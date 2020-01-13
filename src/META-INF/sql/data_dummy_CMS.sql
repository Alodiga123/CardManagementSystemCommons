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



















