-- Crear tabla keyProperties
-- author: Jesús Gómez
-- Fecha: 08/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`keyProperties` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `channelId` INT NOT NULL,
  `productId` BIGINT UNIQUE NOT NULL,
  `keyLength` INT NULL,
  `expirationDays` INT NULL,
  `totalPreviousKeys` INT NULL,
  `totalNumericCharacters` INT NULL,
  `indConsecutiveEqualCharacters` TINYINT(1) NULL,
  `indContinuousCharacters` TINYINT(1) NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_keyProperties_channel1_idx` (`channelId` ASC),
  INDEX `fk_keyProperties_product1_idx` (`productId` ASC),
  CONSTRAINT `fk_keyProperties_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_keyProperties_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tablas para esquema de Proceso de Cierre Diario
-- author: Jesús Gómez
-- Fecha: 09/02/2021
-- Crear tabla dailyClosing
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`dailyClosing` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `closingDate` DATE NOT NULL,
  `closingStartTime` TIME NULL,
  `closingEndTime` TIME NULL,
  `originApplicationId` INT NOT NULL,
  `totalTransactions` INT NULL,
  `transactionsAmount` FLOAT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_daily_closing_origin_application1_idx` (`originApplicationId` ASC),
  CONSTRAINT `fk_daily_closing_origin_application1`
    FOREIGN KEY (`originApplicationId`)
    REFERENCES `CardManagementSystem`.`originApplication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar FK dailyClosingId y el campo indClosed en las tablas transactionManagement y transactionManagementHistory
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `indClosed` TINYINT(1) NULL AFTER `messageMiddlewareId`,
ADD COLUMN `dailyClosingId` BIGINT NULL AFTER `indClosed`;
SET FOREIGN_KEY_CHECKS = 0;
ALTER TABLE `CardManagementSystem`.`transactionsManagement`
ADD CONSTRAINT `fk_transactionsManagement_dailyClosing1`
FOREIGN KEY (`dailyClosingId`)
REFERENCES `CardManagementSystem`.`dailyClosing` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
ADD COLUMN `indClosed` TINYINT(1) NULL AFTER `messageMiddlewareId`,
ADD COLUMN `dailyClosingId` BIGINT NULL AFTER `indClosed`;
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory`
ADD CONSTRAINT `fk_transactionsManagementHistory_dailyClosing1`
FOREIGN KEY (`dailyClosingId`)
REFERENCES `CardManagementSystem`.`dailyClosing` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

-- Crear tabla de calendar_days
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`calendarDays` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `countryId` INT NOT NULL,
  `holidayDate` DATE NULL,
  `description` VARCHAR(50) NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_calendarDays_country1_idx` (`countryId` ASC),
  CONSTRAINT `fk_calendarDays_country1`
    FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tablas para el Log de transacciones
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`codeErrorTransactionLog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NULL,
  `code` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusTransactionLog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NOT NULL,
  `code` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`transactionLog` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `transactionsManagementHistoryId` BIGINT(20) NOT NULL,
  `statusTransactionLogId` INT NOT NULL,
  `codeErrorTransactionLogId` INT NOT NULL,
  `observations` VARCHAR(1500) NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transactionLog_Transaction1_idx` (`transactionsManagementHistoryId` ASC),
  INDEX `fk_transactionLog_StatusTransactionLog1_idx` (`statusTransactionLogId` ASC),
  INDEX `fk_transactionLog_CodeErrorTransactionLog1_idx` (`codeErrorTransactionLogId` ASC),
  CONSTRAINT `fk_transactionLog_Transaction1`
    FOREIGN KEY (`transactionsManagementHistoryId`)
    REFERENCES `CardManagementSystem`.`transactionsManagementHistory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transactionLog_statusTransactionLog1`
    FOREIGN KEY (`statusTransactionLogId`)
    REFERENCES `CardManagementSystem`.`statusTransactionLog` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transactionLog_codeErrorTransactionLog1`
    FOREIGN KEY (`codeErrorTransactionLogId`)
    REFERENCES `CardManagementSystem`.`codeErrorTransactionLog` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
SET FOREIGN_KEY_CHECKS = 1;

-- Agregar campo transferDestinationCardNumber en las tablas transactionManagement y transactionManagementHistory
-- author: Jesús Gómez
-- Fecha: 09/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `transferDestinationCardNumber` VARCHAR(1000) NULL AFTER `pinLenght`;

ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
ADD COLUMN `transferDestinationCardNumber` VARCHAR(1000) NULL AFTER `pinLenght`;

-- Agregar campo transactionConcept en las tablas transactionManagement y transactionManagementHistory
-- author: Jesús Gómez
-- Fecha: 11/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `transactionConcept` VARCHAR(80) NULL AFTER `transactionSequence`;

ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
ADD COLUMN `transactionConcept` VARCHAR(80) NULL AFTER `transactionSequence`;

-- Agregar tabla totalTransactionsAmountByDailyClosing
-- author: Jesús Gómez
-- Fecha: 12/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`totalTransactionsAmountByDailyClosing` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `dailyClosingId` BIGINT UNIQUE NOT NULL,
  `transactionId` INT NOT NULL,
  `totalTransactions` INT NULL,
  `transactionsAmount` FLOAT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_totalTransactionsAmountByDailyClosing_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_totalTransactionsAmountByDailyClosing_dailyClosing1_idx` (`dailyClosingId` ASC),
  CONSTRAINT `fk_totalTransactionsAmountByDailyClosing_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_totalTransactionsAmountByDailyClosing_dailyClosing1`
    FOREIGN KEY (`dailyClosingId`)
    REFERENCES `CardManagementSystem`.`dailyClosing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Eliminar FK dailyClosingId en tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 12/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
DROP FOREIGN KEY `fk_transactionsManagement_dailyClosing1`;
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
DROP INDEX `fk_transactionsManagement_dailyClosing1`;

-- Eliminar FK dailyClosingId en tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 12/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
DROP FOREIGN KEY `fk_transactionsManagementHistory_dailyClosing1`;
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
DROP INDEX `fk_transactionsManagementHistory_dailyClosing1`;

-- Se eliminaron los campos: dailyClosingId y indClosed en tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 12/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
DROP COLUMN `dailyClosingId`,
DROP COLUMN `indClosed`;

-- Modificar tamaño de campo pinOffset en tabla card
-- author: Jesús Gómez
-- Fecha: 16/02/2021
ALTER TABLE `CardManagementSystem`.`card` 
CHANGE COLUMN `pinOffset` `pinOffset` VARCHAR(1000);

-- Agregar tabla historyCardStatusChanges
-- author: Jesús Gómez
-- Fecha: 16/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`historyCardStatusChanges` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `cardStatusId` INT NOT NULL,
  `userResponsabileId` INT NULL,
  `statusUpdateReasonId` INT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cardStatusChangedHistory_card1_idx` (`cardId` ASC),
  INDEX `fk_historyCardStatusChanges_cardStatus1_idx` (`cardStatusId` ASC),
  INDEX `fk_historyCardStatusChanges_user1_idx` (`userResponsabileId` ASC),
  INDEX `fk_historyCardStatusChanges_statusUpdateReason1_idx` (`statusUpdateReasonId` ASC),
  CONSTRAINT `fk_cardStatusChangedHistory_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historyCardStatusChanges_cardStatus1`
    FOREIGN KEY (`cardStatusId`)
    REFERENCES `CardManagementSystem`.`cardStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historyCardStatusChanges_user1`
    FOREIGN KEY (`userResponsabileId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historyCardStatusChanges_statusUpdateReason1`
    FOREIGN KEY (`statusUpdateReasonId`)
    REFERENCES `CardManagementSystem`.`statusUpdateReason` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla cardKeyHistory
-- author: Jesús Gómez
-- Fecha: 17/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardKeyHistory` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `previousPinOffset` VARCHAR(1000) NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cardKeyHistory_card1_idx` (`cardId` ASC),
  CONSTRAINT `fk_cardKeyHistory_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Eliminar indice en tabla balanceHistoryCard
-- author: Jesús Gómez
-- Fecha: 19/02/2021
ALTER TABLE `CardManagementSystem`.`balanceHistoryCard` 
DROP INDEX `transactionsManagementId`;

-- Colocar Not Null el campo createDate en tabla transaction
-- author: Jesús Gómez
-- Fecha: 19/02/2021
ALTER TABLE `CardManagementSystem`.`transaction` 
CHANGE COLUMN `createDate` `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Eliminar FK en tabla balanceHistoryCard
-- author: Jesús Gómez
-- Fecha: 22/02/2021
ALTER TABLE `CardManagementSystem`.`balanceHistoryCard` 
DROP FOREIGN KEY `fk_balanceHistoryCard_transactionsManagement1`;
ALTER TABLE `CardManagementSystem`.`balanceHistoryCard` 
DROP INDEX `fk_balanceHistoryCard_transactionsManagement1_idx`;

-- Agregar campos relacionados al proceso de cierre en la tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 23/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `indClosed` TINYINT(1) NULL AFTER `messageMiddlewareId`,
ADD COLUMN `dailyClosingId` BIGINT NULL AFTER `indClosed`;

-- Procedimiento Almacenado para pasar de transactionsManagement a transactionManagementHistory en el cierre diario
-- author: Yamelis Almea
-- Fecha: 23/02/2021
USE `CardManagementSystem`;
DROP procedure IF EXISTS `pasarTransactionesAHistoricos`;

DELIMITER $$
USE `CardManagementSystem`$$
CREATE PROCEDURE `pasarTransactionesAHistoricos`(IN begginingDate TIMESTAMP, IN endingDate TIMESTAMP)
BEGIN
INSERT INTO transactionsManagementHistory
         SELECT *
         FROM transactionsManagement t 
         WHERE t.createDate between begginingDate AND endingDate AND t.dailyClosingId IS NULL AND (t.indClosed IS NULL OR t.indClosed = 0);
END$$

DELIMITER ;

-- Modificar campos en la tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 25/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `authorizationCode` VARCHAR(20) NULL AFTER `responseCode`,
CHANGE COLUMN `transactionRateAmount` `transactionCommissionAmount` FLOAT;

-- Modificar campos en la tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 25/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
ADD COLUMN `authorizationCode` VARCHAR(20) NULL AFTER `responseCode`,
CHANGE COLUMN `transactionRateAmount` `transactionCommissionAmount` FLOAT;


-- Agregar el campo personAssociatedUserId en tabla user
-- author: Jesús Gómez
-- Fecha: 25/02/2021
ALTER TABLE `CardManagementSystem`.`user`
ADD COLUMN `personAssociatedUserId` BIGINT NULL AFTER `personId`;
ALTER TABLE `CardManagementSystem`.`user`
ADD CONSTRAINT `fk_user_personAssociatedUser1`
FOREIGN KEY (`personAssociatedUserId`)
REFERENCES `CardManagementSystem`.`person` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

-- Modificar FK fk_user_Employee1 para que acepte NULL en tabla user
-- author: Jesús Gómez
-- Fecha: 25/02/2021
ALTER TABLE `CardManagementSystem`.`user` 
DROP FOREIGN KEY `fk_user_Employee1`;
ALTER TABLE `CardManagementSystem`.`user` 
CHANGE COLUMN `AuthorizedEmployeeId` `AuthorizedEmployeeId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`user` 
ADD CONSTRAINT `fk_user_Employee1`
  FOREIGN KEY (`AuthorizedEmployeeId`)
  REFERENCES `CardManagementSystem`.`employee` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION; 

-- Agregar campo customerIdentificationNumber en la tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 26/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `customerIdentificationNumber` VARCHAR(40) NULL AFTER `expirationCardDate`;

-- Agregar campo customerIdentificationNumber en la tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 26/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
ADD COLUMN `customerIdentificationNumber` VARCHAR(40) NULL AFTER `expirationCardDate`;

-- Agregar campo approvalDateTime en la tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 05/03/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
ADD COLUMN `approvalDateTime` TIMESTAMP NULL AFTER `responseCode`;

-- Agregar campo approvalDateTime en la tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 05/03/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
ADD COLUMN `approvalDateTime` TIMESTAMP NULL AFTER `responseCode`;