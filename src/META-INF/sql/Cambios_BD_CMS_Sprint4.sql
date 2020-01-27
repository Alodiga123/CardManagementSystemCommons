RENAME TABLE `CardManagementSystem`.`allowedChannels` TO `CardManagementSystem`.`productHasChannel`;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`reasonRejectionRequest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(50) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `CardManagementSystem`.`reasonRejectionRequest`
(`code`,`description`)
VALUES 
("RECAUDOS","La solicitud no contempla los recaudos requeridos"),
("LISTAS NEGRAS","Algún relacionados a la solicitud está en Listas Negras"),
("CREDITICIA","La evaluación crediticia no fue satisfactoria"),
("RIESGOS","La evaluación de riesgos no fue satisfactoria");

ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `reasonRejectionRequestId` INT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_reasonRejectionRequest1` 
FOREIGN KEY (`reasonRejectionRequestId`)
    REFERENCES `CardManagementSystem`.`reasonRejectionRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`comercialAgency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `cityId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comercialAgency_city1_idx` (`cityId` ASC),
  CONSTRAINT `fk_comercialAgency_city1`
    FOREIGN KEY (`cityId`)
    REFERENCES `CardManagementSystem`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla employedPosition
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`employedPosition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstNames` VARCHAR(40) NULL,
  `lastNames` VARCHAR(45) NULL,
  `personId` BIGINT UNIQUE NOT NULL,
  `employedPositionId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Employee_employedPosition1_idx` (`employedPositionId` ASC),
  INDEX `fk_Employee_person1_idx` (`personId` ASC),
  CONSTRAINT `fk_Employee_employedPosition1`
    FOREIGN KEY (`employedPositionId`)
    REFERENCES `CardManagementSystem`.`employedPosition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Employee_person1`
    FOREIGN KEY (`personId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Eliminar tabla user
-- author: Jesús Gómez
-- Fecha: 10/01/2020
DROP TABLE `CardManagementSystem`.`user`;

-- Agregar tabla user
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `code` VARCHAR(40) NOT NULL,
  `firstNames` VARCHAR(40) NULL,
  `lastNames` VARCHAR(40) NULL,
  `personId` BIGINT UNIQUE NOT NULL,
  `AuthorizedEmployeeId` INT NOT NULL,
  `EmployeeId` INT NULL,
  `comercialAgencyId` INT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_person1_idx` (`personId` ASC),
  INDEX `fk_user_Employee1_idx` (`AuthorizedEmployeeId` ASC),
  INDEX `fk_user_Employee2_idx` (`EmployeeId` ASC),
  INDEX `fk_user_comercialAgency1_idx` (`comercialAgencyId` ASC),
  CONSTRAINT `fk_user_person1`
    FOREIGN KEY (`personId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_Employee1`
    FOREIGN KEY (`AuthorizedEmployeeId`)
    REFERENCES `CardManagementSystem`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_Employee2`
    FOREIGN KEY (`EmployeeId`)
    REFERENCES `CardManagementSystem`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_comercialAgency1`
    FOREIGN KEY (`comercialAgencyId`)
    REFERENCES `CardManagementSystem`.`comercialAgency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla reviewCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`reviewCollectionsRequest` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `requestId` BIGINT NOT NULL,
  `reviewDate` TIMESTAMP NULL,
  `maximumRechargeAmount` FLOAT NULL,
  `userId` INT NOT NULL,
  `productId` BIGINT UNIQUE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reviewCollectionsRequest_request1_idx` (`requestId` ASC),
  INDEX `fk_reviewCollectionsRequest_user1_idx` (`userId` ASC),
  INDEX `fk_reviewCollectionsRequest_product1_idx` (`productId` ASC),
  CONSTRAINT `fk_reviewCollectionsRequest_request1`
    FOREIGN KEY (`requestId`)
    REFERENCES `CardManagementSystem`.`request` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviewCollectionsRequest_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviewCollectionsRequest_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar campos en tabla product
-- author: Jesús Gómez
-- Fecha: 10/01/2020
ALTER TABLE `CardManagementSystem`.`product` 
ADD COLUMN `minimumBalance` FLOAT NULL,
ADD COLUMN `maximumBalance` FLOAT NULL;

-- Agregar tabla transaction
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(10) NOT NULL,
  `description` VARCHAR(60) NULL,
  `indMonetaryType` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FK en tabla productHasChannel
-- author: Jesús Gómez
-- Fecha: 10/01/2020
ALTER TABLE `CardManagementSystem`.`productHasChannel` 
ADD COLUMN `transactionId` INT NULL;
ALTER TABLE `CardManagementSystem`.`productHasChannel` 
ADD CONSTRAINT `fk_productHasChannel_transaction1` 
FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar tabla parameterProductHasChannel
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`parameterProductHasChannel` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `productHasChannelId` BIGINT NOT NULL,
  `maximumNumberTransactionsDaily` INT NULL,
  `maximumNumberTransactionsMonthly` INT NULL,
  `amountMinimumTransactionDomestic` FLOAT NULL,
  `amountMaximumTransactionDomestic` FLOAT NULL,
  `amountMinimumTransactionInternational` FLOAT NULL,
  `amountMaximumTransactionInternational` FLOAT NULL,
  `dailyAmountLimitDomestic` FLOAT NULL,
  `monthlyAmountLimitDomestic` FLOAT NULL,
  `dailyAmountLimitInternational` FLOAT NULL,
  `monthlyAmountLimitInternational` FLOAT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parameterProductHasChannel_productHasChannel1_idx` (`productHasChannelId` ASC),
  CONSTRAINT `fk_parameterProductHasChannel_productHasChannel1`
    FOREIGN KEY (`productHasChannelId`)
    REFERENCES `CardManagementSystem`.`productHasChannel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar campos en tabla reviewCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 13/01/2020
ALTER TABLE `CardManagementSystem`.`reviewCollectionsRequest` 
ADD COLUMN `observations` VARCHAR(1500) NULL;

-- Cambiar tipo de índice productId en la tabla productHasCommerceCategory
-- author: Jesús Gómez
-- Fecha: 13/01/2020
ALTER TABLE `CardManagementSystem`.`productHasCommerceCategory` 
DROP INDEX `productId` ,
ADD INDEX `productId` (`productId` ASC);

-- Agregar campos en tabla user
-- author: Jesús Gómez
-- Fecha: 14/01/2020
ALTER TABLE `CardManagementSystem`.`user` 
ADD COLUMN `identificationNumber` VARCHAR(40) NULL;

-- Eliminar tabla parameterProductHasChannel
-- author: Jesús Gómez
-- Fecha: 15/01/2020
DROP TABLE `CardManagementSystem`.`parameterProductHasChannel`;

-- Eliminar tabla productHasChannel
-- author: Jesús Gómez
-- Fecha: 15/01/2020
DROP TABLE `CardManagementSystem`.`productHasChannel`;

-- Agregar tabla productHasChannelHasTransaction
-- author: Jesús Gómez
-- Fecha: 15/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`productHasChannelHasTransaction` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `maximumNumberTransactionsDaily` INT NULL,
  `maximumNumberTransactionsMonthly` INT NULL,
  `amountMinimumTransactionDomestic` FLOAT NULL,
  `amountMaximumTransactionDomestic` FLOAT NULL,
  `amountMinimumTransactionInternational` FLOAT NULL,
  `amountMaximumTransactionInternational` FLOAT NULL,
  `dailyAmountLimitDomestic` FLOAT NULL,
  `monthlyAmountLimitDomestic` FLOAT NULL,
  `dailyAmountLimitInternational` FLOAT NULL,
  `monthlyAmountLimitInternational` FLOAT NULL,
  `productUseId` INT NOT NULL,
  `transactionId` INT NOT NULL,
  `channelId` INT NOT NULL,
  `productId` BIGINT UNIQUE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parameterProductHasChannel_productUse1_idx` (`productUseId` ASC),
  INDEX `fk_parameterProductHasChannel_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_parameterProductHasChannel_channel1_idx` (`channelId` ASC),
  INDEX `fk_parameterProductHasChannel_product1_idx` (`productId` ASC),
  CONSTRAINT `fk_parameterProductHasChannel_productUse1`
    FOREIGN KEY (`productUseId`)
    REFERENCES `CardManagementSystem`.`productUse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parameterProductHasChannel_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parameterProductHasChannel_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parameterProductHasChannel_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla rateApplicationType
-- author: Jesús Gómez
-- Fecha: 16/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`rateApplicationType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla generalRate
-- author: Jesús Gómez
-- Fecha: 16/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`generalRate` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `countryId` INT NOT NULL,
  `transactionId` INT NOT NULL,
  `productTypeId` INT NOT NULL,
  `channelId` INT NOT NULL,
  `fixedRate` FLOAT NULL,
  `percentageRate` FLOAT NULL,
  `totalInitialTransactionsExempt` INT NULL,
  `totalTransactionsExemptPerMonth` INT NULL,
  `rateApplicationTypeId` INT NOT NULL,
  `indCardHolderModification` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_generalRate_country1_idx` (`countryId` ASC),
  INDEX `fk_generalRate_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_generalRate_productType1_idx` (`productTypeId` ASC),
  INDEX `fk_generalRate_channel1_idx` (`channelId` ASC),
  INDEX `fk_generalRate_rateApplicationType1_idx` (`rateApplicationTypeId` ASC),
  CONSTRAINT `fk_generalRate_country1`
    FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_generalRate_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_generalRate_productType1`
    FOREIGN KEY (`productTypeId`)
    REFERENCES `CardManagementSystem`.`productType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_generalRate_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_generalRate_rateApplicationType1`
    FOREIGN KEY (`rateApplicationTypeId`)
    REFERENCES `CardManagementSystem`.`rateApplicationType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar índice en tabla generalRate
-- author: Jesús Gómez
-- Fecha: 17/01/2020
ALTER TABLE `CardManagementSystem`.`generalRate` 
ADD UNIQUE INDEX `fk_generalRate_idx` (`countryId` ASC, `productTypeId` ASC, `channelId` ASC, `transactionId` ASC);

-- Eliminar FKs tabla issuer
-- author: Jesús Gómez
-- Fecha: 17/01/2020
ALTER TABLE `CardManagementSystem`.`issuer`
DROP FOREIGN KEY `fk_issuer_person2`;
ALTER TABLE `CardManagementSystem`.`issuer` 
DROP INDEX  `contactPersonId`;
ALTER TABLE `CardManagementSystem`.`issuer` 
DROP INDEX  `fk_issuer_person2_idx`;
ALTER TABLE `CardManagementSystem`.`issuer` 
DROP COLUMN `contactPersonId`;

-- Agregar campos en tabla issuer
-- author: Jesús Gómez
-- Fecha: 17/01/2020
ALTER TABLE `CardManagementSystem`.`issuer` 
ADD COLUMN `personContactName` VARCHAR(60) NULL,
ADD COLUMN `emailPersonContact` VARCHAR(80) NULL;

-- Agregar tabla daysWeek
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`daysWeek` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `day` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla programLoyaltyType
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`programLoyaltyType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla statusProgramLoyalty
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusProgramLoyalty` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla programLoyalty
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`programLoyalty` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `programId` BIGINT NOT NULL,
  `productId` BIGINT UNIQUE NOT NULL,
  `description` VARCHAR(1500) NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `programLoyaltyTypeId` INT NOT NULL,
  `conversionRatePoints` FLOAT NULL,
  `statusProgramLoyaltyId` INT NOT NULL,
  `observations` VARCHAR(1500) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_programLoyalty_program1_idx` (`programId` ASC),
  INDEX `fk_programLoyalty_product1_idx` (`productId` ASC),
  INDEX `fk_programLoyalty_programLoyaltyType1_idx` (`programLoyaltyTypeId` ASC),
  INDEX `fk_programLoyalty_statusProgramLoyalty1_idx` (`statusProgramLoyaltyId` ASC),
  CONSTRAINT `fk_programLoyalty_program1`
    FOREIGN KEY (`programId`)
    REFERENCES `CardManagementSystem`.`program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_programLoyalty_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_programLoyalty_programLoyaltyType1`
    FOREIGN KEY (`programLoyaltyTypeId`)
    REFERENCES `CardManagementSystem`.`programLoyaltyType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_programLoyalty_statusProgramLoyalty1`
    FOREIGN KEY (`statusProgramLoyaltyId`)
    REFERENCES `CardManagementSystem`.`statusProgramLoyalty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla daysWeekHasProgramLoyalty
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`daysWeekHasProgramLoyalty` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `programLoyaltyId` BIGINT NOT NULL,
  `daysWeekId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_daysWeekHasProgramLoyalty_programLoyalty1_idx` (`programLoyaltyId` ASC),
  INDEX `fk_daysWeekHasProgramLoyalty_daysWeek1_idx` (`daysWeekId` ASC),
  CONSTRAINT `fk_daysWeekHasProgramLoyalty_programLoyalty1`
    FOREIGN KEY (`programLoyaltyId`)
    REFERENCES `CardManagementSystem`.`programLoyalty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_daysWeekHasProgramLoyalty_daysWeek1`
    FOREIGN KEY (`daysWeekId`)
    REFERENCES `CardManagementSystem`.`daysWeek` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla programLoyaltyTransaction
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`programLoyaltyTransaction` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `channelId` INT NOT NULL,
  `programLoyaltyId` BIGINT NOT NULL,
  `transactionId` INT NOT NULL,
  `totalPointsValue` FLOAT NULL,
  `totalBonificationPercentageValue` FLOAT NULL,
  `totalBonificationFixedValue` FLOAT NULL,
  `totalMaximumTransactionsPoints` FLOAT NULL,
  `totalMaximumTransactionsBonification` FLOAT NULL,
  `totalAmountDailyPoints` FLOAT NULL,
  `totalAmountMonthlyPoints` FLOAT NULL,
  `totalAmountDailyBonification` FLOAT NULL,
  `totalAmountMonthlyBonification` FLOAT NULL,
  `ActivationCardBonification` FLOAT NULL,
  `ActivationCardPoints` FLOAT NULL,
  `renovationCardBonification` FLOAT NULL,
  `renovationCardPoints` VARCHAR(45) NULL,
  `indBonificationFixed` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_table1_channel1_idx` (`channelId` ASC),
  INDEX `fk_programLoyaltyHasTransactionHasChannel_programLoyalty1_idx` (`programLoyaltyId` ASC),
  INDEX `fk_programLoyaltyHasTransactionHasChannel_transaction1_idx` (`transactionId` ASC),
  CONSTRAINT `fk_table1_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_programLoyaltyHasTransactionHasChannel_programLoyalty1`
    FOREIGN KEY (`programLoyaltyId`)
    REFERENCES `CardManagementSystem`.`programLoyalty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_programLoyaltyHasTransactionHasChannel_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla loyaltyTransactionHasCommerceCategory
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`loyaltyTransactionHasCommerceCategory` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `commerceCategoryId` INT NOT NULL,
  `programLoyaltyTransactionId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_loyaltyTransactionHasCommerceCategory_commerceCategory1_idx` (`commerceCategoryId` ASC),
  INDEX `fk_loyaltyTransactionHasCommerceCategory_programLoyaltyTran_idx` (`programLoyaltyTransactionId` ASC),
  CONSTRAINT `fk_loyaltyTransactionHasCommerceCategory_commerceCategory1`
    FOREIGN KEY (`commerceCategoryId`)
    REFERENCES `CardManagementSystem`.`commerceCategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loyaltyTransactionHasCommerceCategory_programLoyaltyTransa1`
    FOREIGN KEY (`programLoyaltyTransactionId`)
    REFERENCES `CardManagementSystem`.`programLoyaltyTransaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla ratesByProgram
-- author: Jesús Gómez
-- Fecha: 20/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`rateByProgram` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `programId` BIGINT NOT NULL,
  `transactionId` INT NOT NULL,
  `channelId` INT NOT NULL,
  `rateApplicationTypeId` INT NOT NULL,
  `fixedRate` FLOAT NULL,
  `percentageRate` FLOAT NULL,
  `totalInitialTransactionsExempt` INT NULL,
  `totalTransactionsExemptPerMonth` INT NULL,
  `indCardHolderModification` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ratesByProgram_program1_idx` (`programId` ASC),
  INDEX `fk_ratesByProgram_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_ratesByProgram_channel1_idx` (`channelId` ASC),
  INDEX `fk_ratesByProgram_rateApplicationType1_idx` (`rateApplicationTypeId` ASC),
  CONSTRAINT `fk_ratesByProgram_program1`
    FOREIGN KEY (`programId`)
    REFERENCES `CardManagementSystem`.`program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ratesByProgram_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ratesByProgram_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ratesByProgram_rateApplicationType1`
    FOREIGN KEY (`rateApplicationTypeId`)
    REFERENCES `CardManagementSystem`.`rateApplicationType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar índice en ratesByProgram
-- author: Jesús Gómez
-- Fecha: 22/01/2020
ALTER TABLE `CardManagementSystem`.`rateByProgram` 
ADD UNIQUE INDEX `fk_rateByProgram_unique` (`transactionId` ASC, `channelId` ASC, `programId` ASC);

-- Agregar tabla rateByProduct
-- author: Jesús Gómez
-- Fecha: 24/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`rateByProduct` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `productId` BIGINT UNIQUE NOT NULL,
  `channelId` INT NOT NULL,
  `transactionId` INT NOT NULL,
  `rateApplicationTypeId` INT NOT NULL,
  `fixedRate` FLOAT NULL,
  `percentageRate` FLOAT NULL,
  `totalInitialTransactionsExempt` INT NULL,
  `totalTransactionsExemptPerMonth` INT NULL,
  `indCardHolderModification` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rateByProduct_product1_idx` (`productId` ASC),
  INDEX `fk_rateByProduct_channel1_idx` (`channelId` ASC),
  INDEX `fk_rateByProduct_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_rateByProduct_rateApplicationType1_idx` (`rateApplicationTypeId` ASC),
  CONSTRAINT `fk_rateByProduct_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rateByProduct_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rateByProduct_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rateByProduct_rateApplicationType1`
    FOREIGN KEY (`rateApplicationTypeId`)
    REFERENCES `CardManagementSystem`.`rateApplicationType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




