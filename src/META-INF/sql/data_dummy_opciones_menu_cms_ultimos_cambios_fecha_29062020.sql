
-- Autor· Yoan León
-- Fecha 29 Junio 2020
-- tabla permission -- ProductType
INSERT INTO `permission` (`permissionGroupId`,`action`,`entity`,`name`,`enabled`) VALUES 
(5,'listProductType.zul','productType','List Product Type',1),
(5,'adminProductType.zul?eventType=1','productType','Add Product Type',1),
(5,'adminProductType.zul?eventType=2','productType','Edit Product Type',1),
(5,'adminProductType.zul?eventType=4','productType','View Product Type',1);


-- Autor· Yoan León
-- Fecha 29 Junio 2020
-- tabla permission_data -- ProductType
INSERT INTO `permission_data` (`permissionId`,`languageId`,`alias`,`description`) VALUES 
(184,1,'Product Type','Product Type'),
(184,2,'Tipos de Producto','Tipos de Producto'),
(185,1,'Add Product Type','Add Product Type'),
(185,2,'Agregar Tipo de Producto','Agregar Tipo de Producto'),
(186,1,'Edit Product Type','Edit Product Type'),
(186,2,'Editar Tipo de Producto','Editar Tipo de Producto'),
(187,1,'View Product Type','View Product Type'),
(187,2,'Ver Tipo de Producto','Ver Tipo de Producto');




-- Autor· Lulymar Gutierrez
-- Fecha 03 Julio 2020
-- tabla permission -- CardUpdateReason
INSERT INTO CardManagementSystem.permission (`permissionGroupId`,`action`,`entity`,`name`,`enabled`) VALUES 
(4,'listCardUpdateReason.zul','cardUpdateReason','List Card Update Reason',1),
(4,'listCardUpdateReason.zul?eventType=1','cardUpdateReason','Add Card Update Reason',1),
(4,'listCardUpdateReason.zul?eventType=2','cardUpdateReason','Edit Card Update Reason',1),
(4,'listCardUpdateReason.zul?eventType=4','cardUpdateReason','View Card Update Reason',1);

-- Autor· Lulymar Gutierrez
-- Fecha 03 Julio 2020
-- tabla permission_data -- CardUpdateReason
INSERT INTO CardManagementSystem.permission_data (`permissionId`,`languageId`,`alias`,`description`) VALUES 
(188,1,'Card Update Reason','Card Update Reason'),
(188,2,'Motivos Actualizacion Tarjeta','Motivos Actualizacion Tarjeta'),
(189,1,'Add Card Update Reason','Add Card Update Reason'),
(189,2,'Agregar Motivos Actualizacion Tarjeta','Agregar Motivos Actualizacion Tarjeta'),
(190,1,'Edit Card Update Reason','Edit Card Update Reason'),
(190,2,'Editar Motivos Actualizacion Tarjeta','Editar Motivos Actualizacion Tarjeta'),
(191,1,'View Card Update Reason','View Card Update Reason'),
(191,2,'Ver Motivos Actualizacion Tarjeta','Ver Motivos Actualizacion Tarjeta');



