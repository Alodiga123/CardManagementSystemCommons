--data dummy Card management System

-- Insertar datos tabla productType
INSERT INTO `CardManagementSystem`.`productType`
(`name`)
VALUES 
("Tarjeta Prepagada"),
("Tarjeta  de Débito"),
("Tarjeta de Regalo"),
("Tarjeta de Crédito");

-- Insertar datos tabla personType
INSERT INTO `CardManagementSystem`.`personType`
(`description`,`countryId`)
VALUES 
("Persona Natural",1),
("Persona Jurídica",1);

-- Insertar datos tabla documentsPersonType
INSERT INTO `CardManagementSystem`.`documentsPersonType`
(`description`,`personTypeId`)
VALUES 
("Cédula de Identidad",1),
("Pasaporte",1),
("Registro de Información Fiscal",2);

-- Insertar datos tabla cardRequestType
INSERT INTO `CardManagementSystem`.`cardRequestType`
(`code`,`description`)
VALUES 
("IPER","Individual Personalizada"),
("MPER","Masiva personalizada"),
("MNPE","Masiva No Personalizada");

-- Insertar datos tabla programType
INSERT INTO `CardManagementSystem`.`programType`
(`name`)
VALUES 
("Franquicia"),
("Privado");

-- Insertar datos tabla personClassification
INSERT INTO `CardManagementSystem`.`personClassification`
(`description`)
VALUES 
("Issuer"),
("Card Manager Program"),
("Program Owner"),
("Applicant"),
("Legal Representatives"),
("Persona Contacto Emisor");


-- Insertar datos tabla person
INSERT INTO `CardManagementSystem`.`person`
(`countryId`,`personClassificationId`,`personTypeId`)
VALUES 
(1,1,2), -- Emisor Banco Mercantil
(1,6,1), -- Persona Contacto Banco Mercantil
(1,3,1), -- Program Owner (Program Ejm)
(1,2,1); -- Card Program Owner (Program Ejm)

-- Insertar datos tabla issuerType
INSERT INTO `CardManagementSystem`.`issuerType`
(`description`)
VALUES 
("Entidad Bancaria"),
("Persona Jurídica");


-- Insertar datos tabla issuer
INSERT INTO `CardManagementSystem`.`issuer`
(`countryId`,`name`,`issuerTypeId`,`contactPersonId`,`issuerPersonId`)
VALUES 
(1,"Banco Mercantil",1,2,1);

-- Insertar datos tabla binSponsor
INSERT INTO `CardManagementSystem`.`binSponsor`
(`description`)
VALUES 
("VISA"),
("MASTER CARD"),
("DINNERS"),
("AMEX"),
("DISCOVER"),
("CABAL");

-- Insertar datos tabla cardIssuanceType
INSERT INTO `CardManagementSystem`.`cardIssuanceType`
(`description`)
VALUES 
("Emisión Instantánea Solamente"),
("Emisión Instantánea seguida de Personalizada"),
("Personalizada Solamente");

-- Insertar datos tabla sourceFunds
INSERT INTO `CardManagementSystem`.`sourceFunds`
(`description`)
VALUES 
("Cliente"),
("Empleadora"),
("Corporación"),
("Gobierno"),
("Otros");

-- Insertar datos tabla responsibleNetworkReporting
INSERT INTO `CardManagementSystem`.`responsibleNetworkReporting`
(`description`)
VALUES 
("Program Manager"),
("Procesador"),
("Otros");


-- Insertar datos tabla program
INSERT INTO `CardManagementSystem`.`program`
(`name`,`description`,`contractDate`,`ProgramTypeId`,`productTypeId`,`IssuerId`,`programOwnerId`,`cardProgramManagerId`,`BinSponsorId`,
 `cardIssuanceTypeId`,`sourceFundsId`,`currencyId`,`responsibleNetworkReportingId` )
VALUES 
("Programa de tarjeta prepagada para sector estudiantes","LOREM IPSU LOREM IPSU LOREM IPSU LOREM IPSU", "2019-06-12",1,1,1,3,4,1,2,1,1,1);


-- Insertar datos tabla requestType
INSERT INTO `CardManagementSystem`.`requestType`
(`ProgramId`,`productTypeId`,`countryId`,`personTypeId`,`cardRequestTypeId`)
VALUES 
(1,1,1,2,2);








