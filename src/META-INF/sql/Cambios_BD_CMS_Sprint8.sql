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
    ON UPDATE NO ACTION)





