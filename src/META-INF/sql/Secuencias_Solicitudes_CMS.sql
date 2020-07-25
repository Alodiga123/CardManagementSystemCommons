-- Insertar tipos de documentos para (Emision Nuevas Tarjetas y Cambiar Contraseña)
-- author: Jesús Gómez
-- Fecha: 24/07/2020
INSERT INTO `CardManagementSystem`.`documentType` (`name`, `acronym`) VALUES 
("NEW CARD ISSUE REQUEST", "NCIR"),
("CHANGE PASSWORD REQUEST", "CPR");

-- Insertar secuencias para documentos (Emision Nuevas Tarjetas y Cambiar Contraseña)
-- author: Jesús Gómez
-- Fecha: 24/07/2020
INSERT INTO `CardManagementSystem`.`sequences` (`initialValue`, `currentValue`, `documentType_id`, `originApplicationId`) VALUES (1, 1, 5, 1);
INSERT INTO `CardManagementSystem`.`sequences` (`initialValue`, `currentValue`, `documentType_id`, `originApplicationId`) VALUES (1, 1, 6, 1);