-- Agregar FK en user
-- author: Jesús Gómez
-- Fecha: 10/03/2020
ALTER TABLE `CardManagementSystem`.`user` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`user` 
ADD CONSTRAINT `fk_user_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar campos en card
-- author: Jesús Gómez
-- Fecha: 10/03/2020
ALTER TABLE `CardManagementSystem`.`card` 
ADD COLUMN `cardHolder` VARCHAR(50) NULL AFTER `productId`,
ADD COLUMN `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `personCustomerId`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createdDate`;

-- Eliminar indice en reviewOFAC
-- author: Jesús Gómez
-- Fecha: 18/03/2020
ALTER TABLE `CardManagementSystem`.`reviewOFAC` 
DROP INDEX `personId` ;

-- Crear tabla statusAccount
-- author: Jesús Gómez
-- Fecha: 18/03/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusAccount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Crear tabla account
-- author: Jesús Gómez
-- Fecha: 18/03/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accountCard` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `accountPropertiesId` BIGINT NOT NULL,
  `statusAccountId` INT NOT NULL,
  `cardId` BIGINT NOT NULL,
  `transactionId` INT NOT NULL,
  `channelId` INT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_account_accountProperties1_idx` (`accountPropertiesId` ASC),
  INDEX `fk_account_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_account_channel1_idx` (`channelId` ASC),
  INDEX `fk_account_statusAccount1_idx` (`statusAccountId` ASC),
  INDEX `fk_account_card1_idx` (`cardId` ASC),
  CONSTRAINT `fk_account_accountProperties1`
    FOREIGN KEY (`accountPropertiesId`)
    REFERENCES `CardManagementSystem`.`accountProperties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_statusAccount1`
    FOREIGN KEY (`statusAccountId`)
    REFERENCES `CardManagementSystem`.`statusAccount` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Modificar tabla accountCard
-- author: Jesús Gómez
-- Fecha: 18/03/2020
ALTER TABLE `CardManagementSystem`.`accountCard` 
ADD COLUMN `accountNumber` VARCHAR(40) NOT NULL AFTER `accountPropertiesId`;

-- Actualizar fecha de creación en card
-- author: Jesús Gómez
-- Fecha: 18/03/2020  
ALTER TABLE `CardManagementSystem`.`card` 
CHANGE COLUMN `createdDate` `createDate` TIMESTAMP NOT NULL CURRENT_TIMESTAMP;

-- agregar campo en phonePerson
-- author: Jesús Gómez
-- Fecha: 18/03/2020  
ALTER TABLE `CardManagementSystem`.`phonePerson` 
ADD COLUMN `extensionPhoneNumber` VARCHAR(10) NULL AFTER `phoneTypeId`;

-- Cambios realizados por Yamelis para opcion de solicitud de tarjeta pagina web
-- ninguno de esos cambios nos afectan por ahora pero deben estar en BD porque están en Java
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `CardManagementSystem`.`title` (`id`, `description`) VALUES ('1', 'Sr');
INSERT INTO `CardManagementSystem`.`title` (`id`, `description`) VALUES ('2', 'Sra');
INSERT INTO `CardManagementSystem`.`title` (`id`, `description`) VALUES ('3', 'Srta');

ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD COLUMN `titleId` INT(11) NULL DEFAULT NULL AFTER `statusApplicantId`,
ADD COLUMN `recommendation` TINYINT(1) NULL AFTER `titleId`,
ADD COLUMN `promotion` TINYINT(1) NULL AFTER `recommendation`,
ADD COLUMN `citizen` TINYINT(1) NULL AFTER `promotion`;

ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD INDEX `fk_applicantNaturalPerson_title1` (`titleId` ASC);

ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD CONSTRAINT `fk_applicantNaturalPerson_title1`
  FOREIGN KEY (`titleId`)
  REFERENCES `CardManagementSystem`.`title` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `fullAddress` VARCHAR(150) NULL DEFAULT NULL AFTER `addressTypeId`;

ALTER TABLE  `CardManagementSystem`.`applicantNaturalPerson`
CHANGE COLUMN `identificationNumber` `identificationNumber` VARCHAR(40) NULL,
CHANGE COLUMN `gender` `gender` VARCHAR(1) NULL,
CHANGE COLUMN `placeBirth` `placeBirth` VARCHAR(45) NULL;

ALTER TABLE `CardManagementSystem`.`address`  
DROP FOREIGN KEY `fk_address_addressType1`,
DROP FOREIGN KEY `fk_address_edificationType1`,
DROP FOREIGN KEY `fk_address_streetType1`,
DROP FOREIGN KEY `fk_address_zipZone1`;
ALTER TABLE `CardManagementSystem`.`address`  
CHANGE COLUMN `edificationTypeId` `edificationTypeId` INT(11) NULL ,
CHANGE COLUMN `streetTypeId` `streetTypeId` INT(11) NULL ,
CHANGE COLUMN `zipZoneId` `zipZoneId` INT(11) NULL ,
CHANGE COLUMN `addressTypeId` `addressTypeId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`address`  
ADD CONSTRAINT `fk_address_addressType1`
  FOREIGN KEY (`addressTypeId`)
  REFERENCES `CardManagementSystem`.`addressType` (`id`),
ADD CONSTRAINT `fk_address_edificationType1`
  FOREIGN KEY (`edificationTypeId`)
  REFERENCES `CardManagementSystem`.`edificationType` (`id`),
ADD CONSTRAINT `fk_address_streetType1`
  FOREIGN KEY (`streetTypeId`)
  REFERENCES `CardManagementSystem`.`streetType` (`id`),
ADD CONSTRAINT `fk_address_zipZone1`
  FOREIGN KEY (`zipZoneId`)
  REFERENCES `CardManagementSystem`.`zipZone` (`id`);

ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD COLUMN `password` VARCHAR(45) NULL DEFAULT NULL AFTER `citizen`;

-- Crear tabla rateCard
-- author: Jesús Gómez
-- Fecha: 19/03/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`rateCard` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cardId` BIGINT NOT NULL,
  `channelId` INT NOT NULL,
  `transactionId` INT NOT NULL,
  `rateApplicationType_id` INT NOT NULL,
  `fixedRate` FLOAT NULL,
  `percentageRate` FLOAT NULL,
  `totalInitialTransactionsExempt` INT NULL,
  `totalTransactionsExemptPerMonth` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rateCardHolder_card1_idx` (`cardId` ASC),
  INDEX `fk_rateCard_channel1_idx` (`channelId` ASC),
  INDEX `fk_rateCard_transaction1_idx` (`transactionId` ASC),
  INDEX `fk_rateCard_rateApplicationType1_idx` (`rateApplicationType_id` ASC),
  CONSTRAINT `fk_rateCardHolder_card1`
    FOREIGN KEY (`cardId`)
    REFERENCES `CardManagementSystem`.`card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rateCard_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rateCard_transaction1`
    FOREIGN KEY (`transactionId`)
    REFERENCES `CardManagementSystem`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rateCard_rateApplicationType1`
    FOREIGN KEY (`rateApplicationType_id`)
    REFERENCES `CardManagementSystem`.`rateApplicationType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Crear tabla cardNumberCredential
-- author: Jesús Gómez
-- Fecha: 20/03/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardNumberCredential` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cardNumber` VARCHAR(40) NULL,
  `securityCodeCard` VARCHAR(10) NULL,
  `indUse` TINYINT(1) NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Cambiar nombre de tabla rateCard
-- author: Jesús Gómez
-- Fecha: 21/03/2020
RENAME TABLE `CardManagementSystem`.`rateCard` TO `CardManagementSystem`.`rateByCard`; 

ALTER TABLE `CardManagementSystem`.`rateByCard` 
DROP FOREIGN KEY `fk_rateCard_rateApplicationType1`;
ALTER TABLE `CardManagementSystem`.`rateByCard` 
CHANGE COLUMN `rateApplicationType_id` `rateApplicationTypeId` INT(11) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`rateByCard` 
ADD CONSTRAINT `fk_rateCard_rateApplicationType1`
  FOREIGN KEY (`rateApplicationTypeId`)
  REFERENCES `CardManagementSystem`.`rateApplicationType` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `CardManagementSystem`.`user` 
CHANGE COLUMN `code` `code` VARCHAR(40) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL ;

-- Agregar 2 nuevos CollectionType para las imagenes de Solicitud de Tarjetas
-- author: Yamelis Almea
-- Fecha: 26/03/2020

INSERT INTO `CardManagementSystem`.`collectionType` (`id`, `description`, `countryId`) VALUES ('9', 'DOCUMENTO DE IDENTIFICACION APP', '1');
INSERT INTO `CardManagementSystem`.`collectionType` (`id`, `description`, `countryId`) VALUES ('10', 'FOTO CON DOCUMENTO DE IDENTIDAD', '1');
CHANGE COLUMN `code` `code` VARCHAR(40) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL ;
