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
  CONSTRAINT `FK_COMP_CM_DET_COMP_CAB` FOREIGN KEY (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) REFERENCES `comprobante_cabecera_compra` (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_detalle_compra` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
