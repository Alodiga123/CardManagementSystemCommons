-- Cambios para ajustar el formulario de solicitud de tarjetas
-- author: Jesús Gómez
-- Fecha: 15/03/2020

CREATE TABLE `cardmanagementsystem`.`title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `cardmanagementsystem`.`title` (`id`, `description`) VALUES ('1', 'Sr');
INSERT INTO `cardmanagementsystem`.`title` (`id`, `description`) VALUES ('2', 'Sra');
INSERT INTO `cardmanagementsystem`.`title` (`id`, `description`) VALUES ('3', 'Srta');


ALTER TABLE `cardmanagementsystem`.`applicantnaturalperson` 
ADD COLUMN `titleId` INT(11) NULL DEFAULT NULL AFTER `statusApplicantId`,
ADD COLUMN `recommendation` TINYINT(1) NULL AFTER `titleId`,
ADD COLUMN `promotion` TINYINT(1) NULL AFTER `recommendation`,
ADD COLUMN `citizen` TINYINT(1) NULL AFTER `promotion`,
ADD INDEX `fk_applicationNaturalPerson_title1` (`titleId` ASC) INVISIBLE;
;
ALTER TABLE `cardmanagementsystem`.`applicantnaturalperson` 
ADD CONSTRAINT `fk_applicationNaturalPerson_title1`
  FOREIGN KEY (`titleId`)
  REFERENCES `cardmanagementsystem`.`title` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
  ALTER TABLE `cardmanagementsystem`.`applicantnaturalperson` 
ADD COLUMN `password` VARCHAR(45) NULL DEFAULT NULL AFTER `citizen`;


ALTER TABLE `cardmanagementsystem`.`address` 
ADD COLUMN `fullAddress` VARCHAR(150) NULL DEFAULT NULL AFTER `addressTypeId`;

ALTER TABLE `cardmanagementsystem`.`address` 
ADD COLUMN `postalZone` VARCHAR(45) NULL DEFAULT NULL AFTER `fullAddress`;

ALTER TABLE `cardmanagementsystem`.`applicantnaturalperson` 
CHANGE COLUMN `identificationNumber` `identificationNumber` VARCHAR(40) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL ,
CHANGE COLUMN `gender` `gender` VARCHAR(1) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL ,
CHANGE COLUMN `placeBirth` `placeBirth` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_danish_ci' NULL ;

ALTER TABLE `cardmanagementsystem`.`address` 
DROP FOREIGN KEY `fk_address_addressType1`,
DROP FOREIGN KEY `fk_address_edificationType1`,
DROP FOREIGN KEY `fk_address_streetType1`,
DROP FOREIGN KEY `fk_address_zipZone1`;
ALTER TABLE `cardmanagementsystem`.`address` 
CHANGE COLUMN `edificationTypeId` `edificationTypeId` INT(11) NULL ,
CHANGE COLUMN `streetTypeId` `streetTypeId` INT(11) NULL ,
CHANGE COLUMN `zipZoneId` `zipZoneId` INT(11) NULL ,
CHANGE COLUMN `addressTypeId` `addressTypeId` INT(11) NULL ;
ALTER TABLE `cardmanagementsystem`.`address` 
ADD CONSTRAINT `fk_address_addressType1`
  FOREIGN KEY (`addressTypeId`)
  REFERENCES `cardmanagementsystem`.`addresstype` (`id`),
ADD CONSTRAINT `fk_address_edificationType1`
  FOREIGN KEY (`edificationTypeId`)
  REFERENCES `cardmanagementsystem`.`edificationtype` (`id`),
ADD CONSTRAINT `fk_address_streetType1`
  FOREIGN KEY (`streetTypeId`)
  REFERENCES `cardmanagementsystem`.`streettype` (`id`),
ADD CONSTRAINT `fk_address_zipZone1`
  FOREIGN KEY (`zipZoneId`)
  REFERENCES `cardmanagementsystem`.`zipzone` (`id`);

