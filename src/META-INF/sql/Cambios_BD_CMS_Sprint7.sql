-- Crear tablastatusProduct
-- author: Jesús Gómez
-- Fecha: 02/04/2020
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`statusProduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- Agregar FK en product
-- author: Jesús Gómez
-- Fecha: 02/04/2020
ALTER TABLE `CardManagementSystem`.`product` 
ADD COLUMN `statusProductId` INT NOT NULL;
ALTER TABLE `CardManagementSystem`.`product` 
ADD CONSTRAINT `fk_product_statusProduct1` 
FOREIGN KEY (`statusProductId`)
    REFERENCES `CardManagementSystem`.`statusProduct` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


