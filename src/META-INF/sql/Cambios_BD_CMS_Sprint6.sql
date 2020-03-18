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



