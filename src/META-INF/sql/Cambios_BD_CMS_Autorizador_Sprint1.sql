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
  `createDate` TIMESTAMP NULL,
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

