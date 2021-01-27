-- Agregar tipo de transacción "COBRO TARIFA CMS"
-- author: Jesús Gómez
-- Fecha: 25/01/2021
INSERT INTO `CardManagementSystem`.`transaction` 
(`id`, `code`, `description`, `indMonetaryType`, `indTransactionPurchase`, `indVariationRateChannel`) 
VALUES ('25', '120', 'COBRO TARIFA CMS', '1', '0', '0');