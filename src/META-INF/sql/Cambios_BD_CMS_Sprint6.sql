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

ALTER TABLE `CardManagementSystem`.`reviewOFAC` 
DROP INDEX `personId` ;



