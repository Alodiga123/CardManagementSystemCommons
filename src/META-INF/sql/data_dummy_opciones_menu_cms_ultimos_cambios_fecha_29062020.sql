
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





