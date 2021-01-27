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
INSERT INTO `CardManagementSystem`.`statusTransactionManagement` (`id`, `description`, `code`) VALUES ('1', 'PROCESS', 'PRO');

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

