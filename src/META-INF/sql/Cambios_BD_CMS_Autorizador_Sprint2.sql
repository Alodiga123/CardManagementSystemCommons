-- Crear tabla keyProperties
-- author: Jesús Gómez
-- Fecha: 08/02/2021
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`keyProperties` (
  `id` BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
  `channelId` INT NOT NULL,
  `productId` BIGINT UNIQUE NOT NULL,
  `keyLength` INT NULL,
  `expirationDays` INT NULL,
  `totalPreviousKeys` INT NULL,
  `totalNumericCharacters` INT NULL,
  `indConsecutiveEqualCharacters` TINYINT(1) NULL,
  `indContinuousCharacters` TINYINT(1) NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_keyProperties_channel1_idx` (`channelId` ASC),
  INDEX `fk_keyProperties_product1_idx` (`productId` ASC),
  CONSTRAINT `fk_keyProperties_channel1`
    FOREIGN KEY (`channelId`)
    REFERENCES `CardManagementSystem`.`channel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_keyProperties_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `CardManagementSystem`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
