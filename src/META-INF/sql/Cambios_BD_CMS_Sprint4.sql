--Cambios Sprint 4
-- Agregar tabla reasonRejectionRequest
-- author: Jesús Gómez
-- Fecha: 10/01/2020

CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`reasonRejectionRequest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FK en tabla request
-- author: Jesús Gómez
-- Fecha: 10/01/2020
ALTER TABLE `CardManagementSystem`.`request` 
ADD COLUMN `reasonRejectionRequestId` INT NULL;
ALTER TABLE `CardManagementSystem`.`request` 
ADD CONSTRAINT `fk_request_reasonRejectionRequest1` 
FOREIGN KEY (`reasonRejectionRequestId`)
    REFERENCES `CardManagementSystem`.`reasonRejectionRequest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Agregar tabla comercialAgency
-- author: Jesús Gómez
-- Fecha: 10/01/2020
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

-- Agregar tabla employee
-- author: Jesús Gómez
-- Fecha: 10/01/2020
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

-- Agregar tabla system
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`system` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla systemOptionType
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`systemOptionType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla Option
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`option` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `level` INT NULL,
  `systemOptionTypeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_option_systemOptionType1_idx` (`systemOptionTypeId` ASC),
  CONSTRAINT `fk_option_systemOptionType1`
    FOREIGN KEY (`systemOptionTypeId`)
    REFERENCES `CardManagementSystem`.`systemOptionType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla systemOption
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`systemOption` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `systemId` INT NOT NULL,
  `systemOptionId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_systemHasSystemOption_system1_idx` (`systemId` ASC),
  INDEX `fk_systemHasSystemOption_systemOption1_idx` (`systemOptionId` ASC),
  CONSTRAINT `fk_systemHasSystemOption_system1`
    FOREIGN KEY (`systemId`)
    REFERENCES `CardManagementSystem`.`system` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_systemHasSystemOption_systemOption1`
    FOREIGN KEY (`systemOptionId`)
    REFERENCES `CardManagementSystem`.`option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla profile
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(20) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(250) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla profileHasSystemOption
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`profileHasSystemOption` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profileId` INT NOT NULL,
  `systemOptionId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_profileHasSystemOption_profile1_idx` (`profileId` ASC),
  INDEX `fk_profileHasSystemOption_systemOption1_idx` (`systemOptionId` ASC),
  CONSTRAINT `fk_profileHasSystemOption_profile1`
    FOREIGN KEY (`profileId`)
    REFERENCES `CardManagementSystem`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profileHasSystemOption_systemOption1`
    FOREIGN KEY (`systemOptionId`)
    REFERENCES `CardManagementSystem`.`systemOption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla accessSystemParticular
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accessSystemParticular` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar tabla accessSystemType
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`accessSystemType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NOT NULL,
  `accessSystemParticularId` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accessSystemType_accessSystemParticular1_idx` (`accessSystemParticularId` ASC),
  CONSTRAINT `fk_accessSystemType_accessSystemParticular1`
    FOREIGN KEY (`accessSystemParticularId`)
    REFERENCES `CardManagementSystem`.`accessSystemParticular` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla rol
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(20) NULL,
  `name` VARCHAR(40) NULL,
  `description` VARCHAR(250) NULL,
  `accessSystemTypeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rol_accessSystemType1_idx` (`accessSystemTypeId` ASC),
  CONSTRAINT `fk_rol_accessSystemType1`
    FOREIGN KEY (`accessSystemTypeId`)
    REFERENCES `CardManagementSystem`.`accessSystemType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla rolHasProfileHasSystemOption
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`rolHasProfileHasSystemOption` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rolId` INT NOT NULL,
  `profileHasSystemOptionId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rolHasProfileHasSystemOption_rol1_idx` (`rolId` ASC),
  INDEX `fk_rolHasProfileHasSystemOption_profileHasSystemOption1_idx` (`profileHasSystemOptionId` ASC),
  CONSTRAINT `fk_rolHasProfileHasSystemOption_rol1`
    FOREIGN KEY (`rolId`)
    REFERENCES `CardManagementSystem`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rolHasProfileHasSystemOption_profileHasSystemOption1`
    FOREIGN KEY (`profileHasSystemOptionId`)
    REFERENCES `CardManagementSystem`.`profileHasSystemOption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Agregar tabla userHasRol
-- author: Jesús Gómez
-- Fecha: 10/01/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`userHasRol` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `rolId` INT NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_userHasRol_rol1_idx` (`rolId` ASC),
  INDEX `fk_userHasRol_user1_idx` (`userId` ASC),
  CONSTRAINT `fk_userHasRol_rol1`
    FOREIGN KEY (`rolId`)
    REFERENCES `CardManagementSystem`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userHasRol_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `CardManagementSystem`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Cambiar nombre de tabla allowedChannels
-- author: Jesús Gómez
-- Fecha: 10/01/2020
RENAME TABLE `CardManagementSystem`.`allowedChannels` TO `CardManagementSystem`.`productHasChannel`; 

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