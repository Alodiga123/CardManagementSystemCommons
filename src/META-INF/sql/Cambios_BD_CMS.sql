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
