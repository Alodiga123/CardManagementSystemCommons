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
  `statusPlasticCustomizingRequestd` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_statusResultPlasticCustomizing_plasticManufacturer1_idx` (`plasticManufacturerId` ASC),
  INDEX `fk_statusResultPlasticCustomizing_statusPlasticCustomizingR_idx` (`statusPlasticCustomizingRequestd` ASC),
  CONSTRAINT `fk_statusResultPlasticCustomizing_plasticManufacturer1`
    FOREIGN KEY (`plasticManufacturerId`)
    REFERENCES `CardManagementSystem`.`plasticManufacturer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_statusResultPlasticCustomizing_statusPlasticCustomizingReq1`
    FOREIGN KEY (`statusPlasticCustomizingRequestd`)
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

-- Agregar campos de fecha en tabla address
-- author: Jesús Gomez
-- Fecha: 21/04/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `addressTypeId`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createDate`;


