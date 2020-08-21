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
  KEY `FK_COMP_CM_CAB_COD_USUARIO` (`cod_usuario`),
  KEY `FK_COMP_CM_CAB_COD_PROVE` (`cod_proveedor`),
  KEY `FK_COMP_CM_CAB_COD_COND` (`cod_cond_comp`),
  KEY `FK_COMP_CM_CAB_COD_MONEDA` (`cod_moneda`),
  KEY `FK_COMP_CM_CAB_COD_DEP` (`cod_sucursal`,`cod_deposito`),
  CONSTRAINT `FK_COMP_CM_CAB_COD_COND` FOREIGN KEY (`cod_cond_comp`) REFERENCES `condicion_venta` (`cod_condicion`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_COMP_CM_CAB_COD_DEP` FOREIGN KEY (`cod_sucursal`, `cod_deposito`) REFERENCES `deposito_articulo` (`cod_sucursal`, `cod_deposito`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_COMP_CM_CAB_COD_MONEDA` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_COMP_CM_CAB_COD_PROVE` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedor` (`cod_proveedor`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_COMP_CM_CAB_COD_SUCURSAL` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_COMP_CM_CAB_COD_USUARIO` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_cabecera_compra` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
