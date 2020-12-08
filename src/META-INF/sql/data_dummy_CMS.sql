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


-- Insertar datos tabla cardType
INSERT INTO `CardManagementSystem`.`cardType`
(`description`)
VALUES 
("Debito"),
("Prepagada"),
("Regalo");

-- Insertar datos tabla segmentMarketing
INSERT INTO `CardManagementSystem`.`segmentMarketing`
(`name`,`description`)
VALUES 
("Estudiantes","LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM"),
("Tercera Edad","LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM"),
("Empleados Pùblicos","LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM");

-- Insertar datos tabla segmentCommerce
INSERT INTO `CardManagementSystem`.`segmentCommerce`
(`name`)
VALUES 
("AGENCIAS Y AEROLINEAS",),
("AGROPECUARIO"),
("ALMACEN POR DEPARTAMENTOS"),
("AUTO Y SERV DE TRANSPORTE"),
("BARES Y RESTAURANTES"),
("GENERAL");

-- Insertar datos tabla commerceCategory
INSERT INTO `CardManagementSystem`.`commerceCategory`
(`mccCode`,`economicActivity`,`descriptionEconomicActivity`,`segmentCommerceId`)
VALUES 
("3001","AMERICAN AIRLINES","AMERICAN AIRLINES",1),
("3007","AIR FRANCE","AIR FRANCE",1),
("7342","Exterminating and Disinfecting Services","Exterminating and Disinfecting ServiceS",2),
("5311","Department Stores","Department Stores",3),
("5499","Misc. Food Stores – Convenience Stores and Specialty Markets","Misc. Food Stores – Convenience Stores and Specialty MarketS",3),
("4111","Local/Suburban Commuter Passenger Transportation – Railroads, Feries, Local Water Transportation.","Local/Suburban Commuter Passenger Transportation – Railroads, Feries, Local Water Transportation.",4),
("3357","HERTZ RENT-A-CAR","HERTZ RENT-A-CAR",4),
("5812","Eating places and Restaurants","Eating places and Restaurants",5),
("4119","Ambulance Services","Ambulance Services",6),
("4789","Transportation Services, Not elsewhere classified)","Transportation Services, Not elsewhere classified)",6);

--
-- Insertar datos tabla kindCard
INSERT INTO `CardManagementSystem`.`kindCard`
(`description`)
VALUES 
("Fisica"),
("Virtual");

-- Insertar datos tabla productUse
INSERT INTO `CardManagementSystem`.`productUse`
(`description`)
VALUES 
("Domestico"),
("Internacional"),
("Ambos");

-- Insertar datos tabla channel
INSERT INTO `CardManagementSystem`.`channel`
(`name`,`description`)
VALUES 
("RED POS","Puntos de Ventas"),
("ATM","Cajero Automatico"),
("WEB","Banca Movil Banca en linea"),
("BANCOS","Banco Emisor Transacciones Realizadas Agencia Bancaria"),
("CMS","Card Management System"),
("IVR","Servicio Automatizado de Voz");

-- Insertar datos tabla storageMedio
INSERT INTO `CardManagementSystem`.`storageMedio`
(`description`)
VALUES 
("Chip"),
("Banda Magnetica");


-- Insertar datos tabla levelProduct
INSERT INTO `CardManagementSystem`.`levelProduct`
(`description`)
VALUES 
("SILVER"),
("GOLD"),
("PLATINUM"),
("BLACK");

-- Insertar datos tabla product
INSERT INTO `CardManagementSystem`.`product`
(`name`,`issuerId`,`countryId`,`cardTypeId`,`kindCardId`,`programTypeId`,`binSponsorId`,`levelProductId`,`productUseId`,`domesticCurrencyId`,
 `internationalCurrencyId`,`storageMedio_id`,`segmentMarketingId`,`program_id`,`binNumber`,`validityYears`,`daysBeforeExpiration`,
 `daysToActivate`,`daysToInactivate`,`daysToUse`,`daysToWithdrawCard`,`beginDateValidity`,`endDateValidity`)
VALUES 
("Tarjeta de Regalo Tercera Edad","1","1","5","1","1","1","2","1",1,3,"1",2,"44",2,1,1,1,1,1,1,"2019-12-26","2019-12-26");

-- Insertar datos tabla collectionType
INSERT INTO `CardManagementSystem`.`collectionType`
(`description`,`countryId`)
VALUES 
("Cédula de Identidad",4),
("Referencias Personales",4),
("Referencias Bancarias",4),
("Pasaporte",4),
("Constancia de Trabajo",4);

-- Insertar datos tabla reasonRejectionRequest
INSERT INTO `CardManagementSystem`.`reasonRejectionRequest`
(`code`,`description`)
VALUES 
("RECAUDOS","La solicitud no contempla los recaudos requeridos"),
("LISTAS NEGRAS","Algún relacionados a la solicitud está en Listas Negras"),
("CREDITICIA","La evaluación crediticia no fue satisfactoria"),
("RIESGOS","La evaluación de riesgos no fue satisfactoria");


-- Insertar datos tabla system
INSERT INTO `CardManagementSystem`.`system`
(`code`,`name`,`description`)
VALUES 
("CMS","Card Management System","LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM LOREM IPSUM");

-- Insertar datos tabla systemOptionType
INSERT INTO `CardManagementSystem`.`systemOptionType`
(`description`)
VALUES 
("CONSULTA"),
("ACTUALIZACION"),
("GLOBAL");

-- Insertar datos tabla menuList
INSERT INTO `CardManagementSystem`.`menuList`
(`nameOption`)
VALUES 
("Administrar Programas Datos Generales"),
("Administrar Programas Redes"),
("Administrar Productos Datos Generales"),
("Administrar Productos Categorías Comercio"),
("Administrar Productos Límites y Restricciones"),
("Solicitud de Tarjeta PN Datos Generales"),
("Solicitud de Tarjeta PN Datos Solicitante"),
("Solicitud de Tarjeta PN Dirección Solicitante"),
("Solicitud de Tarjeta PN Referencias Familiares"),
("Solicitud de Tarjeta PN Tarjetas Complementarias"),
("Solicitud de Tarjeta PN Recaudos"),
("Solicitud de Tarjeta PN Revisión"),
("Solicitud de Tarjeta PJ Datos Generales"),
("Solicitud de Tarjeta PJ Datos Solicitante"),
("Solicitud de Tarjeta PJ Dirección Solicitante"),
("Solicitud de Tarjeta PJ Representantes Legales"),
("Solicitud de Tarjeta PJ Tarjetas Adicionales"),
("Solicitud de Tarjeta PJ Recaudos"),
("Solicitud de Tarjeta PJ Revisión");

-- Insertar datos tabla option
INSERT INTO `CardManagementSystem`.`option`
(`menuListId`,`level`,`systemOptionTypeId`)
VALUES 
(1,1,1),
(1,1,2),
(1,1,3),
(2,1,1),
(2,1,2),
(2,1,3),
(3,1,1),
(3,1,2),
(3,1,3),
(4,1,1),
(4,1,2),
(4,1,3),
(5,1,1),
(5,1,2),
(5,1,3),
(6,1,1),
(6,1,2),
(6,1,3),
(7,1,1),
(7,1,2),
(7,1,3),
(8,1,1),
(8,1,2),
(8,1,3),
(9,1,1),
(9,1,2),
(9,1,3),
(10,1,1),
(10,1,2),
(10,1,3),
(11,1,1),
(11,1,2),
(11,1,3),
(12,1,1),
(12,1,2),
(12,1,3),
(13,1,1),
(13,1,2),
(13,1,3),
(14,1,1),
(14,1,2),
(14,1,3),
(15,1,1),
(15,1,2),
(15,1,3),
(16,1,1),
(16,1,2),
(16,1,3),
(17,1,1),
(17,1,2),
(17,1,3),
(18,1,1),
(18,1,2),
(18,1,3),
(19,1,1),
(19,1,2),
(19,1,3);

-- Insertar datos de Plastic Manufacturer 
INSERT INTO `CardManagementSystem`.`personClassification`
(`id`,`description`)
VALUES 
(9,"Plastic Manufacturer");

INSERT INTO `CardManagementSystem`.`person`
(`countryId`,`email`,`personClassificationId`,`personTypeId`)
VALUES 
(1,"Credential@gmail.com",9,2);

SET @PersonID = 0;
SELECT MAX(p.id) INTO @PersonID FROM `CardManagementSystem`.`person` p;

INSERT INTO `CardManagementSystem`.`phonePerson`
(`numberPhone`,`personId`,`phoneTypeId`)
VALUES 
("0416-2589633",@PersonID,1);

INSERT INTO `CardManagementSystem`.`plasticManufacturer`
(`personId`,`documentsPersonTypeId`,`identificationNumber`,`name`,`contractNumber`,`contactPerson`,`emailContactPerson`,`indStatus`)
VALUES 
(@PersonID,3,"J105826932","Credential Argentina","PO-1586328-A","Yoan Leon","yleon@gmail.com",1);


-- Insertar datos tabla cardNumberCredential
INSERT INTO `CardManagementSystem`.`cardNumberCredential`
(`cardNumber`,`securityCodeCard`,`indUse`)
VALUES 
('5412101234567890','659',0),
('5412341234567890','793',0),
('5412781234567890','884',0),
('5412330987654321','385',0),
('5412569877730932','659',0),
('5412156874009834','123',0),
('5412105888400936','943',0),
('5412757578484899','847',0),
('5412104466379833','008',0),
('5412345678936278','447',0),
('5412102377593847','472',0);



INSERT INTO `documentType` VALUES ('NEW CARD ISSUE REQUEST','NCI');

INSERT INTO `sequences` VALUES (1,1,5,1);

INSERT INTO `statusNewCardIssueRequest` VALUES ('PEND','PENDIENTE'),('CONF','CONFIRMADA'),('CANC','CANCELADA');


-- Jorge Pinto 
-- Insertar dato NFC tabla storageMedio
INSERT INTO `CardManagementSystem`.`storageMedio` (`description`) VALUES ('NFC');

-- Insertar datos de Shipping Company
INSERT INTO `CardManagementSystem`.`person`
(`countryId`,`email`,`personClassificationId`,`personTypeId`)
VALUES 
(1,"DHL@gmail.com",11,2);

SET @PersonID = 0;
SELECT MAX(p.id) INTO @PersonID FROM `CardManagementSystem`.`person` p;

INSERT INTO `CardManagementSystem`.`phonePerson`
(`numberPhone`,`personId`,`phoneTypeId`)
VALUES 
("0416-2589633",@PersonID,1);

INSERT INTO `CardManagementSystem`.`legalPerson`
(`personId`,`documentsPersonTypeId`,`identificationNumber`,`name`,`contractNumber`,`contactPerson`,`emailContactPerson`,`indStatus`)
VALUES 
(@PersonID,3,"J105826932","Credential Argentina","PO-1586328-A","Yoan Leon","yleon@gmail.com",1);


-- Actualizar code Mexico en tabla state
-- author: Jesús Gómez
-- Fecha: 04/10/2020
UPDATE `CardManagementSystem`.`state` SET `code`='A' WHERE `id`='79';
UPDATE `CardManagementSystem`.`state` SET `code`='B' WHERE `id`='81';
UPDATE `CardManagementSystem`.`state` SET `code`='6' WHERE `id`='80';
UPDATE `CardManagementSystem`.`state` SET `code`='C' WHERE `id`='82';
UPDATE `CardManagementSystem`.`state` SET `code`='F' WHERE `id`='83';
UPDATE `CardManagementSystem`.`state` SET `code`='G' WHERE `id`='84';
UPDATE `CardManagementSystem`.`state` SET `code`='D' WHERE `id`='85';
UPDATE `CardManagementSystem`.`state` SET `code`='E' WHERE `id`='86';
UPDATE `CardManagementSystem`.`state` SET `code`='H' WHERE `id`='87';
UPDATE `CardManagementSystem`.`state` SET `code`='I' WHERE `id`='88';
UPDATE `CardManagementSystem`.`state` SET `code`='K' WHERE `id`='89';
UPDATE `CardManagementSystem`.`state` SET `code`='L' WHERE `id`='90';
UPDATE `CardManagementSystem`.`state` SET `code`='M' WHERE `id`='91';
UPDATE `CardManagementSystem`.`state` SET `code`='N' WHERE `id`='92';
UPDATE `CardManagementSystem`.`state` SET `code`='J' WHERE `id`='93';
UPDATE `CardManagementSystem`.`state` SET `code`='O' WHERE `id`='94';
UPDATE `CardManagementSystem`.`state` SET `code`='P' WHERE `id`='95';
UPDATE `CardManagementSystem`.`state` SET `code`='Q' WHERE `id`='96';
UPDATE `CardManagementSystem`.`state` SET `code`='R' WHERE `id`='97';
UPDATE `CardManagementSystem`.`state` SET `code`='S' WHERE `id`='98';
UPDATE `CardManagementSystem`.`state` SET `code`='T' WHERE `id`='99';
UPDATE `CardManagementSystem`.`state` SET `code`='U' WHERE `id`='100';
UPDATE `CardManagementSystem`.`state` SET `code`='V' WHERE `id`='101';
UPDATE `CardManagementSystem`.`state` SET `code`='W' WHERE `id`='102';
UPDATE `CardManagementSystem`.`state` SET `code`='X' WHERE `id`='103';
UPDATE `CardManagementSystem`.`state` SET `code`='Y' WHERE `id`='104';
UPDATE `CardManagementSystem`.`state` SET `code`='Z' WHERE `id`='105';
UPDATE `CardManagementSystem`.`state` SET `code`='1' WHERE `id`='106';
UPDATE `CardManagementSystem`.`state` SET `code`='2' WHERE `id`='107';
UPDATE `CardManagementSystem`.`state` SET `code`='3' WHERE `id`='108';
UPDATE `CardManagementSystem`.`state` SET `code`='4' WHERE `id`='109';
UPDATE `CardManagementSystem`.`state` SET `code`='5' WHERE `id`='110';


-- Actualizar data para asociar recaudos de la solicitud de tarjetas
-- author: Yamelis Almea
-- Fecha: 05/11/2020

INSERT INTO `CardManagementSystem`.`personType` (`id`, `description`, `countryId`, `originApplicationId`, `indNaturalPerson`) VALUES ('9', 'Persona Natural', '82', '2', '1');
UPDATE `CardManagementSystem`.`collectionType` SET `personTypeId` = '3' WHERE (`id` = '9');
UPDATE `CardManagementSystem`.`collectionType` SET `personTypeId` = '3' WHERE (`id` = '10');
UPDATE `CardManagementSystem`.`collectionType` SET `description` = 'FOTO CON DOCUMENTO DE IDENTIDAD APP' WHERE (`id` = '10');
INSERT INTO `CardManagementSystem`.`collectionType` (`id`, `description`, `countryId`, `personTypeId`) VALUES ('18', 'DOCUMENTO DE IDENTIFICACION APP', '2', '4');
INSERT INTO `CardManagementSystem`.`collectionType` (`id`, `description`, `countryId`, `personTypeId`) VALUES ('19', 'DOCUMENTO DE IDENTIFICACION APP', '82', '9');
INSERT INTO `CardManagementSystem`.`collectionType` (`id`, `description`, `countryId`, `personTypeId`) VALUES ('20', 'FOTO CON DOCUMENTO DE IDENTIDAD APP', '2', '4');
INSERT INTO `CardManagementSystem`.`collectionType` (`id`, `description`, `countryId`, `personTypeId`) VALUES ('21', 'FOTO CON DOCUMENTO DE IDENTIDAD APP', '82', '9');

UPDATE `CardManagementSystem`.`collectionType` SET `orden` = '1' WHERE (`id` = '9');
UPDATE `CardManagementSystem`.`collectionType` SET `orden` = '2' WHERE (`id` = '10');
UPDATE `CardManagementSystem`.`collectionType` SET `orden` = '1' WHERE (`id` = '18');
UPDATE `CardManagementSystem`.`collectionType` SET `orden` = '1' WHERE (`id` = '19');
UPDATE `CardManagementSystem`.`collectionType` SET `orden` = '2' WHERE (`id` = '20');
UPDATE `CardManagementSystem`.`collectionType` SET `orden` = '2' WHERE (`id` = '21');


INSERT INTO `CardManagementSystem`.`collectionsRequest` (`countryId`, `productTypeId`, `programId`, `personTypeId`, `collectionTypeId`) VALUES ('1', '1', '4', '3', '10');
INSERT INTO `CardManagementSystem`.`collectionsRequest` (`countryId`, `productTypeId`, `programId`, `personTypeId`, `collectionTypeId`) VALUES ('2', '1', '4', '4', '18');
INSERT INTO `CardManagementSystem`.`collectionsRequest` (`countryId`, `productTypeId`, `programId`, `personTypeId`, `collectionTypeId`) VALUES ('2', '1', '4', '4', '20');
INSERT INTO `CardManagementSystem`.`collectionsRequest` (`countryId`, `productTypeId`, `programId`, `personTypeId`, `collectionTypeId`) VALUES ('82', '1', '4', '9', '19');
INSERT INTO `CardManagementSystem`.`collectionsRequest` (`countryId`, `productTypeId`, `programId`, `personTypeId`, `collectionTypeId`) VALUES ('82', '1', '4', '9', '21');

-- Estatus de en la tabla statusapplicant
-- author: Yamelis Almea
-- Fecha: 008/12/2020

INSERT INTO `CardManagementSystem`.`statusApplicant` (`id`, `description`, `code`) VALUES ('6', 'TARJETA PENDIENTE', 'TARPEN');
INSERT INTO `CardManagementSystem`.`statusApplicant` (`id`, `description`, `code`) VALUES ('7', 'TARJETA ASIGNADA', 'TARASI');
INSERT INTO `CardManagementSystem`.`statusApplicant` (`id`, `description`, `code`) VALUES ('8', 'TARJETA PENDIENTE POR ASIGNAR', 'TPENAS');
INSERT INTO `CardManagementSystem`.`statusApplicant` (`id`, `description`, `code`) VALUES ('9', 'ASIGNADA AL CLIENTE', 'ASICLI');
INSERT INTO `CardManagementSystem`.`statusApplicant` (`id`, `description`, `code`) VALUES ('10', 'ERROR SOLICITUD PERSONALIZACION', 'ERDOPE');
INSERT INTO `CardManagementSystem`.`statusApplicant` (`id`, `description`, `code`) VALUES ('11', 'PENDIENTE PERSONALIZACION', 'PENPER');
