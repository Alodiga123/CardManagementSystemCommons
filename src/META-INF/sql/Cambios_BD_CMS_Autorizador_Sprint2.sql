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