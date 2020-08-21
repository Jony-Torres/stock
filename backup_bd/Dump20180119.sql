-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: compra_venta
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acceso_grupo`
--

DROP TABLE IF EXISTS `acceso_grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acceso_grupo` (
  `cod_grupo` varchar(15) NOT NULL,
  `cod_modulo` varchar(5) NOT NULL,
  `desc_formulario` varchar(10) NOT NULL,
  `puede_insert` varchar(1) DEFAULT NULL,
  `puede_modif` varchar(1) DEFAULT NULL,
  `puede_borrar` varchar(1) DEFAULT NULL,
  `puede_consul` varchar(1) DEFAULT NULL,
  `mostrar_en_menu` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_grupo`,`cod_modulo`,`desc_formulario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso_grupo`
--

LOCK TABLES `acceso_grupo` WRITE;
/*!40000 ALTER TABLE `acceso_grupo` DISABLE KEYS */;
INSERT INTO `acceso_grupo` VALUES ('ADMIN','AJ','FORMACCGRU','S','S','S','S','S'),('ADMIN','AJ','FORMMENUPR','S','S','S','S','S'),('ADMIN','AJ','FORMUSUARI','S','S','S','S','S'),('ADMIN','CC','FORMCLIENT','S','S','S','S','S'),('ADMIN','CC','FORMCOSACL','S','S','S','S','S'),('ADMIN','CC','FORMFORMCO','S','S','S','S','S'),('ADMIN','CC','FORMPERSON','S','S','S','S','S'),('ADMIN','CC','FORMRECIBO','S','S','S','S','S'),('ADMIN','CM','FORMFACCOM','S','S','S','S','S'),('ADMIN','CP','FORMCOSAPR','S','S','S','S','S'),('ADMIN','CP','FORMFORMPA','S','S','S','S','S'),('ADMIN','CP','FORMPROVEE','S','S','S','S','S'),('ADMIN','ST','FORMARTICU','S','S','S','S','S'),('ADMIN','ST','FORMCOEXAR','S','S','S','S','S'),('ADMIN','VT','FORMCONDVE','S','S','S','S','S'),('ADMIN','VT','FORMFACTUR','S','S','S','S','S'),('VENTAS','ST','FORMARTICU','S','S','S','S','S');
/*!40000 ALTER TABLE `acceso_grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `cod_articulo` varchar(50) NOT NULL,
  `cod_sucursal` varchar(10) NOT NULL,
  `cod_deposito` varchar(10) NOT NULL,
  `desc_articulo` varchar(80) NOT NULL,
  `cod_proveedor` varchar(10) NOT NULL,
  `cod_marca` varchar(10) NOT NULL,
  `cod_categoria` varchar(10) NOT NULL,
  `precio_compra` int(10) DEFAULT NULL,
  `precio_venta` int(10) DEFAULT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `cod_iva` varchar(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `maneja_stock` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_articulo`,`cod_deposito`,`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES ('A11','01','01','LED TOKYO 32 PULG','1','','',0,0,0,'10','A','S'),('A12','01','01','AIRE ACONDICIONADO SPLIT 12000 BTU','1','','',0,0,0,'10','A','S'),('A13','01','01','VENTILADOR DE PIE TOKYO','1','','',0,0,0,'10','A','S'),('A14','01','01','COCINA ELECTRICA MIDAS','2','','',0,0,0,'10','A','S'),('A15','01','01','MIXTERA ARNO','3','','',0,0,0,'10','A','S'),('A16','01','01','PLAY STATION 2','3','','',0,0,0,'10','A','S'),('A17','01','01','MINI COMPONENTE DE AUDIO MEGASTAR','3','','',0,0,0,'10','A','S'),('A18','01','01','BUFFER PIONER 10 PULG','3','','',0,0,0,'10','A','S'),('A19','01','01','AMPLIFICADOR DE AUDIO BOOSTER 2500 WTTS','3','','',0,0,0,'10','A','S'),('A20','01','01','AUTO RADIO PIONER 1656','3','','',0,0,0,'10','A','S');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_insert_exist_artic` AFTER INSERT ON `articulo` 
    FOR EACH ROW BEGIN
CALL insertar_exist_articulo(new.cod_sucursal,new.cod_deposito,new.cod_articulo,3,7,0);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `cod_caja` varchar(15) NOT NULL,
  `desc_caja` varchar(50) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`cod_caja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES ('CAJ1','CAJA1',NULL,'A','01');
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `cod_categoria` varchar(10) NOT NULL,
  `desc_categoria` varchar(80) NOT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES ('GRAL','GENERAL');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `cod_ciudad` int(10) NOT NULL AUTO_INCREMENT,
  `desc_ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'ASUNCION'),(2,'AREGUA');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cod_cliente` int(15) NOT NULL AUTO_INCREMENT,
  `cod_persona` int(15) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `cod_cobrador` varchar(20) DEFAULT NULL,
  `cod_vendedor` varchar(20) DEFAULT NULL,
  `limite_credito` int(10) DEFAULT NULL,
  `cod_condicion_venta` int(10) DEFAULT NULL,
  `tipo_cliente` varchar(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `comentario` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_cliente`),
  KEY `fk_cod_persona_idx` (`cod_persona`),
  CONSTRAINT `fk_cod_persona` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,4,'01','','',0,0,'','A',''),(2,5,'01','','',0,NULL,'','A',''),(3,6,'01','','',0,NULL,'','A',''),(4,7,'01','01','01',0,1,'01','A',''),(5,11,'01','01','01',0,1,'','','');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cobrador`
--

DROP TABLE IF EXISTS `cobrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cobrador` (
  `cod_cobrador` int(10) NOT NULL AUTO_INCREMENT,
  `cod_persona` int(10) DEFAULT NULL,
  `cod_zona` varchar(15) DEFAULT NULL,
  `porcentaje_comision` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_cobrador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cobrador`
--

LOCK TABLES `cobrador` WRITE;
/*!40000 ALTER TABLE `cobrador` DISABLE KEYS */;
INSERT INTO `cobrador` VALUES (1,3,NULL,10,'A'),(2,8,NULL,10,'A');
/*!40000 ALTER TABLE `cobrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante_cabecera_compra`
--

DROP TABLE IF EXISTS `comprobante_cabecera_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante_cabecera_compra` (
  `cod_tipo_comp` varchar(10) NOT NULL,
  `ser_timb_comp` varchar(15) NOT NULL,
  `nro_comprob_comp` int(11) NOT NULL,
  `nro_timbrado` varchar(30) DEFAULT NULL,
  `fecha_comprob_comp` date NOT NULL,
  `cod_usuario` varchar(10) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `cod_deposito` varchar(5) DEFAULT NULL,
  `cod_proveedor` int(10) NOT NULL,
  `cod_cond_comp` int(5) DEFAULT NULL,
  `cant_cuota` int(10) DEFAULT NULL,
  `fecha_inic_comp` date DEFAULT NULL,
  `monto_cuota` int(11) DEFAULT NULL,
  `total_comprob_comp` int(11) NOT NULL,
  `iva_comp` int(11) NOT NULL,
  `gravada` int(11) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `tipo_cambio` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `pagado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante_cabecera_compra`
--

LOCK TABLES `comprobante_cabecera_compra` WRITE;
/*!40000 ALTER TABLE `comprobante_cabecera_compra` DISABLE KEYS */;
INSERT INTO `comprobante_cabecera_compra` VALUES ('FCR','001-001',1,'12345','2018-01-19','root','01','01',3,3,3,'2018-01-19',1033333,3100000,281818,2818182,'01',0,'P','S'),('FCR','001-001',2,'12345','2018-01-19','root','01','01',5,4,4,'2018-01-19',1425000,5700000,518183,5181817,'01',0,'P',NULL),('FCR','001-001',3,'12345','2018-01-19','root','01','01',6,2,2,'2018-01-19',1050000,2100000,190909,1909091,'01',0,'P',NULL);
/*!40000 ALTER TABLE `comprobante_cabecera_compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_generar_saldo_proveedor` AFTER INSERT ON `comprobante_cabecera_compra` 
    FOR EACH ROW BEGIN
CALL generar_saldo_proveedor(new.cod_tipo_comp,new.ser_timb_comp,new.nro_comprob_comp,new.cod_cond_comp,new.cod_sucursal,new.cod_proveedor,new.fecha_comprob_comp,new.total_comprob_comp,new.cod_moneda,new.total_comprob_comp,new.cod_usuario);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_det_comprob_compra` AFTER DELETE ON `comprobante_cabecera_compra` 
    FOR EACH ROW BEGIN
DELETE FROM  comprobante_detalle_compra
WHERE cod_tipo_comp=old.cod_tipo_comp
AND ser_timb_comp=old.ser_timb_comp
AND nro_comprob_comp=old.nro_comprob_comp;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comprobante_cabecera_venta`
--

DROP TABLE IF EXISTS `comprobante_cabecera_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante_cabecera_venta` (
  `tipo_comprobante` varchar(5) NOT NULL,
  `ser_comprobante` varchar(5) NOT NULL,
  `nro_comprobante` int(15) NOT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `cod_deposito` varchar(5) DEFAULT NULL,
  `fecha_comprobante` date DEFAULT NULL,
  `cod_cliente` int(10) DEFAULT NULL,
  `cod_cobrador` varchar(10) DEFAULT NULL,
  `cod_vendedor` varchar(10) DEFAULT NULL,
  `tipo_comprobante_ref` varchar(5) DEFAULT NULL,
  `ser_comprobante_ref` varchar(5) DEFAULT NULL,
  `nro_comprobante_ref` int(15) DEFAULT NULL,
  `cod_condicion_venta` int(10) DEFAULT NULL,
  `descuento` int(10) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `tipo_cambio` int(10) DEFAULT NULL,
  `total_comprobante` int(15) DEFAULT NULL,
  `total_gravada` int(15) DEFAULT NULL,
  `total_exenta` int(10) DEFAULT NULL,
  `total_iva` int(11) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  `comentario` varchar(80) DEFAULT NULL,
  `monto_cuota` int(10) DEFAULT NULL,
  `cobrado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante_cabecera_venta`
--

LOCK TABLES `comprobante_cabecera_venta` WRITE;
/*!40000 ALTER TABLE `comprobante_cabecera_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprobante_cabecera_venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_generar_saldo_cliente` AFTER INSERT ON `comprobante_cabecera_venta` FOR EACH ROW BEGIN

CALL generar_saldo_cliente(new.tipo_comprobante,new.ser_comprobante,new.nro_comprobante,new.cod_condicion_venta,new.cod_sucursal,new.cod_cliente,new.fecha_comprobante,new.monto_cuota,new.cod_moneda,new.monto_cuota,new.cod_usuario);

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_det_comprob_venta` AFTER DELETE ON `comprobante_cabecera_venta` FOR EACH ROW BEGIN

DELETE FROM  comprobante_detalle_venta

WHERE tipo_comprobante=old.tipo_comprobante

AND ser_comprobante=old.ser_comprobante

AND nro_comprobante=old.nro_comprobante;

    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comprobante_detalle_compra`
--

DROP TABLE IF EXISTS `comprobante_detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante_detalle_compra` (
  `cod_tipo_comp` varchar(5) NOT NULL,
  `ser_timb_comp` varchar(30) NOT NULL,
  `nro_comprob_comp` int(11) NOT NULL,
  `cod_producto` varchar(50) NOT NULL,
  `descripcion_prod` varchar(100) NOT NULL,
  `cantidad_prod` int(11) NOT NULL,
  `precio_unitario` int(11) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  `importe` int(11) NOT NULL,
  `total_iva_5` int(11) DEFAULT NULL,
  `total_iva_10` int(11) DEFAULT NULL,
  `gravada_5` int(11) DEFAULT NULL,
  `gravada_10` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`,`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante_detalle_compra`
--

LOCK TABLES `comprobante_detalle_compra` WRITE;
/*!40000 ALTER TABLE `comprobante_detalle_compra` DISABLE KEYS */;
INSERT INTO `comprobante_detalle_compra` VALUES ('FCR','001-001',1,'A18','BUFFER PIONER 10 PULG',3,350000,0,1050000,0,95455,0,954545),('FCR','001-001',1,'A19','AMPLIFICADOR DE AUDIO BOOSTER 2500 WTTS',5,250000,0,1250000,0,113636,0,1136364),('FCR','001-001',1,'A20','AUTO RADIO PIONER 1656',2,400000,0,800000,0,72727,0,727273),('FCR','001-001',2,'A11','LED TOKYO 32 PULG',3,900000,0,2700000,0,245455,0,2454545),('FCR','001-001',2,'A12','AIRE ACONDICIONADO SPLIT 12000 BTU',2,1300000,0,2600000,0,236364,0,2363636),('FCR','001-001',2,'A13','VENTILADOR DE PIE TOKYO',5,80000,0,400000,0,36364,0,363636),('FCR','001-001',3,'A15','MIXTERA ARNO',5,50000,0,250000,0,22727,0,227273),('FCR','001-001',3,'A16','PLAY STATION 2',3,500000,0,1500000,0,136364,0,1363636),('FCR','001-001',3,'A17','MINI COMPONENTE DE AUDIO MEGASTAR',5,70000,0,350000,0,31818,0,318182);
/*!40000 ALTER TABLE `comprobante_detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_exist_artic_compra` AFTER INSERT ON `comprobante_detalle_compra` 
    FOR EACH ROW BEGIN
DECLARE s VARCHAR(1);
declare suc VARCHAR(5);
declare dep VARCHAR(5);
select 	cod_sucursal,cod_deposito
into 	suc,dep
from 	comprobante_cabecera_compra
where	cod_tipo_comp=new.cod_tipo_comp
	and ser_timb_comp=new.ser_timb_comp
	and nro_comprob_comp=new.nro_comprob_comp;
	
	
SELECT maneja_stock INTO s
     FROM articulo 
     WHERE cod_articulo=new.cod_producto
	   and cod_sucursal=suc
	   and cod_deposito=dep;
IF s='S'  THEN
UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad_prod WHERE cod_articulo=new.cod_producto and cod_sucursal=suc and cod_deposito=dep and  tipo_transacc=3 and sub_tipo_transacc=7;
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_saldo_proveedor` AFTER DELETE ON `comprobante_detalle_compra` 
    FOR EACH ROW BEGIN
DELETE FROM  saldo_proveedor
WHERE tipo_comprobante=old.cod_tipo_comp
AND ser_comprobante=old.ser_timb_comp
AND nro_comprobante=old.nro_comprob_comp;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comprobante_detalle_venta`
--

DROP TABLE IF EXISTS `comprobante_detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante_detalle_venta` (
  `tipo_comprobante` varchar(5) NOT NULL,
  `ser_comprobante` varchar(5) NOT NULL,
  `nro_comprobante` int(15) NOT NULL,
  `cod_articulo` varchar(50) NOT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `precio_unitario` int(10) DEFAULT NULL,
  `descuento` int(10) DEFAULT NULL,
  `gravada_10` int(10) DEFAULT NULL,
  `gravada_5` int(10) DEFAULT NULL,
  `importe_total` int(10) DEFAULT NULL,
  `total_iva10` int(10) DEFAULT NULL,
  `total_iva5` int(10) DEFAULT NULL,
  `porcentaje_iva` int(5) DEFAULT NULL,
  `cod_iva` int(5) DEFAULT NULL,
  `porcentaje_descuento` int(5) DEFAULT NULL,
  `nro_cuota` int(5) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`cod_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante_detalle_venta`
--

LOCK TABLES `comprobante_detalle_venta` WRITE;
/*!40000 ALTER TABLE `comprobante_detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprobante_detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_stock_comprob_venta` AFTER INSERT ON `comprobante_detalle_venta` 
    FOR EACH ROW BEGIN
DECLARE s VARCHAR(1);
declare ea varchar(1);
DECLARE suc VARCHAR(5);
DECLARE dep VARCHAR(5);
SELECT 	cod_sucursal,cod_deposito
INTO 	suc,dep
FROM 	comprobante_cabecera_venta
WHERE	tipo_comprobante=new.tipo_comprobante
	AND ser_comprobante=new.ser_comprobante
	AND nro_comprobante=new.nro_comprobante;
	
SELECT maneja_stock INTO s
     FROM articulo 
     WHERE cod_articulo=new.cod_articulo
           AND cod_sucursal=suc
	   AND cod_deposito=dep;
	   
SELECT 'S' INTO ea
     FROM existencia_articulo 
     WHERE cod_articulo=new.cod_articulo
           AND cod_sucursal=suc
	   AND cod_deposito=dep
	   AND tipo_transacc=4
	   and sub_tipo_transacc=10;
	   
IF s='S'  THEN
	
	if ea = 'S' then
		UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad WHERE cod_articulo=new.cod_articulo AND cod_sucursal=suc AND cod_deposito=dep and tipo_transacc=4 and sub_tipo_transacc=10;
	else
		CALL insertar_exist_articulo(suc,dep,new.cod_articulo,4,10,new.cantidad);
	end if;
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_saldo_cliente` AFTER DELETE ON `comprobante_detalle_venta` FOR EACH ROW BEGIN

DELETE FROM  saldo_cliente

WHERE tipo_comprobante=old.tipo_comprobante

AND ser_comprobante=old.ser_comprobante

AND nro_comprobante=old.nro_comprobante;

    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `condicion_venta`
--

DROP TABLE IF EXISTS `condicion_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condicion_venta` (
  `cod_condicion` int(10) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `numero_cuota` int(5) DEFAULT NULL,
  `dia_inicial` int(5) DEFAULT NULL,
  `plazo` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_condicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condicion_venta`
--

LOCK TABLES `condicion_venta` WRITE;
/*!40000 ALTER TABLE `condicion_venta` DISABLE KEYS */;
INSERT INTO `condicion_venta` VALUES (0,'CONTADO',0,0,0,'A'),(1,'CREDITO(30 DIAS)',1,1,0,'A'),(2,'CREDITO(60 DIAS)',2,1,0,'A'),(3,'CREDITO(90 DIAS)',3,1,30,'A'),(4,'CREDITO(120 DIAS)',4,1,30,'A');
/*!40000 ALTER TABLE `condicion_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposito_articulo`
--

DROP TABLE IF EXISTS `deposito_articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposito_articulo` (
  `cod_sucursal` varchar(5) NOT NULL,
  `cod_deposito` varchar(5) NOT NULL,
  `desc_deposito` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`,`cod_deposito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposito_articulo`
--

LOCK TABLES `deposito_articulo` WRITE;
/*!40000 ALTER TABLE `deposito_articulo` DISABLE KEYS */;
INSERT INTO `deposito_articulo` VALUES ('01','01','DEPOSITO CASA CENTRAL(1)'),('02','02','DEPOSITO SUCURSAL(02)');
/*!40000 ALTER TABLE `deposito_articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_civil`
--

DROP TABLE IF EXISTS `estado_civil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_civil` (
  `cod_estado_civil` varchar(5) NOT NULL,
  `desc_estado_civil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_estado_civil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_civil`
--

LOCK TABLES `estado_civil` WRITE;
/*!40000 ALTER TABLE `estado_civil` DISABLE KEYS */;
INSERT INTO `estado_civil` VALUES ('CAS','CASADO/A'),('DIV','DIVORCIADO/A'),('SOL','SOLTERO/A'),('VIU','VIUDO/A');
/*!40000 ALTER TABLE `estado_civil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `existencia_articulo`
--

DROP TABLE IF EXISTS `existencia_articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `existencia_articulo` (
  `cod_sucursal` varchar(10) NOT NULL,
  `cod_deposito` varchar(10) NOT NULL,
  `cod_articulo` varchar(50) NOT NULL,
  `tipo_transacc` int(5) NOT NULL COMMENT 'tipo_transaccion',
  `sub_tipo_transacc` int(5) NOT NULL COMMENT 'sub_tipo_transaccion',
  `cantidad` int(5) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`,`cod_deposito`,`cod_articulo`,`tipo_transacc`,`sub_tipo_transacc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `existencia_articulo`
--

LOCK TABLES `existencia_articulo` WRITE;
/*!40000 ALTER TABLE `existencia_articulo` DISABLE KEYS */;
INSERT INTO `existencia_articulo` VALUES ('01','01','A11',3,7,3),('01','01','A12',3,7,2),('01','01','A13',3,7,5),('01','01','A14',3,7,0),('01','01','A15',3,7,5),('01','01','A16',3,7,3),('01','01','A17',3,7,5),('01','01','A18',3,7,3),('01','01','A19',3,7,5),('01','01','A20',3,7,2);
/*!40000 ALTER TABLE `existencia_articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_cobro_venta`
--

DROP TABLE IF EXISTS `forma_cobro_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_cobro_venta` (
  `tipo_mov_caja` varchar(5) NOT NULL,
  `ser_mov_caja` varchar(5) NOT NULL,
  `nro_mov_caja` int(10) NOT NULL,
  `tipo_transaccion` int(5) NOT NULL,
  `sub_tipo_transaccion` int(5) NOT NULL,
  `cod_persona_juridica` int(10) DEFAULT NULL,
  `nro_valor` varchar(30) DEFAULT NULL,
  `nro_cuenta` varchar(30) DEFAULT NULL,
  `monto` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`tipo_transaccion`,`sub_tipo_transaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_cobro_venta`
--

LOCK TABLES `forma_cobro_venta` WRITE;
/*!40000 ALTER TABLE `forma_cobro_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `forma_cobro_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pago_compra`
--

DROP TABLE IF EXISTS `forma_pago_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_pago_compra` (
  `tipo_mov_caja_com` varchar(5) NOT NULL,
  `ser_mov_caja_com` varchar(5) NOT NULL,
  `nro_mov_caja_com` int(10) NOT NULL,
  `tipo_transaccion` int(5) NOT NULL,
  `sub_tipo_transaccion` int(5) NOT NULL,
  `cod_persona_juridica` int(10) DEFAULT NULL,
  `nro_valor` varchar(30) DEFAULT NULL,
  `nro_cuenta` varchar(30) DEFAULT NULL,
  `monto` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja_com`,`ser_mov_caja_com`,`nro_mov_caja_com`,`tipo_transaccion`,`sub_tipo_transaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pago_compra`
--

LOCK TABLES `forma_pago_compra` WRITE;
/*!40000 ALTER TABLE `forma_pago_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `forma_pago_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_usuario`
--

DROP TABLE IF EXISTS `grupo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_usuario` (
  `cod_grupo` varchar(10) NOT NULL,
  `desc_grupo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_usuario`
--

LOCK TABLES `grupo_usuario` WRITE;
/*!40000 ALTER TABLE `grupo_usuario` DISABLE KEYS */;
INSERT INTO `grupo_usuario` VALUES ('ADMIN','ADMINISTRACION DE SISTEMA'),('COMPRAS','COMPRAS'),('VENTAS','VENTAS Y FACTURACION');
/*!40000 ALTER TABLE `grupo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilitacion_caja`
--

DROP TABLE IF EXISTS `habilitacion_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habilitacion_caja` (
  `nro_habilitacion` int(10) NOT NULL AUTO_INCREMENT,
  `fecha_hab` date DEFAULT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `saldo_inicial` int(10) DEFAULT NULL,
  `cod_caja` varchar(15) DEFAULT NULL,
  `cod_sucursal` varchar(10) DEFAULT NULL,
  `cod_usuario` varchar(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`nro_habilitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilitacion_caja`
--

LOCK TABLES `habilitacion_caja` WRITE;
/*!40000 ALTER TABLE `habilitacion_caja` DISABLE KEYS */;
INSERT INTO `habilitacion_caja` VALUES (1,NULL,NULL,10000,'CAJ1','01','root','H');
/*!40000 ALTER TABLE `habilitacion_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iva`
--

DROP TABLE IF EXISTS `iva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iva` (
  `cod_iva` varchar(10) NOT NULL,
  `desc_iva` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_iva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iva`
--

LOCK TABLES `iva` WRITE;
/*!40000 ALTER TABLE `iva` DISABLE KEYS */;
INSERT INTO `iva` VALUES ('10','I.V.A(10%)'),('5','I.V.A(5%)');
/*!40000 ALTER TABLE `iva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `cod_marca` varchar(10) NOT NULL,
  `desc_marca` varchar(80) NOT NULL,
  PRIMARY KEY (`cod_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES ('GRAL','GENERAL');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo_sistema`
--

DROP TABLE IF EXISTS `modulo_sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo_sistema` (
  `cod_modulo` varchar(5) NOT NULL,
  `desc_modulo` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_modulo`,`desc_modulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo_sistema`
--

LOCK TABLES `modulo_sistema` WRITE;
/*!40000 ALTER TABLE `modulo_sistema` DISABLE KEYS */;
INSERT INTO `modulo_sistema` VALUES ('AJ','AJUSTES SISTEMA'),('CC','CUENTAS A COBRAR'),('CM','COMPRAS'),('CP','CUENTAS A PAGAR'),('ST','STOCK'),('VT','VENTAS Y FACTURACION');
/*!40000 ALTER TABLE `modulo_sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moneda`
--

DROP TABLE IF EXISTS `moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moneda` (
  `cod_moneda` varchar(5) NOT NULL,
  `desc_moneda` varchar(50) DEFAULT NULL,
  `siglas` varchar(5) DEFAULT NULL,
  `cod_pais` varchar(5) DEFAULT NULL,
  `decimales` int(5) DEFAULT NULL,
  `tipo_cambio` int(10) DEFAULT NULL,
  `tipo_cambio_compra` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `redondeo` int(10) DEFAULT NULL,
  PRIMARY KEY (`cod_moneda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneda`
--

LOCK TABLES `moneda` WRITE;
/*!40000 ALTER TABLE `moneda` DISABLE KEYS */;
INSERT INTO `moneda` VALUES ('01','GUARANIES','GS','1',2,48000,5000,'A',1),('02','DOLAR AMERICANO','DOL','1',2,48000,5000,'A',1);
/*!40000 ALTER TABLE `moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento_caja_compra`
--

DROP TABLE IF EXISTS `movimiento_caja_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_caja_compra` (
  `tipo_mov_caja_com` varchar(5) NOT NULL,
  `ser_mov_caja_com` varchar(5) NOT NULL,
  `nro_mov_caja_com` int(10) NOT NULL,
  `fecha_mov_caja_com` date DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  `cod_usuario` varchar(15) DEFAULT NULL,
  `cod_caja` varchar(5) DEFAULT NULL,
  `numero_hab` int(11) DEFAULT NULL,
  `total_mov_caja_com` int(11) DEFAULT NULL,
  `anulado` varchar(1) DEFAULT NULL,
  `fecha_anulacion_com` date DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja_com`,`ser_mov_caja_com`,`nro_mov_caja_com`),
  KEY `nro_mov_caja_com` (`nro_mov_caja_com`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_caja_compra`
--

LOCK TABLES `movimiento_caja_compra` WRITE;
/*!40000 ALTER TABLE `movimiento_caja_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento_caja_compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_det_mov_compra` AFTER DELETE ON `movimiento_caja_compra` 
    FOR EACH ROW BEGIN
DELETE FROM  movimiento_comprobante_compra
WHERE tipo_mov_caja_com=old.tipo_mov_caja_com
AND ser_mov_caja_com=old.ser_mov_caja_com
AND nro_mov_caja_com=old.nro_mov_caja_com;
DELETE FROM  forma_pago_compra
WHERE tipo_mov_caja_com=old.tipo_mov_caja_com
AND ser_mov_caja_com=old.ser_mov_caja_com
AND nro_mov_caja_com=old.nro_mov_caja_com;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `movimiento_caja_venta`
--

DROP TABLE IF EXISTS `movimiento_caja_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_caja_venta` (
  `tipo_mov_caja` varchar(5) NOT NULL,
  `ser_mov_caja` varchar(5) NOT NULL,
  `nro_mov_caja` int(10) NOT NULL,
  `fecha_mov_caja_venta` date DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `cod_cliente` int(11) DEFAULT NULL,
  `cod_usuario` varchar(15) DEFAULT NULL,
  `cod_caja` varchar(5) DEFAULT NULL,
  `numero_hab` int(11) DEFAULT NULL,
  `total_mov_caja` int(11) DEFAULT NULL,
  `anulado` varchar(1) DEFAULT NULL,
  `fecha_anulacion` date DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`),
  KEY `nro_mov_caja` (`nro_mov_caja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_caja_venta`
--

LOCK TABLES `movimiento_caja_venta` WRITE;
/*!40000 ALTER TABLE `movimiento_caja_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento_caja_venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_det_mov_venta` AFTER DELETE ON `movimiento_caja_venta` 
    FOR EACH ROW BEGIN
DELETE FROM  movimiento_comprobante_venta
WHERE tipo_mov_caja=old.tipo_mov_caja
AND ser_mov_caja=old.ser_mov_caja
AND nro_mov_caja=old.nro_mov_caja;
DELETE FROM  forma_cobro_venta
WHERE tipo_mov_caja=old.tipo_mov_caja
AND ser_mov_caja=old.ser_mov_caja
AND nro_mov_caja=old.nro_mov_caja;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `movimiento_comprobante_compra`
--

DROP TABLE IF EXISTS `movimiento_comprobante_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_comprobante_compra` (
  `tipo_mov_caja_com` varchar(5) NOT NULL,
  `ser_mov_caja_com` varchar(5) NOT NULL,
  `nro_mov_caja_com` int(10) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `tipo_transacc` int(5) NOT NULL,
  `sub_tipo_transacc` int(5) NOT NULL,
  `tipo_comprobante_com` varchar(5) NOT NULL,
  `ser_comprobante_com` varchar(15) NOT NULL,
  `nro_comprobante_com` int(10) NOT NULL,
  `total_comprobante_com` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja_com`,`ser_mov_caja_com`,`nro_mov_caja_com`,`cod_sucursal`,`tipo_transacc`,`sub_tipo_transacc`,`tipo_comprobante_com`,`ser_comprobante_com`,`nro_comprobante_com`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_comprobante_compra`
--

LOCK TABLES `movimiento_comprobante_compra` WRITE;
/*!40000 ALTER TABLE `movimiento_comprobante_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento_comprobante_compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_saldo_proveedor_forma_pago` AFTER INSERT ON `movimiento_comprobante_compra` 
    FOR EACH ROW BEGIN
UPDATE  saldo_proveedor SET saldo_cuota=(saldo_cuota-new.total_comprobante_com)
WHERE tipo_comprobante=new.tipo_comprobante_com
AND ser_comprobante=new.ser_comprobante_com
AND nro_comprobante=new.nro_comprobante_com;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_pago_comprob_compra` AFTER INSERT ON `movimiento_comprobante_compra` 
    FOR EACH ROW BEGIN
IF (new.tipo_transacc=5 and new.sub_tipo_transacc=13) THEN
UPDATE  comprobante_cabecera_compra SET pagado='S'
WHERE cod_tipo_comp=new.tipo_comprobante_com
AND ser_timb_comp=new.ser_comprobante_com
AND nro_comprob_comp=new.nro_comprobante_com;
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_borr_saldo_proveedor_forma_pago` AFTER DELETE ON `movimiento_comprobante_compra` 
    FOR EACH ROW BEGIN
UPDATE  saldo_proveedor
SET saldo_cuota=(saldo_cuota+old.total_comprobante_com)
WHERE tipo_comprobante=old.tipo_comprobante_com
AND ser_comprobante=old.ser_comprobante_com
AND nro_comprobante=old.nro_comprobante_com;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `movimiento_comprobante_venta`
--

DROP TABLE IF EXISTS `movimiento_comprobante_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_comprobante_venta` (
  `tipo_mov_caja` varchar(5) NOT NULL,
  `ser_mov_caja` varchar(5) NOT NULL,
  `nro_mov_caja` int(10) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `tipo_comprobante` varchar(5) NOT NULL,
  `ser_comprobante` varchar(5) NOT NULL,
  `nro_comprobante` int(10) NOT NULL,
  `total_comprobante` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`cod_sucursal`,`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_comprobante_venta`
--

LOCK TABLES `movimiento_comprobante_venta` WRITE;
/*!40000 ALTER TABLE `movimiento_comprobante_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento_comprobante_venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_cobro_ventas` AFTER INSERT ON `movimiento_comprobante_venta` FOR EACH ROW BEGIN

IF (new.tipo_comprobante='FCO') THEN

UPDATE  comprobante_cabecera_venta SET cobrado='S'

WHERE tipo_comprobante=new.tipo_comprobante

AND ser_comprobante=new.ser_comprobante

AND nro_comprobante=new.nro_comprobante;

END IF;

IF (new.tipo_comprobante='REC') THEN

UPDATE  recibo_venta_cabecera SET cobrado='S'

WHERE tipo_recibo=new.tipo_comprobante

AND ser_recibo=new.ser_comprobante

AND nro_recibo=new.nro_comprobante;

END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `cod_pais` int(10) NOT NULL AUTO_INCREMENT,
  `desc_pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'PARAGUAY'),(2,'ARGENTINA'),(3,'BRASIL'),(4,'ECUADOR'),(5,'CHILE'),(6,'URUGUAY'),(7,'VENEZUELA'),(8,'COLOMBIA'),(9,'PERU'),(10,'BOLIVIA');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `cod_persona` int(15) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `cod_tipo_doc` varchar(10) DEFAULT NULL,
  `ruc_ci` varchar(20) DEFAULT NULL,
  `cod_ciudad` int(15) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `direccion_trabajo` varchar(100) DEFAULT NULL,
  `telefono_domicilio` varchar(50) DEFAULT NULL,
  `telefono_trabajo` varchar(50) DEFAULT NULL,
  `celular` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `cod_estado_civil` varchar(10) DEFAULT NULL,
  `cod_pais` int(15) DEFAULT NULL,
  `es_banco` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'ADMINISTRADOR DEL SISTEMA','',NULL,NULL,'AREGUA','','','','','2000-01-01','',NULL,NULL),(2,'VENDEDOR1','',NULL,NULL,'AREGUA','','','','','2000-01-01','',NULL,NULL),(3,'COBRADOR1','',NULL,NULL,'AREGUA','','','','','2000-01-01','',NULL,NULL),(4,'JONATHAN TORRES','CI','4749347',2,'CAACUPEMI BARRIO SAN ANTONIO','','','','0985-516-950','2000-01-01','SOL',1,NULL),(5,'RICARDO TORRES','CI','4749373',2,'CAACUPEMI BARRIO SAN ANTONIO','','','','','2000-01-01','',NULL,NULL),(6,'FRANCISCO AMARILLA','',NULL,NULL,'ISLA BOGADO','','','','','2000-01-01','',NULL,NULL),(7,'WILLIAM CESPEDES','',NULL,NULL,'LAURELTY','','','','','2000-01-01','',NULL,NULL),(8,'BANCO BAMILIAR','','',1,'ASUNCION','','','','','2000-01-01','',1,'S'),(9,'PROVEEDOR PRUEBA1','','',1,'AREGUA','','','','','2000-01-01','',1,'N'),(10,'PRUEBA PROV','','',1,'ASUNCION','','','','','2000-01-01','',NULL,'N'),(11,'OCASIONAL','CI','',1,'ASUNCION','','','','','2000-01-01','',NULL,'N'),(12,'BANCO CONTINENTAL','','',1,'ASUNCION','','','','','2000-01-01','',1,'S'),(13,'BANCO ITAU','','',1,'ASUNCION','','','','','2000-01-01','',1,'S'),(14,'BANCO NACIONAL DE FOMENTO','','',1,'ASUNCION','','','','','2000-01-01','',1,'S'),(15,'NGO','','',1,'ASUNCION','','','','','2000-01-01','',1,'N'),(16,'LASER IMPORT','','',1,'ASUNCION','','','','','2000-01-01','',NULL,'N'),(17,'EL GRAN TRIUNFO','','',1,'ASUNCION','','','','','2000-01-01','',NULL,'N');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `cod_proveedor` int(10) NOT NULL AUTO_INCREMENT,
  `cod_persona` int(10) NOT NULL,
  `cod_tipo_prov` varchar(5) DEFAULT NULL,
  `razon_social` varchar(80) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`,`cod_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,9,'GRAL',NULL,'A'),(2,10,'GRAL',NULL,'A'),(3,7,'GRAL',NULL,'A'),(4,15,'ELECT',NULL,'A'),(5,16,'ELECT',NULL,'A'),(6,17,'ELECT',NULL,'A');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo_compra_cabecera`
--

DROP TABLE IF EXISTS `recibo_compra_cabecera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo_compra_cabecera` (
  `tipo_rec_comp` varchar(3) NOT NULL,
  `ser_rec_comp` varchar(7) NOT NULL,
  `nro_rec_comp` int(10) NOT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `fecha_rec_comp` date DEFAULT NULL,
  `cod_proveedor` int(10) DEFAULT NULL,
  `cod_moneda` varchar(3) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `total_rec_comp` int(10) DEFAULT NULL,
  `comentario` varchar(80) DEFAULT NULL,
  `pagado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`tipo_rec_comp`,`ser_rec_comp`,`nro_rec_comp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_compra_cabecera`
--

LOCK TABLES `recibo_compra_cabecera` WRITE;
/*!40000 ALTER TABLE `recibo_compra_cabecera` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo_compra_cabecera` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_detalle_recibo_compra` AFTER DELETE ON `recibo_compra_cabecera` 
    FOR EACH ROW BEGIN
DELETE FROM  recibo_detalle_compra
WHERE tipo_rec_comp=old.tipo_rec_comp
AND ser_rec_comp=old.ser_rec_comp
AND nro_rec_comp=old.nro_rec_comp;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `recibo_detalle_compra`
--

DROP TABLE IF EXISTS `recibo_detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo_detalle_compra` (
  `tipo_rec_comp` varchar(3) NOT NULL,
  `ser_rec_comp` varchar(7) NOT NULL,
  `nro_rec_comp` int(10) NOT NULL,
  `tipo_transaccion` int(5) NOT NULL,
  `sub_tipo_transac` int(5) NOT NULL,
  `tipo_comprobante_ref` varchar(3) NOT NULL,
  `ser_comprobante_ref` varchar(7) NOT NULL,
  `nro_comprobante_ref` int(10) NOT NULL,
  `nro_cuota` int(5) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `monto_cuota` int(10) DEFAULT NULL,
  `importe_total` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_rec_comp`,`ser_rec_comp`,`nro_rec_comp`,`tipo_transaccion`,`sub_tipo_transac`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`,`fecha_vencimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_detalle_compra`
--

LOCK TABLES `recibo_detalle_compra` WRITE;
/*!40000 ALTER TABLE `recibo_detalle_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo_detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_saldo_proveedor_recibo_compra` AFTER INSERT ON `recibo_detalle_compra` 
    FOR EACH ROW BEGIN
UPDATE  saldo_proveedor SET saldo_cuota=(saldo_cuota-new.importe_total)
WHERE tipo_comprobante=new.tipo_comprobante_ref
AND ser_comprobante=new.ser_comprobante_ref
AND nro_comprobante=new.nro_comprobante_ref
AND nro_cuota=new.nro_cuota;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_borr_saldo_prov_recibo_compra` AFTER DELETE ON `recibo_detalle_compra` 
    FOR EACH ROW BEGIN
UPDATE  saldo_proveedor
SET saldo_cuota=(saldo_cuota+old.importe_total)
WHERE tipo_comprobante=old.tipo_comprobante_ref
AND ser_comprobante=old.ser_comprobante_ref
AND nro_comprobante=old.nro_comprobante_ref
AND nro_cuota=old.nro_cuota;
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `recibo_detalle_venta`
--

DROP TABLE IF EXISTS `recibo_detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo_detalle_venta` (
  `tipo_recibo` varchar(3) NOT NULL,
  `ser_recibo` varchar(3) NOT NULL,
  `nro_recibo` int(10) NOT NULL,
  `tipo_transaccion` int(5) NOT NULL,
  `sub_tipo_transac` int(5) NOT NULL,
  `tipo_comprobante_ref` varchar(3) NOT NULL,
  `ser_comprobante_ref` varchar(3) NOT NULL,
  `nro_comprobante_ref` int(10) NOT NULL,
  `nro_cuota` int(5) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `monto_cuota` int(10) DEFAULT NULL,
  `importe_total` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_recibo`,`ser_recibo`,`nro_recibo`,`tipo_transaccion`,`sub_tipo_transac`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`,`fecha_vencimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_detalle_venta`
--

LOCK TABLES `recibo_detalle_venta` WRITE;
/*!40000 ALTER TABLE `recibo_detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo_detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_saldo_cliente_recibo_venta` AFTER INSERT ON `recibo_detalle_venta` FOR EACH ROW BEGIN

UPDATE  saldo_cliente SET saldo_cuota=(saldo_cuota-new.importe_total)

WHERE tipo_comprobante=new.tipo_comprobante_ref

AND ser_comprobante=new.ser_comprobante_ref

AND nro_comprobante=new.nro_comprobante_ref

AND nro_cuota=new.nro_cuota;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_act_borr_saldo_cliente_recibo_venta` AFTER DELETE ON `recibo_detalle_venta` FOR EACH ROW BEGIN

UPDATE  saldo_cliente

SET saldo_cuota=(saldo_cuota+old.importe_total)

WHERE tipo_comprobante=old.tipo_comprobante_ref

AND ser_comprobante=old.ser_comprobante_ref

AND nro_comprobante=old.nro_comprobante_ref

AND nro_cuota=old.nro_cuota;

    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `recibo_venta_cabecera`
--

DROP TABLE IF EXISTS `recibo_venta_cabecera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo_venta_cabecera` (
  `tipo_recibo` varchar(3) NOT NULL,
  `ser_recibo` varchar(3) NOT NULL,
  `nro_recibo` int(10) NOT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `fecha_recibo` date DEFAULT NULL,
  `cod_cliente` int(10) DEFAULT NULL,
  `cod_cobrador` varchar(3) DEFAULT NULL,
  `cod_moneda` varchar(3) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `total_recibo` int(10) DEFAULT NULL,
  `comentario` varchar(80) DEFAULT NULL,
  `cobrado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`tipo_recibo`,`ser_recibo`,`nro_recibo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_venta_cabecera`
--

LOCK TABLES `recibo_venta_cabecera` WRITE;
/*!40000 ALTER TABLE `recibo_venta_cabecera` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo_venta_cabecera` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_borra_detalle_recibo_venta` AFTER DELETE ON `recibo_venta_cabecera` FOR EACH ROW BEGIN

DELETE FROM  recibo_detalle_venta

WHERE tipo_recibo=old.tipo_recibo

AND ser_recibo=old.ser_recibo

AND nro_recibo=old.nro_recibo;

    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `saldo_cliente`
--

DROP TABLE IF EXISTS `saldo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldo_cliente` (
  `tipo_comprobante` varchar(3) NOT NULL,
  `ser_comprobante` varchar(3) NOT NULL,
  `nro_comprobante` int(10) NOT NULL,
  `nro_cuota` int(5) NOT NULL,
  `cod_sucursal` varchar(2) DEFAULT NULL,
  `cod_cliente` int(10) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `monto_cuota` int(10) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `saldo_cuota` int(10) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldo_cliente`
--

LOCK TABLES `saldo_cliente` WRITE;
/*!40000 ALTER TABLE `saldo_cliente` DISABLE KEYS */;
INSERT INTO `saldo_cliente` VALUES ('FCR','A',1,1,'01',1,'2018-01-28',83333,'01',0,'root'),('FCR','A',1,2,'01',1,'2018-02-28',83333,'01',83333,'root'),('FCR','A',1,3,'01',1,'2018-03-28',83333,'01',83333,'root');
/*!40000 ALTER TABLE `saldo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saldo_proveedor`
--

DROP TABLE IF EXISTS `saldo_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldo_proveedor` (
  `tipo_comprobante` varchar(3) NOT NULL,
  `ser_comprobante` varchar(15) NOT NULL,
  `nro_comprobante` int(10) NOT NULL,
  `nro_cuota` int(5) NOT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `cod_proveedor` int(10) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `monto_cuota` int(10) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `saldo_cuota` int(10) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldo_proveedor`
--

LOCK TABLES `saldo_proveedor` WRITE;
/*!40000 ALTER TABLE `saldo_proveedor` DISABLE KEYS */;
INSERT INTO `saldo_proveedor` VALUES ('FCR','001-001',1,1,'01',3,'2018-04-19',3100000,'01',3100000,'root'),('FCR','001-001',2,1,'01',5,'2018-05-19',5700000,'01',5700000,'root'),('FCR','001-001',3,1,'01',6,'2018-03-19',2100000,'01',2100000,'root');
/*!40000 ALTER TABLE `saldo_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie_comprobante`
--

DROP TABLE IF EXISTS `serie_comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serie_comprobante` (
  `tipo_comprobante` varchar(3) NOT NULL,
  `ser_comprobante` varchar(2) NOT NULL,
  `numero_inicial` int(15) DEFAULT NULL,
  `numero_final` int(15) DEFAULT NULL,
  `ser_timbrado` varchar(30) DEFAULT NULL,
  `numero_timbrado` varchar(30) DEFAULT NULL,
  `fecha_vigencia` date DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie_comprobante`
--

LOCK TABLES `serie_comprobante` WRITE;
/*!40000 ALTER TABLE `serie_comprobante` DISABLE KEYS */;
INSERT INTO `serie_comprobante` VALUES ('FCO','A',NULL,NULL,'001-001-001',NULL,'2018-05-01','01'),('FCR','A',NULL,NULL,'001-001-001','456123','2018-05-01','01'),('FCR','C',NULL,NULL,'001-001-003',NULL,'2018-05-01','01'),('REC','A',NULL,NULL,'001-001-001','',NULL,'01'),('REC','B',NULL,NULL,'001-001-002',NULL,NULL,'01'),('REC','C',NULL,NULL,'001-001-003',NULL,NULL,'01');
/*!40000 ALTER TABLE `serie_comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_tipo_transaccion`
--

DROP TABLE IF EXISTS `sub_tipo_transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_tipo_transaccion` (
  `cod_sub_tipo_trans` int(5) NOT NULL AUTO_INCREMENT,
  `cod_tipo_trans` int(5) NOT NULL,
  `cod_modulo` varchar(5) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_sub_tipo_trans`,`cod_tipo_trans`,`cod_modulo`),
  UNIQUE KEY `cod_sub_tipo_trans` (`cod_sub_tipo_trans`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_tipo_transaccion`
--

LOCK TABLES `sub_tipo_transaccion` WRITE;
/*!40000 ALTER TABLE `sub_tipo_transaccion` DISABLE KEYS */;
INSERT INTO `sub_tipo_transaccion` VALUES (1,1,'CC','CANCELACION DE COMPROBANTE VENTA',NULL),(2,1,'CC','COBROS A CUENTA',NULL),(3,1,'CC','A APLICAR',NULL),(4,2,'CC','EFECTIVO',NULL),(5,2,'CC','CHEQUE',NULL),(6,3,'CC','TARJETA',NULL),(7,3,'ST','ENTRADA DE ARTICULOS EN STOCK POR COMPRAS','A'),(8,3,'ST','ENTRADA DE ARTICULOS EN STOCK POR AJUSTE','A'),(9,3,'ST','ENTRADA DE ARTICULOS EN STOCK POR NOTAS DE CREDITO','A'),(10,4,'ST','SALIDA DE ARTICULOS POR VENTAS','A'),(11,4,'ST','SALIDA DE ARTICULOS POR AJUSTE','A'),(12,4,'ST','SALIDA DE ARTICULOS POR NOTAS DE CREDITO','A'),(13,5,'CP','CANCELACION COMPROBANTE COMPRA','A'),(14,5,'CP','PAGOS A CUENTA','A');
/*!40000 ALTER TABLE `sub_tipo_transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `cod_sucursal` varchar(10) NOT NULL,
  `desc_sucursal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES ('01','AREGUA'),('02','LUQUE');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talonario`
--

DROP TABLE IF EXISTS `talonario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talonario` (
  `tipo_talonario` varchar(3) NOT NULL,
  `nro_talonario` int(5) NOT NULL,
  `serie` varchar(2) NOT NULL,
  `numero_inicial` int(15) DEFAULT NULL,
  `numero_final` int(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tipo_talonario`,`nro_talonario`,`serie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talonario`
--

LOCK TABLES `talonario` WRITE;
/*!40000 ALTER TABLE `talonario` DISABLE KEYS */;
INSERT INTO `talonario` VALUES ('FCO',1,'A',1,500,'A','01'),('FCO',2,'B',500,1000,'A','01'),('FCR',1,'A',1,500,'A','01'),('FCR',2,'B',500,1000,'A','01'),('REC',1,'A',1,500,'A','01'),('REC',2,'B',500,1000,'A','01');
/*!40000 ALTER TABLE `talonario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talonario_usuario`
--

DROP TABLE IF EXISTS `talonario_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talonario_usuario` (
  `tipo_talonario` varchar(3) NOT NULL,
  `nro_talonario` int(5) NOT NULL,
  `cod_usuario` varchar(15) NOT NULL,
  PRIMARY KEY (`tipo_talonario`,`nro_talonario`,`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talonario_usuario`
--

LOCK TABLES `talonario_usuario` WRITE;
/*!40000 ALTER TABLE `talonario_usuario` DISABLE KEYS */;
INSERT INTO `talonario_usuario` VALUES ('FCO',1,'jony'),('FCO',1,'root'),('FCR',1,'jony'),('FCR',1,'root'),('REC',1,'jony'),('REC',1,'root');
/*!40000 ALTER TABLE `talonario_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_cliente` (
  `cod_tipo_cliente` varchar(10) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES ('00','GRAL'),('01','NORMAL'),('02','MAYORISTA');
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_comprobante`
--

DROP TABLE IF EXISTS `tipo_comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_comprobante` (
  `tipo_comprobante` varchar(3) NOT NULL,
  `cod_modulo` varchar(3) NOT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `lineas` int(2) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`cod_modulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_comprobante`
--

LOCK TABLES `tipo_comprobante` WRITE;
/*!40000 ALTER TABLE `tipo_comprobante` DISABLE KEYS */;
INSERT INTO `tipo_comprobante` VALUES ('FCR','VT','FACTURA CREDITO',10),('NCR','VT','NOTA DE CREDITO',5),('REC','CC','RECIBO',5);
/*!40000 ALTER TABLE `tipo_comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_documento` (
  `cod_tipo_doc` varchar(10) NOT NULL,
  `Desc_tipo_doc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES ('CI','CEDULA DE INDENTIDAD'),('DOCEX','DOCUMENTO EXTRANJERO'),('PAS','PASAPORTE'),('RUC','REGISTRO UNICO CONTRIBUYENTE');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_prov_client`
--

DROP TABLE IF EXISTS `tipo_prov_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_prov_client` (
  `cod_tipo_provcl` varchar(10) NOT NULL,
  `desc_tipo_provcl` varchar(80) NOT NULL,
  PRIMARY KEY (`cod_tipo_provcl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_prov_client`
--

LOCK TABLES `tipo_prov_client` WRITE;
/*!40000 ALTER TABLE `tipo_prov_client` DISABLE KEYS */;
INSERT INTO `tipo_prov_client` VALUES ('ELECT','ELECTRICOS/ELECTRONICOS'),('GRAL','GENERAL'),('INSOF','INSUMOS P/OFICINAS');
/*!40000 ALTER TABLE `tipo_prov_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_transaccion`
--

DROP TABLE IF EXISTS `tipo_transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_transaccion` (
  `cod_tipo_trans` int(5) NOT NULL AUTO_INCREMENT,
  `cod_modulo` varchar(5) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_trans`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_transaccion`
--

LOCK TABLES `tipo_transaccion` WRITE;
/*!40000 ALTER TABLE `tipo_transaccion` DISABLE KEYS */;
INSERT INTO `tipo_transaccion` VALUES (1,'CC','CONCEPTO PARA RECIBOS','A'),(2,'CC','CONCEPTO PARA COBROS','A'),(3,'ST','ENTRADAS DE ARTICULOS','A'),(4,'ST','SALIDAS DE ARTICULOS','A'),(5,'CP','CONCEPTO PARA PAGOS','A'),(6,'CP','CONCEPTO FORMA DE PAGOS','A');
/*!40000 ALTER TABLE `tipo_transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `cod_usuario` varchar(10) NOT NULL,
  `clave_usuario` varchar(50) DEFAULT NULL,
  `cod_persona` int(15) DEFAULT NULL,
  `cod_grupo` varchar(15) DEFAULT NULL,
  `cod_sucursal` varchar(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('ADMIN','ADMINISTRA',1,'ADMIN','01','A'),('jony','administrador',4,'ADMIN','01','A'),('root','manager',1,'ADMIN','01','A');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendedor` (
  `cod_vendedor` int(10) NOT NULL AUTO_INCREMENT,
  `cod_persona` int(10) DEFAULT NULL,
  `cod_zona` varchar(10) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `porc_comision` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_vendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (1,2,NULL,'VENTAS1',10,'A'),(2,9,NULL,'VENTAS2',10,'A');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_articulo`
--

DROP TABLE IF EXISTS `view_articulo`;
/*!50001 DROP VIEW IF EXISTS `view_articulo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_articulo` AS SELECT 
 1 AS `cod_articulo`,
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `cod_deposito`,
 1 AS `desc_deposito`,
 1 AS `desc_articulo`,
 1 AS `cod_proveedor`,
 1 AS `nombre_prov`,
 1 AS `razon_social`,
 1 AS `cod_marca`,
 1 AS `desc_marca`,
 1 AS `cod_categoria`,
 1 AS `desc_categoria`,
 1 AS `precio_compra`,
 1 AS `precio_venta`,
 1 AS `cantidad`,
 1 AS `cod_iva`,
 1 AS `desc_iva`,
 1 AS `estado`,
 1 AS `man_stock`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_cliente`
--

DROP TABLE IF EXISTS `view_cliente`;
/*!50001 DROP VIEW IF EXISTS `view_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_cliente` AS SELECT 
 1 AS `cod_cliente`,
 1 AS `cod_persona`,
 1 AS `nombre`,
 1 AS `cod_moneda`,
 1 AS `desc_moneda`,
 1 AS `cod_cobrador`,
 1 AS `cobrador`,
 1 AS `cod_vendedor`,
 1 AS `vendedor`,
 1 AS `limite_credito`,
 1 AS `cod_condicion_venta`,
 1 AS `condicion`,
 1 AS `cod_tipo_clien`,
 1 AS `tipo_cliente`,
 1 AS `estado`,
 1 AS `comentario`,
 1 AS `ruc_ci`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_comprob_compra_cab_det`
--

DROP TABLE IF EXISTS `view_comprob_compra_cab_det`;
/*!50001 DROP VIEW IF EXISTS `view_comprob_compra_cab_det`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_comprob_compra_cab_det` AS SELECT 
 1 AS `tipo_comp`,
 1 AS `tipo_comprobante`,
 1 AS `serie_comp`,
 1 AS `nro_comp`,
 1 AS `nro_timbrado_comp`,
 1 AS `fecha_comprob`,
 1 AS `cod_usuario`,
 1 AS `nomb_usuario`,
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `cod_deposito`,
 1 AS `desc_deposito`,
 1 AS `cod_proveedor`,
 1 AS `nomb_proveedor`,
 1 AS `cond_comp`,
 1 AS `descripcion`,
 1 AS `cant_cuota`,
 1 AS `fecha_inic_comp`,
 1 AS `monto_cuota`,
 1 AS `total_comp`,
 1 AS `total_iva_comp`,
 1 AS `total_grav_comp`,
 1 AS `cod_moneda`,
 1 AS `desc_moneda`,
 1 AS `tipo_cambio`,
 1 AS `estado`,
 1 AS `cod_articulo`,
 1 AS `desc_articulo`,
 1 AS `cant_articulo`,
 1 AS `precio_unitario`,
 1 AS `descuento`,
 1 AS `importe`,
 1 AS `iva5`,
 1 AS `iva10`,
 1 AS `gravada5`,
 1 AS `gravada10`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_comprob_venta_cab_det`
--

DROP TABLE IF EXISTS `view_comprob_venta_cab_det`;
/*!50001 DROP VIEW IF EXISTS `view_comprob_venta_cab_det`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_comprob_venta_cab_det` AS SELECT 
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `tipo_comprobante`,
 1 AS `ser_comprobante`,
 1 AS `nro_comprobante`,
 1 AS `fecha_comprobante`,
 1 AS `cod_cliente`,
 1 AS `nombre_cliente`,
 1 AS `cod_cobrador`,
 1 AS `nombre_cobrador`,
 1 AS `cod_vendedor`,
 1 AS `nombre_vendedor`,
 1 AS `cod_condicion_venta`,
 1 AS `descripcion`,
 1 AS `cod_moneda`,
 1 AS `desc_moneda`,
 1 AS `cod_articulo`,
 1 AS `cantidad`,
 1 AS `desc_articulo`,
 1 AS `precio_unitario`,
 1 AS `importe_total`,
 1 AS `total_iva5`,
 1 AS `total_iva10`,
 1 AS `gravada_5`,
 1 AS `gravada_10`,
 1 AS `total_gravada`,
 1 AS `total_iva`,
 1 AS `total_comprobante`,
 1 AS `cod_deposito`,
 1 AS `desc_deposito`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_existencia_articulo`
--

DROP TABLE IF EXISTS `view_existencia_articulo`;
/*!50001 DROP VIEW IF EXISTS `view_existencia_articulo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_existencia_articulo` AS SELECT 
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `cod_deposito`,
 1 AS `desc_deposito`,
 1 AS `cod_articulo`,
 1 AS `desc_articulo`,
 1 AS `existencia`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_mov_caja_compra`
--

DROP TABLE IF EXISTS `view_mov_caja_compra`;
/*!50001 DROP VIEW IF EXISTS `view_mov_caja_compra`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_mov_caja_compra` AS SELECT 
 1 AS `tipo_mov_comp`,
 1 AS `ser_mov_comp`,
 1 AS `nro_mov_comp`,
 1 AS `fecha_mov_comp`,
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `cod_proveedor`,
 1 AS `nomb_proveedor`,
 1 AS `cod_usuario`,
 1 AS `nomb_usuario`,
 1 AS `total_mov_comp`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_mov_caja_venta`
--

DROP TABLE IF EXISTS `view_mov_caja_venta`;
/*!50001 DROP VIEW IF EXISTS `view_mov_caja_venta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_mov_caja_venta` AS SELECT 
 1 AS `tipo_mov_caja`,
 1 AS `ser_mov_caja`,
 1 AS `nro_mov_caja`,
 1 AS `fecha_mov_caja_venta`,
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `cod_cliente`,
 1 AS `nomb_cliente`,
 1 AS `cod_usuario`,
 1 AS `nomb_usuario`,
 1 AS `cod_caja`,
 1 AS `desc_caja`,
 1 AS `numero_hab`,
 1 AS `total_mov_caja`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_persona`
--

DROP TABLE IF EXISTS `view_persona`;
/*!50001 DROP VIEW IF EXISTS `view_persona`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_persona` AS SELECT 
 1 AS `cod_persona`,
 1 AS `nombre`,
 1 AS `cod_tipo_doc`,
 1 AS `Desc_tipo_doc`,
 1 AS `ruc_ci`,
 1 AS `cod_ciudad`,
 1 AS `desc_ciudad`,
 1 AS `direccion`,
 1 AS `direccion_trabajo`,
 1 AS `telefono_domicilio`,
 1 AS `telefono_trabajo`,
 1 AS `celular`,
 1 AS `fecha_nacimiento`,
 1 AS `cod_estado_civil`,
 1 AS `desc_estado_civil`,
 1 AS `cod_pais`,
 1 AS `desc_pais`,
 1 AS `es_banco`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_recibo_compra`
--

DROP TABLE IF EXISTS `view_recibo_compra`;
/*!50001 DROP VIEW IF EXISTS `view_recibo_compra`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_recibo_compra` AS SELECT 
 1 AS `cod_usuario`,
 1 AS `nomb_usuario`,
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `tipo_recibo`,
 1 AS `ser_recibo`,
 1 AS `nro_recibo`,
 1 AS `fecha_recibo`,
 1 AS `cod_proveedor`,
 1 AS `nomb_cliente`,
 1 AS `cod_moneda`,
 1 AS `desc_moneda`,
 1 AS `total_recibo`,
 1 AS `comentario`,
 1 AS `tipo_transaccion`,
 1 AS `sub_tipo_transac`,
 1 AS `tipo_comprobante_ref`,
 1 AS `ser_comprobante_ref`,
 1 AS `nro_comprobante_ref`,
 1 AS `nro_cuota`,
 1 AS `fecha_vencimiento`,
 1 AS `monto_cuota`,
 1 AS `importe_total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_recibo_venta`
--

DROP TABLE IF EXISTS `view_recibo_venta`;
/*!50001 DROP VIEW IF EXISTS `view_recibo_venta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_recibo_venta` AS SELECT 
 1 AS `cod_usuario`,
 1 AS `nomb_usuario`,
 1 AS `cod_sucursal`,
 1 AS `desc_sucursal`,
 1 AS `tipo_recibo`,
 1 AS `ser_recibo`,
 1 AS `nro_recibo`,
 1 AS `fecha_recibo`,
 1 AS `cod_cliente`,
 1 AS `nomb_cliente`,
 1 AS `cod_cobrador`,
 1 AS `nomb_cobrador`,
 1 AS `cod_moneda`,
 1 AS `desc_moneda`,
 1 AS `total_recibo`,
 1 AS `comentario`,
 1 AS `tipo_transaccion`,
 1 AS `sub_tipo_transac`,
 1 AS `tipo_comprobante_ref`,
 1 AS `ser_comprobante_ref`,
 1 AS `nro_comprobante_ref`,
 1 AS `nro_cuota`,
 1 AS `fecha_vencimiento`,
 1 AS `monto_cuota`,
 1 AS `importe_total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_saldo_cliente`
--

DROP TABLE IF EXISTS `view_saldo_cliente`;
/*!50001 DROP VIEW IF EXISTS `view_saldo_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_saldo_cliente` AS SELECT 
 1 AS `tipo_comprobante`,
 1 AS `ser_comprobante`,
 1 AS `nro_comprobante`,
 1 AS `cod_cliente`,
 1 AS `nombre`,
 1 AS `nro_cuota`,
 1 AS `fec_venc`,
 1 AS `fecha_vencimiento`,
 1 AS `saldo_cuota`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_saldo_proveedor`
--

DROP TABLE IF EXISTS `view_saldo_proveedor`;
/*!50001 DROP VIEW IF EXISTS `view_saldo_proveedor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_saldo_proveedor` AS SELECT 
 1 AS `tipo_comprobante`,
 1 AS `ser_comprobante`,
 1 AS `nro_comprobante`,
 1 AS `cod_proveedor`,
 1 AS `nombre`,
 1 AS `nro_cuota`,
 1 AS `fec_venc`,
 1 AS `fecha_vencimiento`,
 1 AS `saldo_cuota`,
 1 AS `monto_cuota`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'compra_venta'
--

--
-- Dumping routines for database 'compra_venta'
--
/*!50003 DROP FUNCTION IF EXISTS `retorna_nro_comp_venta_inicial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_nro_comp_venta_inicial`(sc varchar(5),tp VARCHAR(5),sr VARCHAR(2)) RETURNS int(11)
BEGIN

DECLARE nro INT;

  SELECT t.numero_inicial

  into nro

  FROM talonario t

  WHERE t.cod_sucursal=sc AND t.serie=sr AND t.tipo_talonario=tp;

RETURN nro;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `retorna_porc_iva_art` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_porc_iva_art`(cod VARCHAR(20)) RETURNS int(11)
BEGIN

DECLARE iva INT;

SELECT p.cod_iva INTO iva

     FROM articulo p 

     WHERE p.cod_articulo=cod;

RETURN iva;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `retorna_usuario_grupo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_usuario_grupo`(nom VARCHAR(20)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN

      DECLARE n VARCHAR(10);

     SELECT cod_grupo INTO n

     FROM usuario 

     WHERE cod_usuario=nom;

RETURN n;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_codigo_prod` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_codigo_prod`(cod VARCHAR(50),suc VARCHAR(5),dep VARCHAR(5)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
DECLARE s VARCHAR(15);
SELECT cod_articulo INTO s
FROM articulo 
WHERE cod_articulo=cod
       and cod_sucursal=suc
       and cod_deposito=dep;
IF s=cod  THEN
SET mens="S";
ELSE
SET mens="N";
END IF;
RETURN mens;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_exisc_saldo_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exisc_saldo_cliente`(cod INT) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN

DECLARE mens VARCHAR(5);

      DECLARE s INT(15);

      SELECT  sum(saldo_cuota) INTO s

     FROM saldo_cliente 

     WHERE cod_cliente=cod  AND

           saldo_cuota<>0;

     IF s<>0   THEN

     SET mens="S";

     ELSE

      SET mens="N";

       END IF;

RETURN mens;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_exisc_saldo_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exisc_saldo_proveedor`(cod INT) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
      DECLARE s INT(15);
      SELECT  SUM(saldo_cuota) INTO s
     FROM saldo_proveedor 
     WHERE cod_proveedor=cod  AND
           saldo_cuota<>0;
     IF s<>0   THEN
     SET mens="S";
     ELSE
      SET mens="N";
       END IF;
RETURN mens;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_existencia_nro_comprobante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_existencia_nro_comprobante`(sucur VARCHAR(5),seri varchar(5),numer int(10)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN

DECLARE mens VARCHAR(5);

DECLARE s VARCHAR(15);

SELECT c.nro_comprobante INTO s

FROM comprobante_cabecera_venta c

WHERE c.cod_sucursal=sucur and c.ser_comprobante=seri and c.nro_comprobante=numer;

IF s=numer  THEN

SET mens="S";

ELSE

SET mens="N";

END IF;

RETURN mens;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_existencia_nro_recibo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_existencia_nro_recibo`(sucur VARCHAR(5),seri VARCHAR(5),numer INT(10)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN

DECLARE mens VARCHAR(5);

DECLARE s VARCHAR(15);

SELECT c.nro_recibo INTO s

FROM recibo_venta_cabecera c

WHERE c.cod_sucursal=sucur AND c.ser_recibo=seri AND c.nro_recibo=numer;

IF s=numer  THEN

SET mens="S";

ELSE

SET mens="N";

END IF;

RETURN mens;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_exist_nro_comp_comp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exist_nro_comp_comp`(sucur VARCHAR(5),seri VARCHAR(15),numer INT(10)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
DECLARE s VARCHAR(15);
SELECT c.nro_comprob_comp INTO s
FROM comprobante_cabecera_compra c
WHERE c.cod_sucursal=sucur AND c.ser_timb_comp=seri AND c.nro_comprob_comp=numer;
IF s=numer  THEN
SET mens="S";
ELSE
SET mens="N";
END IF;
RETURN mens;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_exist_nro_rec_comp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exist_nro_rec_comp`(sucur VARCHAR(5),seri VARCHAR(7),numer INT(10)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
DECLARE s VARCHAR(15);
SELECT c.nro_rec_comp INTO s
FROM recibo_compra_cabecera c
WHERE c.cod_sucursal=sucur AND c.ser_rec_comp=seri AND c.nro_rec_comp=numer;
IF s=numer  THEN
SET mens="S";
ELSE
SET mens="N";
END IF;
RETURN mens;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_exist_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exist_usuario`(nom VARCHAR(20),cla VARCHAR(20)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN

      DECLARE mens VARCHAR(20);

      DECLARE n VARCHAR(20);

      DECLARE c VARCHAR(20);

     SELECT cod_usuario,clave_usuario INTO n,c

     FROM usuario 

     WHERE cod_usuario=nom AND clave_usuario=cla;

     IF n=nom AND c=cla THEN

     SET mens="S";

     ELSE

      SET mens="N";

       END IF;

RETURN mens;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `verif_nro_doc_pers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `verif_nro_doc_pers`(cod VARCHAR(15)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
DECLARE s VARCHAR(15);
SELECT IFNULL(ruc_ci,'N') INTO s
FROM persona 
WHERE ruc_ci=IFNULL(cod,'N');
IF s=cod  and s <> '' THEN
SET mens="S";
ELSE
SET mens="N";
END IF;
RETURN mens;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_acceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_acceso`(IN codigo_grupo VARCHAR(10),IN codigo_modulo VARCHAR(10),IN codigo_form VARCHAR(10),IN grupo VARCHAR(10),IN modulo VARCHAR(5),IN formulario VARCHAR(10),IN inserta VARCHAR(1),IN modif VARCHAR(1),IN borrar VARCHAR(1),IN consul VARCHAR(1),IN menu VARCHAR(1))
BEGIN

UPDATE acceso_grupo set cod_grupo=grupo,cod_modulo=modulo,desc_formulario=formulario,puede_insert=inserta,puede_modif=modif,puede_borrar=borrar,puede_consul=consul,mostrar_en_menu=menu where cod_grupo=codigo_grupo and cod_modulo=codigo_modulo and desc_formulario=codigo_form;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_articulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_articulo`(IN codigo VARCHAR(50),IN codigo_suc VARCHAR(10),IN codigo_dep VARCHAR(10),IN articulo VARCHAR(10),IN sucursal VARCHAR(10),IN deposito VARCHAR(10),IN desc_art VARCHAR(80),IN proveedor VARCHAR(10),IN marca VARCHAR(10),IN categoria VARCHAR(10),IN pre_compra INT(10),IN pre_venta INT(10),IN cantid INT(10),IN iva VARCHAR(10),IN estad VARCHAR(1),IN mane_stock VARCHAR(1))
BEGIN
UPDATE articulo SET cod_articulo=articulo,cod_sucursal=sucursal,cod_deposito=deposito,desc_articulo=desc_art,cod_proveedor=proveedor,cod_marca=marca,cod_categoria=categoria,precio_compra=pre_compra,precio_venta=pre_venta,cantidad=cantid,cod_iva=iva,estado=estad,maneja_stock=mane_stock WHERE cod_articulo=codigo and cod_sucursal=codigo_suc and cod_deposito=codigo_dep;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cliente`(in codigo int(15),IN cod_per int(15),IN cod_mon VARCHAR(5),IN cod_cob VARCHAR(20),IN cod_ven VARCHAR(20),IN limite_cre int(10),IN cod_cond int(10),IN tipo_cli VARCHAR(10),IN est VARCHAR(1),IN comen VARCHAR(80))
BEGIN

UPDATE  cliente SET cod_persona=cod_per,cod_moneda=cod_mon,cod_cobrador=cod_cob,cod_vendedor=cod_ven,limite_credito=limite_cre,cod_condicion_venta=cod_cond,tipo_cliente=tipo_cli,estado=est,comentario=comen where cod_cliente=codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_condicion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_condicion`(IN codigo int(10),IN cod_cond INT(10),IN descr VARCHAR(80),IN nro_cuota INT(5),IN dia_ini INT(5),IN plaz INT(10),IN est VARCHAR(1))
BEGIN

UPDATE condicion_venta set cod_condicion=cod_cond,descripcion=descr,numero_cuota=nro_cuota,dia_inicial=dia_ini,plazo=plaz,estado=est where cod_condicion=codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_persona`(IN codigo INT(10),IN nombre VARCHAR(80),IN cod_tipo_doc varchar(10),IN ruc_ci VARCHAR(15),IN cod_ciudad INT(10),IN direccion VARCHAR(100),IN direccion_trabajo VARCHAR(100),IN telefono_domicilio VARCHAR(20),IN telefono_trabajo VARCHAR(20),IN celular VARCHAR(15),IN fecha_nacimiento DATE,IN cod_estado_civil VARCHAR (5),IN cod_pais INT(15),in es_ban varchar(1))
BEGIN

UPDATE persona SET nombre=nombre,cod_tipo_doc=cod_tipo_doc,ruc_ci=ruc_ci,cod_ciudad=cod_ciudad,direccion=direccion,direccion_trabajo=direccion_trabajo,telefono_domicilio=telefono_domicilio,telefono_trabajo=telefono_trabajo,celular=celular,fecha_nacimiento=fecha_nacimiento,cod_estado_civil=cod_estado_civil,cod_pais=cod_pais,es_banco=es_ban WHERE cod_persona=codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_proveedor`(in cod int(10),IN cod_perso INT(15),in cod_tipo_pr varchar(5),in est varchar(1))
BEGIN
update proveedor set cod_persona=cod_perso,cod_tipo_prov=cod_tipo_pr,estado=est where cod_proveedor=cod;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualiza_exist_art_borr_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_compra`(IN art VARCHAR(50),IN cant INT(5),IN suc VARCHAR(5),IN dep VARCHAR(5))
BEGIN
UPDATE  existencia_articulo
SET cantidad=(cantidad-cant)
WHERE cod_sucursal=suc
AND cod_deposito=dep
AND cod_articulo=art
AND tipo_transacc=3
AND sub_tipo_transacc=7;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualiza_exist_art_borr_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_venta`(IN art VARCHAR(50),in cant INT(5),in suc varchar(5),in dep varchar(5))
BEGIN
UPDATE  existencia_articulo
SET cantidad=(cantidad-cant)
WHERE cod_sucursal=suc
AND cod_deposito=dep
AND cod_articulo=art
AND tipo_transacc=4
AND sub_tipo_transacc=10;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_acceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_acceso`(IN codigo VARCHAR(10),IN modulo VARCHAR(10),IN form VARCHAR(10))
BEGIN

DELETE FROM acceso_grupo WHERE cod_grupo=codigo and cod_modulo=modulo and desc_formulario=form;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_articulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_articulo`(IN codigo VARCHAR(10),IN cod_suc VARCHAR(10),in cod_dep VARCHAR(10))
BEGIN
DELETE FROM articulo WHERE cod_articulo=codigo AND cod_sucursal=cod_suc and cod_deposito=cod_dep;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente`(IN codigo VARCHAR(10))
BEGIN

DELETE FROM cliente WHERE cod_cliente=codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_condicion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_condicion`(IN codigo int(10))
BEGIN

DELETE FROM condicion_venta WHERE cod_condicion=codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_persona`(IN codigo Varchar(10))
BEGIN

DELETE FROM persona WHERE cod_persona=codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_proveedor`(in cod int(10))
BEGIN
delete from proveedor  where cod_proveedor=cod;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elimina_comprobante_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_comprobante_compra`(tpcom VARCHAR(5),secom VARCHAR(15),nucom INT )
BEGIN
DELETE FROM comprobante_cabecera_compra WHERE cod_tipo_comp=tpcom AND ser_timb_comp=secom AND nro_comprob_comp=nucom;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elimina_comprobante_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_comprobante_venta`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN

DELETE FROM comprobante_cabecera_venta WHERE tipo_comprobante=tpcom AND ser_comprobante=secom AND nro_comprobante=nucom;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elimina_mov_caja_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_mov_caja_compra`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM movimiento_caja_compra WHERE tipo_mov_caja_com=tpcom AND ser_mov_caja_com=secom AND nro_mov_caja_com=nucom;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elimina_mov_caja_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_mov_caja_venta`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN

DELETE FROM movimiento_caja_venta WHERE tipo_mov_caja=tpcom AND ser_mov_caja=secom AND nro_mov_caja=nucom;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elimina_recibo_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_recibo_compra`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM recibo_compra_cabecera WHERE tipo_rec_comp=tpcom AND ser_rec_comp=secom AND nro_rec_comp=nucom;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elimina_recibo_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_recibo_venta`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN

DELETE FROM recibo_venta_cabecera WHERE tipo_recibo=tpcom AND ser_recibo=secom AND nro_recibo=nucom;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_saldo_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_saldo_cliente`(IN tipo VARCHAR(3),IN ser VARCHAR(2),IN numero INT,in cant_cuo int, in suc varchar(2),IN cliente INT,IN fecha DATE,IN monto INT,IN mon VARCHAR(5),IN saldo INT,us varchar(10))
BEGIN

DECLARE i INT;

DECLARE f DATE;

SET i=1;

WHILE i <= cant_cuo DO

INSERT INTO saldo_cliente(tipo_comprobante,ser_comprobante,nro_comprobante,nro_cuota,cod_sucursal,cod_cliente,fecha_vencimiento,monto_cuota,cod_moneda,saldo_cuota,cod_usuario) VALUES(tipo,ser,numero,i,suc,cliente,ADDDATE(fecha,INTERVAL I MONTH),monto,mon,saldo,us);

SET i = i + 1;

END WHILE;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_saldo_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_saldo_proveedor`(IN tipo VARCHAR(3),IN ser VARCHAR(15),IN numero INT,IN cant_cuo INT, IN suc VARCHAR(5),IN cliente INT,IN fecha DATE,IN monto INT,IN mon VARCHAR(5),IN saldo INT,us VARCHAR(10))
BEGIN
DECLARE i INT;
DECLARE f DATE;
SET i=1;
/*WHILE i <= cant_cuo DO*/
INSERT INTO saldo_proveedor(tipo_comprobante,ser_comprobante,nro_comprobante,nro_cuota,cod_sucursal,cod_proveedor,fecha_vencimiento,monto_cuota,cod_moneda,saldo_cuota,cod_usuario) VALUES(tipo,ser,numero,1,suc,cliente,ADDDATE(fecha,INTERVAL cant_cuo MONTH),monto,mon,saldo,us);
/*SET i = i + 1;
END WHILE;*/
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_acceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_acceso`(IN cod_grupo VARCHAR(10),IN cod_modulo VARCHAR(5),IN desc_formulario VARCHAR(10),IN puede_insert VARCHAR(1),IN puede_modif VARCHAR(1),IN puede_borrar VARCHAR(1),IN puede_consul VARCHAR(1),IN mostrar_en_menu VARCHAR(1))
BEGIN

INSERT INTO acceso_grupo(cod_grupo,cod_modulo,desc_formulario,puede_insert,puede_modif,puede_borrar,puede_consul,mostrar_en_menu) VALUES(cod_grupo,cod_modulo,desc_formulario,puede_insert,puede_modif,puede_borrar,puede_consul,mostrar_en_menu);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_articulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_articulo`(IN cod_articulo VARCHAR(10),IN cod_sucursal VARCHAR(10),IN cod_deposito VARCHAR(10),IN desc_articulo VARCHAR(80),IN cod_proveedor VARCHAR(10),IN cod_marca VARCHAR(10),IN cod_categoria VARCHAR(10),IN precio_compra int(10),IN precio_venta int(10),IN cantidad int(10),IN cod_iva VARCHAR(10),IN estado VARCHAR(1),IN maneja_stock VARCHAR(1))
BEGIN
INSERT INTO articulo(cod_articulo,cod_sucursal,cod_deposito,desc_articulo,cod_proveedor,cod_marca,cod_categoria,precio_compra,precio_venta,cantidad,cod_iva,estado,maneja_stock) VALUES(cod_articulo,cod_sucursal,cod_deposito,desc_articulo,cod_proveedor,cod_marca,cod_categoria,precio_compra,precio_venta,cantidad,cod_iva,estado,maneja_stock);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cliente`(IN cod_persona int(15),IN cod_moneda VARCHAR(5),IN cod_cobrador VARCHAR(20),IN cod_vendedor VARCHAR(20),IN limite_credito int(10),IN cod_condicion_venta int(10),IN tipo_cliente VARCHAR(10),IN estado VARCHAR(1),IN comentario VARCHAR(80))
BEGIN

INSERT INTO cliente(cod_persona,cod_moneda,cod_cobrador,cod_vendedor,limite_credito,cod_condicion_venta,tipo_cliente,estado,comentario) VALUES(cod_persona,cod_moneda,cod_cobrador,cod_vendedor,limite_credito,cod_condicion_venta,tipo_cliente,estado,comentario);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_compra_cabecera`(IN tipo_comp VARCHAR(3),IN ser_timb VARCHAR(15),IN nro_comprob INT(15),in nro_timb varchar(30),IN fecha_comprobante DATE,IN cod_us VARCHAR(10),IN cod_suc VARCHAR(5),IN cod_dep VARCHAR(5),IN cod_proveedor INT(10),IN cod_cond INT(5),in cant_cuo int(5),in fec_inic_comp date,in mont_cuo int(10),IN total_comprobante INT(15),IN total_iva INT(15),IN total_gravada INT(15),IN cod_moneda VARCHAR(5),in ti_camb int(10),IN est VARCHAR(1))
BEGIN
INSERT INTO comprobante_cabecera_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,nro_timbrado,fecha_comprob_comp,cod_usuario,cod_sucursal,cod_deposito,cod_proveedor,cod_cond_comp,cant_cuota,fecha_inic_comp,monto_cuota,total_comprob_comp,iva_comp,gravada,cod_moneda,tipo_cambio,estado) VALUES(tipo_comp,ser_timb,nro_comprob,nro_timb,fecha_comprobante,cod_us,cod_suc,cod_dep,cod_proveedor,cod_cond,cant_cuo,fec_inic_comp,mont_cuo,total_comprobante,total_iva,total_gravada,cod_moneda,ti_camb,est);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_compra_detalle`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(15),IN nro_comprobante INT(15),IN cod_articulo VARCHAR(50),in desc_articulo varchar(100),IN cantidad INT(10),IN precio_unitario INT(10),IN descuento INT(10),IN importe INT(10),IN total_iva5 INT(10),IN total_iva10 INT(10),IN gravada_5 INT(10),IN gravada_10 INT(10))
BEGIN
INSERT INTO comprobante_detalle_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,cod_producto,descripcion_prod,cantidad_prod,precio_unitario,descuento,importe,total_iva_5,total_iva_10,gravada_5,gravada_10) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,desc_articulo,cantidad,precio_unitario,descuento,importe,total_iva5,total_iva10,gravada_5,gravada_10);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_comprobante_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comprobante_cabecera`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante int(15),IN cod_sucursal VARCHAR(5),IN cod_depos VARCHAR(5),IN fecha_comprobante date,IN cod_cliente int(10),IN cod_cobrador varchar(10),IN cod_vendedor varchar(10),IN cod_condicion_venta INT(5),IN cod_moneda VARCHAR(5),IN total_comprobante int(15),IN total_gravada int(15),IN total_iva INT(15),IN estado varchar(1),IN cod_usuario varchar(10),IN comentario varchar(50),in monto_cuo int(10))
BEGIN
INSERT INTO comprobante_cabecera_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_deposito,fecha_comprobante,cod_cliente,cod_cobrador,cod_vendedor,cod_condicion_venta,cod_moneda,total_comprobante,total_gravada,total_iva,estado,cod_usuario,comentario,monto_cuota) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_depos,fecha_comprobante,cod_cliente,cod_cobrador,cod_vendedor,cod_condicion_venta,cod_moneda,total_comprobante,total_gravada,total_iva,estado,cod_usuario,comentario,monto_cuo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_comprobante_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comprobante_detalle`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante int(15),IN cod_articulo VARCHAR(50),IN cantidad INT(2),IN precio_unitario int(10),IN descuento INT(10),IN gravada_10 INT(10),IN gravada_5 INT(10),IN importe_total INT(10),IN total_iva10 int(10),IN total_iva5 int(10),IN porcentaje_iva INT(2),IN cod_iva int(2),IN porcentaje_descuento int(2),IN nro_cuota int(2),in descripcion varchar(80))
BEGIN

INSERT INTO comprobante_detalle_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cantidad,precio_unitario,descuento,gravada_10,gravada_5,importe_total,total_iva10,total_iva5,porcentaje_iva,cod_iva,porcentaje_descuento,nro_cuota,descripcion) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cantidad,precio_unitario,descuento,gravada_10,gravada_5,importe_total,total_iva10,total_iva5,porcentaje_iva,cod_iva,porcentaje_descuento,nro_cuota,descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_condicion_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_condicion_venta`(IN cod_condicion int(10),IN descripcion VARCHAR(80),IN numero_cuota int(5),IN dia_inicial INT(5),IN plazo int(10),IN estado VARCHAR(1))
BEGIN

INSERT INTO condicion_venta(cod_condicion,descripcion,numero_cuota,dia_inicial,plazo,estado) VALUES(cod_condicion,descripcion,numero_cuota,dia_inicial,plazo,estado);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_exist_articulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_exist_articulo`(IN cod_suc VARCHAR(5),IN cod_dep VARCHAR(5),IN cod_art VARCHAR(50),in tip_tra int(5),in sub_tip int(5),in cant_art int(5))
BEGIN
INSERT INTO existencia_articulo(cod_sucursal,cod_deposito,cod_articulo,tipo_transacc,sub_tipo_transacc,cantidad) VALUES(cod_suc,cod_dep,cod_art,tip_tra,sub_tip,cant_art);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_forma_cobro_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_forma_cobro_venta`(IN tipo_mov_cja VARCHAR(3),IN ser_mov_cja VARCHAR(3),IN nro_mov_cja INT(15),IN tipo_tran int(5),IN su_tip_tra int(5),IN cod_pers_juridic INT(10),IN nro_val VARCHAR(30),IN nro_cuen VARCHAR(30),IN mot INT(10))
BEGIN

INSERT INTO forma_cobro_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,tipo_transaccion,sub_tipo_transaccion,cod_persona_juridica,nro_valor,nro_cuenta,monto)VALUES(tipo_mov_cja,ser_mov_cja,nro_mov_cja,tipo_tran,su_tip_tra,cod_pers_juridic,nro_val,nro_cuen,mot);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_forma_pago` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_forma_pago`(IN tipo_mov_cja VARCHAR(3),IN ser_mov_cja VARCHAR(3),IN nro_mov_cja INT(15),IN tipo_tran INT(5),IN su_tip_tra INT(5),IN cod_pers_juridic INT(10),IN nro_val VARCHAR(30),IN nro_cuen VARCHAR(30),IN mot INT(10))
BEGIN
INSERT INTO forma_pago_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,tipo_transaccion,sub_tipo_transaccion,cod_persona_juridica,nro_valor,nro_cuenta,monto)VALUES(tipo_mov_cja,ser_mov_cja,nro_mov_cja,tipo_tran,su_tip_tra,cod_pers_juridic,nro_val,nro_cuen,mot);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_movimiento_caja_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_caja_compra`(IN tipo_mov VARCHAR(3),IN ser_mov VARCHAR(3),IN nro_mov INT(10),IN fecha_mov DATE,IN cod_suc VARCHAR(5),IN cod_prov INT(10),IN cod_usu VARCHAR(10),IN total_mov INT(15))
BEGIN
INSERT INTO movimiento_caja_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,fecha_mov_caja_com,cod_sucursal,cod_proveedor,cod_usuario,total_mov_caja_com)VALUES(tipo_mov,ser_mov,nro_mov,fecha_mov,cod_suc,cod_prov,cod_usu,total_mov);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_movimiento_caja_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_caja_venta`(IN tipo_mov_caja VARCHAR(3),IN ser_mov_caja VARCHAR(3),in nro_mov_caja INT(10),IN fecha_mov_caja_venta DATE,IN cod_sucursal VARCHAR(5),IN cod_cliente INT(10),IN cod_usuario VARCHAR(10),IN cod_caja VARCHAR(10),IN numero_hab INT(10),IN total_mov_caja INT(15))
BEGIN

INSERT INTO movimiento_caja_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,fecha_mov_caja_venta,cod_sucursal,cod_cliente,cod_usuario,cod_caja,numero_hab,total_mov_caja)VALUES(tipo_mov_caja,ser_mov_caja,nro_mov_caja,fecha_mov_caja_venta,cod_sucursal,cod_cliente,cod_usuario,cod_caja,numero_hab,total_mov_caja);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_movimiento_comprobante_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_comprobante_compra`(IN tipo_mov VARCHAR(3),IN ser_mov VARCHAR(3),IN nro_mov INT(15),IN cod_suc VARCHAR(5),in tipo_trans int(5),in sub_tipo_trans int(5),IN tipo_comprob VARCHAR(3),IN ser_comprob VARCHAR(15),IN nro_comprob INT(10),IN total_comprob INT(10))
BEGIN
INSERT INTO movimiento_comprobante_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,cod_sucursal,tipo_transacc,sub_tipo_transacc,tipo_comprobante_com,ser_comprobante_com,nro_comprobante_com,total_comprobante_com)VALUES(tipo_mov,ser_mov,nro_mov,cod_suc,tipo_trans,sub_tipo_trans,tipo_comprob,ser_comprob,nro_comprob,total_comprob);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_movimiento_comprobante_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_comprobante_venta`(IN tipo_mov_caja VARCHAR(3),IN ser_mov_caja VARCHAR(3),IN nro_mov_caja INT(15),IN cod_sucursal VARCHAR(5),IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(3),IN nro_comprobante INT(10),IN total_comprobante INT(10))
BEGIN

INSERT INTO movimiento_comprobante_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,cod_sucursal,tipo_comprobante,ser_comprobante,nro_comprobante,total_comprobante)VALUES(tipo_mov_caja,ser_mov_caja,nro_mov_caja,cod_sucursal,tipo_comprobante,ser_comprobante,nro_comprobante,total_comprobante);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_persona`(IN nombre varchar(80),in cod_tipo_doc varchar(10),in ruc_ci VARCHAR(15),in cod_ciudad int(10),in direccion VARCHAR(100),in direccion_trabajo VARCHAR(100),in telefono_domicilio VARCHAR(20),in telefono_trabajo VARCHAR(20),in celular VARCHAR(15),in fecha_nacimiento date,in cod_estado_civil varchar (5),in cod_pais int(15),in es_ban varchar(1))
BEGIN

INSERT INTO persona(nombre,cod_tipo_doc,ruc_ci,cod_ciudad,direccion,direccion_trabajo,telefono_domicilio,telefono_trabajo,celular,fecha_nacimiento,cod_estado_civil,cod_pais,es_banco) VALUES(nombre,cod_tipo_doc,ruc_ci,cod_ciudad,direccion,direccion_trabajo,telefono_domicilio,telefono_trabajo,celular,fecha_nacimiento,cod_estado_civil,cod_pais,es_ban);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_proveedor`(IN cod_persona INT(15),in cod_tipo_prov varchar(5),in estado varchar(1))
BEGIN
INSERT INTO proveedor(cod_persona,cod_tipo_prov,estado) VALUES(cod_persona,cod_tipo_prov,estado);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_recibo_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_compra_cabecera`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(7),IN nro_recibo INT(15),IN cod_sucursal VARCHAR(5),IN fecha_recibo DATE,IN cod_prov INT(10),IN cod_moneda VARCHAR(5),IN cod_usuario VARCHAR(10),IN estado VARCHAR(1),IN total_recibo INT(15),IN comentario VARCHAR(50))
BEGIN
INSERT INTO recibo_compra_cabecera(tipo_rec_comp,ser_rec_comp,nro_rec_comp,cod_sucursal,fecha_rec_comp,cod_proveedor,cod_moneda,cod_usuario,estado,total_rec_comp,comentario) VALUES(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_prov,cod_moneda,cod_usuario,estado,total_recibo,comentario);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_recibo_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_compra_detalle`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(7),IN nro_recibo INT(15),IN tipo_transaccion INT(5),IN sub_tipo_transac INT(5),IN tipo_comprobante_ref VARCHAR(3),IN ser_comprobante_ref VARCHAR(7),IN nro_comprobante_ref INT(15),IN nro_cuota INT(5),IN fecha_vencimiento DATE,IN monto_cuota INT(15),IN importe_total INT(15))
BEGIN
INSERT INTO recibo_detalle_compra(`tipo_rec_comp`,`ser_rec_comp`,`nro_rec_comp`,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total) VALUES(tipo_recibo,ser_recibo,nro_recibo,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_recibo_venta_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_venta_cabecera`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(2),IN nro_recibo INT(15),IN cod_sucursal VARCHAR(5),IN fecha_recibo DATE,IN cod_cliente INT(10),IN cod_cobrador VARCHAR(10),IN cod_moneda VARCHAR(5),IN cod_usuario VARCHAR(10),IN estado VARCHAR(1),IN total_recibo INT(15),IN comentario VARCHAR(50))
BEGIN

INSERT INTO recibo_venta_cabecera(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_cliente,cod_cobrador,cod_moneda,cod_usuario,estado,total_recibo,comentario) VALUES(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_cliente,cod_cobrador,cod_moneda,cod_usuario,estado,total_recibo,comentario);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_recibo_venta_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_venta_detalle`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(2),IN nro_recibo INT(15),IN tipo_transaccion INT(5),IN sub_tipo_transac INT(5),IN tipo_comprobante_ref VARCHAR(3),IN ser_comprobante_ref VARCHAR(2),IN nro_comprobante_ref INT(15),IN nro_cuota INT(5),IN fecha_vencimiento date,IN monto_cuota INT(15),IN importe_total INT(15))
BEGIN

INSERT INTO recibo_detalle_venta(tipo_recibo,ser_recibo,nro_recibo,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total) VALUES(tipo_recibo,ser_recibo,nro_recibo,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_usuario`(IN cod_usuario VARCHAR(10),IN clave_usuario VARCHAR(20),IN cod_persona INT(15),IN cod_grupo VARCHAR(15),IN cod_sucursal VARCHAR(5),IN estado VARCHAR(1))
BEGIN

INSERT INTO usuario(cod_usuario,clave_usuario,cod_persona,cod_grupo,cod_sucursal,estado) VALUES(cod_usuario,clave_usuario,cod_persona,cod_grupo,cod_sucursal,estado);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `view_articulo`
--

/*!50001 DROP VIEW IF EXISTS `view_articulo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_articulo` AS (select `a`.`cod_articulo` AS `cod_articulo`,`a`.`cod_sucursal` AS `cod_sucursal`,`s`.`desc_sucursal` AS `desc_sucursal`,`a`.`cod_deposito` AS `cod_deposito`,`d`.`desc_deposito` AS `desc_deposito`,`a`.`desc_articulo` AS `desc_articulo`,`a`.`cod_proveedor` AS `cod_proveedor`,`ps`.`nombre` AS `nombre_prov`,`p`.`razon_social` AS `razon_social`,`a`.`cod_marca` AS `cod_marca`,`m`.`desc_marca` AS `desc_marca`,`a`.`cod_categoria` AS `cod_categoria`,`c`.`desc_categoria` AS `desc_categoria`,`a`.`precio_compra` AS `precio_compra`,`a`.`precio_venta` AS `precio_venta`,`a`.`cantidad` AS `cantidad`,`a`.`cod_iva` AS `cod_iva`,`i`.`desc_iva` AS `desc_iva`,(case when (`a`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `estado`,(case when (`a`.`maneja_stock` = 'S') then 'SI' else 'NO' end) AS `man_stock` from (((((((`articulo` `a` left join `sucursal` `s` on((`a`.`cod_sucursal` = `s`.`cod_sucursal`))) left join `proveedor` `p` on((`a`.`cod_proveedor` = `p`.`cod_proveedor`))) left join `persona` `ps` on((`p`.`cod_persona` = `ps`.`cod_persona`))) left join `marca` `m` on((`a`.`cod_marca` = `m`.`cod_marca`))) left join `categoria` `c` on((`a`.`cod_categoria` = `c`.`cod_categoria`))) left join `iva` `i` on((`a`.`cod_iva` = `i`.`cod_iva`))) left join `deposito_articulo` `d` on((`a`.`cod_deposito` = `d`.`cod_deposito`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_cliente`
--

/*!50001 DROP VIEW IF EXISTS `view_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_cliente` AS (select `c`.`cod_cliente` AS `cod_cliente`,`c`.`cod_persona` AS `cod_persona`,`p`.`nombre` AS `nombre`,`c`.`cod_moneda` AS `cod_moneda`,`m`.`desc_moneda` AS `desc_moneda`,`c`.`cod_cobrador` AS `cod_cobrador`,`pc`.`nombre` AS `cobrador`,`c`.`cod_vendedor` AS `cod_vendedor`,`pv`.`nombre` AS `vendedor`,ifnull(`c`.`limite_credito`,'') AS `limite_credito`,ifnull(`c`.`cod_condicion_venta`,'') AS `cod_condicion_venta`,`cv`.`descripcion` AS `condicion`,`c`.`tipo_cliente` AS `cod_tipo_clien`,`tc`.`descripcion` AS `tipo_cliente`,(case when (`c`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `estado`,`c`.`comentario` AS `comentario`,`p`.`ruc_ci` AS `ruc_ci` from ((((((((`cliente` `c` left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) left join `moneda` `m` on((`c`.`cod_moneda` = `m`.`cod_moneda`))) left join `cobrador` `cb` on((`c`.`cod_cobrador` = `cb`.`cod_cobrador`))) left join `persona` `pc` on((`cb`.`cod_persona` = `pc`.`cod_persona`))) left join `vendedor` `v` on((`c`.`cod_vendedor` = `v`.`cod_vendedor`))) left join `persona` `pv` on((`v`.`cod_persona` = `pv`.`cod_persona`))) left join `condicion_venta` `cv` on((`c`.`cod_condicion_venta` = `cv`.`cod_condicion`))) left join `tipo_cliente` `tc` on((`c`.`tipo_cliente` = `tc`.`cod_tipo_cliente`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_comprob_compra_cab_det`
--

/*!50001 DROP VIEW IF EXISTS `view_comprob_compra_cab_det`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_comprob_compra_cab_det` AS (select `c`.`cod_tipo_comp` AS `tipo_comp`,(case when (`c`.`cod_tipo_comp` = 'FCO') then 'FACTURA CONTADO' else 'FACTURA CREDITO' end) AS `tipo_comprobante`,`c`.`ser_timb_comp` AS `serie_comp`,`c`.`nro_comprob_comp` AS `nro_comp`,`c`.`nro_timbrado` AS `nro_timbrado_comp`,date_format(`c`.`fecha_comprob_comp`,'%d/%m/%Y') AS `fecha_comprob`,`c`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`c`.`cod_sucursal` AS `cod_sucursal`,`s`.`desc_sucursal` AS `desc_sucursal`,`c`.`cod_deposito` AS `cod_deposito`,`da`.`desc_deposito` AS `desc_deposito`,`c`.`cod_proveedor` AS `cod_proveedor`,`pp`.`nombre` AS `nomb_proveedor`,`c`.`cod_cond_comp` AS `cond_comp`,`cv`.`descripcion` AS `descripcion`,`c`.`cant_cuota` AS `cant_cuota`,date_format(`c`.`fecha_inic_comp`,'%d/%m/%Y') AS `fecha_inic_comp`,`c`.`monto_cuota` AS `monto_cuota`,`c`.`total_comprob_comp` AS `total_comp`,`c`.`iva_comp` AS `total_iva_comp`,`c`.`gravada` AS `total_grav_comp`,`c`.`cod_moneda` AS `cod_moneda`,`mo`.`desc_moneda` AS `desc_moneda`,`c`.`tipo_cambio` AS `tipo_cambio`,`c`.`estado` AS `estado`,`d`.`cod_producto` AS `cod_articulo`,`d`.`descripcion_prod` AS `desc_articulo`,`d`.`cantidad_prod` AS `cant_articulo`,`d`.`precio_unitario` AS `precio_unitario`,`d`.`descuento` AS `descuento`,`d`.`importe` AS `importe`,`d`.`total_iva_5` AS `iva5`,`d`.`total_iva_10` AS `iva10`,`d`.`gravada_5` AS `gravada5`,`d`.`gravada_10` AS `gravada10` from (((((((((`comprobante_cabecera_compra` `c` left join `comprobante_detalle_compra` `d` on(((`c`.`cod_tipo_comp` = `d`.`cod_tipo_comp`) and (`c`.`ser_timb_comp` = `d`.`ser_timb_comp`) and (`c`.`nro_comprob_comp` = `d`.`nro_comprob_comp`)))) left join `usuario` `u` on((`c`.`cod_usuario` = `u`.`cod_usuario`))) left join `persona` `pu` on((`u`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `s` on((`c`.`cod_sucursal` = `s`.`cod_sucursal`))) left join `deposito_articulo` `da` on((`c`.`cod_deposito` = `da`.`cod_deposito`))) left join `proveedor` `pr` on((`c`.`cod_proveedor` = `pr`.`cod_proveedor`))) left join `persona` `pp` on((`pr`.`cod_persona` = `pp`.`cod_persona`))) left join `condicion_venta` `cv` on((`c`.`cod_cond_comp` = `cv`.`cod_condicion`))) left join `moneda` `mo` on((`c`.`cod_moneda` = `mo`.`cod_moneda`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_comprob_venta_cab_det`
--

/*!50001 DROP VIEW IF EXISTS `view_comprob_venta_cab_det`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_comprob_venta_cab_det` AS (select `com`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,(case when (`com`.`tipo_comprobante` = 'FCO') then 'FACTURA CONTADO' else 'FACTURA CREDITO' end) AS `tipo_comprobante`,`com`.`ser_comprobante` AS `ser_comprobante`,`com`.`nro_comprobante` AS `nro_comprobante`,date_format(`com`.`fecha_comprobante`,'%d/%m/%Y') AS `fecha_comprobante`,`com`.`cod_cliente` AS `cod_cliente`,`per`.`nombre` AS `nombre_cliente`,`com`.`cod_cobrador` AS `cod_cobrador`,`pco`.`nombre` AS `nombre_cobrador`,`com`.`cod_vendedor` AS `cod_vendedor`,`pve`.`nombre` AS `nombre_vendedor`,`com`.`cod_condicion_venta` AS `cod_condicion_venta`,`con`.`descripcion` AS `descripcion`,`com`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`dco`.`cod_articulo` AS `cod_articulo`,`dco`.`cantidad` AS `cantidad`,`art`.`desc_articulo` AS `desc_articulo`,`dco`.`precio_unitario` AS `precio_unitario`,`dco`.`importe_total` AS `importe_total`,`dco`.`total_iva5` AS `total_iva5`,`dco`.`total_iva10` AS `total_iva10`,`dco`.`gravada_5` AS `gravada_5`,`dco`.`gravada_10` AS `gravada_10`,`com`.`total_gravada` AS `total_gravada`,`com`.`total_iva` AS `total_iva`,`com`.`total_comprobante` AS `total_comprobante`,`com`.`cod_deposito` AS `cod_deposito`,`dep`.`desc_deposito` AS `desc_deposito` from ((((((((((((`comprobante_cabecera_venta` `com` left join `comprobante_detalle_venta` `dco` on(((`com`.`tipo_comprobante` = `dco`.`tipo_comprobante`) and (`com`.`ser_comprobante` = `dco`.`ser_comprobante`) and (`com`.`nro_comprobante` = `dco`.`nro_comprobante`)))) left join `articulo` `art` on((`dco`.`cod_articulo` = `art`.`cod_articulo`))) left join `cliente` `cli` on((`com`.`cod_cliente` = `cli`.`cod_cliente`))) left join `persona` `per` on((`cli`.`cod_persona` = `per`.`cod_persona`))) left join `sucursal` `suc` on((`com`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `deposito_articulo` `dep` on((`com`.`cod_deposito` = `dep`.`cod_deposito`))) left join `cobrador` `cob` on((`com`.`cod_cobrador` = `cob`.`cod_cobrador`))) left join `persona` `pco` on((`cob`.`cod_persona` = `pco`.`cod_persona`))) left join `vendedor` `ven` on((`com`.`cod_vendedor` = `ven`.`cod_vendedor`))) left join `persona` `pve` on((`ven`.`cod_persona` = `pve`.`cod_persona`))) left join `condicion_venta` `con` on((`com`.`cod_condicion_venta` = `con`.`cod_condicion`))) left join `moneda` `mon` on((`cli`.`cod_moneda` = `mon`.`cod_moneda`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_existencia_articulo`
--

/*!50001 DROP VIEW IF EXISTS `view_existencia_articulo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_existencia_articulo` AS (select `e`.`cod_sucursal` AS `cod_sucursal`,`e`.`desc_sucursal` AS `desc_sucursal`,`e`.`cod_deposito` AS `cod_deposito`,`e`.`desc_deposito` AS `desc_deposito`,`e`.`cod_articulo` AS `cod_articulo`,`e`.`desc_articulo` AS `desc_articulo`,(sum(`e`.`cant_compra`) - sum(`e`.`cant_venta`)) AS `existencia` from (select `exi`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`exi`.`cod_deposito` AS `cod_deposito`,`dar`.`desc_deposito` AS `desc_deposito`,`exi`.`cod_articulo` AS `cod_articulo`,`art`.`desc_articulo` AS `desc_articulo`,`exi`.`cantidad` AS `cant_compra`,0 AS `cant_venta` from (((`compra_venta`.`existencia_articulo` `exi` left join `compra_venta`.`articulo` `art` on(((`exi`.`cod_sucursal` = `art`.`cod_sucursal`) and (`exi`.`cod_deposito` = `art`.`cod_deposito`) and (`exi`.`cod_articulo` = `art`.`cod_articulo`)))) left join `compra_venta`.`sucursal` `suc` on((`exi`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `compra_venta`.`deposito_articulo` `dar` on((`exi`.`cod_deposito` = `dar`.`cod_deposito`))) where (`exi`.`tipo_transacc` = 3) union all select `exi`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`exi`.`cod_deposito` AS `cod_deposito`,`dar`.`desc_deposito` AS `desc_deposito`,`exi`.`cod_articulo` AS `cod_articulo`,`art`.`desc_articulo` AS `desc_articulo`,0 AS `cant_compra`,`exi`.`cantidad` AS `cant_venta` from (((`compra_venta`.`existencia_articulo` `exi` left join `compra_venta`.`articulo` `art` on(((`exi`.`cod_sucursal` = `art`.`cod_sucursal`) and (`exi`.`cod_deposito` = `art`.`cod_deposito`) and (`exi`.`cod_articulo` = `art`.`cod_articulo`)))) left join `compra_venta`.`sucursal` `suc` on((`exi`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `compra_venta`.`deposito_articulo` `dar` on((`exi`.`cod_deposito` = `dar`.`cod_deposito`))) where (`exi`.`tipo_transacc` = 4)) `e` group by `e`.`cod_sucursal`,`e`.`desc_sucursal`,`e`.`cod_deposito`,`e`.`desc_deposito`,`e`.`cod_articulo`,`e`.`desc_articulo` order by `e`.`cod_articulo`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_mov_caja_compra`
--

/*!50001 DROP VIEW IF EXISTS `view_mov_caja_compra`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_mov_caja_compra` AS (select `mcaj`.`tipo_mov_caja_com` AS `tipo_mov_comp`,`mcaj`.`ser_mov_caja_com` AS `ser_mov_comp`,`mcaj`.`nro_mov_caja_com` AS `nro_mov_comp`,date_format(`mcaj`.`fecha_mov_caja_com`,'%d/%m/%Y') AS `fecha_mov_comp`,`mcaj`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`mcaj`.`cod_proveedor` AS `cod_proveedor`,`p`.`nombre` AS `nomb_proveedor`,`mcaj`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`mcaj`.`total_mov_caja_com` AS `total_mov_comp` from (((((`movimiento_caja_compra` `mcaj` left join `proveedor` `c` on((`mcaj`.`cod_proveedor` = `c`.`cod_proveedor`))) left join `persona` `p` on((`p`.`cod_persona` = `c`.`cod_persona`))) left join `usuario` `us` on((`mcaj`.`cod_usuario` = `us`.`cod_usuario`))) left join `persona` `pu` on((`us`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `suc` on((`mcaj`.`cod_sucursal` = `suc`.`cod_sucursal`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_mov_caja_venta`
--

/*!50001 DROP VIEW IF EXISTS `view_mov_caja_venta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_mov_caja_venta` AS (select `mcaj`.`tipo_mov_caja` AS `tipo_mov_caja`,`mcaj`.`ser_mov_caja` AS `ser_mov_caja`,`mcaj`.`nro_mov_caja` AS `nro_mov_caja`,date_format(`mcaj`.`fecha_mov_caja_venta`,'%d/%m/%Y') AS `fecha_mov_caja_venta`,`mcaj`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`mcaj`.`cod_cliente` AS `cod_cliente`,`p`.`nombre` AS `nomb_cliente`,`mcaj`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`mcaj`.`cod_caja` AS `cod_caja`,`cj`.`desc_caja` AS `desc_caja`,`mcaj`.`numero_hab` AS `numero_hab`,`mcaj`.`total_mov_caja` AS `total_mov_caja` from ((((((`movimiento_caja_venta` `mcaj` left join `cliente` `c` on((`mcaj`.`cod_cliente` = `c`.`cod_cliente`))) left join `caja` `cj` on((`mcaj`.`cod_caja` = `cj`.`cod_caja`))) left join `persona` `p` on((`p`.`cod_persona` = `c`.`cod_persona`))) left join `usuario` `us` on((`mcaj`.`cod_usuario` = `us`.`cod_usuario`))) left join `persona` `pu` on((`us`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `suc` on((`mcaj`.`cod_sucursal` = `suc`.`cod_sucursal`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_persona`
--

/*!50001 DROP VIEW IF EXISTS `view_persona`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_persona` AS (select `per`.`cod_persona` AS `cod_persona`,`per`.`nombre` AS `nombre`,`per`.`cod_tipo_doc` AS `cod_tipo_doc`,`tdoc`.`Desc_tipo_doc` AS `Desc_tipo_doc`,`per`.`ruc_ci` AS `ruc_ci`,ifnull(`per`.`cod_ciudad`,'') AS `cod_ciudad`,`ciu`.`desc_ciudad` AS `desc_ciudad`,`per`.`direccion` AS `direccion`,`per`.`direccion_trabajo` AS `direccion_trabajo`,`per`.`telefono_domicilio` AS `telefono_domicilio`,`per`.`telefono_trabajo` AS `telefono_trabajo`,`per`.`celular` AS `celular`,date_format(`per`.`fecha_nacimiento`,'%d/%m/%Y') AS `fecha_nacimiento`,`per`.`cod_estado_civil` AS `cod_estado_civil`,`ecv`.`desc_estado_civil` AS `desc_estado_civil`,ifnull(`per`.`cod_pais`,'') AS `cod_pais`,`p`.`desc_pais` AS `desc_pais`,ifnull(`per`.`es_banco`,'N') AS `es_banco` from ((((`persona` `per` left join `tipo_documento` `tdoc` on((`per`.`cod_tipo_doc` = `tdoc`.`cod_tipo_doc`))) left join `ciudad` `ciu` on((`per`.`cod_ciudad` = `ciu`.`cod_ciudad`))) left join `estado_civil` `ecv` on((`per`.`cod_estado_civil` = `ecv`.`cod_estado_civil`))) left join `pais` `p` on((`per`.`cod_pais` = `p`.`cod_pais`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_recibo_compra`
--

/*!50001 DROP VIEW IF EXISTS `view_recibo_compra`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_recibo_compra` AS (select `rec`.`cod_usuario` AS `cod_usuario`,`pus`.`nombre` AS `nomb_usuario`,`rec`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`rec`.`tipo_rec_comp` AS `tipo_recibo`,`rec`.`ser_rec_comp` AS `ser_recibo`,`rec`.`nro_rec_comp` AS `nro_recibo`,date_format(`rec`.`fecha_rec_comp`,'%d/%m/%Y') AS `fecha_recibo`,`rec`.`cod_proveedor` AS `cod_proveedor`,`pcl`.`nombre` AS `nomb_cliente`,`rec`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`rec`.`total_rec_comp` AS `total_recibo`,`rec`.`comentario` AS `comentario`,`dre`.`tipo_transaccion` AS `tipo_transaccion`,`dre`.`sub_tipo_transac` AS `sub_tipo_transac`,`dre`.`tipo_comprobante_ref` AS `tipo_comprobante_ref`,`dre`.`ser_comprobante_ref` AS `ser_comprobante_ref`,`dre`.`nro_comprobante_ref` AS `nro_comprobante_ref`,`dre`.`nro_cuota` AS `nro_cuota`,`dre`.`fecha_vencimiento` AS `fecha_vencimiento`,`dre`.`monto_cuota` AS `monto_cuota`,`dre`.`importe_total` AS `importe_total` from (((((((`recibo_compra_cabecera` `rec` left join `recibo_detalle_compra` `dre` on(((`rec`.`tipo_rec_comp` = `dre`.`tipo_rec_comp`) and (`rec`.`ser_rec_comp` = `dre`.`ser_rec_comp`) and (`rec`.`nro_rec_comp` = `dre`.`nro_rec_comp`)))) left join `proveedor` `pro` on((`rec`.`cod_proveedor` = `pro`.`cod_proveedor`))) left join `moneda` `mon` on((`rec`.`cod_moneda` = `mon`.`cod_moneda`))) left join `sucursal` `suc` on((`rec`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `usuario` `usu` on((`rec`.`cod_usuario` = `usu`.`cod_usuario`))) left join `persona` `pcl` on((`pro`.`cod_persona` = `pcl`.`cod_persona`))) left join `persona` `pus` on((`usu`.`cod_persona` = `pus`.`cod_persona`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_recibo_venta`
--

/*!50001 DROP VIEW IF EXISTS `view_recibo_venta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_recibo_venta` AS (select `rec`.`cod_usuario` AS `cod_usuario`,`pus`.`nombre` AS `nomb_usuario`,`rec`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`rec`.`tipo_recibo` AS `tipo_recibo`,`rec`.`ser_recibo` AS `ser_recibo`,`rec`.`nro_recibo` AS `nro_recibo`,date_format(`rec`.`fecha_recibo`,'%d/%m/%Y') AS `fecha_recibo`,`rec`.`cod_cliente` AS `cod_cliente`,`pcl`.`nombre` AS `nomb_cliente`,`rec`.`cod_cobrador` AS `cod_cobrador`,`pco`.`nombre` AS `nomb_cobrador`,`rec`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`rec`.`total_recibo` AS `total_recibo`,`rec`.`comentario` AS `comentario`,`dre`.`tipo_transaccion` AS `tipo_transaccion`,`dre`.`sub_tipo_transac` AS `sub_tipo_transac`,`dre`.`tipo_comprobante_ref` AS `tipo_comprobante_ref`,`dre`.`ser_comprobante_ref` AS `ser_comprobante_ref`,`dre`.`nro_comprobante_ref` AS `nro_comprobante_ref`,`dre`.`nro_cuota` AS `nro_cuota`,`dre`.`fecha_vencimiento` AS `fecha_vencimiento`,`dre`.`monto_cuota` AS `monto_cuota`,`dre`.`importe_total` AS `importe_total` from (((((((((`recibo_venta_cabecera` `rec` left join `recibo_detalle_venta` `dre` on(((`rec`.`tipo_recibo` = `dre`.`tipo_recibo`) and (`rec`.`ser_recibo` = `dre`.`ser_recibo`) and (`rec`.`nro_recibo` = `dre`.`nro_recibo`)))) left join `cliente` `cli` on((`rec`.`cod_cliente` = `cli`.`cod_cliente`))) left join `cobrador` `cob` on((`rec`.`cod_cobrador` = `cob`.`cod_cobrador`))) left join `moneda` `mon` on((`rec`.`cod_moneda` = `mon`.`cod_moneda`))) left join `sucursal` `suc` on((`rec`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `usuario` `usu` on((`rec`.`cod_usuario` = `usu`.`cod_usuario`))) left join `persona` `pcl` on((`cli`.`cod_persona` = `pcl`.`cod_persona`))) left join `persona` `pco` on((`cob`.`cod_persona` = `pco`.`cod_persona`))) left join `persona` `pus` on((`usu`.`cod_persona` = `pus`.`cod_persona`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_saldo_cliente`
--

/*!50001 DROP VIEW IF EXISTS `view_saldo_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_saldo_cliente` AS (select `s`.`tipo_comprobante` AS `tipo_comprobante`,`s`.`ser_comprobante` AS `ser_comprobante`,`s`.`nro_comprobante` AS `nro_comprobante`,`s`.`cod_cliente` AS `cod_cliente`,`p`.`nombre` AS `nombre`,`s`.`nro_cuota` AS `nro_cuota`,`s`.`fecha_vencimiento` AS `fec_venc`,date_format(`s`.`fecha_vencimiento`,'%d/%m/%Y') AS `fecha_vencimiento`,`s`.`saldo_cuota` AS `saldo_cuota` from ((`saldo_cliente` `s` left join `cliente` `c` on((`s`.`cod_cliente` = `c`.`cod_cliente`))) left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) order by `s`.`ser_comprobante`,`s`.`nro_comprobante`,`s`.`nro_cuota`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_saldo_proveedor`
--

/*!50001 DROP VIEW IF EXISTS `view_saldo_proveedor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_saldo_proveedor` AS (select `s`.`tipo_comprobante` AS `tipo_comprobante`,`s`.`ser_comprobante` AS `ser_comprobante`,`s`.`nro_comprobante` AS `nro_comprobante`,`s`.`cod_proveedor` AS `cod_proveedor`,`p`.`nombre` AS `nombre`,`s`.`nro_cuota` AS `nro_cuota`,`s`.`fecha_vencimiento` AS `fec_venc`,date_format(`s`.`fecha_vencimiento`,'%d/%m/%Y') AS `fecha_vencimiento`,`s`.`saldo_cuota` AS `saldo_cuota`,`s`.`monto_cuota` AS `monto_cuota` from ((`saldo_proveedor` `s` left join `proveedor` `c` on((`s`.`cod_proveedor` = `c`.`cod_proveedor`))) left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) order by `s`.`ser_comprobante`,`s`.`nro_comprobante`,`s`.`nro_cuota`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-19 13:22:03
