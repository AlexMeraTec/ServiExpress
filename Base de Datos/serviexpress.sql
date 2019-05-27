-- MySQL dump 10.13  Distrib 8.0.16, for Linux (x86_64)
--
-- Host: localhost    Database: serviexpress
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `id_personas` int(11) NOT NULL AUTO_INCREMENT,
  `natural_empresa` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_personas`),
  UNIQUE KEY `clientes__idx` (`id_personas`),
  CONSTRAINT `clientes_personas_fk` FOREIGN KEY (`id_personas`) REFERENCES `personas` (`id_personas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleados` (
  `id_personas` int(11) NOT NULL AUTO_INCREMENT,
  `nivel_acceso` int(11) NOT NULL,
  PRIMARY KEY (`id_personas`),
  UNIQUE KEY `empleados_idx` (`id_personas`),
  CONSTRAINT `empleado_personas_fk` FOREIGN KEY (`id_personas`) REFERENCES `personas` (`id_personas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,4);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familias`
--

DROP TABLE IF EXISTS `familias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `familias` (
  `id_familias` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_familias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familias`
--

LOCK TABLES `familias` WRITE;
/*!40000 ALTER TABLE `familias` DISABLE KEYS */;
/*!40000 ALTER TABLE `familias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagos` (
  `id_pago` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `boleta_factura` tinyint(1) NOT NULL,
  `total_neto` int(11) NOT NULL,
  `descuento` int(11) NOT NULL,
  `total_final` int(11) NOT NULL,
  `anulada` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `reservas_id_reservas` int(11) NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `pagos_reservas_fk` (`reservas_id_reservas`),
  CONSTRAINT `pagos_reservas_fk` FOREIGN KEY (`reservas_id_reservas`) REFERENCES `reservas` (`id_reservas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedidos` (
  `id_pedidos` int(11) NOT NULL AUTO_INCREMENT,
  `estado` tinyint(1) NOT NULL,
  `empleados_id_personas` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_pedidos`),
  KEY `pedidos_empleados_fk` (`empleados_id_personas`),
  CONSTRAINT `pedidos_empleados_fk` FOREIGN KEY (`empleados_id_personas`) REFERENCES `empleados` (`id_personas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personas` (
  `id_personas` int(11) NOT NULL AUTO_INCREMENT,
  `rut` int(11) NOT NULL,
  `digito_verificador` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `paterno` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `materno` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `telefono` int(11) NOT NULL,
  `telefono2` int(11) DEFAULT NULL,
  `usuario` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `e_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `activa` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tipo_personas` enum('c','e') CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id_personas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,18897468,'6','Alex','Mera','Adasme','Direccion de prueba 1',999999999,NULL,'admin','admin','alex@mera.cl','1',NULL);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos` (
  `id_productos ` varchar(17) NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fecha_vencimiento` datetime NOT NULL,
  `proveedores_id_proveedor` int(3) NOT NULL,
  `tipos_id_tipos` int(3) NOT NULL,
  `familias_id_familias` int(3) NOT NULL,
  `precio_compra` int(11) NOT NULL,
  `precio_venta` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `stock_critico` int(11) NOT NULL,
  PRIMARY KEY (`id_productos`),
  KEY `productos_familias_fk` (`familias_id_familias`),
  KEY `productos_proveedores_fk` (`proveedores_id_proveedor`),
  KEY `productos_tipos_fk` (`tipos_id_tipos`),
  CONSTRAINT `productos_familias_fk` FOREIGN KEY (`familias_id_familias`) REFERENCES `familias` (`id_familias`),
  CONSTRAINT `productos_proveedores_fk` FOREIGN KEY (`proveedores_id_proveedor`) REFERENCES `proveedores` (`id_proveedor`),
  CONSTRAINT `productos_tipos_fk` FOREIGN KEY (`tipos_id_tipos`) REFERENCES `tipos` (`id_tipos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_pedidos`
--

DROP TABLE IF EXISTS `productos_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos_pedidos` (
  `productos_id_productos` varchar(11) NOT NULL,
  `pedidos_id_pedidos` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`pedidos_id_pedidos`,`productos_id_productos`),
  KEY `PRODUCTOS-PEDIDOS_PRODUCTOS_FK` (`productos_id_productos`),
  KEY `PRODUCTOS_PEDIDOS_PEDIDOS_FK` (`pedidos_id_pedidos`),
  CONSTRAINT `PRODUCTOS-PEDIDOS_PEDIDOS_FK` FOREIGN KEY (`pedidos_id_pedidos`) REFERENCES `pedidos` (`id_pedidos`),
  CONSTRAINT `PRODUCTOS-PEDIDOS_PRODUCTOS_FK` FOREIGN KEY (`productos_id_productos`) REFERENCES `productos` (`id_productos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_pedidos`
--

LOCK TABLES `productos_pedidos` WRITE;
/*!40000 ALTER TABLE `productos_pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_reservas`
--

DROP TABLE IF EXISTS `productos_reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos_reservas` (
  `cantidad` int(11) NOT NULL,
  `reservas_id_reservas` int(11) NOT NULL,
  `productos_id_productos` varchar(11) NOT NULL,
  PRIMARY KEY (`reservas_id_reservas`,`productos_id_productos`),
  KEY `prod_res_prod_fk` (`productos_id_productos`),
  KEY `productos_reservas_reservas_fk` (`reservas_id_reservas`) USING BTREE,
  CONSTRAINT `pro_res_res_fk` FOREIGN KEY (`reservas_id_reservas`) REFERENCES `reservas` (`id_reservas`),
  CONSTRAINT `prod_res_prod_fk` FOREIGN KEY (`productos_id_productos`) REFERENCES `productos` (`id_productos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_reservas`
--

LOCK TABLES `productos_reservas` WRITE;
/*!40000 ALTER TABLE `productos_reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `rubro` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `telefono` int(11) NOT NULL,
  `e_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepciones`
--

DROP TABLE IF EXISTS `recepciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recepciones` (
  `id_recepcion` int(11) NOT NULL,
  `pedidos_id_pedidos` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_emp_recep` int(11) NOT NULL,
  PRIMARY KEY (`id_recepcion`),
  UNIQUE KEY `recepcion__idx` (`pedidos_id_pedidos`),
  CONSTRAINT `recepciones_pedidos_fk` FOREIGN KEY (`pedidos_id_pedidos`) REFERENCES `pedidos` (`id_pedidos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepciones`
--

LOCK TABLES `recepciones` WRITE;
/*!40000 ALTER TABLE `recepciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `recepciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reservas` (
  `id_reservas` int(11) NOT NULL,
  `empleados_id_personas` int(11) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `observaciones` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `se_atendio` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `clientes_id_personas` int(11) NOT NULL,
  PRIMARY KEY (`id_reservas`),
  KEY `reservas_clientes_fk` (`clientes_id_personas`),
  CONSTRAINT `reservas_clientes_fk` FOREIGN KEY (`clientes_id_personas`) REFERENCES `clientes` (`id_personas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas_servicios`
--

DROP TABLE IF EXISTS `reservas_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reservas_servicios` (
  `reservas_id_reservas` int(11) NOT NULL,
  `servicios_id_servicios` int(11) NOT NULL,
  PRIMARY KEY (`reservas_id_reservas`,`servicios_id_servicios`),
  KEY `res_serv_serv_fk` (`servicios_id_servicios`) USING BTREE,
  KEY `res_serv_res_fk` (`reservas_id_reservas`) USING BTREE,
  CONSTRAINT `reservas_servicios_ibfk_1` FOREIGN KEY (`servicios_id_servicios`) REFERENCES `servicios` (`id_servicios`),
  CONSTRAINT `reservas_servicios_ibfk_2` FOREIGN KEY (`reservas_id_reservas`) REFERENCES `reservas` (`id_reservas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas_servicios`
--

LOCK TABLES `reservas_servicios` WRITE;
/*!40000 ALTER TABLE `reservas_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `servicios` (
  `id_servicios` int(11) NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `precio` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_servicios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (0,'servicio 0',0,1),(1,'servicio 1',1000,1),(2,'servicio 2',2000,1);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipos` (
  `id_tipos` int(11) NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_tipos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehiculos` (
  `id_personas` int(11) NOT NULL,
  `patente` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tipo` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `modelo` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `color` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `anio` datetime(6) NOT NULL,
  `motor` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`patente`),
  KEY `id_personas` (`id_personas`),
  CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`id_personas`) REFERENCES `clientes` (`id_personas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-27  0:25:42

/*
--funcion para crear la id_productos
CREATE FUNCTION serviexpress.Generar_id_productos
(
proveedor int(3),
familia int(3),
vencimiento DATE,
tipo int(3)
)
RETURNS varchar(17)
BEGIN
-- DECLARE variables
    DECLARE fechaint int(8);
    DECLARE fechavar varchar(8);
    DECLARE msj varchar(17);
-- definition
    IF vencimiento="0001-01-01" THEN
      SET fechavar = "00000000";
    else
        SET fechaint=CAST(CAST(vencimiento as DATE) as UNSIGNED);
        SET fechavar = concat("",fechaint);
    END IF;
    SET msj = CONCAT(right( POWER(10, 3)+proveedor, 3),right( POWER(10, 3)+familia, 3),fechavar,right( POWER(10, 3)+tipo, 3)); 
    --right( POWER(10, 3)+proveedor, 3) esta sección permite convertir un numero desde 1 a 999 en un formato de 001
-- RETURN variable | value
    RETURN msj;
END;
*/