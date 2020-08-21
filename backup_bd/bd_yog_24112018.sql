/*
SQLyog Community v12.2.6 (32 bit)
MySQL - 5.7.14-log : Database - compra_venta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`compra_venta` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `compra_venta`;

/*Table structure for table `acceso_grupo` */

DROP TABLE IF EXISTS `acceso_grupo`;

CREATE TABLE `acceso_grupo` (
  `cod_grupo` varchar(15) NOT NULL,
  `cod_modulo` varchar(5) NOT NULL,
  `desc_formulario` varchar(10) NOT NULL,
  `puede_insert` varchar(1) DEFAULT NULL,
  `puede_modif` varchar(1) DEFAULT NULL,
  `puede_borrar` varchar(1) DEFAULT NULL,
  `puede_consul` varchar(1) DEFAULT NULL,
  `mostrar_en_menu` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_grupo`,`cod_modulo`,`desc_formulario`),
  KEY `INDEX_COD_GRUPO` (`cod_grupo`),
  KEY `INDEX_COD_MODULO` (`cod_modulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `acceso_grupo` */

insert  into `acceso_grupo`(`cod_grupo`,`cod_modulo`,`desc_formulario`,`puede_insert`,`puede_modif`,`puede_borrar`,`puede_consul`,`mostrar_en_menu`) values 
('ADMIN','AJ','FORMACCGRU','S','S','S','S','S'),
('ADMIN','AJ','FORMDESCON','S','S','S','S','S'),
('ADMIN','AJ','FORMMENUPR','S','S','S','S','S'),
('ADMIN','AJ','FORMSALIR','S','S','S','S','S'),
('ADMIN','AJ','FORMSERCOM','S','S','S','S','S'),
('ADMIN','AJ','FORMTALONA','S','S','S','S','S'),
('ADMIN','AJ','FORMTALUSU','S','S','S','S','S'),
('ADMIN','AJ','FORMUSUARI','S','S','S','S','S'),
('ADMIN','AY','FORMCAMPAS','S','S','S','S','S'),
('ADMIN','CC','FORMCIECAJ','S','S','S','S','S'),
('ADMIN','CC','FORMCLIENT','S','S','S','S','S'),
('ADMIN','CC','FORMCOSACL','S','S','S','S','S'),
('ADMIN','CC','FORMFORMCO','S','S','S','S','S'),
('ADMIN','CC','FORMHBCJCO','S','S','S','S','S'),
('ADMIN','CC','FORMPERSON','S','N','N','S','S'),
('ADMIN','CC','FORMRECIBO','S','S','S','S','S'),
('ADMIN','CC','REPEXTCLI1','S','S','S','S','S'),
('ADMIN','CC','REP_COB','S','S','S','S','S'),
('ADMIN','CM','FORMFACCOM','S','S','S','S','S'),
('ADMIN','CP','FORMCOSAPR','S','S','S','S','S'),
('ADMIN','CP','FORMFORMPA','S','S','S','S','S'),
('ADMIN','CP','FORMPROVEE','S','S','S','S','S'),
('ADMIN','ST','FORMARTICU','S','S','S','S','S'),
('ADMIN','ST','FORMCATART','S','S','S','S','S'),
('ADMIN','ST','FORMCOEXAR','S','S','S','S','S'),
('ADMIN','ST','FORMMARART','S','S','S','S','S'),
('ADMIN','ST','FORMUNMEAR','S','S','S','S','S'),
('ADMIN','ST','REPEXISART','S','S','S','S','S'),
('ADMIN','ST','REP_STK','S','S','S','S','S'),
('ADMIN','VT','FORMANCOVE','S','S','S','S','S'),
('ADMIN','VT','FORMCNCMVE','S','S','S','S','S'),
('ADMIN','VT','FORMCONDVE','S','S','S','S','S'),
('ADMIN','VT','FORMFACTUR','S','S','S','S','S'),
('VENTAS','ST','FORMARTICU','S','S','S','S','S');

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `cod_articulo` varchar(100) NOT NULL,
  `cod_un_med` varchar(5) NOT NULL,
  `nro_lote` varchar(100) NOT NULL,
  `desc_articulo` varchar(100) NOT NULL,
  `cod_proveedor` int(10) DEFAULT NULL,
  `cod_marca` varchar(10) DEFAULT NULL,
  `cod_categoria` varchar(10) DEFAULT NULL,
  `precio_compra` int(10) DEFAULT NULL,
  `precio_venta` int(10) DEFAULT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `cod_iva` varchar(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `maneja_stock` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_articulo`,`cod_un_med`,`nro_lote`),
  KEY `INDEX_COD_PROVEEDOR` (`cod_proveedor`),
  KEY `INDEX_COD_MARCA` (`cod_marca`),
  KEY `INDEX_COD_CATEGORIA` (`cod_categoria`),
  KEY `INDEX_COD_IVA` (`cod_iva`),
  KEY `INDEX_COD_UN_MED` (`cod_un_med`),
  CONSTRAINT `FK_ARTICULO_COD_CATEGORIA` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`cod_categoria`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_ARTICULO_COD_IVA` FOREIGN KEY (`cod_iva`) REFERENCES `iva` (`cod_iva`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_ARTICULO_COD_MARCA` FOREIGN KEY (`cod_marca`) REFERENCES `marca` (`cod_marca`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_ARTICULO_COD_PROVEEDOR` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedor` (`cod_proveedor`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_ARTICULO_COD_UN_MED` FOREIGN KEY (`cod_un_med`) REFERENCES `unidad_med_articulo` (`cod_un_med`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articulo` */

insert  into `articulo`(`cod_articulo`,`cod_un_med`,`nro_lote`,`desc_articulo`,`cod_proveedor`,`cod_marca`,`cod_categoria`,`precio_compra`,`precio_venta`,`cantidad`,`cod_iva`,`estado`,`maneja_stock`) values 
('AAA001','UN','0','LCD TOKYO',5,'GRAL','GRAL',NULL,NULL,NULL,'10','A','S'),
('AAA001','UN','0101','LCD SAMSUNG',5,'GRAL','GRAL',NULL,NULL,NULL,'10','A','S'),
('AAA002','UN','0','SOPORTE P/AIRE',5,'GRAL','GRAL',NULL,NULL,NULL,'10','A','S'),
('AAA003','UN','0','COCINA ELECTRICA',5,'GRAL','GRAL',NULL,NULL,NULL,'10','A','S'),
('AAA004','UN','0','EQUIPO DE SONIDO PHILIPS',6,'GRAL','GRAL',NULL,NULL,NULL,'10','A','S'),
('AAA005','UN','0','AURICULAR INALAMBRICO',5,NULL,NULL,NULL,NULL,NULL,'10','A','S'),
('AAA006','UN','0','ARTICULO DE PRUEBA',6,'TOY','ELEC',NULL,NULL,NULL,'10','A','S');

/*Table structure for table `caja` */

DROP TABLE IF EXISTS `caja`;

CREATE TABLE `caja` (
  `cod_sucursal` varchar(5) NOT NULL,
  `cod_caja` varchar(15) NOT NULL,
  `desc_caja` varchar(50) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`,`cod_caja`),
  CONSTRAINT `FK_CAJA_COD_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `caja` */

insert  into `caja`(`cod_sucursal`,`cod_caja`,`desc_caja`,`fecha_alta`,`estado`) values 
('01','CAJ1','CAJA UNO SUC1','2018-05-02','A'),
('02','CAJ1','CAJA UNO SUC2','2018-05-02','A');

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `cod_categoria` varchar(10) NOT NULL,
  `desc_categoria` varchar(80) NOT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `categoria` */

insert  into `categoria`(`cod_categoria`,`desc_categoria`) values 
('CEL','CELULARES'),
('ELEC','ELECTRONICA'),
('GRAL','GENERAL'),
('INSU','INSUMOS'),
('MUEB','MUEBLES');

/*Table structure for table `ciudad` */

DROP TABLE IF EXISTS `ciudad`;

CREATE TABLE `ciudad` (
  `cod_ciudad` int(10) NOT NULL AUTO_INCREMENT,
  `desc_ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ciudad` */

insert  into `ciudad`(`cod_ciudad`,`desc_ciudad`) values 
(1,'ASUNCION'),
(2,'AREGUA');

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

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
  KEY `INDEX_COD_PERSONA` (`cod_persona`),
  KEY `INDEX_COD_MON` (`cod_moneda`),
  KEY `INDEX_COD_COB` (`cod_cobrador`),
  KEY `INDEX_COD_VEN` (`cod_vendedor`),
  KEY `INDEX_COD_CON` (`cod_condicion_venta`),
  KEY `INDEX_COD_TIP_CLI` (`tipo_cliente`),
  CONSTRAINT `FK_CLIENTE_COD_COBRADOR` FOREIGN KEY (`cod_cobrador`) REFERENCES `cobrador` (`cod_cobrador`),
  CONSTRAINT `FK_CLIENTE_COD_CONDICION` FOREIGN KEY (`cod_condicion_venta`) REFERENCES `condicion_venta` (`cod_condicion`),
  CONSTRAINT `FK_CLIENTE_COD_MONEDA` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`),
  CONSTRAINT `FK_CLIENTE_COD_PERSONA` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`),
  CONSTRAINT `FK_CLIENTE_COD_TIP_CLIENTE` FOREIGN KEY (`tipo_cliente`) REFERENCES `tipo_cliente` (`cod_tipo_cliente`),
  CONSTRAINT `FK_CLIENTE_COD_VENDEDOR` FOREIGN KEY (`cod_vendedor`) REFERENCES `vendedor` (`cod_vendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cliente` */

insert  into `cliente`(`cod_cliente`,`cod_persona`,`cod_moneda`,`cod_cobrador`,`cod_vendedor`,`limite_credito`,`cod_condicion_venta`,`tipo_cliente`,`estado`,`comentario`) values 
(1,1,'01','01','01',NULL,1,'00','A',NULL),
(4,2,'01','01','01',NULL,3,'00','A',NULL),
(5,4,'01','01','01',NULL,0,'00','A',NULL),
(6,17,'01','01','01',NULL,0,'00','A','CLIENTE DE PRUEBA');

/*Table structure for table `cobrador` */

DROP TABLE IF EXISTS `cobrador`;

CREATE TABLE `cobrador` (
  `cod_cobrador` varchar(20) NOT NULL,
  `cod_persona` int(10) DEFAULT NULL,
  `cod_zona` varchar(15) DEFAULT NULL,
  `porcentaje_comision` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_cobrador`),
  KEY `INDEX_COD_PERS` (`cod_persona`),
  CONSTRAINT `FK_COBRADOR_COD_PERSONA` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cobrador` */

insert  into `cobrador`(`cod_cobrador`,`cod_persona`,`cod_zona`,`porcentaje_comision`,`estado`) values 
('01',6,NULL,10,'A');

/*Table structure for table `comprobante_cabecera_compra` */

DROP TABLE IF EXISTS `comprobante_cabecera_compra`;

CREATE TABLE `comprobante_cabecera_compra` (
  `cod_tipo_comp` varchar(10) NOT NULL,
  `ser_timb_comp` varchar(30) NOT NULL,
  `nro_comprob_comp` int(10) NOT NULL,
  `nro_timbrado` varchar(30) DEFAULT NULL,
  `fecha_comprob_comp` date NOT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `cod_deposito` varchar(5) DEFAULT NULL,
  `cod_proveedor` int(10) DEFAULT NULL,
  `cod_cond_comp` int(5) DEFAULT NULL,
  `cant_cuota` int(10) DEFAULT NULL,
  `fecha_inic_comp` date DEFAULT NULL,
  `monto_cuota` int(11) DEFAULT NULL,
  `total_comprob_comp` int(11) DEFAULT NULL,
  `iva_comp` int(11) DEFAULT NULL,
  `gravada` int(11) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `tipo_cambio` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `pagado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`),
  KEY `FK_COMP_CM_CAB_COD_DEP_SUC` (`cod_sucursal`,`cod_deposito`),
  KEY `FK_COMP_CM_CAB_COD_PROV` (`cod_proveedor`),
  KEY `FK_COMP_CM_CAB_COD_USUARIO` (`cod_usuario`),
  KEY `FK_COMP_CM_CAB_COD_COND` (`cod_cond_comp`),
  KEY `FK_COMP_CM_CAB_COD_MONEDA` (`cod_moneda`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_COND` FOREIGN KEY (`cod_cond_comp`) REFERENCES `condicion_venta` (`cod_condicion`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_DEP_SUC` FOREIGN KEY (`cod_sucursal`, `cod_deposito`) REFERENCES `deposito_articulo` (`cod_sucursal`, `cod_deposito`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_MONEDA` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_PROV` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedor` (`cod_proveedor`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_SUCURSAL` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_USUARIO` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_cabecera_compra` */

insert  into `comprobante_cabecera_compra`(`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`,`nro_timbrado`,`fecha_comprob_comp`,`cod_usuario`,`cod_sucursal`,`cod_deposito`,`cod_proveedor`,`cod_cond_comp`,`cant_cuota`,`fecha_inic_comp`,`monto_cuota`,`total_comprob_comp`,`iva_comp`,`gravada`,`cod_moneda`,`tipo_cambio`,`estado`,`pagado`) values 
('FCR','001-001',1,'1234','2018-05-24','root','01','01',5,4,4,'2018-05-24',0,17500000,1590909,15909091,'01',0,'P',NULL),
('FCR','001-001',2,'12345','2018-05-24','root','01','01',6,3,3,'2018-05-24',0,7000000,636364,6363636,'01',0,'P',NULL);

/*Table structure for table `comprobante_cabecera_venta` */

DROP TABLE IF EXISTS `comprobante_cabecera_venta`;

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
  `cod_motivo_anul` int(5) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`),
  KEY `FK_COMP_VENTA_CAB_TAL` (`tipo_comprobante`,`ser_comprobante`,`cod_sucursal`),
  KEY `FK_COMP_VENTA_CAB_DEP` (`cod_deposito`,`cod_sucursal`),
  KEY `FK_COMP_VENTA_CAB_CLIE` (`cod_cliente`),
  KEY `FK_COMP_VENTA_CAB_COBR` (`cod_cobrador`),
  KEY `FK_COMP_VENTA_CAB_VEND` (`cod_vendedor`),
  KEY `FK_COMP_VENTA_CAB_COND` (`cod_condicion_venta`),
  KEY `FK_COMP_VENTA_CAB_MONE` (`cod_moneda`),
  KEY `FK_COMP_VENTA_CAB_USU` (`cod_usuario`),
  KEY `FK_COMP_VENTA_CAB_MANU` (`cod_motivo_anul`),
  CONSTRAINT `FK_COMP_VENTA_CAB_CLIE` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `FK_COMP_VENTA_CAB_COBR` FOREIGN KEY (`cod_cobrador`) REFERENCES `cobrador` (`cod_cobrador`),
  CONSTRAINT `FK_COMP_VENTA_CAB_COND` FOREIGN KEY (`cod_condicion_venta`) REFERENCES `condicion_venta` (`cod_condicion`),
  CONSTRAINT `FK_COMP_VENTA_CAB_DEP` FOREIGN KEY (`cod_deposito`, `cod_sucursal`) REFERENCES `deposito_articulo` (`cod_sucursal`, `cod_deposito`),
  CONSTRAINT `FK_COMP_VENTA_CAB_MANU` FOREIGN KEY (`cod_motivo_anul`) REFERENCES `motivo_anulac_comp` (`cod_motivo`),
  CONSTRAINT `FK_COMP_VENTA_CAB_MONE` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`),
  CONSTRAINT `FK_COMP_VENTA_CAB_TAL` FOREIGN KEY (`tipo_comprobante`, `ser_comprobante`, `cod_sucursal`) REFERENCES `talonario` (`tipo_talonario`, `serie`, `cod_sucursal`),
  CONSTRAINT `FK_COMP_VENTA_CAB_USU` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`),
  CONSTRAINT `FK_COMP_VENTA_CAB_VEND` FOREIGN KEY (`cod_vendedor`) REFERENCES `vendedor` (`cod_vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_cabecera_venta` */

insert  into `comprobante_cabecera_venta`(`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`cod_sucursal`,`cod_deposito`,`fecha_comprobante`,`cod_cliente`,`cod_cobrador`,`cod_vendedor`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`cod_condicion_venta`,`descuento`,`cod_moneda`,`tipo_cambio`,`total_comprobante`,`total_gravada`,`total_exenta`,`total_iva`,`estado`,`cod_usuario`,`comentario`,`monto_cuota`,`cobrado`,`cod_motivo_anul`) values 
('FCO','A',4,'01','01','2018-09-02',1,'01','01',NULL,NULL,NULL,0,NULL,'01',NULL,500000,454545,NULL,45455,'P','root',NULL,0,'S',NULL),
('FCO','A',6,'01','01','2018-09-15',5,'01','01',NULL,NULL,NULL,0,NULL,'01',NULL,700000,636364,NULL,63636,'P','root',NULL,0,'S',NULL),
('FCO','A',7,'01','01','2018-09-15',1,'01','01',NULL,NULL,NULL,0,NULL,'01',NULL,1500000,1363636,NULL,136364,'P','root',NULL,0,NULL,NULL),
('FCO','A',11,'01','01','2018-09-15',6,'01','01',NULL,NULL,NULL,0,NULL,'01',NULL,900000,818182,NULL,81818,'P','root',NULL,0,NULL,NULL),
('FCO','A',12,'01','01','2018-09-15',6,'01','01',NULL,NULL,NULL,0,NULL,'01',NULL,1500000,1363636,NULL,136364,'P','root',NULL,0,NULL,NULL),
('FCR','A',5,'01','01','2018-09-15',1,'01','01',NULL,NULL,NULL,1,NULL,'01',NULL,700000,636364,NULL,63636,'P','root',NULL,700000,NULL,NULL),
('FCR','A',8,'01','01','2018-09-15',5,'01','01',NULL,NULL,NULL,3,NULL,'01',NULL,1500000,1363636,NULL,136364,'P','root',NULL,500000,NULL,NULL),
('FCR','A',9,'01','01','2018-09-15',4,'01','01',NULL,NULL,NULL,3,NULL,'01',NULL,2000000,1818182,NULL,181818,'P','root',NULL,666666,NULL,NULL),
('FCR','A',10,'01','01','2018-09-15',1,'01','01',NULL,NULL,NULL,1,NULL,'01',NULL,1800000,1636364,NULL,163636,'P','root',NULL,1800000,NULL,NULL);

/*Table structure for table `comprobante_detalle_compra` */

DROP TABLE IF EXISTS `comprobante_detalle_compra`;

CREATE TABLE `comprobante_detalle_compra` (
  `cod_tipo_comp` varchar(5) NOT NULL,
  `ser_timb_comp` varchar(30) NOT NULL,
  `nro_comprob_comp` int(11) NOT NULL,
  `cod_producto` varchar(100) NOT NULL,
  `cod_un_med` varchar(100) NOT NULL,
  `nro_lote` varchar(100) NOT NULL,
  `descripcion_prod` varchar(100) DEFAULT NULL,
  `cantidad_prod` int(11) DEFAULT NULL,
  `precio_unitario` int(11) DEFAULT NULL,
  `descuento` int(11) DEFAULT NULL,
  `importe` int(11) DEFAULT NULL,
  `total_iva_5` int(11) DEFAULT NULL,
  `total_iva_10` int(11) DEFAULT NULL,
  `gravada_5` int(11) DEFAULT NULL,
  `gravada_10` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`,`cod_producto`,`cod_un_med`,`nro_lote`),
  KEY `FK_COMP_CM_DET_EXIST_ART` (`cod_producto`,`cod_un_med`,`nro_lote`),
  CONSTRAINT `FK_COMP_CM_DET_ARTICULO` FOREIGN KEY (`cod_producto`, `cod_un_med`, `nro_lote`) REFERENCES `articulo` (`cod_articulo`, `cod_un_med`, `nro_lote`),
  CONSTRAINT `FK_COMP_CM_DET_COMP_CAB` FOREIGN KEY (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) REFERENCES `comprobante_cabecera_compra` (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_detalle_compra` */

insert  into `comprobante_detalle_compra`(`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`,`cod_producto`,`cod_un_med`,`nro_lote`,`descripcion_prod`,`cantidad_prod`,`precio_unitario`,`descuento`,`importe`,`total_iva_5`,`total_iva_10`,`gravada_5`,`gravada_10`) values 
('FCR','001-001',1,'AAA001','UN','0','LCD TOKYO',5,1500000,0,7500000,0,681818,0,6818182),
('FCR','001-001',1,'AAA001','UN','0101','LCD SAMSUNG',5,2000000,0,10000000,0,909091,0,9090909),
('FCR','001-001',2,'AAA003','UN','0','COCINA ELECTRICA',5,500000,0,2500000,0,227273,0,2272727),
('FCR','001-001',2,'AAA004','UN','0','EQUIPO DE SONIDO PHILIPS',3,1500000,0,4500000,0,409091,0,4090909);

/*Table structure for table `comprobante_detalle_venta` */

DROP TABLE IF EXISTS `comprobante_detalle_venta`;

CREATE TABLE `comprobante_detalle_venta` (
  `tipo_comprobante` varchar(5) NOT NULL,
  `ser_comprobante` varchar(5) NOT NULL,
  `nro_comprobante` int(15) NOT NULL,
  `cod_articulo` varchar(50) NOT NULL,
  `cod_un_med` varchar(100) NOT NULL,
  `nro_lote` varchar(100) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
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
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`cod_articulo`,`cod_un_med`,`nro_lote`),
  KEY `FK_COMP_VENTA_DET_STOCK` (`cod_articulo`,`cod_un_med`,`nro_lote`),
  CONSTRAINT `FK_COMP_VENTA_DET_CAB` FOREIGN KEY (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`) REFERENCES `comprobante_cabecera_venta` (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_COMP_VENTA_DET_STOCK` FOREIGN KEY (`cod_articulo`, `cod_un_med`, `nro_lote`) REFERENCES `existencia_articulo` (`cod_articulo`, `cod_un_medida`, `nro_lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_detalle_venta` */

insert  into `comprobante_detalle_venta`(`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`cod_articulo`,`cod_un_med`,`nro_lote`,`descripcion`,`cantidad`,`precio_unitario`,`descuento`,`gravada_10`,`gravada_5`,`importe_total`,`total_iva10`,`total_iva5`,`porcentaje_iva`,`cod_iva`,`porcentaje_descuento`,`nro_cuota`) values 
('FCO','A',4,'AAA003','UN','0','COCINA ELECTRICA',1,500000,0,454545,0,500000,45455,0,0,0,0,1),
('FCO','A',6,'AAA004','UN','0','EQUIPO DE SONIDO PHILIPS',1,700000,0,636364,0,700000,63636,0,0,0,0,1),
('FCO','A',7,'AAA001','UN','0101','LCD SAMSUNG',1,1500000,0,1363636,0,1500000,136364,0,0,0,0,1),
('FCO','A',11,'AAA003','UN','0','COCINA ELECTRICA',1,900000,0,818182,0,900000,81818,0,0,0,0,1),
('FCO','A',12,'AAA001','UN','0101','LCD SAMSUNG',1,1500000,0,1363636,0,1500000,136364,0,0,0,0,1),
('FCR','A',5,'AAA004','UN','0','EQUIPO DE SONIDO PHILIPS',1,700000,0,636364,0,700000,63636,0,0,0,0,1),
('FCR','A',8,'AAA001','UN','0101','LCD SAMSUNG',1,1500000,0,1363636,0,1500000,136364,0,0,0,0,1),
('FCR','A',9,'AAA001','UN','0','LCD TOKYO',1,2000000,0,1818182,0,2000000,181818,0,0,0,0,1),
('FCR','A',10,'AAA001','UN','0','LCD TOKYO',1,1800000,0,1636364,0,1800000,163636,0,0,0,0,1);

/*Table structure for table `condicion_venta` */

DROP TABLE IF EXISTS `condicion_venta`;

CREATE TABLE `condicion_venta` (
  `cod_condicion` int(10) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `numero_cuota` int(5) DEFAULT NULL,
  `dia_inicial` int(5) DEFAULT NULL,
  `plazo` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_condicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `condicion_venta` */

insert  into `condicion_venta`(`cod_condicion`,`descripcion`,`numero_cuota`,`dia_inicial`,`plazo`,`estado`) values 
(0,'CONTADO',0,0,0,'A'),
(1,'CREDITO(30 DIAS)',1,1,0,'A'),
(2,'CREDITO(60 DIAS)',2,1,0,'A'),
(3,'CREDITO(90 DIAS)',3,1,30,'A'),
(4,'CREDITO(120 DIAS)',4,1,30,'A');

/*Table structure for table `deposito_articulo` */

DROP TABLE IF EXISTS `deposito_articulo`;

CREATE TABLE `deposito_articulo` (
  `cod_sucursal` varchar(5) NOT NULL,
  `cod_deposito` varchar(5) NOT NULL,
  `desc_deposito` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`,`cod_deposito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `deposito_articulo` */

insert  into `deposito_articulo`(`cod_sucursal`,`cod_deposito`,`desc_deposito`) values 
('01','01','DEPOSITO CASA CENTRAL(1)'),
('02','02','DEPOSITO SUCURSAL(02)');

/*Table structure for table `estado_civil` */

DROP TABLE IF EXISTS `estado_civil`;

CREATE TABLE `estado_civil` (
  `cod_estado_civil` varchar(5) NOT NULL,
  `desc_estado_civil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_estado_civil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estado_civil` */

insert  into `estado_civil`(`cod_estado_civil`,`desc_estado_civil`) values 
('CAS','CASADO/A'),
('DIV','DIVORCIADO/A'),
('SOL','SOLTERO/A'),
('VIU','VIUDO/A');

/*Table structure for table `existencia_articulo` */

DROP TABLE IF EXISTS `existencia_articulo`;

CREATE TABLE `existencia_articulo` (
  `cod_sucursal` varchar(10) NOT NULL,
  `cod_deposito` varchar(10) NOT NULL,
  `cod_articulo` varchar(100) NOT NULL,
  `cod_un_medida` varchar(5) NOT NULL,
  `nro_lote` varchar(100) NOT NULL,
  `tipo_transacc` int(5) NOT NULL COMMENT 'tipo_transaccion',
  `sub_tipo_transacc` int(5) NOT NULL COMMENT 'sub_tipo_transaccion',
  `cantidad` int(5) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`,`cod_deposito`,`cod_articulo`,`cod_un_medida`,`nro_lote`,`tipo_transacc`,`sub_tipo_transacc`),
  KEY `FK_EXIST_ARTICULO_COD_DEP_SUC` (`cod_deposito`,`cod_sucursal`),
  KEY `FK_EXIST_ARTICULO_COD_ART` (`cod_articulo`,`cod_un_medida`,`nro_lote`),
  KEY `FK_EXIST_ARTICULO_COD_TIP_TRAN` (`tipo_transacc`),
  KEY `FK_EXIST_ARTICULO_COD_SUB_TIP_TRAN` (`sub_tipo_transacc`),
  CONSTRAINT `FK_EXIST_ARTICULO_COD_ART` FOREIGN KEY (`cod_articulo`, `cod_un_medida`, `nro_lote`) REFERENCES `articulo` (`cod_articulo`, `cod_un_med`, `nro_lote`),
  CONSTRAINT `FK_EXIST_ARTICULO_COD_DEP_SUC` FOREIGN KEY (`cod_deposito`, `cod_sucursal`) REFERENCES `deposito_articulo` (`cod_sucursal`, `cod_deposito`),
  CONSTRAINT `FK_EXIST_ARTICULO_COD_SUB_TIP_TRAN` FOREIGN KEY (`sub_tipo_transacc`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_EXIST_ARTICULO_COD_SUCURSAL` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_EXIST_ARTICULO_COD_TIP_TRAN` FOREIGN KEY (`tipo_transacc`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `existencia_articulo` */

insert  into `existencia_articulo`(`cod_sucursal`,`cod_deposito`,`cod_articulo`,`cod_un_medida`,`nro_lote`,`tipo_transacc`,`sub_tipo_transacc`,`cantidad`) values 
('01','01','AAA001','UN','0',3,7,5),
('01','01','AAA001','UN','0',4,10,2),
('01','01','AAA001','UN','0101',3,7,5),
('01','01','AAA001','UN','0101',4,10,3),
('01','01','AAA003','UN','0',3,7,5),
('01','01','AAA003','UN','0',4,10,2),
('01','01','AAA004','UN','0',3,7,3),
('01','01','AAA004','UN','0',4,10,2);

/*Table structure for table `forma_cobro_venta` */

DROP TABLE IF EXISTS `forma_cobro_venta`;

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
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`tipo_transaccion`,`sub_tipo_transaccion`),
  KEY `FK_FORM_COB_VEN_TRANS` (`tipo_transaccion`),
  KEY `FK_FORM_COB_VEN_SUB_TIP` (`sub_tipo_transaccion`),
  KEY `FK_FORM_COB_VEN_PERS` (`cod_persona_juridica`),
  CONSTRAINT `FK_FORM_COB_VEN_MOV_VEN` FOREIGN KEY (`tipo_mov_caja`, `ser_mov_caja`, `nro_mov_caja`) REFERENCES `movimiento_caja_venta` (`tipo_mov_caja`, `ser_mov_caja`, `nro_mov_caja`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_FORM_COB_VEN_PERS` FOREIGN KEY (`cod_persona_juridica`) REFERENCES `persona` (`cod_persona`),
  CONSTRAINT `FK_FORM_COB_VEN_SUB_TIP` FOREIGN KEY (`sub_tipo_transaccion`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_FORM_COB_VEN_TRANS` FOREIGN KEY (`tipo_transaccion`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `forma_cobro_venta` */

insert  into `forma_cobro_venta`(`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`tipo_transaccion`,`sub_tipo_transaccion`,`cod_persona_juridica`,`nro_valor`,`nro_cuenta`,`monto`) values 
('CAJ','A',1,2,4,NULL,'','',500000),
('CAJ','A',2,2,4,NULL,'','',700000),
('CAJ','A',3,2,4,NULL,'','',500000);

/*Table structure for table `forma_pago_compra` */

DROP TABLE IF EXISTS `forma_pago_compra`;

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
  PRIMARY KEY (`tipo_mov_caja_com`,`ser_mov_caja_com`,`nro_mov_caja_com`,`tipo_transaccion`,`sub_tipo_transaccion`),
  UNIQUE KEY `INDEX_FORMA_PAG_COMP_NRO_VALOR` (`nro_valor`),
  KEY `FK_FORMA_PAGO_COMP_TIP_TRANS` (`tipo_transaccion`),
  KEY `FK_FORMA_PAGO_COMP_SUB_TIP_TRANS` (`sub_tipo_transaccion`),
  KEY `FK_FORMA_PAGO_COMP_COD_PERS` (`cod_persona_juridica`),
  CONSTRAINT `FK_FORMA_PAGO_COMP_COD_PERS` FOREIGN KEY (`cod_persona_juridica`) REFERENCES `persona` (`cod_persona`),
  CONSTRAINT `FK_FORMA_PAGO_COMP_MOV_CAJ_COMP` FOREIGN KEY (`tipo_mov_caja_com`, `ser_mov_caja_com`, `nro_mov_caja_com`) REFERENCES `movimiento_caja_compra` (`tipo_mov_caja_com`, `ser_mov_caja_com`, `nro_mov_caja_com`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_FORMA_PAGO_COMP_SUB_TIP_TRANS` FOREIGN KEY (`sub_tipo_transaccion`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_FORMA_PAGO_COMP_TIP_TRANS` FOREIGN KEY (`tipo_transaccion`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `forma_pago_compra` */

/*Table structure for table `grupo_usuario` */

DROP TABLE IF EXISTS `grupo_usuario`;

CREATE TABLE `grupo_usuario` (
  `cod_grupo` varchar(10) NOT NULL,
  `desc_grupo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grupo_usuario` */

insert  into `grupo_usuario`(`cod_grupo`,`desc_grupo`) values 
('ADMIN','ADMINISTRACION DE SISTEMA'),
('COMPRAS','COMPRAS'),
('VENTAS','VENTAS Y FACTURACION');

/*Table structure for table `habilitacion_caja` */

DROP TABLE IF EXISTS `habilitacion_caja`;

CREATE TABLE `habilitacion_caja` (
  `nro_habilitacion` int(10) NOT NULL AUTO_INCREMENT,
  `fecha_hab` date DEFAULT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `saldo_inicial` int(10) DEFAULT NULL,
  `cod_sucursal` varchar(10) DEFAULT NULL,
  `cod_caja` varchar(15) DEFAULT NULL,
  `cod_usuario` varchar(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`nro_habilitacion`),
  KEY `FK_HAB_CAJ_COD_SUC_CAJ` (`cod_sucursal`,`cod_caja`),
  KEY `FK_HAB_CAJ_COD_USU` (`cod_usuario`),
  CONSTRAINT `FK_HAB_CAJ_COD_SUC_CAJ` FOREIGN KEY (`cod_sucursal`, `cod_caja`) REFERENCES `caja` (`cod_sucursal`, `cod_caja`),
  CONSTRAINT `FK_HAB_CAJ_COD_USU` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `habilitacion_caja` */

insert  into `habilitacion_caja`(`nro_habilitacion`,`fecha_hab`,`fecha_cierre`,`saldo_inicial`,`cod_sucursal`,`cod_caja`,`cod_usuario`,`estado`) values 
(1,'2018-05-03','2018-05-04',50000,'01','CAJ1','root','C'),
(2,'2018-05-04','2018-08-26',50000,'01','CAJ1','root','C'),
(3,'2018-08-26',NULL,10000,'01','CAJ1','root','H');

/*Table structure for table `iva` */

DROP TABLE IF EXISTS `iva`;

CREATE TABLE `iva` (
  `cod_iva` varchar(10) NOT NULL,
  `desc_iva` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_iva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `iva` */

insert  into `iva`(`cod_iva`,`desc_iva`) values 
('0','EXENTO'),
('10','I.V.A(10%)'),
('5','I.V.A(5%)');

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `cod_marca` varchar(10) NOT NULL,
  `desc_marca` varchar(80) NOT NULL,
  PRIMARY KEY (`cod_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `marca` */

insert  into `marca`(`cod_marca`,`desc_marca`) values 
('ACE','ACER'),
('AOC','AOC'),
('CAT','CAT'),
('DELL','DELL'),
('ECO','ECOPOWER'),
('GRAL','GENERAL'),
('GUR','GURU'),
('HP','HP'),
('KD','KDE'),
('NOK','NOKIA'),
('SAM','SAMSUNG'),
('TOY','TOKYO');

/*Table structure for table `modulo_sistema` */

DROP TABLE IF EXISTS `modulo_sistema`;

CREATE TABLE `modulo_sistema` (
  `cod_modulo` varchar(5) NOT NULL,
  `desc_modulo` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_modulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `modulo_sistema` */

insert  into `modulo_sistema`(`cod_modulo`,`desc_modulo`) values 
('AJ','AJUSTES SISTEMA'),
('AY','AYUDA'),
('CC','CUENTAS A COBRAR'),
('CM','COMPRAS'),
('CP','CUENTAS A PAGAR'),
('ST','STOCK'),
('VT','VENTAS Y FACTURACION');

/*Table structure for table `moneda` */

DROP TABLE IF EXISTS `moneda`;

CREATE TABLE `moneda` (
  `cod_moneda` varchar(5) NOT NULL,
  `desc_moneda` varchar(50) DEFAULT NULL,
  `siglas` varchar(5) DEFAULT NULL,
  `cod_pais` int(10) DEFAULT NULL,
  `decimales` int(5) DEFAULT NULL,
  `tipo_cambio` int(10) DEFAULT NULL,
  `tipo_cambio_compra` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `redondeo` int(10) DEFAULT NULL,
  PRIMARY KEY (`cod_moneda`),
  KEY `INDEX_COD_PAIS` (`cod_pais`),
  CONSTRAINT `FK_MONEDA_COD_PAIS` FOREIGN KEY (`cod_pais`) REFERENCES `pais` (`cod_pais`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `moneda` */

insert  into `moneda`(`cod_moneda`,`desc_moneda`,`siglas`,`cod_pais`,`decimales`,`tipo_cambio`,`tipo_cambio_compra`,`estado`,`redondeo`) values 
('01','GUARANIES','GS',1,2,48000,5000,'A',1),
('02','DOLAR AMERICANO','DOL',1,2,48000,5000,'A',1);

/*Table structure for table `motivo_anulac_comp` */

DROP TABLE IF EXISTS `motivo_anulac_comp`;

CREATE TABLE `motivo_anulac_comp` (
  `cod_motivo` int(10) NOT NULL AUTO_INCREMENT,
  `desc_motivo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_motivo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `motivo_anulac_comp` */

insert  into `motivo_anulac_comp`(`cod_motivo`,`desc_motivo`) values 
(1,'ERROR DE IMPRESION'),
(2,'ERROR OPERARIO'),
(3,'CLIENTE DESISTIO A LA COMPRA');

/*Table structure for table `movimiento_caja_compra` */

DROP TABLE IF EXISTS `movimiento_caja_compra`;

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
  KEY `nro_mov_caja_com` (`nro_mov_caja_com`),
  KEY `FK_MOV_CAJA_COMPRA_COD_SUC` (`cod_sucursal`),
  KEY `FK_MOV_CAJA_COMPRA_COD_PROV` (`cod_proveedor`),
  KEY `FK_MOV_CAJA_COMPRA_COD_USU` (`cod_usuario`),
  CONSTRAINT `FK_MOV_CAJA_COMPRA_COD_PROV` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedor` (`cod_proveedor`),
  CONSTRAINT `FK_MOV_CAJA_COMPRA_COD_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_MOV_CAJA_COMPRA_COD_USU` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movimiento_caja_compra` */

/*Table structure for table `movimiento_caja_venta` */

DROP TABLE IF EXISTS `movimiento_caja_venta`;

CREATE TABLE `movimiento_caja_venta` (
  `tipo_mov_caja` varchar(5) NOT NULL,
  `ser_mov_caja` varchar(5) NOT NULL,
  `nro_mov_caja` int(10) NOT NULL,
  `fecha_mov_caja_venta` date DEFAULT NULL,
  `cod_sucursal` varchar(5) DEFAULT NULL,
  `cod_caja` varchar(5) DEFAULT NULL,
  `cod_cliente` int(11) DEFAULT NULL,
  `cod_usuario` varchar(15) DEFAULT NULL,
  `numero_hab` int(11) DEFAULT NULL,
  `total_mov_caja` int(11) DEFAULT NULL,
  `anulado` varchar(1) DEFAULT NULL,
  `fecha_anulacion` date DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`),
  KEY `nro_mov_caja` (`nro_mov_caja`),
  KEY `FK_MOV_CAJ_VEN_CLIENTE` (`cod_cliente`),
  KEY `FK_MOV_CAJ_VEN_USUARIO` (`cod_usuario`),
  KEY `FK_MOV_CAJ_VEN_CAJA` (`cod_caja`,`cod_sucursal`),
  KEY `FK_MOV_CAJ_VEN_MOV` (`cod_sucursal`,`cod_caja`),
  CONSTRAINT `FK_MOV_CAJ_VEN_CLIENTE` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `FK_MOV_CAJ_VEN_MOV` FOREIGN KEY (`cod_sucursal`, `cod_caja`) REFERENCES `caja` (`cod_sucursal`, `cod_caja`),
  CONSTRAINT `FK_MOV_CAJ_VEN_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_MOV_CAJ_VEN_USUARIO` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movimiento_caja_venta` */

insert  into `movimiento_caja_venta`(`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`fecha_mov_caja_venta`,`cod_sucursal`,`cod_caja`,`cod_cliente`,`cod_usuario`,`numero_hab`,`total_mov_caja`,`anulado`,`fecha_anulacion`) values 
('CAJ','A',1,'2018-09-02','01','CAJ1',1,'root',3,500000,NULL,NULL),
('CAJ','A',2,'2018-09-15','01','CAJ1',5,'root',3,700000,NULL,NULL),
('CAJ','A',3,'2018-09-16','01','CAJ1',5,'root',3,500000,NULL,NULL);

/*Table structure for table `movimiento_comprobante_compra` */

DROP TABLE IF EXISTS `movimiento_comprobante_compra`;

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
  PRIMARY KEY (`tipo_mov_caja_com`,`ser_mov_caja_com`,`nro_mov_caja_com`,`cod_sucursal`,`tipo_transacc`,`sub_tipo_transacc`,`tipo_comprobante_com`,`ser_comprobante_com`,`nro_comprobante_com`),
  KEY `FK_MOV_COMP_COMPRA_COD_SUC` (`cod_sucursal`),
  KEY `FK_MOV_COMP_COMPRA_TIP_TRANS` (`tipo_transacc`),
  KEY `FK_MOV_COMP_COMPRA_SUB_TIP_TRANS` (`sub_tipo_transacc`),
  KEY `FK_MOV_COMP_COMPRA_COMP` (`tipo_comprobante_com`,`ser_comprobante_com`,`nro_comprobante_com`),
  CONSTRAINT `FK_MOV_COMP_COMPRA_COD_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_MOV_COMP_COMPRA_COMP` FOREIGN KEY (`tipo_comprobante_com`, `ser_comprobante_com`, `nro_comprobante_com`) REFERENCES `comprobante_cabecera_compra` (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`),
  CONSTRAINT `FK_MOV_COMP_COMPRA_SUB_TIP_TRANS` FOREIGN KEY (`sub_tipo_transacc`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_MOV_COMP_COMPRA_TIP_TRANS` FOREIGN KEY (`tipo_transacc`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movimiento_comprobante_compra` */

/*Table structure for table `movimiento_comprobante_venta` */

DROP TABLE IF EXISTS `movimiento_comprobante_venta`;

CREATE TABLE `movimiento_comprobante_venta` (
  `tipo_mov_caja` varchar(5) NOT NULL,
  `ser_mov_caja` varchar(5) NOT NULL,
  `nro_mov_caja` int(10) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `tipo_comprobante` varchar(5) NOT NULL,
  `ser_comprobante` varchar(5) NOT NULL,
  `nro_comprobante` int(10) NOT NULL,
  `total_comprobante` int(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`cod_sucursal`,`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`),
  KEY `FK_MOV_COMP_VEN_SUC` (`cod_sucursal`),
  CONSTRAINT `FK_MOV_COMP_VEN_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movimiento_comprobante_venta` */

insert  into `movimiento_comprobante_venta`(`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`cod_sucursal`,`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`total_comprobante`) values 
('CAJ','A',1,'01','FCO','A',4,500000),
('CAJ','A',2,'01','FCO','A',6,700000),
('CAJ','A',3,'01','REC','A',1,500000);

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `cod_pais` int(10) NOT NULL AUTO_INCREMENT,
  `desc_pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `pais` */

insert  into `pais`(`cod_pais`,`desc_pais`) values 
(1,'PARAGUAY'),
(2,'ARGENTINA'),
(3,'BRASIL'),
(4,'ECUADOR'),
(5,'CHILE'),
(6,'URUGUAY'),
(7,'VENEZUELA'),
(8,'COLOMBIA');

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `cod_persona` int(15) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `cod_tipo_doc` varchar(10) DEFAULT NULL,
  `ruc_ci` varchar(20) DEFAULT NULL,
  `cod_ciudad` int(10) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `direccion_trabajo` varchar(100) DEFAULT NULL,
  `telefono_domicilio` varchar(50) DEFAULT NULL,
  `telefono_trabajo` varchar(50) DEFAULT NULL,
  `celular` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `cod_estado_civil` varchar(5) DEFAULT NULL,
  `cod_pais` int(10) DEFAULT NULL,
  `es_banco` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_persona`),
  UNIQUE KEY `INDEX_RUC_CI` (`ruc_ci`),
  KEY `INDEX_COD_CIUDAD` (`cod_ciudad`),
  KEY `INDEX_COD_TIP_DOC` (`cod_tipo_doc`),
  KEY `INDEX_COD_EST_CIV` (`cod_estado_civil`),
  KEY `INDEX_COD_PAIS` (`cod_pais`),
  FULLTEXT KEY `INDEX_CI` (`ruc_ci`),
  CONSTRAINT `FK_PERSONA_COD_CIU` FOREIGN KEY (`cod_ciudad`) REFERENCES `ciudad` (`cod_ciudad`),
  CONSTRAINT `FK_PERSONA_COD_EST_CIV` FOREIGN KEY (`cod_estado_civil`) REFERENCES `estado_civil` (`cod_estado_civil`),
  CONSTRAINT `FK_PERSONA_COD_PAIS` FOREIGN KEY (`cod_pais`) REFERENCES `pais` (`cod_pais`),
  CONSTRAINT `FK_PERSONA_TIP_DOC` FOREIGN KEY (`cod_tipo_doc`) REFERENCES `tipo_documento` (`cod_tipo_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `persona` */

insert  into `persona`(`cod_persona`,`nombre`,`cod_tipo_doc`,`ruc_ci`,`cod_ciudad`,`direccion`,`direccion_trabajo`,`telefono_domicilio`,`telefono_trabajo`,`celular`,`fecha_nacimiento`,`cod_estado_civil`,`cod_pais`,`es_banco`) values 
(1,'JONATHAN DAVID TORRES VILLAGRA','CI','4749347',1,'AREGUA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2,'RICARDO JAVIER TORRES VILLAGRA','CI','4749373',2,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(3,'FRANCISCO JAVIER AMARILLA TORRES',NULL,NULL,1,'LUQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(4,'WILLIAM DAVID CESPEDES CORONEL',NULL,NULL,1,'LUQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(5,'VENTAS CASA CENTRAL',NULL,NULL,1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(6,'COBRADOR CASA CENTRAL',NULL,NULL,1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(7,'VENTAS CLIENTE MOSTRADOR',NULL,NULL,1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(8,'NGO',NULL,'80090',1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(9,'LASER IMPORT',NULL,NULL,1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(10,'AM REGUERA',NULL,NULL,1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(11,'PROVEEDOR DE PRUEBA',NULL,NULL,1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(12,'BANCO FAMILIAR',NULL,NULL,1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'S'),
(13,'BANCO VISION',NULL,NULL,1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'S'),
(14,'BANCO ITAU',NULL,NULL,1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'S'),
(16,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,2,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(17,'OCASIONAL',NULL,NULL,1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N');

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `cod_proveedor` int(10) NOT NULL AUTO_INCREMENT,
  `cod_persona` int(10) DEFAULT NULL,
  `cod_tipo_prov` varchar(5) DEFAULT NULL,
  `razon_social` varchar(80) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`),
  KEY `INDEX_COD_PERSONA` (`cod_persona`),
  KEY `INDEX_COD_TIPO_PROV` (`cod_tipo_prov`),
  CONSTRAINT `FK_PROVEEDOR_COD_PERSONA` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_PROVEEDOR_TIP_PROV` FOREIGN KEY (`cod_tipo_prov`) REFERENCES `tipo_prov_client` (`cod_tipo_provcl`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `proveedor` */

insert  into `proveedor`(`cod_proveedor`,`cod_persona`,`cod_tipo_prov`,`razon_social`,`estado`) values 
(5,8,NULL,NULL,'A'),
(6,9,NULL,NULL,'A'),
(7,10,NULL,NULL,'A');

/*Table structure for table `recibo_compra_cabecera` */

DROP TABLE IF EXISTS `recibo_compra_cabecera`;

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

/*Data for the table `recibo_compra_cabecera` */

/*Table structure for table `recibo_detalle_compra` */

DROP TABLE IF EXISTS `recibo_detalle_compra`;

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

/*Data for the table `recibo_detalle_compra` */

/*Table structure for table `recibo_detalle_venta` */

DROP TABLE IF EXISTS `recibo_detalle_venta`;

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
  PRIMARY KEY (`tipo_recibo`,`ser_recibo`,`nro_recibo`,`tipo_transaccion`,`sub_tipo_transac`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`,`fecha_vencimiento`),
  KEY `FK_DET_REC_VEN_TRANS` (`tipo_transaccion`),
  KEY `FK_DET_REC_VEN_SUB_TIP_TRANS` (`sub_tipo_transac`),
  KEY `FK_DET_REC_VEN_SAL_CLIEN` (`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`),
  CONSTRAINT `FK_DET_REC_VEN_SAL_CLIEN` FOREIGN KEY (`tipo_comprobante_ref`, `ser_comprobante_ref`, `nro_comprobante_ref`, `nro_cuota`) REFERENCES `saldo_cliente` (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`, `nro_cuota`),
  CONSTRAINT `FK_DET_REC_VEN_SUB_TIP_TRANS` FOREIGN KEY (`sub_tipo_transac`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_DET_REC_VEN_TRANS` FOREIGN KEY (`tipo_transaccion`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recibo_detalle_venta` */

insert  into `recibo_detalle_venta`(`tipo_recibo`,`ser_recibo`,`nro_recibo`,`tipo_transaccion`,`sub_tipo_transac`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`,`fecha_vencimiento`,`monto_cuota`,`importe_total`) values 
('REC','A',1,1,1,'FCR','A',8,1,'2018-10-15',500000,500000);

/*Table structure for table `recibo_venta_cabecera` */

DROP TABLE IF EXISTS `recibo_venta_cabecera`;

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
  PRIMARY KEY (`tipo_recibo`,`ser_recibo`,`nro_recibo`),
  KEY `FK_REC_VEN_CAB_TAL` (`tipo_recibo`,`ser_recibo`,`cod_sucursal`),
  KEY `FK_REC_VEN_CAB_SUC` (`cod_sucursal`),
  KEY `FK_REC_VEN_CAB_CLIEN` (`cod_cliente`),
  KEY `FK_REC_VEN_CAB_COB` (`cod_cobrador`),
  KEY `FK_REC_VEN_CAB_MON` (`cod_moneda`),
  KEY `FK_REC_VEN_CAB_USU` (`cod_usuario`),
  CONSTRAINT `FK_REC_VEN_CAB_CLIEN` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `FK_REC_VEN_CAB_COB` FOREIGN KEY (`cod_cobrador`) REFERENCES `cobrador` (`cod_cobrador`),
  CONSTRAINT `FK_REC_VEN_CAB_MON` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`),
  CONSTRAINT `FK_REC_VEN_CAB_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_REC_VEN_CAB_TAL` FOREIGN KEY (`tipo_recibo`, `ser_recibo`, `cod_sucursal`) REFERENCES `talonario` (`tipo_talonario`, `serie`, `cod_sucursal`),
  CONSTRAINT `FK_REC_VEN_CAB_USU` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recibo_venta_cabecera` */

insert  into `recibo_venta_cabecera`(`tipo_recibo`,`ser_recibo`,`nro_recibo`,`cod_sucursal`,`fecha_recibo`,`cod_cliente`,`cod_cobrador`,`cod_moneda`,`cod_usuario`,`estado`,`total_recibo`,`comentario`,`cobrado`) values 
('REC','A',1,'01','2018-09-16',5,'01','01','root','P',500000,NULL,'S');

/*Table structure for table `saldo_cliente` */

DROP TABLE IF EXISTS `saldo_cliente`;

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
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`),
  KEY `FK_SALD_CLI_CLIENT` (`cod_cliente`),
  KEY `FK_SALD_CLI_SUC` (`cod_sucursal`),
  KEY `FK_SALD_CLI_MONE` (`cod_moneda`),
  KEY `FK_SALD_CLI_US` (`cod_usuario`),
  CONSTRAINT `FK_SALD_CLI_CLIENT` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `FK_SALD_CLI_COMP_CAB` FOREIGN KEY (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`) REFERENCES `comprobante_cabecera_venta` (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SALD_CLI_MONE` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`),
  CONSTRAINT `FK_SALD_CLI_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_SALD_CLI_US` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `saldo_cliente` */

insert  into `saldo_cliente`(`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`,`cod_sucursal`,`cod_cliente`,`fecha_vencimiento`,`monto_cuota`,`cod_moneda`,`saldo_cuota`,`cod_usuario`) values 
('FCR','A',5,1,'01',1,'2018-10-15',700000,'01',700000,'root'),
('FCR','A',8,1,'01',5,'2018-10-15',500000,'01',0,'root'),
('FCR','A',8,2,'01',5,'2018-11-15',500000,'01',500000,'root'),
('FCR','A',8,3,'01',5,'2018-12-15',500000,'01',500000,'root'),
('FCR','A',9,1,'01',4,'2018-10-15',666666,'01',666666,'root'),
('FCR','A',9,2,'01',4,'2018-11-15',666666,'01',666666,'root'),
('FCR','A',9,3,'01',4,'2018-12-15',666666,'01',666666,'root'),
('FCR','A',10,1,'01',1,'2018-10-15',1800000,'01',1800000,'root');

/*Table structure for table `saldo_proveedor` */

DROP TABLE IF EXISTS `saldo_proveedor`;

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
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`),
  CONSTRAINT `FK_SALDO_PROV_TIP_SER_NRO` FOREIGN KEY (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`) REFERENCES `comprobante_cabecera_compra` (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `saldo_proveedor` */

insert  into `saldo_proveedor`(`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`,`cod_sucursal`,`cod_proveedor`,`fecha_vencimiento`,`monto_cuota`,`cod_moneda`,`saldo_cuota`,`cod_usuario`) values 
('FCR','001-001',1,1,'01',5,'2018-09-24',17500000,'01',17500000,'root'),
('FCR','001-001',2,1,'01',6,'2018-08-24',7000000,'01',7000000,'root');

/*Table structure for table `serie_comprobante` */

DROP TABLE IF EXISTS `serie_comprobante`;

CREATE TABLE `serie_comprobante` (
  `tipo_comprobante` varchar(3) NOT NULL,
  `ser_comprobante` varchar(2) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `numero_inicial` int(15) DEFAULT NULL,
  `numero_final` int(15) DEFAULT NULL,
  `ser_timbrado` varchar(30) DEFAULT NULL,
  `numero_timbrado` varchar(30) DEFAULT NULL,
  `fecha_vigencia` date DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`cod_sucursal`),
  KEY `FK_SER_COMP_COD_SUC` (`cod_sucursal`),
  CONSTRAINT `FK_SER_COMP_COD_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`),
  CONSTRAINT `FK_SER_COMP_TIP_COMP` FOREIGN KEY (`tipo_comprobante`) REFERENCES `tipo_comprobante` (`tipo_comprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `serie_comprobante` */

insert  into `serie_comprobante`(`tipo_comprobante`,`ser_comprobante`,`cod_sucursal`,`numero_inicial`,`numero_final`,`ser_timbrado`,`numero_timbrado`,`fecha_vigencia`) values 
('FCO','A','01',1,1000,'001-001','123456','2019-04-16'),
('FCO','B','01',1,1000,'001-002','123456','2019-04-16'),
('FCO','C','01',1,1000,'001-001','123456','2019-06-20'),
('FCR','A','01',1,1000,'001-001','123456','2019-04-16'),
('FCR','B','01',1,1000,'001-002','1234567','2019-04-16'),
('FCR','C','01',1,1000,'001-001','123456','2019-06-20'),
('REC','A','01',1,1000,'001-001',NULL,NULL);

/*Table structure for table `sub_tipo_transaccion` */

DROP TABLE IF EXISTS `sub_tipo_transaccion`;

CREATE TABLE `sub_tipo_transaccion` (
  `cod_sub_tipo_trans` int(5) NOT NULL AUTO_INCREMENT,
  `cod_tipo_trans` int(5) NOT NULL,
  `cod_modulo` varchar(5) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_sub_tipo_trans`,`cod_tipo_trans`,`cod_modulo`),
  UNIQUE KEY `cod_sub_tipo_trans` (`cod_sub_tipo_trans`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `sub_tipo_transaccion` */

insert  into `sub_tipo_transaccion`(`cod_sub_tipo_trans`,`cod_tipo_trans`,`cod_modulo`,`descripcion`,`estado`) values 
(1,1,'CC','CANCELACION DE COMPROBANTE VENTA',NULL),
(2,1,'CC','COBROS A CUENTA',NULL),
(3,1,'CC','A APLICAR',NULL),
(4,2,'CC','EFECTIVO',NULL),
(5,2,'CC','CHEQUE',NULL),
(6,3,'CC','TARJETA',NULL),
(7,3,'ST','ENTRADA DE ARTICULOS EN STOCK POR COMPRAS','A'),
(8,3,'ST','ENTRADA DE ARTICULOS EN STOCK POR AJUSTE','A'),
(9,3,'ST','ENTRADA DE ARTICULOS EN STOCK POR NOTAS DE CREDITO','A'),
(10,4,'ST','SALIDA DE ARTICULOS POR VENTAS','A'),
(11,4,'ST','SALIDA DE ARTICULOS POR AJUSTE','A'),
(12,4,'ST','SALIDA DE ARTICULOS POR NOTAS DE CREDITO','A'),
(13,5,'CP','CANCELACION COMPROBANTE COMPRA','A'),
(14,5,'CP','PAGOS A CUENTA','A');

/*Table structure for table `sucursal` */

DROP TABLE IF EXISTS `sucursal`;

CREATE TABLE `sucursal` (
  `cod_sucursal` varchar(10) NOT NULL,
  `desc_sucursal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sucursal` */

insert  into `sucursal`(`cod_sucursal`,`desc_sucursal`) values 
('01','AREGUA'),
('02','LUQUE');

/*Table structure for table `talonario` */

DROP TABLE IF EXISTS `talonario`;

CREATE TABLE `talonario` (
  `tipo_talonario` varchar(3) NOT NULL,
  `serie` varchar(2) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `nro_talonario` int(5) NOT NULL,
  `numero_inicial` int(15) DEFAULT NULL,
  `numero_final` int(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`tipo_talonario`,`serie`,`cod_sucursal`,`nro_talonario`),
  CONSTRAINT `FK_TAL_TIP_SER_COMP` FOREIGN KEY (`tipo_talonario`, `serie`, `cod_sucursal`) REFERENCES `serie_comprobante` (`tipo_comprobante`, `ser_comprobante`, `cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `talonario` */

insert  into `talonario`(`tipo_talonario`,`serie`,`cod_sucursal`,`nro_talonario`,`numero_inicial`,`numero_final`,`estado`) values 
('FCO','A','01',1,1,1000,'A'),
('FCO','B','01',1,1,1000,'A'),
('FCR','A','01',1,1,1000,'A'),
('FCR','B','01',1,1,1000,'A'),
('REC','A','01',1,1,1000,'A');

/*Table structure for table `talonario_usuario` */

DROP TABLE IF EXISTS `talonario_usuario`;

CREATE TABLE `talonario_usuario` (
  `tipo_talonario` varchar(3) NOT NULL,
  `serie` varchar(2) NOT NULL,
  `cod_sucursal` varchar(5) NOT NULL,
  `nro_talonario` int(5) NOT NULL,
  `cod_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`tipo_talonario`,`serie`,`cod_sucursal`,`nro_talonario`,`cod_usuario`),
  KEY `FK_TAL_US_COD_USU` (`cod_usuario`),
  CONSTRAINT `FK_TAL_USU_TIP_SER_TAL` FOREIGN KEY (`tipo_talonario`, `serie`, `cod_sucursal`, `nro_talonario`) REFERENCES `talonario` (`tipo_talonario`, `serie`, `cod_sucursal`, `nro_talonario`),
  CONSTRAINT `FK_TAL_US_COD_USU` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `talonario_usuario` */

insert  into `talonario_usuario`(`tipo_talonario`,`serie`,`cod_sucursal`,`nro_talonario`,`cod_usuario`) values 
('FCO','A','01',1,'root'),
('FCO','B','01',1,'root'),
('FCR','A','01',1,'root'),
('FCR','B','01',1,'root'),
('REC','A','01',1,'root');

/*Table structure for table `tipo_cliente` */

DROP TABLE IF EXISTS `tipo_cliente`;

CREATE TABLE `tipo_cliente` (
  `cod_tipo_cliente` varchar(10) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tipo_cliente` */

insert  into `tipo_cliente`(`cod_tipo_cliente`,`descripcion`) values 
('00','GRAL'),
('01','NORMAL'),
('02','MAYORISTA');

/*Table structure for table `tipo_comprobante` */

DROP TABLE IF EXISTS `tipo_comprobante`;

CREATE TABLE `tipo_comprobante` (
  `tipo_comprobante` varchar(3) NOT NULL,
  `cod_modulo` varchar(3) NOT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `lineas` int(2) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`cod_modulo`),
  KEY `FK_TIP_COMP_COD_MOD` (`cod_modulo`),
  CONSTRAINT `FK_TIP_COMP_COD_MOD` FOREIGN KEY (`cod_modulo`) REFERENCES `modulo_sistema` (`cod_modulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tipo_comprobante` */

insert  into `tipo_comprobante`(`tipo_comprobante`,`cod_modulo`,`descripcion`,`lineas`) values 
('FCO','VT','FACTURA CONTADO',10),
('FCR','VT','FACTURA CREDITO',10),
('REC','CC','RECIBO VENTA',10);

/*Table structure for table `tipo_documento` */

DROP TABLE IF EXISTS `tipo_documento`;

CREATE TABLE `tipo_documento` (
  `cod_tipo_doc` varchar(10) NOT NULL,
  `Desc_tipo_doc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tipo_documento` */

insert  into `tipo_documento`(`cod_tipo_doc`,`Desc_tipo_doc`) values 
('CI','CEDULA DE INDENTIDAD'),
('DOCEX','DOCUMENTO EXTRANJERO'),
('PAS','PASAPORTE'),
('RUC','REGISTRO UNICO CONTRIBUYENTE');

/*Table structure for table `tipo_prov_client` */

DROP TABLE IF EXISTS `tipo_prov_client`;

CREATE TABLE `tipo_prov_client` (
  `cod_tipo_provcl` varchar(10) NOT NULL,
  `desc_tipo_provcl` varchar(80) NOT NULL,
  PRIMARY KEY (`cod_tipo_provcl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tipo_prov_client` */

insert  into `tipo_prov_client`(`cod_tipo_provcl`,`desc_tipo_provcl`) values 
('ELECT','ELECTRICOS/ELECTRONICOS'),
('GRAL','GENERAL'),
('INSOF','INSUMOS P/OFICINAS');

/*Table structure for table `tipo_transaccion` */

DROP TABLE IF EXISTS `tipo_transaccion`;

CREATE TABLE `tipo_transaccion` (
  `cod_tipo_trans` int(5) NOT NULL AUTO_INCREMENT,
  `cod_modulo` varchar(5) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_trans`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tipo_transaccion` */

insert  into `tipo_transaccion`(`cod_tipo_trans`,`cod_modulo`,`descripcion`,`estado`) values 
(1,'CC','CONCEPTO PARA RECIBOS','A'),
(2,'CC','CONCEPTO PARA COBROS','A'),
(3,'ST','ENTRADAS DE ARTICULOS','A'),
(4,'ST','SALIDAS DE ARTICULOS','A'),
(5,'CP','CONCEPTO PARA PAGOS','A'),
(6,'CP','CONCEPTO FORMA DE PAGOS','A');

/*Table structure for table `unidad_med_articulo` */

DROP TABLE IF EXISTS `unidad_med_articulo`;

CREATE TABLE `unidad_med_articulo` (
  `cod_un_med` varchar(5) NOT NULL,
  `desc_un_med` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_un_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `unidad_med_articulo` */

insert  into `unidad_med_articulo`(`cod_un_med`,`desc_un_med`) values 
('CAJ','CAJA'),
('GR','GRAMO'),
('KG','KILOGRAMO'),
('LT','LITRO'),
('ML','MILILITRO'),
('UN','UNIDAD');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `cod_usuario` varchar(10) NOT NULL,
  `clave_usuario` varchar(50) DEFAULT NULL,
  `cod_persona` int(15) DEFAULT NULL,
  `cod_grupo` varchar(15) DEFAULT NULL,
  `cod_sucursal` varchar(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  KEY `FK_USUARIO_COD_PERS` (`cod_persona`),
  KEY `FK_USUARIO_COD_GRUP` (`cod_grupo`),
  KEY `FK_USUARIO_COD_SUC` (`cod_sucursal`),
  CONSTRAINT `FK_USUARIO_COD_GRUP` FOREIGN KEY (`cod_grupo`) REFERENCES `grupo_usuario` (`cod_grupo`),
  CONSTRAINT `FK_USUARIO_COD_PERS` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`),
  CONSTRAINT `FK_USUARIO_COD_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`cod_usuario`,`clave_usuario`,`cod_persona`,`cod_grupo`,`cod_sucursal`,`estado`) values 
('jony','administrador',1,'ADMIN','01','A'),
('JTORRES','JTORRES123',1,'ADMIN','01','A'),
('RIKY','RIKY123456',2,'VENTAS','01','A'),
('root','manager',16,'ADMIN','01','A'),
('VENTAS','VENTAS1234',5,'VENTAS','01','A');

/*Table structure for table `vendedor` */

DROP TABLE IF EXISTS `vendedor`;

CREATE TABLE `vendedor` (
  `cod_vendedor` varchar(20) NOT NULL,
  `cod_persona` int(10) DEFAULT NULL,
  `cod_zona` varchar(10) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `porc_comision` int(10) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_vendedor`),
  KEY `INDEX_COD_PERS` (`cod_persona`),
  CONSTRAINT `FK_VENDEDOR_COD_PERSONA` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vendedor` */

insert  into `vendedor`(`cod_vendedor`,`cod_persona`,`cod_zona`,`descripcion`,`porc_comision`,`estado`) values 
('01',5,NULL,NULL,NULL,'A'),
('02',7,NULL,NULL,NULL,'A');

/* Trigger structure for table `comprobante_cabecera_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_generar_saldo_proveedor` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_generar_saldo_proveedor` AFTER INSERT ON `comprobante_cabecera_compra` FOR EACH ROW BEGIN
CALL generar_saldo_proveedor(new.cod_tipo_comp,new.ser_timb_comp,new.nro_comprob_comp,new.cod_cond_comp,new.cod_sucursal,new.cod_proveedor,new.fecha_comprob_comp,new.total_comprob_comp,new.cod_moneda,new.total_comprob_comp,new.cod_usuario);
END */$$


DELIMITER ;

/* Trigger structure for table `comprobante_cabecera_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_generar_saldo_cliente` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_generar_saldo_cliente` AFTER INSERT ON `comprobante_cabecera_venta` FOR EACH ROW BEGIN
CALL generar_saldo_cliente(new.tipo_comprobante,new.ser_comprobante,new.nro_comprobante,new.cod_condicion_venta,new.cod_sucursal,new.cod_cliente,new.fecha_comprobante,new.monto_cuota,new.cod_moneda,new.monto_cuota,new.cod_usuario);
END */$$


DELIMITER ;

/* Trigger structure for table `comprobante_detalle_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_activa_stock_compra` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_activa_stock_compra` AFTER INSERT ON `comprobante_detalle_compra` FOR EACH ROW BEGIN
declare ea  varchar(1);
DECLARE suc VARCHAR(5);
DECLARE dep VARCHAR(5);
	
	SELECT 	cod_sucursal,cod_deposito
	INTO 	suc,dep
	FROM 	comprobante_cabecera_compra
	WHERE	cod_tipo_comp=new.cod_tipo_comp
		AND ser_timb_comp=new.ser_timb_comp
		AND nro_comprob_comp=new.nro_comprob_comp;
	
	SELECT 'S' INTO ea
	FROM 	existencia_articulo 
	WHERE 	cod_articulo=new.cod_producto
		and cod_un_medida=new.cod_un_med
		and nro_lote=new.nro_lote
		AND cod_sucursal=suc
		AND cod_deposito=dep
		AND tipo_transacc=3
		AND sub_tipo_transacc=7;
	   	
	IF ea = 'S' THEN
		UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad_prod WHERE cod_articulo=new.cod_producto and cod_un_medida=new.cod_un_med and nro_lote=new.nro_lote AND cod_sucursal=suc AND cod_deposito=dep AND tipo_transacc=3 AND sub_tipo_transacc=7;
	ELSE
		CALL insertar_exist_articulo(suc,dep,new.cod_producto,new.cod_un_med,new.nro_lote,3,7,new.cantidad_prod);
	END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `comprobante_detalle_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_stock_compra_delete` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_stock_compra_delete` BEFORE DELETE ON `comprobante_detalle_compra` FOR EACH ROW BEGIN
DECLARE ea  VARCHAR(1);
DECLARE suc VARCHAR(5);
DECLARE dep VARCHAR(5);
	
	SELECT 	cod_sucursal,cod_deposito
	INTO 	suc,dep
	FROM 	comprobante_cabecera_compra
	WHERE	cod_tipo_comp=old.cod_tipo_comp
		AND ser_timb_comp=old.ser_timb_comp
		AND nro_comprob_comp=old.nro_comprob_comp;
	
	SELECT 'S' INTO ea
	FROM 	existencia_articulo 
	WHERE 	cod_articulo=old.cod_producto
		AND cod_un_medida=old.cod_un_med
		AND nro_lote=old.nro_lote
		AND cod_sucursal=suc
		AND cod_deposito=dep
		AND tipo_transacc=3
		AND sub_tipo_transacc=7;
	   	
	IF ea = 'S' THEN
		UPDATE  existencia_articulo SET cantidad=cantidad-old.cantidad_prod WHERE cod_articulo=old.cod_producto AND cod_un_medida=old.cod_un_med AND nro_lote=old.nro_lote AND cod_sucursal=suc AND cod_deposito=dep AND tipo_transacc=3 AND sub_tipo_transacc=7;
	END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `comprobante_detalle_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_desactiva_stock_venta` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_desactiva_stock_venta` AFTER INSERT ON `comprobante_detalle_venta` FOR EACH ROW BEGIN
DECLARE s VARCHAR(1);
DECLARE ea VARCHAR(1);
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
           AND cod_un_med=new.cod_un_med
	   AND nro_lote=new.nro_lote;
	   
SELECT 'S' INTO ea
     FROM existencia_articulo 
     WHERE cod_articulo=new.cod_articulo
	   AND cod_un_medida=new.cod_un_med
	   AND nro_lote=new.nro_lote 
           AND cod_sucursal=suc
	   AND cod_deposito=dep
	   AND tipo_transacc=4
	   AND sub_tipo_transacc=10;
	   
IF s='S'  THEN
	
	IF ea = 'S' THEN
		UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad WHERE cod_articulo=new.cod_articulo and cod_un_medida=new.cod_un_med AND nro_lote=new.nro_lote AND cod_sucursal=suc AND cod_deposito=dep AND tipo_transacc=4 AND sub_tipo_transacc=10;
	ELSE
		CALL insertar_exist_articulo(suc,dep,new.cod_articulo,new.cod_un_med,new.nro_lote,4,10,new.cantidad);
	END IF;
END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_caja_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_borra_det_mov_compra` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_borra_det_mov_compra` AFTER DELETE ON `movimiento_caja_compra` FOR EACH ROW BEGIN
DELETE FROM  movimiento_comprobante_compra
WHERE tipo_mov_caja_com=old.tipo_mov_caja_com
AND ser_mov_caja_com=old.ser_mov_caja_com
AND nro_mov_caja_com=old.nro_mov_caja_com;
DELETE FROM  forma_pago_compra
WHERE tipo_mov_caja_com=old.tipo_mov_caja_com
AND ser_mov_caja_com=old.ser_mov_caja_com
AND nro_mov_caja_com=old.nro_mov_caja_com;
    END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_caja_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_borra_det_mov_venta` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_borra_det_mov_venta` AFTER DELETE ON `movimiento_caja_venta` FOR EACH ROW BEGIN
DELETE FROM  movimiento_comprobante_venta
WHERE tipo_mov_caja=old.tipo_mov_caja
AND ser_mov_caja=old.ser_mov_caja
AND nro_mov_caja=old.nro_mov_caja;
DELETE FROM  forma_cobro_venta
WHERE tipo_mov_caja=old.tipo_mov_caja
AND ser_mov_caja=old.ser_mov_caja
AND nro_mov_caja=old.nro_mov_caja;
    END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_comprobante_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_saldo_proveedor_forma_pago` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_saldo_proveedor_forma_pago` AFTER INSERT ON `movimiento_comprobante_compra` FOR EACH ROW BEGIN
UPDATE  saldo_proveedor SET saldo_cuota=(saldo_cuota-new.total_comprobante_com)
WHERE tipo_comprobante=new.tipo_comprobante_com
AND ser_comprobante=new.ser_comprobante_com
AND nro_comprobante=new.nro_comprobante_com;
END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_comprobante_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_pago_comprob_compra` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_pago_comprob_compra` AFTER INSERT ON `movimiento_comprobante_compra` FOR EACH ROW BEGIN
IF (new.tipo_transacc=5 and new.sub_tipo_transacc=13) THEN
UPDATE  comprobante_cabecera_compra SET pagado='S'
WHERE cod_tipo_comp=new.tipo_comprobante_com
AND ser_timb_comp=new.ser_comprobante_com
AND nro_comprob_comp=new.nro_comprobante_com;
END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_comprobante_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_pago_comprob_compra_delete` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_pago_comprob_compra_delete` BEFORE DELETE ON `movimiento_comprobante_compra` FOR EACH ROW BEGIN
IF (old.tipo_transacc=5 AND old.sub_tipo_transacc=13) THEN
UPDATE  comprobante_cabecera_compra SET pagado='N'
WHERE cod_tipo_comp=old.tipo_comprobante_com
AND ser_timb_comp=old.ser_comprobante_com
AND nro_comprob_comp=old.nro_comprobante_com;
END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_comprobante_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_borr_saldo_proveedor_forma_pago` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_borr_saldo_proveedor_forma_pago` AFTER DELETE ON `movimiento_comprobante_compra` FOR EACH ROW BEGIN
UPDATE  saldo_proveedor
SET saldo_cuota=(saldo_cuota+old.total_comprobante_com)
WHERE tipo_comprobante=old.tipo_comprobante_com
AND ser_comprobante=old.ser_comprobante_com
AND nro_comprobante=old.nro_comprobante_com;
    END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_comprobante_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_cobro_ventas` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_cobro_ventas` AFTER INSERT ON `movimiento_comprobante_venta` FOR EACH ROW BEGIN
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
END */$$


DELIMITER ;

/* Trigger structure for table `movimiento_comprobante_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_cobro_ventas_delete` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_cobro_ventas_delete` BEFORE DELETE ON `movimiento_comprobante_venta` FOR EACH ROW BEGIN
IF (old.tipo_comprobante='FCO') THEN
UPDATE  comprobante_cabecera_venta SET cobrado='N'
WHERE tipo_comprobante=old.tipo_comprobante
AND ser_comprobante=old.ser_comprobante
AND nro_comprobante=old.nro_comprobante;
END IF;
IF (old.tipo_comprobante='REC') THEN
UPDATE  recibo_venta_cabecera SET cobrado='N'
WHERE tipo_recibo=old.tipo_comprobante
AND ser_recibo=old.ser_comprobante
AND nro_recibo=old.nro_comprobante;
END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `recibo_compra_cabecera` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_borra_detalle_recibo_compra` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_borra_detalle_recibo_compra` AFTER DELETE ON `recibo_compra_cabecera` FOR EACH ROW BEGIN
DELETE FROM  recibo_detalle_compra
WHERE tipo_rec_comp=old.tipo_rec_comp
AND ser_rec_comp=old.ser_rec_comp
AND nro_rec_comp=old.nro_rec_comp;
    END */$$


DELIMITER ;

/* Trigger structure for table `recibo_detalle_compra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_saldo_proveedor_recibo_compra` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_saldo_proveedor_recibo_compra` AFTER INSERT ON `recibo_detalle_compra` FOR EACH ROW BEGIN
UPDATE  saldo_proveedor SET saldo_cuota=(saldo_cuota-new.importe_total)
WHERE tipo_comprobante=new.tipo_comprobante_ref
AND ser_comprobante=new.ser_comprobante_ref
AND nro_comprobante=new.nro_comprobante_ref
AND nro_cuota=new.nro_cuota;
END */$$


DELIMITER ;

/* Trigger structure for table `recibo_detalle_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_saldo_cliente_recibo_venta` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_saldo_cliente_recibo_venta` AFTER INSERT ON `recibo_detalle_venta` FOR EACH ROW BEGIN
UPDATE  saldo_cliente SET saldo_cuota=(saldo_cuota-new.importe_total)
WHERE tipo_comprobante=new.tipo_comprobante_ref
AND ser_comprobante=new.ser_comprobante_ref
AND nro_comprobante=new.nro_comprobante_ref
AND nro_cuota=new.nro_cuota;
END */$$


DELIMITER ;

/* Trigger structure for table `recibo_detalle_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_borr_saldo_cliente_recibo_venta` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_borr_saldo_cliente_recibo_venta` BEFORE DELETE ON `recibo_detalle_venta` FOR EACH ROW BEGIN
UPDATE  saldo_cliente
SET saldo_cuota=(saldo_cuota+old.importe_total)
WHERE tipo_comprobante=old.tipo_comprobante_ref
AND ser_comprobante=old.ser_comprobante_ref
AND nro_comprobante=old.nro_comprobante_ref
AND nro_cuota=old.nro_cuota;
    END */$$


DELIMITER ;

/* Trigger structure for table `recibo_venta_cabecera` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_borra_detalle_recibo_venta` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_borra_detalle_recibo_venta` AFTER DELETE ON `recibo_venta_cabecera` FOR EACH ROW BEGIN
DELETE FROM  recibo_detalle_venta
WHERE tipo_recibo=old.tipo_recibo
AND ser_recibo=old.ser_recibo
AND nro_recibo=old.nro_recibo;
    END */$$


DELIMITER ;

/* Function  structure for function  `retorna_nro_comp_venta_inicial` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_nro_comp_venta_inicial` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_nro_comp_venta_inicial`(sc varchar(5),tp VARCHAR(5),sr VARCHAR(2)) RETURNS int(11)
BEGIN
DECLARE nro INT;
  SELECT t.numero_inicial
  into nro
  FROM talonario t
  WHERE t.cod_sucursal=sc AND t.serie=sr AND t.tipo_talonario=tp;
RETURN nro;
END */$$
DELIMITER ;

/* Function  structure for function  `retorna_permiso_delete` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_permiso_delete` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_permiso_delete`(grupo varchar(15),modulo VARCHAR(5),form VARCHAR(10)) RETURNS varchar(1) CHARSET latin1
BEGIN
DECLARE perm varchar(1);
	select ag.puede_borrar
	into perm
	from acceso_grupo ag
	where ag.cod_grupo=grupo
	and ag.cod_modulo=modulo
    and ag.desc_formulario=form;
RETURN perm;
END */$$
DELIMITER ;

/* Function  structure for function  `retorna_permiso_insert` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_permiso_insert` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_permiso_insert`(grupo varchar(15),modulo VARCHAR(5),form VARCHAR(10)) RETURNS varchar(1) CHARSET latin1
BEGIN
DECLARE perm varchar(1);
	select ag.puede_insert
	into perm
	from acceso_grupo ag
	where ag.cod_grupo=grupo
	and ag.cod_modulo=modulo
    and ag.desc_formulario=form;
RETURN perm;
END */$$
DELIMITER ;

/* Function  structure for function  `retorna_permiso_update` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_permiso_update` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_permiso_update`(grupo varchar(15),modulo VARCHAR(5),form VARCHAR(10)) RETURNS varchar(1) CHARSET latin1
BEGIN
DECLARE perm varchar(1);
	select ag.puede_modif
	into perm
	from acceso_grupo ag
	where ag.cod_grupo=grupo
	and ag.cod_modulo=modulo
    and ag.desc_formulario=form;
RETURN perm;
END */$$
DELIMITER ;

/* Function  structure for function  `retorna_porc_iva_art` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_porc_iva_art` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_porc_iva_art`(cod VARCHAR(100),uni varchar(5),lote varchar(100)) RETURNS int(11)
BEGIN
DECLARE iva INT;
SELECT IFNULL(p.cod_iva,0) INTO iva
     FROM articulo p 
     WHERE p.cod_articulo=cod
	   and p.cod_un_med=uni
	   and p.nro_lote=lote;
RETURN iva;
END */$$
DELIMITER ;

/* Function  structure for function  `retorna_usuario_grupo` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_usuario_grupo` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_usuario_grupo`(nom VARCHAR(20)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN
      DECLARE n VARCHAR(10);
     SELECT cod_grupo INTO n
     FROM usuario 
     WHERE cod_usuario=nom;
RETURN n;
END */$$
DELIMITER ;

/* Function  structure for function  `verif_codigo_prod` */

/*!50003 DROP FUNCTION IF EXISTS `verif_codigo_prod` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_codigo_prod`(cod VARCHAR(50),uni VARCHAR(5),lot VARCHAR(100)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
DECLARE s VARCHAR(15);
SELECT cod_articulo INTO s
FROM articulo 
WHERE cod_articulo=cod
       and cod_un_med=uni
       and nro_lote=lot;
IF s=cod  THEN
SET mens="S";
ELSE
SET mens="N";
END IF;
RETURN mens;
    END */$$
DELIMITER ;

/* Function  structure for function  `verif_exisc_saldo_cliente` */

/*!50003 DROP FUNCTION IF EXISTS `verif_exisc_saldo_cliente` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exisc_saldo_cliente`(cod INT) RETURNS varchar(5) CHARSET latin1
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
END */$$
DELIMITER ;

/* Function  structure for function  `verif_exisc_saldo_proveedor` */

/*!50003 DROP FUNCTION IF EXISTS `verif_exisc_saldo_proveedor` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exisc_saldo_proveedor`(cod INT) RETURNS varchar(5) CHARSET latin1
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
END */$$
DELIMITER ;

/* Function  structure for function  `verif_existencia_nro_comprobante` */

/*!50003 DROP FUNCTION IF EXISTS `verif_existencia_nro_comprobante` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_existencia_nro_comprobante`(sucur VARCHAR(5),seri varchar(5),numer int(10)) RETURNS varchar(5) CHARSET latin1
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
    END */$$
DELIMITER ;

/* Function  structure for function  `verif_existencia_nro_recibo` */

/*!50003 DROP FUNCTION IF EXISTS `verif_existencia_nro_recibo` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_existencia_nro_recibo`(sucur VARCHAR(5),seri VARCHAR(5),numer INT(10)) RETURNS varchar(5) CHARSET latin1
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
    END */$$
DELIMITER ;

/* Function  structure for function  `verif_exist_nro_comp_comp` */

/*!50003 DROP FUNCTION IF EXISTS `verif_exist_nro_comp_comp` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exist_nro_comp_comp`(sucur VARCHAR(5),seri VARCHAR(15),numer INT(10)) RETURNS varchar(5) CHARSET latin1
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
    END */$$
DELIMITER ;

/* Function  structure for function  `verif_exist_nro_rec_comp` */

/*!50003 DROP FUNCTION IF EXISTS `verif_exist_nro_rec_comp` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exist_nro_rec_comp`(sucur VARCHAR(5),seri VARCHAR(7),numer INT(10)) RETURNS varchar(5) CHARSET latin1
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
    END */$$
DELIMITER ;

/* Function  structure for function  `verif_exist_usuario` */

/*!50003 DROP FUNCTION IF EXISTS `verif_exist_usuario` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_exist_usuario`(nom VARCHAR(20),cla VARCHAR(20)) RETURNS varchar(50) CHARSET latin1
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
END */$$
DELIMITER ;

/* Function  structure for function  `verif_nro_doc_pers` */

/*!50003 DROP FUNCTION IF EXISTS `verif_nro_doc_pers` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_nro_doc_pers`(cod VARCHAR(15)) RETURNS varchar(5) CHARSET latin1
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
    END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_acceso` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_acceso` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_acceso`(IN codigo_grupo VARCHAR(10),IN codigo_modulo VARCHAR(10),IN codigo_form VARCHAR(10),IN grupo VARCHAR(10),IN modulo VARCHAR(5),IN formulario VARCHAR(10),IN inserta VARCHAR(1),IN modif VARCHAR(1),IN borrar VARCHAR(1),IN consul VARCHAR(1),IN menu VARCHAR(1))
BEGIN
UPDATE acceso_grupo set cod_grupo=grupo,cod_modulo=modulo,desc_formulario=formulario,puede_insert=inserta,puede_modif=modif,puede_borrar=borrar,puede_consul=consul,mostrar_en_menu=menu where cod_grupo=codigo_grupo and cod_modulo=codigo_modulo and desc_formulario=codigo_form;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_articulo`(IN codigo_old VARCHAR(50),IN un_med_old VARCHAR(5),IN lote_old VARCHAR(100),IN codigo_new VARCHAR(10),IN un_med_new VARCHAR(5),IN lote_new VARCHAR(100),IN desc_art VARCHAR(80),IN proveedor VARCHAR(10),IN marca VARCHAR(10),IN categoria VARCHAR(10),IN pre_compra INT(10),IN pre_venta INT(10),IN cantid INT(10),IN iva VARCHAR(10),IN estad VARCHAR(1),IN mane_stock VARCHAR(1))
BEGIN
UPDATE articulo SET cod_articulo=codigo_new,cod_un_med=un_med_new,nro_lote=lote_new,desc_articulo=desc_art,cod_proveedor=proveedor,cod_marca=marca,cod_categoria=categoria,precio_compra=pre_compra,precio_venta=pre_venta,cantidad=cantid,cod_iva=iva,estado=estad,maneja_stock=mane_stock WHERE cod_articulo=codigo_old and cod_un_med=un_med_old and nro_lote=lote_old;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_categoria` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_categoria` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_categoria`(IN cod_ant VARCHAR(10),IN cod VARCHAR(10),IN desc_cat VARCHAR(50))
BEGIN
UPDATE categoria SET cod_categoria=cod,desc_categoria=desc_cat WHERE cod_categoria=cod_ant;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cliente`(in codigo int(15),IN cod_per int(15),IN cod_mon VARCHAR(5),IN cod_cob VARCHAR(20),IN cod_ven VARCHAR(20),IN limite_cre int(10),IN cod_cond int(10),IN tipo_cli VARCHAR(10),IN est VARCHAR(1),IN comen VARCHAR(80))
BEGIN
UPDATE  cliente SET cod_persona=cod_per,cod_moneda=cod_mon,cod_cobrador=cod_cob,cod_vendedor=cod_ven,limite_credito=limite_cre,cod_condicion_venta=cod_cond,tipo_cliente=tipo_cli,estado=est,comentario=comen where cod_cliente=codigo;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_condicion` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_condicion` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_condicion`(IN codigo int(10),IN cod_cond INT(10),IN descr VARCHAR(80),IN nro_cuota INT(5),IN dia_ini INT(5),IN plaz INT(10),IN est VARCHAR(1))
BEGIN
UPDATE condicion_venta set cod_condicion=cod_cond,descripcion=descr,numero_cuota=nro_cuota,dia_inicial=dia_ini,plazo=plaz,estado=est where cod_condicion=codigo;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_marca` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_marca` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_marca`(IN cod_ant VARCHAR(10),IN cod VARCHAR(10),IN desc_mar VARCHAR(50))
BEGIN
UPDATE marca SET cod_marca=cod,desc_marca=desc_mar WHERE cod_marca=cod_ant;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_persona` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_persona` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_persona`(IN codigo INT(10),IN nombre VARCHAR(80),IN cod_tipo_doc varchar(10),IN ruc_ci VARCHAR(15),IN cod_ciudad INT(10),IN direccion VARCHAR(100),IN direccion_trabajo VARCHAR(100),IN telefono_domicilio VARCHAR(20),IN telefono_trabajo VARCHAR(20),IN celular VARCHAR(15),IN fecha_nacimiento DATE,IN cod_estado_civil VARCHAR (5),IN cod_pais INT(15),in es_ban varchar(1))
BEGIN
UPDATE persona SET nombre=nombre,cod_tipo_doc=cod_tipo_doc,ruc_ci=ruc_ci,cod_ciudad=cod_ciudad,direccion=direccion,direccion_trabajo=direccion_trabajo,telefono_domicilio=telefono_domicilio,telefono_trabajo=telefono_trabajo,celular=celular,fecha_nacimiento=fecha_nacimiento,cod_estado_civil=cod_estado_civil,cod_pais=cod_pais,es_banco=es_ban WHERE cod_persona=codigo;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_proveedor` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_proveedor` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_proveedor`(in cod int(10),IN cod_perso INT(15),in cod_tipo_pr varchar(5),in est varchar(1))
BEGIN
update proveedor set cod_persona=cod_perso,cod_tipo_prov=cod_tipo_pr,estado=est where cod_proveedor=cod;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_serie_comprobante` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_serie_comprobante` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_serie_comprobante`(IN tipo_comp_ant VARCHAR(3),IN ser_comp_ant VARCHAR(2),IN cod_suc_ant VARCHAR(5),IN tipo_comp VARCHAR(3),IN ser_comp VARCHAR(2),IN cod_suc VARCHAR(5),IN nro_inicial INT(15),IN nro_final INT(15),IN ser_timb VARCHAR(30),IN nro_timbrado VARCHAR(30),IN fec_vig VARCHAR(20))
BEGIN
 update serie_comprobante set tipo_comprobante=tipo_comp,ser_comprobante=ser_comp,cod_sucursal=cod_suc,numero_inicial=nro_inicial,numero_final=nro_final,ser_timbrado=ser_timb,numero_timbrado=nro_timbrado,fecha_vigencia=fec_vig where tipo_comprobante=tipo_comp_ant and ser_comprobante=ser_comp_ant and cod_sucursal=cod_suc_ant;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_talonario` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_talonario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_talonario`(IN tipo_tal_ant VARCHAR(3),IN ser_ant VARCHAR(2),IN cod_suc_ant VARCHAR(5),IN tipo_tal VARCHAR(3),IN ser VARCHAR(2),IN cod_suc VARCHAR(5),IN nro_tal INT(10),IN nro_inicial INT(15),IN nro_final INT(15),IN estad VARCHAR(1))
BEGIN
update talonario set tipo_talonario=tipo_tal,serie=ser,cod_sucursal=cod_suc,nro_talonario=nro_tal,numero_inicial=nro_inicial,numero_final=nro_final,estado=estad where tipo_talonario=tipo_tal_ant and serie=ser_ant and cod_sucursal=cod_suc_ant;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_talonario_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_talonario_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_talonario_usuario`(IN tipo_tal_ant VARCHAR(3),IN ser_ant VARCHAR(2),IN cod_suc_ant VARCHAR(5),IN tipo_tal VARCHAR(3),IN ser VARCHAR(2),IN cod_suc VARCHAR(5),IN nro_tal INT(10),IN cod_us VARCHAR(20))
BEGIN
update talonario_usuario set tipo_talonario=tipo_tal,serie=ser,cod_sucursal=cod_suc,nro_talonario=nro_tal,cod_usuario=cod_us where tipo_talonario=tipo_tal_ant and serie=ser_ant and cod_sucursal=cod_suc_ant;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_und_med_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_und_med_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_und_med_articulo`(IN cod_ant VARCHAR(5),IN cod VARCHAR(5),IN desc_un VARCHAR(50))
BEGIN
UPDATE unidad_med_articulo SET cod_un_med=cod,desc_un_med=desc_un WHERE cod_un_med=cod_ant;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualizar_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_usuario`(IN cod varchar(10),IN cod_pers INT(15),IN cod_grup VARCHAR(15),IN cod_suc VARCHAR(15),in estad varchar(1))
BEGIN
UPDATE usuario SET cod_persona=cod_pers,cod_grupo=cod_grup,cod_sucursal=cod_suc,estado=estad WHERE cod_usuario=cod;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualiza_exist_art_borr_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualiza_exist_art_borr_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_compra`(IN art VARCHAR(100),IN un VARCHAR(100),IN lot VARCHAR(100),IN cant INT(5),IN suc VARCHAR(5),IN dep VARCHAR(5))
BEGIN
UPDATE  existencia_articulo
SET cantidad=(cantidad-cant)
WHERE cod_sucursal=suc
AND cod_deposito=dep
AND cod_articulo=art
AND cod_un_medida=un
AND nro_lote=lot
AND tipo_transacc=3
AND sub_tipo_transacc=7;	
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualiza_exist_art_borr_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualiza_exist_art_borr_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_venta`(IN art VARCHAR(100),IN un VARCHAR(100),IN lot VARCHAR(100),IN cant INT(5),IN suc VARCHAR(5),IN dep VARCHAR(5))
BEGIN
UPDATE  existencia_articulo
SET cantidad=(cantidad-cant)
WHERE cod_sucursal=suc
AND cod_deposito=dep
AND cod_articulo=art
AND cod_un_medida=un
AND nro_lote=lot
AND tipo_transacc=4
AND sub_tipo_transacc=10;	
END */$$
DELIMITER ;

/* Procedure structure for procedure `anular_comprob_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `anular_comprob_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `anular_comprob_venta`(IN tipcon VARCHAR(10),IN sercom VARCHAR(50),IN nuncom INT,IN motanu INT)
BEGIN
UPDATE comprobante_cabecera_venta SET estado='A',cod_motivo_anul=motanu WHERE tipo_comprobante=tipcon AND ser_comprobante=sercom AND nro_comprobante=nuncom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `cerrar_caja_cobro` */

/*!50003 DROP PROCEDURE IF EXISTS  `cerrar_caja_cobro` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `cerrar_caja_cobro`(IN nrohab VARCHAR(10),IN codcaj VARCHAR(10),IN codsuc VARCHAR(10),IN codusu VARCHAR(10),IN feccie VARCHAR(20))
BEGIN
UPDATE habilitacion_caja SET fecha_cierre=feccie,estado='C' WHERE nro_habilitacion=nrohab AND cod_caja=codcaj AND cod_sucursal=codsuc AND cod_usuario=codusu;
END */$$
DELIMITER ;

/* Procedure structure for procedure `eliminar_acceso` */

/*!50003 DROP PROCEDURE IF EXISTS  `eliminar_acceso` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_acceso`(IN codigo VARCHAR(10),IN modulo VARCHAR(10),IN form VARCHAR(10))
BEGIN
DELETE FROM acceso_grupo WHERE cod_grupo=codigo and cod_modulo=modulo and desc_formulario=form;
END */$$
DELIMITER ;

/* Procedure structure for procedure `eliminar_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `eliminar_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_articulo`(IN codigo VARCHAR(10),IN cod_un VARCHAR(5),in lote VARCHAR(100))
BEGIN
DELETE FROM articulo WHERE cod_articulo=codigo AND cod_un_med=cod_un and nro_lote=lote;
END */$$
DELIMITER ;

/* Procedure structure for procedure `eliminar_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `eliminar_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente`(IN codigo VARCHAR(10))
BEGIN
DELETE FROM cliente WHERE cod_cliente=codigo;
END */$$
DELIMITER ;

/* Procedure structure for procedure `eliminar_condicion` */

/*!50003 DROP PROCEDURE IF EXISTS  `eliminar_condicion` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_condicion`(IN codigo int(10))
BEGIN
DELETE FROM condicion_venta WHERE cod_condicion=codigo;
END */$$
DELIMITER ;

/* Procedure structure for procedure `eliminar_persona` */

/*!50003 DROP PROCEDURE IF EXISTS  `eliminar_persona` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_persona`(IN codigo Varchar(10))
BEGIN
DELETE FROM persona WHERE cod_persona=codigo;
END */$$
DELIMITER ;

/* Procedure structure for procedure `eliminar_proveedor` */

/*!50003 DROP PROCEDURE IF EXISTS  `eliminar_proveedor` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_proveedor`(in cod int(10))
BEGIN
delete from proveedor  where cod_proveedor=cod;
END */$$
DELIMITER ;

/* Procedure structure for procedure `elimina_comprobante_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `elimina_comprobante_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_comprobante_compra`(tpcom VARCHAR(5),secom VARCHAR(15),nucom INT )
BEGIN
DELETE FROM comprobante_cabecera_compra WHERE cod_tipo_comp=tpcom AND ser_timb_comp=secom AND nro_comprob_comp=nucom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `elimina_comprobante_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `elimina_comprobante_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_comprobante_venta`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM comprobante_cabecera_venta WHERE tipo_comprobante=tpcom AND ser_comprobante=secom AND nro_comprobante=nucom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `elimina_mov_caja_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `elimina_mov_caja_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_mov_caja_compra`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM movimiento_caja_compra WHERE tipo_mov_caja_com=tpcom AND ser_mov_caja_com=secom AND nro_mov_caja_com=nucom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `elimina_mov_caja_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `elimina_mov_caja_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_mov_caja_venta`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM movimiento_caja_venta WHERE tipo_mov_caja=tpcom AND ser_mov_caja=secom AND nro_mov_caja=nucom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `elimina_recibo_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `elimina_recibo_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_recibo_compra`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM recibo_compra_cabecera WHERE tipo_rec_comp=tpcom AND ser_rec_comp=secom AND nro_rec_comp=nucom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `elimina_recibo_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `elimina_recibo_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_recibo_venta`(tpcom VARCHAR(5),secom VARCHAR(5),nucom INT )
BEGIN
DELETE FROM recibo_venta_cabecera WHERE tipo_recibo=tpcom AND ser_recibo=secom AND nro_recibo=nucom;
END */$$
DELIMITER ;

/* Procedure structure for procedure `generar_saldo_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `generar_saldo_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_saldo_cliente`(IN tipo VARCHAR(3),IN ser VARCHAR(2),IN numero INT,in cant_cuo int, in suc varchar(2),IN cliente INT,IN fecha DATE,IN monto INT,IN mon VARCHAR(5),IN saldo INT,us varchar(10))
BEGIN
DECLARE i INT;
DECLARE f DATE;
SET i=1;
WHILE i <= cant_cuo DO
INSERT INTO saldo_cliente(tipo_comprobante,ser_comprobante,nro_comprobante,nro_cuota,cod_sucursal,cod_cliente,fecha_vencimiento,monto_cuota,cod_moneda,saldo_cuota,cod_usuario) VALUES(tipo,ser,numero,i,suc,cliente,ADDDATE(fecha,INTERVAL I MONTH),monto,mon,saldo,us);
SET i = i + 1;
END WHILE;
END */$$
DELIMITER ;

/* Procedure structure for procedure `generar_saldo_proveedor` */

/*!50003 DROP PROCEDURE IF EXISTS  `generar_saldo_proveedor` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_saldo_proveedor`(IN tipo VARCHAR(3),IN ser VARCHAR(15),IN numero INT,IN cant_cuo INT, IN suc VARCHAR(5),IN cliente INT,IN fecha DATE,IN monto INT,IN mon VARCHAR(5),IN saldo INT,us VARCHAR(10))
BEGIN
DECLARE i INT;
DECLARE f DATE;
SET i=1;
/*WHILE i <= cant_cuo DO*/
INSERT INTO saldo_proveedor(tipo_comprobante,ser_comprobante,nro_comprobante,nro_cuota,cod_sucursal,cod_proveedor,fecha_vencimiento,monto_cuota,cod_moneda,saldo_cuota,cod_usuario) VALUES(tipo,ser,numero,1,suc,cliente,ADDDATE(fecha,INTERVAL cant_cuo MONTH),monto,mon,saldo,us);
/*SET i = i + 1;
END WHILE;*/
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_acceso` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_acceso` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_acceso`(IN cod_grupo VARCHAR(10),IN cod_modulo VARCHAR(5),IN desc_formulario VARCHAR(10),IN puede_insert VARCHAR(1),IN puede_modif VARCHAR(1),IN puede_borrar VARCHAR(1),IN puede_consul VARCHAR(1),IN mostrar_en_menu VARCHAR(1))
BEGIN
INSERT INTO acceso_grupo(cod_grupo,cod_modulo,desc_formulario,puede_insert,puede_modif,puede_borrar,puede_consul,mostrar_en_menu) VALUES(cod_grupo,cod_modulo,desc_formulario,puede_insert,puede_modif,puede_borrar,puede_consul,mostrar_en_menu);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_articulo`(IN cod_articulo VARCHAR(10),IN cod_un_med VARCHAR(5),IN nro_lote VARCHAR(100),IN desc_articulo VARCHAR(80),IN cod_proveedor VARCHAR(10),IN cod_marca VARCHAR(10),IN cod_categoria VARCHAR(10),IN precio_compra int(10),IN precio_venta int(10),IN cantidad int(10),IN cod_iva VARCHAR(10),IN estado VARCHAR(1),IN maneja_stock VARCHAR(1))
BEGIN
INSERT INTO articulo(cod_articulo,cod_un_med,nro_lote,desc_articulo,cod_proveedor,cod_marca,cod_categoria,precio_compra,precio_venta,cantidad,cod_iva,estado,maneja_stock) VALUES(cod_articulo,cod_un_med,nro_lote,desc_articulo,cod_proveedor,cod_marca,cod_categoria,precio_compra,precio_venta,cantidad,cod_iva,estado,maneja_stock);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_categoria_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_categoria_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_categoria_articulo`(IN cod_cat VARCHAR(5),IN desc_cat VARCHAR(80))
BEGIN
INSERT INTO categoria(cod_categoria,desc_categoria) VALUES(cod_cat,desc_cat);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cliente`(IN cod_persona int(15),IN cod_moneda VARCHAR(5),IN cod_cobrador VARCHAR(20),IN cod_vendedor VARCHAR(20),IN limite_credito int(10),IN cod_condicion_venta int(10),IN tipo_cliente VARCHAR(10),IN estado VARCHAR(1),IN comentario VARCHAR(80))
BEGIN
INSERT INTO cliente(cod_persona,cod_moneda,cod_cobrador,cod_vendedor,limite_credito,cod_condicion_venta,tipo_cliente,estado,comentario) VALUES(cod_persona,cod_moneda,cod_cobrador,cod_vendedor,limite_credito,cod_condicion_venta,tipo_cliente,estado,comentario);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_compra_cabecera` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_compra_cabecera` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_compra_cabecera`(IN tipo_comp VARCHAR(3),IN ser_timb VARCHAR(15),IN nro_comprob INT(15),in nro_timb varchar(30),IN fecha_comprobante DATE,IN cod_us VARCHAR(10),IN cod_suc VARCHAR(5),IN cod_dep VARCHAR(5),IN cod_proveedor INT(10),IN cod_cond INT(5),in cant_cuo int(5),in fec_inic_comp date,in mont_cuo int(10),IN total_comprobante INT(15),IN total_iva INT(15),IN total_gravada INT(15),IN cod_moneda VARCHAR(5),in ti_camb int(10),IN est VARCHAR(1))
BEGIN
INSERT INTO comprobante_cabecera_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,nro_timbrado,fecha_comprob_comp,cod_usuario,cod_sucursal,cod_deposito,cod_proveedor,cod_cond_comp,cant_cuota,fecha_inic_comp,monto_cuota,total_comprob_comp,iva_comp,gravada,cod_moneda,tipo_cambio,estado) VALUES(tipo_comp,ser_timb,nro_comprob,nro_timb,fecha_comprobante,cod_us,cod_suc,cod_dep,cod_proveedor,cod_cond,cant_cuo,fec_inic_comp,mont_cuo,total_comprobante,total_iva,total_gravada,cod_moneda,ti_camb,est);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_compra_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_compra_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_compra_detalle`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(15),IN nro_comprobante INT(15),IN cod_articulo VARCHAR(100),cod_un varchar(5),lo varchar(100),in desc_articulo varchar(100),IN cantidad INT(10),IN precio_unitario INT(10),IN descuento INT(10),IN importe INT(10),IN total_iva5 INT(10),IN total_iva10 INT(10),IN gravada_5 INT(10),IN gravada_10 INT(10))
BEGIN
INSERT INTO comprobante_detalle_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,cod_producto,cod_un_med,nro_lote,descripcion_prod,cantidad_prod,precio_unitario,descuento,importe,total_iva_5,total_iva_10,gravada_5,gravada_10) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un,lo,desc_articulo,cantidad,precio_unitario,descuento,importe,total_iva5,total_iva10,gravada_5,gravada_10);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_comprobante_cabecera` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_comprobante_cabecera` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comprobante_cabecera`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante int(15),IN cod_sucursal VARCHAR(5),IN cod_depos VARCHAR(5),IN fecha_comprobante date,IN cod_cliente int(10),IN cod_cobrador varchar(10),IN cod_vendedor varchar(10),IN cod_condicion_venta INT(5),IN cod_moneda VARCHAR(5),IN total_comprobante int(15),IN total_gravada int(15),IN total_iva INT(15),IN estado varchar(1),IN cod_usuario varchar(10),IN comentario varchar(50),in monto_cuo int(10))
BEGIN
INSERT INTO comprobante_cabecera_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_deposito,fecha_comprobante,cod_cliente,cod_cobrador,cod_vendedor,cod_condicion_venta,cod_moneda,total_comprobante,total_gravada,total_iva,estado,cod_usuario,comentario,monto_cuota) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_depos,fecha_comprobante,cod_cliente,cod_cobrador,cod_vendedor,cod_condicion_venta,cod_moneda,total_comprobante,total_gravada,total_iva,estado,cod_usuario,comentario,monto_cuo);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_comprobante_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_comprobante_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comprobante_detalle`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante int(15),IN cod_articulo VARCHAR(50),in cod_un_med varchar(5),in nro_lo varchar(100),IN cantidad INT(2),IN precio_unitario int(10),IN descuento INT(10),IN gravada_10 INT(10),IN gravada_5 INT(10),IN importe_total INT(10),IN total_iva10 int(10),IN total_iva5 int(10),IN porcentaje_iva INT(2),IN cod_iva int(2),IN porcentaje_descuento int(2),IN nro_cuota int(2),in descripcion varchar(80))
BEGIN
INSERT INTO comprobante_detalle_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lote,cantidad,precio_unitario,descuento,gravada_10,gravada_5,importe_total,total_iva10,total_iva5,porcentaje_iva,cod_iva,porcentaje_descuento,nro_cuota,descripcion) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lo,cantidad,precio_unitario,descuento,gravada_10,gravada_5,importe_total,total_iva10,total_iva5,porcentaje_iva,cod_iva,porcentaje_descuento,nro_cuota,descripcion);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_condicion_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_condicion_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_condicion_venta`(IN cod_condicion int(10),IN descripcion VARCHAR(80),IN numero_cuota int(5),IN dia_inicial INT(5),IN plazo int(10),IN estado VARCHAR(1))
BEGIN
INSERT INTO condicion_venta(cod_condicion,descripcion,numero_cuota,dia_inicial,plazo,estado) VALUES(cod_condicion,descripcion,numero_cuota,dia_inicial,plazo,estado);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_exist_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_exist_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_exist_articulo`(IN cod_suc VARCHAR(5),IN cod_dep VARCHAR(5),IN cod_art VARCHAR(100),in cod_un varchar(5),in lot varchar(100),in tip_tra int(5),in sub_tip int(5),in cant_art int(5))
BEGIN
INSERT INTO existencia_articulo(cod_sucursal,cod_deposito,cod_articulo,cod_un_medida,nro_lote,tipo_transacc,sub_tipo_transacc,cantidad) VALUES(cod_suc,cod_dep,cod_art,cod_un,lot,tip_tra,sub_tip,cant_art);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_forma_cobro_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_forma_cobro_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_forma_cobro_venta`(IN tipo_mov_cja VARCHAR(3),IN ser_mov_cja VARCHAR(3),IN nro_mov_cja INT(15),IN tipo_tran int(5),IN su_tip_tra int(5),IN cod_pers_juridic INT(10),IN nro_val VARCHAR(30),IN nro_cuen VARCHAR(30),IN mot INT(10))
BEGIN
INSERT INTO forma_cobro_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,tipo_transaccion,sub_tipo_transaccion,cod_persona_juridica,nro_valor,nro_cuenta,monto)VALUES(tipo_mov_cja,ser_mov_cja,nro_mov_cja,tipo_tran,su_tip_tra,cod_pers_juridic,nro_val,nro_cuen,mot);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_forma_pago` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_forma_pago` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_forma_pago`(IN tipo_mov_cja VARCHAR(3),IN ser_mov_cja VARCHAR(3),IN nro_mov_cja INT(15),IN tipo_tran INT(5),IN su_tip_tra INT(5),IN cod_pers_juridic INT(10),IN nro_val VARCHAR(30),IN nro_cuen VARCHAR(30),IN mot INT(10))
BEGIN
INSERT INTO forma_pago_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,tipo_transaccion,sub_tipo_transaccion,cod_persona_juridica,nro_valor,nro_cuenta,monto)VALUES(tipo_mov_cja,ser_mov_cja,nro_mov_cja,tipo_tran,su_tip_tra,cod_pers_juridic,nro_val,nro_cuen,mot);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_hab_caja_ventas` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_hab_caja_ventas` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_hab_caja_ventas`(IN fecha_hab_caj VARCHAR(20),IN saldo_inicial_caj INT(10),IN cod_caja_hab VARCHAR(20),IN cod_sucursal_hab VARCHAR(20),IN cod_usuario_hab VARCHAR(20),IN estado_hab VARCHAR(1))
BEGIN
INSERT INTO habilitacion_caja(fecha_hab,saldo_inicial,cod_caja,cod_sucursal,cod_usuario,estado) VALUES(fecha_hab_caj,saldo_inicial_caj,cod_caja_hab,cod_sucursal_hab,cod_usuario_hab,estado_hab);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_marca_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_marca_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_marca_articulo`(IN cod_mar VARCHAR(5),IN desc_mar VARCHAR(80))
BEGIN
INSERT INTO marca(cod_marca,desc_marca) VALUES(cod_mar,desc_mar);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_caja_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_caja_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_caja_compra`(IN tipo_mov VARCHAR(3),IN ser_mov VARCHAR(3),IN nro_mov INT(10),IN fecha_mov DATE,IN cod_suc VARCHAR(5),IN cod_prov INT(10),IN cod_usu VARCHAR(10),IN total_mov INT(15))
BEGIN
INSERT INTO movimiento_caja_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,fecha_mov_caja_com,cod_sucursal,cod_proveedor,cod_usuario,total_mov_caja_com)VALUES(tipo_mov,ser_mov,nro_mov,fecha_mov,cod_suc,cod_prov,cod_usu,total_mov);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_caja_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_caja_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_caja_venta`(IN tipo_mov_caja VARCHAR(3),IN ser_mov_caja VARCHAR(3),in nro_mov_caja INT(10),IN fecha_mov_caja_venta DATE,IN cod_sucursal VARCHAR(5),IN cod_cliente INT(10),IN cod_usuario VARCHAR(10),IN cod_caja VARCHAR(10),IN numero_hab INT(10),IN total_mov_caja INT(15))
BEGIN
INSERT INTO movimiento_caja_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,fecha_mov_caja_venta,cod_sucursal,cod_cliente,cod_usuario,cod_caja,numero_hab,total_mov_caja)VALUES(tipo_mov_caja,ser_mov_caja,nro_mov_caja,fecha_mov_caja_venta,cod_sucursal,cod_cliente,cod_usuario,cod_caja,numero_hab,total_mov_caja);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_comprobante_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_comprobante_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_comprobante_compra`(IN tipo_mov VARCHAR(3),IN ser_mov VARCHAR(3),IN nro_mov INT(15),IN cod_suc VARCHAR(5),in tipo_trans int(5),in sub_tipo_trans int(5),IN tipo_comprob VARCHAR(3),IN ser_comprob VARCHAR(15),IN nro_comprob INT(10),IN total_comprob INT(10))
BEGIN
INSERT INTO movimiento_comprobante_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,cod_sucursal,tipo_transacc,sub_tipo_transacc,tipo_comprobante_com,ser_comprobante_com,nro_comprobante_com,total_comprobante_com)VALUES(tipo_mov,ser_mov,nro_mov,cod_suc,tipo_trans,sub_tipo_trans,tipo_comprob,ser_comprob,nro_comprob,total_comprob);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_comprobante_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_comprobante_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_comprobante_venta`(IN tipo_mov_caja VARCHAR(3),IN ser_mov_caja VARCHAR(3),IN nro_mov_caja INT(15),IN cod_sucursal VARCHAR(5),IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(3),IN nro_comprobante INT(10),IN total_comprobante INT(10))
BEGIN
INSERT INTO movimiento_comprobante_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,cod_sucursal,tipo_comprobante,ser_comprobante,nro_comprobante,total_comprobante)VALUES(tipo_mov_caja,ser_mov_caja,nro_mov_caja,cod_sucursal,tipo_comprobante,ser_comprobante,nro_comprobante,total_comprobante);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_persona` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_persona` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_persona`(IN nombre varchar(80),in cod_tipo_doc varchar(10),in ruc_ci VARCHAR(15),in cod_ciudad int(10),in direccion VARCHAR(100),in direccion_trabajo VARCHAR(100),in telefono_domicilio VARCHAR(20),in telefono_trabajo VARCHAR(20),in celular VARCHAR(15),in fecha_nacimiento date,in cod_estado_civil varchar (5),in cod_pais integer(10),in es_ban varchar(1))
BEGIN
INSERT INTO persona(nombre,cod_tipo_doc,ruc_ci,cod_ciudad,direccion,direccion_trabajo,telefono_domicilio,telefono_trabajo,celular,fecha_nacimiento,cod_estado_civil,cod_pais,es_banco) VALUES(nombre,cod_tipo_doc,ruc_ci,cod_ciudad,direccion,direccion_trabajo,telefono_domicilio,telefono_trabajo,celular,fecha_nacimiento,cod_estado_civil,cod_pais,es_ban);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_proveedor` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_proveedor` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_proveedor`(IN cod_persona INT(15),in cod_tipo_prov varchar(5),in estado varchar(1))
BEGIN
INSERT INTO proveedor(cod_persona,cod_tipo_prov,estado) VALUES(cod_persona,cod_tipo_prov,estado);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_recibo_compra_cabecera` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_recibo_compra_cabecera` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_compra_cabecera`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(7),IN nro_recibo INT(15),IN cod_sucursal VARCHAR(5),IN fecha_recibo DATE,IN cod_prov INT(10),IN cod_moneda VARCHAR(5),IN cod_usuario VARCHAR(10),IN estado VARCHAR(1),IN total_recibo INT(15),IN comentario VARCHAR(50))
BEGIN
INSERT INTO recibo_compra_cabecera(tipo_rec_comp,ser_rec_comp,nro_rec_comp,cod_sucursal,fecha_rec_comp,cod_proveedor,cod_moneda,cod_usuario,estado,total_rec_comp,comentario) VALUES(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_prov,cod_moneda,cod_usuario,estado,total_recibo,comentario);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_recibo_compra_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_recibo_compra_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_compra_detalle`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(7),IN nro_recibo INT(15),IN tipo_transaccion INT(5),IN sub_tipo_transac INT(5),IN tipo_comprobante_ref VARCHAR(3),IN ser_comprobante_ref VARCHAR(7),IN nro_comprobante_ref INT(15),IN nro_cuota INT(5),IN fecha_vencimiento DATE,IN monto_cuota INT(15),IN importe_total INT(15))
BEGIN
INSERT INTO recibo_detalle_compra(`tipo_rec_comp`,`ser_rec_comp`,`nro_rec_comp`,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total) VALUES(tipo_recibo,ser_recibo,nro_recibo,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_recibo_venta_cabecera` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_recibo_venta_cabecera` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_venta_cabecera`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(2),IN nro_recibo INT(15),IN cod_sucursal VARCHAR(5),IN fecha_recibo DATE,IN cod_cliente INT(10),IN cod_cobrador VARCHAR(10),IN cod_moneda VARCHAR(5),IN cod_usuario VARCHAR(10),IN estado VARCHAR(1),IN total_recibo INT(15),IN comentario VARCHAR(50))
BEGIN
INSERT INTO recibo_venta_cabecera(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_cliente,cod_cobrador,cod_moneda,cod_usuario,estado,total_recibo,comentario) VALUES(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_cliente,cod_cobrador,cod_moneda,cod_usuario,estado,total_recibo,comentario);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_recibo_venta_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_recibo_venta_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_venta_detalle`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(2),IN nro_recibo INT(15),IN tipo_transaccion INT(5),IN sub_tipo_transac INT(5),IN tipo_comprobante_ref VARCHAR(3),IN ser_comprobante_ref VARCHAR(2),IN nro_comprobante_ref INT(15),IN nro_cuota INT(5),IN fecha_vencimiento date,IN monto_cuota INT(15),IN importe_total INT(15))
BEGIN
INSERT INTO recibo_detalle_venta(tipo_recibo,ser_recibo,nro_recibo,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total) VALUES(tipo_recibo,ser_recibo,nro_recibo,tipo_transaccion,sub_tipo_transac,tipo_comprobante_ref,ser_comprobante_ref,nro_comprobante_ref,nro_cuota,fecha_vencimiento,monto_cuota,importe_total);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_serie_comprobante` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_serie_comprobante` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_serie_comprobante`(IN tipo_comp VARCHAR(3),IN ser_comp VARCHAR(2),IN cod_suc VARCHAR(5),IN nro_inicial int(15),IN nro_final int(15),IN ser_timb VARCHAR(30),IN nro_timbrado VARCHAR(30),IN fec_vig VARCHAR(20))
BEGIN
INSERT INTO serie_comprobante(tipo_comprobante,ser_comprobante,cod_sucursal,numero_inicial,numero_final,ser_timbrado,numero_timbrado,fecha_vigencia) VALUES(tipo_comp,ser_comp,cod_suc,nro_inicial,nro_final,ser_timb,nro_timbrado,fec_vig);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_talonario` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_talonario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_talonario`(IN tipo_tal VARCHAR(3),IN ser VARCHAR(2),IN cod_suc VARCHAR(5),in nro_tal int(10),IN nro_inicial int(15),IN nro_final int(15),IN estad VARCHAR(1))
BEGIN
INSERT INTO talonario(tipo_talonario,serie,cod_sucursal,nro_talonario,numero_inicial,numero_final,estado) VALUES(tipo_tal,ser,cod_suc,nro_tal,nro_inicial,nro_final,estad);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_talonario_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_talonario_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_talonario_usuario`(IN tipo_tal VARCHAR(3),IN ser VARCHAR(2),IN cod_suc VARCHAR(5),in nro_tal int(10),IN cod_us varchar(20))
BEGIN
INSERT INTO talonario_usuario(tipo_talonario,serie,cod_sucursal,nro_talonario,cod_usuario) VALUES(tipo_tal,ser,cod_suc,nro_tal,cod_us);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_und_med_articulo` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_und_med_articulo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_und_med_articulo`(IN cod_un VARCHAR(5),IN desc_un VARCHAR(100))
BEGIN
INSERT INTO unidad_med_articulo(cod_un_med,desc_un_med) VALUES(cod_un,desc_un);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_usuario`(IN cod_usuario VARCHAR(10),IN clave_usuario VARCHAR(20),IN cod_persona INT(15),IN cod_grupo VARCHAR(15),IN cod_sucursal VARCHAR(5),IN estado VARCHAR(1))
BEGIN
INSERT INTO usuario(cod_usuario,clave_usuario,cod_persona,cod_grupo,cod_sucursal,estado) VALUES(cod_usuario,clave_usuario,cod_persona,cod_grupo,cod_sucursal,estado);
END */$$
DELIMITER ;

/*Table structure for table `view_articulo` */

DROP TABLE IF EXISTS `view_articulo`;

/*!50001 DROP VIEW IF EXISTS `view_articulo` */;
/*!50001 DROP TABLE IF EXISTS `view_articulo` */;

/*!50001 CREATE TABLE  `view_articulo`(
 `cod_articulo` varchar(100) ,
 `unidad_med` varchar(100) ,
 `nro_lote` varchar(100) ,
 `desc_articulo` varchar(100) ,
 `cod_proveedor` int(10) ,
 `nombre_prov` varchar(80) ,
 `razon_social` varchar(80) ,
 `cod_marca` varchar(10) ,
 `desc_marca` varchar(80) ,
 `cod_categoria` varchar(10) ,
 `desc_categoria` varchar(80) ,
 `precio_compra` int(10) ,
 `precio_venta` int(10) ,
 `cantidad` int(10) ,
 `cod_iva` varchar(10) ,
 `desc_iva` varchar(50) ,
 `estado` varchar(8) ,
 `man_stock` varchar(2) 
)*/;

/*Table structure for table `view_cliente` */

DROP TABLE IF EXISTS `view_cliente`;

/*!50001 DROP VIEW IF EXISTS `view_cliente` */;
/*!50001 DROP TABLE IF EXISTS `view_cliente` */;

/*!50001 CREATE TABLE  `view_cliente`(
 `cod_cliente` int(15) ,
 `cod_persona` int(15) ,
 `nombre` varchar(80) ,
 `cod_moneda` varchar(5) ,
 `desc_moneda` varchar(50) ,
 `cod_cobrador` varchar(20) ,
 `cobrador` varchar(80) ,
 `cod_vendedor` varchar(20) ,
 `vendedor` varchar(80) ,
 `limite_credito` varchar(11) ,
 `cod_condicion_venta` varchar(11) ,
 `condicion` varchar(80) ,
 `cod_tipo_clien` varchar(10) ,
 `tipo_cliente` varchar(80) ,
 `estado` varchar(8) ,
 `comentario` varchar(80) ,
 `ruc_ci` varchar(20) 
)*/;

/*Table structure for table `view_comprob_compra_cab_det` */

DROP TABLE IF EXISTS `view_comprob_compra_cab_det`;

/*!50001 DROP VIEW IF EXISTS `view_comprob_compra_cab_det` */;
/*!50001 DROP TABLE IF EXISTS `view_comprob_compra_cab_det` */;

/*!50001 CREATE TABLE  `view_comprob_compra_cab_det`(
 `tipo_comp` varchar(10) ,
 `tipo_comprobante` varchar(15) ,
 `serie_comp` varchar(30) ,
 `nro_comp` int(10) ,
 `nro_timbrado_comp` varchar(30) ,
 `fecha_comprob` varchar(10) ,
 `cod_usuario` varchar(10) ,
 `nomb_usuario` varchar(80) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `cod_deposito` varchar(5) ,
 `desc_deposito` varchar(80) ,
 `cod_proveedor` int(10) ,
 `nomb_proveedor` varchar(80) ,
 `cond_comp` int(5) ,
 `descripcion` varchar(80) ,
 `cant_cuota` int(10) ,
 `fecha_inic_comp` varchar(10) ,
 `monto_cuota` int(11) ,
 `total_comp` int(11) ,
 `total_iva_comp` int(11) ,
 `total_grav_comp` int(11) ,
 `cod_moneda` varchar(5) ,
 `desc_moneda` varchar(50) ,
 `tipo_cambio` int(10) ,
 `estado` varchar(1) ,
 `cod_articulo` varchar(100) ,
 `unidad_med` varchar(100) ,
 `nro_lote` varchar(100) ,
 `desc_articulo` varchar(100) ,
 `cant_articulo` int(11) ,
 `precio_unitario` int(11) ,
 `descuento` int(11) ,
 `importe` int(11) ,
 `iva5` int(11) ,
 `iva10` int(11) ,
 `gravada5` int(11) ,
 `gravada10` int(11) 
)*/;

/*Table structure for table `view_comprob_venta_cab_det` */

DROP TABLE IF EXISTS `view_comprob_venta_cab_det`;

/*!50001 DROP VIEW IF EXISTS `view_comprob_venta_cab_det` */;
/*!50001 DROP TABLE IF EXISTS `view_comprob_venta_cab_det` */;

/*!50001 CREATE TABLE  `view_comprob_venta_cab_det`(
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `tipo_comprobante` varchar(15) ,
 `ser_comprobante` varchar(5) ,
 `nro_comprobante` int(15) ,
 `fecha_comprobante` varchar(10) ,
 `cod_cliente` int(10) ,
 `nombre_cliente` varchar(80) ,
 `cod_cobrador` varchar(10) ,
 `nombre_cobrador` varchar(80) ,
 `cod_vendedor` varchar(10) ,
 `nombre_vendedor` varchar(80) ,
 `cod_condicion_venta` int(10) ,
 `descripcion` varchar(80) ,
 `cod_moneda` varchar(5) ,
 `desc_moneda` varchar(50) ,
 `cod_articulo` varchar(50) ,
 `cod_un_med` varchar(100) ,
 `nro_lote` varchar(100) ,
 `cantidad` int(10) ,
 `desc_articulo` varchar(100) ,
 `precio_unitario` int(10) ,
 `importe_total` int(10) ,
 `total_iva5` int(10) ,
 `total_iva10` int(10) ,
 `gravada_5` int(10) ,
 `gravada_10` int(10) ,
 `total_gravada` int(15) ,
 `total_iva` int(11) ,
 `total_comprobante` int(15) ,
 `cod_deposito` varchar(5) ,
 `desc_deposito` varchar(80) ,
 `estado` varchar(1) ,
 `tip_comp` varchar(5) ,
 `fec_comp` date 
)*/;

/*Table structure for table `view_existencia_articulo` */

DROP TABLE IF EXISTS `view_existencia_articulo`;

/*!50001 DROP VIEW IF EXISTS `view_existencia_articulo` */;
/*!50001 DROP TABLE IF EXISTS `view_existencia_articulo` */;

/*!50001 CREATE TABLE  `view_existencia_articulo`(
 `cod_sucursal` varchar(10) ,
 `desc_sucursal` varchar(50) ,
 `cod_deposito` varchar(10) ,
 `desc_deposito` varchar(80) ,
 `cod_articulo` varchar(100) ,
 `cod_un_medida` varchar(5) ,
 `nro_lote` varchar(100) ,
 `desc_articulo` varchar(100) ,
 `existencia` decimal(42,0) 
)*/;

/*Table structure for table `view_grupo_usuario` */

DROP TABLE IF EXISTS `view_grupo_usuario`;

/*!50001 DROP VIEW IF EXISTS `view_grupo_usuario` */;
/*!50001 DROP TABLE IF EXISTS `view_grupo_usuario` */;

/*!50001 CREATE TABLE  `view_grupo_usuario`(
 `cod_grupo` varchar(15) ,
 `desc_grupo` varchar(50) ,
 `cod_modulo` varchar(5) ,
 `desc_modulo` varchar(50) ,
 `desc_formulario` varchar(10) ,
 `menu` varchar(2) ,
 `borrar` varchar(2) ,
 `consultar` varchar(2) ,
 `insertar` varchar(2) ,
 `modificar` varchar(2) 
)*/;

/*Table structure for table `view_mov_caja_compra` */

DROP TABLE IF EXISTS `view_mov_caja_compra`;

/*!50001 DROP VIEW IF EXISTS `view_mov_caja_compra` */;
/*!50001 DROP TABLE IF EXISTS `view_mov_caja_compra` */;

/*!50001 CREATE TABLE  `view_mov_caja_compra`(
 `tipo_mov_comp` varchar(5) ,
 `ser_mov_comp` varchar(5) ,
 `nro_mov_comp` int(10) ,
 `fecha_mov_comp` varchar(10) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `cod_proveedor` int(11) ,
 `nomb_proveedor` varchar(80) ,
 `cod_usuario` varchar(15) ,
 `nomb_usuario` varchar(80) ,
 `total_mov_comp` int(11) 
)*/;

/*Table structure for table `view_mov_caja_venta` */

DROP TABLE IF EXISTS `view_mov_caja_venta`;

/*!50001 DROP VIEW IF EXISTS `view_mov_caja_venta` */;
/*!50001 DROP TABLE IF EXISTS `view_mov_caja_venta` */;

/*!50001 CREATE TABLE  `view_mov_caja_venta`(
 `tipo_mov_caja` varchar(5) ,
 `ser_mov_caja` varchar(5) ,
 `nro_mov_caja` int(10) ,
 `fecha_mov_caja_venta` varchar(10) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `cod_cliente` int(11) ,
 `nomb_cliente` varchar(80) ,
 `cod_usuario` varchar(15) ,
 `nomb_usuario` varchar(80) ,
 `cod_caja` varchar(5) ,
 `desc_caja` varchar(50) ,
 `numero_hab` int(11) ,
 `total_mov_caja` int(11) 
)*/;

/*Table structure for table `view_persona` */

DROP TABLE IF EXISTS `view_persona`;

/*!50001 DROP VIEW IF EXISTS `view_persona` */;
/*!50001 DROP TABLE IF EXISTS `view_persona` */;

/*!50001 CREATE TABLE  `view_persona`(
 `cod_persona` int(15) ,
 `nombre` varchar(80) ,
 `cod_tipo_doc` varchar(10) ,
 `Desc_tipo_doc` varchar(50) ,
 `ruc_ci` varchar(20) ,
 `cod_ciudad` varchar(11) ,
 `desc_ciudad` varchar(50) ,
 `direccion` varchar(100) ,
 `direccion_trabajo` varchar(100) ,
 `telefono_domicilio` varchar(50) ,
 `telefono_trabajo` varchar(50) ,
 `celular` varchar(50) ,
 `fecha_nacimiento` varchar(10) ,
 `cod_estado_civil` varchar(5) ,
 `desc_estado_civil` varchar(50) ,
 `cod_pais` varchar(11) ,
 `desc_pais` varchar(50) ,
 `es_banco` varchar(1) 
)*/;

/*Table structure for table `view_recibo_compra` */

DROP TABLE IF EXISTS `view_recibo_compra`;

/*!50001 DROP VIEW IF EXISTS `view_recibo_compra` */;
/*!50001 DROP TABLE IF EXISTS `view_recibo_compra` */;

/*!50001 CREATE TABLE  `view_recibo_compra`(
 `cod_usuario` varchar(10) ,
 `nomb_usuario` varchar(80) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `tipo_recibo` varchar(3) ,
 `ser_recibo` varchar(7) ,
 `nro_recibo` int(10) ,
 `fecha_recibo` varchar(10) ,
 `cod_proveedor` int(10) ,
 `nomb_cliente` varchar(80) ,
 `cod_moneda` varchar(3) ,
 `desc_moneda` varchar(50) ,
 `total_recibo` int(10) ,
 `comentario` varchar(80) ,
 `tipo_transaccion` int(5) ,
 `sub_tipo_transac` int(5) ,
 `tipo_comprobante_ref` varchar(3) ,
 `ser_comprobante_ref` varchar(7) ,
 `nro_comprobante_ref` int(10) ,
 `nro_cuota` int(5) ,
 `fecha_vencimiento` date ,
 `monto_cuota` int(10) ,
 `importe_total` int(10) 
)*/;

/*Table structure for table `view_recibo_venta` */

DROP TABLE IF EXISTS `view_recibo_venta`;

/*!50001 DROP VIEW IF EXISTS `view_recibo_venta` */;
/*!50001 DROP TABLE IF EXISTS `view_recibo_venta` */;

/*!50001 CREATE TABLE  `view_recibo_venta`(
 `cod_usuario` varchar(10) ,
 `nomb_usuario` varchar(80) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `tipo_recibo` varchar(3) ,
 `ser_recibo` varchar(3) ,
 `nro_recibo` int(10) ,
 `fecha_recibo` varchar(10) ,
 `cod_cliente` int(10) ,
 `nomb_cliente` varchar(80) ,
 `cod_cobrador` varchar(3) ,
 `nomb_cobrador` varchar(80) ,
 `cod_moneda` varchar(3) ,
 `desc_moneda` varchar(50) ,
 `total_recibo` int(10) ,
 `comentario` varchar(80) ,
 `tipo_transaccion` int(5) ,
 `sub_tipo_transac` int(5) ,
 `tipo_comprobante_ref` varchar(3) ,
 `ser_comprobante_ref` varchar(3) ,
 `nro_comprobante_ref` int(10) ,
 `nro_cuota` int(5) ,
 `fecha_vencimiento` date ,
 `monto_cuota` int(10) ,
 `importe_total` int(10) 
)*/;

/*Table structure for table `view_saldo_cliente` */

DROP TABLE IF EXISTS `view_saldo_cliente`;

/*!50001 DROP VIEW IF EXISTS `view_saldo_cliente` */;
/*!50001 DROP TABLE IF EXISTS `view_saldo_cliente` */;

/*!50001 CREATE TABLE  `view_saldo_cliente`(
 `tipo_comprobante` varchar(3) ,
 `ser_comprobante` varchar(3) ,
 `nro_comprobante` int(10) ,
 `cod_cliente` int(10) ,
 `nombre` varchar(80) ,
 `nro_cuota` int(5) ,
 `fec_venc` date ,
 `fecha_vencimiento` varchar(10) ,
 `saldo_cuota` int(10) 
)*/;

/*Table structure for table `view_saldo_proveedor` */

DROP TABLE IF EXISTS `view_saldo_proveedor`;

/*!50001 DROP VIEW IF EXISTS `view_saldo_proveedor` */;
/*!50001 DROP TABLE IF EXISTS `view_saldo_proveedor` */;

/*!50001 CREATE TABLE  `view_saldo_proveedor`(
 `tipo_comprobante` varchar(3) ,
 `ser_comprobante` varchar(15) ,
 `nro_comprobante` int(10) ,
 `cod_proveedor` int(10) ,
 `nombre` varchar(80) ,
 `nro_cuota` int(5) ,
 `fec_venc` date ,
 `fecha_vencimiento` varchar(10) ,
 `saldo_cuota` int(10) ,
 `monto_cuota` int(10) 
)*/;

/*Table structure for table `view_serie_comprobante` */

DROP TABLE IF EXISTS `view_serie_comprobante`;

/*!50001 DROP VIEW IF EXISTS `view_serie_comprobante` */;
/*!50001 DROP TABLE IF EXISTS `view_serie_comprobante` */;

/*!50001 CREATE TABLE  `view_serie_comprobante`(
 `tipo_comprobante` varchar(3) ,
 `desc_comp` varchar(30) ,
 `ser_comprobante` varchar(2) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `numero_inicial` int(15) ,
 `numero_final` int(15) ,
 `ser_timbrado` varchar(30) ,
 `numero_timbrado` varchar(30) ,
 `fecha_vigencia` varchar(10) 
)*/;

/*Table structure for table `view_talonario_comprobante` */

DROP TABLE IF EXISTS `view_talonario_comprobante`;

/*!50001 DROP VIEW IF EXISTS `view_talonario_comprobante` */;
/*!50001 DROP TABLE IF EXISTS `view_talonario_comprobante` */;

/*!50001 CREATE TABLE  `view_talonario_comprobante`(
 `tipo_talonario` varchar(3) ,
 `desc_talonario` varchar(30) ,
 `serie` varchar(2) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `nro_talonario` int(5) ,
 `numero_inicial` int(15) ,
 `numero_final` int(15) ,
 `estado` varchar(1) ,
 `desc_estado` varchar(8) 
)*/;

/*Table structure for table `view_talonario_usuario` */

DROP TABLE IF EXISTS `view_talonario_usuario`;

/*!50001 DROP VIEW IF EXISTS `view_talonario_usuario` */;
/*!50001 DROP TABLE IF EXISTS `view_talonario_usuario` */;

/*!50001 CREATE TABLE  `view_talonario_usuario`(
 `tipo_talonario` varchar(3) ,
 `desc_talonario` varchar(30) ,
 `serie` varchar(2) ,
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `nro_talonario` int(5) ,
 `cod_usuario` varchar(20) ,
 `nombre` varchar(80) 
)*/;

/*Table structure for table `view_usuarios` */

DROP TABLE IF EXISTS `view_usuarios`;

/*!50001 DROP VIEW IF EXISTS `view_usuarios` */;
/*!50001 DROP TABLE IF EXISTS `view_usuarios` */;

/*!50001 CREATE TABLE  `view_usuarios`(
 `COD_USUARIO` varchar(10) ,
 `COD_PERSONA` int(15) ,
 `NOMBRE_USUARIO` varchar(80) ,
 `COD_GRUPO` varchar(15) ,
 `DESC_GRUPO` varchar(50) ,
 `COD_SUCURSAL` varchar(15) ,
 `DESC_SUCURSAL` varchar(50) ,
 `ESTADO` varchar(1) ,
 `desc_estado` varchar(8) 
)*/;

/*View structure for view view_articulo */

/*!50001 DROP TABLE IF EXISTS `view_articulo` */;
/*!50001 DROP VIEW IF EXISTS `view_articulo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_articulo` AS (select `a`.`cod_articulo` AS `cod_articulo`,`un`.`desc_un_med` AS `unidad_med`,`a`.`nro_lote` AS `nro_lote`,`a`.`desc_articulo` AS `desc_articulo`,`a`.`cod_proveedor` AS `cod_proveedor`,`ps`.`nombre` AS `nombre_prov`,`p`.`razon_social` AS `razon_social`,`a`.`cod_marca` AS `cod_marca`,`m`.`desc_marca` AS `desc_marca`,`a`.`cod_categoria` AS `cod_categoria`,`c`.`desc_categoria` AS `desc_categoria`,`a`.`precio_compra` AS `precio_compra`,`a`.`precio_venta` AS `precio_venta`,`a`.`cantidad` AS `cantidad`,`a`.`cod_iva` AS `cod_iva`,`i`.`desc_iva` AS `desc_iva`,(case when (`a`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `estado`,(case when (`a`.`maneja_stock` = 'S') then 'SI' else 'NO' end) AS `man_stock` from ((((((`articulo` `a` left join `proveedor` `p` on((`a`.`cod_proveedor` = `p`.`cod_proveedor`))) left join `persona` `ps` on((`p`.`cod_persona` = `ps`.`cod_persona`))) left join `marca` `m` on((`a`.`cod_marca` = `m`.`cod_marca`))) left join `categoria` `c` on((`a`.`cod_categoria` = `c`.`cod_categoria`))) left join `iva` `i` on((`a`.`cod_iva` = `i`.`cod_iva`))) left join `unidad_med_articulo` `un` on((`un`.`cod_un_med` = `a`.`cod_un_med`)))) */;

/*View structure for view view_cliente */

/*!50001 DROP TABLE IF EXISTS `view_cliente` */;
/*!50001 DROP VIEW IF EXISTS `view_cliente` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_cliente` AS (select `c`.`cod_cliente` AS `cod_cliente`,`c`.`cod_persona` AS `cod_persona`,`p`.`nombre` AS `nombre`,`c`.`cod_moneda` AS `cod_moneda`,`m`.`desc_moneda` AS `desc_moneda`,`c`.`cod_cobrador` AS `cod_cobrador`,`pc`.`nombre` AS `cobrador`,`c`.`cod_vendedor` AS `cod_vendedor`,`pv`.`nombre` AS `vendedor`,ifnull(`c`.`limite_credito`,'') AS `limite_credito`,ifnull(`c`.`cod_condicion_venta`,'') AS `cod_condicion_venta`,`cv`.`descripcion` AS `condicion`,`c`.`tipo_cliente` AS `cod_tipo_clien`,`tc`.`descripcion` AS `tipo_cliente`,(case when (`c`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `estado`,`c`.`comentario` AS `comentario`,`p`.`ruc_ci` AS `ruc_ci` from ((((((((`cliente` `c` left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) left join `moneda` `m` on((`c`.`cod_moneda` = `m`.`cod_moneda`))) left join `cobrador` `cb` on((`c`.`cod_cobrador` = `cb`.`cod_cobrador`))) left join `persona` `pc` on((`cb`.`cod_persona` = `pc`.`cod_persona`))) left join `vendedor` `v` on((`c`.`cod_vendedor` = `v`.`cod_vendedor`))) left join `persona` `pv` on((`v`.`cod_persona` = `pv`.`cod_persona`))) left join `condicion_venta` `cv` on((`c`.`cod_condicion_venta` = `cv`.`cod_condicion`))) left join `tipo_cliente` `tc` on((`c`.`tipo_cliente` = `tc`.`cod_tipo_cliente`)))) */;

/*View structure for view view_comprob_compra_cab_det */

/*!50001 DROP TABLE IF EXISTS `view_comprob_compra_cab_det` */;
/*!50001 DROP VIEW IF EXISTS `view_comprob_compra_cab_det` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_comprob_compra_cab_det` AS (select `c`.`cod_tipo_comp` AS `tipo_comp`,(case when (`c`.`cod_tipo_comp` = 'FCO') then 'FACTURA CONTADO' else 'FACTURA CREDITO' end) AS `tipo_comprobante`,`c`.`ser_timb_comp` AS `serie_comp`,`c`.`nro_comprob_comp` AS `nro_comp`,`c`.`nro_timbrado` AS `nro_timbrado_comp`,date_format(`c`.`fecha_comprob_comp`,'%d/%m/%Y') AS `fecha_comprob`,`c`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`c`.`cod_sucursal` AS `cod_sucursal`,`s`.`desc_sucursal` AS `desc_sucursal`,`c`.`cod_deposito` AS `cod_deposito`,`da`.`desc_deposito` AS `desc_deposito`,`c`.`cod_proveedor` AS `cod_proveedor`,`pp`.`nombre` AS `nomb_proveedor`,`c`.`cod_cond_comp` AS `cond_comp`,`cv`.`descripcion` AS `descripcion`,`c`.`cant_cuota` AS `cant_cuota`,date_format(`c`.`fecha_inic_comp`,'%d/%m/%Y') AS `fecha_inic_comp`,`c`.`monto_cuota` AS `monto_cuota`,`c`.`total_comprob_comp` AS `total_comp`,`c`.`iva_comp` AS `total_iva_comp`,`c`.`gravada` AS `total_grav_comp`,`c`.`cod_moneda` AS `cod_moneda`,`mo`.`desc_moneda` AS `desc_moneda`,`c`.`tipo_cambio` AS `tipo_cambio`,`c`.`estado` AS `estado`,`d`.`cod_producto` AS `cod_articulo`,`d`.`cod_un_med` AS `unidad_med`,`d`.`nro_lote` AS `nro_lote`,`d`.`descripcion_prod` AS `desc_articulo`,`d`.`cantidad_prod` AS `cant_articulo`,`d`.`precio_unitario` AS `precio_unitario`,`d`.`descuento` AS `descuento`,`d`.`importe` AS `importe`,`d`.`total_iva_5` AS `iva5`,`d`.`total_iva_10` AS `iva10`,`d`.`gravada_5` AS `gravada5`,`d`.`gravada_10` AS `gravada10` from (((((((((`comprobante_cabecera_compra` `c` left join `comprobante_detalle_compra` `d` on(((`c`.`cod_tipo_comp` = `d`.`cod_tipo_comp`) and (`c`.`ser_timb_comp` = `d`.`ser_timb_comp`) and (`c`.`nro_comprob_comp` = `d`.`nro_comprob_comp`)))) left join `usuario` `u` on((`c`.`cod_usuario` = `u`.`cod_usuario`))) left join `persona` `pu` on((`u`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `s` on((`c`.`cod_sucursal` = `s`.`cod_sucursal`))) left join `deposito_articulo` `da` on((`c`.`cod_deposito` = `da`.`cod_deposito`))) left join `proveedor` `pr` on((`c`.`cod_proveedor` = `pr`.`cod_proveedor`))) left join `persona` `pp` on((`pr`.`cod_persona` = `pp`.`cod_persona`))) left join `condicion_venta` `cv` on((`c`.`cod_cond_comp` = `cv`.`cod_condicion`))) left join `moneda` `mo` on((`c`.`cod_moneda` = `mo`.`cod_moneda`)))) */;

/*View structure for view view_comprob_venta_cab_det */

/*!50001 DROP TABLE IF EXISTS `view_comprob_venta_cab_det` */;
/*!50001 DROP VIEW IF EXISTS `view_comprob_venta_cab_det` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_comprob_venta_cab_det` AS (select `com`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,(case when (`com`.`tipo_comprobante` = 'FCO') then 'FACTURA CONTADO' else 'FACTURA CREDITO' end) AS `tipo_comprobante`,`com`.`ser_comprobante` AS `ser_comprobante`,`com`.`nro_comprobante` AS `nro_comprobante`,date_format(`com`.`fecha_comprobante`,'%d/%m/%Y') AS `fecha_comprobante`,`com`.`cod_cliente` AS `cod_cliente`,`per`.`nombre` AS `nombre_cliente`,`com`.`cod_cobrador` AS `cod_cobrador`,`pco`.`nombre` AS `nombre_cobrador`,`com`.`cod_vendedor` AS `cod_vendedor`,`pve`.`nombre` AS `nombre_vendedor`,`com`.`cod_condicion_venta` AS `cod_condicion_venta`,`con`.`descripcion` AS `descripcion`,`com`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`dco`.`cod_articulo` AS `cod_articulo`,`dco`.`cod_un_med` AS `cod_un_med`,`dco`.`nro_lote` AS `nro_lote`,`dco`.`cantidad` AS `cantidad`,`art`.`desc_articulo` AS `desc_articulo`,`dco`.`precio_unitario` AS `precio_unitario`,`dco`.`importe_total` AS `importe_total`,`dco`.`total_iva5` AS `total_iva5`,`dco`.`total_iva10` AS `total_iva10`,`dco`.`gravada_5` AS `gravada_5`,`dco`.`gravada_10` AS `gravada_10`,`com`.`total_gravada` AS `total_gravada`,`com`.`total_iva` AS `total_iva`,`com`.`total_comprobante` AS `total_comprobante`,`com`.`cod_deposito` AS `cod_deposito`,`dep`.`desc_deposito` AS `desc_deposito`,`com`.`estado` AS `estado`,`com`.`tipo_comprobante` AS `tip_comp`,`com`.`fecha_comprobante` AS `fec_comp` from ((((((((((((`comprobante_cabecera_venta` `com` left join `comprobante_detalle_venta` `dco` on(((`com`.`tipo_comprobante` = `dco`.`tipo_comprobante`) and (`com`.`ser_comprobante` = `dco`.`ser_comprobante`) and (`com`.`nro_comprobante` = `dco`.`nro_comprobante`)))) left join `articulo` `art` on(((`dco`.`cod_articulo` = `art`.`cod_articulo`) and (`dco`.`cod_un_med` = `art`.`cod_un_med`) and (`dco`.`nro_lote` = `art`.`nro_lote`)))) left join `cliente` `cli` on((`com`.`cod_cliente` = `cli`.`cod_cliente`))) left join `persona` `per` on((`cli`.`cod_persona` = `per`.`cod_persona`))) left join `sucursal` `suc` on((`com`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `deposito_articulo` `dep` on((`com`.`cod_deposito` = `dep`.`cod_deposito`))) left join `cobrador` `cob` on((`com`.`cod_cobrador` = `cob`.`cod_cobrador`))) left join `persona` `pco` on((`cob`.`cod_persona` = `pco`.`cod_persona`))) left join `vendedor` `ven` on((`com`.`cod_vendedor` = `ven`.`cod_vendedor`))) left join `persona` `pve` on((`ven`.`cod_persona` = `pve`.`cod_persona`))) left join `condicion_venta` `con` on((`com`.`cod_condicion_venta` = `con`.`cod_condicion`))) left join `moneda` `mon` on((`cli`.`cod_moneda` = `mon`.`cod_moneda`)))) */;

/*View structure for view view_existencia_articulo */

/*!50001 DROP TABLE IF EXISTS `view_existencia_articulo` */;
/*!50001 DROP VIEW IF EXISTS `view_existencia_articulo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_existencia_articulo` AS (select `e`.`cod_sucursal` AS `cod_sucursal`,`e`.`desc_sucursal` AS `desc_sucursal`,`e`.`cod_deposito` AS `cod_deposito`,`e`.`desc_deposito` AS `desc_deposito`,`e`.`cod_articulo` AS `cod_articulo`,`e`.`cod_un_medida` AS `cod_un_medida`,`e`.`nro_lote` AS `nro_lote`,`e`.`desc_articulo` AS `desc_articulo`,(sum(`e`.`cant_compra`) - sum(`e`.`cant_venta`)) AS `existencia` from (select `exi`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`exi`.`cod_deposito` AS `cod_deposito`,`dar`.`desc_deposito` AS `desc_deposito`,`exi`.`cod_articulo` AS `cod_articulo`,`exi`.`cod_un_medida` AS `cod_un_medida`,`exi`.`nro_lote` AS `nro_lote`,`art`.`desc_articulo` AS `desc_articulo`,ifnull(`exi`.`cantidad`,0) AS `cant_compra`,0 AS `cant_venta` from (((`compra_venta`.`existencia_articulo` `exi` left join `compra_venta`.`articulo` `art` on(((`exi`.`cod_articulo` = `art`.`cod_articulo`) and (`exi`.`cod_un_medida` = `art`.`cod_un_med`) and (`exi`.`nro_lote` = `art`.`nro_lote`)))) left join `compra_venta`.`sucursal` `suc` on((`exi`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `compra_venta`.`deposito_articulo` `dar` on((`exi`.`cod_deposito` = `dar`.`cod_deposito`))) where (`exi`.`tipo_transacc` = 3) union select `exi`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`exi`.`cod_deposito` AS `cod_deposito`,`dar`.`desc_deposito` AS `desc_deposito`,`exi`.`cod_articulo` AS `cod_articulo`,`exi`.`cod_un_medida` AS `cod_un_medida`,`exi`.`nro_lote` AS `nro_lote`,`art`.`desc_articulo` AS `desc_articulo`,0 AS `cant_compra`,ifnull(`exi`.`cantidad`,0) AS `cant_venta` from (((`compra_venta`.`existencia_articulo` `exi` left join `compra_venta`.`articulo` `art` on(((`exi`.`cod_articulo` = `art`.`cod_articulo`) and (`exi`.`cod_un_medida` = `art`.`cod_un_med`) and (`exi`.`nro_lote` = `art`.`nro_lote`)))) left join `compra_venta`.`sucursal` `suc` on((`exi`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `compra_venta`.`deposito_articulo` `dar` on((`exi`.`cod_deposito` = `dar`.`cod_deposito`))) where (`exi`.`tipo_transacc` = 4)) `e` group by `e`.`cod_sucursal`,`e`.`desc_sucursal`,`e`.`cod_deposito`,`e`.`desc_deposito`,`e`.`cod_articulo`,`e`.`cod_un_medida`,`e`.`nro_lote`,`e`.`desc_articulo` order by `e`.`cod_articulo`) */;

/*View structure for view view_grupo_usuario */

/*!50001 DROP TABLE IF EXISTS `view_grupo_usuario` */;
/*!50001 DROP VIEW IF EXISTS `view_grupo_usuario` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_grupo_usuario` AS (select `ag`.`cod_grupo` AS `cod_grupo`,`gu`.`desc_grupo` AS `desc_grupo`,`ag`.`cod_modulo` AS `cod_modulo`,`ms`.`desc_modulo` AS `desc_modulo`,`ag`.`desc_formulario` AS `desc_formulario`,(case when (`ag`.`mostrar_en_menu` = 'S') then 'SI' else 'NO' end) AS `menu`,(case when (`ag`.`puede_borrar` = 'S') then 'SI' else 'NO' end) AS `borrar`,(case when (`ag`.`puede_consul` = 'S') then 'SI' else 'NO' end) AS `consultar`,(case when (`ag`.`puede_insert` = 'S') then 'SI' else 'NO' end) AS `insertar`,(case when (`ag`.`puede_modif` = 'S') then 'SI' else 'NO' end) AS `modificar` from ((`acceso_grupo` `ag` left join `grupo_usuario` `gu` on((`ag`.`cod_grupo` = `gu`.`cod_grupo`))) left join `modulo_sistema` `ms` on((`ag`.`cod_modulo` = `ms`.`cod_modulo`)))) */;

/*View structure for view view_mov_caja_compra */

/*!50001 DROP TABLE IF EXISTS `view_mov_caja_compra` */;
/*!50001 DROP VIEW IF EXISTS `view_mov_caja_compra` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_mov_caja_compra` AS (select `mcaj`.`tipo_mov_caja_com` AS `tipo_mov_comp`,`mcaj`.`ser_mov_caja_com` AS `ser_mov_comp`,`mcaj`.`nro_mov_caja_com` AS `nro_mov_comp`,date_format(`mcaj`.`fecha_mov_caja_com`,'%d/%m/%Y') AS `fecha_mov_comp`,`mcaj`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`mcaj`.`cod_proveedor` AS `cod_proveedor`,`p`.`nombre` AS `nomb_proveedor`,`mcaj`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`mcaj`.`total_mov_caja_com` AS `total_mov_comp` from (((((`movimiento_caja_compra` `mcaj` left join `proveedor` `c` on((`mcaj`.`cod_proveedor` = `c`.`cod_proveedor`))) left join `persona` `p` on((`p`.`cod_persona` = `c`.`cod_persona`))) left join `usuario` `us` on((`mcaj`.`cod_usuario` = `us`.`cod_usuario`))) left join `persona` `pu` on((`us`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `suc` on((`mcaj`.`cod_sucursal` = `suc`.`cod_sucursal`)))) */;

/*View structure for view view_mov_caja_venta */

/*!50001 DROP TABLE IF EXISTS `view_mov_caja_venta` */;
/*!50001 DROP VIEW IF EXISTS `view_mov_caja_venta` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_mov_caja_venta` AS (select `mcaj`.`tipo_mov_caja` AS `tipo_mov_caja`,`mcaj`.`ser_mov_caja` AS `ser_mov_caja`,`mcaj`.`nro_mov_caja` AS `nro_mov_caja`,date_format(`mcaj`.`fecha_mov_caja_venta`,'%d/%m/%Y') AS `fecha_mov_caja_venta`,`mcaj`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`mcaj`.`cod_cliente` AS `cod_cliente`,`p`.`nombre` AS `nomb_cliente`,`mcaj`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`mcaj`.`cod_caja` AS `cod_caja`,`cj`.`desc_caja` AS `desc_caja`,`mcaj`.`numero_hab` AS `numero_hab`,`mcaj`.`total_mov_caja` AS `total_mov_caja` from ((((((`movimiento_caja_venta` `mcaj` left join `cliente` `c` on((`mcaj`.`cod_cliente` = `c`.`cod_cliente`))) left join `caja` `cj` on(((`mcaj`.`cod_caja` = `cj`.`cod_caja`) and (`mcaj`.`cod_sucursal` = `cj`.`cod_sucursal`)))) left join `persona` `p` on((`p`.`cod_persona` = `c`.`cod_persona`))) left join `usuario` `us` on((`mcaj`.`cod_usuario` = `us`.`cod_usuario`))) left join `persona` `pu` on((`us`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `suc` on((`mcaj`.`cod_sucursal` = `suc`.`cod_sucursal`)))) */;

/*View structure for view view_persona */

/*!50001 DROP TABLE IF EXISTS `view_persona` */;
/*!50001 DROP VIEW IF EXISTS `view_persona` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_persona` AS (select `per`.`cod_persona` AS `cod_persona`,`per`.`nombre` AS `nombre`,`per`.`cod_tipo_doc` AS `cod_tipo_doc`,`tdoc`.`Desc_tipo_doc` AS `Desc_tipo_doc`,`per`.`ruc_ci` AS `ruc_ci`,ifnull(`per`.`cod_ciudad`,'') AS `cod_ciudad`,`ciu`.`desc_ciudad` AS `desc_ciudad`,`per`.`direccion` AS `direccion`,`per`.`direccion_trabajo` AS `direccion_trabajo`,`per`.`telefono_domicilio` AS `telefono_domicilio`,`per`.`telefono_trabajo` AS `telefono_trabajo`,`per`.`celular` AS `celular`,date_format(`per`.`fecha_nacimiento`,'%d/%m/%Y') AS `fecha_nacimiento`,`per`.`cod_estado_civil` AS `cod_estado_civil`,`ecv`.`desc_estado_civil` AS `desc_estado_civil`,ifnull(`per`.`cod_pais`,'') AS `cod_pais`,`p`.`desc_pais` AS `desc_pais`,ifnull(`per`.`es_banco`,'N') AS `es_banco` from ((((`persona` `per` left join `tipo_documento` `tdoc` on((`per`.`cod_tipo_doc` = `tdoc`.`cod_tipo_doc`))) left join `ciudad` `ciu` on((`per`.`cod_ciudad` = `ciu`.`cod_ciudad`))) left join `estado_civil` `ecv` on((`per`.`cod_estado_civil` = `ecv`.`cod_estado_civil`))) left join `pais` `p` on((`per`.`cod_pais` = `p`.`cod_pais`)))) */;

/*View structure for view view_recibo_compra */

/*!50001 DROP TABLE IF EXISTS `view_recibo_compra` */;
/*!50001 DROP VIEW IF EXISTS `view_recibo_compra` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_recibo_compra` AS (select `rec`.`cod_usuario` AS `cod_usuario`,`pus`.`nombre` AS `nomb_usuario`,`rec`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`rec`.`tipo_rec_comp` AS `tipo_recibo`,`rec`.`ser_rec_comp` AS `ser_recibo`,`rec`.`nro_rec_comp` AS `nro_recibo`,date_format(`rec`.`fecha_rec_comp`,'%d/%m/%Y') AS `fecha_recibo`,`rec`.`cod_proveedor` AS `cod_proveedor`,`pcl`.`nombre` AS `nomb_cliente`,`rec`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`rec`.`total_rec_comp` AS `total_recibo`,`rec`.`comentario` AS `comentario`,`dre`.`tipo_transaccion` AS `tipo_transaccion`,`dre`.`sub_tipo_transac` AS `sub_tipo_transac`,`dre`.`tipo_comprobante_ref` AS `tipo_comprobante_ref`,`dre`.`ser_comprobante_ref` AS `ser_comprobante_ref`,`dre`.`nro_comprobante_ref` AS `nro_comprobante_ref`,`dre`.`nro_cuota` AS `nro_cuota`,`dre`.`fecha_vencimiento` AS `fecha_vencimiento`,`dre`.`monto_cuota` AS `monto_cuota`,`dre`.`importe_total` AS `importe_total` from (((((((`recibo_compra_cabecera` `rec` left join `recibo_detalle_compra` `dre` on(((`rec`.`tipo_rec_comp` = `dre`.`tipo_rec_comp`) and (`rec`.`ser_rec_comp` = `dre`.`ser_rec_comp`) and (`rec`.`nro_rec_comp` = `dre`.`nro_rec_comp`)))) left join `proveedor` `pro` on((`rec`.`cod_proveedor` = `pro`.`cod_proveedor`))) left join `moneda` `mon` on((`rec`.`cod_moneda` = `mon`.`cod_moneda`))) left join `sucursal` `suc` on((`rec`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `usuario` `usu` on((`rec`.`cod_usuario` = `usu`.`cod_usuario`))) left join `persona` `pcl` on((`pro`.`cod_persona` = `pcl`.`cod_persona`))) left join `persona` `pus` on((`usu`.`cod_persona` = `pus`.`cod_persona`)))) */;

/*View structure for view view_recibo_venta */

/*!50001 DROP TABLE IF EXISTS `view_recibo_venta` */;
/*!50001 DROP VIEW IF EXISTS `view_recibo_venta` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_recibo_venta` AS (select `rec`.`cod_usuario` AS `cod_usuario`,`pus`.`nombre` AS `nomb_usuario`,`rec`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`rec`.`tipo_recibo` AS `tipo_recibo`,`rec`.`ser_recibo` AS `ser_recibo`,`rec`.`nro_recibo` AS `nro_recibo`,date_format(`rec`.`fecha_recibo`,'%d/%m/%Y') AS `fecha_recibo`,`rec`.`cod_cliente` AS `cod_cliente`,`pcl`.`nombre` AS `nomb_cliente`,`rec`.`cod_cobrador` AS `cod_cobrador`,`pco`.`nombre` AS `nomb_cobrador`,`rec`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`rec`.`total_recibo` AS `total_recibo`,`rec`.`comentario` AS `comentario`,`dre`.`tipo_transaccion` AS `tipo_transaccion`,`dre`.`sub_tipo_transac` AS `sub_tipo_transac`,`dre`.`tipo_comprobante_ref` AS `tipo_comprobante_ref`,`dre`.`ser_comprobante_ref` AS `ser_comprobante_ref`,`dre`.`nro_comprobante_ref` AS `nro_comprobante_ref`,`dre`.`nro_cuota` AS `nro_cuota`,`dre`.`fecha_vencimiento` AS `fecha_vencimiento`,`dre`.`monto_cuota` AS `monto_cuota`,`dre`.`importe_total` AS `importe_total` from (((((((((`recibo_venta_cabecera` `rec` left join `recibo_detalle_venta` `dre` on(((`rec`.`tipo_recibo` = `dre`.`tipo_recibo`) and (`rec`.`ser_recibo` = `dre`.`ser_recibo`) and (`rec`.`nro_recibo` = `dre`.`nro_recibo`)))) left join `cliente` `cli` on((`rec`.`cod_cliente` = `cli`.`cod_cliente`))) left join `cobrador` `cob` on((`rec`.`cod_cobrador` = `cob`.`cod_cobrador`))) left join `moneda` `mon` on((`rec`.`cod_moneda` = `mon`.`cod_moneda`))) left join `sucursal` `suc` on((`rec`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `usuario` `usu` on((`rec`.`cod_usuario` = `usu`.`cod_usuario`))) left join `persona` `pcl` on((`cli`.`cod_persona` = `pcl`.`cod_persona`))) left join `persona` `pco` on((`cob`.`cod_persona` = `pco`.`cod_persona`))) left join `persona` `pus` on((`usu`.`cod_persona` = `pus`.`cod_persona`)))) */;

/*View structure for view view_saldo_cliente */

/*!50001 DROP TABLE IF EXISTS `view_saldo_cliente` */;
/*!50001 DROP VIEW IF EXISTS `view_saldo_cliente` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_saldo_cliente` AS (select `s`.`tipo_comprobante` AS `tipo_comprobante`,`s`.`ser_comprobante` AS `ser_comprobante`,`s`.`nro_comprobante` AS `nro_comprobante`,`s`.`cod_cliente` AS `cod_cliente`,`p`.`nombre` AS `nombre`,`s`.`nro_cuota` AS `nro_cuota`,`s`.`fecha_vencimiento` AS `fec_venc`,date_format(`s`.`fecha_vencimiento`,'%d/%m/%Y') AS `fecha_vencimiento`,`s`.`saldo_cuota` AS `saldo_cuota` from ((`saldo_cliente` `s` left join `cliente` `c` on((`s`.`cod_cliente` = `c`.`cod_cliente`))) left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) order by `s`.`ser_comprobante`,`s`.`nro_comprobante`,`s`.`nro_cuota`) */;

/*View structure for view view_saldo_proveedor */

/*!50001 DROP TABLE IF EXISTS `view_saldo_proveedor` */;
/*!50001 DROP VIEW IF EXISTS `view_saldo_proveedor` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_saldo_proveedor` AS (select `s`.`tipo_comprobante` AS `tipo_comprobante`,`s`.`ser_comprobante` AS `ser_comprobante`,`s`.`nro_comprobante` AS `nro_comprobante`,`s`.`cod_proveedor` AS `cod_proveedor`,`p`.`nombre` AS `nombre`,`s`.`nro_cuota` AS `nro_cuota`,`s`.`fecha_vencimiento` AS `fec_venc`,date_format(`s`.`fecha_vencimiento`,'%d/%m/%Y') AS `fecha_vencimiento`,`s`.`saldo_cuota` AS `saldo_cuota`,`s`.`monto_cuota` AS `monto_cuota` from ((`saldo_proveedor` `s` left join `proveedor` `c` on((`s`.`cod_proveedor` = `c`.`cod_proveedor`))) left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) order by `s`.`ser_comprobante`,`s`.`nro_comprobante`,`s`.`nro_cuota`) */;

/*View structure for view view_serie_comprobante */

/*!50001 DROP TABLE IF EXISTS `view_serie_comprobante` */;
/*!50001 DROP VIEW IF EXISTS `view_serie_comprobante` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_serie_comprobante` AS (select `s`.`tipo_comprobante` AS `tipo_comprobante`,`t`.`descripcion` AS `desc_comp`,`s`.`ser_comprobante` AS `ser_comprobante`,`s`.`cod_sucursal` AS `cod_sucursal`,`sc`.`desc_sucursal` AS `desc_sucursal`,`s`.`numero_inicial` AS `numero_inicial`,`s`.`numero_final` AS `numero_final`,`s`.`ser_timbrado` AS `ser_timbrado`,`s`.`numero_timbrado` AS `numero_timbrado`,date_format(`s`.`fecha_vigencia`,'%d/%m/%Y') AS `fecha_vigencia` from ((`serie_comprobante` `s` left join `tipo_comprobante` `t` on((`s`.`tipo_comprobante` = `t`.`tipo_comprobante`))) left join `sucursal` `sc` on((`s`.`cod_sucursal` = `sc`.`cod_sucursal`))) order by `s`.`tipo_comprobante`,`s`.`ser_comprobante`) */;

/*View structure for view view_talonario_comprobante */

/*!50001 DROP TABLE IF EXISTS `view_talonario_comprobante` */;
/*!50001 DROP VIEW IF EXISTS `view_talonario_comprobante` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_talonario_comprobante` AS (select `ta`.`tipo_talonario` AS `tipo_talonario`,`tc`.`descripcion` AS `desc_talonario`,`ta`.`serie` AS `serie`,`ta`.`cod_sucursal` AS `cod_sucursal`,`su`.`desc_sucursal` AS `desc_sucursal`,`ta`.`nro_talonario` AS `nro_talonario`,`ta`.`numero_inicial` AS `numero_inicial`,`ta`.`numero_final` AS `numero_final`,`ta`.`estado` AS `estado`,(case when (`ta`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `desc_estado` from ((`talonario` `ta` left join `tipo_comprobante` `tc` on((`ta`.`tipo_talonario` = `tc`.`tipo_comprobante`))) left join `sucursal` `su` on((`ta`.`cod_sucursal` = `su`.`cod_sucursal`))) order by `ta`.`tipo_talonario`,`ta`.`serie`) */;

/*View structure for view view_talonario_usuario */

/*!50001 DROP TABLE IF EXISTS `view_talonario_usuario` */;
/*!50001 DROP VIEW IF EXISTS `view_talonario_usuario` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_talonario_usuario` AS (select `tu`.`tipo_talonario` AS `tipo_talonario`,`tc`.`descripcion` AS `desc_talonario`,`tu`.`serie` AS `serie`,`tu`.`cod_sucursal` AS `cod_sucursal`,`su`.`desc_sucursal` AS `desc_sucursal`,`tu`.`nro_talonario` AS `nro_talonario`,`tu`.`cod_usuario` AS `cod_usuario`,`pe`.`nombre` AS `nombre` from ((((`talonario_usuario` `tu` left join `tipo_comprobante` `tc` on((`tu`.`tipo_talonario` = `tc`.`tipo_comprobante`))) left join `sucursal` `su` on((`tu`.`cod_sucursal` = `su`.`cod_sucursal`))) left join `usuario` `us` on((`tu`.`cod_usuario` = `us`.`cod_usuario`))) left join `persona` `pe` on((`us`.`cod_persona` = `pe`.`cod_persona`))) order by `tu`.`tipo_talonario`,`tu`.`serie`) */;

/*View structure for view view_usuarios */

/*!50001 DROP TABLE IF EXISTS `view_usuarios` */;
/*!50001 DROP VIEW IF EXISTS `view_usuarios` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_usuarios` AS (select `u`.`cod_usuario` AS `COD_USUARIO`,`p`.`cod_persona` AS `COD_PERSONA`,`p`.`nombre` AS `NOMBRE_USUARIO`,`u`.`cod_grupo` AS `COD_GRUPO`,`g`.`desc_grupo` AS `DESC_GRUPO`,`u`.`cod_sucursal` AS `COD_SUCURSAL`,`s`.`desc_sucursal` AS `DESC_SUCURSAL`,`u`.`estado` AS `ESTADO`,(case when (`u`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `desc_estado` from (((`usuario` `u` left join `persona` `p` on((`u`.`cod_persona` = `p`.`cod_persona`))) left join `grupo_usuario` `g` on((`u`.`cod_grupo` = `g`.`cod_grupo`))) left join `sucursal` `s` on((`u`.`cod_sucursal` = `s`.`cod_sucursal`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
