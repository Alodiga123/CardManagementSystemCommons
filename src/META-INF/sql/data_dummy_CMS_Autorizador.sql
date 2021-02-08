-- Agregar tipo de transacción "COBRO TARIFA CMS"
-- author: Jesús Gómez
-- Fecha: 25/01/2021
INSERT INTO `CardManagementSystem`.`transaction` 
(`id`, `code`, `description`, `indMonetaryType`, `indTransactionPurchase`, `indVariationRateChannel`) 
VALUES ('25', '120', 'COBRO TARIFA CMS', '1', '0', '0');


-- Agregar Data dummy para hacer pruebas para obtener el currentBalance de una tarjeta
-- author: Jorge Pinto
-- Fecha: 26/01/2021

--Insertar un status de la transaction
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`id`, `description`, `code`) VALUES ('1', 'PROCESS', 'PROCES');

SET @CardID = 0;
SELECT MAX(c.id) INTO @CardID FROM `CardManagementSystem`.`card` c;

SET @ChannelID = 0;
SELECT MAX(c.id) INTO @ChannelID FROM `CardManagementSystem`.`channel` c WHERE name like "POS";

SET @CurrencyID = 0;
SELECT MAX(c.id) INTO @CurrencyID FROM `CardManagementSystem`.`currency` c WHERE symbol like "USD";

SET @CityID = 0;
SELECT MAX(c.id) INTO @CityID FROM `CardManagementSystem`.`city` c where stateId = 1;

SET @StatusTransactionID = 0;
SELECT MAX(s.id) INTO @StatusTransactionID FROM `CardManagementSystem`.`statusTransactionManagement` s;

SET @IssuerID = 0;
SELECT MAX(i.id) INTO @IssuerID FROM `CardManagementSystem`.`statusTransactionManagement` i;

--Insertar un data dummy para transactionsManagement
INSERT INTO `CardManagementSystem`.`transactionsManagement` ( `acquirerTerminalCode`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`,`transactionCityId`,`statusTransactionManagementId`,`cardNumber`,`cardHolder`,`CVV`,`expirationCardDate`,`pinLenght`,`acquirerId`,`issuerId`,`mccCodeTrade`,`systemTraceAuditNumber`,`numberMovementsCheckBalance`,`responseCode`,`createDate`,`updateDate`)
VALUES ('100', '100', '10101', '1', @ChannelID ,@CityID, @StatusTransactionID, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,NULL,NULL);

SET @TransactionsManagementID = 0;
SELECT MAX(t.id) INTO @TransactionsManagementID FROM `CardManagementSystem`.`transactionsManagement` t;

-- Insertar data en balanceHistoryCard
INSERT INTO `CardManagementSystem`.`balanceHistoryCard` (`cardUserId`, `transactionsManagementId`, `previousBalance`, `currentBalance`, `createDate`, `updateDate`) 
VALUES (@CardID, @TransactionsManagementID, '500', '400', '2021-01-27 00:00:00', NULL);

-- Agregar data en la tablas transactionManagement y transactionManagementHistory
-- author: Jesús Gómez
-- Fecha: 28/01/2021
INSERT INTO `CardManagementSystem`.`transactionsManagement` (`acquirerCountryId`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`, `dateTransaction`, `dateTimeTransmissionTerminal`, `localTimeTransaction`, `localDateTransaction`, `settlementTransactionAmount`, `acquirerCommisionAmount`, `acquirerSettlementCommissionAmount`, `statusTransactionManagementId`, `cardNumber`, `cardHolder`, `CVV`, `expirationCardDate`, `responseCode`) 
VALUES 
('484', 'TRA-01', 'ACMS-034-2021-1', '6', '1', '2021-01-04', NULL,NULL, NULL, 35.42, 2, 0.12, 1, '5412589633874522', 'CARLOS ALVARADO P', '035', '1024', '00'),
('484', 'TRA-02', 'ACMS-034-2021-2', '6', '1', '2021-01-07', NULL,NULL, NULL, 105.3, 2, 0.12, 1, '5412581258963325', 'PEDRO GONZALEZ A', '721', '0822', '00');

INSERT INTO `CardManagementSystem`.`transactionsManagementHistory` (`acquirerCountryId`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`, `dateTransaction`, `dateTimeTransmissionTerminal`, `localTimeTransaction`, `localDateTransaction`, `settlementTransactionAmount`, `acquirerCommisionAmount`, `acquirerSettlementCommissionAmount`, `statusTransactionManagementId`, `cardNumber`, `cardHolder`, `CVV`, `expirationCardDate`, `responseCode`) 
VALUES ('484', 'TRA-01', 'ACMS-034-2021-1', '6', '1', '2021-01-04', NULL,NULL, NULL, 35.42, 2, 0.12, 1, '5412589633874522', 'CARLOS ALVARADO P', '035', '1024', '00');

-- Agregar transacción "TARIFA_TRANSACCION_CMS"
-- author: Jesús Gómez
-- Fecha: 29/01/2021
INSERT INTO `CardManagementSystem`.`transaction` (`id`,`code`,`description`,`indMonetaryType`,`indTransactionPurchase`,`indVariationRateChannel`)
VALUES (25,"050","TARIFA_TRANSACCION_CMS",1,0,1);

INSERT INTO `CardManagementSystem`.`documentType` (`id`, `name`, `acronym,`) 
VALUES (7, 'TRANSACTION FEE CMS', 'TFCMS');


INSERT INTO `CardManagementSystem`.`sequences` (`initialValue`, `currentValue`, `documentType_id`, `originApplicationId`) 
VALUES ('1', '1', '7', '1');

-- DATA INICIAL para tabla statusTransactionManagement
-- author: Jesús Gómez
-- Fecha: 29/01/2021
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`description`, `code`) VALUES ('IN PROCESS', 'INPROC');
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`description`, `code`) VALUES ('APPROVED', 'APPROV');
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`description`, `code`) VALUES ('REJECTED', 'REJECT');
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`description`, `code`) VALUES ('CANCELLED', 'CANCELLED'),
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`description`, `code`) VALUES ('CLOSED', 'CLOSED');


-- Agregar data en la tablas producthaschannelhastransaction Y transactionManagementHistory
-- author: Yamelis Almea
-- Fecha: 29/01/2021

INSERT INTO `cardmanagementsystem`.`producthaschannelhastransaction` (`id`, `maximumNumberTransactionsDaily`, `maximumNumberTransactionsMonthly`, `amountMinimumTransactionDomestic`, `amountMaximumTransactionDomestic`, `amountMinimumTransactionInternational`, `amountMaximumTransactionInternational`, `dailyAmountLimitDomestic`, `monthlyAmountLimitDomestic`, `dailyAmountLimitInternational`, `monthlyAmountLimitInternational`, `productUseId`, `transactionId`, `channelId`, `productId`) VALUES ('17', '10', '20', '1000', '2000', '2000', '20000', '10', '20', '5', '10', '3', '6', '1', '2');

UPDATE `cardmanagementsystem`.`producthaschannelhastransaction` SET `amountMinimumTransactionDomestic` = '100', `amountMinimumTransactionInternational` = '200', `amountMaximumTransactionInternational` = '2000', `dailyAmountLimitDomestic` = '1000', `monthlyAmountLimitDomestic` = '2000', `dailyAmountLimitInternational` = '2000', `monthlyAmountLimitInternational` = '5000' WHERE (`id` = '17');

INSERT INTO `CardManagementSystem`.`transactionsManagementHistory` (`acquirerCountryId`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`, `dateTransaction`, `dateTimeTransmissionTerminal`, `localTimeTransaction`, `localDateTransaction`, `settlementTransactionAmount`, `acquirerCommisionAmount`, `acquirerSettlementCommissionAmount`, `statusTransactionManagementId`, `cardNumber`, `cardHolder`, `CVV`, `expirationCardDate`, `responseCode`) 
VALUES ('484', 'TRA-02', 'ACMS-034-2021-1', '6', '1', '2021-01-04', NULL,NULL, NULL, 35.42, 2, 0.12, 1, '5412156874009834', 'Bella Mijares', '123', '0823', '00');

INSERT INTO `CardManagementSystem`.`transactionsManagementHistory` (`acquirerCountryId`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`, `dateTransaction`, `dateTimeTransmissionTerminal`, `localTimeTransaction`, `localDateTransaction`, `settlementTransactionAmount`, `acquirerCommisionAmount`, `acquirerSettlementCommissionAmount`, `statusTransactionManagementId`, `cardNumber`, `cardHolder`, `CVV`, `expirationCardDate`, `responseCode`) 
VALUES ('484', 'TRA-03', 'ACMS-034-2021-1', '6', '1', '2021-01-04', NULL,NULL, NULL, 35.42, 2, 0.12, 1, '5412156874009834', 'Bella Mijares', '123', '0823', '00');

INSERT INTO `CardManagementSystem`.`transactionsManagementHistory` (`acquirerCountryId`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`, `dateTransaction`, `dateTimeTransmissionTerminal`, `localTimeTransaction`, `localDateTransaction`, `settlementTransactionAmount`, `acquirerCommisionAmount`, `acquirerSettlementCommissionAmount`, `statusTransactionManagementId`, `cardNumber`, `cardHolder`, `CVV`, `expirationCardDate`, `responseCode`) 
VALUES ('484', 'TRA-04', 'ACMS-034-2021-1', '6', '1', '2021-01-04', NULL,NULL, NULL, 35.42, 2, 0.12, 1, '5412156874009834', 'Bella Mijares', '123', '0823', '00');

INSERT INTO `CardManagementSystem`.`transactionsManagementHistory` (`acquirerCountryId`, `transactionNumberAcquirer`, `transactionNumberIssuer`, `transactionTypeId`, `channelId`, `dateTransaction`, `dateTimeTransmissionTerminal`, `localTimeTransaction`, `localDateTransaction`, `settlementTransactionAmount`, `acquirerCommisionAmount`, `acquirerSettlementCommissionAmount`, `statusTransactionManagementId`, `cardNumber`, `cardHolder`, `CVV`, `expirationCardDate`, `responseCode`) 
VALUES ('484', 'TRA-05', 'ACMS-034-2021-1', '6', '1', '2021-01-04', NULL,NULL, NULL, 35.42, 2, 0.12, 1, '5412156874009834', 'Bella Mijares', '123', '0823', '00');

-- data inicial de la tabla subTransactionType
-- Atualizar los tipos de transacción agregando el sub tipo de transacción
-- author: Jesús Gómez
-- Fecha: 02/02/2021 

INSERT INTO `CardManagementSystem`.`subTypeTransaction` (`description`, `code`) VALUES ('Administrative', 'ADMINI');
INSERT INTO `CardManagementSystem`.`subTypeTransaction` (`description`, `code`) VALUES ('Debit', 'DEBIT');
INSERT INTO `CardManagementSystem`.`subTypeTransaction` (`description`, `code`) VALUES ('Credit', 'CREDIT');

UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='3' WHERE `id`='1';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='3' WHERE `id`='2';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='2' WHERE `id`='3';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='2' WHERE `id`='4';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='2' WHERE `id`='5';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='2' WHERE `id`='6';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='3' WHERE `id`='7';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='1' WHERE `id`='8';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='3' WHERE `id`='9';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='1' WHERE `id`='10';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='1' WHERE `id`='23';
UPDATE `CardManagementSystem`.`transaction` SET `subTypeTransactionId`='3' WHERE `id`='24';
UPDATE `CardManagementSystem`.`transaction` SET `description`='COMISION_TRANSACCION_CMS', `subTypeTransactionId`='3' WHERE `id`='25';

-- Generar los documentType para las transacciones Comision CMS y Activación de Tarjeta
-- author: Jesús Gómez
-- Fecha: 05/02/2021 
UPDATE `CardManagementSystem`.`documentType` SET `name`='COMMISION CMS', `acronym`='COMCMS' WHERE `id`='7';
INSERT INTO `CardManagementSystem`.`documentType` (`id`,`name`, `acronym`) VALUES (8,'ACTIVATION CARD', 'ACTCAR');