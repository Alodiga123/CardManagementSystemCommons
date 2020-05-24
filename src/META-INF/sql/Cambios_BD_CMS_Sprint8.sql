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


