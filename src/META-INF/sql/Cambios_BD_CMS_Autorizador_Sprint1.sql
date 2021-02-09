-- Agregar campos en tabla accountCard
-- author: Jesús Gómez
-- Fecha: 25/01/2021
ALTER TABLE `CardManagementSystem`.`accountCard` 
ADD COLUMN `currentBalance` FLOAT NULL AFTER `transactionId`;

-- Crear tabla transactionsManagement
-- Formato Interno estándar para registrar las transacciones que vienen por AlodigaMiddleWare
-- author: Jesús Gómez
-- Fecha: 25/01/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`transactionsManagement` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `acquirerTerminalCode` VARCHAR(50) NULL,
  `transactionNumberAcquirer` VARCHAR(50) NULL,
  `transactionNumberIssuer` VARCHAR(50) NULL,
  `transactionTypeId` INT NULL,
  `channelId` INT NULL,
  `dateTransaction` DATE NULL,
  `dateTimeTransmissionTerminal` TIMESTAMP NULL,
  `localTimeTransaction` TIMESTAMP NULL,
  `localDateTransaction` DATE NULL,
  `localCurrencyTransactionId` INT NULL,
  `localCurrencyTransactionAmount` FLOAT NULL,
  `settlementCurrencyTransactionId` INT NULL,
  `settlementTransactionAmount` FLOAT NULL,
  `rateConvertionSettlement` FLOAT NULL,
  `acquirerCommisionAmount` FLOAT NULL,
  `acquirerSettlementCommissionAmount` FLOAT NULL,
  `transactionCityId` INT NULL,
  `statusTransactionManagementId` INT NULL,
  `cardNumber` VARCHAR(1000) NULL,
  `cardHolder` VARCHAR(50) NULL,
  `CVV` VARCHAR(1000) NULL,
  `expirationCardDate` DATE NULL,
  `pinLenght` INT NULL,
  `acquirerId` BIGINT NULL,
  `issuerId` INT NULL,
  `mccCodeTrade` VARCHAR(10) NULL,
  `systemTraceAuditNumber` VARCHAR(50) NULL,
  `numberMovementsCheckBalance` INT NULL,
  `responseCode` VARCHAR(50) NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla statusTransactionManagement
-- Listado de estatus asociados a las transacciones
-- author: Jesús Gómez
-- Fecha: 25/01/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusTransactionManagement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(60) NOT NULL,
  `code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla commisionTransaction
-- Configurar las comisiones por tipo de transacción y tarjeta
-- author: Jesús Gómez
-- Fecha: 25/01/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`commisionTransaction` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `productId` BIGINT UNIQUE NOT NULL,
  `transactionId` INT NOT NULL,
  `begginingDate` DATE NULL,
  `endingDate` DATE NULL,
  `indPercentComission` TINYINT(1) NULL,
  `value` FLOAT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_commisionTransaction_product1_idx` (`productId` ASC),
  INDEX `fk_commisionTransaction_transaction1_idx` (`transactionId` ASC),
  CONSTRAINT `fk_commisionTransaction_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commisionTransaction_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla commisionsReceived
-- Registrar los cálculos de las comisiones generadas por las transacciones que realizan los usuarios del sistema
-- author: Jesús Gómez
-- Fecha: 25/01/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`commisionsReceived` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `commisionTransactionId` BIGINT UNIQUE NOT NULL,
  `transactionsManagementId` BIGINT UNIQUE NOT NULL,
  `amountCommision` FLOAT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_commisionsReceived_commisionTransaction1_idx` (`commisionTransactionId` ASC),
  INDEX `fk_commisionsReceived_transactionsManagement1_idx` (`transactionsManagementId` ASC),
  CONSTRAINT `fk_commisionsReceived_commisionTransaction1`
    FOREIGN KEY (`commisionTransactionId`)
    REFERENCES `CardManagementSystem`.`commisionTransaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commisionsReceived_transactionsManagement1`
    FOREIGN KEY (`transactionsManagementId`)
    REFERENCES `CardManagementSystem`.`transactionsManagement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla balanceHistoryCard
-- Registrar el histórico de los saldos de las tarjetas asociadas a los clientes
-- author: Jesús Gómez
-- Fecha: 25/01/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`balanceHistoryCard` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `cardUserId` BIGINT NOT NULL,
  `transactionsManagementId` BIGINT UNIQUE NOT NULL,
  `previousBalance` FLOAT NOT NULL,
  `currentBalance` FLOAT NOT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_balanceHistoryCard_card1_idx` (`cardUserId` ASC),
  INDEX `fk_balanceHistoryCard_transactionsManagement1_idx` (`transactionsManagementId` ASC),
  CONSTRAINT `fk_balanceHistoryCard_card1`
    FOREIGN KEY (`cardUserId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_balanceHistoryCard_transactionsManagement1`
    FOREIGN KEY (`transactionsManagementId`)
    REFERENCES `CardManagementSystem`.`transactionsManagement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`transactionsManagementHistory` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `acquirerTerminalCode` VARCHAR(50) NULL,
  `transactionNumberAcquirer` VARCHAR(50) NULL,
  `transactionNumberIssuer` VARCHAR(50) NULL,
  `transactionTypeId` INT NULL,
  `channelId` INT NULL,
  `dateTransaction` DATE NULL,
  `dateTimeTransmissionTerminal` TIMESTAMP NULL,
  `localTimeTransaction` TIMESTAMP NULL,
  `localDateTransaction` DATE NULL,
  `localCurrencyTransactionId` INT NULL,
  `localCurrencyTransactionAmount` FLOAT NULL,
  `settlementCurrencyTransactionId` INT NULL,
  `settlementTransactionAmount` FLOAT NULL,
  `rateConvertionSettlement` FLOAT NULL,
  `acquirerCommisionAmount` FLOAT NULL,
  `acquirerSettlementCommissionAmount` FLOAT NULL,
  `transactionCityId` INT NULL,
  `statusTransactionManagementId` INT NULL,
  `cardNumber` VARCHAR(1000) NULL,
  `cardHolder` VARCHAR(50) NULL,
  `CVV` VARCHAR(1000) NULL,
  `expirationCardDate` DATE NULL,
  `pinLenght` INT NULL,
  `acquirerId` BIGINT NULL,
  `issuerId` INT NULL,
  `mccCodeTrade` VARCHAR(10) NULL,
  `systemTraceAuditNumber` VARCHAR(50) NULL,
  `numberMovementsCheckBalance` INT NULL,
  `responseCode` VARCHAR(50) NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar campos en tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 25/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory`
ADD COLUMN `transactionSequence` VARCHAR(40) NULL AFTER `transactionTypeId`,
ADD COLUMN `transactionRateAmount` FLOAT NULL AFTER `transactionCityId`;

-- Agregar campos en tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 25/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement`
ADD COLUMN `transactionSequence` VARCHAR(40) NULL AFTER `transactionTypeId`,
ADD COLUMN `transactionRateAmount` FLOAT NULL AFTER `transactionCityId`;

-- Agregar campos en tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 28/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement`
ADD COLUMN `acquirerCountryId` INT NULL  `acquirerTerminalCode`;

-- Agregar campos en tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 28/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory`
ADD COLUMN `acquirerCountryId` INT NULL AFTER `acquirerTerminalCode`;


-- Modificar campos en tablas transactionsManagement y transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 28/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement` 
CHANGE COLUMN `expirationCardDate` `expirationCardDate` VARCHAR(10) NOT NULL;

ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory` 
CHANGE COLUMN `expirationCardDate` `expirationCardDate` VARCHAR(10) NOT NULL;

-- Agregar campo en tabla card
-- author: Jesús Gómez
-- Fecha: 29/01/2021
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `maximumRechargeAmount` FLOAT NOT NULL AFTER `sequentialNumber`;

-- Agregar campos en tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 29/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement`
ADD COLUMN `transactionReference` VARCHAR(50) NULL AFTER `dateTransaction`;

-- Agregar campos en tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 29/01/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory`
ADD COLUMN `transactionReference` VARCHAR(50) NULL AFTER `dateTransaction`;

-- Crear tabla bonusCard
-- author: Jesús Gómez
-- Fecha: 01/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`bonusCard` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `programLoyaltyTransactionId` BIGINT NOT NULL,
  `totalPointsAccumulatedDaily` INT NULL,
  `totalPointsAccumulatedMonthly` INT NULL,
  `totalAmountBonuses` FLOAT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bonusCard_card1_idx` (`cardId` ASC),
  INDEX `fk_bonusCard_programLoyaltyTransaction1_idx` (`programLoyaltyTransactionId` ASC),
  CONSTRAINT `fk_bonusCard_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bonusCard_programLoyaltyTransaction1`
    FOREIGN KEY (`programLoyaltyTransactionId`)
    REFERENCES `CardManagementSystem`.`programLoyaltyTransaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla subTypeTransaction
-- author: Jesús Gómez
-- Fecha: 02/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`subTypeTransaction` (
  `id` INT NOT NULL,
  `description` VARCHAR(50) NULL,
  `code` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FK subTypeTransactionId en tabla transaction
-- author: Jesús Gómez
-- Fecha: 02/02/2021
ALTER TABLE `CardManagementSystem`.`transaction` 
ADD COLUMN `subTypeTransactionId` INT NOT NULL AFTER `indVariationRateChannel`,
ADD COLUMN `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP AFTER `subTypeTransactionId`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER createDate;
SET FOREIGN_KEY_CHECKS = 0;
ALTER TABLE `CardManagementSystem`.`transaction`
ADD CONSTRAINT `fk_reviewOfac_subTypeTransaction1`
FOREIGN KEY (`subTypeTransactionId`)
REFERENCES `CardManagementSystem`.`subTypeTransaction` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS = 1;


-- Agregar la opción de AUTOINCREMENT en el campo id de subTypeTransaction
-- author: Jesús Gómez
-- Fecha: 02/02/2021
SET FOREIGN_KEY_CHECKS = 0;
ALTER TABLE `CardManagementSystem`.`subTypeTransaction` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;
SET FOREIGN_KEY_CHECKS = 1;

-- Agregar campos en tabla transactionsManagement
-- author: Jesús Gómez
-- Fecha: 03/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagement`
ADD COLUMN `messageMiddlewareId` BIGINT NULL AFTER `responseCode`,
ADD COLUMN `tradeName` VARCHAR(250) NULL AFTER `mccCodeTrade`,
ADD COLUMN `transactionDateIssuer` TIMESTAMP NULL AFTER `transactionNumberIssuer`;

-- Agregar campos en tabla transactionsManagementHistory
-- author: Jesús Gómez
-- Fecha: 03/02/2021
ALTER TABLE `CardManagementSystem`.`transactionsManagementHistory`
ADD COLUMN `messageMiddlewareId` BIGINT NULL AFTER `responseCode`,
ADD COLUMN `tradeName` VARCHAR(250) NULL AFTER `mccCodeTrade`,
ADD COLUMN `transactionDateIssuer` TIMESTAMP NULL AFTER `transactionNumberIssuer`;

-- Agregar code en tabla programLoyalTytype
-- author: Yamelis Almea
-- Fecha: 09/02/2021
ALTER TABLE `CardManagementSystem`.`programLoyaltyType` 
ADD COLUMN `code` VARCHAR(5) NULL AFTER `name`;

UPDATE `CardManagementSystem`.`programLoyaltyType` SET `code` = 'point' WHERE (`id` = '1');
UPDATE `CardManagementSystem`.`programLoyaltyType` SET `code` = 'bonus' WHERE (`id` = '2');

-- Agregar Nuevo tipo de transaccion para registrar las bonificaciones
-- author: Yamelis Almea
-- Fecha: 09/02/2021
INSERT INTO `CardManagementSystem`.`transaction` (`id`, `code`, `description`, `indMonetaryType`, `indTransactionPurchase`, `indVariationRateChannel`, `subTypeTransactionId`, `createDate`) VALUES ('26', '051', 'BONIFICACIONS_CMS', '1', '0', '1', '3', '2021-02-04 10:26:07');

-- Agregar Nuevo documentType para utilizar en el numero de secuencia
-- author: Yamelis Almea
-- Fecha: 09/02/2021
INSERT INTO `CardManagementSystem`.`documentType` (`id`, `name`, `acronym`) VALUES ('8', 'BONUS TRANSACTION CMS', 'BTCMS');

-- Agregar Secuencia para transaciones de bonificacion
-- author: Yamelis Almea
-- Fecha: 09/02/2021
INSERT INTO `CardManagementSystem`.`sequences` (`id`, `initialValue`, `currentValue`, `documentType_id`, `originApplicationId`) VALUES ('9', '1', '1', '8', '1');

-- Agregar Modificar tabla de bonusCard para guardar puntos 
-- author: Yamelis Almea
-- Fecha: 09/02/2021
ALTER TABLE `CardManagementSystem`.`bonusCard` 
DROP FOREIGN KEY `fk_bonusCard_programLoyaltyTransaction1`;
ALTER TABLE `cardmanagementsystem`.`bonuscard` 
DROP COLUMN `totalAmountBonuses`,
DROP COLUMN `totalPointsAccumulatedMonthly`,
DROP COLUMN `programLoyaltyTransactionId`,
CHANGE COLUMN `totalPointsAccumulatedDaily` `totalPointsAccumulated` INT(11) NULL DEFAULT NULL ,
DROP INDEX `fk_bonusCard_programLoyaltyTransaction1_idx` ;

-- Crear tabla transactionPoint
-- author: Yamelis Almea
-- Fecha: 09/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`transactionPoint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cardId` bigint(20) NOT NULL,
  `programLoyaltyTransactionId` bigint(20) NOT NULL,
  `points` int(11) DEFAULT NULL,
  `transactionReference` varchar(50) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_transactionPoint_card1_idx` (`cardId`),
  KEY `fk_transactionPoint_programLoyaltyTransaction1_idx` (`programLoyaltyTransactionId`),
  CONSTRAINT `fk_transactionPoint_card1` FOREIGN KEY (`cardId`) REFERENCES `card` (`id`),
  CONSTRAINT `fk_transactionPoint_programLoyaltyTransaction1` FOREIGN KEY (`programLoyaltyTransactionId`) REFERENCES `programloyaltytransaction` (`id`)
) ENGINE=InnoDB;

