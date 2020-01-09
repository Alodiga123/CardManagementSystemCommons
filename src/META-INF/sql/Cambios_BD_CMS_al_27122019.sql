-- Modificado el campo FamiliReferencesId
-- author: Jesús Gómez
-- Fecha: 12/11/2019

ALTER TABLE `CardManagementSystem`.`phoneFamilyReferences` 
DROP FOREIGN KEY `fk_phoneFamilyReferences_familyReferences1`;
ALTER TABLE `CardManagementSystem`.`phoneFamilyReferences` 
CHANGE COLUMN `familyReferences_id` `familyReferencesId` BIGINT(20) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`phoneFamilyReferences` 
ADD CONSTRAINT `fk_phoneFamilyReferences_familyReferences1`
  FOREIGN KEY (`familyReferencesId`)
  REFERENCES `CardManagementSystem`.`familyReferences` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


-- tabla personType
-- author: Jesús Gómez
-- Fecha: 13/11/2019
Use `CardManagementSystem`;
ALTER TABLE `CardManagementSystem`.`personType` 
ADD COLUMN `countryId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`personType` 
ADD CONSTRAINT `fk_personType_country1` 
FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- agregar tabla documentsPersonType
-- author: Jesús Gómez
-- Fecha: 13/11/2019
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`documentsPersonType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(80) NULL,
  `personTypeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_documentsPersonType_personType1_idx` (`personTypeId` ASC),
  CONSTRAINT `fk_documentsPersonType_personType1`
    FOREIGN KEY (`personTypeId`)
    REFERENCES `CardManagementSystem`.`personType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Eliminar campo RIF en tabla person
-- author: Jesús Gómez
-- Fecha: 14/11/2019

ALTER TABLE `CardManagementSystem`.`person` 
	DROP COLUMN `rif`;

-- Agregar FK en tabla naturalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`naturalPerson` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`naturalPerson` 
ADD CONSTRAINT `fk_naturalPerson_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla legalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`legalPerson` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`legalPerson` 
ADD CONSTRAINT `fk_legalPerson_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar campos identificationNumber y codeIdentificationNumber en tabla legalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`legalPerson` 
ADD COLUMN `identificationNumber` VARCHAR(40) NOT NULL;

-- Eliminar FK tabla naturalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`naturalPerson`
DROP FOREIGN KEY `fk_naturalPerson_identificationType1`;
ALTER TABLE `CardManagementSystem`.`naturalPerson` 
DROP INDEX  `fk_naturalPerson_identificationType1_idx`;
ALTER TABLE `CardManagementSystem`.`naturalPerson` 
DROP COLUMN `identificationTypeId`;

-- Eliminar FK tabla legalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`legalPerson`
	DROP FOREIGN KEY `fk_legalPerson_identificationType1`;
ALTER TABLE `CardManagementSystem`.`legalPerson` 
	DROP INDEX  `fk_legalPerson_identificationType1_idx`;
ALTER TABLE `CardManagementSystem`.`legalPerson` 
	DROP COLUMN `identificationTypeId`;


-- Eliminar FK tabla legalRepresentatives
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`legalRepresentatives`
DROP FOREIGN KEY `fk_legalRepresentatives_identificationType1`;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
DROP INDEX  `fk_legalRepresentatives_identificationType1_idx`;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
	DROP COLUMN `identificationTypeId`;

-- Eliminar FK tabla applicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson`
DROP FOREIGN KEY `fk_naturalPerson_identificationType10`;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
DROP INDEX  `fk_naturalPerson_identificationType1_idx`;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
DROP COLUMN `identificationTypeId`;

-- Eliminar FK tabla cardRequestNaturalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson`
DROP FOREIGN KEY `fk_cardRequestNaturalPerson_identificationType1`;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
DROP INDEX  `fk_cardRequestNaturalPerson_identificationType1_idx`;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
DROP COLUMN `identificationTypeId`;

-- Eliminar tabla identificationType
-- author: Jesús Gómez
-- Fecha: 14/11/2019
DROP TABLE `CardManagementSystem`.`identificationType`;

-- Agregar FK en tabla legalRepresentatives
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD CONSTRAINT `fk_legalRepresentatives_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla aplicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD CONSTRAINT `fk_applicantNaturalPerson_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla cardRequestNaturalPerson
-- author: Jesús Gómez
-- Fecha: 14/11/2019
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD COLUMN `documentsPersonTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD CONSTRAINT `fk_cardRequestNaturalPerson_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;  

-- Agregar campo codeIdentificationNumber en tabla documentsPersonType
-- author: Jesús Gómez
-- Fecha: 15/11/2019
ALTER TABLE `CardManagementSystem`.`documentsPersonType` 
ADD COLUMN `codeIdentificationNumber` VARCHAR(10) NULL; 

ALTER TABLE `CardManagementSystem`.`program` 
DROP INDEX `programOwnerId` ,
ADD INDEX `programOwnerId` (`programOwnerId` ASC),
DROP INDEX `cardProgramManagerId` ,
ADD INDEX `cardProgramManagerId` (`cardProgramManagerId` ASC);

-- Agregar tablas network y programHasNetwork
-- author: Jesús Gómez
-- Fecha: 25/11/2019

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`network` ( 
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(50) NULL, 
  `countryId` INT NOT NULL, 
  PRIMARY KEY (`id`), 
  INDEX `fk_network_country1_idx` (`countryId` ASC), 
  CONSTRAINT `fk_network_country1` 
    FOREIGN KEY (`countryId`) 
    REFERENCES `CardManagementSystem`.`country` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION) 
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`programHasNetwork` ( 
  `id` BIGINT NOT NULL AUTO_INCREMENT, 
  `programId` BIGINT NOT NULL, 
  `networkId` INT NOT NULL, 
  PRIMARY KEY (`id`), 
  INDEX `fk_programHasNetwork_program1_idx` (`programId` ASC), 
  INDEX `fk_programHasNetwork_network1_idx` (`networkId` ASC), 
  CONSTRAINT `fk_programHasNetwork_program1` 
    FOREIGN KEY (`programId`) 
    REFERENCES `CardManagementSystem`.`program` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION, 
  CONSTRAINT `fk_programHasNetwork_network1` 
    FOREIGN KEY (`networkId`) 
    REFERENCES `CardManagementSystem`.`network` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION) 
ENGINE = InnoDB;

-- Agregar FKs en tabla request
-- author: Jesús Gómez
-- Fecha: 25/11/2019
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `programId` BIGINT NOT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_program1` 
FOREIGN KEY (`programId`)
    REFERENCES `CardManagementSystem`.`program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;  
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `productTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_productType1` 
FOREIGN KEY (`productTypeId`)
    REFERENCES `CardManagementSystem`.`productType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;  
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `countryId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_country1` 
FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION; 
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `personTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_personType1` 
FOREIGN KEY (`personTypeId`)
    REFERENCES `CardManagementSystem`.`personType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;  

-- Eliminar tabla cardRequestType
-- author: Jesús Gómez
-- Fecha: 25/11/2019
DROP TABLE `CardManagementSystem`.`cardRequestType`;

-- Eliminar FKs tabla requestType
-- author: Jesús Gómez
-- Fecha: 25/11/2019
ALTER TABLE `CardManagementSystem`.`requestType`
DROP FOREIGN KEY `fk_requestType_CardRequestType1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP INDEX  `fk_requestType_CardRequestType1_idx`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP COLUMN `cardRequestTypeId`;

ALTER TABLE `CardManagementSystem`.`requestType`
DROP FOREIGN KEY `fk_requestType_country1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP INDEX  `fk_requestType_country1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP COLUMN `countryId`;

ALTER TABLE `CardManagementSystem`.`requestType`
DROP FOREIGN KEY `fk_requestType_personType1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP INDEX  `fk_requestType_personType1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP COLUMN `personTypeId`;

ALTER TABLE `CardManagementSystem`.`requestType`
DROP FOREIGN KEY `fk_requestType_productType1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP INDEX  `fk_requestType_productType1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP COLUMN `productTypeId`;

ALTER TABLE `CardManagementSystem`.`requestType`
DROP FOREIGN KEY `fk_requestType_program1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP INDEX  `fk_requestType_program1`;
ALTER TABLE `CardManagementSystem`.`requestType` 
DROP COLUMN `programId`;

-- Agregar campos: code y description en tabla requestType
-- author: Jesús Gómez
-- Fecha: 25/11/2019
ALTER TABLE `CardManagementSystem`.`requestType` 
ADD COLUMN `code` VARCHAR(10) NULL,
ADD COLUMN `description` VARCHAR(50) NULL;

-- Eliminar tabla requestTypeHasCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 25/11/2019
DROP TABLE `CardManagementSystem`.`requestTypeHasCollectionsRequest`;

-- Agregar tabla requestHasCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 25/11/2019
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`requestHasCollectionsRequest` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `collectionsRequest_id` INT NOT NULL,
  `request_id` BIGINT NOT NULL,
  `indApproved` TINYINT NULL,
  `observations` VARCHAR(1500) NULL,
  `urlImageFile` VARCHAR(250) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_requestHasCollectionsRequest_collectionsRequest1_idx` (`collectionsRequest_id` ASC),
  INDEX `fk_requestHasCollectionsRequest_request1_idx` (`request_id` ASC),
  CONSTRAINT `fk_requestHasCollectionsRequest_collectionsRequest1`
    FOREIGN KEY (`collectionsRequest_id`)
    REFERENCES `CardManagementSystem`.`collectionsRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_requestHasCollectionsRequest_request1`
    FOREIGN KEY (`request_id`)
    REFERENCES `CardManagementSystem`.`request` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Modificar los tipos de índices de la tabla Program
-- author: Jesús Gómez
-- Fecha: 26/11/2019
ALTER TABLE `CardManagementSystem`.`program` 
DROP INDEX `programOwnerId` ,
ADD INDEX `programOwnerId` (`programOwnerId` ASC),
DROP INDEX `cardProgramManagerId` ,
ADD INDEX `cardProgramManagerId` (`cardProgramManagerId` ASC);

-- Cambios en BD 02/12/2019

-- Agregar la tabla originApplication
-- author: Jesús Gómez
-- Fecha: 02/12/2019
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`originApplication` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FKs en tabla personType
-- author: Jesús Gómez
-- Fecha: 02/12/2019
ALTER TABLE `CardManagementSystem`.`personType` 
ADD COLUMN `originApplicationId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`personType` 
ADD CONSTRAINT `fk_personType_originApplication1` 
FOREIGN KEY (`originApplicationId`)
    REFERENCES `CardManagementSystem`.`originApplication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION; 

-- Eliminar FKs tabla familyReferences
-- author: Jesús Gómez
-- Fecha: 02/12/2019
ALTER TABLE `CardManagementSystem`.`familyReferences`
DROP FOREIGN KEY `fk_familyReferences_naturalPerson1`;
ALTER TABLE `CardManagementSystem`.`familyReferences` 
DROP INDEX  `fk_familyReferences_naturalPerson1_idx`;
ALTER TABLE `CardManagementSystem`.`familyReferences` 
DROP COLUMN `naturalPerson_id`; 

-- Agregar FKs en tabla familyReferences
-- author: Jesús Gómez
-- Fecha: 02/12/2019
ALTER TABLE `CardManagementSystem`.`familyReferences` 
ADD COLUMN `applicantNaturalPersonId` BIGINT NOT NULL;
ALTER TABLE `CardManagementSystem`.`familyReferences` 
ADD CONSTRAINT `fk_familyReferences_applicantNaturalPerson1` 
FOREIGN KEY (`applicantNaturalPersonId`)
    REFERENCES `CardManagementSystem`.`applicantNaturalPerson` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION; 

-- Agregar campos en tabla familyReferences
-- author: Jesús Gómez
-- Fecha: 02/12/2019
ALTER TABLE `CardManagementSystem`.`familyReferences` 
ADD COLUMN `city` VARCHAR(50) NULL,
ADD COLUMN `localPhone` VARCHAR(30) NULL,
ADD COLUMN `cellPhone` VARCHAR(30) NULL,
ADD COLUMN `lastNames` VARCHAR(40) NULL; 

-- Cambiar nombre de campo en tabla familyReferences
-- author: Jesús Gómez
-- Fecha: 02/12/2019 
ALTER TABLE `CardManagementSystem`.`familyReferences` CHANGE COLUMN `name` `firstNames` varchar(40);

-- Eliminar tabla phoneFamilyReferences
-- author: Jesús Gómez
-- Fecha: 02/12/2019
DROP TABLE `CardManagementSystem`.`phoneFamilyReferences`;

-- Eliminar campo email en tabla address
-- author: Jesús Gómez
-- Fecha: 03/12/2019

ALTER TABLE `CardManagementSystem`.`address` 
  DROP COLUMN `email`;

-- Agregar la tabla documentType
-- author: Jesús Gómez
-- Fecha: 04/12/2019
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`documentType` (
  `id` INT NOT NULL,
  `name` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB

-- Agregar la tabla sequences
-- author: Jesús Gómez
-- Fecha: 04/12/2019
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`sequences` (
  `id` INT NOT NULL,
  `initialValue` INT NULL,
  `currentValue` INT NULL,
  `documentType_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sequences_documentType1_idx` (`documentType_id` ASC),
  CONSTRAINT `fk_sequences_documentType1`
    FOREIGN KEY (`documentType_id`)
    REFERENCES `CardManagementSystem`.`documentType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- Modificar FK personId en tabla request (para que acepte null)
-- author: Jesús Gómez
-- Fecha: 04/12/2019
ALTER TABLE `CardManagementSystem`.`request` 
DROP FOREIGN KEY `fk_request_person1`;
ALTER TABLE `CardManagementSystem`.`request` 
CHANGE COLUMN `personId` `personId` BIGINT(20) NULL ;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_person1`
  FOREIGN KEY (`personId`)
  REFERENCES `CardManagementSystem`.`person` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Eliminar campo zipZonecol en tabla zipZone 
-- author: Jesús Gómez
-- Fecha: 09/12/2019
ALTER TABLE `CardManagementSystem`.`zipZone` 
DROP COLUMN `zipZonecol`;

-- Modificar nombre de FK en tabla state 
-- author: Jesús Gómez
-- Fecha: 09/12/2019
ALTER TABLE `CardManagementSystem`.`state` 
DROP FOREIGN KEY `fk_state_country1`;
ALTER TABLE `CardManagementSystem`.`state` 
CHANGE COLUMN `country_id` `countryId` INT(11) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`state` 
ADD CONSTRAINT `fk_state_country1`
  FOREIGN KEY (`countryId`)
  REFERENCES `CardManagementSystem`.`country` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


-- Modificar tipo de indice en tabla phonePerson 
-- author: Jesús Gómez
-- Fecha: 10/12/2019
ALTER TABLE `CardManagementSystem`.`phonePerson` 
DROP INDEX `personId` ,
ADD INDEX `personId` (`personId` ASC);

-- Modificar tipo de indice en tabla applicantNaturalPerson 
-- author: Jesús Gómez
-- Fecha: 10/12/2019
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
DROP INDEX `personId` ,
ADD INDEX `personId` (`personId` ASC);

-- Modificar tipo de indice en tabla cardRequestNaturalPerson 
-- author: Jesús Gómez
-- Fecha: 10/12/2019
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
DROP INDEX `person_id` ,
ADD INDEX `person_id` (`person_id` ASC);

-- Modificar índice en tabla legalRepresentatives 
-- author: Jesús Gómez
-- Fecha: 11/12/2019
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
DROP INDEX `personsId` ,
ADD INDEX `personsId` (`personsId` ASC);

-- Canbiar nombre de columna tabla legalRepresentatives 
-- author: Jesús Gómez
-- Fecha: 11/12/2019
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
DROP FOREIGN KEY `fk_legalRepresentatives_persons1`;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
CHANGE COLUMN `personsId` `personId` BIGINT(20) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD CONSTRAINT `fk_legalRepresentatives_persons1`
  FOREIGN KEY (`personId`)
  REFERENCES `CardManagementSystem`.`person` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Establecer varios campos NOT_NULL tabla applicantNaturalPerson 
-- author: Jesús Gómez
-- Fecha: 12/12/2019
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
DROP FOREIGN KEY `fk_applicantNaturalPerson_documentsPersonType1`;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
CHANGE COLUMN `identificationNumber` `identificationNumber` VARCHAR(40) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NOT NULL ,
CHANGE COLUMN `firstNames` `firstNames` VARCHAR(40) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NOT NULL ,
CHANGE COLUMN `lastNames` `lastNames` VARCHAR(40) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NOT NULL ,
CHANGE COLUMN `gender` `gender` VARCHAR(1) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NOT NULL ,
CHANGE COLUMN `placeBirth` `placeBirth` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NOT NULL ,
CHANGE COLUMN `dateBirth` `dateBirth` DATE NOT NULL ,
CHANGE COLUMN `documentsPersonTypeId` `documentsPersonTypeId` INT(11) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD CONSTRAINT `fk_applicantNaturalPerson_documentsPersonType1`
  FOREIGN KEY (`documentsPersonTypeId`)
  REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Modificar indice en tabla request
-- author: Jesús Gómez
-- Fecha: 16/12/2019
ALTER TABLE `CardManagementSystem`.`request` 
DROP INDEX `person_id` ,
ADD INDEX `person_id` (`personId` ASC);

-- Agregar FK en tabla sequences
-- author: Jesús Gómez
-- Fecha: 16/12/2019
ALTER TABLE `CardManagementSystem`.`sequences` 
ADD COLUMN `originApplicationId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`sequences` 
ADD CONSTRAINT `fk_sequences_originApplication1` 
FOREIGN KEY (`originApplicationId`)
    REFERENCES `CardManagementSystem`.`originApplication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Cambiar tamaño de campo tabla economicActivity
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`economicActivity` 
CHANGE COLUMN `description` `description` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL DEFAULT NULL ;

-- Cambiar tamaño de campo en tabla segment
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`segment` 
CHANGE COLUMN `description` `description` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL DEFAULT NULL ;

-- Eliminar FKs tabla commerceCategory
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`commerceCategory`
DROP FOREIGN KEY `fk_commerceCategory_economicActivity1`;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
DROP INDEX  `fk_commerceCategory_economicActivity1_idx`;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
DROP COLUMN `economicActivityId`;

-- Agregar campos en tabla commerceCategory
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
ADD COLUMN `economicActivity` VARCHAR(1000) NULL,
ADD COLUMN `descriptionEconomicActivity` VARCHAR(1500) NULL;

-- Eliminar FKs tabla commerceCategory
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`commerceCategory`
DROP FOREIGN KEY `fk_commerceCategory_country1`;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
DROP INDEX  `fk_commerceCategory_country1_idx`;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
DROP COLUMN `countryId`;


-- Cambiar nombre de tabla segment
-- author: Jesús Gómez
-- Fecha: 23/12/2019
RENAME TABLE `CardManagementSystem`.`segment` TO `CardManagementSystem`.`segmentMarketing`

-- Agregar tabla segmentCommerce
-- author: Jesús Gómez
-- Fecha: 23/12/2019
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`segmentCommerce` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Eliminar FKs tabla commerceCategory
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`commerceCategory`
DROP FOREIGN KEY `fk_commerceCategory_segment1`;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
DROP INDEX  `fk_commerceCategory_segment1_idx`;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
DROP COLUMN `segmentId`;

-- Agregar FK en tabla commerceCategory
-- author: Jesús Gómez
-- Fecha: 23/12/2019
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
ADD COLUMN `segmentCommerceId` INT NULL;
ALTER TABLE `CardManagementSystem`.`commerceCategory` 
ADD CONSTRAINT `fk_commerceCategory_segmentCommerce1` 
FOREIGN KEY (`segmentCommerceId`)
    REFERENCES `CardManagementSystem`.`segmentCommerce` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `CardManagementSystem`.`personHasAddress` 
DROP INDEX `person_id` ,
ADD INDEX `person_id` (`personId` ASC);

-- Modificar nombre de FK en tabla product
-- author: Jesús Gómez
-- Fecha: 26/12/2019
ALTER TABLE `CardManagementSystem`.`product` 
DROP FOREIGN KEY `fk_product_segment1`;
ALTER TABLE `CardManagementSystem`.`product` 
CHANGE COLUMN `segment_id` `segmentMarketingId` INT(11) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`product` 
ADD CONSTRAINT `fk_product_segment1`
  FOREIGN KEY (`segmentMarketingId`)
  REFERENCES `CardManagementSystem`.`segmentMarketing` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION; 

-- Agregar FK en tabla applicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 02/01/2020
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
DROP FOREIGN KEY `fk_naturalPerson_civilStatus10`,
DROP FOREIGN KEY `fk_naturalPerson_professions10`;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
CHANGE COLUMN `civilStatusId` `civilStatusId` INT(11) NULL ,
CHANGE COLUMN `professionId` `professionId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD CONSTRAINT `fk_naturalPerson_civilStatus10`
  FOREIGN KEY (`civilStatusId`)
  REFERENCES `CardManagementSystem`.`civilStatus` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_naturalPerson_professions10`
  FOREIGN KEY (`professionId`)
  REFERENCES `CardManagementSystem`.`profession` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


-- Agregar FK en tabla applicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 02/01/2020
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD CONSTRAINT `fk_applicantNaturalPerson_documentsPersonType1` 
FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar tabla collectionType
-- author: Jesús Gómez
-- Fecha: 06/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`collectionType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(80) NOT NULL,
  `countryId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_collectionType_country1_idx` (`countryId` ASC),
  CONSTRAINT `fk_collectionType_country1`
    FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Eliminando campo description en tabla collectionsRequest
-- author: Jesús Gómez
-- Fecha: 06/01/2020
ALTER TABLE `CardManagementSystem`.`collectionsRequest` 
DROP COLUMN `description`;

-- Agregar FK en tabla collectionsRequest
-- author: Jesús Gómez
-- Fecha: 06/01/2020
ALTER TABLE `CardManagementSystem`.`collectionsRequest` 
ADD COLUMN `collectionTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`collectionsRequest` 
ADD CONSTRAINT `fk_collectionsRequest_collectionType1` 
FOREIGN KEY (`collectionTypeId`)
    REFERENCES `CardManagementSystem`.`collectionType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `CardManagementSystem`.`productHasCommerceCategory` 
DROP FOREIGN KEY `fk_productCommerceClassification_commerceClassification1`;
ALTER TABLE `CardManagementSystem`.`productHasCommerceCategory` 
CHANGE COLUMN `commerceClassificationId` `commerceCategoryId` INT(11) NOT NULL ;
ALTER TABLE `CardManagementSystem`.`productHasCommerceCategory` 
ADD CONSTRAINT `fk_productCommerceClassification_commerceClassification1`
  FOREIGN KEY (`commerceCategoryId`)
  REFERENCES `CardManagementSystem`.`commerceCategory` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

