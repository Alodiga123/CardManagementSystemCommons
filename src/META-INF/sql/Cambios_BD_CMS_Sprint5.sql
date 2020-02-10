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








