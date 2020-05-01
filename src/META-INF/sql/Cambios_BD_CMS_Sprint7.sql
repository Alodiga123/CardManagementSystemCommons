-- Crear tabla statusProduct
-- author: Jesús Gómez
-- Fecha: 02/04/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusProduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FK en product
-- author: Jesús Gómez
-- Fecha: 02/04/2020
ALTER TABLE `CardManagementSystem`.`product` 
ADD COLUMN `statusProductId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`product` 
ADD CONSTRAINT `fk_product_statusProduct1` 
FOREIGN KEY (`statusProductId`)
    REFERENCES `CardManagementSystem`.`statusProduct` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Crear tabla plastiCustomizingRequestHasCard
-- author: Jesús Gómez
-- Fecha: 07/04/2020   
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`plastiCustomizingRequestHasCard` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `plasticCustomizingRequestId` BIGINT UNIQUE NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_plastiCustomizingRequestHasCard_card1_idx` (`cardId` ASC),
  INDEX `fk_plastiCustomizingRequestHasCard_plasticCustomizingReques_idx` (`plasticCustomizingRequestId` ASC),
  CONSTRAINT `fk_plastiCustomizingRequestHasCard_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plastiCustomizingRequestHasCard_plasticCustomizingRequest1`
    FOREIGN KEY (`plasticCustomizingRequestId`)
    REFERENCES `CardManagementSystem`.`plasticCustomizingRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla statusDeliveryRequest
-- author: Jesús Gómez
-- Fecha: 07/04/2020 
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusDeliveryRequest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla deliveryRequest
-- author: Jesús Gómez
-- Fecha: 07/04/2020 
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`deliveryRequest` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `requestNumber` VARCHAR(40) NOT NULL,
  `requestDate` DATE NULL,
  `ShippingCompanyId` BIGINT NOT NULL,
  `programId` BIGINT NOT NULL,
  `shippingGuideNumber` VARCHAR(40) NULL,
  `amountCards` INT NOT NULL,
  `statusDeliveryRequestId` INT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_deliveryRequest_legalPerson1_idx` (`ShippingCompanyId` ASC),
  INDEX `fk_deliveryRequest_program1_idx` (`programId` ASC),
  INDEX `fk_deliveryRequest_statusDeliveryRequest1_idx` (`statusDeliveryRequestId` ASC),
  CONSTRAINT `fk_deliveryRequest_legalPerson1`
    FOREIGN KEY (`ShippingCompanyId`)
    REFERENCES `CardManagementSystem`.`legalPerson` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deliveryRequest_program1`
    FOREIGN KEY (`programId`)
    REFERENCES `CardManagementSystem`.`program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deliveryRequest_statusDeliveryRequest1`
    FOREIGN KEY (`statusDeliveryRequestId`)
    REFERENCES `CardManagementSystem`.`statusDeliveryRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Crear tabla deliveryRequetsHasCard
-- author: Jesús Gómez
-- Fecha: 07/04/2020 
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`deliveryRequetsHasCard` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `deliveryRequestId` BIGINT UNIQUE NOT NULL,
  `cardId` BIGINT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_deliveryRequetsHasCard_deliveryRequest1_idx` (`deliveryRequestId` ASC),
  INDEX `fk_deliveryRequetsHasCard_card1_idx` (`cardId` ASC),
  CONSTRAINT `fk_deliveryRequetsHasCard_deliveryRequest1`
    FOREIGN KEY (`deliveryRequestId`)
    REFERENCES `CardManagementSystem`.`deliveryRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deliveryRequetsHasCard_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Eliminar campos en diferentes tablas
-- author: Jesús Gómez
-- Fecha: 09/04/2020
ALTER TABLE `CardManagementSystem`.`address` 
DROP COLUMN `fullAddress`;

ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
DROP COLUMN `password`,
DROP COLUMN `titleId`;

-- Eliminar tabla title
-- author: Jesús Gómez
-- Fecha: 09/04/2020
DROP TABLE `CardManagementSystem`.`title`;

-- Crear tabla statusResultPlasticCustomizing
-- author: Jesús Gómez
-- Fecha: 14/04/2020 
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusResultPlasticCustomizing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(60) NOT NULL,
  `plasticManufacturerId` INT NOT NULL,
  `statusPlasticCustomizingRequestId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_statusResultPlasticCustomizing_plasticManufacturer1_idx` (`plasticManufacturerId` ASC),
  INDEX `fk_statusResultPlasticCustomizing_statusPlasticCustomizingR_idx` (`statusPlasticCustomizingRequestd` ASC),
  CONSTRAINT `fk_statusResultPlasticCustomizing_plasticManufacturer1`
    FOREIGN KEY (`plasticManufacturerId`)
    REFERENCES `CardManagementSystem`.`plasticManufacturer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_statusResultPlasticCustomizing_statusPlasticCustomizingReq1`
    FOREIGN KEY (`statusPlasticCustomizingRequestId`)
    REFERENCES `CardManagementSystem`.`statusPlasticCustomizingRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla resultPlasticCustomizingRequest
-- author: Jesús Gómez
-- Fecha: 14/04/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`resultPlasticCustomizingRequest` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cardNumber` VARCHAR(40) NOT NULL,
  `cardHolder` VARCHAR(50) NOT NULL,
  `identificationNumberCardHolder` VARCHAR(40) NOT NULL,
  `productTypeDescription` VARCHAR(40) NULL,
  `expirationCardDate` DATE NOT NULL,
  `statusResultPlasticCustomizingId` INT NOT NULL,
  `plasticCustomizingRequestId` BIGINT UNIQUE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_resultPlasticCustomizingRequest_statusResultPlasticCusto_idx` (`statusResultPlasticCustomizingId` ASC),
  INDEX `fk_resultPlasticCustomizingRequest_plasticCustomizingReques_idx` (`plasticCustomizingRequestId` ASC),
  CONSTRAINT `fk_resultPlasticCustomizingRequest_statusResultPlasticCustomi1`
    FOREIGN KEY (`statusResultPlasticCustomizingId`)
    REFERENCES `CardManagementSystem`.`statusResultPlasticCustomizing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resultPlasticCustomizingRequest_plasticCustomizingRequest1`
    FOREIGN KEY (`plasticCustomizingRequestId`)
    REFERENCES `CardManagementSystem`.`plasticCustomizingRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Y agregar el campo number (numero de casa u edificio)
-- author: YamelYis Almea
-- Fecha: 14/04/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `number` VARCHAR(10) NULL AFTER `addressTypeId`;

-- Agregar el campo en tabla resultPlasticCustomizingRequest
-- author: Jesús Gomez
-- Fecha: 17/04/2020
ALTER TABLE `CardManagementSystem`.`resultPlasticCustomizingRequest` 
ADD COLUMN `statusResult` VARCHAR(60) NULL AFTER `expirationCardDate`;

-- Eliminar FKs tabla statusResultPlasticCustomizing
-- author: Jesús Gómez
-- Fecha: 21/04/2020
ALTER TABLE `CardManagementSystem`.`statusResultPlasticCustomizing`
DROP FOREIGN KEY `fk_statusResultPlasticCustomizing_statusPlasticCustomizingReq1`;
ALTER TABLE `CardManagementSystem`.`statusResultPlasticCustomizing` 
DROP COLUMN `statusPlasticCustomizingRequestd`;

-- Agregar campos de fecha en tabla address
-- author: Jesús Gomez
-- Fecha: 21/04/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `addressTypeId`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createDate`;

-- Agregar FK en tabla statusResultPlasticCustomizing
-- author: Jesús Gómez
-- Fecha: 21/04/2020
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `CardManagementSystem`.`statusResultPlasticCustomizing` 
ADD COLUMN `cardStatusId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`statusResultPlasticCustomizing` 
ADD CONSTRAINT `fk_statusResultPlasticCustomizing_cardStatus1` 
FOREIGN KEY (`cardStatusId`)
    REFERENCES `CardManagementSystem`.`cardStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS=1;

-- Agregar campo en tabla card
-- author: Jesús Gomez
-- Fecha: 21/04/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `indDeliveryRequest` TINYINT(1) NULL AFTER `personCustomerId`;

-- Crear tabla approvalCardRate
-- author: Jesús Gómez
-- Fecha: 22/04/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`approvalCardRate` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `approvalDate` DATE NOT NULL,
  `indApproved` TINYINT(1) NOT NULL,
  `userId` INT NOT NULL,
  `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_approvalCardRate_card1_idx` (`cardId` ASC),
  INDEX `fk_approvalCardRate_user1_idx` (`userId` ASC),
  CONSTRAINT `fk_approvalCardRate_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_approvalCardRate_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Agregar FK en tabla generalRate
-- author: Jesús Gómez
-- Fecha: 22/04/2020
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `CardManagementSystem`.`generalRate` 
ADD COLUMN `approvalGeneralRateId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`generalRate` 
ADD CONSTRAINT `fk_generalRate_approvalGeneralRate1` 
FOREIGN KEY (`approvalGeneralRateId`)
    REFERENCES `CardManagementSystem`.`approvalGeneralRate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla rateByProgram
-- author: Jesús Gómez
-- Fecha: 22/04/2020
ALTER TABLE `CardManagementSystem`.`rateByProgram` 
ADD COLUMN `approvalProgramRateId` BIGINT NULL;
ALTER TABLE `CardManagementSystem`.`rateByProgram` 
ADD INDEX `fk_rateByProgram_approvalProgramRate1_idx` (`approvalProgramRateId` ASC);
ALTER TABLE `CardManagementSystem`.`rateByProgram` 
ADD CONSTRAINT `fk_rateByProgram_approvalProgramRate1`
  FOREIGN KEY (`approvalProgramRateId`)
  REFERENCES `CardManagementSystem`.`approvalProgramRate` (`Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Agregar FK en tabla rateByProduct
-- author: Jesús Gómez
-- Fecha: 22/04/2020
ALTER TABLE `CardManagementSystem`.`rateByProduct` 
ADD COLUMN `approvalProductRateId` BIGINT NULL;
ALTER TABLE `CardManagementSystem`.`rateByProduct` 
ADD INDEX `fk_rateByProduct_approvalProductRate1_idx` (`approvalProductRateId` ASC);
ALTER TABLE `CardManagementSystem`.`rateByProduct` 
ADD CONSTRAINT `fk_rateByProduct_approvalProductRate1` 
FOREIGN KEY (`approvalProductRateId`)
    REFERENCES `CardManagementSystem`.`approvalProductRate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla rateByCard
-- author: Jesús Gómez
-- Fecha: 22/04/2020
ALTER TABLE `CardManagementSystem`.`rateByCard` 
ADD COLUMN `approvalCardRateId` BIGINT NULL;
ALTER TABLE `CardManagementSystem`.`rateByCard` 
ADD INDEX `fk_rateByCard_approvalCardRate1_idx` (`approvalCardRateId` ASC);
ALTER TABLE `CardManagementSystem`.`rateByCard` 
ADD CONSTRAINT `fk_rateByCard_approvalCardRate1` 
FOREIGN KEY (`approvalCardRateId`)
    REFERENCES `CardManagementSystem`.`approvalCardRate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

SET FOREIGN_KEY_CHECKS=1;

-- Modificar FK en tabla product
-- author: Jesús Gómez
-- Fecha: 24/04/2020
ALTER TABLE `CardManagementSystem`.`product` 
DROP FOREIGN KEY `fk_product_currency1`,
DROP FOREIGN KEY `fk_product_currency2`;
ALTER TABLE `CardManagementSystem`.`product` 
CHANGE COLUMN `domesticCurrencyId` `domesticCurrencyId` INT(11) NULL ,
CHANGE COLUMN `internationalCurrencyId` `internationalCurrencyId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`product` 
ADD CONSTRAINT `fk_product_currency1`
  FOREIGN KEY (`domesticCurrencyId`)
  REFERENCES `CardManagementSystem`.`currency` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_product_currency2`
  FOREIGN KEY (`internationalCurrencyId`)
  REFERENCES `CardManagementSystem`.`currency` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Agregar FK en product
-- author: Jesús Gómez
-- Fecha: 24/04/2020
ALTER TABLE `CardManagementSystem`.`product` 
ADD COLUMN `userActivationId` INT NULL;
ALTER TABLE `CardManagementSystem`.`product` 
ADD CONSTRAINT `fk_product_user1` 
FOREIGN KEY (`userActivationId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar campos en tabla product
-- author: Jesús Gomez
-- Fecha: 24/04/2020
ALTER TABLE `CardManagementSystem`.`product` 
ADD COLUMN `activationDate` DATE NULL AFTER `statusProductId`,
ADD COLUMN `indActivation` TINYINT(1) NULL AFTER `activationDate`,
ADD COLUMN `observations` VARCHAR(1000)  NULL AFTER `indActivation`;

-- Agregar campos en tabla rateByProgram
-- author: Jesús Gomez
-- Fecha: 27/04/2020
ALTER TABLE `CardManagementSystem`.`rateByProgram` 
ADD COLUMN `fixedRateGR` FLOAT NULL AFTER `approvalProgramRateId`,
ADD COLUMN `percentageRateGR` FLOAT NULL AFTER `fixedRateGR`,
ADD COLUMN `totalInitialTransactionsExemptGR` INT(11) NULL AFTER `percentageRateGR`,
ADD COLUMN `totalTransactionsExemptPerMonthGR` INT(11) NULL AFTER `totalInitialTransactionsExemptGR`,
ADD COLUMN `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `totalTransactionsExemptPerMonthGR`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createDate`;

-- Agregar campos en tabla rateByProduct
-- author: Jesús Gomez
-- Fecha: 27/04/2020
ALTER TABLE `CardManagementSystem`.`rateByProduct` 
ADD COLUMN `fixedRatePR` FLOAT NULL AFTER `approvalProductRateId`,
ADD COLUMN `percentageRatePR` FLOAT NULL AFTER `fixedRatePR`,
ADD COLUMN `totalInitialTransactionsExemptPR` INT(11) NULL AFTER `percentageRatePR`,
ADD COLUMN `totalTransactionsExemptPerMonthPR` INT(11) NULL AFTER `totalInitialTransactionsExemptPR`,
ADD COLUMN `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `totalTransactionsExemptPerMonthPR`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createDate`;

-- Agregar campos en tabla programLoyalty
-- author: Jesús Gomez
-- Fecha: 28/04/2020
ALTER TABLE `CardManagementSystem`.`programLoyalty` 
ADD COLUMN `activationDate` DATE NULL AFTER `observations`,
ADD COLUMN `indActivation` TINYINT(1) NULL AFTER `activationDate`,
ADD COLUMN `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `indActivation`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createDate`;

-- Agregar FK en programLoyalty
-- author: Jesús Gómez
-- Fecha: 28/04/2020
ALTER TABLE `CardManagementSystem`.`programLoyalty` 
ADD COLUMN `userActivationId` INT NULL;
ALTER TABLE `CardManagementSystem`.`programLoyalty` 
ADD CONSTRAINT `fk_programLoyalty_user1` 
FOREIGN KEY (`userActivationId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar campos en tabla address
-- author: Jesús Gomez
-- Fecha: 30/04/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `addressLine1` VARCHAR(250) NULL AFTER `number`,
ADD COLUMN `addressLine2` VARCHAR(250) NULL AFTER `addressLine1`;

ALTER TABLE `CardManagementSystem`.`address` 
CHANGE COLUMN `createDate` `createDate` TIMESTAMP NULL DEFAULT NULL AFTER `addressLine2`
CHANGE COLUMN `updateDate` `updateDate` TIMESTAMP NULL DEFAULT NULL AFTER `createDate`;

-- Agregar FK en tabla civilStatus
-- author: Jesús Gómez
-- Fecha: 30/04/2020
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `CardManagementSystem`.`civilStatus` 
ADD COLUMN `countryId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`civilStatus` 
ADD INDEX `fk_civilStatus1_idx` (`countryId` ASC);
ALTER TABLE `CardManagementSystem`.`civilStatus` 
ADD CONSTRAINT `fk_civilStatus_country1` 
FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

SET FOREIGN_KEY_CHECKS=1;



