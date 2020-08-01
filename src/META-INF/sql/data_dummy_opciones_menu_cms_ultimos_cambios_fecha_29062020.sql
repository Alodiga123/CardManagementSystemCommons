
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



-- Autor· Lulymar Gutierrez
-- Fecha 06 Julio 2020
-- tabla permission -- cardStatusByReason
INSERT INTO CardManagementSystem.permission (`permissionGroupId`,`action`,`entity`,`name`,`enabled`) VALUES 
(4,'listCardStatusByReason.zul','cardStatusByReason','List Card Status By Reason',1),
(4,'listCardStatusByReason.zul?eventType=1','cardStatusByReason','Add Card Status By Reason',1),
(4,'listCardStatusByReason.zul?eventType=2','cardStatusByReason','Edit Card Status By Reason',1),
(4,'listCardStatusByReason.zul?eventType=4','cardStatusByReason','View Card Status By Reason',1);



-- Autor· Lulymar Gutierrez
-- Fecha 06 Julio 2020
-- tabla permission_data -- cardStatusByReason
INSERT INTO CardManagementSystem.permission_data (`permissionId`,`languageId`,`alias`,`description`) VALUES 
(192,1,'Card Status By Reason','Card Status By Reason'),
(192,2,'Estatus de la Tarjeta por Motivo','Estatus de la Tarjeta por Motivo'),
(193,1,'Add Card Status By Reason','Add Card Status By Reason'),
(193,2,'Agregar Estatus de la Tarjeta por Motivo','Agregar Estatus de la Tarjeta por Motivo'),
(194,1,'Edit Card Status By Reason','Edit Card Status By Reason'),
(194,2,'Editar Estatus de la Tarjeta por Motivo','Editar Estatus de la Tarjeta por Motivo'),
(195,1,'View Card Status By Reason','View Card Status By Reason'),
(195,2,'Ver Estatus de la Tarjeta por Motivo','Ver Estatus de la Tarjeta por Motivo');


-- Autor· Jorge Pinto
-- Fecha 20 Julio 2020
-- tabla permission -- EconomicActivities
INSERT INTO CardManagementSystem.permission (`permissionGroupId`,`action`,`entity`,`name`,`enabled`) VALUES 
(5,'ListEconomicActivity.zul','economicActivity','List Economic Activities',1),
(5,'adminEconomicActivity.zul?eventType=1','economicActivity','Add Economic Activity',1),
(5,'adminEconomicActivity.zul?eventType=2','economicActivity','Edit Economic Activity',1),
(5,'adminEconomicActivity.zul?eventType=4','economicActivity','View Economic Activity',1);

-- Autor· Jorge Pinto
-- Fecha 20 Julio 2020
-- tabla permission_data -- EconomicActivities
INSERT INTO CardManagementSystem.permission_data (`permissionId`,`languageId`,`alias`,`description`) VALUES 
(196,1,'Economic Activities','Economic Activities'),
(196,2,'Actividades Economicas','Actividades Económicas'),
(197,1,'Add Economic Activity','Add Economic Activity'),
(197,2,'Agregar Actividad Económica','Agregar Actividad Económica'),
(198,1,'Edit Economic Activity','Edit Economic Activity'),
(198,2,'Editar Actividad Económica','Editar Actividad Económica'),
(199,1,'View Economic Activity','View Economic Activity'),
(199,2,'Ver Actividad Económica','Ver Actividad Económica');


-- Autor· Jorge Pinto
-- Fecha 28 Julio 2020
-- tabla permission -- Employee
INSERT INTO CardManagementSystem.permission (`permissionGroupId`,`action`,`entity`,`name`,`enabled`) VALUES 
(1,'ListEmployee.zul','employee','List Employee',1),
(1,'adminEmployee.zul?eventType=1','employee','Add Employee',1),
(1,'adminEmployee.zul?eventType=2','employee','Edit Employee',1),
(1,'adminEmployee.zul?eventType=4','employee','View Employee',1),
(1,'ListEmployeePhone.zul','phonePerson','List Employee Phone',1),
(1,'adminEmployeePhone.zul?eventType=1','phonePerson','Add Employee Phone',1),
(1,'adminEmployeePhone.zul?eventType=2','phonePerson','Edit Employee Phone',1),
(1,'adminEmployeePhone.zul?eventType=4','phonePerson','View Employee',1);

-- Autor· Jorge Pinto
-- Fecha 28 Julio 2020
-- tabla permission_data -- Employee
INSERT INTO CardManagementSystem.permission_data (`permissionId`,`languageId`,`alias`,`description`) VALUES 
(200,1,'Employees','Employees'),
(200,2,'Empleados','EMpleados'),
(201,1,'Add Employee','Add Employee'),
(201,2,'Agregar Empleado','Agregar Empleado'),
(202,1,'Edit Employee','Edit Employee'),
(202,2,'Editar Empleado','Editar Empleado'),
(203,1,'View Employee','View Employee'),
(203,2,'Ver Empleado','Ver Empleado');
