-- Agregar tabla reviewRequestType
-- author: Jesús Gómez
-- Fecha: 06/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`reviewRequestType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Insertar datos tabla reviewRequestType
INSERT INTO `CardManagementSystem`.`reviewRequestType`
(`description`)
VALUES 
("Recaudos"),
("Lista Negra OFAC");

-- Cambiar nombre de tabla reviewCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 06/02/2020
RENAME TABLE `CardManagementSystem`.`reviewCollectionsRequest` TO `CardManagementSystem`.`reviewRequest`; 

-- Agregar campos en tabla reviewRequest
-- author: Jesús Gómez
-- Fecha: 06/02/2020
ALTER TABLE `CardManagementSystem`.`reviewRequest` 
ADD COLUMN `reviewRequestTypeId` INT NOT NULL,
ADD COLUMN `indApproved` TINYINT(1) NULL;

-- Agregar FK en tabla reviewRequest
-- author: Jesús Gómez
-- Fecha: 06/02/2020
ALTER TABLE `CardManagementSystem`.`reviewRequest` 
ADD CONSTRAINT `fk_reviewRequest_reviewRequestType1` 
FOREIGN KEY (`reviewRequestTypeId`)
    REFERENCES `CardManagementSystem`.`reviewRequestType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar campos en tabla address
-- author: Jesús Gómez
-- Fecha: 07/02/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `indAddressDelivery` TINYINT(1) NULL;

-- Agregar tabla addressType
-- author: Jesús Gómez
-- Fecha: 07/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`addressType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Insertar datos tabla addressType
INSERT INTO `CardManagementSystem`.`addressType`
(`description`)
VALUES 
("Habitación"),
("Domicilio Fiscal"),
("Entrega Tarjeta"),
("Facturación");

-- Agregar FK en tabla address
-- author: Jesús Gómez
-- Fecha: 07/02/2020
ALTER TABLE `CardManagementSystem`.`address` 
ADD COLUMN `addressTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`address` 
ADD CONSTRAINT `fk_address_addressType1` 
FOREIGN KEY (`addressTypeId`)
    REFERENCES `CardManagementSystem`.`addressType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla request
-- author: Jesús Gómez
-- Fecha: 07/02/2020
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `personCustomerId` BIGINT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_personCustomer1` 
FOREIGN KEY (`personCustomerId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar tabla statusCustomer
-- author: Jesús Gómez
-- Fecha: 07/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusCustomer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla naturalCustomer
-- author: Jesús Gómez
-- Fecha: 07/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`naturalCustomer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `personId` BIGINT NOT NULL,
  `documentsPersonTypeId` INT NOT NULL,
  `identificationNumber` VARCHAR(40) NULL,
  `dueDateDocumentIdentification` DATE NULL,
  `indNaturalized` TINYINT(1) NULL,
  `identificationNumberOld` VARCHAR(40) NULL,
  `statusCustomerId` INT NOT NULL,
  `indForeign` TINYINT(1) NULL,
  `countryStayTime` INT NULL,
  `firstNames` VARCHAR(40) NULL,
  `lastNames` VARCHAR(40) NULL,
  `marriedLastName` VARCHAR(40) NULL,
  `rifNumber` VARCHAR(10) NULL,
  `gender` VARCHAR(1) NULL,
  `placeBirth` VARCHAR(45) NULL,
  `dateBirth` DATE NULL,
  `civilStatusId` INT NOT NULL,
  `familyResponsibilities` INT NULL,
  `professionId` INT NOT NULL,
  `naturalCustomerId` BIGINT NOT NULL,
  `kinShipApplicantId` INT NOT NULL,
  `createDate` TIMESTAMP NULL,
  `updatedate` TIMESTAMP NULL,
  INDEX `fk_Customer_person1_idx` (`personId` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_naturalCustomer_documentsPersonType1_idx` (`documentsPersonTypeId` ASC),
  INDEX `fk_naturalCustomer_statusCustomer1_idx` (`statusCustomerId` ASC),
  INDEX `fk_naturalCustomer_civilStatus1_idx` (`civilStatusId` ASC),
  INDEX `fk_naturalCustomer_profession1_idx` (`professionId` ASC),
  INDEX `fk_naturalCustomer_naturalCustomer1_idx` (`naturalCustomerId` ASC),
  INDEX `fk_naturalCustomer_kinShipApplicant1_idx` (`kinShipApplicantId` ASC),
  CONSTRAINT `fk_Customer_person1`
    FOREIGN KEY (`personId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalCustomer_documentsPersonType1`
    FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalCustomer_statusCustomer1`
    FOREIGN KEY (`statusCustomerId`)
    REFERENCES `CardManagementSystem`.`statusCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalCustomer_civilStatus1`
    FOREIGN KEY (`civilStatusId`)
    REFERENCES `CardManagementSystem`.`civilStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalCustomer_profession1`
    FOREIGN KEY (`professionId`)
    REFERENCES `CardManagementSystem`.`profession` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalCustomer_naturalCustomer1`
    FOREIGN KEY (`naturalCustomerId`)
    REFERENCES `CardManagementSystem`.`naturalCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalCustomer_kinShipApplicant1`
    FOREIGN KEY (`kinShipApplicantId`)
    REFERENCES `CardManagementSystem`.`kinShipApplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla legalCustomer
-- author: Jesús Gómez
-- Fecha: 07/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`legalCustomer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `personId` BIGINT NOT NULL,
  `documentsPersonTypeId` INT NOT NULL,
  `identificationNumber` VARCHAR(40) NULL,
  `tradeName` VARCHAR(60) NULL,
  `enterpriseName` VARCHAR(60) NULL,
  `statusCustomerId` INT NOT NULL,
  `economicActivityId` INT NOT NULL,
  `dateInscriptionRegister` DATE NULL,
  `registerNumber` VARCHAR(45) NULL,
  `payedCapital` FLOAT NULL,
  `webSite` VARCHAR(45) NULL,
  `createDate` TIMESTAMP NULL,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_legalCustomer_person1_idx` (`personId` ASC),
  INDEX `fk_legalCustomer_documentsPersonType1_idx` (`documentsPersonTypeId` ASC),
  INDEX `fk_legalCustomer_statusCustomer1_idx` (`statusCustomerId` ASC),
  INDEX `fk_legalCustomer_economicActivity1_idx` (`economicActivityId` ASC),
  CONSTRAINT `fk_legalCustomer_person1`
    FOREIGN KEY (`personId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalCustomer_documentsPersonType1`
    FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalCustomer_statusCustomer1`
    FOREIGN KEY (`statusCustomerId`)
    REFERENCES `CardManagementSystem`.`statusCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalCustomer_economicActivity1`
    FOREIGN KEY (`economicActivityId`)
    REFERENCES `CardManagementSystem`.`economicActivity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla legalCustomerHasLegalRepresentatives
-- author: Jesús Gómez
-- Fecha: 07/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`legalCustomerHasLegalRepresentatives` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `legalRepresentativesId` INT NOT NULL,
  `legalCustomerId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_legalCustomerHasLegalRepresentatives_legalRepresentative_idx` (`legalRepresentativesId` ASC),
  INDEX `fk_legalCustomerHasLegalRepresentatives_legalCustomer1_idx` (`legalCustomerId` ASC),
  CONSTRAINT `fk_legalCustomerHasLegalRepresentatives_legalRepresentatives1`
    FOREIGN KEY (`legalRepresentativesId`)
    REFERENCES `CardManagementSystem`.`legalRepresentatives` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalCustomerHasLegalRepresentatives_legalCustomer1`
    FOREIGN KEY (`legalCustomerId`)
    REFERENCES `CardManagementSystem`.`legalCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla cardStatus
-- author: Jesús Gómez
-- Fecha: 07/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`cardStatus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`card` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cardNumber` VARCHAR(40) NULL,
  `sequentialNumber` INT NULL,
  `programId` BIGINT NOT NULL,
  `productId` BIGINT NOT NULL,
  `issueDate` DATE NULL,
  `expirationDate` DATE NULL,
  `securityCodeCard` VARCHAR(10) NULL,
  `securityCodeMagneticStrip` VARCHAR(10) NULL,
  `ICVVMagneticStrip` VARCHAR(1500) NULL,
  `cardStatusId` INT NOT NULL,
  `pinOffset` VARCHAR(40) NULL,
  `validationData` VARCHAR(40) NULL,
  `pinLenght` INT NULL,
  `personCustomerId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_card_program1_idx` (`programId` ASC),
  INDEX `fk_card_product1_idx` (`productId` ASC),
  INDEX `fk_card_cardStatus1_idx` (`cardStatusId` ASC),
  INDEX `fk_card_person1_idx` (`personCustomerId` ASC),
  CONSTRAINT `fk_card_program1`
    FOREIGN KEY (`programId`)
    REFERENCES `CardManagementSystem`.`program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_cardStatus1`
    FOREIGN KEY (`cardStatusId`)
    REFERENCES `CardManagementSystem`.`cardStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_person1`
    FOREIGN KEY (`personCustomerId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla reviewOFAC
-- author: Jesús Gómez
-- Fecha: 10/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`reviewOFAC` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `resultReview` VARCHAR(250) NULL,
  `personId` BIGINT UNIQUE NOT NULL,
  `requestId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ReviewOFAC_person1_idx` (`personId` ASC),
  INDEX `fk_ReviewOFAC_request1_idx` (`requestId` ASC),
  CONSTRAINT `fk_ReviewOFAC_person1`
    FOREIGN KEY (`personId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ReviewOFAC_request1`
    FOREIGN KEY (`requestId`)
    REFERENCES `CardManagementSystem`.`request` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar FK en tabla cardRequestNaturalPerson
-- author: Jesús Gómez
-- Fecha: 10/02/2020
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD COLUMN `legalCustomerId` BIGINT NULL;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD CONSTRAINT `fk_cardRequestNaturalPerson_legalCustomer1` 
FOREIGN KEY (`legalCustomerId`)
    REFERENCES `CardManagementSystem`.`legalCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar tabla accountType
-- author: Jesús Gómez
-- Fecha: 11/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accountType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla subAccountType
-- author: Jesús Gómez
-- Fecha: 11/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`subAccountType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `accountTypeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_subAccountType_accountType1_idx` (`accountTypeId` ASC),
  CONSTRAINT `fk_subAccountType_accountType1`
    FOREIGN KEY (`accountTypeId`)
    REFERENCES `CardManagementSystem`.`accountType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla accountProperties
-- author: Jesús Gómez
-- Fecha: 11/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accountProperties` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `countryId` INT NOT NULL,
  `programId` BIGINT NOT NULL,
  `accountTypeId` INT NOT NULL,
  `identifier` VARCHAR(40) NULL,
  `lenghtAccount` INT NULL,
  `maximumAmount` FLOAT NULL,
  `minimunAmount` FLOAT NULL,
  `indOverDraft` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accountType_country1_idx` (`countryId` ASC),
  INDEX `fk_accountType_program1_idx` (`programId` ASC),
  INDEX `fk_accountProperties_accountType1_idx` (`accountTypeId` ASC),
  CONSTRAINT `fk_accountType_country1`
    FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_accountType_program1`
    FOREIGN KEY (`programId`)
    REFERENCES `CardManagementSystem`.`program` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_accountProperties_accountType1`
    FOREIGN KEY (`accountTypeId`)
    REFERENCES `CardManagementSystem`.`accountType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla accountSegment
-- author: Jesús Gómez
-- Fecha: 11/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accountSegment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NULL,
  `lenghtSegment` INT NULL,
  `accountPropertiesId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accountSegment_accountProperties1_idx` (`accountPropertiesId` ASC),
  CONSTRAINT `fk_accountSegment_accountProperties1`
    FOREIGN KEY (`accountPropertiesId`)
    REFERENCES `CardManagementSystem`.`accountProperties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar campo en tabla request
-- author: Jesús Gómez
-- Fecha: 12/02/2020
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `indPersonNaturalRequest` TINYINT(1) NULL;

-- Agregar tabla accountTypeHasProductType
-- author: Jesús Gómez
-- Fecha: 13/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accountTypeHasProductType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productTypeId` INT NOT NULL,
  `accountTypeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accountTypeHasProductType_productType1_idx` (`productTypeId` ASC),
  INDEX `fk_accountTypeHasProductType_accountType1_idx` (`accountTypeId` ASC),
  CONSTRAINT `fk_accountTypeHasProductType_productType1`
    FOREIGN KEY (`productTypeId`)
    REFERENCES `CardManagementSystem`.`productType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_accountTypeHasProductType_accountType1`
    FOREIGN KEY (`accountTypeId`)
    REFERENCES `CardManagementSystem`.`accountType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla statusApplicant
-- author: Jesús Gómez
-- Fecha: 14/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusApplicant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FK en tabla applicantNaturalPerson
-- author: Jesús Gómez
-- Fecha: 14/02/2020
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD COLUMN `statusApplicantId` INT NULL;
ALTER TABLE `CardManagementSystem`.`applicantNaturalPerson` 
ADD CONSTRAINT `fk_applicantNaturalPerson_statusApplicant1` 
FOREIGN KEY (`statusApplicantId`)
    REFERENCES `CardManagementSystem`.`statusApplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla legalPerson
-- author: Jesús Gómez
-- Fecha: 14/02/2020
ALTER TABLE `CardManagementSystem`.`legalPerson` 
ADD COLUMN `statusApplicantId` INT NULL;
ALTER TABLE `CardManagementSystem`.`legalPerson` 
ADD CONSTRAINT `fk_legalPerson_statusApplicant1` 
FOREIGN KEY (`statusApplicantId`)
    REFERENCES `CardManagementSystem`.`statusApplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar FK en tabla personType
-- author: Jesús Gómez
-- Fecha: 17/02/2020
ALTER TABLE `CardManagementSystem`.`personType` 
ADD COLUMN `indNaturalPerson` TINYINT(1) NULL;

-- Agregar FK en tabla legalRepresentatives
-- author: Jesús Gómez
-- Fecha: 18/02/2020
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD COLUMN `civilStatusId` INT NULL;
ALTER TABLE `CardManagementSystem`.`legalRepresentatives` 
ADD CONSTRAINT `fk_legalRepresentatives_civilStatus1` 
FOREIGN KEY (`civilStatusId`)
    REFERENCES `CardManagementSystem`.`civilStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- Agregar tabla additionalInformationNaturalCustomer
-- author: Jesús Gómez
-- Fecha: 20/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`additionalInformationNaturalCustomer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `naturalCustomerId` BIGINT NOT NULL,
  `firstNamesHusband` VARCHAR(40) NULL,
  `lastNamesHusband` VARCHAR(40) NULL,
  `documentsPersonTypeId` INT NOT NULL,
  `identificationNumberHusband` VARCHAR(40) NULL,
  `phoneHusband` VARCHAR(30) NULL,
  `emailHusband` VARCHAR(60) NULL,
  `carBrand` VARCHAR(40) NULL,
  `carModel` VARCHAR(40) NULL,
  `carYear` INT NULL,
  `carPlate` VARCHAR(20) NULL,
  `salary` FLOAT NULL,
  `freeProfessionalExercise` FLOAT NULL,
  `bonusesCommissionsFee` FLOAT NULL,
  `rentsIncome` FLOAT NULL,
  `otherIncome` FLOAT NULL,
  `totalIncome` FLOAT NULL,
  `housingExpenses` FLOAT NULL,
  `monthlyRentMortgage` FLOAT NULL,
  `monthlyPaymentCreditCard` FLOAT NULL,
  `monthlyPaymentOtherCredit` FLOAT NULL,
  `educationExpenses` FLOAT NULL,
  `totalExpenses` FLOAT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_additionalInformationNaturalCustomer_naturalCustomer1_idx` (`naturalCustomerId` ASC),
  INDEX `fk_additionalInformationNaturalCustomer_documentsPersonType_idx` (`documentsPersonTypeId` ASC),
  CONSTRAINT `fk_additionalInformationNaturalCustomer_naturalCustomer1`
    FOREIGN KEY (`naturalCustomerId`)
    REFERENCES `CardManagementSystem`.`naturalCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_additionalInformationNaturalCustomer_documentsPersonType1`
    FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar FK para que acepte NULL en familyReferences
-- author: Jesús Gómez
-- Fecha: 20/02/2020
ALTER TABLE `CardManagementSystem`.`familyReferences` 
ADD COLUMN `naturalCustomerId` BIGINT NULL;
ALTER TABLE `CardManagementSystem`.`familyReferences` 
ADD CONSTRAINT `fk_familyReferences_naturalCustomer1` 
FOREIGN KEY (`naturalCustomerId`)
    REFERENCES `CardManagementSystem`.`naturalCustomer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- Agregar tabla plasticManufacturer
-- author: Jesús Gómez
-- Fecha: 20/02/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`plasticManufacturer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `personId` BIGINT UNIQUE NOT NULL,
  `documentsPersonTypeId` INT NOT NULL,
  `identificationNumber` VARCHAR(40) NULL,
  `name` VARCHAR(120) NULL,
  `contractNumber` VARCHAR(40) NULL,
  `contactPerson` VARCHAR(80) NULL,
  `emailContactPerson` VARCHAR(40) NULL,
  `indStatus` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_plasticManufacturer_person1_idx` (`personId` ASC),
  INDEX `fk_plasticManufacturer_documentsPersonType1_idx` (`documentsPersonTypeId` ASC),
  CONSTRAINT `fk_plasticManufacturer_person1`
    FOREIGN KEY (`personId`)
    REFERENCES `CardManagementSystem`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plasticManufacturer_documentsPersonType1`
    FOREIGN KEY (`documentsPersonTypeId`)
    REFERENCES `CardManagementSystem`.`documentsPersonType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar FK en accountProperties
-- author: Jesús Gómez
-- Fecha: 20/02/2020
ALTER TABLE `CardManagementSystem`.`accountProperties` 
ADD COLUMN `subAccountTypeId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`accountProperties` 
ADD CONSTRAINT `fk_accountProperties_subAccountType1` 
FOREIGN KEY (`subAccountTypeId`)
    REFERENCES `CardManagementSystem`.`subAccountType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- Agregar campos de creación y actualización de registro en request
-- author: Jesús Gómez
-- Fecha: 28/02/2020
ALTER TABLE `CardManagementSystem`.`request` 
CHANGE COLUMN `requestDate` `requestDate` TIMESTAMP NULL ,
ADD COLUMN `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  AFTER `indPersonNaturalRequest`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createDate`;

-- Agregar FK en request
-- author: Jesús Gómez
-- Fecha: 28/02/2020
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `userId` INT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_user1` 
FOREIGN KEY (`userId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Actualizar fecha de creación en naturalCustomer
-- author: Jesús Gómez
-- Fecha: 28/02/2020  
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
CHANGE COLUMN `createDate` `createDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ;

-- Actualizar fecha de creación en legalCustomer
-- author: Jesús Gómez
-- Fecha: 28/02/2020  
ALTER TABLE `CardManagementSystem`.`legalCustomer` 
CHANGE COLUMN `createDate` `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ;

-- Agregar campos de creación y actualización de registro en requestHasCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 29/02/2020
ALTER TABLE `CardManagementSystem`.`requestHasCollectionsRequest` 
ADD COLUMN `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `urlImageFile`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createdDate`;

-- Agregar campos de creación y actualización de registro en reviewRequest
-- author: Jesús Gómez
-- Fecha: 29/02/2020
ALTER TABLE `CardManagementSystem`.`reviewRequest` 
ADD COLUMN `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `indPersonNaturalRequest`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createdDate`;

-- cambiar FK kinShipApplicantId para que acepte null en naturalCustomer
-- author: Jesús Gómez
-- Fecha: 29/02/2020
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
DROP FOREIGN KEY `fk_naturalCustomer_kinShipApplicant1`;
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
CHANGE COLUMN `kinShipApplicantId` `kinShipApplicantId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
ADD CONSTRAINT `fk_naturalCustomer_kinShipApplicant1`
  FOREIGN KEY (`kinShipApplicantId`)
  REFERENCES `CardManagementSystem`.`kinShipApplicant` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Actualizar fecha de creación en legalCustomer
-- author: Jesús Gómez
-- Fecha: 28/02/2020  
ALTER TABLE `CardManagementSystem`.`legalCustomer` 
CHANGE COLUMN `createDate` `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ;

-- Agregar campos de creación y actualización de registro en requestHasCollectionsRequest
-- author: Jesús Gómez
-- Fecha: 29/02/2020
ALTER TABLE `CardManagementSystem`.`requestHasCollectionsRequest` 
ADD COLUMN `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `urlImageFile`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createdDate`;

-- Agregar campos de creación y actualización de registro en reviewRequest
-- author: Jesús Gómez
-- Fecha: 29/02/2020
ALTER TABLE `CardManagementSystem`.`reviewRequest` 
ADD COLUMN `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `indApproved`,
ADD COLUMN `updateDate` TIMESTAMP NULL AFTER `createdDate`;

-- cambiar FK kinShipApplicantId para que acepte null en naturalCustomer
-- author: Jesús Gómez
-- Fecha: 29/02/2020
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
DROP FOREIGN KEY `fk_naturalCustomer_kinShipApplicant1`;
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
CHANGE COLUMN `kinShipApplicantId` `kinShipApplicantId` INT(11) NULL ;
ALTER TABLE `CardManagementSystem`.`naturalCustomer` 
ADD CONSTRAINT `fk_naturalCustomer_kinShipApplicant1`
  FOREIGN KEY (`kinShipApplicantId`)
  REFERENCES `CardManagementSystem`.`kinShipApplicant` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- cambiar FK countryId en additionalInformationNaturalCustomer
-- author: Jesús Gómez
-- Fecha: 03/03/2020
ALTER TABLE `CardManagementSystem`.`additionalInformationNaturalCustomer` 
ADD COLUMN `countryId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`additionalInformationNaturalCustomer` 
ADD CONSTRAINT `fk_additionalInformationNaturalCustomer_country1` 
FOREIGN KEY (`countryId`)
    REFERENCES `CardManagementSystem`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- cambiar nombre de campo en product
-- author: Jesús Gómez
-- Fecha: 06/03/2020
ALTER TABLE `CardManagementSystem`.`product` 
CHANGE COLUMN `validityYears` `validityMonths` INT(11) NULL DEFAULT NULL ;


