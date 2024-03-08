-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.3.0 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para practica
CREATE DATABASE IF NOT EXISTS `practica` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `practica`;

-- Volcando estructura para tabla practica.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) NOT NULL,
  `LastName` varchar(150) NOT NULL,
  `ShippingStreet` varchar(255) DEFAULT NULL,
  `ShippingCity` varchar(255) DEFAULT NULL,
  `ShippingCountry` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.clients: ~10 rows (aproximadamente)
INSERT INTO `clients` (`ID`, `Name`, `LastName`, `ShippingStreet`, `ShippingCity`, `ShippingCountry`) VALUES
	(1, 'John', 'Doe', '123 Main St', 'Cityville', 'Countryland'),
	(2, 'Jane', 'Smith', '456 Oak St', 'Townsville', 'Countryland'),
	(3, 'Alice', 'Johnson', '789 Pine St', 'Villageton', 'Countryland'),
	(4, 'Bob', 'Williams', '101 Maple St', 'Hamletville', 'Countryland'),
	(5, 'Eva', 'Davis', '202 Elm St', 'Cityburg', 'Countryland'),
	(6, 'Carlos', 'Martinez', '303 Birch St', 'Villageburg', 'Countryland'),
	(7, 'Olivia', 'Taylor', '404 Cedar St', 'Townburg', 'Countryland'),
	(8, 'David', 'Brown', '505 Spruce St', 'Hamletburg', 'Countryland'),
	(9, 'Sophia', 'Miller', '606 Walnut St', 'Cityton', 'Countryland'),
	(10, 'Matthew', 'Jones', '707 Oak St', 'Villagetown', 'Countryland');

-- Volcando estructura para tabla practica.orderlineitems
CREATE TABLE IF NOT EXISTS `orderlineitems` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `OrderID` int NOT NULL,
  `ProductID` int NOT NULL,
  `UnitPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `OrderID` (`OrderID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `orderlineitems_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`ID`),
  CONSTRAINT `orderlineitems_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.orderlineitems: ~30 rows (aproximadamente)
INSERT INTO `orderlineitems` (`ID`, `OrderID`, `ProductID`, `UnitPrice`) VALUES
	(1, 1, 3, 40.00),
	(2, 1, 5, 25.00),
	(3, 1, 9, 25.00),
	(4, 1, 13, 25.00),
	(6, 2, 2, 70.00),
	(7, 2, 6, 39.99),
	(8, 2, 11, 74.99),
	(9, 2, 14, 89.99),
	(10, 3, 3, 49.99),
	(11, 3, 11, 74.99),
	(12, 3, 12, 50.00),
	(13, 3, 15, 14.99),
	(14, 3, 18, 49.99),
	(15, 3, 20, 79.99),
	(24, 33, 6, 39.99),
	(38, 42, 3, 49.99),
	(39, 42, 1, 20.00),
	(40, 42, 4, 19.99),
	(42, 43, 12, 50.00),
	(43, 43, 20, 79.99),
	(44, 43, 17, 19.99),
	(45, 43, 2, 70.00),
	(46, 44, 11, 74.99),
	(47, 44, 19, 89.99),
	(48, 37, 13, 10.00),
	(53, 46, 14, 89.99),
	(57, 49, 3, 40.00),
	(58, 49, 11, 74.99),
	(59, 49, 11, 74.99),
	(62, 50, 3, 40.00),
	(63, 51, 3, 45.00);

-- Volcando estructura para tabla practica.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int NOT NULL,
  `TotalPrice` decimal(10,2) DEFAULT '0.00',
  `ShippingStreet` varchar(255) DEFAULT NULL,
  `ShippingCity` varchar(255) DEFAULT NULL,
  `ShippingCountry` varchar(255) DEFAULT NULL,
  `Status` varchar(100) DEFAULT 'Draft',
  PRIMARY KEY (`ID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `clients` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.orders: ~11 rows (aproximadamente)
INSERT INTO `orders` (`ID`, `ClientID`, `TotalPrice`, `ShippingStreet`, `ShippingCity`, `ShippingCountry`, `Status`) VALUES
	(1, 1, 115.00, '123 Main St', 'Cityville', 'Countryland', 'Sent'),
	(2, 3, 274.97, '789 Pine St', 'Villageton', 'Countryland', 'Completed'),
	(3, 5, 319.95, '202 Elm St', 'Cityburg', 'Countryland', 'Completed'),
	(33, 1, 39.99, '123 Main St', 'Cityville', 'Countryland', 'Accepted'),
	(37, 10, 10.00, '707 Oak St', 'Villagetown', 'Countryland', 'Sent'),
	(42, 1, 89.98, '123 Main St', 'Cityville', 'Countryland', 'Completed'),
	(43, 7, 219.98, '404 Cedar St', 'Townburg', 'Countryland', 'Completed'),
	(44, 6, 164.98, '303 Birch St', 'Villageburg', 'Countryland', 'Completed'),
	(46, 8, 89.99, '505 Spruce St', 'Hamletburg', 'Countryland', 'Completed'),
	(49, 5, 189.98, '202 Elm St', 'Cityburg', 'Countryland', 'Completed'),
	(50, 8, 40.00, '505 Spruce St', 'Hamletburg', 'Countryland', 'Sent'),
	(51, 8, 40.00, '505 Spruce St', 'Hamletburg', 'Countryland', 'Draft');

-- Volcando estructura para tabla practica.products
CREATE TABLE IF NOT EXISTS `products` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.products: ~21 rows (aproximadamente)
INSERT INTO `products` (`ID`, `ProductName`, `Price`) VALUES
	(1, 'Balón de Baloncesto Nike', 30.00),
	(2, 'Zapatillas de Baloncesto Adidas', 70.00),
	(3, 'Camiseta Oficial del Equipo', 45.00),
	(4, 'Gorra con Logo del Equipo', 19.99),
	(5, 'Pantalones Cortos de Entrenamiento', 34.99),
	(6, 'Mochila para Equipos de Baloncesto', 39.99),
	(7, 'Calcetines Técnicos para Baloncesto', 15.00),
	(8, 'Botella de Agua Deportiva', 12.99),
	(9, 'Toalla de Microfibra para Entrenamiento', 17.99),
	(10, 'Sudadera con Capucha del Equipo', 54.99),
	(11, 'Chaqueta Impermeable para Entrenamientos', 73.00),
	(12, 'Rodilleras de Compresión', 50.00),
	(13, 'Cinta para la Cabeza de Baloncesto', 10.00),
	(14, 'Entrenador de Baloncesto Portátil', 89.99),
	(15, 'Conos de Entrenamiento (Set de 10)', 14.99),
	(16, 'Reloj Deportivo con GPS', 129.99),
	(17, 'Banda de Resistencia para Ejercicios', 19.99),
	(18, 'Tabla de Tiro de Baloncesto', 49.99),
	(19, 'Entrenador Virtual de Tiro', 159.99),
	(20, 'Poster Firmado por el Jugador Estrella', 79.99),
	(21, 'Gastos de envío', 4.99);

-- Volcando estructura para tabla practica.shipmentitems
CREATE TABLE IF NOT EXISTS `shipmentitems` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ShipmentID` int NOT NULL,
  `ProductID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ShipmentID` (`ShipmentID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `shipmentitems_ibfk_1` FOREIGN KEY (`ShipmentID`) REFERENCES `shipments` (`ID`),
  CONSTRAINT `shipmentitems_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.shipmentitems: ~30 rows (aproximadamente)
INSERT INTO `shipmentitems` (`ID`, `ShipmentID`, `ProductID`) VALUES
	(28, 58, 3),
	(29, 58, 8),
	(30, 58, 12),
	(31, 58, 15),
	(32, 58, 18),
	(33, 58, 20),
	(34, 59, 2),
	(35, 59, 7),
	(36, 59, 11),
	(37, 59, 14),
	(38, 60, 3),
	(39, 60, 1),
	(40, 60, 4),
	(41, 61, 12),
	(42, 61, 20),
	(43, 61, 17),
	(44, 61, 2),
	(45, 62, 11),
	(46, 62, 14),
	(47, 63, 14),
	(48, 64, 3),
	(49, 64, 5),
	(50, 64, 9),
	(51, 64, 13),
	(52, 65, 3),
	(53, 65, 11),
	(54, 65, 11),
	(55, 66, 3),
	(56, 66, 11),
	(57, 66, 11),
	(58, 67, 3),
	(59, 70, 13);

-- Volcando estructura para tabla practica.shipments
CREATE TABLE IF NOT EXISTS `shipments` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int NOT NULL,
  `OrderID` int NOT NULL,
  `ShippingStreet` varchar(255) DEFAULT NULL,
  `ShippingCity` varchar(255) DEFAULT NULL,
  `ShippingCountry` varchar(255) DEFAULT NULL,
  `Status` varchar(100) DEFAULT 'New',
  PRIMARY KEY (`ID`),
  KEY `ClientID` (`ClientID`),
  KEY `OrderID` (`OrderID`),
  CONSTRAINT `shipments_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `clients` (`ID`),
  CONSTRAINT `shipments_ibfk_2` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.shipments: ~11 rows (aproximadamente)
INSERT INTO `shipments` (`ID`, `ClientID`, `OrderID`, `ShippingStreet`, `ShippingCity`, `ShippingCountry`, `Status`) VALUES
	(57, 3, 2, '789 Pine St', 'Villageton', 'Countryland', 'Delivered'),
	(58, 5, 3, '202 Elm St', 'Cityburg', 'Countryland', 'Delivered'),
	(59, 3, 2, '789 Pine St', 'Villageton', 'Countryland', 'Delivered'),
	(60, 1, 42, '123 Main St', 'Cityville', 'Countryland', 'Delivered'),
	(61, 7, 43, '404 Cedar St', 'Townburg', 'Countryland', 'Delivered'),
	(62, 6, 44, '303 Birch St', 'Villageburg', 'Countryland', 'Delivered'),
	(63, 8, 46, '505 Spruce St', 'Hamletburg', 'Countryland', 'Delivered'),
	(64, 1, 1, '123 Main St', 'Cityville', 'Countryland', 'New'),
	(65, 5, 49, '202 Elm St', 'Cityburg', 'Countryland', 'Delivered'),
	(66, 5, 49, '202 Elm St', 'Cityburg', 'Countryland', 'Delivered'),
	(67, 8, 50, '505 Spruce St', 'Hamletburg', 'Countryland', 'New'),
	(69, 6, 50, '505 Spruce St', 'Hamletburg', 'Countryland', 'New'),
	(70, 10, 37, '707 Oak St', 'Villagetown', 'Countryland', 'New');

-- Volcando estructura para tabla practica.workorderitems
CREATE TABLE IF NOT EXISTS `workorderitems` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `WorkOrderID` int NOT NULL,
  `ProductID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `WorkOrderID` (`WorkOrderID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `workorderitems_ibfk_1` FOREIGN KEY (`WorkOrderID`) REFERENCES `workorders` (`ID`),
  CONSTRAINT `workorderitems_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.workorderitems: ~29 rows (aproximadamente)
INSERT INTO `workorderitems` (`ID`, `WorkOrderID`, `ProductID`) VALUES
	(76, 10, 2),
	(77, 10, 7),
	(78, 10, 11),
	(79, 10, 14),
	(80, 11, 3),
	(81, 11, 8),
	(82, 11, 12),
	(83, 11, 15),
	(84, 11, 18),
	(85, 11, 20),
	(86, 13, 6),
	(87, 14, 3),
	(88, 14, 1),
	(89, 14, 4),
	(90, 15, 12),
	(91, 15, 20),
	(92, 15, 17),
	(93, 15, 2),
	(94, 16, 11),
	(95, 16, 14),
	(96, 17, 14),
	(97, 18, 13),
	(98, 19, 3),
	(99, 19, 5),
	(100, 19, 9),
	(101, 19, 13),
	(102, 20, 3),
	(103, 20, 11),
	(104, 20, 11),
	(105, 22, 3);

-- Volcando estructura para tabla practica.workorders
CREATE TABLE IF NOT EXISTS `workorders` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `OrderID` int NOT NULL,
  `Status` varchar(100) DEFAULT 'New',
  PRIMARY KEY (`ID`),
  KEY `OrderID` (`OrderID`),
  CONSTRAINT `workorders_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla practica.workorders: ~10 rows (aproximadamente)
INSERT INTO `workorders` (`ID`, `OrderID`, `Status`) VALUES
	(10, 2, 'Completed'),
	(11, 3, 'Completed'),
	(13, 33, 'New'),
	(14, 42, 'Completed'),
	(15, 43, 'Completed'),
	(16, 44, 'Completed'),
	(17, 46, 'Completed'),
	(18, 37, 'Completed'),
	(19, 1, 'Completed'),
	(20, 49, 'Completed'),
	(22, 50, 'Completed');

-- Volcando estructura para procedimiento practica.CalculateAllOrderPrice
DELIMITER //
CREATE PROCEDURE `CalculateAllOrderPrice`()
BEGIN
/*Este procedimiento no es totalmente necesario, hace lo mismo que OrderLineItems
pero usando un cursos para poner correctamente los precios de todos los orders.
Lo cree como un refuerzo mientras lo hacia para corregir cosas que quedaban mal si
cometia errores a la hora de poner el precio correcto y decidi dejarlo aquí porque
no molesta*/

	DECLARE OrdenID INT;
	DECLARE OrderFinal DECIMAL(10,2) DEFAULT 0.0;
	DECLARE cur_finished INT DEFAULT FALSE;
	
	DECLARE cur_var CURSOR FOR
		SELECT orderlineitems.OrderID, SUM(orderlineitems.UnitPrice)
		FROM orderlineitems 
		GROUP BY orderlineitems.OrderID;
	
	DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET cur_finished = TRUE;
	
	OPEN cur_var;
	
	label1:LOOP
		FETCH cur_var INTO OrdenID, OrderFinal;
		IF(cur_finished)THEN
			LEAVE label1;
		END IF;	
		If(orderFinal IS NULL) then
			SET orderFinal = 0.0;
		END IF;
		UPDATE orders
		SET orders.TotalPrice = orderFinal
		WHERE ID = OrdenID;
	END LOOP;
	
	CLOSE cur_var;
END//
DELIMITER ;

-- Volcando estructura para procedimiento practica.CalculateOrderPrice
DELIMITER //
CREATE PROCEDURE `CalculateOrderPrice`(
	IN `OrderIDParam` INT
)
BEGIN

/*Este procedimiento se encarga de recalcular el precio total de un order,
lo llamo desde 4 lugares diferentes, los 3 disparadores after-insert, update
y delete de OrderLineItems y también en el procedimiento OrderLineItemsPrice*/

	
	DECLARE orderFinal DECIMAL(10,2);
	-- Sumamos el precio de los productos de la tabla OrderLineItems con una misma orderID y lo asignamos a nuestra variable
	SELECT SUM(orderlineitems.UnitPrice) INTO orderFinal
	FROM orderlineitems
	WHERE orderlineitems.OrderID = OrderIDParam;
	-- Para evitar que si cuando insertamos o hacemos algun canvio dentro de orderlineitems con la orderID que damos como parámetro la suma es 0 la variable coja un valor null,
	-- la ponemos en 0 en caso de ser NULL.
	-- Se podría dar sobre todo a la hora de eliminar orderlineitems
	IF(orderFinal IS NULL) THEN
		SET orderFinal = 0.0;
	END IF;
	
	-- Actualizamos el precio de orders

	UPDATE orders
	SET orders.TotalPrice = orderFinal
	WHERE orders.ID = orderIDParam;
	
END//
DELIMITER ;

-- Volcando estructura para procedimiento practica.OrderLineItemsPrice
DELIMITER //
CREATE PROCEDURE `OrderLineItemsPrice`(
	IN `precio` DECIMAL(10,2),
	IN `productIDvar` INT
)
BEGIN

/*Este procedimiento nos servirá para cambiar los UnitPrice de orderlineitems
cuando cambiemos el precio de un producto, siempre y cuando el order donde esta incluido
el producto tenga el estado Draft, es llamado desde el disparador after update products*/

	DECLARE orderIDvar INT;
	DECLARE orderlineitemsIDvar INT;
	DECLARE Statusorder VARCHAR(20);
	DECLARE cur_finished INT DEFAULT FALSE;
	
	DECLARE cur_var CURSOR FOR
		SELECT orderlineitems.OrderID, orders.Status, orderlineitems.ID
		FROM orders
		JOIN orderlineitems ON orderlineitems.orderID = orders.ID
		WHERE orderlineitems.ProductID = productIDvar AND orders.`Status` = 'Draft';
	
	DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET cur_finished = TRUE;
	
	OPEN cur_var;
	bucleNuevoPrecio: LOOP
		
		FETCH cur_var INTO orderIDvar, statusorder, orderlineitemsIDvar;
		
		IF cur_finished THEN
			LEAVE bucleNuevoPrecio;
		END IF;
		
		
		UPDATE orderlineitems
		SET orderlineitems.UnitPrice = precio
		WHERE orderlineitems.ID = orderlineitemsIDvar;	
		CALL CalculateOrderPrice(orderIDvar);
		
	END LOOP;
	
	CLOSE cur_var;
	

END//
DELIMITER ;

-- Volcando estructura para procedimiento practica.ShipmentItemsProcedure
DELIMITER //
CREATE PROCEDURE `ShipmentItemsProcedure`(
	IN `ShipmentIDvar` INT,
	IN `OrderIDvar` INT
)
BEGIN

/*Este procedimiento coge todas las workorderitems de un workorder, cada una asociada a un producto,
y las introduce dentro de shipmentitems.*/

   DECLARE productoID INT;
	DECLARE cur_finished INT DEFAULT FALSE;   
	
	DECLARE cur_var CURSOR FOR
  		SELECT workorderitems.ProductID 
		FROM workorderitems
		JOIN workorders ON workorderitems.WorkOrderID = workorders.ID
  		WHERE workorders.OrderID = OrderIDvar;   
	
	DECLARE CONTINUE HANDLER FOR NOT FOUND
   	SET cur_finished = TRUE;   
	OPEN cur_var;
  	
   bucleShipmentItems: LOOP
  	   FETCH cur_var INTO productoID;
  		IF cur_finished THEN
  			LEAVE bucleShipmentItems;
  		END IF;
  	
  		INSERT INTO ShipmentItems (ShipmentID, productID)
		VALUES(ShipmentIDvar, productoID);
   END LOOP;   
	
	CLOSE cur_var;

END//
DELIMITER ;

-- Volcando estructura para procedimiento practica.ShipmentsProcedure
DELIMITER //
CREATE PROCEDURE `ShipmentsProcedure`(
	IN `OrderIDVar` INT
)
BEGIN
	
/*Este procedimiento inserta un shipment, lo llamaremos en el disparados after update wororderS*/
	
	DECLARE ClientIDvar INT;
	DECLARE OrdenID INT;
	DECLARE calle VARCHAR(255);
	DECLARE ciudad VARCHAR(255);
   DECLARE pais VARCHAR(255);

  	SELECT orders.ClientID, orders.ID, orders.ShippingStreet, orders.ShippingCity, orders.ShippingCountry
  		INTO ClientIDvar, OrdenID, calle, ciudad, pais
  		FROM orders
		WHERE orders.ID = OrderIDvar;

  	INSERT INTO shipments(ClientID, OrderID, ShippingStreet, ShippingCity, ShippingCountry) 
	VALUES(ClientIDvar, OrdenID, calle, ciudad, pais);

END//
DELIMITER ;

-- Volcando estructura para procedimiento practica.ShipmentsStatus
DELIMITER //
CREATE PROCEDURE `ShipmentsStatus`(
	IN `OrderIDvar` INT
)
BEGIN

/*Este procedimiento se debe a que en el ejercicio 7 deja caer que puede haber más de un shipment
para un mismo order, por tanto, para poder pasar el order a 'completed' nos deberemos asegurar
de que todos los shipment asociados a este order estan en 'delivered'. Lo llamo desde
el disparador after update shipments. */


	DECLARE estadoenvio VARCHAR(255);
	DECLARE todoBien BOOLEAN DEFAULT TRUE;
	DECLARE cur_finished INT DEFAULT FALSE;
	
	DECLARE cur_shipments CURSOR FOR
	
		SELECT shipments.`Status`
		FROM shipments
		WHERE shipments.OrderID = OrderIDvar;
		
	DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET cur_finished = TRUE;
	
	OPEN cur_shipments;
	
	bucleShipments: LOOP
	
		FETCH cur_shipments INTO estadoenvio;
		IF cur_finished OR NOT todoBien THEN
			LEAVE bucleShipments;
		END IF;
		-- Si encontramos un solo shipment al order con estado diferente a 'delivered' cambiaremos el booleano a falso.
		-- Si el booleanos es falso saldremos a la siguiente itración en lugar de seguir dando vueltas.
		IF estadoenvio <> 'Delivered' THEN
			SET todoBien = FALSE;
		END IF;
		
	END LOOP;
	
	-- Si después de comprobar todo el booleano sigue siendo verdadero, entonces actualizaremos el estado del order.
	IF todoBien THEN
		UPDATE Orders
		SET orders.`Status` = 'Completed'
		WHERE orders.ID = OrderIDvar;
	END IF;
	
	CLOSE cur_Shipments;
	
END//
DELIMITER ;

-- Volcando estructura para procedimiento practica.WorkOrderItemsProcedure
DELIMITER //
CREATE PROCEDURE `WorkOrderItemsProcedure`(
	IN `WorkOrderIDvar` INT,
	IN `OrderIDvar` INT
)
BEGIN

/*Este procedimiento coge todas las orderlineitems asociadas a un mismo orders, cada una de ellas
asociadas a un productos y las introduce dentro de workorderitems. Lo llamo desde el disparador 
after update orders*/

   DECLARE productoID INT;
	DECLARE cur_finished INT DEFAULT FALSE;   
	DECLARE cur_var CURSOR FOR
  		SELECT orderlineitems.ProductID FROM orderlineitems
  		WHERE orderlineitems.OrderID = OrderIDvar;   
	
	DECLARE CONTINUE HANDLER FOR NOT FOUND
   	SET cur_finished = TRUE;  
		
	OPEN cur_var;
  	
   bucleWorkOrder: LOOP
  	   FETCH cur_var INTO productoID;
  		IF cur_finished THEN
  			LEAVE bucleWorkOrder;
  		END IF;
  		-- Consiste en una inserción para cada orderlineitem que tenga la orderID asocidada que estamos llamando

  		
  		INSERT INTO workorderitems (WorkOrderID, productID)
		VALUES(WorkOrderIDvar, productoID);
   END LOOP;   
	CLOSE cur_var;

END//
DELIMITER ;

-- Volcando estructura para disparador practica.orderlineitems_after_delete
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orderlineitems_after_delete` AFTER DELETE ON `orderlineitems` FOR EACH ROW BEGIN
-- Parte 1 Ejercicio 2
	CALL CalculateOrderPrice(OLD.OrderID);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orderlineitems_after_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orderlineitems_after_insert` AFTER INSERT ON `orderlineitems` FOR EACH ROW BEGIN
-- Parte 1 Ejercicio 2
	CALL CalculateOrderPrice(NEW.OrderID);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orderlineitems_after_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orderlineitems_after_update` AFTER UPDATE ON `orderlineitems` FOR EACH ROW BEGIN
-- Parte 1 Ejercicio 2
	IF(OLD.ProductID <> NEW.ProductID) THEN
		CALL CalculateOrderPrice(NEW.OrderID);
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orderlineitems_before_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orderlineitems_before_insert` BEFORE INSERT ON `orderlineitems` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 3 y parte 2 ejercicio 7

	DECLARE statusorder VARCHAR(255);
	DECLARE precio DECIMAL(10,2);
	
	SELECT orders.Status
	INTO statusorder
	FROM orders
	WHERE orders.ID = NEW.OrderID;
	
	SELECT products.Price 
	INTO precio
	FROM products 
	WHERE products.ID = NEW.ProductID;
	
	IF(statusorder = 'Draft') THEN
		SET NEW.UnitPrice = precio;
	ELSE
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'No es posible insertar productos en un pedido que no tenga el estado Draft';
	END IF;
	
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orderlineitems_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orderlineitems_before_update` BEFORE UPDATE ON `orderlineitems` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 3

	DECLARE precio DECIMAL(10,2);
	DECLARE statusorder VARCHAR(255);
	
	SELECT orders.Status
	INTO statusorder
	FROM orders
	WHERE orders.ID = NEW.OrderID;
	
	SELECT products.Price
	INTO precio
	FROM products
	WHERE products.ID = NEW.ProductID;
	
	IF((OLD.ProductID <> NEW.ProductID)OR(OLD.UnitPrice <> NEW.UnitPrice))AND(statusorder = 'Draft') THEN
		SET NEW.UnitPrice = precio;
	ELSE
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'No es posible cambiar productos en un pedido que no tenga el estado Draft';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orders_after_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orders_after_update` AFTER UPDATE ON `orders` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 4

	IF(NEW.Status = 'Accepted' AND OLD.Status <> 'Accepted') THEN
		INSERT INTO workorders (workorders.OrderID) VALUES (NEW.ID);
		SET @workorderID = LAST_INSERT_ID();
		CALL WorkOrderItemsProcedure(@workorderID, NEW.ID);
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orders_before_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orders_before_insert` BEFORE INSERT ON `orders` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 1

	DECLARE nuevacalle VARCHAR(255);
	DECLARE nuevaciudad VARCHAR(255);
	DECLARE nuevopais VARCHAR(255);
	
	SELECT clients.ShippingStreet, clients.ShippingCity, clients.ShippingCountry
	INTO nuevacalle, nuevaciudad, nuevopais
	FROM clients
	WHERE clients.ID = NEW.ClientID;	
	
	SET NEW.ShippingStreet = nuevacalle, NEW.ShippingCity = nuevaciudad, NEW.ShippingCountry = nuevopais;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.orders_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `orders_before_update` BEFORE UPDATE ON `orders` FOR EACH ROW BEGIN

-- Parte 2 Ejercicio 1, 2, 5 y 6

	DECLARE totalProductos INT;
	
	SELECT COUNT(*)
	INTO totalProductos
	FROM orderlineitems
	WHERE orderlineitems.OrderID = NEW.ID;
	
	-- 1
	
	IF(NEW.Status NOT IN('Draft', 'Created', 'Accepted', 'Sent', 'Completed')) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Estado de pedido no válido';
	END IF;
	
	-- 5
	
	IF(totalProductos = 0 AND NEW.Status <> 'Draft') THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Ese pedido no tiene ninguna linea de pedido';
	END IF;
	
	-- 2 i 6
	
	IF(OLD.Status = 'Draft' AND NEW.Status NOT IN('Draft', 'Created'))OR 
	(OLD.Status = 'Created'AND NEW.Status NOT IN('Created', 'Accepted')) OR 
	(OLD.Status = 'Accepted' AND NEW.Status NOT IN ('Accepted','Sent')) OR
	(OLD.Status = 'Sent' AND NEW.Status NOT IN ('Sent', 'Completed')) OR 
	(OLD.Status = 'Completed' AND NEW.Status <> 'Completed') THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'No es posible llevar a cabo esa acción';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.products_after_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `products_after_update` AFTER UPDATE ON `products` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 8

	IF(OLD.Price <> NEW.Price) THEN
		CALL OrderLineItemsPrice(NEW.Price, NEW.ID);
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.shipments_after_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `shipments_after_insert` AFTER INSERT ON `shipments` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 6

	UPDATE Orders
	SET STATUS = 'Sent'
	WHERE orders.ID = NEW.OrderID;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.shipments_after_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `shipments_after_update` AFTER UPDATE ON `shipments` FOR EACH ROW BEGIN

-- Parte 1 Ejercicio 7
	
	IF(OLD.Status <> 'Delivered' AND NEW.Status = 'Delivered') THEN
		CALL ShipmentsStatus(NEW.OrderID);
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.shipments_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `shipments_before_update` BEFORE UPDATE ON `shipments` FOR EACH ROW BEGIN

-- Parte 2 Ejercicios 5 y 6
	
	-- 5
	
	IF(NEW.Status NOT IN('New', 'Sent', 'Delivered')) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'No es posible llevar a cabo esa acción';
	END IF;
	
	-- 6
	
	IF(OLD.Status = 'New' AND NEW.Status NOT IN ('New','Sent', 'Delivered')) OR 
	(OLD.Status = 'Sent' AND NEW.Status NOT IN ('Sent', 'Delivered')) OR 
	(OLD.Status = 'Delivered' AND NEW.Status <> 'Delivered') THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'No es posible llevar a cabo esa acción';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.workorders_after_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `workorders_after_update` AFTER UPDATE ON `workorders` FOR EACH ROW BEGIN

-- Parte 1 Ejercicios 5

	IF(NEW.Status = 'Completed' AND OLD.Status <> 'Completed') THEN
		CALL ShipmentsProcedure(NEW.OrderID);
		SET @ShipmentID = LAST_INSERT_ID();
		CALL ShipmentItemsProcedure(@ShipmentID, NEW.OrderID);
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador practica.workorders_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `workorders_before_update` BEFORE UPDATE ON `workorders` FOR EACH ROW BEGIN

-- Parte 2 Ejercicio 3 y 6
	
	-- 3
	
	IF(NEW.Status NOT IN ('New', 'Completed')) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'No es posible llevar a cabo esa acción';
	END IF;
	
	-- 6
	
	IF(OLD.Status = 'Completed' AND NEW.Status <> 'Completed') THEN 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'No es posible llevar a cabo esa acción';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
