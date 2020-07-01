-- Modificar FK en tabla generalRate
-- author: Jesús Gómez
-- Fecha: 01/07/2020
ALTER TABLE `CardManagementSystem`.`generalRate` 
DROP FOREIGN KEY `fk_generalRate_approvalGeneralRate1`;
ALTER TABLE `CardManagementSystem`.`generalRate`
DROP COLUMN `approvalGeneralRateId`;
ALTER TABLE `CardManagementSystem`.`generalRate` 
ADD COLUMN `approvalGeneralRateId` INT NULL;
ALTER TABLE `CardManagementSystem`.`generalRate` 
ADD CONSTRAINT `fk_generalRate_approvalGeneralRate1` 
FOREIGN KEY (`approvalGeneralRateId`)
    REFERENCES `CardManagementSystem`.`approvalGeneralRate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- Modificar FK en tabla familyReferences
-- author: Lulymar Gutiérrez
-- Fecha: 01/07/2020
ALTER TABLE `CardManagementSystem`.`familyReferences` 
DROP FOREIGN KEY `fk_familyReferences_applicantNaturalPerson1`;
ALTER TABLE `CardManagementSystem`.`familyReferences` 
CHANGE COLUMN `applicantNaturalPersonId` `applicantNaturalPersonId` BIGINT(20) NULL ;
ALTER TABLE `CardManagementSystem`.`familyReferences` 
ADD CONSTRAINT `fk_familyReferences_applicantNaturalPerson1`
  FOREIGN KEY (`applicantNaturalPersonId`)
  REFERENCES `CardManagementSystem`.`applicantNaturalPerson` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Modificar FK en tabla cardRequestNaturalPerson
-- author: Lulymar Gutiérrez
-- Fecha: 01/07/2020 
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
DROP FOREIGN KEY `fk_cardRequestNaturalPerson_legalPerson1`;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
CHANGE COLUMN `legalPerson_id` `legalPerson_id` BIGINT(20) NULL ;
ALTER TABLE `CardManagementSystem`.`cardRequestNaturalPerson` 
ADD CONSTRAINT `fk_cardRequestNaturalPerson_legalPerson1`
  FOREIGN KEY (`legalPerson_id`)
  REFERENCES `CardManagementSystem`.`legalPerson` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;