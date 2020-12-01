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
DROP TABLE `CardManagementSystem`.`cardDeliveryRegister`;

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

-- Crear tabla statusNewCardIssueRequest
-- author: Jesús Gómez
-- Fecha: 11/06/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusNewCardIssueRequest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(4) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla newCardIssueRequest
-- author: Jesús Gómez
-- Fecha: 11/06/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`newCardIssueRequest` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `requestNumber` VARCHAR(40) NULL,
  `requestDate` DATE NULL,
  `statusNewCardIssueRequestId` INT NOT NULL,
  `observations` VARCHAR(1500) NULL,
  `indConfirmation` TINYINT(1) NULL,
  `newCardIssueDate` DATE NULL,
  `cardId` BIGINT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_newCardIssueRequest_statusNewCardIssueRequest1_idx` (`statusNewCardIssueRequestId` ASC),
  INDEX `fk_newCardIssueRequest_card1_idx` (`cardId` ASC),
  CONSTRAINT `fk_newCardIssueRequest_statusNewCardIssueRequest1`
    FOREIGN KEY (`statusNewCardIssueRequestId`)
    REFERENCES `CardManagementSystem`.`statusNewCardIssueRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_newCardIssueRequest_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Agregar campos en tabla card
-- author: Jesús Gómez
-- Fecha: 11/06/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `indPendingNewCardIssue` TINYINT(1) NULL AFTER `observations`;

-- Agregar campos en tabla product
-- author: Jesús Gómez
-- Fecha: 16/06/2020
ALTER TABLE `CardManagementSystem`.`product` 
ADD COLUMN `maximunDeactivationTimeBlocking` INT NULL AFTER `userActivationId`;

-- Agregar FK en issuer
-- author: Jesús Gómez
-- Fecha: 19/06/2020
ALTER TABLE `CardManagementSystem`.`issuer` 
ADD COLUMN `documentsPersonTypeId` INT NULL AFTER `documentIdentification`;
ALTER TABLE `CardManagementSystem`.`issuer` 
ADD CONSTRAINT `fk_issuer_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FKs en tabla employee
-- author: Jesús Gómez
-- Fecha: 25/07/2020
SET FOREIGN_KEY_CHECKS=0;

ALTER TABLE `CardManagementSystem`.`employee` 
ADD COLUMN `comercialAgencyId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`employee` 
ADD CONSTRAINT `fk_employee_comercialAgency1` 
FOREIGN KEY (`comercialAgencyId`)
    REFERENCES `CardManagementSystem`.`comercialAgency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `CardManagementSystem`.`employee` 
ADD COLUMN `identificationNumber` INT NOT NULL AFTER `id`;

ALTER TABLE `CardManagementSystem`.`employee` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL AFTER `identificationNumber`;
ALTER TABLE `CardManagementSystem`.`employee` 
ADD CONSTRAINT `fk_employee_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

SET FOREIGN_KEY_CHECKS=1;

-- Agregar índice único en tabla user
-- author: Jesús Gómez
-- Fecha: 26/07/2020
ALTER TABLE `CardManagementSystem`.`user` 
ADD UNIQUE INDEX `login_UNIQUE` (`login` ASC);

-- Agregar campo en tabla phonePerson
-- author: Jesús Gómez
-- Fecha: 02/08/2020
ALTER TABLE `CardManagementSystem`.`phonePerson` 
ADD COLUMN `countryCode` VARCHAR(4) NULL AFTER `id`,
ADD COLUMN `areaCode` VARCHAR(10) NULL AFTER `countryCode`,
ADD COLUMN `indMainPhone` TINYINT(1) NULL AFTER `extensionPhoneNumber`;

-- Agregar FK en tabla phonePerson
-- author: Jesús Gómez
-- Fecha: 28/08/2020
ALTER TABLE `CardManagementSystem`.`phonePerson` 
CHANGE COLUMN `countryId` `countryId` INT(11) NULL;

ALTER TABLE `CardManagementSystem`.`phonePerson` 
ADD CONSTRAINT `fk_phonePerson_country1` 
FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- Agregar campo code y sus valores en tabla statusRequest
-- author: Jesús Gómez
-- Fecha: 31/08/2020
ALTER TABLE `CardManagementSystem`.`statusRequest` 
ADD COLUMN `code` VARCHAR(6) NOT NULL AFTER `description`;

UPDATE `CardManagementSystem`.`statusRequest` SET `code`='ENPROC' WHERE `id`='1';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='SOLREC' WHERE `id`='2';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='RECAPR' WHERE `id`='3';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='PENAPR' WHERE `id`='4';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='LINEOK' WHERE `id`='5';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='SOLAPR' WHERE `id`='6';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='RECREC' WHERE `id`='7';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='TAASCL' WHERE `id`='8';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='PROCES' WHERE `id`='9';
UPDATE `CardManagementSystem`.`statusRequest` SET `code`='LISNEG' WHERE `id`='10';

-- Agregar FK en tabla cardRequestNaturalPerson
-- author: Jesús Gómez
-- Fecha: 31/08/2020
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD COLUMN `statusApplicantId` INT NOT NULL AFTER `legalCustomerId`;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD CONSTRAINT `fk_cardRequestNaturalPerson_statusApplicant1` 
FOREIGN KEY (`statusApplicantId`)
    REFERENCES `CardManagementSystem`.`statusApplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS=1;

-- Agregar FK en tabla legalRepresentatives
-- author: Jesús Gómez
-- Fecha: 31/08/2020
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD COLUMN `statusApplicantId` INT NOT NULL AFTER `civilStatusId`;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD CONSTRAINT `fk_legalRepresentatives_statusApplicant1` 
FOREIGN KEY (`statusApplicantId`)
    REFERENCES `CardManagementSystem`.`statusApplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS=1;

-- Agregar campo code y sus valores en tabla personClassification
-- author: Jesús Gómez
-- Fecha: 01/09/2020
ALTER TABLE `CardManagementSystem`.`personClassification` 
ADD COLUMN `code` VARCHAR(6) NOT NULL AFTER `description`;

UPDATE `CardManagementSystem`.`personClassification` SET `code`='ISSUER' WHERE `id`='1';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='CAMAPR' WHERE `id`='2';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='PRGOWN' WHERE `id`='3';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='APLICA' WHERE `id`='4';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='LEGREP' WHERE `id`='5';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='COPEIS' WHERE `id`='6';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='CUSTOM' WHERE `id`='7';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='CACONP' WHERE `id`='8';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='PLAMAN' WHERE `id`='9';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='EMPLOY' WHERE `id`='10';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='SHICOM' WHERE `id`='11';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='COMOFF' WHERE `id`='12';
UPDATE `CardManagementSystem`.`personClassification` SET `code`='BUSAGE' WHERE `id`='13';

-- Agregar campo code y sus valores en tabla statusApplicant
-- author: Jorge Pinto
-- Fecha: 03/09/2020
ALTER TABLE `CardManagementSystem`.`statusApplicant` 
ADD COLUMN `code` VARCHAR(6) NOT NULL AFTER `description`;

UPDATE `CardManagementSystem`.`statusApplicant` SET `code`='ACTIVO' WHERE `id`='1';
UPDATE `CardManagementSystem`.`statusApplicant` SET `code`='INACTI' WHERE `id`='2';
UPDATE `CardManagementSystem`.`statusApplicant` SET `code`='LINEOK' WHERE `id`='3';
UPDATE `CardManagementSystem`.`statusApplicant` SET `code`='LISNEG' WHERE `id`='4';
UPDATE `CardManagementSystem`.`statusApplicant` SET `code`='CLIENT' WHERE `id`='5';

ALTER TABLE `CardManagementSystem`.`card` 
CHANGE COLUMN `createDate` `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `userResponsibleStatusUpdateId`,
CHANGE COLUMN `updateDate` `updateDate` TIMESTAMP NULL DEFAULT NULL AFTER `createDate`;

-- Agregar campo en tabla card
-- author: Jesús Gómez
-- Fecha: 03/09/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `indReceivedCard` TINYINT(1) NULL AFTER `userResponsibleStatusUpdateId`;


-- Agregar campo code y sus valores en tabla edificationType
-- author: Jorge Pinto
-- Fecha: 09/09/2020
ALTER TABLE `CardManagementSystem`.`edificationType` 
ADD COLUMN `code` VARCHAR(6) NOT NULL AFTER `description`;

UPDATE `CardManagementSystem`.`edificationType` SET `code`='CASA' WHERE `id`='1';
UPDATE `CardManagementSystem`.`edificationType` SET `code`='QUINTA' WHERE `id`='2';
UPDATE `CardManagementSystem`.`edificationType` SET `code`='EDIFIC' WHERE `id`='3';
UPDATE `CardManagementSystem`.`edificationType` SET `code`='RESCOM' WHERE `id`='4';
UPDATE `CardManagementSystem`.`edificationType` SET `code`='CENCOM' WHERE `id`='5';
UPDATE `CardManagementSystem`.`edificationType` SET `code`='CHALET' WHERE `id`='6';
UPDATE `CardManagementSystem`.`edificationType` SET `code`='DUPLEX' WHERE `id`='7';

-- Agregar FK en tabla collection_type
-- author: Jorge Pinto
-- Fecha: 14/09/2020
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `CardManagementSystem`.`collectionType`
ADD COLUMN `personTypeId` INT(11) NOT NULL;
ALTER TABLE `CardManagementSystem`.`collectionType`
ADD CONSTRAINT `fk_collectionType_personType1`
 FOREIGN KEY (`personTypeId`)
 REFERENCES `CardManagementSystem`.`personType` (`id`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION;
 SET FOREIGN_KEY_CHECKS=1;

-- Agregar campo order en tabla collectionType
-- author: Jesús Gómez
-- Fecha: 30/10/2020
ALTER TABLE `CardManagementSystem`.`collectionType` 
ADD COLUMN `orden` INT NULL AFTER `personTypeId`;

-- Agregar campos en tabla card
-- author: Jesús Gómez
-- Fecha: 03/10/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `alias` VARCHAR(40) NULL AFTER `cardNumber`,
ADD COLUMN `assignedAccount` VARCHAR(40) NULL AFTER `alias`;

-- Agregar campos en tabla address
-- author: Jesús Gómez
-- Fecha: 03/10/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `zipZoneCode` VARCHAR(40) NULL AFTER `zipZoneId`;

-- Agregar campos en tabla state
-- author: Jesús Gómez
-- Fecha: 03/10/2020
ALTER TABLE `CardManagementSystem`.`state` 
ADD COLUMN `code` VARCHAR(4) NULL AFTER `countryId`;

-- Agregar campos en tabla applicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 04/10/2020
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD COLUMN `taxInformationRegistry` VARCHAR(40) NULL AFTER `identificationNumberOld`;


-- Modificar FK de profesionId para que acepte null en tabla naturalCustomer
-- author: Jesús Gómez
-- Fecha: 16/11/2020
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
DROP FOREIGN KEY `fk_naturalCustomer_profession1`;
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
CHANGE COLUMN `professionId` `professionId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
ADD CONSTRAINT `fk_naturalCustomer_profession1`
  FOREIGN KEY (`professionId`)
  REFERENCES `CardManagementSystem`.`profession` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Modificar tipo de dato en la tabla reviewOFAC en el campo resultReview
-- author: Jorge Pinto
-- Fecha: 16/11/2020
ALTER TABLE `CardManagementSystem`.`reviewOFAC` 
CHANGE COLUMN `resultReview` `resultReview` FLOAT NULL DEFAULT NULL ;

-- Agregar campos en tabla ratebycard
-- author: Yamelis Almea
-- Fecha: 20/11/2020
ALTER TABLE `CardManagementSystem`.`rateByCard` 
ADD COLUMN `indCardHolderModification` TINYINT(1) NULL DEFAULT NULL AFTER `totalTransactionsExemptPerMonth`;

-- Agregar campos en tabla applicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 01/12/2020
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD COLUMN `observations` VARCHAR(1500) NULL AFTER `statusApplicantId`;

-- Agregar campos en tabla cardRequestNaturalPerson
-- author: Jesús Gómez
-- Fecha: 01/12/2020
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD COLUMN `observations` VARCHAR(1500) NULL AFTER `statusApplicantId`;