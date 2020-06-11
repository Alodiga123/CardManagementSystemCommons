-- Crear tabla cardDeliveryRegister
-- author: Jesús Gómez
-- Fecha: 20/05/2020  

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardDeliveryRegister` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `numberDeliveryAttempts` INT NOT NULL,
  `deliveryDate` DATE NULL,
  `receiverFirstName` VARCHAR(40) NULL,
  `receiverLastName` VARCHAR(40) NULL,
  `deliveryObservations` VARCHAR(1500) NULL,
  `indDelivery` TINYINT(1) NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  `deliveryRequetsHasCardId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_deliveryRegister_deliveryRequetsHasCard1_idx` (`deliveryRequetsHasCardId` ASC),
  CONSTRAINT `fk_deliveryRegister_deliveryRequetsHasCard1`
    FOREIGN KEY (`deliveryRequetsHasCardId`)
    REFERENCES `CardManagementSystem`.`deliveryRequetsHasCard` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Crear tabla user_has_profile
-- author: Jesús Gómez
-- Fecha: 20/05/2020  
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`user_has_profile` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `profileId` BIGINT(3) NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_userHasProfile_user1_idx` (`userId` ASC),
  INDEX `fk_userHasProfile_profile1_idx` (`profileId` ASC),
  CONSTRAINT `fk_userHasProfile_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userHasProfile_profile1`
    FOREIGN KEY (`profileId`)
    REFERENCES `CardManagementSystem`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Agregar campos en tabla card
-- author: Jesús Gómez
-- Fecha: 23/05/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `automaticRenewalDate` DATE NULL,
ADD COLUMN `indRenewal` TINYINT(1) NULL;

-- Crear tabla statusCardRenewalRequest
-- author: Jesús Gómez
-- Fecha: 23/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusCardRenewalRequest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla cardRenewalRequest
-- author: Jesús Gómez
-- Fecha: 23/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardRenewalRequest` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `requestNumber` VARCHAR(40) NULL,
  `requestDate` DATE NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  `statusCardRenewalRequestId` INT NOT NULL,
  `observations` VARCHAR(1500) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cardRenewalRequest_statusCardRenewalRequest1_idx` (`statusCardRenewalRequestId` ASC),
  CONSTRAINT `fk_cardRenewalRequest_statusCardRenewalRequest1`
    FOREIGN KEY (`statusCardRenewalRequestId`)
    REFERENCES `CardManagementSystem`.`statusCardRenewalRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Crear tabla cardRenewalRequestHasCard
-- author: Jesús Gómez
-- Fecha: 23/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardRenewalRequestHasCard` (
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `cardRenewalRequestId` BIGINT UNIQUE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cardRenewalRequestHasCard_card1_idx` (`cardId` ASC),
  INDEX `fk_cardRenewalRequestHasCard_cardRenewalRequest1_idx` (`cardRenewalRequestId` ASC),
  CONSTRAINT `fk_cardRenewalRequestHasCard_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardRenewalRequestHasCard_cardRenewalRequest1`
    FOREIGN KEY (`cardRenewalRequestId`)
    REFERENCES `CardManagementSystem`.`cardRenewalRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Agregar campos en tabla accountCard
-- author: Jesús Gómez
-- Fecha: 23/05/2020
ALTER TABLE `CardManagementSystem`.`accountCard` 
ADD COLUMN `reasonCancellation` VARCHAR(1000) NULL,
ADD COLUMN `cancellationDate` DATE NULL;

-- Agregar FK en accountCard
-- author: Jesús Gómez
-- Fecha: 23/05/2020
ALTER TABLE `CardManagementSystem`.`accountCard` 
ADD COLUMN `userCancellationAccountId` INT NULL;
ALTER TABLE `CardManagementSystem`.`accountCard` 
ADD CONSTRAINT `fk_accountCard_user1` 
FOREIGN KEY (`userCancellationAccountId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Crear tabla securityQuestion
-- author: Jesús Gómez
-- Fecha: 25/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`securityQuestion` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `securityQuestion` VARCHAR(250) NULL,
  `languageId` BIGINT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_questionSecurity_language1_idx` (`languageId` ASC),
  CONSTRAINT `fk_questionSecurity_language1`
    FOREIGN KEY (`languageId`)
    REFERENCES `CardManagementSystem`.`language` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Crear tabla systemFuncionality
-- author: Jesús Gómez
-- Fecha: 25/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`systemFuncionality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `originApplicationId` INT NOT NULL,
  `languageId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_systemFuncionality_originApplication1_idx` (`originApplicationId` ASC),
  INDEX `fk_systemFuncionality_language1_idx` (`languageId` ASC),
  CONSTRAINT `fk_systemFuncionality_originApplication1`
    FOREIGN KEY (`originApplicationId`)
    REFERENCES `CardManagementSystem`.`originApplication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_systemFuncionality_language1`
    FOREIGN KEY (`languageId`)
    REFERENCES `CardManagementSystem`.`language` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla systemFuncionalityHasQuestionSecurity
-- author: Jesús Gómez
-- Fecha: 25/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`systemFuncionalityHasSecurityQuestion` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `systemFuncionalityId` INT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  `securityQuestionId` BIGINT UNIQUE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_questionSecurityHasPermission_systemFuncionality1_idx` (`systemFuncionalityId` ASC),
  INDEX `fk_systemFuncionalityHasSecurityQuestion_securityQuestion1_idx` (`securityQuestionId` ASC),
  CONSTRAINT `fk_questionSecurityHasPermission_systemFuncionality1`
    FOREIGN KEY (`systemFuncionalityId`)
    REFERENCES `CardManagementSystem`.`systemFuncionality` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_systemFuncionalityHasSecurityQuestion_securityQuestion1`
    FOREIGN KEY (`securityQuestionId`)
    REFERENCES `CardManagementSystem`.`securityQuestion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Cambios en los indices relacionados con tablas de solicitud de personalización de plasticos
-- author: Jesús Gómez
-- Fecha: 26/05/2020
ALTER TABLE `CardManagementSystem`.`plastiCustomizingRequestHasCard` 
DROP INDEX `plasticCustomizingRequestId` ,
ADD INDEX `plasticCustomizingRequestId` (`plasticCustomizingRequestId` ASC);

ALTER TABLE `CardManagementSystem`.`resultPlasticCustomizingRequest` 
DROP INDEX `plasticCustomizingRequestId` ,
ADD INDEX `plasticCustomizingRequestId` (`plasticCustomizingRequestId` ASC);

-- Agregar campos en tabla statusResultPlasticCustomizing
-- author: Jesús Gómez
-- Fecha: 28/05/2020
ALTER TABLE `CardManagementSystem`.`statusResultPlasticCustomizing` 
ADD COLUMN `statusPlasticCustomizing` VARCHAR(20) NOT NULL AFTER `plasticManufacturerId`;

-- Modificar ndice en tabla deliveryRequetsHasCard
-- author: Jesús Gómez
-- Fecha: 28/05/2020
ALTER TABLE `CardManagementSystem`.`deliveryRequetsHasCard` 
DROP INDEX `deliveryRequestId` ,
ADD INDEX `deliveryRequestId` (`deliveryRequestId` ASC);

-- Agregar campos en tabla documentType
-- author: Jesús Gómez
-- Fecha: 29/05/2020
ALTER TABLE `CardManagementSystem`.`documentType` 
ADD COLUMN `acronym` VARCHAR(10) NOT NULL AFTER `name`;

-- Crear tabla statusUpdateReason
-- author: Jesús Gómez
-- Fecha: 30/05/2020
-- A partir de aquí no se actualizó en el servidor de AWS
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusUpdateReason` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla cardStatusHasUpdateReason
-- author: Jesús Gómez
-- Fecha: 30/05/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardStatusHasUpdateReason` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `statusUpdateReasonId` INT NOT NULL,
  `cardStatusId` INT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_timestamps_statusUpdateReason1_idx` (`statusUpdateReasonId` ASC),
  INDEX `fk_timestamps_cardStatus1_idx` (`cardStatusId` ASC),
  CONSTRAINT `fk_timestamps_statusUpdateReason1`
    FOREIGN KEY (`statusUpdateReasonId`)
    REFERENCES `CardManagementSystem`.`statusUpdateReason` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_timestamps_cardStatus1`
    FOREIGN KEY (`cardStatusId`)
    REFERENCES `CardManagementSystem`.`cardStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Agregar campos en tabla card
-- author: Jesús Gómez
-- Fecha: 30/05/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `observations` VARCHAR(1500) NULL AFTER `indRenewal`,
ADD COLUMN `statusUpdateReasonDate` DATE NULL AFTER `observations`;

-- Agregar FK en card
-- author: Jesús Gómez
-- Fecha: 30/05/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `userResponsibleStatusUpdateId` INT NULL;
ALTER TABLE `CardManagementSystem`.`card` 
ADD CONSTRAINT `fk_card_user1` 
FOREIGN KEY (`userResponsibleStatusUpdateId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en cardRenewalRequest
-- author: Jesús Gómez
-- Fecha: 03/06/2020
ALTER TABLE `CardManagementSystem`.`cardRenewalRequest` 
ADD COLUMN `IssuerId` INT NULL;
ALTER TABLE `CardManagementSystem`.`cardRenewalRequest` 
ADD CONSTRAINT `fk_cardRenewalRequest_issuer1` 
FOREIGN KEY (`IssuerId`)
    REFERENCES `CardManagementSystem`.`issuer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en card
-- author: Jesús Gómez
-- Fecha: 05/06/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `statusUpdateReasonId` INT NULL AFTER `observations`;
ALTER TABLE `CardManagementSystem`.`card` 
ADD CONSTRAINT `fk_card_statusUpdateReason1` 
FOREIGN KEY (`statusUpdateReasonId`)
    REFERENCES `CardManagementSystem`.`statusUpdateReason` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Crear tabla passwordChangeRequest
-- author: Jesús Gómez
-- Fecha: 07/06/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`passwordChangeRequest` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `requestNumber` VARCHAR(40) NULL,
  `requestDate` TIMESTAMP NULL,
  `indApproved` TINYINT(1) NULL,
  `userid` INT NOT NULL,
  `currentPassword` VARCHAR(20) NULL,
  `newPassword` VARCHAR(20) NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_passwordChangeRequest_user1_idx` (`userid` ASC),
  CONSTRAINT `fk_passwordChangeRequest_user1`
    FOREIGN KEY (`userid`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Agregar campos en tabla deliveryRequetsHasCard
-- author: Jesús Gómez
-- Fecha: 09/06/2020
ALTER TABLE `CardManagementSystem`.`deliveryRequetsHasCard` 
ADD COLUMN `numberDeliveryAttempts` INT NULL AFTER `cardId`,
ADD COLUMN `deliveryDate` DATE NULL AFTER `numberDeliveryAttempts`,
ADD COLUMN `receiverFirstName` VARCHAR(40) NULL AFTER `deliveryDate`,
ADD COLUMN `receiverLastName` VARCHAR(40) NULL AFTER `receiverFirstName`,
ADD COLUMN `deliveryObservations` VARCHAR(1500) NULL AFTER `receiverLastName`,
ADD COLUMN `indDelivery` TINYINT(1) NULL AFTER `deliveryObservations`;


-- Eliminar tabla CardDeliveryRegister
-- author: Jesús Gómez
-- Fecha: 09/06/2020
DROP TABLE `CardManagementSystem`.`CardDeliveryRegister`;

-- Agregar campos en tabla cardStatusHasUpdateReason
-- author: Jesús Gómez
-- Fecha: 10/06/2020
ALTER TABLE `CardManagementSystem`.`cardStatusHasUpdateReason` 
ADD COLUMN `indAllowTable` TINYINT(1)  NOT NULL AFTER `cardStatusId`;

-- Cambiar nombre de campo en tabla passwordChangeRequest
-- author: Jesús Gómez
-- Fecha: 10/06/2020
ALTER TABLE `CardManagementSystem`.`passwordChangeRequest` 
DROP FOREIGN KEY `fk_passwordChangeRequest_user1`;
ALTER TABLE `CardManagementSystem`.`passwordChangeRequest` 
CHANGE COLUMN `userid` `userId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`passwordChangeRequest` 
ADD CONSTRAINT `fk_passwordChangeRequest_user1`
  FOREIGN KEY (`userId`)
  REFERENCES `CardManagementSystem`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
