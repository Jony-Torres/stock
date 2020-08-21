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
('ADMIN','AJ','FORMBACKUP','S','S','S','S','S'),
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
('ADMIN','CC','FORMPERSON','S','S','S','S','S'),
('ADMIN','CC','FORMRECIBO','S','S','S','S','S'),
('ADMIN','CC','REPEXTCLI1','S','S','S','S','S'),
('ADMIN','CC','REPMOVCAJ1','S','S','S','S','S'),
('ADMIN','CC','REPRECEMI1','S','S','S','S','S'),
('ADMIN','CC','REP_COB','S','S','S','S','S'),
('ADMIN','CM','FORMFACCOM','S','S','S','S','S'),
('ADMIN','CP','FORMCOSAPR','S','S','S','S','S'),
('ADMIN','CP','FORMFORMPA','S','S','S','S','S'),
('ADMIN','CP','FORMPROVEE','S','S','S','S','S'),
('ADMIN','ST','FORMAJUSTK','S','S','S','S','S'),
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
('ADMIN','VT','REPCOMPEM1','S','S','S','S','S'),
('ADMIN','VT','REP_VENT','S','S','S','S','S'),
('GERENCIA','AJ','FORMDESCON','S','S','S','S','S'),
('GERENCIA','AY','FORMCAMPAS','S','S','S','S','S'),
('GERENCIA','CC','FORMCLIENT','S','S','S','S','S'),
('GERENCIA','CC','FORMCOSACL','S','S','S','S','S'),
('GERENCIA','CC','FORMFORMCO','S','S','S','S','S'),
('GERENCIA','CC','FORMHBCJCO','S','S','S','S','S'),
('GERENCIA','CC','FORMPERSON','S','S','S','S','S'),
('GERENCIA','CC','FORMRECIBO','S','S','S','S','S'),
('GERENCIA','CC','REPEXTCLI1','S','S','S','S','S'),
('GERENCIA','CC','REPMOVCAJ1','S','S','S','S','S'),
('GERENCIA','CC','REPRECEMI1','S','S','S','S','S'),
('GERENCIA','CC','REP_COB','S','S','S','S','S'),
('VENTAS','AJ','FORMBACKUP','S','S','S','S','S'),
('VENTAS','AJ','FORMDESCON','S','S','S','S','S'),
('VENTAS','AJ','FORMMENUPR','S','S','S','S','S'),
('VENTAS','AJ','FORMSALIR','S','S','S','S','S'),
('VENTAS','AY','FORMCAMPAS','S','S','S','S','S'),
('VENTAS','CC','FORMCIECAJ','S','S','S','S','S'),
('VENTAS','CC','FORMCLIENT','S','S','S','S','S'),
('VENTAS','CC','FORMCOSACL','S','S','S','S','S'),
('VENTAS','CC','FORMFORMCO','S','S','S','S','S'),
('VENTAS','CC','FORMHBCJCO','S','S','S','S','S'),
('VENTAS','CC','FORMPERSON','S','S','S','S','S'),
('VENTAS','CC','FORMRECIBO','S','S','S','S','S'),
('VENTAS','CC','REPEXTCLI1','S','S','S','S','S'),
('VENTAS','CC','REPMOVCAJ1','S','S','S','S','S'),
('VENTAS','CC','REPRECEMI1','S','S','S','S','S'),
('VENTAS','CC','REP_COB','S','S','S','S','S'),
('VENTAS','CM','FORMFACCOM','S','S','S','S','S'),
('VENTAS','CP','FORMCOSAPR','S','S','S','S','S'),
('VENTAS','CP','FORMPROVEE','S','S','S','S','S'),
('VENTAS','ST','FORMAJUSTK','S','S','S','S','S'),
('VENTAS','ST','FORMARTICU','S','S','S','S','S'),
('VENTAS','ST','FORMCATART','S','S','S','S','S'),
('VENTAS','ST','FORMCOEXAR','S','S','S','S','S'),
('VENTAS','ST','FORMMARART','S','S','S','S','S'),
('VENTAS','ST','FORMUNMEAR','S','S','S','S','S'),
('VENTAS','ST','REPEXISART','S','S','S','S','S'),
('VENTAS','ST','REP_STK','S','S','S','S','S'),
('VENTAS','VT','FORMANCOVE','S','S','S','S','S'),
('VENTAS','VT','FORMCNCMVE','S','S','S','S','S'),
('VENTAS','VT','FORMFACTUR','S','S','S','S','S'),
('VENTAS','VT','REPCOMPEM1','S','S','S','S','S'),
('VENTAS','VT','REP_VENT','S','S','S','S','S');

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
('A001','UN','0','CARGADOR PARA AUTO LUO 8135',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A002','UN','0','CARGADOR PARA ECOPOWER LUO 8135',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A003','UN','0','CARGADOR 6101 FINO NOKIA',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A004','UN','0','CARGADOR V8 COMUN',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A005','UN','0','CARGADOR UNIVERSAL LUO 8051',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A006','UN','0','CARGADOR ECOPOWER IPH 7052',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A007','UN','0','CARGADOR DNS IPH 1123',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A008','UN','0','CARGADOR ECOPOWER V8 7056',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A009','UN','0','CARGADOR ORIGINAL SAMSUNG 5225',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A010','UN','0','CARGADOR INOVA V8 003',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A011','UN','0','CARGADOR ECOPOWER 7053 TIPO C',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A012','UN','0','CARGADOR XIOAMI',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A013','UN','0','CABLE ECOPOWER 6008 V8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A014','UN','0','CABLE ECOPOWER 6022 TIPO C',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A015','UN','0','AUXILIAR COMUN 6262C',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A016','UN','0','AUXILIAR GRIFFIN 3879',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A017','UN','0','CABLE USB 3 METROS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A018','UN','0','CABLE TIPO C COMUN',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A019','UN','0','CABLE V3 COMUN 2725',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A020','UN','0','CABLE V8 COMUN',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A021','UN','0','CABLE USB IPH,V8 HY 971',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A022','UN','0','CABEZA CARGADOR LUO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A023','UN','0','OTG V8 LUO LUXO1 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A024','UN','0','OTG TIPO C LUX02',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A025','UN','0','CABLE IPH 4 CA9501',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A026','UN','0','CABLE IPH ORIGINAL 5526',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A027','UN','0','OTG TIPO C LUX03',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A028','UN','0','OTG IPH LU05',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A029','UN','0','OTG V8 LUO 2030',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A030','UN','0','OTG TIPO C 1181',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A031','UN','0','CABEZA CARGADOR ECONO 1327',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A032','UN','0','ADAPTADOR GRIFFIN 5820',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A033','UN','0','PENDRIVE 64 GB 9731',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A034','UN','0','PENDRIVE 16 GB 0043',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A035','UN','0','PENDRIVE 8 GB 0042',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A036','UN','0','MEMORIA 16 GB 6688',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A037','UN','0','MEMORIA 32 GB 9868',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A038','UN','0','PENDRIVE CON MUSICA E40',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A039','UN','0','BATERIA 1500',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A040','UN','0','BATERIA 6530',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A041','UN','0','BATERIA 1200',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A042','UN','0','BATERIA BL4C',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A043','UN','0','BATERIA BL5C',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A044','UN','0','BATERIA 2000 CORE2',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A045','UN','0','BATERIA J7',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A046','UN','0','BATERIA J1 ASC',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A047','UN','0','CABEZA IPH',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A048','UN','0','CARGADOR PORTATIL ECOPOWER 5200',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A049','UN','0','CARGADOR PORTATIL ECOPOWER 6500',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A050','UN','0','AURICULAR ECOPOWER APH121',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A051','UN','0','AURICULAR ECOPOWER APH138',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A052','UN','0','AURICULAR INALAMBRICO I7',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A053','UN','0','AURICULAR IPH CAJITA',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A054','UN','0','CARGADOR COMUN FON 10032',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A055','UN','0','AURICULAR LUO  LUA01',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A056','UN','0','AURICULAR AKC C559',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A057','UN','0','AURICULAR SAMSUNG ORIGINAL',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A058','UN','0','AURICULAR J5 6H59',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A059','UN','0','AURICULAR LUO LU450',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A060','UN','0','AURICULAR INALAMBRICO INOVA FON002',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A061','UN','0','ADAPTADOR DE BLUETOO JQ95',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A062','UN','0','LINTERNA ECOPOWER EP8233',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A063','UN','0','TRANSMISOR LUO 2013',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A064','UN','0','TRANSMISOR X5 BLUETOO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A065','UN','0','MINI SPEKEAR W5877',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A066','UN','0','CONTROL ECOPOWER EP8609',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A067','UN','0','CONTROL ECOPOWER EP8615',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A068','UN','0','CONTROL PLAY3 9004',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A069','UN','0','CONTROL PLAY2 COMUN',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A070','UN','0','RADIO INOVA AM,FM RAD0011',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A071','UN','0','PARLANTE INOVA RAD00006',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A072','UN','0','PARLANTE PREMIO J222',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A073','UN','0','SPEKEAR INOVA 8168',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A074','UN','0','SPEKEAR AURICULAR MK101',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A075','UN','0','SPEKEAR JBL MINIGO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A076','UN','0','SPEKEAR INOVA KARAOKE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A077','UN','0','ESTUCHE K40',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A078','UN','0','ESTUCHE MATE9 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A079','UN','0','ESTUCHE MATE9 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A080','UN','0','ESTUCHE SAMSUNG NOTE8 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A081','UN','0','ESTUCHE K8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A082','UN','0','ESTUCHE PSMART',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A083','UN','0','ESTUCHE P30 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A084','UN','0','ESTUCHE 510',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A085','UN','0','ESTUCHE REDMI 9',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A086','UN','0','ESTUCHE 520 ULTRA',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A087','UN','0','ESTUCHE NOTE 8 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A088','UN','0','ESTUCHE NOTE 8 REDMI',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A089','UN','0','ESTUCHE A80',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A090','UN','0','ESTUCHE A71',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A091','UN','0','ESTUCHE A70',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A092','UN','0','ESTUCHE A51',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A093','UN','0','ESTUCHE A50',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A094','UN','0','ESTUCHE A505',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A095','UN','0','ESTUCHE A31',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A096','UN','0','ESTUCHE A305',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A097','UN','0','ESTUCHE A30',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A098','UN','0','ESTUCHE A21',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A099','UN','0','ESTUCHE A205',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A100','UN','0','ESTUCHE A20',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A101','UN','0','ESTUCHE A11',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A102','UN','0','ESTUCHE A10',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A103','UN','0','ESTUCHE A10S',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A104','UN','0','ESTUCHE A01',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A105','UN','0','ESTUCHE J8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A106','UN','0','ESTUCHE J7.06',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A107','UN','0','ESTUCHE J7 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A108','UN','0','ESTUCHE J7 PRIME ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A109','UN','0','ESTUCHE J6 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A110','UN','0','ESTUCHE J6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A111','UN','0','ESTUCHE J5 PRIME',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A112','UN','0','ESTUCHE J5 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A113','UN','0','ESTUCHE J5',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A114','UN','0','ESTUCHE J4',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A115','UN','0','ESTUCHE J4 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A116','UN','0','ESTUCHE J3.06',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A117','UN','0','ESTUCHE J2 PRIME',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A118','UN','0','ESTUCHE J2 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A119','UN','0','ESTUCHE J2 CORE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A120','UN','0','ESTUCHE J1 ACE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A121','UN','0','ESTUCHE Y5.06',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A122','UN','0','ESTUCHE Y5 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A123','UN','0','ESTUCHE Y52018',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A124','UN','0','ESTUCHE Y6 2019',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A125','UN','0','ESTUCHE Y7',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A126','UN','0','ESTUCHE Y7 2018',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A127','UN','0','ESTUCHE Y92018',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A128','UN','0','ESTUCHE Y92019',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A129','UN','0','ESTUCHE P9 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A130','UN','0','ESTUCHE P9',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A131','UN','0','ESTUCHE P10',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A132','UN','0','ESTUCHE P10 SELFIE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A133','UN','0','ESTUCHE P20 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A134','UN','0','ESTUCHE S7',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A135','UN','0','ESTUCHE S8 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A136','UN','0','ESTUCHE S8 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A137','UN','0','ESTUCHE S9 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A138','UN','0','ESTUCHE S9 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A139','UN','0','ESTUCHE IPH 6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A140','UN','0','ESTUCHE IPH 6 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A141','UN','0','ESTUCHE IPH 7 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A142','UN','0','ESTUCHE IPH 7 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A143','UN','0','ESTUCHE IPH 8 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A144','UN','0','ESTUCHE IPH X',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A145','UN','0','ESTUCHE IPH XS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A146','UN','0','ESTUCHE IPH R',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A147','UN','0','ESTUCHE IPH XS MAX',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A148','UN','0','ESTUCHE IPH 11 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A149','UN','0','ESTUCHE IPH 11 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A150','UN','0','VISOR J1.6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A151','UN','0','VISOR J1 ACE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A152','UN','0','VISOR J2',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A153','UN','0','VISOR J2 PRIME',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A154','UN','0','VISOR J2 CORE ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A155','UN','0','VISOR J2 PRO ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A156','UN','0','VISOR J3.07',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A157','UN','0','VISOR J4 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A158','UN','0','VISOR J4',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A159','UN','0','VISOR J5',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A160','UN','0','VISOR J5.6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A161','UN','0','VISOR J5 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A162','UN','0','VISOR J5 PRIME',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A163','UN','0','VISOR J6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A164','UN','0','VISOR J7 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A165','UN','0','VISOR J7.6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A166','UN','0','VISOR J7 PRIME',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A167','UN','0','VISOR J7 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A168','UN','0','VISOR J8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A169','UN','0','VISOR A01',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A170','UN','0','VISOR A10',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A171','UN','0','VISOR A10S',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A172','UN','0','VISOR A11',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A173','UN','0','VISOR A20',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A174','UN','0','VISOR A20S',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A175','UN','0','VISOR A21',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A176','UN','0','VISOR A30',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A177','UN','0','VISOR A30S',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A178','UN','0','VISOR A31',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A179','UN','0','VISOR A50',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A180','UN','0','VISOR A50S',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A181','UN','0','VISOR A51',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A182','UN','0','VISOR A70',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A183','UN','0','VISOR A71',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A184','UN','0','VISOR A80',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A185','UN','0','VISOR A20',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A186','UN','0','VISOR P20 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A187','UN','0','VISOR P30 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A188','UN','0','VISOR P30 LITE',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A189','UN','0','VISOR Y3',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A190','UN','0','VISOR Y5',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A191','UN','0','VISOR Y5.18',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A192','UN','0','VISOR Y5.19',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A193','UN','0','VISOR Y6.19',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A194','UN','0','VISOR Y7.18',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A195','UN','0','VISOR Y7.19',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A196','UN','0','VISOR Y9.18',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A197','UN','0','VISOR Y9.19',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A198','UN','0','VISOR PSMART',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A199','UN','0','VISOR NOTE 8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A200','UN','0','VISOR MATE 20',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A201','UN','0','VISOR XIAOMI NOTE 7A',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A202','UN','0','VISOR XIAOMI NOTE 7 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A203','UN','0','VISOR XIAOMI NOTE 8 PRO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A204','UN','0','VISOR XIAOMI NOTE 9',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A205','UN','0','VISOR XIAOMI REDMI GO',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A206','UN','0','VISOR P10',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A207','UN','0','VISOR K7',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A208','UN','0','VISOR K8.17',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A209','UN','0','VISOR P8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A210','UN','0','VISOR ONE VISION',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A211','UN','0','VISOR A7.6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A212','UN','0','VISOR IPH 6',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A213','UN','0','VISOR IPH 6 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A214','UN','0','VISOR IPH 7 ',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A215','UN','0','VISOR IPH 7 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A216','UN','0','VISOR IPH 8',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A217','UN','0','VISOR IPH 8 PLUS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A218','UN','0','VISOR IPH X',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A219','UN','0','VISOR IPH XS',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A220','UN','0','VISOR IPH 11',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A221','UN','0','VISOR XR',1,'GRAL','GRAL',0,0,1,'10','A','S'),
('A222','UN','0','CABLE TIPO C 5122',1,'GRAL','GRAL',0,0,1,'10','A','S');

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
('01','CAJ2','CAJA DOS SUC1','2018-05-02','A');

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
('GRAL','GENERALES'),
('INSU','INSUMOS'),
('MUEB','MUEBLES'),
('PRE2','PRUEBA2'),
('PRUEB','PRUEBA');

/*Table structure for table `ciudad` */

DROP TABLE IF EXISTS `ciudad`;

CREATE TABLE `ciudad` (
  `cod_ciudad` int(10) NOT NULL AUTO_INCREMENT,
  `desc_ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `ciudad` */

insert  into `ciudad`(`cod_ciudad`,`desc_ciudad`) values 
(1,'AREGUA'),
(2,'ASUNCION'),
(3,'LUQUE'),
(4,'LIMPIO'),
(5,'SAN LORENZO'),
(6,'FERNANDO DE LA MORA'),
(7,'ITAGUA'),
(8,'YPACARAI'),
(9,'ITA'),
(10,'CAACUPE');

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
) ENGINE=InnoDB AUTO_INCREMENT=2483 DEFAULT CHARSET=utf8;

/*Data for the table `cliente` */

insert  into `cliente`(`cod_cliente`,`cod_persona`,`cod_moneda`,`cod_cobrador`,`cod_vendedor`,`limite_credito`,`cod_condicion_venta`,`tipo_cliente`,`estado`,`comentario`) values 
(1,2490,'01',NULL,NULL,NULL,0,'00','A',NULL);

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
('01',2478,NULL,10,'A'),
('02',2016,NULL,NULL,'A');

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
  `monto_cuota` decimal(10,2) DEFAULT NULL,
  `total_comprob_comp` decimal(10,2) DEFAULT NULL,
  `iva_comp` decimal(10,2) DEFAULT NULL,
  `gravada` decimal(10,2) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `tipo_cambio` decimal(10,2) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `pagado` varchar(1) DEFAULT NULL,
  `cod_mot_ent_sal_art` int(5) DEFAULT NULL,
  `cod_sub_mot_ent_sal_art` int(5) DEFAULT NULL,
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
  `tipo_cambio` decimal(10,2) DEFAULT NULL,
  `total_comprobante` decimal(10,2) DEFAULT NULL,
  `total_gravada` decimal(10,2) DEFAULT NULL,
  `total_exenta` decimal(10,2) DEFAULT NULL,
  `total_iva` decimal(10,2) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  `comentario` varchar(80) DEFAULT NULL,
  `monto_cuota` decimal(10,2) DEFAULT NULL,
  `cobrado` varchar(1) DEFAULT NULL,
  `cod_motivo_anul` int(5) DEFAULT NULL,
  `cod_mot_ent_sal_art` int(5) DEFAULT NULL,
  `cod_sub_mot_ent_sal_art` int(5) DEFAULT NULL,
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
  KEY `FK_COMP_VENTA_CAB_TIP_TRANS` (`cod_mot_ent_sal_art`),
  KEY `FK_COMP_VENTA_CAB_SUB_TIP_TRANS` (`cod_sub_mot_ent_sal_art`),
  CONSTRAINT `FK_COMP_VENTA_CAB_CLIE` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `FK_COMP_VENTA_CAB_COBR` FOREIGN KEY (`cod_cobrador`) REFERENCES `cobrador` (`cod_cobrador`),
  CONSTRAINT `FK_COMP_VENTA_CAB_COND` FOREIGN KEY (`cod_condicion_venta`) REFERENCES `condicion_venta` (`cod_condicion`),
  CONSTRAINT `FK_COMP_VENTA_CAB_DEP` FOREIGN KEY (`cod_deposito`, `cod_sucursal`) REFERENCES `deposito_articulo` (`cod_sucursal`, `cod_deposito`),
  CONSTRAINT `FK_COMP_VENTA_CAB_MANU` FOREIGN KEY (`cod_motivo_anul`) REFERENCES `motivo_anulac_comp` (`cod_motivo`),
  CONSTRAINT `FK_COMP_VENTA_CAB_MONE` FOREIGN KEY (`cod_moneda`) REFERENCES `moneda` (`cod_moneda`),
  CONSTRAINT `FK_COMP_VENTA_CAB_SUB_TIP_TRANS` FOREIGN KEY (`cod_sub_mot_ent_sal_art`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_COMP_VENTA_CAB_TAL` FOREIGN KEY (`tipo_comprobante`, `ser_comprobante`, `cod_sucursal`) REFERENCES `talonario` (`tipo_talonario`, `serie`, `cod_sucursal`),
  CONSTRAINT `FK_COMP_VENTA_CAB_TIP_TRANS` FOREIGN KEY (`cod_mot_ent_sal_art`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`),
  CONSTRAINT `FK_COMP_VENTA_CAB_USU` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`),
  CONSTRAINT `FK_COMP_VENTA_CAB_VEND` FOREIGN KEY (`cod_vendedor`) REFERENCES `vendedor` (`cod_vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_cabecera_venta` */

insert  into `comprobante_cabecera_venta`(`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`cod_sucursal`,`cod_deposito`,`fecha_comprobante`,`cod_cliente`,`cod_cobrador`,`cod_vendedor`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`cod_condicion_venta`,`descuento`,`cod_moneda`,`tipo_cambio`,`total_comprobante`,`total_gravada`,`total_exenta`,`total_iva`,`estado`,`cod_usuario`,`comentario`,`monto_cuota`,`cobrado`,`cod_motivo_anul`,`cod_mot_ent_sal_art`,`cod_sub_mot_ent_sal_art`) values 
('FCO','A',1,'01','01','2020-08-19',1,NULL,NULL,NULL,NULL,NULL,0,NULL,'01',NULL,60000.00,54546.00,NULL,5454.00,'P','RTORRES',NULL,0.00,NULL,NULL,NULL,NULL);

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
  `cantidad_prod` decimal(10,2) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL,
  `total_iva_5` decimal(10,2) DEFAULT NULL,
  `total_iva_10` decimal(10,2) DEFAULT NULL,
  `gravada_5` decimal(10,2) DEFAULT NULL,
  `gravada_10` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_comp`,`ser_timb_comp`,`nro_comprob_comp`,`cod_producto`,`cod_un_med`,`nro_lote`),
  KEY `FK_COMP_CM_DET_EXIST_ART` (`cod_producto`,`cod_un_med`,`nro_lote`),
  CONSTRAINT `FK_COMP_CM_DET_ARTICULO` FOREIGN KEY (`cod_producto`, `cod_un_med`, `nro_lote`) REFERENCES `articulo` (`cod_articulo`, `cod_un_med`, `nro_lote`),
  CONSTRAINT `FK_COMP_CM_DET_COMP_CAB` FOREIGN KEY (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) REFERENCES `comprobante_cabecera_compra` (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobante_detalle_compra` */

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
  `cantidad` decimal(10,2) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `gravada_10` decimal(10,2) DEFAULT NULL,
  `gravada_5` decimal(10,2) DEFAULT NULL,
  `importe_total` decimal(10,2) DEFAULT NULL,
  `total_iva10` decimal(10,2) DEFAULT NULL,
  `total_iva5` decimal(10,2) DEFAULT NULL,
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
('FCO','A',1,'A108','UN','0','ESTUCHE J7 PRIME ',1.00,40000.00,0.00,36364.00,0.00,40000.00,3636.00,0.00,0,0,0,1),
('FCO','A',1,'A166','UN','0','VISOR J7 PRIME',1.00,20000.00,0.00,18182.00,0.00,20000.00,1818.00,0.00,0,0,0,1);

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
(4,'CREDITO(120 DIAS)',4,1,30,'A'),
(5,'CREDITO(150 DIAS)',5,0,0,'A'),
(6,'CREDITO(180 DIAS)',6,0,0,'A'),
(7,'CREDITO(210 DIAS)',7,0,0,'A'),
(8,'CREDITO(240 DIAS)',8,0,0,'A'),
(9,'CREDITO(270 DIAS)',9,0,0,'A'),
(10,'CREDITO(300 DIAS)',10,0,0,'A'),
(11,'CREDITO(330 DIAS)',11,0,0,'A'),
(12,'CREDITO(360 DIAS)',12,0,0,'A'),
(13,NULL,NULL,NULL,NULL,NULL),
(14,NULL,NULL,NULL,NULL,NULL),
(15,NULL,NULL,NULL,NULL,NULL),
(16,NULL,NULL,NULL,NULL,NULL),
(17,NULL,NULL,NULL,NULL,NULL),
(18,NULL,NULL,NULL,NULL,NULL),
(19,NULL,NULL,NULL,NULL,NULL),
(20,NULL,NULL,NULL,NULL,NULL),
(21,NULL,NULL,NULL,NULL,NULL),
(22,NULL,NULL,NULL,NULL,NULL),
(23,NULL,NULL,NULL,NULL,NULL),
(24,NULL,NULL,NULL,NULL,NULL),
(25,NULL,NULL,NULL,NULL,NULL),
(26,NULL,NULL,NULL,NULL,NULL),
(27,NULL,NULL,NULL,NULL,NULL),
(28,NULL,NULL,NULL,NULL,NULL),
(29,NULL,NULL,NULL,NULL,NULL),
(30,NULL,NULL,NULL,NULL,NULL),
(31,NULL,NULL,NULL,NULL,NULL),
(32,NULL,NULL,NULL,NULL,NULL),
(33,NULL,NULL,NULL,NULL,NULL),
(34,NULL,NULL,NULL,NULL,NULL),
(35,NULL,NULL,NULL,NULL,NULL),
(36,NULL,NULL,NULL,NULL,NULL),
(37,NULL,NULL,NULL,NULL,NULL),
(38,NULL,NULL,NULL,NULL,NULL),
(39,NULL,NULL,NULL,NULL,NULL),
(40,NULL,NULL,NULL,NULL,NULL),
(41,NULL,NULL,NULL,NULL,NULL),
(42,NULL,NULL,NULL,NULL,NULL),
(43,NULL,NULL,NULL,NULL,NULL),
(44,NULL,NULL,NULL,NULL,NULL),
(45,NULL,NULL,NULL,NULL,NULL);

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
  `cantidad` decimal(10,2) DEFAULT NULL,
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
('01','01','A001','UN','0',3,7,2.00),
('01','01','A002','UN','0',3,7,4.00),
('01','01','A003','UN','0',3,7,5.00),
('01','01','A004','UN','0',3,7,2.00),
('01','01','A005','UN','0',3,7,4.00),
('01','01','A006','UN','0',3,7,6.00),
('01','01','A007','UN','0',3,7,1.00),
('01','01','A008','UN','0',3,7,4.00),
('01','01','A009','UN','0',3,7,1.00),
('01','01','A010','UN','0',3,7,2.00),
('01','01','A011','UN','0',3,7,4.00),
('01','01','A012','UN','0',3,7,1.00),
('01','01','A013','UN','0',3,7,3.00),
('01','01','A014','UN','0',3,7,4.00),
('01','01','A015','UN','0',3,7,10.00),
('01','01','A016','UN','0',3,7,1.00),
('01','01','A017','UN','0',3,7,1.00),
('01','01','A018','UN','0',3,7,2.00),
('01','01','A019','UN','0',3,7,1.00),
('01','01','A020','UN','0',3,7,1.00),
('01','01','A021','UN','0',3,7,3.00),
('01','01','A022','UN','0',3,7,1.00),
('01','01','A023','UN','0',3,7,4.00),
('01','01','A024','UN','0',3,7,1.00),
('01','01','A025','UN','0',3,7,1.00),
('01','01','A026','UN','0',3,7,2.00),
('01','01','A027','UN','0',3,7,2.00),
('01','01','A028','UN','0',3,7,2.00),
('01','01','A029','UN','0',3,7,1.00),
('01','01','A030','UN','0',3,7,1.00),
('01','01','A031','UN','0',3,7,2.00),
('01','01','A032','UN','0',3,7,1.00),
('01','01','A033','UN','0',3,7,1.00),
('01','01','A034','UN','0',3,7,1.00),
('01','01','A035','UN','0',3,7,1.00),
('01','01','A036','UN','0',3,7,1.00),
('01','01','A037','UN','0',3,7,1.00),
('01','01','A038','UN','0',3,7,2.00),
('01','01','A039','UN','0',3,7,4.00),
('01','01','A040','UN','0',3,7,2.00),
('01','01','A041','UN','0',3,7,3.00),
('01','01','A042','UN','0',3,7,1.00),
('01','01','A043','UN','0',3,7,1.00),
('01','01','A044','UN','0',3,7,2.00),
('01','01','A045','UN','0',3,7,3.00),
('01','01','A046','UN','0',3,7,2.00),
('01','01','A047','UN','0',3,7,3.00),
('01','01','A048','UN','0',3,7,1.00),
('01','01','A049','UN','0',3,7,2.00),
('01','01','A050','UN','0',3,7,2.00),
('01','01','A051','UN','0',3,7,2.00),
('01','01','A052','UN','0',3,7,1.00),
('01','01','A053','UN','0',3,7,2.00),
('01','01','A054','UN','0',3,7,2.00),
('01','01','A055','UN','0',3,7,3.00),
('01','01','A056','UN','0',3,7,3.00),
('01','01','A057','UN','0',3,7,2.00),
('01','01','A058','UN','0',3,7,1.00),
('01','01','A059','UN','0',3,7,1.00),
('01','01','A060','UN','0',3,7,2.00),
('01','01','A061','UN','0',3,7,1.00),
('01','01','A062','UN','0',3,7,1.00),
('01','01','A063','UN','0',3,7,1.00),
('01','01','A064','UN','0',3,7,2.00),
('01','01','A065','UN','0',3,7,1.00),
('01','01','A066','UN','0',3,7,1.00),
('01','01','A067','UN','0',3,7,1.00),
('01','01','A068','UN','0',3,7,1.00),
('01','01','A069','UN','0',3,7,1.00),
('01','01','A070','UN','0',3,7,1.00),
('01','01','A071','UN','0',3,7,1.00),
('01','01','A072','UN','0',3,7,1.00),
('01','01','A073','UN','0',3,7,1.00),
('01','01','A074','UN','0',3,7,1.00),
('01','01','A075','UN','0',3,7,1.00),
('01','01','A076','UN','0',3,7,1.00),
('01','01','A077','UN','0',3,7,2.00),
('01','01','A078','UN','0',3,7,4.00),
('01','01','A079','UN','0',3,7,4.00),
('01','01','A080','UN','0',3,7,4.00),
('01','01','A081','UN','0',3,7,4.00),
('01','01','A082','UN','0',3,7,4.00),
('01','01','A083','UN','0',3,7,4.00),
('01','01','A084','UN','0',3,7,2.00),
('01','01','A085','UN','0',3,7,2.00),
('01','01','A086','UN','0',3,7,3.00),
('01','01','A087','UN','0',3,7,4.00),
('01','01','A088','UN','0',3,7,8.00),
('01','01','A089','UN','0',3,7,7.00),
('01','01','A090','UN','0',3,7,5.00),
('01','01','A091','UN','0',3,7,9.00),
('01','01','A092','UN','0',3,7,7.00),
('01','01','A093','UN','0',3,7,11.00),
('01','01','A094','UN','0',3,7,8.00),
('01','01','A095','UN','0',3,7,9.00),
('01','01','A096','UN','0',3,7,8.00),
('01','01','A097','UN','0',3,7,9.00),
('01','01','A098','UN','0',3,7,5.00),
('01','01','A099','UN','0',3,7,5.00),
('01','01','A100','UN','0',3,7,9.00),
('01','01','A101','UN','0',3,7,4.00),
('01','01','A102','UN','0',3,7,9.00),
('01','01','A103','UN','0',3,7,5.00),
('01','01','A104','UN','0',3,7,6.00),
('01','01','A105','UN','0',3,7,3.00),
('01','01','A106','UN','0',3,7,6.00),
('01','01','A107','UN','0',3,7,2.00),
('01','01','A108','UN','0',3,7,3.00),
('01','01','A108','UN','0',4,10,1.00),
('01','01','A109','UN','0',3,7,4.00),
('01','01','A110','UN','0',3,7,4.00),
('01','01','A111','UN','0',3,7,4.00),
('01','01','A112','UN','0',3,7,4.00),
('01','01','A113','UN','0',3,7,3.00),
('01','01','A114','UN','0',3,7,2.00),
('01','01','A115','UN','0',3,7,6.00),
('01','01','A116','UN','0',3,7,2.00),
('01','01','A117','UN','0',3,7,4.00),
('01','01','A118','UN','0',3,7,4.00),
('01','01','A119','UN','0',3,7,4.00),
('01','01','A120','UN','0',3,7,4.00),
('01','01','A121','UN','0',3,7,1.00),
('01','01','A122','UN','0',3,7,6.00),
('01','01','A123','UN','0',3,7,4.00),
('01','01','A124','UN','0',3,7,5.00),
('01','01','A125','UN','0',3,7,4.00),
('01','01','A126','UN','0',3,7,5.00),
('01','01','A127','UN','0',3,7,4.00),
('01','01','A128','UN','0',3,7,4.00),
('01','01','A129','UN','0',3,7,3.00),
('01','01','A130','UN','0',3,7,4.00),
('01','01','A131','UN','0',3,7,3.00),
('01','01','A132','UN','0',3,7,3.00),
('01','01','A133','UN','0',3,7,5.00),
('01','01','A134','UN','0',3,7,4.00),
('01','01','A135','UN','0',3,7,4.00),
('01','01','A136','UN','0',3,7,4.00),
('01','01','A137','UN','0',3,7,4.00),
('01','01','A138','UN','0',3,7,6.00),
('01','01','A139','UN','0',3,7,6.00),
('01','01','A140','UN','0',3,7,7.00),
('01','01','A141','UN','0',3,7,3.00),
('01','01','A142','UN','0',3,7,5.00),
('01','01','A143','UN','0',3,7,1.00),
('01','01','A144','UN','0',3,7,6.00),
('01','01','A145','UN','0',3,7,1.00),
('01','01','A146','UN','0',3,7,2.00),
('01','01','A147','UN','0',3,7,1.00),
('01','01','A148','UN','0',3,7,2.00),
('01','01','A149','UN','0',3,7,3.00),
('01','01','A150','UN','0',3,7,4.00),
('01','01','A151','UN','0',3,7,5.00),
('01','01','A152','UN','0',3,7,3.00),
('01','01','A153','UN','0',3,7,6.00),
('01','01','A154','UN','0',3,7,5.00),
('01','01','A155','UN','0',3,7,1.00),
('01','01','A156','UN','0',3,7,8.00),
('01','01','A157','UN','0',3,7,14.00),
('01','01','A158','UN','0',3,7,4.00),
('01','01','A159','UN','0',3,7,3.00),
('01','01','A160','UN','0',3,7,3.00),
('01','01','A161','UN','0',3,7,4.00),
('01','01','A162','UN','0',3,7,7.00),
('01','01','A163','UN','0',3,7,3.00),
('01','01','A164','UN','0',3,7,4.00),
('01','01','A165','UN','0',3,7,2.00),
('01','01','A166','UN','0',3,7,3.00),
('01','01','A166','UN','0',4,10,1.00),
('01','01','A167','UN','0',3,7,2.00),
('01','01','A168','UN','0',3,7,5.00),
('01','01','A169','UN','0',3,7,9.00),
('01','01','A170','UN','0',3,7,6.00),
('01','01','A171','UN','0',3,7,7.00),
('01','01','A172','UN','0',3,7,2.00),
('01','01','A173','UN','0',3,7,7.00),
('01','01','A174','UN','0',3,7,5.00),
('01','01','A175','UN','0',3,7,6.00),
('01','01','A176','UN','0',3,7,8.00),
('01','01','A177','UN','0',3,7,8.00),
('01','01','A178','UN','0',3,7,2.00),
('01','01','A179','UN','0',3,7,10.00),
('01','01','A180','UN','0',3,7,7.00),
('01','01','A181','UN','0',3,7,5.00),
('01','01','A182','UN','0',3,7,5.00),
('01','01','A183','UN','0',3,7,8.00),
('01','01','A184','UN','0',3,7,7.00),
('01','01','A185','UN','0',3,7,5.00),
('01','01','A186','UN','0',3,7,6.00),
('01','01','A187','UN','0',3,7,7.00),
('01','01','A188','UN','0',3,7,6.00),
('01','01','A189','UN','0',3,7,1.00),
('01','01','A190','UN','0',3,7,1.00),
('01','01','A191','UN','0',3,7,3.00),
('01','01','A192','UN','0',3,7,6.00),
('01','01','A193','UN','0',3,7,9.00),
('01','01','A194','UN','0',3,7,5.00),
('01','01','A195','UN','0',3,7,3.00),
('01','01','A196','UN','0',3,7,5.00),
('01','01','A197','UN','0',3,7,7.00),
('01','01','A198','UN','0',3,7,5.00),
('01','01','A199','UN','0',3,7,4.00),
('01','01','A200','UN','0',3,7,3.00),
('01','01','A201','UN','0',3,7,2.00),
('01','01','A202','UN','0',3,7,2.00),
('01','01','A203','UN','0',3,7,7.00),
('01','01','A204','UN','0',3,7,2.00),
('01','01','A205','UN','0',3,7,2.00),
('01','01','A206','UN','0',3,7,4.00),
('01','01','A207','UN','0',3,7,4.00),
('01','01','A208','UN','0',3,7,6.00),
('01','01','A209','UN','0',3,7,4.00),
('01','01','A210','UN','0',3,7,2.00),
('01','01','A211','UN','0',3,7,3.00),
('01','01','A212','UN','0',3,7,6.00),
('01','01','A213','UN','0',3,7,3.00),
('01','01','A214','UN','0',3,7,3.00),
('01','01','A215','UN','0',3,7,2.00),
('01','01','A216','UN','0',3,7,4.00),
('01','01','A217','UN','0',3,7,9.00),
('01','01','A218','UN','0',3,7,1.00),
('01','01','A219','UN','0',3,7,11.00),
('01','01','A220','UN','0',3,7,4.00),
('01','01','A221','UN','0',3,7,4.00),
('01','01','A222','UN','0',3,7,2.00);

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
  `monto` decimal(10,2) DEFAULT NULL,
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
  `monto` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja_com`,`ser_mov_caja_com`,`nro_mov_caja_com`,`tipo_transaccion`,`sub_tipo_transaccion`),
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
('ADMIN','ADMINISTRACION DEl SISTEMA'),
('COMPRAS','COMPRAS'),
('GERENCIA','ADMINISTRACION Y GERENCIA'),
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
(1,'2019-12-08',NULL,120000,'01','CAJ1','WLOPEZ','H'),
(2,'2020-08-17',NULL,0,'01','CAJ1','VENTAS','H'),
(3,'2020-08-17',NULL,0,'01','CAJ1','RTORRES','H');

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
('PRUE','PRUEBA'),
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
  `total_mov_caja_com` decimal(10,2) DEFAULT NULL,
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
  `total_mov_caja` decimal(10,2) DEFAULT NULL,
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
  `total_comprobante_com` decimal(10,2) DEFAULT NULL,
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
  `total_comprobante` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`tipo_mov_caja`,`ser_mov_caja`,`nro_mov_caja`,`cod_sucursal`,`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`),
  KEY `FK_MOV_COMP_VEN_SUC` (`cod_sucursal`),
  CONSTRAINT `FK_MOV_COMP_VEN_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movimiento_comprobante_venta` */

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
) ENGINE=InnoDB AUTO_INCREMENT=2492 DEFAULT CHARSET=utf8;

/*Data for the table `persona` */

insert  into `persona`(`cod_persona`,`nombre`,`cod_tipo_doc`,`ruc_ci`,`cod_ciudad`,`direccion`,`direccion_trabajo`,`telefono_domicilio`,`telefono_trabajo`,`celular`,`fecha_nacimiento`,`cod_estado_civil`,`cod_pais`,`es_banco`) values 
(1,'ADMINISTRADOR DEL SISTEMA',NULL,NULL,1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'FREDY GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,'ABEL BAEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'ADELA MARIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,'ADELIA SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(7,'ADRIAN DOMINGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(9,'ADRIANA NALENHO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(10,'AGUSTIN VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(11,'AGUSTINA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(15,'AGUSTINA LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(19,'ALAN CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(22,'ALBERTO DAMIAN GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(23,'ALBERTO GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(27,'ALCIDES LEGUIZAMION',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(28,'ALCIDES RAMOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(29,'ALDO GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(32,'ALDO GONZALEZ ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(33,'ALDO RIQUELME',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(34,'ALEJANDRO ALVARENGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(38,'ALFREDO AGUILERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(39,'ALFREDO JARA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(40,'ALICIA HERMOSILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(41,'ALMA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(44,'AMADA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(45,'ANA LIZ CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(46,'ANA LIZ FERREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(48,'ANA OVELAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(50,'ANA PALACIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(51,'ANA RODAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(54,'ANA T CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(55,'ANALICIA ARANDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(57,'ANASTACIO MEDINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(59,'ANDREA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(61,'ANDREA RECALDE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(64,'ANDRES FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(66,'ANDRES SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(68,'ANGEL GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(69,'ANGEL OVIEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(70,'ANGELA AQUINO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(73,'ANGELA TRINIDAD',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(74,'ANIBAL SEGOVIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(76,'ANTOLIN AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(78,'ANTONIA BAEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(79,'ANTONIA ESPINOSA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(81,'ANTONIA MORENO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(82,'ANTONIA RECALDE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(84,'ANTONIA VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(85,'ANTONIO CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(89,'ANTONIO PRESENTADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(91,'ANUNCIA CHAVEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(92,'APU',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(93,'ARNALDO BERNAL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(95,'ARNALDO LOBOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(96,'ARNALDO MEZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(97,'ARSENIO GRANCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(98,'ASENCION CABANHAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(99,'ATILIO SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(102,'AUGUSTO RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(104,'AXEL CORONEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(105,'BANIA RAMIREZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(106,'BARCILIZO FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(108,'BASILIA MORA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(111,'BENJAMINA GRANCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(115,'BIENVENIDO BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(116,'BLANCA CRISTALDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(120,'BLANCA ESPINOLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(121,'BLANCA VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(123,'BLAS MARTIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(124,'BLASIDA GALEANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(126,'CANDELARIA AQUINO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(129,'CARLOS ARIEL GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(130,'CARLOS BARRIENTOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(131,'CARLOS BRITOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(132,'CARLOS CANTERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(135,'CARLOS CORONEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(136,'CARLOS DANIEL GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(138,'CARLOS GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(140,'CARLOS MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(142,'CARLOS RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(143,'CARLOS SANABRIA DE LA CUEVA','CI','6183447',1,'CAACUPEMI',NULL,'0971275634',NULL,NULL,NULL,NULL,NULL,'N'),
(145,'CARMEN JARA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(147,'CARMEN MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(148,'CAROLINA BRITOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(153,'CATALINA CARDOZO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(154,'CATALINA ZARATE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(155,'CECILIA MELGAREJO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(157,'CECILIA RECALDE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(158,'CECILIO OVIEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(159,'CELESTINA OVELAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(161,'CELINA FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(162,'CELSO MACIEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(163,'CESAR  GALEANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(164,'CESAR DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(167,'CHRISTIAN FLEITAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(169,'CHRISTIAN OCAMPOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(171,'CHRYSTIAN SANTACRUZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(172,'CINTHIA DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(173,'CIRENIO DE LEON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(174,'CIRILA SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(178,'CLARA DE VILLAGRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(180,'CLAUDELINO ZEBALLOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(181,'CLAUDIA BENTOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(182,'CLEMENTE GARCETE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(183,'CLEMENTINA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(184,'CONSTANCIA AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(185,'CRISPIN ARANDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(186,'CRISTHIAN ALVARENGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(189,'CRISTHIAN AVILA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(191,'CRISTHIAN DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(194,'CRISTHIAN GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(195,'CRISTHIAN MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(197,'CRISTHIAN VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(199,'CRISTIAN AGUAYO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(200,'CRISTIAN BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(201,'CRISTIAN GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(204,'CRISTIAN RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(206,'CRISTINA LAZZARO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(207,'CRISTINA MEDINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(208,'CRISTINA ROBLES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(209,'CRISTINA ZARATE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(211,'CRISTOBAL CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(212,'CRISTOBAL LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(213,'CRISTOBAL RIVEROS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(214,'CYNTHIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(217,'CYNTHIA ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(218,'DANI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(220,'DANI SILVA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(222,'DANIEL ALMIRON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(223,'DANIEL COLMAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(224,'DANIELA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(225,'DANILO LEIVA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(226,'DAPHJNE RICHER',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(227,'DARIO CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(228,'DAVID MEDINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(229,'DAYSI OLAZAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(231,'DELIA MARIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(234,'DENIS DERLIS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(235,'DERLIS BARRETO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(236,'DERLIS GRANCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(237,'DERLIS PRIETO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(240,'DERLIS SANTACRUZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(241,'DERLIZ BRITOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(242,'DERLIZ DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(244,'DERLIZ LEDESMA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(245,'DERLIZ PERALTA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(247,'DIANA FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(248,'DIEGO INSFRAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(249,'DIEGO TORALES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(250,'DIONISIA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(251,'DIONISIA URBIETA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(252,'DIONISIO RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(253,'DIOSNEL FERNANDEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(256,'DOMINGA GALEANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(258,'DOMINGO BARRETO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(259,'DOMINGO DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(262,'DORITA MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(264,'EDGAR AGUILERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(265,'EDGAR AQUINO LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(268,'EDGAR ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(269,'EDITH HERMOSILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(271,'EDUARDO FRETES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(273,'ELENA GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(274,'ELENO NUNHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(276,'ELEUTERIA CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(277,'ELEUTERIO RIVAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(279,'ELIAS CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(281,'ELIDA CHAVEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(282,'ELIODORO SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(283,'ELIODORO VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(284,'ELISA FRUTOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(287,'ELIZABETH BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(289,'ELIZABETH SANTACRUZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(290,'ELIZABETH SOSA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(291,'ELSA ARAUJO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(294,'ELVIO ARZAMENDIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(297,'EMIGDIO ROJAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(298,'EMILCE FERREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(300,'ENRIQUE GARCIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(303,'EPIFANIO MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(304,'EPIFANIO RODAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(307,'ESTHER KIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(309,'EUGENIO LEIVA PROF',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(310,'EULALIA FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(314,'EUSEBIA CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(315,'EUSEBIO FRETES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(318,'EUSEBIO ROJAS VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(319,'EVELIN GALEANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(320,'EVELIN RODAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(322,'EVER CABANHAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(323,'EVER GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(324,'EVER VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(329,'FABIOLA ROJAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(333,'FAUSTINO BOGADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(334,'FEDERICO ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(335,'FEDERICO FLORES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(336,'FEDERICO URBIETA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(337,'FELICIA PENAYO JORGE SALINAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(340,'FERMIN GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(342,'FERNANADO GRANCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(343,'FERNANDO AYALA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(344,'FERNANDO GRANCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(345,'FERNANDO OVELAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(346,'FIDEL OVIEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(347,'FLORENCIO RAMIREZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(349,'FLORENTINA MONGES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(351,'FRANCISCA ALEGRE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(356,'FRANCISCA VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(357,'FRANCISCO ACUNHA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(358,'FRANCISCO AYALA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(359,'FRANCISCO ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(360,'FRANCISCO LEZCANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(361,'FRANCISCO LEZCANO SILVA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(362,'FRANCISCO RAMOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(363,'FRANCISCO TALAVERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(366,'FREDY FERREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(367,'GABRIEL ORTEGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(369,'GABRIEL SUAREZ CENTURION','CI','6552632',1,'CAACUPEMI',NULL,'0984619193',NULL,NULL,NULL,'SOL',1,'N'),
(370,'GENARO ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(371,'GERARDO ARANDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(373,'GERARDO VEGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(378,'GERONIMO BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(379,'GESSICA GARCETE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(380,'GILBERTA PEREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(382,'GLADIS GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(384,'GLORIA AGUILAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(385,'GLORIA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(386,'GLORIA BERNAL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(387,'GLORIA ESTIGARRIBIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(388,'GLORIA VELAZQUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(389,'GLORIA VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(390,'GRACIELA GALEANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(395,'GUILLERMO  VELOSO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(396,'GUILLERMO LEGUIZAMON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(397,'GUSTAVO BAREIRO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(400,'GUSTAVO MEDINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(401,'GUSTAVO NOGUERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(402,'GUSTAVO SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(403,'GUSTAVO VALLEJOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(404,'HECTOR BALBUENA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(405,'HECTOR PALACIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(412,'HERMINIO RIVAROLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(413,'HERNAN OVELAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(414,'HILARION RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(417,'HILDA ACOSTA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(418,'HIPOLITO LEGUIZAMON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(420,'HUGO ARCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(421,'HUGO ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(422,'HUGO ESPINOLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(425,'HUGO MANCUELLO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(426,'HUGO ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(427,'HUMBERTO FRETES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(431,'IDALINO GOMEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(434,'IDALIO OLAZAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(435,'IGNACIA GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(437,'INOCENCIA FALCON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(438,'IREON ARECO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(439,'IRIS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(441,'IRMA ACOSTA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(444,'ISAAC RIQUELME',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(447,'ISABEL RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(450,'ISAIAS ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(451,'ISIDORO MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(452,'ISMAEL LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(453,'IVAN PEREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(454,'JAIME GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(455,'JAVIER BAEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(457,'JAVIER CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(458,'JAVIER DELGADILLO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(459,'JAVIER DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(462,'JAZMIN JARA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(464,'JESSICA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(467,'JESSICA FLEITAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(468,'JESSICA NUNHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(470,'JESUS MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(471,'JOEL AQUINO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(472,'JOEL GALEANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(473,'JONATHAN MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(474,'JORGE AVILA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(475,'JORGE ENRIQUE VELAZQUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(476,'JORGE GONZALEZ Y PERLA COHENE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(477,'JORGE JARA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(478,'JORGE LUGO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(479,'JORGE VELAZQUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(480,'JORGE VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(484,'JOSE CARLOS LEDESMA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(486,'JOSE ESQUIVEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(487,'JOSE GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(490,'JOSE LUIS BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(494,'JOSE LUIS RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(497,'JOSE VIERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(498,'JOVINO VILLORDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(502,'JUAN CABANHAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(504,'JUAN CARLOS NUNHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(505,'JUAN CARLOS SEGOBIA X BOBADILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(507,'JUAN DANILO GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(508,'JUAN ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(509,'JUAN FRETES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(510,'JUAN GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(513,'JUAN HIDALGO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(514,'JUAN LEZCANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(516,'JUAN MARTIN GUERRERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(518,'JUAN PABLO  ORTEGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(519,'JUAN PABLO CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(520,'JUAN PASMOR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(523,'JUAN PRESENTADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(525,'JUAN RAMON FLEYTAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(529,'JUANA ARGUELLO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(532,'JUANA DELGADO DE RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(534,'JUANA GARCIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(535,'JUANA MARIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(536,'JUANA SILVA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(537,'JULIAN BOGADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(539,'JULIAN ORTEGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(541,'JULIAN RIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(542,'JULIANA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(543,'JULIO ALMIRON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(545,'JULIO CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(550,'JULIO CESAR ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(552,'JULIO CESAR VILLAGRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(554,'JULIO PORTILLO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(555,'JULIO RIVEROS   ANG AQUINO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(558,'JUNNIOR OZUNA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(559,'JUSTINA BENEGAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(560,'JUSTINO VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(561,'JUSTO ARCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(562,'KATERIN BAEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(564,'KATHERIN PRESENTADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(565,'LARISSA ALARCON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(568,'LARISSA RAMIREZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(569,'LAURA BRITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(570,'LAURA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(571,'LAURA FERNANDEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(572,'LAURA VILLASANTI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(573,'LEONGINA BOGADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(575,'LEONIDAS CABANHAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(577,'LEONOR CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(580,'LETTICIA DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(581,'LIBRADA GONZALEZ  MAURI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(583,'LIBRADO VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(585,'LIDER MONGELOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(586,'LIDIA AGUILERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(589,'LILIAN CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(590,'LILIAN CANDIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(591,'LILIAN CASTILLO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(593,'LILIAN GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(594,'LILIAN JARA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(595,'LILIAN LEIVA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(599,'LILIAN VALLEJOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(600,'LILIANA CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(602,'LIMPIA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(604,'LIZ BENEGAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(605,'LIZ BERNAL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(607,'LIZ CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(609,'LIZ CORONEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(610,'LIZ DEL CARMEN CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(613,'LIZ LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(614,'LIZ PAOLA DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(615,'LIZ RIVAROLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(620,'LORENA CARVAJAL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(623,'LUCAS PEREZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(625,'LUCERO BARRIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(626,'LUCIA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(630,'LUCIO FLORENTIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(631,'LUCIO GARCIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(632,'LUIS A. GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(633,'LUIS ALBERTO IBARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(634,'LUIS DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(637,'LUIS ENRIQUE BIGADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(638,'LUIS FERREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(640,'LUIS GAMARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(641,'LUIS GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(649,'LUIS MOREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(650,'LUIS MOREL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(651,'LUIS P MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(655,'LURDE DAVALOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(656,'LUZ BENEGAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(659,'LUZ LUGO RIVEROS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(661,'LUZ M. CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(662,'LUZ MATTO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(666,'MABEL ORTIGOZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(667,'MACARIO BRITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(668,'MANUELA PIRIS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(670,'MARCELINO TORRES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(671,'MARCELO ALONSO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(672,'MARCELO PAVON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(673,'MARCO LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(674,'MARCOS ANTONIO SARUBI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(676,'MARCOS CANHETE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(677,'MARCOS CARDOZO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(679,'MARCOS OJEDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(684,'MARCOS SANGUINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(685,'MARGARITA ROMAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(686,'MARIA ADELADIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(687,'MARIA ALMIRON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(688,'MARIA AMARILLA ALEGRE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(690,'MARIA BELEN ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(692,'MARIA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(693,'MARIA C. URQUIZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(694,'MARIA CACERES VDA DE LA ESPADA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(695,'MARIA CHAVEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(696,'MARIA DE LUGO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(698,'MARIA DOMINGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(699,'MARIA DUMONT  X JOEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(700,'MARIA E INSFRAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(701,'MARIA E. MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(702,'MARIA ELIZABETH MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(703,'MARIA ELIZABETH RIVAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(705,'MARIA ESTELA QUINTANA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(706,'MARIA GLORIA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(707,'MARIA GRACIELA MALDONADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(709,'MARIA IDALIA DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(710,'MARIA ISABEL CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(711,'MARIA L OLMEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(712,'MARIA LOURDES CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(713,'MARIA LUCIA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(714,'MARIA LUISA AQUINO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(716,'MARIA MORA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(717,'MARIA NICOLASA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(719,'MARIA P GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(720,'MARIA PABLA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(721,'MARIA ROA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(722,'MARIA RODAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(726,'MARIA VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(728,'MARIAN CANHETE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(729,'MARIELA AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(735,'MARIELA OJEDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(738,'MARIN GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(741,'MARIO LARROZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(744,'MARIO MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(746,'MARIO RODAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(747,'MARIO ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(748,'MARIO VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(749,'MARISOL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(750,'MARITE VARELA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(751,'MARIZA CORONEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(756,'MARLENE NARVAEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(757,'MARTA FIGUEREDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(758,'MARTA ROLON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(759,'MARTIN GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(760,'MATIAS BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(761,'MELANIA ESPINOLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(762,'MELISSA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(763,'MERCEDES CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(764,'MERCEDES SANTACRUZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(765,'MICHEL DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(766,'MIGDONIO SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(771,'MIGUEL ANGEL ARCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(774,'MILCA ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(776,'MILCIADES GAMARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(777,'MILCIADES OVIEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(778,'MILVA PRESENTADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(779,'MIRIAN BAEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(780,'MIRIAN BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(781,'MIRIAN CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(782,'MIRIAN CABRERA  SOTO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(784,'MIRIAN LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(786,'MIRTHA ALVARENGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(787,'MIRTHA BEATRIZ RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(790,'MIRTHA MERCEDES RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(794,'MODESTO CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(795,'MOIGDONIO SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(798,'MYRIAM TORRES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(799,'NADIA DE VOUGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(803,'NADIA GOMEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(804,'NADIA MENDOZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(806,'NANCY OJEDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(807,'NANCY PEREZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(808,'NANCY RIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(809,'NANCY SIMMERLI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(810,'NATIVIDAD AGUILERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(811,'NELSON BARRIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(814,'NELSON GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(815,'NELSON ROLON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(820,'NERY GARCIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(822,'NICANORA DE LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(823,'NICOMEDES GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(824,'NIDIA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(827,'NIDIA PAREDES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(828,'NILDA ARANDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(829,'NILDA LOPEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(832,'NIMIA LEGUIZAMON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(833,'NIMIA REYES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(834,'NIMIA VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(835,'NIMIO SANTACRUZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(837,'NOELIA DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(839,'NOELIA OLMEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(840,'NOELIA OZUNA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(842,'NORMA BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(846,'NORMA CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(847,'NORMA SOSA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(848,'NORWIS ZAYAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(850,'OLIVER MENDOZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(853,'OSCAR CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(854,'OSCAR GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(855,'OSCAR ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(856,'OSVALDO RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(857,'OSVALDO VEGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(858,'OVIDIO BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(859,'PABLA GAMARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(861,'PABLO CABALLERO OCAMPOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(863,'PABLO ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(864,'PAOLA GUZMAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(866,'PATRICIO RIVAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(867,'PATROCINIA HERMOSILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(869,'PEDRO BENEGAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(870,'PEDRO CESAR CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(871,'PEDRO ESCOBAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(872,'PEDRO HIDALGO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(874,'PEDRO NUNHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(876,'PEDRO OVIEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(878,'PEDRO RODAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(881,'PERLA OVELAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(883,'PETRONA ARCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(884,'PORFIRIO INCHAUSTI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(885,'RAFAELA CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(887,'RALT RAMON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(888,'RAMON ARZAMENDIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(889,'RAMON FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(890,'RAMON ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(894,'RANULFO VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(895,'RAQUEL DOSANTOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(897,'RAUL PATINHO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(898,'REINALDO FERREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(899,'REINALDO OSORIO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(904,'RENE GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(905,'REY SALOMON AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(906,'RICARDO ROJAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(907,'RICARDO SIMMERLI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(908,'RICHARD JARA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(911,'ROBERTO BAZAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(912,'ROBERTO BOBADILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(915,'ROCIO ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(916,'RODNEY ACOSTA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(917,'RODNEY CONDORI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(919,'RODRIGO CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(920,'RODRIGO GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(922,'RODRIGO SEGOVIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(923,'RODRIGO TORRES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(925,'ROLANDO HAEDO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(927,'ROMAN BARRIOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(928,'ROMAN DOMINGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(930,'ROSA CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(931,'ROSALBA CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(935,'ROSALINA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(937,'ROSANA HERMOSILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(940,'ROSSANA NUNHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(942,'ROZULA SUARES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(943,'RUBEN MACIEL',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(946,'RUBEN VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(949,'SALOMON AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(954,'SANDRA PEREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(955,'SANDRA RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(956,'SANDRA SILVERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(957,'SANTIAGO GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(958,'SANTIAGO RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(959,'SANTIAGO VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(960,'SARA BORJAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(963,'SATURNINO ALMEIDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(964,'SERGIO ARISTIQUI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(967,'SILA ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(968,'SILVANA FLEYTAS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(969,'SILVERIO FRUTOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(971,'SILVIA ROLON',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(973,'SILVIA SOTO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(975,'SILVIO JAVIER BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(977,'SINDULFO ARCE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(980,'SIXTO LEZCANO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(981,'SIXTO MEDINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(982,'SOLEDAD BALBUENA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(985,'SUSANA ESTIGARRIBIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(990,'TANIA GARCIA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(992,'TEODORA SUSANA MILTOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(997,'TEONILA SANCHEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1000,'TERESA ARANDA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1005,'TERESA FRANCO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1006,'TERESA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1008,'TIBURCIO PRESENTADO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1009,'TOMASA RAMOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1010,'ULISES BALBUENA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1011,'ULISES GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1012,'VALENTIN GAMARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1013,'VALERIANA AGUILERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1015,'VALERIO ALMADA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1016,'VERONICA IRALA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1017,'VICENTE ORTEGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1018,'VICENTE SARUBI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1020,'VICTOR AVALOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1021,'VICTOR CABRERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1023,'VICTOR CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1024,'VICTOR CASTILLO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1025,'VICTOR GAMARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1026,'VICTOR OLAZAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1027,'VICTOR RODRIGUEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1029,'VICTOR SIMMERLI',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1032,'VICTOR VERA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1036,'VIDALINA MORENO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1037,'VIRGILIA ALVARENGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1040,'VIRGILIO AMARILLA PAPA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1041,'VIRGILIO AMARILLA REY',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1043,'VIVIANA FRETES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1044,'VIVIANA HERMOSILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1047,'WILFRIDO ORTIZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1048,'WILFRIDO PAIVA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1050,'WILFRIDO VILLALBA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1052,'WILLIAM CABALLERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1054,'YAMILHE BURGOS',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1055,'YENNY GAONA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1056,'YESSICA FERNANDEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1059,'YESSICAFERREIRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1060,'YHONI ROMERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1063,'YIYA ENCINA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1065,'YOLANDA AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1068,'YSIDRO OVELAR',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1072,'ZENON MARTINEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1074,'ZULLY GAMARRA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1077,'ZUNILDA AMARILLA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1079,'ZUNILDA DUARTE',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1081,'ZUNILDA RUIZ DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1082,'DIEGO CORONEL',NULL,'4109720',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1083,'DESIDERIO INSFRAN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1084,'ADELA MARIN ACOSTA',NULL,'2056166',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1085,'ALMA GOMEZ ESPINOLA',NULL,NULL,5,'MANUELORTIZ GY EUCALIPTO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1086,'EVER CABRERA',NULL,'5933743',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1087,'VICENTE FERNANDEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1090,'VICTOR CARTES',NULL,'1249866',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1091,'CESAR SERVIN',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1092,'CESAR GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1093,'JULIANA DIAZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1094,'PABLA SANDOVAL',NULL,NULL,1,'SENTAMINTO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1095,'ALFREDO GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1096,'LETICIA SANCHEZ',NULL,'6215985',1,'CAACUPEMI HNA DE GERARDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1098,'LILIAN GIMENEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1101,'ADRIAN BRITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1103,'PEDRO MENDOZA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1105,'GERMAN ESPINOLA',NULL,'5097538',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1106,'RAMON CACERES',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1107,'ALEJANDRA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1109,'GERARDO SANCHEZ',NULL,'4669368',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1110,'FREDDI BORDON',NULL,NULL,1,'CAACUPEMI FRACCION SAN LUIS 1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1111,'CINTHIA BENITEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1113,'PABLO NU;EZ',NULL,NULL,3,'3 DE MAYO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1114,'ELSA DE MARTINEZ',NULL,'1231429',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1115,'JESSICA GUERRERO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1116,'ROMINA FRANCO RAMOS',NULL,NULL,1,'CAACUPEMI NORWIS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1117,'ARIEL OSORIO',NULL,NULL,1,'CAACUPEMI SANTA LIBRADA -REINALDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1118,'ROSALIA GONZALEZ',NULL,NULL,1,'TAYI POTY CERCA DE ESCUELA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1119,'GABRIELA GONZALEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1120,'EMILIO INSFRAN R',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1123,'ROQUE MIGUEL BENITEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1124,'LUZ RUIZ DIAZ',NULL,'4530762',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1126,'VICENTE GONZALEZ',NULL,'1776639',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1127,'CRISTIAN FERNANDEZ',NULL,NULL,1,'CAACUPEMI ALDO FERN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1130,'FATIMA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1132,'FIDELINA ORTIZ',NULL,'4311632',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1133,'WILLIAN RAMOS',NULL,'3646236',1,'VILLA DOS NORWIS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1134,'LAURA GONZALEZ GIMENEZ',NULL,NULL,1,'ENTREGA A CUENTA HELAD. COC. VENT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1135,'KATHIA ORTIZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1137,'FREDY GIMENEZ',NULL,'5195227',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1138,'MILCIADES ARZAMENDIA',NULL,NULL,1,'C9025',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1139,'FREDDY IBARROLA',NULL,NULL,1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1141,'TEO ÑA TEO',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1142,'JORGE DANIEL FRANCO',NULL,'3776804',1,'CUÑADO DE MARIA BENITEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1143,'HILDA ROTELA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1145,'JESSICA SILVA',NULL,'1',1,'C/EDGSR FERREIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1146,'ROSA VILLAMAYOR',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1147,'RAQUEL DEL BORDEN',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1148,'NESTOR RAMIREZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1149,'ROSSANA PEREZ',NULL,'3933420',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1150,'CLAUDIA JARA',NULL,'4403918',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1151,'JULIO CESAR CACERES',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1152,'DELICIA PEREZ',NULL,NULL,1,'LUQUE MAMA DE ROSSANA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1154,'CESAR GRANCE',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1155,'MARIA AGUIAR',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1156,'CECILIO  DELGADO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1158,'MARIO FERNANDEZ',NULL,'5',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1159,'CRISTHIAN VILLAMAYOR',NULL,'5187778',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1160,'LIZ MOREIRA',NULL,NULL,1,'VIVE EN WILFRIDO PAIVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1161,'LUIS ALBERTO VELAZQUEZ NALERIO',NULL,NULL,1,'PRIMO DE RODRIGO GONZALEZ 9055',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1162,'CARLOS NOTARIO IRALA',NULL,'4507345',1,'VILLA SALVADOR GREORIA ORTIZ  9055',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1163,'ROSA VEGA GIMENEZ',NULL,'4450280',1,'ARA PYAHU II NIS 2761036 ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1164,'NIDIA CABALLERO',NULL,NULL,1,'DETRAS DE RENE HNA. DE ROSALBA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1165,'VICTOR RUBEN CABRERA',NULL,'11',1,'SOLDADOR = 9057',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1166,'ADELIO MALDONADO MIRET',NULL,'1730264',1,'REC EMILO INSFRAN DETRAS DE GUMERC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1168,'JUSTINO GIMENEZ',NULL,'1234',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1170,'JUAN CARLOS PEREIRA',NULL,NULL,1,'VECINO DE FREDDI BORDON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1171,'CHICHA',NULL,NULL,1,'CUBIERTAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1172,'MARICEL RIVERA GIMENEZ',NULL,'2934581',1,'AS. BELEN / SUSANA ESTG. 9061',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1174,'AURORA DUARTE BRIZUELA',NULL,'1767440',1,'CERCA DE KALAITO A 4 CASAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1175,'MAURICIO SANCHEZ ROMERO',NULL,'6352362',1,'VECINO DE PERLA OVELAR ASENT.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1176,'RODRIGO GONZALEZ C',NULL,NULL,1,'COCUE GUAZU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1177,'JORGE DANIEL GONZALEZ LOPEZ',NULL,'4621972',1,'PINDOLO CAMINO A ITUGUA LAVADERO JULIAN GAONA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1179,'LIZ MARIA LOPEZ RUIZ DIAZ',NULL,NULL,1,'HERMANA DE MYRIAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1180,'MAXIMA VICTORIA SOTELO PERALTA',NULL,'4341382',1,'NHANDEROGA RA CERCA FLIA PERA;TA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1183,'YENY MARTA PRESENTADO PORTILLO',NULL,'2601932',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1186,'ARSENIO LOPEZ FLORENTIN',NULL,NULL,1,'HIJO DE EDIT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1187,'HILARION BAEZ',NULL,NULL,1,'CONAVI PAPA DE WINIE DE POOB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1188,'LIZ CAROLINA RODRIGUEZ GONZALEZ',NULL,'6012393',1,'HNA DE QUESU.I',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1190,'NILDA RUIZ DIAZ',NULL,'2180179',1,'HIJA DE DON ISIDRO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1194,'JORGE ADALBERTO PINEDA',NULL,NULL,1,'16 CONOC. DE TERESA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1196,'ISAIAS AGUERO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1197,'ALBERTO OLMEDO',NULL,NULL,1,'ELECT. DE AUTOMOIL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1202,'ALBERTO ROLON',NULL,NULL,1,'HIJO DE ;A MARGARITA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1204,'AISAR JULIAN DELGADO BERNAL',NULL,'5091200',1,'PARIENTE DE LATONERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1205,'LETICIA GONZALEZ ESCOBAR',NULL,NULL,1,'HNA DE ALDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1206,'MIGUEL ANGEL PRIETO',NULL,NULL,1,'RECONDADO DE ANTONIO PRESENT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1207,'ISMAEL AUGUSTO RODRIGUEZ',NULL,NULL,1,'YERNO DE IDALINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1208,'CARLOS WILSON VERA PERALTA',NULL,'4838537',1,'YERNO DE TOMAS HERR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1209,'ELIAS JAVIER FRANCO DIAZ',NULL,NULL,1,'CERCA DEL TANQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1211,'SANDRA BEATRIZ GALARZA A',NULL,NULL,1,'DETRAS DE DON GARCETE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1213,'FRANCISCA VILLALBA VERA',NULL,NULL,1,'CALLE SAN RAMON DES. LUMA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1214,'PALMIRA GONZALEZ DE MEDINA',NULL,NULL,1,'SUEGRA DE EVER CABANHAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1215,'LUIS JAVIER RODAS ARANDA',NULL,NULL,1,'VILLA 1  SOBRE LA CALLE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1216,'TOMAS ORIHUELA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1217,'JUSTO AMARILLA BARBOZA',NULL,'5297904',1,'REC.LUIS VELAZQUEZ / SEBASTIAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1219,'VALERIANA VERA',NULL,NULL,1,'CERCA DE BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1220,'VICTOR RAMON MORAN',NULL,'2031845',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1221,'JOEL IGNACIO GONZALEZ',NULL,'5559725',1,'HNO DE DANILO - PATRICIA AQUINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1222,'OSCAR EVER VERA',NULL,NULL,1,'CUNHADO DE BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1224,'FERNANDO VILLASANTI',NULL,'666',1,'RECOMENDADO DE OSCAR EVER VERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1225,'MIKI',NULL,NULL,1,'ESTANZUELA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1226,'MKARIA N. GIMENEZ OCAMPOS',NULL,'3776817',1,'ALFAREROS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1230,'CRISTINA FLECHA',NULL,'10101',1,'MAMA DE JUAN CARLO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1231,'DIGNO SANCHEZ',NULL,'2900361',1,'CERCA DE LA CANCHA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1232,'LIZ FABIOLA GIMENEZ  A',NULL,'3215274',1,'NIETA DE CONSTANCIA AMARILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1233,'GRACIELA ESPINOZA',NULL,'3525663',1,'HNA DE VICENTE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1235,'RODOLFO BRIZUELA PAREDES',NULL,NULL,1,'ASENTAMIENTO SAN LORENZO- SAN FERNANDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1236,'JUAN DELGADILLO',NULL,'1506802',1,'MARIDO DE MANUELA PIRIS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1237,'CARLOS R, FLEITAS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1238,'VIRGINIO ESQUIVEL',NULL,'3001768',1,'MILITAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1240,'MARIA ELIZABETH ROJAS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1241,'NILTON ROJAS SANCHEZ',NULL,'6528735',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1242,'JUAN LEDESMA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1243,'RAIMUNDO BARRIOS',NULL,NULL,1,'SUEGRO DEL QUE TRAB EN LA CARP',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1244,'TERESIO TORRES',NULL,'1027263',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1246,'JUAN BAUTISTA FERREIRA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1250,'FELICIANA SANCHEZ',NULL,'4056602',1,'TIA DE GERARDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1251,'MIGDONIO CABALLERO',NULL,'1451467',1,'REPARTIDOR DE FACTURA DE AGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1253,'EUGENIO S CABALLERO',NULL,'1507730',1,'LED',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1255,'ALBERTO CASSANOVA',NULL,'190',1,'REPARTIDOR DE HUEVO - ITAUGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1256,'MARIA PELUQ',NULL,'191',1,'PELUQUERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1258,'FRANCISCA NOEMI ADORNO',NULL,'1886409',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1259,'CESAR VERON',NULL,NULL,1,'HERRERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1260,'BLAS ANTONIO CACERES',NULL,'5870777',1,'YERNO DE ALBERTO DAMIAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1262,'HERNAN BRITEZ',NULL,'4999488',1,'REC. PEDRO OVIEDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1263,'SALVADOR ANTONIO GONZALEZ',NULL,'2138144',1,'AVAL: EVER RODRIGO GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1264,'FRANCISCO CABRAL',NULL,NULL,1,'ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1266,'JUANA FRANCO',NULL,'1921',1,'MAMA DE NOELIA OLAZAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1267,'FRANCISCO JAVIER ROJAS',NULL,'6778679',1,'MCAL ESTIGARRIBIA NHA VICTORIANA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1268,'SEBASTIAN TORRES',NULL,'1390',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1269,'LUIS LOPEZ',NULL,'1431',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1270,'FLORENTINA GONZALEZ',NULL,NULL,1,'MAMA DE JAVIER',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1271,'MARTA RAMOS',NULL,NULL,1,'MAMA DE NORW',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1273,'ANTONIO LOPEZ',NULL,'19334',1,'TIO ANTONIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1275,'JUAN SINMERLI',NULL,'1937',1,'HNO DE NANCY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1276,'JOSE BRITEZ MARIN',NULL,'2143996',1,'CONAVI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1277,'ALFREDO ARZAMENDIA',NULL,'5649433',2,'TRINIDAD',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1278,'LIZZIE GIMENEZ',NULL,'4182782',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1279,'FERNANDO ESQUIVEL',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1281,'GESSICA OVELAR',NULL,'4866965',1,'CERCA DEL NORUEGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1282,'FLAMINIA ESCOBAR',NULL,NULL,1,'HNA DE ISABEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1283,'ISAAC SANTACRUZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1285,'ROCIO FABIOLA MENDOZA',NULL,'4300915',1,'VCNA DE NHA CAMBA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1286,'OSCAR CABALLERO',NULL,'2055090',1,'HNO PUMA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1288,'RAFAEL BENITEZ',NULL,'2468145',1,'CERCA DE LA GOBERNACION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1290,'VALENCIA CANHETE',NULL,NULL,1,'ESTANZUELA DETRAS DE COPETROL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1291,'ESTELA MARY GAUTO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1292,'MIGUEL ECHEVERRIA',NULL,'1079618',1,'HIJO DE NHA GENARA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1295,'NELIDA C SOSA RIOS',NULL,'3679297',1,'VILLA 1 REC. LILIAN VALLEJOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1296,'DIOSNEL OLMEDO',NULL,NULL,1,'CHAQUENHA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1297,'CATALINA CANHETE',NULL,'613082',1,'PARIENTE DE FLORENTIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1298,'NORMA SOTO',NULL,'3533834',1,'CONAVI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1299,'DERLIS CABANHAS',NULL,'6226069',1,'PARIENTE DE ALDO G',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1300,'JOAQUIN FLORES',NULL,NULL,1,'ASENT. BELEN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1301,'BRAHIAN D VERA V',NULL,NULL,1,'VCINO BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1302,'SALVADOR ALVARENGA',NULL,'12111',1,'MARIDO DE NHA KUKA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1303,'DIEGO OPORTO',NULL,'4343083',1,'CHACOMER',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1304,'MONICA A ORTIZ',NULL,'6664759',1,'HIJA DE DON PEDRO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1305,'ALBERTO SUAREZ AYALA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1308,'DERLIS RAMON PERALTA PORTILLO','CI','5082758',1,'ASENTAMIENTO NHANDE ROGA RA',NULL,'0986615073',NULL,NULL,NULL,'SOL',1,'N'),
(1309,'ISIDRO BRIZUELA C',NULL,NULL,1,'REC,CRISTOBAL LOPEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1311,'LORENA SANABRIA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1312,'ISIDORA TALAVERA',NULL,'2345305',1,'FRENTE AL DR FABIAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1313,'MATIAS RUIZ DIAZ',NULL,'3684860',1,'NIETO DE ISIDRO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1314,'OSVALDO ESPINOLA',NULL,NULL,1,'VECINO  DE NHA ELISA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1318,'ZENAIDA FLORENTIN',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1319,'VICTOR MOREL',NULL,'6685843',1,'CUNHADO DE CRISTOBAL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1321,'LILIANA ROMERO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1322,'GLADYS FERNANDEZ',NULL,'667',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1323,'HECTOR CABANHAS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1324,'VICTOR AYALA',NULL,NULL,1,'CUNHADO DE BRITEZ CONAVI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1325,'RUBEN AMARILLA',NULL,'4489173',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1327,'JUAN CARLOS RIQUELME',NULL,'2520157',3,'TIO JHONY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1328,'ISABEL LENCINA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1329,'MABEL RAMOS',NULL,'12311',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1330,'ROSA HERMOSILLA',NULL,'674683',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1331,'ISMAEL RODAS A',NULL,NULL,1,'MARMOLERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1332,'VICTOR DIAZ VALENZUELA',NULL,NULL,1,'VCNO BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1333,'DERLIS VILLASANTI',NULL,NULL,1,'VCINO BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1334,'SONIA GONZALEZ',NULL,'6767788',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1335,'LUIS SAMUDIO',NULL,NULL,1,'SOBRINO DE ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1337,'CRISPIN SANCHEZ',NULL,'1030126',1,'PAPA DE GERARDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1338,'BENEDICTO PISSURNO',NULL,NULL,1,'HERRERO DE DON TOMAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1339,'SONIA B CACERES',NULL,'2219842',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1340,'RICARDO MIRANDA',NULL,'2181637',1,'TOMASA FLORENTIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1341,'SILVESTRE MARTINEZ',NULL,NULL,3,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1342,'MIGUEL LEIVA',NULL,'1974851',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1344,'JULIO CABRERA',NULL,'4530662',1,'LUIS IBARRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1346,'MIRTHA ORUE DE VILLALBA',NULL,NULL,1,'SUEGRA DE RAMONA LOPEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1347,'TOMASA DE FLORENYTIN',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1350,'MARCO SAUCEDO',NULL,'1208287',1,'PARIENTE SAMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1352,'MARIA TANDE',NULL,'4791732',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1353,'DAHIANA CANTERO',NULL,NULL,1,'COCUE GUAZU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1354,'CESAR CABALLERO',NULL,'3700167',1,'HNO DE LA VIUDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1355,'FRANCISCO BENITEZ',NULL,'3862693',1,'MARIDO DE BANHIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1356,'JUAN CABRERA CABRERA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1359,'JHON M ESTECHE',NULL,'5234133',1,'HERRERO DE DON TOMAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1362,'PATRICIO BOGADO',NULL,'3974097',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1363,'ARMINDA MONTIEL',NULL,NULL,1,'AMIGA DE GLADYS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1365,'RODRIGO ARCE',NULL,'4350346',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1366,'LUCIO FLORENTIN',NULL,'4790574',1,'NHA TOMASA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1367,'ELI AQUINO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1368,'OBDULIA ALEN GONZALEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1369,'JUANA CHILENO',NULL,'2220591',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1370,'EDGAR FERREIRA',NULL,'688839',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1371,'ANTONIO ORTEGA',NULL,NULL,1,'BLASIDA ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1372,'VICTOR MENDOZA',NULL,'5307994',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1377,'REINALDO RODAS',NULL,'1329334',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1379,'CIRILA FERNANDEZ',NULL,NULL,1,'FRENTE A FABIAN CAB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1380,'BLANCA FERNANDEZ',NULL,'1344532',1,'HNA DE ANA SELVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1381,'MARIA A GRANCE',NULL,NULL,1,'Z VILLAMAYOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1383,'ALVINO RUIZDIA A',NULL,'1960276',1,'RAMON MEDINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1384,'GLADYS AVEIRO DE RIOS',NULL,NULL,1,'MAMA DE LESLIE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1385,'LIZ CAROLINA LOPEZ',NULL,'5028313',1,'HIJA DE MARIA E.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1386,'VICENTE BERNAL',NULL,NULL,1,'VILLA 1 LECHERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1387,'SONIA LOPEZ RAMOS',NULL,'4254363',5,'DETRAS DE COLONIAL VENDEDOR DE TROVATO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1388,'SILVINO MELGAREJO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1389,'PEDRO AQUINO',NULL,NULL,1,'COBRADOR DE CHACOMER',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1391,'BETY BEATRIZ GONZALEZ',NULL,NULL,1,'PELUQUERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1392,'ALFREDO GOMEZ',NULL,'2631507',1,'VILLA 1 DON TOMAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1393,'ANTONIO RODAS',NULL,'4767347',1,'REC FATIMA CABALLERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1394,'PAULO BERHTE',NULL,'2207824',1,'SUEGRO DE ROBERTO GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1395,'RILCY FRETES M',NULL,'4661315',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1399,'LUCIO BRITEZ',NULL,'1674106',1,'VCNO DE KIKE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1400,'KARINA GOMEZ A',NULL,'5940773',1,'NOVIA DE SAMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1402,'GUSTAVO D FERREIRA',NULL,NULL,1,'VILLA LILICA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1403,'JUANITA FRANCO',NULL,'5019879',1,'REC. DE CYNTHIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1404,'JUAN CARLOS CABALLERO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1405,'ENZO MEYER',NULL,'3776798',1,'0984913607',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1406,'EMERENCIANO PRESENTADO',NULL,NULL,1,'ROMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1407,'JUAN ALBERTO LOCIO',NULL,'5784566',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1408,'ADOLFO FERREIRA A',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1410,'CYNTHIA FERREIRA',NULL,'3181484',1,'HIJA DE NINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1413,'JUAN CARLOS CABRERA',NULL,'1859996',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1416,'ROBERTO GONZALEZ B',NULL,NULL,1,'NHA EUSEBIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1417,'WILMA BERHTE',NULL,NULL,1,'ROBERTO GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1418,'VICTOR PALMA',NULL,'4466251',1,'YENNI PRESENTADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1419,'ARTEMIA ARANDA',NULL,'560784',1,'TIA DE VIVIAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1420,'JORGE R FRANCO',NULL,'1207865',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1421,'DERLIS VALLEJOS',NULL,NULL,1,'TIO DE GUSTAVO VALLEJOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1423,'ALEXI ROLANDO GOMEZ',NULL,'6605663',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1424,'MIRNA J NALERIO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1425,'EMILIO FRANCO',NULL,'1221',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1426,'ANGELA DOMINGUEZ',NULL,'3390088',1,'SUEGRA DE SONIA OLAZAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1427,'GILBERTO GONZALEZ',NULL,'3015266',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1429,'INGRID M. JARA MART',NULL,'5494977',1,'TRAB EN CINEMAX',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1430,'CECILIA RODAS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1431,'OSCAR GAONA R',NULL,'5777684',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1432,'FIDELINA GIMENEZ V.',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1433,'CARLOS CABALLERO HER',NULL,'3931622',1,'SOBRINO DE MARIO MARTINEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1434,'BERNARDINA AYALA',NULL,'5118042',1,'VILLA ROSITA II A 2 CUADRAS DE LA COMISARIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1436,'IGNACIO PEREIRA',NULL,NULL,1,'A 2 CUADRAS DE LA COMISARIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1437,'ANTOLINA VILLALBA',NULL,'657366',1,'CERCA DE NHA ALE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1438,'ANA C, ALVEZ',NULL,'6357666',1,'CERCA DE BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1439,'LUIS ARCE',NULL,'1165908',1,'NHA ZORAIDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1440,'MIRIAM MAGNOLIA',NULL,NULL,3,'GUYRA CAMPANA 560 C/29 DE SETIEMBRE-HIJA DELICIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1442,'CESAR ARNALDO',NULL,'4549657',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1443,'HUGO MARTINEZ',NULL,'4970224',1,'ESPOSO DE ISABEL GIMENEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1444,'JUAN',NULL,NULL,1,'HIJO NINFA FERREIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1445,'VICTORIANA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1446,'MIRTHA MERCADO',NULL,'2962260',1,'VEC. MYRIAN FLORENTIN','0981247807',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1447,'ARNALDO LUIS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1449,'ALFREDO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1450,'JUSTINA PANIAGUA',NULL,'3972866',1,'SUEDRA DE IDALIO OLAZAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1451,'JULIO CESAR',NULL,'4552738',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1452,'PRIMITIVA',NULL,'270118',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1453,'CIRILO RAMON',NULL,NULL,3,'CERCA DE LA MUNICIPALIDAD',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1454,'DIONICIO',NULL,'3233196',1,'CONOCIDO DE RAMONA ALEGRE Y VILLASANTI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1455,'EMILIANO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1460,'MARIA DE JESUS CABRAL AQUINO',NULL,'4698256',1,'HIJA DEL TECNICO REFRIGERACION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1464,'MIRIAN CABRAL AQUINO',NULL,'4698255',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1465,'GERMAN SANCHEZ CARDENAS',NULL,'2617135',1,'VECINO DE JUANA MARIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1466,'SILVANA L. IBARROLA M.',NULL,'4022782',1,'RECOM LA RED  TRAB MUNIC VALLE PUCU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1467,'HIGINIO MARIN',NULL,NULL,1,'NIETO TOMASA DE FLORENTIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1468,'MARCOS LUIS MIRANDA',NULL,'5596569',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1471,'LOURDES IVON FERREIRA',NULL,'5705718',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1472,'JONATHAN JESUS ARRUA BAEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1473,'ANUNCIA RODRIGUEZ',NULL,'3590479',1,'MOTEL FANTASIA A DOS CUADRAS DE LA RUTA CASILLA BLANCA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1474,'ALCADIO DUARTE',NULL,'1321600',1,'SUEGRO DE VILLASANTI DERLIS FRENTE A SU CASA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1475,'GERARDO DANIEL FLEITAS SILVA',NULL,'4837411',1,'CUNHADO DE HERMINIO RIVAROLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1476,'ANTONIO RAFAEL CABRERA TORALES',NULL,'4680360',1,'GOMERO RECOM DE JOVINO VILLORDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1477,'ESTEBAN DARIO BERNAL BELOSO',NULL,'654726',1,'CERCA DE MICHI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1478,'FRANCISCA VALLEJOS',NULL,'1102943',1,'MAMA DE LILIAN VALLEJOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1479,'LIZ MARINA GAMARRA ARANDA',NULL,'4730152',1,'HNA DE VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1481,'FABIO SUAREZ AYALA',NULL,'2240515',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1482,'SERGIO D. ZARATE',NULL,'2422858',1,'CERCA FRANCISCA CARMEN CABRERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1483,'RUTH NOEMI PAREDES',NULL,'5738513',1,'HIJA DE DERLIS VILLASANTI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1484,'BARSILICIA GONZALEZ VILLALBA',NULL,'4044554',1,'HIJA DE COSTURERA CERCA EMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1485,'ELVIO ALEGRE',NULL,NULL,1,'MARIDO JUANA CHILENO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1486,'MARIA C.DUARTE',NULL,'4931682',1,'CLIENTE VICTOR GAMARRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1487,'GLORIA E.SANCHEZ',NULL,'4604663',1,'HNA DE GERARDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1488,'ANDRES REYES CARDOZO',NULL,'1303304',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1489,'RIGOBERTO DUARTE PEREIRA',NULL,'6787235',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1490,'JOHANA SAMUDIO MONTIEL',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1491,'VICTORIANO GAMARRA GONZALEZ',NULL,NULL,1,'PAPA DE VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1492,'ADELIO SOSA LOPEZ',NULL,'4406421',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1494,'CARINA MENDEZ COLMAN',NULL,'6972731',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1495,'IRMA BENITEZ DE RODAS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1498,'JULIO MERLO',NULL,'3644222',1,'RECOM JULIO CABRERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1499,'LIZ MARIBEL CORONEL',NULL,'4787230',1,'VICTOR OLAZAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1500,'EMMANUEL AMARILLA ARGUELLO',NULL,'6710308',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1501,'PEDRO DOMINGUEZ',NULL,'2314745',1,'EDIL QUINIELERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1502,'LEILA M. AYALA BRITEZ',NULL,'4406261',1,'SOBRIN DE LUCIO BRITEZ/VEC DE KIKE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1505,'ROBERTO LOVERA',NULL,'5261351',1,'HNO DE JULIO LOVERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1506,'LUCIANO PAIVA',NULL,'3344987',1,'A 3 CUADRAS DE HNAS AZULES FRACC AURORA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1508,'LAURA CABRERA MARTINEZ',NULL,'3422231',1,'SRA DE JORGE AVILA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1509,'LAURA M. MEDINA DE GARCIA',NULL,'3256904',1,'ASENT RENACER III',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1510,'MYRIAN ACOSTA DE FRANCO',NULL,'1312954',1,'FRACCION VILLA ROSITA MAMA DE JUANITA FRANCO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1513,'MARIA VICTORIA RAMIREZ GARCIA',NULL,'4623798',1,'CUNADA DE FREDI BORDON/B.SAN LORENZO CERCA TANQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1514,'EDUARDA CABALLERO',NULL,'189847',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1515,'LOURDES B.ALVARENGA',NULL,'5488976',1,'HIJA DE SALVADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1517,'TERESA RUIZ DE JARA',NULL,'1486795',1,'PARIENTE DE CONSTANCIA AMARILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1518,'CINTHIA BARRIENTOS MEZA',NULL,'3001897',1,'PROF. FRENTE A CASA DE CELSO VELAZQUEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1521,'GERARDO VILLASANTI GENES',NULL,'5343229',1,'CUNADO DE CARINA MENDEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1524,'MARTINA MAZ',NULL,'6508729',1,'REC VICTOR COBRADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1526,'WALTER BAEZ',NULL,NULL,1,'DE CATALINA CANETE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1527,'MARIO MORA',NULL,'2885534',1,'GOMERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1529,'JESSICA MARIA MONSERRAT MONTIEL DI LASCIO',NULL,NULL,3,'CERCA DE DAVID',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1532,'CLAUDIA SILVA CANTERO',NULL,'4197458',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1533,'PETRONA QUINHONEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1537,'PATRICIA B PERALTA O',NULL,'4936441',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1538,'MARIO BAZAN PALACIOS',NULL,'4219026',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1539,'SILVESTRE VERA',NULL,'5928863',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1542,'TEODOLINA MERELES MARECOS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1543,'EULALIA ARCE GONZALEZ',NULL,'4728901',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1544,'ARMANDO ACOSTA ZARATE',NULL,'5007340',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1545,'VICTORIA DUARTE OSORIO',NULL,'3001595',1,'VILLASANTI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1549,'GLORIA FRANCO VDA DE MORA',NULL,'4082010',1,'ARA PYAHU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1551,'OSMAR RODAS ARCE',NULL,'3388026',1,'MARMOLERIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1552,'FELICIA VAZQUEZ RAMIREZ',NULL,'2574672',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1554,'MAGDALENA GONZALEZ',NULL,'5335271',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1555,'MARCIAL VAZQUEZ CANHETE',NULL,'4700725',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1556,'CRISTIAN JAVIER CABALLERO MORENO',NULL,'5778750',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1557,'JUAN ANTONIO AMARILLA',NULL,'2008492',1,'VILLA SALVADOR ESQ ESC.FE Y ALEGRIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1559,'FERNANDO PEREIRA',NULL,'3988326',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1562,'SARA GAONA MARTINEZ',NULL,'1858602',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1563,'JUAN PASTOR GUERRERO',NULL,'2548929',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1564,'CLAUDIA B FRETES',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1565,'GABRIELA ROJAS',NULL,NULL,1,'ESPOSA DE ROMAN BARRIOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1566,'ADALBERTO RODAS',NULL,'2102792',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1567,'EULALIO BORJA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1568,'EVER BENITEZ BENITEZ',NULL,NULL,1,'HNO DE MARIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1570,'MARIA CRISTINA AGUERO',NULL,NULL,1,'CUNHADA DE DON CESAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1571,'DELROSARIO TORRES',NULL,'1391101',1,'MAMA DE MARCELINO TORRES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1574,'ORIBE OSVALDO BENITEZ B',NULL,'5495761',1,'HNO DE MARIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1575,'PATRICIA I.AQUINO',NULL,NULL,1,'PATTY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1577,'LILIAN DIANA MEDINA FRETES',NULL,NULL,1,'NUERA DE ASENCION CABANHAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1578,'LUIS AYALA',NULL,'4917778',1,'RAKIURA FLAMINIA ESCOBAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1579,'FRANCISCO J.AYALA',NULL,'4917782',1,'REC FLAMINIA ESCOBAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1580,'MIRIAN ROSANA COLMAN',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1581,'DIONISIO VILLALBA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1582,'TEOFILO BAEZ',NULL,'1225100',1,'RECOMENDADO DE LEONOR CACERES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1583,'GENARO BENITEZ',NULL,'1616492',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1584,'NINFA COHENE',NULL,'3776813',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1586,'VICTORIANO LUJAN',NULL,'3227599',1,'HNO NHA LUCY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1587,'ALEXIS DUARTE',NULL,NULL,1,'RECOM VICTOR COBR.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1588,'JUAN DAVID ANTUNEZ',NULL,'5216235',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1591,'EMILIA VIVIANA RIOS AVEIRO',NULL,'5091599',1,'HNA DE LESLIE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1592,'ERIH ALFONSO CABALLERO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1593,'JUAN ANGEL RODAS DUARTE',NULL,'4475651',1,'SOBRINO DE PROF ZUNI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1595,'TOMAS VELOZO',NULL,'1902953',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1596,'DAHIANA JAZMIN LUGO FLEITAS',NULL,NULL,1,'VILLA SALVADOR FRENTE A LA PLAZA 6 DE AGOSTO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1597,'FRANCISCO GONZALEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1598,'JORGELINA NALERIO',NULL,'2599159',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1599,'NADIA E. GONZALEZ GIMENEZ',NULL,'4375597',1,'HERMANA DE RENE GONZALEZ ESPOSO TRABAJA EN LINCOLN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1600,'SANDRA D. ESPINOLA',NULL,'3363094',1,'RECOMENDADA DE ELI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1601,'RANULFO FRANCO GOMEZ',NULL,NULL,1,'VECINO DE EVER VERA /TRABAJA QUIMAFLEX',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1602,'HUGO A SALINAS',NULL,'6246035',1,'VILLA SALVADOR CERCA DE SOLE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1603,'DIANA A ZELADA',NULL,'3660330',1,'VECINA DE AURORA DUARTE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1605,'MILCIADES CABRERA VALIENTE',NULL,NULL,1,'RADIOLOGO /MIKI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1606,'GRACIELA DE FRETES',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1607,'CATALINA FERNANDEZ',NULL,'4875839',1,'RECOM PATRICIA PRESENTADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1608,'GUSTAVO LOPEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1610,'MARIA ANGELINA MACIEL',NULL,'4626137',1,'HIJA NHA LEO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1611,'AGUSTINA ROTELA',NULL,'4535753',1,'RECOMEND DON ELIGIO CARPINTERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1612,'JULIO CESAR ARANDA',NULL,NULL,1,'VILLA AMANECER CERCA DEL PUESTO DE SALUD',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1613,'JOHANA SALINAS',NULL,'6246036',1,'CERCA DE SOLE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1614,'JORGE DAVID MARTINEZ',NULL,'4360356',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1615,'CLAUDIA CABRERA CABRERA',NULL,'1329284',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1617,'EMILIO ACHAR OTERO',NULL,NULL,1,'HERRERO CERCA NHA LEO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1618,'RODRIGO CORREA',NULL,'5879991',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1619,'VICTOR GONZALEZ GAYOSO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1620,'RODRIGO MARIN RUIZ',NULL,'5029746',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1621,'LUCILA SANABRIA',NULL,'2107739',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1622,'HUGO FLEYTAS',NULL,'2423882',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1623,'GLORIA ROJAS',NULL,NULL,1,'MAMA NIMIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1625,'RODRIGO BAEZ JARA',NULL,'4357380',1,'VECINO DE ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1626,'OSCAR MARTINEZ PALACIOS',NULL,NULL,1,'CALLE KIESE Y 20 DE ENERO  FERRT EL HALCON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1627,'GUSTAVO A RODRIGUEZ',NULL,'6633610',1,'RECOM RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1628,'ARNALDO A CENTURION',NULL,NULL,1,'PRIMO ELVIO ARZAMENDIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1629,'MATEO SAAVEDRA MENDOZA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1630,'ROMI BENITEZ RECALDE',NULL,'5355506',1,'HIJO DE NHA TEO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1631,'JOSE ALFONSO LOPEZ',NULL,'4878932',1,'RECOM LORENA SANABRIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1632,'MARIA EMILIA MEDINA',NULL,'2860246',1,'REC OSVALDO ESPINOLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1633,'CINTHIA BAEZ',NULL,NULL,1,'TRABAJA EN SALEMMA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1635,'AURELIO PAREDES ORTELLADO',NULL,'3024397',1,'VECINO NHA LEO  FRENTE A ARAMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1636,'MIGUEL F. ESCOBAR',NULL,NULL,1,'A 6 CASAS DE JOSE LUIS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1639,'MARIA FRANCISCA FRETES GARCIA',NULL,'1270247',1,'LILICA RECOMEND PABLITO ORTIZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1640,'LIDIA VILLAGRA',NULL,'4681926',1,'SOBRINA DE TERESIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1643,'AURELIO ESCOBAR',NULL,'1135444',1,'CARPINTERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1644,'ALBERTO NUNHEZ',NULL,'4836627',1,'LUQUE COLEGIO POLICIAL HNO DE ROSANA NUNHEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1645,'MIGUEL ANGEL ORTIZ',NULL,'4280805',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1646,'GUIDO BARRIOS',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1647,'CESAR IVAN CRISTALDO',NULL,'21944367',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1649,'NORMA BENITEZ DIAZ',NULL,'2149478',1,'RECOM JUAN C RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1651,'VICTOR ISMAEL GONZALEZ FRANCO',NULL,'3404415',1,'HNO BETY PELUQ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1652,'RAMONA BALBUENA',NULL,NULL,3,'MARAMBURE  -DERLIS VALLEJOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1653,'CARMEN VILLALBA',NULL,'4640077',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1654,'LILIAN ACOSTA MEDINA',NULL,NULL,3,'RECOM VICTOR GAMARRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1655,'SONIA ISABEL ALCARAZ FERNANDEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1656,'FABIO A FRANCO ACOSTA',NULL,'5355510',1,'CINTHIA DUARTE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1657,'VALENTIN RODRIGUEZ',NULL,NULL,3,'RECOM JUAN C RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1658,'FATIMA A ZELADA JARA',NULL,NULL,3,'TIA DE YAMILHE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1659,'VICTOR IGNACIO GONZALEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1661,'LINEO RAUL VARGAS',NULL,NULL,1,'CUNHADO DE MATIAS VECINO ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1662,'SANTIAGO SANCHEZ OVIEDO',NULL,'3562153',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1663,'SERGIO NUNHEZ AQUINO',NULL,'3935778',3,'CUNHADO DE LESLIE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1664,'LESLIE RIOS AVEIRO',NULL,'5199969',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1665,'NELSON MEDINA RUIZ DIAZ',NULL,'1783572',1,'PAPA DE MARLENE NOVIA CUE DEL MUSICO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1666,'JOSE UBALDI BENITEZ',NULL,NULL,1,'CONAVI B. LUZ MARIA PAPA DE GERARDO REC RODRIGO GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1667,'GERARDO BENITEZ BURGOS',NULL,'3837783',1,'COSTA FLEITAS RECOM DE RODRIGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1668,'JULIO CESAR BAEZ',NULL,'3033990',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1669,'MIRIAN BEATRIZ DUARTE LUJAN',NULL,'4784594',1,'HIJA NHA LUCY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1670,'DELIA PEREIRA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1671,'ADELINA MALBE OJEDA DE PAREDES',NULL,'3647828',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1672,'HECTOR DANIEL DETEZ',NULL,'2580516',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1673,'ANA FERNANDEZ DE IRALA',NULL,'3812438',3,'RECOM ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1674,'ALVARO JESUS FLEITAS',NULL,'6797772',1,'RECOM SRA ESTUDIA ENFERMERIA .....LILICO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1675,'VICENTA DUARTE PANAS',NULL,'618333',1,'ROSITA VECINA DON ATILIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1676,'LIMPIA FERNANDEZ',NULL,'3500459',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1680,'AMADO NUNHEZ LEZCANO',NULL,'4403048',1,'RECOM MIGUEL ORTIZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1681,'ELDA QUINHONEZ',NULL,NULL,1,'RICARDO PEREZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1682,'FULGENCIO DANIEL BENITEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1683,'LUCIO CACERES PANIAGUA',NULL,'4345422',1,'YERNO DE ACHAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1684,'CAROLINA BRITE ZCABRERA',NULL,'6164544',1,'CUNHADA DE CLAUDIA JARA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1688,'ROSSANA AYALA DE VAZQUEZ',NULL,'2525422',1,'NOVIA DE DANY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1691,'NESTOR RIVAS ALVARENGA',NULL,'6869817',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1693,'JUANA RUIZ ROLON',NULL,NULL,1,'SALVADOR C/ PARADA CERRO COI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1694,'BLANCA E GONZALEZ',NULL,'3832016',1,'RESPLANDOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1695,'DIEGO ARMANDO ROA VALDEZ',NULL,'4657836',1,'FERRETERIA ROA ELECTRIC FRENTE A BODEGA MIGUELITO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1696,'RAMON PRESENTADO CABALLERO',NULL,NULL,1,'TAXISTA FRENTE A CATALO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1697,'ALBERTA ELVA RIVEROS FERNANDEZ',NULL,'2410561',1,'MAMA DE DAN ALMIRON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1698,'CRISTIAN ALFREDO ORIHUELA C.',NULL,'3571533',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1699,'MARIA CRISTINA VILLASANTI',NULL,NULL,1,'MAMA DE RUBEN VERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1700,'MIGUEL ANGELP ORTILLO BENITEZ',NULL,'2342785',2,'CONGRESO RECOM ROBERTO CARDOZO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1701,'CINTIA MABEL MENDIETA ZARATE',NULL,'5353960',5,'SOBRINA CONSTANCIA AMARILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1702,'YANINA PATRICIA RIVEROS',NULL,'4743983',1,'MARCO LOPEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1704,'ISAMAR A. CANHETE SAMUDIO',NULL,'5022761',1,'REC VICTOR COBRADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1706,'FERNANDO JOEL AMARILLA',NULL,'6710287',1,'HIJO DE VIRGILIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1707,'TOMAS CANHETE AYALA',NULL,'623668',1,'NHA CAMBA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1708,'MARTA ANTONIA PALMA F.',NULL,'2153055',1,'CERCA GOBERN. SRA PANADERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1709,'ALCIDES GUILLERMO MOREL ESCOBAR',NULL,'4388333',1,'VILLA POLICIAL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1710,'JUAN ADOLFO FERNANDEZ F.',NULL,'5084330',1,'HIJO ZULMA FERREIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1711,'VIRGINIA BENITEZ',NULL,'4848178',1,'HNA DE MARIA IMPRENTA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1712,'CELSA COLMAN BARRIOS',NULL,NULL,1,'RECOM VICTOR COBRADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1714,'FRANCISCO BOGADO',NULL,'6383624',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1715,'GASPAR GONZALEZ',NULL,NULL,1,'PAPA DE HERMENEGILDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1716,'OLGA GAONA',NULL,'3784720',1,'RECOM ADRIANA NALERIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1717,'RODRIGO FRETES',NULL,'4354001',1,'CUNHADO DALIA PEREIRA....VILLA OLIVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1718,'TAMARA CABALLERO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1719,'SALVADOR LEIVA MARTINEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1720,'ROBERTO CARDOZO LOPEZ',NULL,'4326601',1,'TEBICUARY/GUAIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1721,'JUNIOR GONZALEZ',NULL,NULL,1,'HERMANO DE STEVEN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1722,'ESTELA MARY ARCE',NULL,'1256887',1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1723,'ALISON ADORNO',NULL,'1886408',1,'HIJA CONSTANCIA AMARILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1724,'FATIMA A.MARTINEZ',NULL,'5447772',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1725,'JOSE E. GAONA B',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1726,'MIGUEL ANGEL CORONEL',NULL,'2228785',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1727,'PEDRO SANABRIA',NULL,'6110154',1,'HIJO DE ANGELA DOMINGUEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1728,'EMIDIO ROMERO',NULL,NULL,1,'RECEND ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1729,'IRIS ROUSANA BOGARIN',NULL,'3487572',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1730,'RAMON ZARACHO',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1731,'ANA ZELADA',NULL,NULL,3,'TIA  DE YAMILHE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1732,'JAZMIN S. ROJAS BENITEZ',NULL,NULL,4,'FRACCION SAN JORGE RAUL CERCA AGUATERIA ACAPULCO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1733,'PEDRO ORTIZ',NULL,'554715',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1735,'ALFREDO MONTIEL GIMENEZ',NULL,'1562290',1,'CHOFER  A 3 CASAS DE LA CANCHA 8DE SETIEMBRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1736,'CESAR GAVILAN PAREDES',NULL,NULL,1,'ESQ DEL ALQUILER NENECHO-TRABAJ CON FRANCISCO CABRAL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1737,'RAMONA BAEZ',NULL,NULL,1,'HNA ANTONIA BAEZ CERCA NHA LUISA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1738,'CARLOS FABIAN SANCHEZ CABRERA',NULL,'5706151',1,'A 1 CUADRA DE LA COMISARIA 220 ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1739,'TESSI CAROLINA CANHETE SAMUDIO',NULL,NULL,3,'MARAMBURE HERNANDARIAS Y PORFIRIO GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1740,'RICHARD CEFERINO RUIZ RIQUELME',NULL,'4436709',3,'DE LAS RESIDENTAS 1777 ...3 DE MAYO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1742,'EMIGDIO JAVIER RODRIGUEZ GONZALEZ',NULL,'6012334',1,'QUESUI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1743,'MARILISA VERA DAVALOS',NULL,'5886710',1,'PEDRO JUAN FLEITAS 8 SETIEMBRE.....COSTURERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1744,'CARLOS DARIO CHAVEZ',NULL,'3998292',1,'HIJO LUCY CHAVEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1745,'DIEGO J, VILLAREAL GODOY',NULL,NULL,5,'AVELINO MARTINEZ RECOM VICTOR COBRADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1746,'RAMON DANIEL DIAZ',NULL,'3490617',1,'ASENT ARA PYAHU 2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1747,'DANIEL GRANDELL MOLINA',NULL,NULL,1,'SUEGRO DE YHONI ROMERO  YUKYRY KM 24',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1748,'EVER GIMENEZ ESCOBAR',NULL,'5891606',1,'STA CATALINA CERCA TANQUE  VEC NHA QUINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1749,'ZULLY DUARTE GONZALEZ',NULL,NULL,1,'ARA PYAHU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1750,'YONY RAFAEL CANDIA CARRERO',NULL,'2094341',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1751,'ROSALBA CABRERA',NULL,NULL,1,'VECINO DE LARISSA ALARCON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1752,'MARGARITA FARINHA',NULL,NULL,1,'ESPOSA DE MACIEL ,HIJO NHA LEO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1753,'DELIA NUNHEZ JARA',NULL,'6140369',1,'HIJA PEDRO HOJALATERO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1754,'BERNARDA ESPINOLA ROMERO',NULL,'4479877',1,'ANTES DE LA CASA DE FLORENTINA MONGES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1755,'ANTONIO RAMON ALCARAZ FERNANDEZ',NULL,'4946010',1,'SIERRA DE AREGUA HNO DE SONIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1756,'AGUSTIN ANDRES ALCARAZ FERNANDEZ',NULL,NULL,1,'HNO SONIA ALCARAZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1757,'MIGUELA VERA SERVIN',NULL,NULL,1,'RECOMEND ROMY PRESENTADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1758,'ARMANDO ARIEL ACUNHA',NULL,'4056266',1,'HIJO FRANCISCO ACUNHA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1759,'EDGAR ROLON FIGUEREDO',NULL,'4872236',1,'RECOM GERMAN SANCHEZ /PINDOLO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1760,'PABLO RAMON FERREIRA ROJAS',NULL,'4703413',3,'MAKAI CNEL MARTINEZ 886 MECANICO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1761,'LARISSA TALAVERA',NULL,NULL,1,'NIETA DE CIRILA TALAVERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1762,'JOEL OVIEDO GALEANO',NULL,'5722823',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1763,'ROSALBA BIENVENIDA VILLALBA DE SCAPPINI',NULL,'2882495',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1765,'LUIS E. BENITEZ OSORIO',NULL,'5334824',1,'ANDREA JULIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1767,'LUIS IGNACIO DUARTE',NULL,NULL,1,'PESCADERIA DUARTE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1769,'MARIA NILDA ESTECHE FLORENTIN',NULL,'2151422',1,'RECOM ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1770,'GABRIEL VILLAR LOPEZ',NULL,NULL,7,'KM 31',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1771,'VIDAL ANTONIO ROJAS',NULL,NULL,3,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1772,'CARLOS MEDINA CANTERO',NULL,'2354651',1,'ODONTOLOGO AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1773,'SEBASTIAN SOSA',NULL,'4871575',1,'MARLENE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1774,'SOFIA BENITEZ',NULL,NULL,1,'VECINO DE KIKE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1775,'JUAN CARLOS ARANDA',NULL,NULL,1,'RECOM TIA ARTE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1776,'ARMANDO VIDAL FRETES GAVILAN',NULL,'5353589',1,'CUNHADO DELIA PEREIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1777,'MIGUEL OJEDA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1778,'GABRIELA ACEVEDO',NULL,'4933697',1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1779,'EMILIO DIAZ',NULL,NULL,1,'CUNHADO DE LINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1780,'CESAR CACERES',NULL,NULL,1,'RECOM BLANCA VERA HIJO DE ANTOLIANA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1781,'BRIGIDA PELAGIA CABALLERO',NULL,'3556760',1,'RECOMEND NHA DORITA- ESPOSO CECILIO AMARILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1782,'ALEJANDRO BAEZ',NULL,'6691842',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1784,'CHRISTIAN RUIZ RIQUELME',NULL,NULL,1,'RECOM RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1785,'CARMEN CESPEDES',NULL,NULL,1,'VECINA DE NHA ELISA AL COSTADO DE LA ESCUELA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1786,'HUGO MENDOZA',NULL,'3293323',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1787,'ALVARO JARA',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1789,'AUTRI ACHAR',NULL,'2077117',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1790,'DOLLY FLEITAS',NULL,'3817386',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1792,'SILVIA AMARILLA',NULL,'4193233',1,'ESPOSA DE FRAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1793,'BEATRIZ ORTELLADO DE FERREIRA',NULL,'3298946',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1796,'MARIA ESTELA MARIN',NULL,'2057794',1,'EX ESPOSA DE ALBERTO SUAREZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1797,'MARIA MARIN CHAVEZ',NULL,NULL,1,'HIJA DE LUCY CHAVEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1798,'VERONICA CASTRO',NULL,'5900253',1,'NOVIA DE WIL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1799,'MARCELINA ALFONSO SILVA',NULL,'4430427',1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1800,'KRIS ROJAS',NULL,'4871090',1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1801,'ZUNILDA VILLASBOA VILLALBA',NULL,NULL,1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1803,'BLANCA FLEYTAS DE DUARTE',NULL,'1329310',1,'RCA DEL PY CERCA DEL TANQUE DE AGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1804,'ALDO LOPEZ ESCOBAR',NULL,NULL,1,'ESPOSO DE MARIAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1806,'LAURA CACERES MOREL',NULL,'5079921',1,'EL MANJAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1807,'RAMON DANIEL VILLALBA OVELAR',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1808,'FRANCISCO EZEQUIEL GONZALEZ LEZCANO',NULL,'5530778',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1810,'WILFRIDO FERREIRA MARTINEZ',NULL,'1959599',1,'HNO ISIDORO MARTINEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1811,'ANA VILLAGRA',NULL,NULL,1,'CUNHADA DE MATIAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1812,'DOMINICA FERREIRA',NULL,NULL,1,'RECOM ELI AQUINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1813,'FERNANDO CATRIEL PRESENTADO PEREZ',NULL,'4947869',1,'A UNA CUADRA DE HELADERIA AMOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1815,'JUSTO EZEQUIEL CARRERA',NULL,NULL,1,'NIETO FLORENTINA MONGES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1817,'MAGDALENA GOMEZ',NULL,'1993747',1,'MAMA DE MILCA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1819,'MARIA ELISA ESPINOLA',NULL,'1171431',1,'VEC DON CESAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1820,'GERARDO FLEYTAS ORTIZ',NULL,'6666128',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1821,'JOSE MELGAREJO BENEGAS',NULL,'4893334',1,'HIJO NHA JUSTINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1822,'ZULLI DELVALLE',NULL,NULL,1,'DESPENSA DEL VALLE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1823,'DARIO JAVIER AGUERO',NULL,'29637260',1,'CAMINO CANCHA 13 DE JUNIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1824,'FABRICIO ALCARAZ FERNANDEZ',NULL,NULL,1,'HIJO DE SONIA ALCARAZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1825,'CLOTILDE OVELAR',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1826,'TEODORA LARROZA',NULL,'2550326',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1827,'NILDA ESPINOLA',NULL,'3766813',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1828,'ERVIN ADRIAN FRANCO',NULL,'1747221',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1829,'CHRISTIAN CHAVEZ',NULL,NULL,1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1830,'MIGUEL ALMEIDA',NULL,'5378730',1,'CUNHADO DE JOSE LUIS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1831,'ALEXIS ESCOBAR',NULL,'6796605',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1832,'RAUL FRETES',NULL,'4631369',1,'HNO DE VIVI CONT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1833,'VANESSA LEIVA',NULL,'5002061',1,'HNA DE ROSAURA LEIVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1834,'INOCENTE SALVADOR GONZALEZ',NULL,'22333865',1,'NILDA RUIZ DIZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1835,'MIRIAN E, FLEYTAS L.',NULL,NULL,1,'TIA DE DAHIANA - FRACCION AURORA ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1836,'LAURA VANESA ROJAS',NULL,'39916418',3,'KM17 CANHADA - LUQUE - VICTOR GAMARRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1837,'CRISTINA CENTURION',NULL,NULL,2,'CNELGRACIA 1388 Y ALEJO GARCIA /HNA DE CENTURION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1838,'BELINDA VALLEJOS',NULL,'5795501',1,'PARIENTE DE SALVADOR LEIVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1839,'LUCIO MARECOS',NULL,'1634246',1,'CAMBOYA/REC. DE CELESTINA OVELAR / VALLEJOS TEBC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1840,'JUAN ANDRES CABRERA',NULL,NULL,1,'A 400 MTS DEL ORATORIO SAN MIGUEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1841,'MARTA G, AYALA',NULL,'5620981',1,'SNTA CATALINA C/HERRERIA 2 HBOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1842,'MIGUEL ANGEL GONZALEZ',NULL,'6195395',1,'SOBRINO DE ROSSANA NUNHEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1843,'LUCIA L DUARTE',NULL,'4774003',1,'RESPALDA LIZ MIOREIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1844,'TAMARA RUIZ DIAZ',NULL,NULL,1,'FRENTE A CASA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1845,'ALDO FABIAN DIAZ',NULL,'6541064',1,'FRENTE A PEQUE/REC. VIRGINIA REYES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1846,'ELIZABETH GONZALEZ VAZQUEZ',NULL,NULL,1,'VALLE PUCU SAN MIGUEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1847,'JOSE LUIS FRETES MARTINEZ',NULL,NULL,1,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1849,'LAURA MARECO',NULL,'47984441',1,'VILLA 2 CONTADORA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1850,'ROMINA BELEN RODAS ARAUJO',NULL,'6013735',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1851,'OSCAR DAVID MEDINA ARANDA',NULL,'6624756',1,'NIETO NHA PALMIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1852,'SERGIO LEDEZMA MARTINEZ',NULL,'4699151',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1853,'MARIELA SOLEDAD MEDINA CANDIA',NULL,'4202618',3,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1855,'GLADYS QUINHONEZ DE BENITEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1856,'FRANCISCO PANIAGUA',NULL,'1382930',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1858,'RONALDO F.ARANDA',NULL,'6661572',1,'VILLA SOLIDARIDAD 2 CASA 208',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1859,'DERLYS ESTEBAN OLMEDO',NULL,'5148008',3,'ASENT 2 DE NOV. MORAS CUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1860,'MAURA ENCISO',NULL,'2150978',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1862,'MARCOS AURELIO ESTECHE FLORENTIN',NULL,'4876503',1,'HIJO MARIA N ESTECHE VEC DE ARMINDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1863,'ALBERTO D GUILLEN VILLAGRA',NULL,'6651386',1,'PARIENTE DE MATIAS RUIZ DIAZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1864,'BRAHIAN GALEANO C',NULL,'5446045',1,'MARIA AUXILIADORA ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1865,'MARIA ANGELICA GOMEZ R',NULL,'50700293',1,'HNA DE MILCA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1867,'ALDO RAMON SANCHEZ SILVA',NULL,'4991583',3,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1869,'HECTOR RAUL AMARILLA',NULL,NULL,1,'ESPOSO DE MIRIAN COLMAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1870,'IXIDA MARECOS DE MERELES',NULL,'2901039',1,'MAMA DE TEODOLINA MERELES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1871,'VICTOR HUGO FERNANDEZ ALFONZO',NULL,'1888673',1,'ESPOSO PELUQ BLANCA NELLY FLEITAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1872,'LUIS CANO FRANCO',NULL,'65125231',2,'PARIENTE DE ELVIO ARZAMENDIA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1875,'MARCELO IBARROLA',NULL,'532326',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1876,'ELVIRA VARGAS',NULL,'1170620',1,'SUEGRA DE MATIAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1877,'BLAS ALBERTO PEREIRA E',NULL,'6669974',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1879,'HERMENEGILDA BARRIENTOS FRANCO',NULL,NULL,1,'RECOM ZULLY DUARTE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1880,'RAMON REYES',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1881,'DIONICIA CHAVEZ',NULL,NULL,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1882,'MONICA LETICIA JARA RUIZ',NULL,'479634',1,'SOBRINA CONSTANCIA AMARILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1883,'YLSE B CABALLERO H.',NULL,'3001820',1,'FRENTE A JULIO ALONSO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1884,'OSVALDO DOMINGUEZ',NULL,'6574426',1,'RECOM ARSENIO LOPEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1885,'RUTH PAOLA ROJAS BENITEZ',NULL,'4784308',3,'FRACC.JORGE RAUL RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1886,'VICTOR DAMIAN FRETES FERREIRA',NULL,'6692344',1,'SOBRINO ANTONIO BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1887,'DAHIANA NOEMI DUARTE ALONZO',NULL,'5710774',1,'VILLA 3 CAACUPEMI RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1888,'HECTOR ALCIDES SPAINI TOLEDO',NULL,'5729394',1,'ASENT BELEN 1  3196',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1889,'PABLO R VILLALBA  P',NULL,'5940763',1,'CONAVI 220',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1890,'FANY SALINAS',NULL,NULL,1,'VECINA DE IVON FERREIRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1892,'MILAGROS MOSQUEIRA',NULL,'6564188',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1894,'MIRTHA NOELIA HERMOSILLA BENITEZ',NULL,NULL,1,'VALLE PUCU  8 DE SETIEMBRE RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1895,'YISEL BARRIOS',NULL,'5502567',5,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1896,'MIGUEL A LOPEZ JARA',NULL,NULL,1,'RECOM RAMON PRESENTADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1897,'VIVIANA RODRIGUEZ',NULL,'6645292',1,'RECOM JUAN C RIQUELME HIJA NORMA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1899,'DIANA FERNANDEZ',NULL,'4815299',3,'CAMBORIU Y JULIO CORREA RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1900,'ENRIQUE J ZEBALLO FERNANDEZ',NULL,'2436979',1,'PROFE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1901,'ANTONIO BOBADILLA',NULL,'1238446',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1902,'YENIFER L RAMIREZ CARDOZO',NULL,'5818833',1,'CERCA DE MARIA LA PELUQ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1903,'RICARDO GUANES DIEZ',NULL,'2829584',1,'VEND DE ZAPATILLAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1904,'ALCIDES ADORNO',NULL,'4517829',3,'PARIENTE DE RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1905,'ALEXIS D BENITEZ',NULL,'6812354',1,'HNO DE IRMA BENITEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1906,'ROMINA DIAZ BAEZ',NULL,'5035902',1,'HIJA DE RAMONA BAEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1907,'JAMILA ARAUJO DELGADO',NULL,'5027717',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1908,'JESUS A RODAS IRALA',NULL,'3387977',1,'HNO DE MARISOL FRENTE A RENE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1909,'FABIANA TORRES SILVA',NULL,NULL,1,'CAACUPMEI',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(1910,'LADISLAA MARTINEZ',NULL,NULL,1,'SRA DE SALVADOR LEIVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1911,'JORGE EZEQUIEL GONZALEZ',NULL,'5216296',1,'NIETO DE CIRILA TALAVERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1912,'JORGE D. RODAS',NULL,'4309639',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(1913,'LEONEL EZEQUIEL LEIVA',NULL,'423128556',1,'HIJO DE CLAUDELINO LEIVA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1915,'NATALIA FRETES',NULL,'6112905',1,'HERMANA DE VIVI CONT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1917,'JOEL GREGORIO VELOZO',NULL,'4332844',1,'CERCA DE CAPILLA MA. AUXILIADORA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1918,'JULIO CESAR ALARCON',NULL,'2854948',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1919,'MARIA ELENA RODAS',NULL,'5127699',1,'HIJA IDALINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1920,'LIZ BAREIRO CANHETE',NULL,'6144361',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1921,'MIGUEL ANGEL ROLON VALDEZ',NULL,'5084805',1,'ARTE CHACHO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1922,'HIGINIO ALCARAZ GRANCE',NULL,'4717103',1,'RECOM JUANA MARIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1923,'LUZ MARIANA FARINHA VARGAS',NULL,'5837264',1,'CUNHADA DE MATIAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1924,'GRACIELA MARIA AYALA A',NULL,'5438928',1,'CHELI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1925,'MARGARITA RODAS CABALLERO',NULL,'1133559',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1926,'NANCY CABANHAS BAREIRO',NULL,'2489567',1,'COCINERA EN SAN AGUSTIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1927,'ANTONIO VERA',NULL,NULL,1,'CAPATAZ DE RUTA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1928,'ALFREDO CABRAL',NULL,'3537210',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1929,'MARIA NILCE MARTINEZ',NULL,'3692286',1,'VILLA ROSITA CERCA BOBADILLA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1930,'CAMILA CABRERA CABALLERO',NULL,'4990830',1,'DETRAS DE LOS MORMONES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1932,'BERNARDINO OSORIO ARANDA',NULL,NULL,1,'HNO DE REINALDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1933,'MARCELO FABIAN RIVEROS NUNHES',NULL,NULL,3,'FLOR DE ITAPUAMI RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1935,'MARIA ADELA JARA NAVARRO',NULL,'2085858',1,'MAMA DE LINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1936,'NANCY FRETES',NULL,'2233996',1,'MAMA DE LILIAN MEDINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1937,'LIZ ANDREA RAMIREZ IBARROLA',NULL,'5408071',3,'FRENTE COLEG SAN LUIS -COSTADO PLAZA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1939,'VICTOR DANIEL NUNHEZ PEREZ',NULL,'4894510',1,'OBRERO CASI 30 DE AGOSTO HNO ROSSANA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1940,'JENNY GONZALEZ',NULL,'5842927',3,'RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1942,'JESSICA ELIZABETH BENITEZ RAMIREZ',NULL,NULL,1,'SOBRINA DE MARIA TRAB CON GERONIMO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1943,'ALEXIS R RUIZ DIAZ TORREZ',NULL,'4085292',1,'RECOM CRISTHIAN ALVARENGA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1945,'FATIMA NOELIA ACUNHA',NULL,'4555351',1,'HIJA DE FRANCISCO ACUNHA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1946,'JUDITH MARIA GALEANO',NULL,'4957232',3,'STA RITA Y SANTA CATALINA VEC. FAUSTINO BOGADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1947,'CRISTIAN DAVID AEDO ORTIZ',NULL,'6244374',1,'VECINO NHA LUISA ,RECOM DON CARLOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1948,'CELSA ROTELA MOLINAS',NULL,NULL,1,'ASENT.SAN FRANCISCO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1949,'LURDES A. FRANCO',NULL,'4444655',1,'ARA PYAHU VEC ROSSANA NUNEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1951,'ELSA CACERES GAUTO',NULL,'4011295',1,'SAN LUIS ,FRACC IRUN LOTE 6',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1952,'MARIO RAMOS GIMENEZ',NULL,'5463956',1,'MATEO SAAVEDRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1953,'CARLOS CABRERA',NULL,'2517065',1,'HNO DE BEBETO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1954,'BLANCA DE DUARTE',NULL,NULL,1,'DETRAS DE LA CANCHA SINTETICA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1955,'PERCIO N BECKER',NULL,'393020',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1956,'YENIFER ESCOBAR',NULL,'6239019',1,'SOBRINA DE ALDO GONZALEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1957,'VERONICA ORTEGA',NULL,'2671101',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1958,'ANGEL VARGAS',NULL,NULL,1,'HNO DE LINEO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1959,'MARIA ELENA LEGAL',NULL,'3469831',1,'RECOM DE BLASIDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1960,'AQUILINA GONZALEZ',NULL,'1291552',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1961,'YESSICA SANABRIA',NULL,'5812774',1,'RECOM DAYSI OLAZAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1962,'DIANA E CANHETE NUNHEZ',NULL,'5673366',1,'HIJA DE VALENTIN CANHETE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1963,'EMILIO MATEO INSFRAN SOLIS',NULL,NULL,1,'HIJO DE DON EMILIO VECINO DE JAVIER',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1964,'NILZA VILLASBOA',NULL,'5216231',1,'VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1965,'MARCOS RAUL ACOSTA BOGADO',NULL,'2159390',1,'VECINO FAUSTINO BOGADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1966,'FLORENTINO ROJAS VERA',NULL,'5745855',1,'FRENTE A PLAZA 6 DE AGOSTO HACIA NHA ELISA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1967,'SILVERIO ESCOBAR VERA',NULL,'2533935',1,'DE HUGUA REY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1968,'EVER GUSTAVO GONZALEZ',NULL,'4473766',1,'VILLA SAN PEDRO  RECOM VICTOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1969,'OSVALDO RECALDE',NULL,NULL,3,'COMP DE TOCAYO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1970,'DIANA FERNANDEZ',NULL,'5020072',1,'CUENTA DE GUSTAVO FLORENTIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1971,'VIRGINIA ELENA REYES DIAZ',NULL,'5967361',1,'HIJA DE RAMON REYES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1972,'CINTHIA RAMONA MORA',NULL,'5595398',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1973,'MAYRA A OVELAR',NULL,'4846914',1,'VECINA DE MARISOL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1974,'CARMEN RAMOS',NULL,'1093438',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1975,'MAGNA RAQUEL ALMEIDA OJEDA',NULL,'5352046',1,'RECOM FIDELINA GIMENEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1976,'CIRILA VALIENTE FERREIRA',NULL,'4162075',1,'B SANTA RITA RECOM VICTOR VEC FAUSTINO BOGADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1977,'HECTOR LUIS ALVARENGA',NULL,'3219535',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1978,'VICTORIANO HERMOSILLA',NULL,'1329311',1,'CERCA DE VILLAMAYOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1979,'CRISTHIAN SILVA DIAZ',NULL,'2920393',1,'HERMANO DE DANI BICI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1980,'CRISTHIAN MIGUEL GONZALEZ',NULL,'2288804',1,'CURRU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1981,'ELIZABETH MARIA MARTINEZ AQUINO',NULL,'4489518',1,'BEBENCHA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1982,'ANDRESA FRANCO',NULL,'1219786',1,'FRENTE A LA IGLESIA FRENTE A CABRAL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1983,'EDITH MABEL AMARILLA',NULL,'4796850',1,'ESPOSA DE JOSE MERCEDES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1984,'RICARDO DANIEL BERNAL ROJAS',NULL,'5355137',1,'TRAB CACIQUE ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1985,'RAMON BENITEZ PAIVA',NULL,'4619903',1,'YERNO DE NHA CARMEN GORDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1986,'FRANCISCO GONZALEZ ARAUJO',NULL,'2447516',1,'PAN CASERO SAN NICOLAS Y CADETE PANTO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1987,'CESAR DIAZ GOMEZ',NULL,'2057923',1,'RECOM JOEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1988,'JULIO CESAR RIQUELME',NULL,'1453691',1,'HNO DE JUAN C RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1989,'BLANCA N  RIQUELME M',NULL,'5257163',1,'HIJA DE JUAN C RIQUELME',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1990,'TERESA SANCHES LUGO',NULL,'4713668',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1992,'GERARDO JAVIER FLEITAS CUENCA',NULL,'4013707',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1993,'ANGELICA MARIA RODAS CABALLERO',NULL,'4689803',1,'HIJA IDALINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1994,'CRISTHIAN ARANDA PENAYO',NULL,'4366778',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1995,'HIPOLITO SANCHEZ',NULL,'597694',1,'PAPACHIN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1996,'CINTHIA SOLEDAD DUARTE',NULL,'4811884',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1997,'JOSE AUGUSTO CACERES FRETES',NULL,'4772508',1,'HNO DE LILIAN MEDINA  VILLA AMPARO UNA CUADRA DE PARADA CERRP KO I',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1998,'CRISTINA FLEITAS ESPINOLA',NULL,'4822591',1,'SOBRINA DE NELIDA SOSA    PTO CASADO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(1999,'PERFECTO VERA LEIVA',NULL,'1825244',1,'ARRIBA DE CASA DE GUGGIARI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2000,'MARIA LUCILA CHAVEZ A',NULL,'2613068',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2001,'NATALIA VEGA',NULL,'4547353',1,'SRA DE JOEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2002,'RUTH YANINA GUZMAN',NULL,'5183093',1,'FRACCION LAS LINDAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2003,'RUTH ECHEVERRIA',NULL,'4493134',1,'FRENTE A NA HILDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2004,'WALTER ACOSTA',NULL,'1886410',1,'CERCA DE MACARIO/ GRACIELA MIRANDA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2005,'MARINA MERELES',NULL,NULL,1,'ASENTAMIENTO BELEN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2006,'LILIAN ROCIO BENITEZ',NULL,'6704848',1,'GARANT. CESAR LOBOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2007,'MIRYAN A ESCOBAR G',NULL,'4857867',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2008,'JUAN C. LEDESMA R.',NULL,'1918250',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2010,'JUAN CARLOS DOMINGUEZ',NULL,'5241207',1,'VECINO DE TEODOLINA / BELEN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2011,'LIDUVINA FLORENTIN',NULL,NULL,1,'ASENTAMIENTO SAN JORGE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2012,'GERARDO GABRIEL GOMEZ BENITEZ',NULL,'4856272',1,'AVDA CNEL MARTINEZ 5 COMPANHIA MAKAI LUIS ENRIQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2014,'SALUSTIANA SILVA DIAZ',NULL,'3678585',1,'HNA DE JUANITA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2016,'CAROL STEFI SUAREZ BRIZUELA',NULL,'3027178',1,'TRAB EN TIGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2018,'MARIA DEL CARMEN BARRIOS',NULL,NULL,1,'HIJA DE RAIMUNDO BARRIOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2019,'VICENTE DOMINGUEZ ALCARAZ',NULL,'4465134',1,'TIO DE JUAN C DOMINGUEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2020,'JORGE LUIS MELGAREJO',NULL,'3991912',1,'HIJO DE NHA LUCY',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2021,'EVER FRANCO',NULL,'2437202',1,'CUIDADOR DE CASA DENENA PARINI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2022,'MARISA GUANES',NULL,NULL,1,'SRA DE RAIMUNDO BARRIOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2023,'LETICIA SUAREZ MARIN',NULL,'5382875',1,'HIJA DE ALBERTO SUAREZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2024,'REMIGIA RUIZ DIAZ',NULL,'354420',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2025,'JOSE MARIA RODRIGUEZ',NULL,'6167468',1,'RECOM Y VECINO DE DON CARLOS FLEITAS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2027,'FELIX SILVA DIAZ',NULL,'3877095',1,'HNO DE JUANI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2029,'SEBASTIAN AYALA Z.',NULL,NULL,1,'RECOM DE FERNANDO ESQUIVEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2030,'ALAN A. GONZALEZ VERA',NULL,'6687415',1,'SALVADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2031,'DERLIZ A. LEZCANO M',NULL,'2042413',1,'VALLE PUCU CERCA DE LUIS GIMENEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2032,'VIVIANA A VERA DE FERREIRA',NULL,'3982586',1,'VILLA ROSITA / CUNADA DE HIJO DE JUSTINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2033,'RUTH MARINA OCAMPOS',NULL,'4815134',1,'CERCA DE ALISSON/ NA ELISA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2034,'DENISE GAONA',NULL,'1858617',1,'HERMANA DE SARA GAONA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2035,'CYNTHIA JACQUELINE BENITEZ CABRERA',NULL,'2934544',1,'FRENTE A MIRIAN COLMAN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2036,'GISSEL ADOLFINA PRESENTADO PEREZ',NULL,'4947843',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2037,'SHIRLEY JOHANA AYALA',NULL,'4915294',1,'CERCA DE GERARDO SANCHEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2038,'SABA ABRIL PRESENTADO ACOSTA',NULL,'6101616',1,'HNA DE LIDU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2039,'VICTOR SAMANIEGO',NULL,'4959761',1,'HIJO DE PABLO SAMANIEGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2040,'FABRICIO BLASDIMIR ALCARAZ FERNANDEZ','CI','6653406',1,'VILLA LILICA HIJO SONIA ALCARAZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2041,'MARYAM VALERIA ORTIZ PEREZ',NULL,'4895000',3,'YKUA RAPE C ASI SAN JORGE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2042,'EDGAR ANDRES FRANCO D',NULL,'4907803',1,'HIJO DE ANDRES FRANCO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2043,'REINA MARIA ROMERO C',NULL,'6664532',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2044,'REBECA ANAHI ZAPATA RIVEROS',NULL,'5125621',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2045,'ANASTACIO ALBERTO BRITEZ',NULL,'1447541',1,'TRABAJA CON MONKI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2046,'AGUILEO BENEGAS VARGAS',NULL,'5440448',1,'NOVIO DE CAMILA CABRERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2047,'ROCIO SOLEDAD VALDEZ MARTINEZ',NULL,'5422294',1,'CASITA DE PESEBRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2048,'ADOLFINA VILLALBA VERA',NULL,'5409578',1,'SOBRINA FLORENTINA MONGES',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2049,'FELISIA AMARILLA DE ARANDA',NULL,'1294294',1,'8 DE DICIEMBRE SUEGRA DE LAURA MARECO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2050,'ANGELA FABIOLA COLMAN DE PISTILLI',NULL,'24490263',3,'TRABAJA EN ALAMO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2051,'LETICIA B MOREL NUNHEZ',NULL,'5024645',1,'HIJA DE ROSSANA NUNHEZ ARA PYAHU 1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2052,'MARIA ESTHELA SANABRIA DE LA CUEVA',NULL,'4947833',1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2053,'ALEJANDRO JAVIER GIMENEZ ARCE',NULL,'6005228',1,'PEGADON A CAPILLA NINHO SALVADOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2054,'PATRICIA YOLANDA MINEUR AREVALOS',NULL,'4235410',3,'LOMA MERLO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2055,'NICOLAS DIONISIO BARRIOS PEREIRA',NULL,'4727702',1,'RECOM MILCIADES CABRERA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2056,'MARIA LETICIA AGUIRRE GONZALEZ',NULL,NULL,1,'RECOM PATRICIA AQUINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2057,'MELANIA ADORNO DE ALVAREZ',NULL,'2952487',1,'RECOMENDADA X SALUSTIANA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2058,'VICTOR ROJAS FERNANDEZ',NULL,'3264085',1,'RECMEND X FREDY BORDON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2059,'ERIKA BARRIOS',NULL,'5595188',1,'HIJA DE GUIDO BARRIOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2060,'GISELLE BARRIOS',NULL,'5439283',1,'HIJA DE GUIDO BARRIOS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2061,'WALTER LOPEZ',NULL,NULL,1,'CAACUPEMI AREGUA',NULL,NULL,NULL,NULL,NULL,'CAS',1,'N'),
(2062,'PROVEEDOR PARA MIGRACION',NULL,NULL,1,'CAACUPEMI AREGUA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2063,'PERSONA DE PRUEBA',NULL,NULL,1,'DIRECCION DE PRUEBA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2064,'PERSONA OCACIONAL',NULL,NULL,1,'CAACUPEMI AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2065,'CHACOMER SAE','RUC','80013744-2',2,'EUSEBIO AYALA 3321',NULL,'021-518-0000',NULL,NULL,NULL,NULL,NULL,'N'),
(2066,'ANTOLIANA ARGUELLO GONZALEZ','CI','3718146',1,'SANTA CATALINA',NULL,'0985298604',NULL,NULL,NULL,'SOL',NULL,'N'),
(2067,'EDGAR RAMON ORTIZ GIMENEZ','CI','5109518',1,'RENACER III','GARANTE RAMON SARACHO ','0992397587',NULL,NULL,'1983-02-16','SOL',1,'N'),
(2068,'ANA BEATRIZ CODAS GARCIA','CI','4515408',1,'YUQUYTY BAJANDO SAN FRANCISCO DE ASIS',NULL,'0982816061',NULL,'0982816061',NULL,'SOL',1,'N'),
(2069,'FEDERICO GONZALES CHAMORRO','CI','2910039',1,'SAN ROQUE AREGUA ',NULL,NULL,NULL,'0981601350',NULL,'SOL',1,'N'),
(2070,'FRANCISCO VALDEZ RIVEROS','CI','3460586',1,'SAN FRANCISCO ',NULL,'0985199732',NULL,'0985199732',NULL,'SOL',1,'N'),
(2071,'MARIA CASILDA MARTINEZ ','CI','4799521',1,'CAACUPEMI',NULL,'0971630838',NULL,'0971630838',NULL,'SOL',1,'N'),
(2072,'HECTOR ANDRES ARRIOLA CABRERA','CI','2407951',1,'CAACUPEMI','RECOMENDADO DE ARTE-CON BASTON','0994274304',NULL,NULL,NULL,'SOL',1,'N'),
(2073,'CELL','RUC','8000000-0',2,'MERCADO CUATRO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2074,'SAN FERMIN S.A','RUC','80024479-6',3,'LUQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2075,'NGO S.E.C.A','RUC','80014137-7',2,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2076,'CPH S.A','RUC','80083931-5',1,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2077,'RECORD ELECTRIC S.A.E.CA','RUC','80016166-1',2,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2078,'COMERCIAL LAS TORRES','RUC','4032232-7',7,'ITAUGUA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2079,'LA YUTENA S.A','RUC','80023705-6',2,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2080,'J Y B PARTICIPACIONES S.A','RUC','80096456-0',2,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2081,'AGROINDUSTRIAL COLONIAL S.A','RUC','80004573-4',2,'J.EULOGIO ESTIGARRIBIA-CAAGUAZU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2082,'RGA S.A','RUC','80084688-5',2,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2083,'ROLE S.A','RUC','80083590-5',2,'ASUNCION',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2084,'DANIELA IBARROLA TOLEDO','CI','2479993',3,'2 DE NOVIEMBRE - VILLA','VICTOR GAMARRA',NULL,NULL,'0994813930',NULL,'SOL',1,'N'),
(2085,'VICTOR EDUARDO ECHEVERRIA MORA','CI','1410345',1,'CAACUPEMI',NULL,'0971900022',NULL,NULL,NULL,'SOL',1,'N'),
(2086,'APOLONIA FRANCO','CI','606746',1,'CAACUPEMI/ MAMA DE BETTY',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2087,'CARMELO BRITEZ RIOS','CI','1633574',1,'CAACUPEMI - CERCA DE ALFREDO',NULL,NULL,NULL,'0983807737',NULL,'SOL',1,'N'),
(2088,'SABINO JUVENAL CENTENO VELAZQUEZ','CI','569996',1,'AREGUA','JUNTA ELECTORAL',NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2089,'JORGELINA GONZALEZ','CI','3579441',1,'CAACUPEMI....',NULL,'0985450745',NULL,NULL,NULL,'SOL',1,'N'),
(2090,'ROQUE MELGAREJO','CI','1757547',1,'CAACUPEMI','SAN IGNACIO MISIONES NACIO',NULL,'CUNHADO SRA BASTOM',NULL,NULL,'SOL',1,'N'),
(2091,'FANY VIVIANA SALINAS PENAYO','CI','6059889',1,'CAACUPEMI','NACIO EN SANTA ROSA DEL AGUARAY',NULL,NULL,'0985246172',NULL,'SOL',1,'N'),
(2092,'OILDA URBIETA AYALA','CI','4591298',1,'NHANDEROGARA CAACUPEMI',NULL,'0983716785',NULL,NULL,NULL,'SOL',1,'N'),
(2093,'FELIPE CERDA','CI','16432701',3,'LUQUE',NULL,NULL,'0986540539',NULL,NULL,NULL,2,'N'),
(2094,'EMILIANO ARIEL ESCOBAR E.','CI','5782568',1,'BARRIO AMANECER CERCA DEL PUESTO DE SALUD','COPETROL CAACUPEMI','0976817274',NULL,NULL,NULL,'SOL',1,'N'),
(2095,'DIVAL ALVARENGA IBARRA','CI','1238973',1,'VILLA 1 / HERMANO DE JORGE ALVARENGA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2096,'RODRIGO MATEO GIMENEZ SOSA','CI','3001870',1,'CAACUPEMI / COPAFI',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2097,'PABLINA GONZALEZ','CI','2903685',1,'CAACUPEMI / CASA DE FERNANDO',NULL,'0992944900',NULL,NULL,NULL,'SOL',1,'N'),
(2098,'CARLOS ALBERTO GIMENEZ FRANCO','CI','4324444',1,'CAACUPEMI / ROMERO','0993257545',NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2099,'ARNALDO SANABRIA DE LA CUEVA','CI','4947848',1,'CAACUPEMI / AMANECER',NULL,'0985638802',NULL,NULL,NULL,'SOL',1,'N'),
(2100,'RODY RONALD  VERA RIVAS','CI','6334217',1,'CAACUPEMI/ TRABAJA EN LACTOLANDA',NULL,'0991431490',NULL,NULL,NULL,'SOL',1,'N'),
(2101,'GABRIEL VILLAR','CI','3923467',7,'KM 31 ITAUGUA/ JULIAN ',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2102,'MODESTO ESQUIVEL','CI ','6579423',7,'ITAUGUA KM 31',NULL,'0985463694',NULL,NULL,NULL,'SOL',1,'N'),
(2103,'LUIS MARTINEZ ','CI','3388055',1,'CAACUPEMI',NULL,'0971192487',NULL,NULL,NULL,'SOL',1,'N'),
(2104,'MONICA S RIVAS','CI','6868944',1,'CERCA DE DON SANCHEZ CAACUPEMI',NULL,'0982706329',NULL,NULL,NULL,'SOL',1,'N'),
(2105,'LUZ MARINA GAMARRA COLMAN','CI','5155021',1,'ARAZA POTY VICINO TIBURCIO',NULL,'0971351855',NULL,NULL,NULL,'SOL',1,'N'),
(2106,'LUIS FERNANDO CACERES S.','CI','3771542',1,'CAACUPEMI',NULL,'0983607177',NULL,NULL,NULL,NULL,1,'N'),
(2107,'CELSO CABRERA','CI','5991259',1,'CAACUPEMI',NULL,'0982443099',NULL,NULL,NULL,'SOL',1,'N'),
(2108,'MARIA LIZ ASUNCION TORRES','CI','3673021',1,'CAACUPEMI',NULL,'0985595278',NULL,NULL,NULL,'SOL',1,'N'),
(2109,'SONIA ELIZABETH OLAZAR FRANCO','CI','4024404',1,'VILLA DEL MAESTRO',NULL,'0992438815',NULL,NULL,NULL,'SOL',1,'N'),
(2110,'JESUS ESQUIVEL','CI','6615181',7,'KM 31 ITAUGUA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2111,'DIEGO ARECO','CI','4022580',1,'CAACUPEMI /IREON',NULL,'0991901769',NULL,NULL,NULL,'SOL',1,'N'),
(2112,'URBANA VALENZUELA','CI','5791848',1,'CAACUPEMI',NULL,'0971116183',NULL,NULL,NULL,'SOL',1,'N'),
(2113,'PEDRO ZARACHO','CI','5359057',1,'CAACUPEMI',NULL,'0985481712',NULL,NULL,NULL,'SOL',1,'N'),
(2114,'LUIS BOGARIN','CI','3534940',1,'CAACUPOEMI',NULL,'0972623870',NULL,NULL,NULL,NULL,NULL,'N'),
(2115,'PEDRO SAUL BORDON','CI','5046122',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,'CAS',1,'N'),
(2116,'CECILIA MARISA GUANES','CI','3669724',1,'CAMBOYA',NULL,'0981935769',NULL,NULL,NULL,'SOL',1,'N'),
(2117,'CHRISTIAN FELIPE ARIAS ','CI','3767139',1,'SALVADOR A DOS CUADRAS DEL ASFALTO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2118,'VICENTE SIMERLI','CI','1708933',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2119,'SARA ANGELICA RAMOS BARRIENTOS','CI','6155297',1,'CAACUPEMI',NULL,'0991983661',NULL,NULL,NULL,'SOL',1,'N'),
(2120,'CRISTIAN DANIEL VILLALBA ARCE','CI','6881267',1,'CAACUPEMI ASENTAMIENTO ARA PYAHU','HNO DE WILFRIDO',NULL,NULL,'0992333520',NULL,'SOL',1,'N'),
(2121,'SALVADOR SOSA','CI','2340770',1,'VILLA I CAACUPEMI',NULL,'0982429861',NULL,NULL,NULL,'SOL',1,'N'),
(2122,'DALMA ANDREA SALINAS PENAYO','CI','7358765',1,'CAACUPEMI /FANY',NULL,'0985246172',NULL,NULL,NULL,'SOL',1,'N'),
(2123,'ANGEL A ARANDA','CI','6006086',1,'AMANECER CAACUPEMI',NULL,'0991478218',NULL,NULL,NULL,'SOL',1,'N'),
(2124,'MARI ESTELA BARRETO LOPEZ','CI','665934',1,'CASA 308 LAS LINDAS C/FRANCISCA',NULL,'0983709580',NULL,NULL,NULL,'CAS',1,'N'),
(2125,'NICOLAS EDILBERTO CACERES','CI','5118720',1,'GOBERNADOR IRALA C/DR LEIVA CAACUPEMI',NULL,'0991695396',NULL,NULL,NULL,NULL,NULL,'N'),
(2126,'MARIA VICTORIA MEDINA','CI','6252231',1,'CAACUPEMI CERCA DE LA CASA DE ALFREDO',NULL,NULL,NULL,'0994784547',NULL,'SOL',1,'N'),
(2127,'SHIRLEY JAZMIN RODAS RIVEROS','CI','6559988',3,'TRES DE MAYO A SEIS CUADRAS DE LA RUTA TERERE',NULL,'0995673003',NULL,NULL,NULL,NULL,NULL,'N'),
(2128,'NANCY BEATRIZ CABRERA','CI','3462686',1,'CAACUPEMI C/CANCHA 29/ DULCERIA',NULL,'0971677392',NULL,NULL,NULL,NULL,1,'N'),
(2129,'OSVALDO VILLALBA OVELAR','CI','4522353',1,'CAACUPEMI',NULL,'0981315623',NULL,NULL,NULL,'SOL',1,'N'),
(2130,'MARCELO DARIO ORTIZ GRANCE','CI','6193070',1,'CAACUPEMI',NULL,'0982814950',NULL,NULL,NULL,NULL,NULL,'N'),
(2131,'HILARIA MARIN RUIZ','CI','3535183',1,'RECOM DE CELESTINA OVELAR',NULL,NULL,NULL,'0972153775','1980-01-14','SOL',1,'N'),
(2132,'ANA CAROLINA ESTECHE FLORENTIN','CI','4872099',1,'CONAVI',NULL,NULL,NULL,'0985514867','1994-11-07','SOL',1,'N'),
(2133,'FRANCISCO TOLEDO TORRES','CI','458782',1,'VENDEDOR DE CHURRO',NULL,NULL,NULL,'0982255518','1949-10-04','CAS',1,'N'),
(2134,'CRISTIAN DAVID ACOSTA AREVALOS','CI','5882608',1,'CAMPO VI ESQ LOS ARBOLITOS.FRENTE A CIE',NULL,NULL,NULL,'0984742849','1994-01-22','SOL',1,'N'),
(2135,'VICTOR MIGUEL MENDEZ GONZALEZ','CI','5323120',1,'COSTA FLEYTAS A UNA CUADRA DE URUNDEY AL SUR',NULL,NULL,NULL,'0984533845','1997-06-03','SOL',1,'N'),
(2136,'PABLO CABALLERO HERMOSILLA','CI','1826159',1,'BARRIO SAN MIGUEL FRENTE A LA ANTENA DE TIGO',NULL,NULL,NULL,'0985964003','1956-06-07','SOL',1,'N'),
(2137,'GESSICA PAOLA FLEITAS FRETES','CI','4297650',1,'COSTA FLEYTAS A 500M AL NORTE DE LA QUINTA VICENTE',NULL,NULL,NULL,'0994280731','1997-07-04','SOL',1,'N'),
(2138,'MAXIMO PRESENTADO GARCETE','CI','1977626',1,'CERCA DE LA PELU MARIA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2139,'ANTONIO FLORENTIN','CI','5632094',1,'TAJY POTY FRACC ANSELMO',NULL,NULL,NULL,'0991859780','2001-06-09','SOL',1,'N'),
(2140,'ANA ADOLFINA MORENO PASMOR','CI','6229477',1,'CERCA DE LA CASA DE LINO,NOVIA',NULL,NULL,NULL,'0983622360','1997-09-23','SOL',1,'N'),
(2141,'SANDRA ARASELI ACUNHA ZARATE','CI','7159636',1,'VIVE EN CASA DE DON CESAR MONKI',NULL,'0985695957',NULL,NULL,NULL,'SOL',1,'N'),
(2142,'JUAN ALEXIS GUERRERO','CI','5360671',1,'RENACER III MANZANA 7 LOTE5',NULL,NULL,NULL,'0984956819',NULL,'SOL',1,'N'),
(2143,'RAFAEL ALFONSO GONZALEZ','CI','4550104',1,'PEGADO A CASA DE DON CALAITO',NULL,NULL,NULL,'0984233059',NULL,'SOL',1,'N'),
(2144,'CLAUDIA SUSANA VALDEZ MARTINEZ','CI','5531454',1,'RENCER III CAMBOYA',NULL,NULL,NULL,'0983413906','0097-04-10','SOL',1,'N'),
(2145,'JUAN CARLOS GARCIA','CI','3856900',1,'ASENTAMIENTO BELEN',NULL,NULL,NULL,'0985224643',NULL,'SOL',1,'N'),
(2146,'MARIA LILIANA CACERES DE ROMERO','CI','3189177',1,'MARIA AUXILIADORA 14 DE MAYO',NULL,NULL,NULL,NULL,'1965-09-25','SOL',1,'N'),
(2147,'GUILLERMO DAVID REYES VILLALBA','CI','4341452',1,'CAACUPEMI RECOM LUZ VARGAS 0981903512',NULL,NULL,NULL,'0971873883',NULL,'SOL',1,'N'),
(2148,'SEBASTIAN AYALA ZIMERLIZ','CI','5707403',1,'PEDRO J.FLEITAS 8SETIEMBRE FRENTE A FABRICA DE BOLSAS',NULL,NULL,NULL,'0972436266','0094-05-23','SOL',1,'N'),
(2149,'LIDUVINA CRISTAL PRESENTADO ACOSTA','CI','4599513',1,'FRENTE A LA FABRICA DE ULE',NULL,NULL,NULL,'0982843212','0090-10-19','SOL',1,'N'),
(2150,'CANDIDA GONZALEZ CESPEDES','CI','4094512',1,'FRENTE A LA CASA DE  BERNARDINA AYALA',NULL,NULL,NULL,NULL,'0076-11-20','SOL',1,'N'),
(2151,'FLORENCIO RAMIREZ','CI','2896876',1,'FRACCION LAS LINDAS A MEDIA CUADRA DE MONKI',NULL,NULL,NULL,'0986671683','0071-04-29','SOL',1,'N'),
(2152,'ISAIAS AGUERO VILLALBA','CI','1880925',1,'BARIO EBENEZER ',NULL,'0984418447',NULL,NULL,NULL,'CAS',NULL,'N'),
(2153,'FRANCISCA ELIZABETH ORTEGA','CI','5355064',1,'VILLARRICA 184',NULL,'0982469337',NULL,NULL,NULL,NULL,NULL,'N'),
(2154,'FRANCISCO ROJAS CABRERA','CI','3968283',1,'CORONEL MARTINEZ 886/LUQUE',NULL,'0985973881',NULL,NULL,NULL,NULL,NULL,'N'),
(2155,'FREDY MARCELO PRIETO INSFRAN','CI','4840168',1,'CERCA DE CASA DE DON COQUI ','ONONDIVEMI',NULL,NULL,'0992 950801',NULL,'SOL',1,'N'),
(2156,'MARGARITA OTERO DE VALDEZ','CI','4703306',1,'SAN FRANCISCO DE ASIS HACIA TAJY POTY',NULL,NULL,NULL,'0991 595888',NULL,'CAS',1,'N'),
(2157,'ANGELICA MEDINA GONZALEZ','CI','3506464',1,'CERCA DE LUIS GIMENEZ','IPS','0982165109',NULL,NULL,NULL,'CAS',NULL,'N'),
(2158,'YULIANA BELEN CABALLERO ACOSTA','CI','5155008',1,'HIJA DE EUGENIO CABALLERO VEC ASENT SAN JORGE',NULL,NULL,NULL,'0985 352690',NULL,'SOL',1,'N'),
(2159,'MARIA CRISTINA ARZAMENDIA SOLIS','CI','2359336',1,'ASENT BELEN I',NULL,NULL,NULL,'0986 793802',NULL,'SOL',1,'N'),
(2160,'GILBERTO VERA','CI','380795',1,'CERCA DE DON FRETES',NULL,NULL,NULL,'0971 942058',NULL,'CAS',1,'N'),
(2161,'DIONISIO VILLALBA CABALLERO','CI','512959',1,'VECINO NHA FRANCISCA ',NULL,NULL,NULL,'0983 368544',NULL,'CAS',1,'N'),
(2162,'MARIA DE LA CRUZ CABALLERO DE GUANES','CI','1934959',1,'B LAS MERCEDES',NULL,NULL,NULL,'0971 742527',NULL,'CAS',1,'N'),
(2163,'FELICIA GRANCE VDA DE RAMOS','CI','1238972',1,'CALLE CHACO BOREAL  SUEGRA DE PROF ZUNI',NULL,NULL,NULL,'0972 852643',NULL,'VIU',1,'N'),
(2164,'SANTIAGO ARANDA ALFONSO','CI','2834070',1,'CAPIATA KM 21 ROJAS CANHADA',NULL,NULL,NULL,'0981 219452',NULL,'SOL',1,'N'),
(2165,'GUSTAVO DANIEL FRETES CACERES','CI','3535040',1,'DETRAS DE CFA CONAVI',NULL,NULL,NULL,'0992486916',NULL,'SOL',1,'N'),
(2166,'BASILIA URBIETA DE BENITEZ','CI','3339481',1,'MAMA DE JOSE LUIS BENITEZ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2167,'RAMON MARIN BOLBE','CI','607279',1,'ARA PUAHU 6159',NULL,'0982916499',NULL,NULL,NULL,NULL,NULL,'N'),
(2168,'ROBERTO BAEZ','CI','1745458',3,'HULERO',NULL,'0961686162',NULL,NULL,NULL,NULL,NULL,'N'),
(2169,'BERNARDO ORUE MORA','CI','2102270',1,'CAACUPEMI/ UJIER DE ASUNCION',NULL,'0982389353',NULL,NULL,NULL,NULL,NULL,'N'),
(2170,'ARSENIO A DIAZ VIVEROS','CI','5094566',1,'RECOMENDADO DE FEDERICO GONZALEZ',NULL,'0981601350',NULL,NULL,NULL,NULL,NULL,'N'),
(2171,'MARIA GLORIA UCEDO DELGADO','CI','3510860',3,'KM 18 VIA FERREA /VICTOR',NULL,'092255103',NULL,NULL,NULL,NULL,NULL,'N'),
(2172,'LAURA RAMONA MINEUR AREVALOS','CI','2941610',3,'PARAPITI C  KARANDAY,TY','GARANTE PATRICIA ,MINEUR','0992261712',NULL,NULL,NULL,NULL,NULL,'N'),
(2173,'NATALIA MARTINEZ RODRIGUEZ','CI','4548192',1,'CALLE KIESE CASA NARANJA REJA NEGRA',NULL,'0972575615',NULL,NULL,NULL,NULL,NULL,'N'),
(2174,'HUGO ALCIDES BOGADO AVALOS','CI','1721668',1,'EN LA VILLA DE REMONTA',NULL,NULL,NULL,'0985 588618',NULL,'CAS',1,'N'),
(2175,'JOSE MANUEL IBARRA','CI','6128180',3,'VILLA POLICIAL MORAS CUE',NULL,NULL,NULL,'0972472695',NULL,'SOL',1,'N'),
(2176,'AURELIA ARECO AQUINO','CI','1573681',1,'CAACUPEMI',NULL,NULL,NULL,'0981 889705',NULL,'CAS',1,'N'),
(2177,'GUSTAVO JOEL SANABRIA BENITEZ','CI','5908676',1,'CAPIATA KM21 CANHADA',NULL,'0982987254',NULL,NULL,NULL,'SOL',1,'N'),
(2178,'ALCIDES ECHEVERRIA CABRERA','CI','1857590',1,'CAACUPEMI',NULL,'0961508236','021634063',NULL,NULL,'CAS',1,'N'),
(2179,'MERCEDES RAMIREZ','CI','3181448',1,'CAACUPEMI',NULL,'0982767658',NULL,NULL,NULL,'CAS',1,'N'),
(2180,'CARLOS O^HIGGINS','CI','1679990',1,'CONAVI CAACUPEMI /HIELOS BARILOCHE',NULL,'0991555508',NULL,NULL,NULL,NULL,NULL,'N'),
(2181,'CRISTHIAN PAIVA','CI','6021535',1,'CAACUPEMI',NULL,'0971376292',NULL,NULL,NULL,NULL,NULL,'N'),
(2182,'ESTELVINA LEIVA','CI','2224850',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2183,'ALCIDES CABRERA ARANDA','CI','809976',1,'A 2 CUADRAS DE NHA IDALINA',NULL,NULL,NULL,'0985 817665',NULL,'CAS',1,'N'),
(2184,'LILIANA RODRIGUEZ BENITEZ','CI','3221180',1,'EMETERIO BENITEZ- PELUQ OSCAR',NULL,NULL,NULL,'0982 956065',NULL,'CAS',NULL,'N'),
(2185,'MARCO ALEJANDRO FRANCO ACOSTA','CI','6008551',1,'LAPACHO C/CRUZ DE CRISTO HNO DE JUANITA FRANCO',NULL,NULL,NULL,'0981-846134',NULL,'SOL',1,'N'),
(2186,'VICTOR HUGO GALARZA MIRO','CI','5027880',1,'VILLA ROSITA ESPOSO DE LA SOBRINA DE CECI',NULL,NULL,NULL,'0991-940644',NULL,'CAS',1,'N'),
(2187,'NICOLE NAYELI CENTURION MENDOZA','CI','5334115',3,'DEL MAESTRO 850 C/FELIPE G 4TO BARRIO MORA CUE',NULL,NULL,NULL,'0991-725763',NULL,'SOL',1,'N'),
(2188,'JORGE ALFREDO MORENO JARA','CI','3301214',1,'ISLA VALLE ',NULL,'0984520063',NULL,NULL,NULL,NULL,NULL,'N'),
(2189,'RONALD RICARDO GALEANO VULETICH','CI','3477586',2,'AVDA DEL PUEBLO 593 LAMBARE',NULL,'0982944970',NULL,NULL,NULL,NULL,NULL,'N'),
(2190,'MARCOS MIGUEL SANCHEZ','CI','2390267',1,'LUZ DE LUNA AREGUA',NULL,NULL,NULL,'0991288796','1985-02-13','SOL',1,'N'),
(2191,'ANA MIRTHA VIVIANA UDRIZAR LOPEZ','CI','3401697',3,'MORA CUE',NULL,NULL,NULL,'0981684802','1982-10-31','SOL',1,'N'),
(2192,'EVA MARLENE ORZUZA SANCHEZ','CI','3705854',1,'VILLA AMPARO',NULL,NULL,NULL,'0984321254',NULL,'SOL',1,'N'),
(2193,'NELSON ANTONIO ESCOBAR ROMERO','CI','4323183',1,'CAACUPEMI',NULL,NULL,NULL,'0984580779',NULL,'SOL',1,'N'),
(2194,'LORENZO ANDRES BAEZ ESTECHE','CI','6646054',1,'TAJY POTY',NULL,NULL,NULL,'0982968430',NULL,'SOL',1,'N'),
(2195,'YOLANDA LOPEZ','CI',NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2196,'TERESA GONZALEZ',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2197,'GLADYS ALVARENGA',NULL,NULL,1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2198,'OVIDIO GONZALEZ VERA','CI','6357915',1,'ASENT ISRAEL CAACUPEMI','GABRIELA MARGARITA ACEDEVO /GARANTE','0976951767',NULL,NULL,NULL,NULL,NULL,'N'),
(2199,'IRENE MARTA PEREZ DE ZARATE','CI','1329367',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2200,'YOLANDA BEATRIZ  GONZALEZ','CI','4542032',1,'CUNHADA DE KOKI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2201,'JORGE LUIS CACERES','CI','2367080',1,'YUKYRY FRACCION SAN MIGUEL',NULL,NULL,NULL,'0984676273',NULL,'SOL',1,'N'),
(2202,'ELISA OVELLA BENITEZ','CI','2335711',1,'FRACCION LAS LINDAS',NULL,NULL,NULL,'0982165213',NULL,'SOL',1,'N'),
(2203,'HORTENCIA BEATRIZ TORRES CHAMORRO','CI','5503504',1,'EUGENIO GARAY C/TEODORO LABRANO','HOSPITAL DE AREGUA','0975390614',NULL,NULL,NULL,NULL,NULL,'N'),
(2204,'HUGO JAVIER VERGARA MILLOT','CI','4849866',1,'CERCA DE GALLIAR',NULL,NULL,NULL,'0984-559754',NULL,'SOL',1,'N'),
(2205,'HECTOR DARIO PRESENTADO MARTINEZ','CI','5212151',1,'FRACC MARIA LETICIA',NULL,NULL,NULL,'0992-278731',NULL,'SOL',1,'N'),
(2206,'JONATHAN DAVID GARCIA LUGO','CI','6091626',1,'CENTRO DE SALUD A 200 MTS',NULL,NULL,NULL,'0991-820815',NULL,'SOL',1,'N'),
(2207,'MONICA MARGARITA FERNANDEZ CHAVEZ','CI','5045095',1,'MARIA AUXILIADORA',NULL,NULL,NULL,'0984-290082',NULL,'SOL',1,'N'),
(2208,'JULIA BARRIOS','CI','3636625',1,'CERCA DE NHA ELISA',NULL,NULL,NULL,'0991-277336',NULL,'SOL',1,'N'),
(2209,'JUAN DARIO MORENO NUNHEZ','CI','4559600',1,'CAACUPEMI',NULL,NULL,NULL,'0985-504024',NULL,'SOL',1,'N'),
(2210,'ANIBAL ANDRES ZARATE FIGUEREDO','CI','2908416',1,'CAACUPEMI',NULL,NULL,NULL,'0981656788',NULL,NULL,1,'N'),
(2211,'RODY RODOLFO VAZQUEZ','CI','3846704',1,'A 200M DE LA ESC MARIA AUXILIADORA (POLICIA)',NULL,NULL,NULL,'0995683566',NULL,NULL,1,'N'),
(2212,'ANDRES DANIEL MOLINARI','CI','5242944',1,'VILLA SALVADOR 321',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2213,'RUFINO OVIEDO PORTILLO','CI','2213620',1,'ASENTAMIENTO ARA PYAHU',NULL,NULL,NULL,'0981193294',NULL,NULL,NULL,'N'),
(2214,'OSVALDO VILLALBA OVELAR','CI','452235',1,'CERCA DE NA GENARA',NULL,NULL,NULL,'0981315623',NULL,NULL,1,'N'),
(2215,'MARGARITA CARDENAS VERA','CI','2553191',1,'FRACC LUZ DE LUNA',NULL,NULL,NULL,'0983-204608',NULL,'SOL',1,'N'),
(2216,'CRISTHIAN ANDRES IBARROLA','CI','5059238',1,'CAACUPEMI',NULL,NULL,NULL,'0986-628375',NULL,'SOL',1,'N'),
(2217,'OSCAR ALFREDO ESCOBAR ESTIGARRIBIA','CI','3519715',1,'VILLA 3 CERCA DE MACARIO',NULL,NULL,NULL,'0976-811552',NULL,'SOL',1,'N'),
(2218,'LUCIANA LUJAN','CI','857654',1,'NHA LUCI',NULL,NULL,NULL,'0982-417217',NULL,'SOL',1,'N'),
(2219,'ANTOLIANA CABRERA MAQUEDA','CI','596977',3,'TTE ROJAS SILVA ESQ YEGROS',NULL,NULL,NULL,'0976-489049',NULL,'CAS',1,'N'),
(2220,'ROMINA RAMIREZ CANTERO','CI','5637920',1,'SAN MIGUEL CERCA ANTENA DE TIGO',NULL,NULL,NULL,'0982-261146',NULL,'SOL',1,'N'),
(2221,'FATIMA MARILENA GARCIA','CI','63363207',1,'A 4 CUADRAS DE LA ESCUELA SION',NULL,NULL,NULL,'0991541191',NULL,'SOL',1,'N'),
(2222,'ESCOLASTICA CABRERA','CI','4302618',1,'CALLE KIESE',NULL,NULL,NULL,'0971-696191',NULL,'SOL',1,'N'),
(2223,'YAMILE ANDREA RODAS GAUTO','CI','6246488',1,'DR BLAIRES DETRAS DE LA CCOP.',NULL,NULL,NULL,'0994-592790',NULL,'SOL',1,'N'),
(2224,'GLADYS MARLENE FERREIRA VERA','CI','3457616',1,'ASENT SAN JORGE',NULL,NULL,NULL,'0985-849374',NULL,'SOL',1,'N'),
(2225,'ERICO ARSENIO DUARTE NUNHEZ','CI','1940150',1,'MANJAR',NULL,NULL,NULL,'0986-473586',NULL,'CAS',1,'N'),
(2226,'LUIS FERNANDO FRANCO DIAZ','CI','4907807',1,'HIJO ANDRES FRANCO',NULL,NULL,NULL,'0992-298946',NULL,'SOL',1,'N'),
(2227,'FATIMA MARIELA GARCIA','CI','6363207',1,'4 CUADRAS DE ESCUELA SION',NULL,NULL,NULL,'0991-736731',NULL,'SOL',1,'N'),
(2228,'SUSANA ESTIGARRIBIA','CI','3538413',1,'CAACUPEMI',NULL,NULL,NULL,'0994659275',NULL,NULL,1,'N'),
(2229,'JAVIER EMELIANO DUARTE BENITEZ','CI','3221246',1,'SAN ANTONIO',NULL,NULL,NULL,'0981552499',NULL,NULL,1,'N'),
(2230,'MAXIMO RAMON MARTINEZ LOPEZ','CI','1404440',1,'REMONTA',NULL,NULL,NULL,'0982149818',NULL,NULL,NULL,'N'),
(2231,'SOLEDAD BALBUENA','CI','36756780',1,'HERMANA DE MARISOL',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2232,'LUZ CLARA RODAS CABALLERO','CI','5038393',1,'CACUPEMI',NULL,NULL,NULL,'0991692106',NULL,NULL,1,'N'),
(2233,'LUCIA ELIZABETH VILLALBA BARRIOS','CI','4974243',1,'VECINA NA FRANCISCA',NULL,NULL,NULL,'0981781268',NULL,NULL,1,'N'),
(2234,'ELDA QUINONEZ','CI','1830748',1,'FREEBTE A LA CANCHA UNION',NULL,NULL,NULL,'0986684343',NULL,NULL,1,'N'),
(2235,'VICTOR HUGO BENITEZ','CI','79690',1,'CAACUPEMI RECOMENDADO DE ARSENIO LOPEZ',NULL,NULL,NULL,'0985580909',NULL,NULL,1,'N'),
(2236,'VICTOR HUGO BENITEZ','CI','796980',1,'CAACUPEMI RECOMENDADO DE ARSENIO LOPEZ',NULL,NULL,NULL,'0985580909',NULL,NULL,1,'N'),
(2237,'ANDRES NICOLAS FRANCO DIAZ','CI','3968299',1,'HIJO DE ANDRES FRANCO/ MARIA AUXILIADORA',NULL,'0981595188',NULL,'C',NULL,NULL,NULL,'N'),
(2238,'MAGALI MARISOL AYALA VERA','CI','5308382',1,'COCUE GUAZU',NULL,NULL,NULL,'0991845623',NULL,NULL,1,'N'),
(2239,'EMIGDIO JAVIER RODRIGUEZ GONZALEZ','CI','6012384',1,'CAACUPEMI KESUI',NULL,NULL,NULL,'0992670553',NULL,NULL,1,'N'),
(2240,'CLAUDIA FIDELITA TORRES','CI','2120970',1,'COSTA FLEYTAS /VICTOR',NULL,'0',NULL,NULL,NULL,NULL,NULL,'N'),
(2241,'JUAN ARIEL GIMENEZ SAID','CI','4840101',1,'CAACUPEMI/VICTOR',NULL,'0982194455',NULL,NULL,NULL,NULL,NULL,'N'),
(2242,'LIZ MARLENE RODAS RIVEROS','CI','4986739',1,'CONAVI',NULL,'0982789017',NULL,NULL,NULL,NULL,NULL,'N'),
(2243,'FATIMA GISELL CABALLERO MARIN','CI','4882134',1,'CAACUPEMI',NULL,'0961361863',NULL,NULL,NULL,NULL,NULL,'N'),
(2244,'CESAR FRANCISCO LOBOS CACERES','CI','4728194',1,'CAACUPEMI',NULL,'0971574174',NULL,NULL,NULL,NULL,NULL,'N'),
(2245,'RUBEN ELIAS RODAS IRALA','CI','3387981',1,'CAACUPEMI',NULL,NULL,NULL,'0983237413',NULL,NULL,1,'N'),
(2246,'GERONIMA PRESENTADO','CI','1937612',1,'FRENTE A EMILIANO',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2247,'ARTURO ARIEL REY MORA','CI','3957196',1,'DETRAS DE LA CANCHA DEL 26',NULL,NULL,NULL,'0981-170363',NULL,'SOL',1,'N'),
(2248,'GUILLERMINA ORTIZ ARAMBULO','CI','2051603',1,'CERCA DE LA ANTENA DE TIGO TELE TUBI',NULL,NULL,NULL,'2051603',NULL,'CAS',1,'N'),
(2249,'CLOTILDE LUISA LEIVA','CI','2187772',1,'COSTURERA',NULL,NULL,NULL,'0981-806115',NULL,'SOL',1,'N'),
(2250,'ARNALDO REYES TROCHE','CI','4801852',1,'CAACUPEMI',NULL,NULL,NULL,'0985-203962',NULL,'SOL',1,'N'),
(2251,'CRISTOBAL DARIO CABANHAS / CHEQUI','CI','563113',1,'CAACUPEMI FRENTE RENE',NULL,'0982228975',NULL,NULL,NULL,NULL,NULL,'N'),
(2252,'FELIPE BENITEZ CABRERA','CI','3319456',1,'CERCA DEL LAGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2253,'OSCAR RAMON JAVIER GUERRERO CABRAL','CI','2599113',1,'TRABAJA EN BENE',NULL,'0981695908',NULL,NULL,NULL,NULL,NULL,'N'),
(2254,'VICTOR MANUEL RODAS GAUTO','CI','4679309',1,'DETRAS DE COPAFI HNO DE JORGE RODAS',NULL,NULL,NULL,'0976566454',NULL,NULL,1,'N'),
(2255,'JOSE SEBASTIAN DELGADILLO CABALLERO','CI','5141530',1,'HIJO NHA IDALINA',NULL,NULL,NULL,'0991-202660',NULL,'SOL',1,'N'),
(2256,'MIGUEL ANGEL BENITEZ','CI','1493180',1,'PEGADO A PELUQ OSCAR    SUEGRO DEL MARMOLERO',NULL,NULL,NULL,'0981-938109',NULL,'CAS',1,'N'),
(2257,'LOIDA BENITEZ DE GONZALEZ','CI','1875955',1,'FRACC LA LINDA 104',NULL,NULL,NULL,'0986-819537',NULL,'CAS',1,'N'),
(2258,'MIRTHA FERNANDEZ','CI','5262158',1,'MEDIA CUADRA DE LA ESC SAN ANTONIO MANO IZQUIERDA',NULL,NULL,NULL,'0983885267',NULL,NULL,1,'N'),
(2259,'HILDA GRACIELA PEREIRA SILVERO','CI','4525142',1,'ARA PUAHU / CERCA DE LO DE EMI',NULL,'0982845890',NULL,NULL,NULL,NULL,NULL,'N'),
(2260,'HUGO ALCIDES BOGADO SOTELO','CI','4825327',1,'REMONTA/MILITAR',NULL,'0986192599',NULL,NULL,NULL,NULL,NULL,'N'),
(2261,'LOURDES RAMONA ZARACHO BENITEZ','CI','4350186',1,'CONAVI',NULL,'0991840594',NULL,NULL,NULL,NULL,NULL,'N'),
(2262,'ORLANDO PATRICIO BOGADO SOTELO','CI','4824990',3,'REMONTA PERSONAL MILITAR',NULL,'0994885531',NULL,NULL,NULL,NULL,NULL,'N'),
(2263,'AURELIA ALFONZO MARTINEZ','CI','2868354',1,'CAACUPEMI',NULL,'0984191208','0976811552',NULL,NULL,NULL,NULL,'N'),
(2264,'DERLIS ANDRES BENITEZ DELVALLE','CI','6759972',1,'CAACUPEMI',NULL,'0973400346',NULL,NULL,NULL,NULL,NULL,'N'),
(2265,'ELVIO RAMON AVILA BENITEZ','CI','1809235',1,'CAACUPEMI/CERCA DE CONSUL REFR',NULL,'0985357187',NULL,'C',NULL,NULL,NULL,'N'),
(2266,'MAGALI LOPEZ','CI','4293174',1,'EMERGENCIA MEDICA AREGUA',NULL,'0991777920',NULL,NULL,NULL,NULL,NULL,'N'),
(2267,'CLAUDIO ANDRES CAPLI PAREDES','CI','3823611',1,'PLAYAS DEL LAGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2268,'DIEGO MOISES VALDEZ BAEZ','CI','4219231',3,'COLON 210 C/BALDERRAMA',NULL,NULL,NULL,'0992-994245',NULL,'SOL',1,'N'),
(2269,'DARIO ANTONIO ARRUA G.','CI','5281571',4,'MRA CUNHADO MARCOS OJEDA',NULL,NULL,NULL,'0991-355744',NULL,'SOL',1,'N'),
(2270,'NORMA GRISELDA RECALDE DE TORRES','CI','3799272',1,'ANTOLIN IRALA',NULL,NULL,NULL,'0982-722340',NULL,'CAS',1,'N'),
(2271,'SILVIA MELGAREJO','CI','3497872',1,'CATANHA 208 ESQ LAUREL',NULL,NULL,NULL,'0981-532576',NULL,'CAS',1,'N'),
(2272,'DIEGO BENICIO PEDROZO MERELES','CI','5067026',1,'COCUE GUAZU ANTES DE LA HNA',NULL,NULL,NULL,'0971-602008',NULL,'SOL',1,'N'),
(2273,'ANDREA DOLORES ALONSO ARRUA','CI','5123863',1,'EUCALIPTO Y TREBOL VILLA SALVADOR','PABLO ROBERTO MIRANDA VILLASBOA /GARANTE','0981326282',NULL,NULL,NULL,NULL,NULL,'N'),
(2274,'HUGO ALFREDO GONZALEZ','CI','6182596',1,'ISLA VALLE/ LAVAD. DE BENE',NULL,'09829076+24','0291432515',NULL,NULL,NULL,NULL,'N'),
(2275,'CARLOS JAVIER SOSA GUERRERO','CI','4421537',1,'ITUGUA','BENE','0986667511','0291432515',NULL,NULL,NULL,NULL,'N'),
(2276,'MIGUEL ALFONSO ','CI','2934804',1,'LUQUE','BENE','0983476324',NULL,NULL,NULL,NULL,NULL,'N'),
(2277,'EDGAR GUSTAVO BAEZ GONZALEZ','CI','1499527',1,'ISLA VALLE AREGUA','BENE','0993411132',NULL,NULL,NULL,NULL,NULL,'N'),
(2278,'JOSE MARIA CENTENO F','CI','8271954',1,'RICARDO PEREZ C/GRAL CABALLERO','EVELIN LEIVA /GARANTE',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2279,'MANUEL PEREZ VILLALBA','CI','4468290',3,'ISLA BOGADO/LUQUE',NULL,'0986872269',NULL,NULL,NULL,NULL,NULL,'N'),
(2280,'CECILIO ECHEVERRIA CABTRERA','CI','684470',1,'GOBERNADOR IRALA',NULL,NULL,NULL,'0983-657129',NULL,'CAS',1,'N'),
(2281,'ARMINDA GAMARRA','CI','4705559',3,'PEDRO JUAN CABALLERO   ',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2282,'GUSTAVO ALFREDO ROA','CI','1749809',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2283,'MIRIAN CONCEPCION GONZALEZ MARTINEZ','CI','6167184',1,'RECOM. MAMA DE BETTY',NULL,'0985697424',NULL,NULL,NULL,NULL,NULL,'N'),
(2284,'GABRIEL CABALLERO MARTINEZ','CI','4685120',1,'CAACUPEMI/FRENTE A DR. VILLAMAYOR',NULL,'0986313086',NULL,NULL,NULL,NULL,NULL,'N'),
(2285,'PERFECTO VERA LEIVA','CI','1824244',1,'FRAY BOLANHOS','0985671661',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2286,'ANASTACIO AGUILERA','CI','1279941',1,'CAACUPEMI/ PADRE DE EDGAR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2287,'JESUS DANIEL RAMOS BARRIENTOS','CI','6155296',1,'GOBERNADOR IRALA  CAACUPEMI',NULL,'0992590419',NULL,NULL,NULL,NULL,NULL,'N'),
(2288,'JOSE DOMINGO ALEN GARAY','CI','5198654',1,'BENE AREGUA / GOMERO',NULL,'0984563887',NULL,NULL,NULL,NULL,NULL,'N'),
(2289,'OSCAR GABRIEL RUIZ DIAZ ACOSTA','CI','3837785',1,'CONAVI AREGUA','BENE CHOFER/ JOEL A',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2290,'MANUEL ALBISO GIMENEZ','CI','1696913',1,'SAN LORENZO KM 10 RECMENDADO DE JOEL AQUINO',NULL,NULL,NULL,'0984-825104',NULL,'SOL',1,'N'),
(2291,'LIZ DAHIANA PAREDES CARDOZO','CI','4362840',1,'VALLE PUCU',NULL,NULL,NULL,'981-207802',NULL,'SOL',1,'N'),
(2292,'OSCAR DARTIO VALDEZ MARTINEZ','CI','5489782',1,'RENACER 3 / CAMBOYA','ROCIO S. VALDEZ M. GARANTE',NULL,'0971472492','0992687977',NULL,NULL,NULL,'N'),
(2293,'MARIA ESTELA ALCARAZ','CI','3773428',3,'POZO AZUL Y 2 DE NOVIEMBRE',NULL,'0982769931',NULL,NULL,NULL,NULL,NULL,'N'),
(2294,'JAVIELA CATALINA LEIVA DE COLMAN','CI','2103219',1,'CAACUPEMI',NULL,'0971546929',NULL,NULL,NULL,NULL,NULL,'N'),
(2295,'PABLO MARTIN GALEANO AYALA','CI','5024412',1,'CAACUPEMI','1/2 CUADRA DE LA IGLESIA SANTA LIBRADA','0994622252',NULL,NULL,NULL,NULL,NULL,'N'),
(2296,'ANA ISABEL ROMERO ARRUA','CI','5791975',1,'TAYY POTY CAACUPEMI','0991253887',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2297,'RAMONA LOPEZ','CI','5761216',1,'8 SETIEMBRE AREGUA',NULL,NULL,NULL,'0991678392',NULL,NULL,1,'N'),
(2298,'ROSA ELIZABETH VILLALBA','CI','4880650',1,'VILLA1 /RECOMENDADO POR DIBAL ALVARENGA',NULL,'0991778381',NULL,NULL,NULL,NULL,NULL,'N'),
(2299,'JUAN CARLOS SAMANIEGO','CI','4664929',1,'CAACUPEMI',NULL,'0992427633',NULL,NULL,NULL,NULL,NULL,'N'),
(2300,'ELIANA NOEMI RODAS ACOSTA','CI','5021915',1,'CAACUPEMI',NULL,'0975279583',NULL,NULL,NULL,NULL,NULL,'N'),
(2301,'MARIA MAGDALENA SALDIVAR MINO ','CI','4935528',1,'GOBERNADOR IRALA CERCA DE LA VERDULERIA YVARAITY ',NULL,NULL,NULL,'0984399347',NULL,NULL,1,'N'),
(2302,'IRENEO FRANCISCO NAVARRO VALIENTE','CI','5041393',1,'VILLA AMPARO',NULL,NULL,NULL,'0972-577407',NULL,'SOL',1,'N'),
(2303,'CESARINA BARRIOS CARDOZO','CI','628592',1,'A LA VUELTA DEL PUESTO DE SALUD -EX SRA DE RECALDE',NULL,NULL,NULL,'0986-464486',NULL,'CAS',1,'N'),
(2304,'CYNTHIA RAMONA BENITEZ','CI','5184268',1,'CABO FRANCISCO ESTIGARRIBIA Y LORENZO AYALA',NULL,NULL,NULL,'0985261229',NULL,NULL,1,'N'),
(2305,'JUAN CUTTIER JIMENEZ','CI','3693417',5,'DR PAIVA Y CAMPO VIA /REC. ARMINDA','0981107341',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2306,'LIZ RUTH SAMUDIO BARRIOS','CI','4196240',1,'BOQUERON  Y 29 DE SETIEMBRE 319','HIJA DE CESARINA',NULL,NULL,'0971-297762',NULL,'SOL',1,'N'),
(2307,'EDITH ANALIA GIMENEZ AVALOS','CI','6268198',1,'CAACUPEMI',NULL,'0983372363',NULL,NULL,NULL,NULL,NULL,'N'),
(2308,'RICHARD DAVID FERNANDEZ BRITEZ','CI','6813805',1,'8DE SETIEMBRE/ VECINO DE VICTOR GAMARRA','0992499717',NULL,NULL,'CI',NULL,NULL,NULL,'N'),
(2309,'ALCIDES TOLEDO GARAY','CI','6621378',1,'COSTA FLEITAS ASENTAMIENTO LOS LAURELES',NULL,NULL,NULL,'0981-723826',NULL,'SOL',1,'N'),
(2310,'GUSTAVO RAMON MARTINEZ SILVA','CI','5075610',1,'VECINA DE ISAIAS',NULL,NULL,NULL,'0992-480438',NULL,'SOL',1,'N'),
(2311,'MARIA LUJAN RODRIGUEZ BENITEZ','CI','4929439',1,'3 DE MAYO',NULL,NULL,NULL,'0981-377241',NULL,'SOL',1,'N'),
(2312,'JESSICA BENITA AQUINO MORALES','CI','5638556',3,'CABO FRANCISCO EST Y LORENZO AYALA',NULL,NULL,NULL,'0975 829711',NULL,'SOL',1,'N'),
(2313,'EULALIO GUMERCINDO JARA BENITEZ','CI','636276',1,'VILLA II',NULL,NULL,NULL,'0985 307444',NULL,NULL,NULL,'N'),
(2314,'MARIELA FLORENCIANI GARCIA','CI','6590086',1,'VIRGEN DE FATIMA DETRAS DEL CEMENTERIO',NULL,NULL,NULL,'0982 183749',NULL,'SOL',1,'N'),
(2315,'ZULMA FERREIRA VERA','CI','1810458',1,'B SAN JORGE CERCA KALAITO',NULL,NULL,NULL,'0985 457283',NULL,NULL,NULL,'N'),
(2316,'RAUL SEERVIN VER','CI','4859426',1,'SAN FRANCISCO TAJY POTY',NULL,NULL,NULL,NULL,NULL,'SOL',NULL,'N'),
(2317,'REINALDO ALVARENGA LEZCANO','CI','4968060',1,'VILLA ALEGRE 9854 /CAACUPEMI',NULL,'0983889752',NULL,NULL,NULL,NULL,NULL,'N'),
(2318,'JORGE DAVID BENITEZ PAREDEZ','CI','7054222',1,'CAACUPEMI DETRAS DE COPETROL A 3 CUADRAS',NULL,'0991427415',NULL,NULL,NULL,NULL,NULL,'N'),
(2319,'LUISA ARSENIA RAMOS','CI','1426512',1,'AREGUA 8 I',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2320,'JONATHAN EZEQUIEL ARANDA QUINHONEZ','CI','5421203',1,'RICARDO PEREZ C/HUMAITA','0981820606',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2321,'MIRELLA DEL CARMEN RUBIRA CASCO','CI','6681852',1,'VILLA 1 SAN MIGUEL',NULL,NULL,NULL,'0976105214',NULL,NULL,1,'N'),
(2322,'GRACIELA RAMOS ','CI','5614566',1,'CAACUPEMI AREGUA',NULL,NULL,NULL,'0991890994',NULL,NULL,1,'N'),
(2323,'ATANACIO CABALLERO','CI','1939941',1,'RAMAL CAPIATA AREGUA ALADO DEL SURTIDOR COYOTE RECOM RAMONA BAEZ',NULL,NULL,NULL,'0994627684',NULL,NULL,1,'N'),
(2324,'GLADYS ESTELA CRISTALDO DE SALDIVAR','CI','1437629',1,'A UNA CUADRA DE LA CASA DE BLANCA CRISTALDO',NULL,NULL,NULL,'0981554946',NULL,NULL,1,'N'),
(2325,'GUILLERMO HERMOSA','CI','2102757',1,'OLIVA Y TREBOL VILLA SAN SALVADOR ',NULL,NULL,NULL,'0981213928',NULL,NULL,1,'N'),
(2326,'RUTH ELIZABETH FERREIRA OCAMPOS ','CI','5197402',1,'CAACUPEMI CLIENTE VICTOR}',NULL,NULL,NULL,'0981132714',NULL,NULL,1,'N'),
(2327,'DIEGO ANDRES MOREIRA MENDOZA ','CI','6349874',1,'CAACUPEMI HNO DE LIZ MOREIRA ',NULL,NULL,NULL,'0973901310',NULL,NULL,1,'N'),
(2328,'SOFIA NOEMI MONGES DOMINGUEZ','CI','4612862',3,'MAKA I LUQUE CLIENTE VICTOR',NULL,NULL,NULL,'0971796029',NULL,NULL,1,'N'),
(2329,'ULISES SEBASTIAN CABALLERO OVELAR ','CI','5712000',1,'14 YPATI CAACUPEMI CERCA DE LA CANCHA 14 MAYO ',NULL,NULL,NULL,'0992933959',NULL,NULL,1,'N'),
(2330,'CLAUDIA ELIZABETH SOTO DE LOPEZ','CI','1897804',1,'AREGUA RECOM DE ELI AQUINO',NULL,NULL,NULL,'0982132014',NULL,NULL,1,'N'),
(2331,'JUSTO VICTORINO RIOS RODRIGUEZ ','CI','748338',1,'CAACUPEMI A DOS CUADRAS DE LA ESC SAN ANTONIO',NULL,NULL,NULL,'0983878964',NULL,NULL,1,'N'),
(2332,'ERNESTO ALCIDES MARIN','CI','3866039',1,'TAJY POTY MARIDO DE RAMONA BAEZ',NULL,NULL,NULL,'0971907380',NULL,NULL,1,'N'),
(2333,'MARIA NILDA ISIDRE','CI','4727074',1,'CAACUPEMI PARIENTE DE BLANCA VERA',NULL,NULL,NULL,'0981388208',NULL,NULL,1,'N'),
(2334,'MELIO FERREIRA ','CI','2878730',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2335,'ALFREDO VALDEZ ','CI','1387964',1,'CLIENTE DE JOEL',NULL,NULL,NULL,'0981674896',NULL,NULL,1,'N'),
(2336,'MARISA CORONEL AYALA','CI','5643120',1,'CALLE FORTINIS CERCA DE LA ANTENA DE TIGO CUÑADA DE SOLEDAD ESPOSA DE FELIX',NULL,NULL,NULL,'0983640487',NULL,NULL,1,'N'),
(2337,'CESAR INSFRAN ALFONSO','CI','3995763',3,'MARAMBURE ASENTAMIENTO KOETI ',NULL,NULL,NULL,'0992476940',NULL,NULL,1,'N'),
(2338,'ALAN MARTIN INSFRAN ','CI','5199624',1,'ASENTAMIENTO SAN JORGE SAN MIGUEL CAACUPEMI',NULL,NULL,NULL,'0986192350',NULL,NULL,1,'N'),
(2339,'FERNANDO JOSE ESTIGARRIBIA ','CI','8145219',1,'TRABAJA EN COPETROL',NULL,NULL,NULL,'0985635873',NULL,NULL,1,'N'),
(2340,'DIANA CAROLINA TALAVERA COLMAN','CI','5667961',5,'SAN LORENZO MIRA FLORES ',NULL,NULL,NULL,'0986819448',NULL,NULL,1,'N'),
(2341,'SONIA LILIANA MEDINA SERAFINI ','CI','3804024',1,'CAACUPEMI ASENTAMIENTO VECINA DE DON CLEMENTE',NULL,NULL,NULL,'0982982106',NULL,NULL,1,'N'),
(2342,'NELSON EDUARDO MAQUEDA SOTO','CI','2046131',1,'MARIDO DE PROFE RAQUELITA',NULL,NULL,NULL,'0971126858',NULL,NULL,1,'N'),
(2343,'JOSE EMILIO MINEUR AREVALOS','CI','3542413',3,'LOMA MERLO ',NULL,NULL,NULL,'0972639000',NULL,NULL,1,'N'),
(2344,'ROSA ISABEL DIAZ GIMENEZ','CI','6796833',1,'SANTA CATALINA CAACUPEMI VECINO DE ISAIAS ',NULL,NULL,NULL,'0992480438',NULL,NULL,1,'N'),
(2345,'HILARIA URSULA ISASI','CI','2112801',1,'GOBERNADOR IRALA ',NULL,NULL,NULL,'0981526431',NULL,NULL,1,'N'),
(2346,'HECTOR URBIETA ZARACHO','CI','7426264',1,'ASENT ARA PYAHU III',NULL,NULL,NULL,'0983489564',NULL,NULL,1,'N'),
(2347,'MARGARITA LOPEZ','CI','5926979',1,'AREGUA',NULL,NULL,NULL,'0971450497',NULL,NULL,1,'N'),
(2348,'FLAMINIA ESCOBAR CACERES','CI','3433798',3,'ITA ANGU A ',NULL,NULL,NULL,'0992469005',NULL,NULL,1,'N'),
(2349,'MARIA RAMONA MEDINA','CI','5695060',1,'CAACUPEMI A LADO DE LA PETROPAR EN EL DUPLEX',NULL,NULL,NULL,'0991663581',NULL,NULL,1,'N'),
(2350,'MYRIAM YOLANDA FLORENTIN BORCHICHI','CI','4877809',1,'CAACUPEMI AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2351,'HELIO ALBERTO ESTIGARRIBIA PEREIRA','CI','4801748',1,'ASENT ARA PYAHU',NULL,NULL,NULL,'0992233775',NULL,NULL,1,'N'),
(2352,'DIANA ESMILCE MEZA MEDINA','CI','4215026',3,'ISLA BOGADO VILLA ALIANZA',NULL,NULL,NULL,'0983 166453',NULL,'SOL',NULL,'N'),
(2353,'BARTOLOME DUARTE BURGOS ','CI ','4099416',1,'CALLE ROSAL  2 CUADRAS DE ÑA ELISA',NULL,NULL,NULL,'0971 115414',NULL,'SOL',NULL,'N'),
(2354,'MARLENE CABRERA SOSA','CI','4081273',1,'ARA PYAHU 2 ANTES DE FABIOLA 2 CASAS',NULL,NULL,NULL,'0985 773614',NULL,'SOL',NULL,'N'),
(2355,'MILAGROS DIAZ','CI','40 960 451',3,'LUQUE',NULL,NULL,NULL,'0986306786',NULL,NULL,1,'N'),
(2356,'ENRIQUE DANIEL ARZAMENDIA','CI','5479974',1,'RECOM DE NA LIMPIA',NULL,NULL,NULL,'0991637753',NULL,NULL,1,'N'),
(2357,'FACUNDO NICOLAS DE LA ESPADA','CI','5234637',1,'CAACUPEMI',NULL,NULL,NULL,'0994971666',NULL,NULL,1,'N'),
(2358,'MARIA BELEN ALDAMA GOMEZ','CI','2192475',1,'CONAVI MANUEL O GUERRERO 1805 C TTE SOSA',NULL,NULL,NULL,'0981228528',NULL,NULL,1,'N'),
(2359,'PEDRO ANTONIO GONZALEZ ISIDRE','CI','526305',1,'TIA DE BLANCA VERA',NULL,NULL,NULL,'0981388208',NULL,NULL,1,'N'),
(2360,'RUTH LUNA E DOMINGUEZ','CI','5282733',1,'VILLA SALVADOR ',NULL,NULL,NULL,'0986267716',NULL,NULL,1,'N'),
(2361,'MARIA ALBINA SALINAS','CI','2405822',1,'RECOM JUAN C SAMANIEGO',NULL,NULL,NULL,'0984 202446',NULL,NULL,NULL,'N'),
(2362,'SONIA AURORA ARAUJO FRANCO','CI','2910220',1,'FRACCION SAN BUENAVENTURA II','MUNICIP',NULL,NULL,'0985 842240',NULL,NULL,NULL,'N'),
(2363,'CLAUDIA SILVERIA RAMOS','CI','4373050',1,'SAN FRANCISCO 8I',NULL,NULL,NULL,'0985 457474',NULL,NULL,NULL,'N'),
(2364,'MILCIADES DAVALOS Q.','CI','4001651',1,'YUKYTY ESPOSO ANA CODAS',NULL,NULL,NULL,'0985 628740',NULL,NULL,NULL,'N'),
(2365,'MARIA DOLORES DUARTE DE BOGADO','CI','527032',1,'CONAVI',NULL,NULL,NULL,'0994 453933',NULL,NULL,NULL,'N'),
(2366,'HUGO RICARDO ESTIGARRIBIA','CI','3832979',1,'ESPODO DE MARICEL RIVERA Y HNO DE SUSANA',NULL,NULL,NULL,'0981 395028',NULL,NULL,NULL,'N'),
(2367,'VICENTA CAROLINA ESPUINOLA VENIALGO','CI','4800506',1,'HNA DE PROF SANDRA CASA DE EMPEÑO AREGUA',NULL,NULL,NULL,'0981 710751',NULL,NULL,NULL,'N'),
(2368,'JUSTO MONTIEL ESCURRA','CI','4758330',1,'ASENTAMIENTO LOS LAURELES FONDO DE CONAVI','VECINO DE ALCIDES TOLEDO',NULL,NULL,'0986 347523',NULL,NULL,NULL,'N'),
(2369,'JOSE DANILO AGUAYO NAVARRO','CI','7162552',1,'PARIENTE DE LINO  ISLA VALLE',NULL,NULL,NULL,'0986 638955',NULL,NULL,NULL,'N'),
(2370,'DERLIS RAMON GOMEZ GOMEZ','CI','4671386',1,'SAN FRANCISCO',NULL,NULL,NULL,'0983 672699',NULL,NULL,NULL,'N'),
(2371,'RAMON GONZALEZ','CI','2816479',1,'ESPOSO DE ELIDA TAXISTA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2372,'PERCY MANUEL BECKER SILVA','CI','4005418',1,'VILLA II',NULL,NULL,NULL,'0982751748',NULL,NULL,1,'N'),
(2373,'VALENTIN LUJAN ','CI','3443328',1,'HNO DE NA LUCY ',NULL,NULL,NULL,'0982393854 ',NULL,NULL,1,'N'),
(2374,'ERICO CESAR ROA MAGGI ','CI','914567',1,'MARIA AUXILIADORA,CERCA DE HECTOR BALBUENA TECNICO',NULL,NULL,NULL,'0981926551',NULL,NULL,1,'N'),
(2375,'ALEJANDRO DUARTE VIVEROS','CI','3807144',2,'ASUNCION DR ALE',NULL,NULL,NULL,'0981129850',NULL,NULL,1,'N'),
(2376,'RONALDO AGUERO DUARTE','CI','6949067',1,'SOBRINO DE DON CESAR',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2377,'ADALIS NUNHEZ JARA ','CI','6140370',1,'HIJA DE DON PEDRO NUNHEZ',NULL,NULL,NULL,'0971116886',NULL,NULL,NULL,'N'),
(2378,'MARIA CLAUDELINA GIMENEZ ROA','CI','3789078',1,'REC ELI AQUINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2379,'SOFIA ALCARAZ CARDOZO','CI','6129142',1,'ASUNCION CENTRO RODRIGUEZ DE FRANCIA',NULL,NULL,NULL,'0972620144',NULL,NULL,1,'N'),
(2380,'OSMAR ANTONIO LOBOS BENITEZ','CI','5496636',1,'CAACUPEMI',NULL,NULL,NULL,'0972578140',NULL,NULL,1,'N'),
(2381,'DEBORA ZELMIRA CACERES SARAVIA','CI','5633648',1,'AREGUA BARRIO LAS MERCEDES',NULL,NULL,NULL,'0981447302',NULL,NULL,1,'N'),
(2382,'MARIA CONCEPCION CABRERA','CI','524268',1,'VEC DE VALERIANA VERA',NULL,NULL,NULL,'0992 882291',NULL,NULL,NULL,'N'),
(2383,'JULIO CESAR CARDOZO GONZALEZ','CI','5630645',3,'ZARATE ISLA A 3 CASAS DE LA PARADA DEL 61',NULL,NULL,NULL,'0981 225939',NULL,NULL,NULL,'N'),
(2384,'NELSON ROBERTO BOGARIN ROA','CI','922816',1,'MANUEL O.G. 1903 CONAVI',NULL,NULL,NULL,'0982 362299',NULL,NULL,NULL,'N'),
(2385,'ISAIAS IVAN DELGADO VALDEZ','CI','6047148',1,'ASENT. BELEN CAACUPEMI.  HIJO DE DON CECILIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2386,'EDUARDO PRESENTADO','CI','1238927',1,'CAACUPEMI',NULL,'0984931765',NULL,NULL,NULL,NULL,NULL,'N'),
(2387,'OPTACIANO ESCOBAR GONZALEZ','CI','2866985',1,'CAACUPEMI',NULL,'0973138580',NULL,NULL,NULL,NULL,NULL,'N'),
(2388,'GRACIELA SALINAS DE AGUERO','CI','3729718',1,'CALLE TAYY UNA CUADRA DEL CENTRO DE SALUD',NULL,'0982706158',NULL,NULL,NULL,NULL,NULL,'N'),
(2389,'TEREZA ARECO ESTIGARRIBIA','CI','2121675',1,'VENDEDOR DE PLANTAS',NULL,NULL,NULL,'0982 505540',NULL,NULL,NULL,'N'),
(2390,'STELLA MARIS RIVEROS','CI','2181931',1,'CAACUPEMI',NULL,'0982440009',NULL,NULL,NULL,NULL,NULL,'N'),
(2391,'MARCELA ELIZABETH BRITEZ DE DUARTE','CI','3394015',1,'VILLA 2 CAACUPEMI',NULL,'0982225372',NULL,NULL,NULL,NULL,NULL,'N'),
(2392,'MARCOS ALEXIS DELGADILLO CABALLERO','CI','5133485',1,'CAACUPE,MI',NULL,NULL,NULL,'0994130931',NULL,NULL,1,'N'),
(2393,'ZULLY CAACUPE MARTINEZ PINTOS','CI','6344688',1,'CAACUPEMI FRENTE A LOS BOMBEROS',NULL,NULL,NULL,'0981721274',NULL,NULL,1,'N'),
(2394,'JUANA MARIA PEREZ VDA DE DUARTE','CI','229025',1,'CAACUPEMI',NULL,NULL,NULL,'021634025',NULL,NULL,1,'N'),
(2395,'HUGO ENRIQUE BECKER SILVA','CI ','2164411',1,'CAACUPEMI VILLA II',NULL,NULL,NULL,'0983200244',NULL,NULL,1,'N'),
(2396,'WILLIANS DAVID ROJAS ROJAS','CI','6175185',1,'ASENT SAN FRANCISCO',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2397,'BERNARDITA MARIA JACQUET DE DUARTE','CI','278529',1,'AREGUA ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2398,'NIDIA GABRIELA LOPEZ MARTINEZ','CI','4169231',1,'CAACUPEMI',NULL,NULL,NULL,'0991650252',NULL,NULL,1,'N'),
(2399,'GRISELDA LORENA VALDEZ DE ORUE','CI','2483598',1,'GOBERNADOR IRALA C CECILIA BAEZ PELUQ LORE',NULL,NULL,NULL,'0992313225',NULL,NULL,1,'N'),
(2400,'ZENON JAVIER MARTINEZ','CI','2263826',1,'ARA PYAHU II RECOM ROSANA NUÑEZ',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2401,'HUGO JAVIER ECHEVERRIA FRETES','CI','7666827',1,'HIJO DE DON MIGUEL.CASA DE ÑA GENARA',NULL,NULL,NULL,'0991188078',NULL,NULL,1,'N'),
(2402,'NADIA ELIZABETH CORTAZAR MEZA','CI','4984677',1,'VILLA SALVADOR RECOM FULGENCIO BENITEZ}}',NULL,NULL,NULL,'0976369508',NULL,NULL,1,'N'),
(2403,'DORILA ROJAS VDA DE FERREIRA','CI','2410298',1,'ENTRADA DE CONAVI',NULL,NULL,NULL,'0995386158',NULL,NULL,1,'N'),
(2404,'BIENVENIDO LEIVA ','CI','2531048',1,'COSTA FLEITAS (JOEL AQUINO)',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2405,'NOELIA GOMEZ ALEGRE ','CI','4665986',1,'CONAVI VILLA DEL MAESTRO RECOM YESSICA FERREIRA',NULL,NULL,NULL,'0992422282',NULL,NULL,1,'N'),
(2406,'JUANA E. LEZCANO','CI','1396958',1,'ESPOSA DE JUSTINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2407,'ROMY MARGARITA SANTACRUZ ARRUA','CI','2875222',1,'RECOM VIRGINIA BENITEZ',NULL,NULL,NULL,'0992 538964',NULL,NULL,NULL,'N'),
(2408,'WILLIAN RODOLFO MARTINEZ MENCIA','CI','4374583',1,'8 DE SETIEMBRE ',NULL,NULL,NULL,'0992 788825',NULL,NULL,NULL,'N'),
(2409,'MIRYAN VERONICA GARCETE CACERES','CI','5227806',1,'ANDRES RAMOS',NULL,NULL,NULL,'0992 337617',NULL,NULL,NULL,'N'),
(2410,'OSCAR MIGUEL ECHEVERRIA FRETES','CI','5327537',1,'VILLA AMPARO HIJO DE DON MIGUEL',NULL,NULL,NULL,'0992 481645',NULL,NULL,NULL,'N'),
(2411,'ELVIO RUBEN GONZALEZ','CI','3674443',1,'SAN FRANCISCO DE ASIS AREGUA',NULL,NULL,NULL,'0991 784142',NULL,NULL,NULL,'N'),
(2412,'NESTOR ANTONIO ARGUELLO','CI','5554321',3,'8 DE MARZO MORA CUE',NULL,NULL,NULL,'0992 918648',NULL,NULL,NULL,'N'),
(2413,'HILDA ENCINA','CI','4997524',1,'HIJA DE HILDA ROTELA',NULL,NULL,NULL,'0986 642893',NULL,NULL,NULL,'N'),
(2414,'FABIO TEODORO OLMEDO LOPEZ','CI','2525954',1,'BARRIO LAS MERCEDES ',NULL,NULL,NULL,'0981107118',NULL,NULL,1,'N'),
(2415,'LIBRADA ROMELIA ROJAS','CI','3356704',1,'CAACUPEMI CASA DE DON SANCHEZ RECOM TERESA SANCHEZ',NULL,NULL,NULL,'0975266240',NULL,NULL,1,'N'),
(2416,'CARLOS PAREDES ARANDA ','CI','4616539',1,'MBOKAJATY NHEMBY HNA DE MILCA',NULL,NULL,NULL,'0985327172',NULL,NULL,1,'N'),
(2417,'MARIA ELENA ROLON VALDEZ','CI','5084818',1,'FRENTE A ONONDIVEMI. ALFARERIA ARTE CHACHO',NULL,NULL,NULL,'0961270499',NULL,NULL,1,'N'),
(2418,'MARIA CECILIA GOMEZ','CI','1885650',1,'CAACUPEMI ',NULL,NULL,NULL,'0981950823',NULL,NULL,1,'N'),
(2419,'MARTA ADELA DUARTE PATINHO','CI','3224795',1,'CAAUPEMI ',NULL,NULL,NULL,'0961813876 ',NULL,NULL,1,'N'),
(2420,'ADRIANA SERVIN VERA','CI','5235310',1,'ASENT SAN FRANCISCO',NULL,NULL,NULL,'0986517378',NULL,NULL,1,'N'),
(2421,'EDUARDO MANUEL CORREA PRESENTADO ','CI','6535114',1,'CAACUPEMI RECOM DE RAMON PRESENTADO',NULL,NULL,NULL,'0994265073',NULL,NULL,1,'N'),
(2422,'OLGA BEATRIZ COLMAN DUARTE','CI','2441050',1,'HIJA DE FRANCISCO QUE HACE CHURROS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2423,'MILCIADES A RIOS MENDOZA','CI','4929422',1,'PRIMO DE LESLIE',NULL,NULL,NULL,'0971 199194',NULL,NULL,NULL,'N'),
(2424,'LUCAS DANIEL CHAVEZ ESPINOLA }','CI','3543104',1,'LUQUE ISLA BOGADO',NULL,NULL,NULL,'0984598755',NULL,NULL,1,'N'),
(2425,'ELVIO ROMERO','CI','2124808',1,'CAACUPEMI. VECINO DE SONIA ARAUJO',NULL,'0971448235',NULL,NULL,NULL,NULL,NULL,'N'),
(2426,'FRANCISCO SEBASTIAN BENITEZ','CI','2474678',7,'VECINO DE GABRIEL VILLAR',NULL,'0985202427',NULL,NULL,NULL,NULL,NULL,'N'),
(2427,'VICTOR JESUS MONTIEL FLORENTIN','CI','5350119',1,'CONAVI',NULL,'0994890524',NULL,NULL,NULL,NULL,NULL,'N'),
(2428,'ELVA CONCEPCION ESCOBEIRO DE DIAZ','CI','353980',1,'CONAVI RAMAL CAPIATA\'  CHEQUI',NULL,'0981274900',NULL,NULL,NULL,NULL,NULL,'N'),
(2429,'CLAUDIA LILIANA BAEZ FLEYTAS','CI','3266033',1,'BARRIO SAN LUIS CAACUPEMI PAN CASERO',NULL,NULL,NULL,'0992880431',NULL,NULL,1,'N'),
(2430,'ROBERT DAVID DIAZ GARCIA}','CI','7077906',1,'BARRIO 8 DE SETIEMBRE CALLE PEDRO JUAN FLEYTAS CERCA DE LA CASA DEL INTENDENTE','RECOM DE FABI TORRES',NULL,NULL,'0975398874',NULL,NULL,1,'N'),
(2431,'SANDRA BEATRIZ ROLON','CI','5337729',1,'RENACER III COSTA FLEITAS',NULL,NULL,NULL,'0991449896',NULL,NULL,1,'N'),
(2432,'ANGELINA MENDEZ AYALA','CI','3409545',2,'TRINIDAD HERMANA DE ZACARIAS MENDEZ',NULL,'0994815527',NULL,NULL,NULL,NULL,NULL,'N'),
(2433,'CLAUDIO ANTONIO GUERRERO GOMEZ','CI','6791893',1,'CAACUPEMI VILLA SERRANA',NULL,'0976961590',NULL,NULL,NULL,NULL,NULL,'N'),
(2434,'AGUSTINA TOLEDO GARAY ','CI','6634312',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2435,'LUIS ANTONIO VILLAGRA CARRILLO','CI','2257768',2,' LUIS ENRIQUE BOGADO',NULL,'0983306643',NULL,NULL,NULL,NULL,NULL,'N'),
(2436,'DARIO RUBEN LOPEZ CABRAL','CI','3421712',1,'LOMA MERLO LUQUE',NULL,'0991993461',NULL,NULL,NULL,NULL,NULL,'N'),
(2437,'MARIA SOFIA CABALLERO HERMOSILLA','CI','2422862',1,'CAACUPEMI FELIX FRONTINI 6587',NULL,'0981324467',NULL,NULL,NULL,NULL,NULL,'N'),
(2438,'WALTER MAZACOTE ACOSTA','CI','750398',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2439,'NOEMI ROMERO GONZALEZ','CI','7074730',1,'CAACUPEMI HNA DE MILCA',NULL,'0984676390',NULL,NULL,NULL,NULL,NULL,'N'),
(2440,'JUAN ESTEBAN AMARILLA JARA','CI','6946014',1,'TAJY POTY. ASNT BELEN',NULL,NULL,NULL,'0983782901',NULL,NULL,1,'N'),
(2441,'CRISTIAN GABRIEL CABANHAS SERVIN','CI','5783077',1,'CONAVI',NULL,'0983868909',NULL,NULL,NULL,NULL,NULL,'N'),
(2442,'BENJAMIN FRETES','CI','1000000',1,'CAACUPPEMI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2443,'ADRIANA BATTAGLIA','CI','4776661',3,'LUQUE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2444,'ALFREDO ENRIQUE MONTIEL SOSA','CI','5724871',1,'VALLEPUCU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2445,'CESAR RAMON MINEUR VALDEZ','CI',' 379452',3,'CLIENTE DE VICTOR GAMARRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2446,'CESAR RAMON MINEUR VALDEZ','CI','379452',3,'CLIENTE DE VICTOR GAMARRA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2447,'RAQUEL SERVIN MARTINEZ ','CI','4568684',1,'BARRIO SAN FRANCISCO AREGUA',NULL,NULL,NULL,'0986192655',NULL,NULL,1,'N'),
(2448,'ALCIDES RUBEN CASTILLO G','CI','7466082',1,'JUANA MARIN',NULL,NULL,NULL,'0992964544',NULL,NULL,1,'N'),
(2449,'RAMONA RUIZ LOPEZ','CI','1600590',1,'BARRIO SAN FRANCISCO AREGUA',NULL,NULL,NULL,'0991371804',NULL,NULL,1,'N'),
(2450,'MIRNA ELIZABETH CABAÑAS ','CI','4292272',1,'BARRIO SAN MIGUEL',NULL,NULL,NULL,'0986310236',NULL,NULL,1,'N'),
(2451,'BEATRIZ FERREIRA','CI','2464589',1,'CAACUPEMI',NULL,NULL,NULL,'0981837663',NULL,NULL,1,'N'),
(2452,'ELVIO SILVA DUARTE','CI','7042414',1,'AREGUA',NULL,NULL,NULL,'0971198356',NULL,NULL,1,'N'),
(2453,'DIEGO FEDERICO VAZQUEZ CARDOZO','CI','6185727',1,'RECOM DON SANCHEZ',NULL,NULL,NULL,'0983684096 ',NULL,NULL,1,'N'),
(2454,'SINFORIANA GONZALEZ HERMOSILLA','CI','1752898',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2455,'MARIA PAZ AYALA','CI','4891080',1,'AREGUA',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2456,'CARMELO ANTONIO JUAN BENITEZ CACERES','CI','4632600',1,'AREGUA',NULL,NULL,NULL,'0982819907',NULL,NULL,1,'N'),
(2457,'EMIGDIO OSVALDO GIMENEZ ','CI','3181509 ',1,'CALLE SAN RAMON',NULL,NULL,NULL,'0985612415',NULL,NULL,1,'N'),
(2458,'IGNACIO MARTINEZ QUINTANA','CI','2435565',1,'COCUE GUAZU',NULL,NULL,NULL,'0981423991',NULL,NULL,1,'N'),
(2459,'GILDA SARAVIA BOGARIN','CI','1186651',1,'ANTOLIN IRALA C RICARDO PEREZ',NULL,NULL,NULL,'0986118150',NULL,NULL,1,'N'),
(2460,'RUBEN DARIO CABAÑAS SERVIN','CI','4292271',1,'AREGUA',NULL,NULL,NULL,'0992296038',NULL,NULL,1,'N'),
(2461,'MARIA ANGELICA RAMIREZ','CI','1700723',1,'CAACUPEMI',NULL,NULL,NULL,NULL,NULL,NULL,1,'N'),
(2462,'MANUELA ROMERO CACERES','CI','6254505',1,'CLIENTE VICTOR...MARIA LILIANA CACERES DE ROMERO',NULL,NULL,NULL,'0985294127',NULL,NULL,1,'N'),
(2463,'JULIO CESAR ROJAS VELAZQUEZ','CI','7520102',1,'BARRIO SAN FRANCISCO',NULL,NULL,NULL,'0992541458',NULL,NULL,1,'N'),
(2464,'NELSON BERTHE GALEANO ','CI','6920410',1,'BARRIO SALVADOR',NULL,NULL,NULL,'0994503763',NULL,NULL,1,'N'),
(2465,'VALERIA TORRES','CI','5969123',1,'HIJA DE GRACIELA GALEANO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2466,'SERGIO ROJAS RODAS','CI','4902858',1,'CAACUPEMI',NULL,'0986615271',NULL,NULL,NULL,NULL,NULL,'N'),
(2467,'ESMILCE MARIA GONZALEZ DE DUARTE','CI','3851463',1,'ISLA VALLE',NULL,'0994011190',NULL,NULL,NULL,NULL,NULL,'N'),
(2468,'EDGAR TOMAS ARCE NUNHEZ','CI','6353201',1,'CAACUPEMI CERCA DE MARIA PELUQ',NULL,'0972536182',NULL,NULL,NULL,NULL,NULL,'N'),
(2469,'MYRIAM RAQUEL STECLER ','CI','3723670',1,'MANUEL ORTIZ GUERRERO',NULL,NULL,NULL,'0981653911',NULL,NULL,1,'N'),
(2470,'ESTEBAN CHAVEZ MARTINEZ','CI','3667863',1,'ISLA VALLE',NULL,NULL,NULL,'0983909815',NULL,NULL,1,'N'),
(2471,'RICARDO PABLO DUARTE RODRIGUEZ','CI','5738287',1,'TEODORO LABRANO',NULL,NULL,NULL,'0982213705',NULL,NULL,1,'N'),
(2472,'MIRIAN CRISTALDO AGUERO}','CI','4408656',1,'BARRIO SAN FRANCISCO ',NULL,NULL,NULL,'0982846686',NULL,NULL,1,'N'),
(2473,'JOSEFA MICAELA HERMOSILLA ROJAS','CI','5177192',1,'LAS MERCEDES GABRIEL CASACCIA',NULL,NULL,NULL,'0975585560',NULL,NULL,1,'N'),
(2474,'MARIA DELCI GRANCE DE PALMA','CI','1083077',1,'HUMAITA 504 BARRIO LAS MERCEDES',NULL,NULL,NULL,'0976815684',NULL,NULL,1,'N'),
(2475,'HECTOR RUBEN LEDESMA CUEVAS','CI','4519446',1,'BARRIO SAN FRANCISCO AREGUA',NULL,NULL,NULL,'0984341592',NULL,NULL,1,'N'),
(2476,'ZULLY MARIELA TALAVERA','CI','6052535',1,'TAJY POTY 8 DE SETIEMBRE',NULL,NULL,NULL,'0',NULL,NULL,NULL,'N'),
(2477,'JOSE LUIS GONZALEZ VERDUM','CI','3728817',1,'TAYY POTY',NULL,'0982420674',NULL,NULL,NULL,NULL,NULL,'N'),
(2478,'VICTOR RENE GAMARRA ARANDA','CI','1957374',1,'AREGUA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2479,'EDITH REINALDA MARTINEZ COHENE','CI','3392277',1,'FRENTE A LA MARMOLERIA REJAS',NULL,'0982597076',NULL,NULL,NULL,NULL,NULL,'N'),
(2480,'BERNA ESTELLA GUERRA DE DIAZ','CI','1318459',1,'FRACCION LAS LINDAS',NULL,NULL,NULL,'0972152145',NULL,NULL,1,'N'),
(2481,'SONIA FRANCO BORDON','CI','4691763',1,'CAACUPEMI . RECOMEND POR NHA CAMBA VECINA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2482,'RAQUEL CABRERA','CI','3674960',1,'CAACUPEMI',NULL,'0981315780',NULL,NULL,NULL,NULL,NULL,'N'),
(2483,'EMANUEL RAMON UARTE AMARILLA','CI','6358526',1,'FRENTE A LO DE FREDI BICI',NULL,NULL,NULL,'0971167644',NULL,NULL,1,'N'),
(2484,'MARIA TERESA MARTINEZ','CI','2964687',1,'VALLEPUCU  \'FRENTE A PETROPAR UNA CUADRA Y DOBLAR',NULL,'0991308348',NULL,NULL,NULL,NULL,NULL,'N'),
(2485,'BENITA VALIENTE','CI','3318072',1,'MAMA DE MILCIADES RADIOLOGO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(2486,'ISIDORA RODRIGUEZ','CI','2448386',1,'CAACUPEMI',NULL,NULL,NULL,'0984 149929',NULL,NULL,NULL,'N'),
(2487,'ZACARIAS RAMON MENDEZ','CI','3492773',1,'CAACUPEMI',NULL,NULL,NULL,'0981 315780',NULL,NULL,NULL,'N'),
(2488,'EDGAR JAVIER FLEYTAS SILVA','CI','1991442',1,'ESPOSO DE GUILLERMINA ORTIZ',NULL,NULL,NULL,'0991 586210',NULL,NULL,NULL,'N'),
(2489,'VENTAS TORRES CELL','CI','999999',1,'YPACARAI','YPACARAI',NULL,NULL,NULL,NULL,'SOL',1,'N'),
(2490,'CLIENTE MOSTRADOR','CI','2020',8,'YPACARAI','YPACARAI','99955',NULL,NULL,NULL,'SOL',1,'N'),
(2491,'RICARDO TORRES','CI','4749373',1,'CAACUPEMI AREGUA',NULL,NULL,NULL,NULL,NULL,'SOL',1,'N');

/*Table structure for table `planes_moviles` */

DROP TABLE IF EXISTS `planes_moviles`;

CREATE TABLE `planes_moviles` (
  `cod_plan` int(5) NOT NULL AUTO_INCREMENT,
  `descripcion_plan` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `planes_moviles` */

insert  into `planes_moviles`(`cod_plan`,`descripcion_plan`) values 
(1,'PLAN 1'),
(2,'RENOVACION PLAN 1'),
(3,'PLAN 2'),
(4,'RENOVACION PLAN 2');

/*Table structure for table `planes_vigencia` */

DROP TABLE IF EXISTS `planes_vigencia`;

CREATE TABLE `planes_vigencia` (
  `cod_plan` int(5) NOT NULL,
  `fecha_desde` date NOT NULL,
  `fecha_hasta` date DEFAULT NULL,
  `importe_plan` decimal(10,2) DEFAULT NULL,
  `ind_renov` varchar(1) DEFAULT NULL,
  `cod_plan_renov` int(5) DEFAULT NULL,
  `cant_cuotas` int(5) DEFAULT NULL,
  PRIMARY KEY (`cod_plan`,`fecha_desde`),
  KEY `FK_PLANES_VIG_PLAN_RENOV` (`cod_plan_renov`),
  CONSTRAINT `FK_PLANES_VIG_COD_PLAN` FOREIGN KEY (`cod_plan`) REFERENCES `planes_moviles` (`cod_plan`),
  CONSTRAINT `FK_PLANES_VIG_PLAN_RENOV` FOREIGN KEY (`cod_plan_renov`) REFERENCES `planes_moviles` (`cod_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `planes_vigencia` */

insert  into `planes_vigencia`(`cod_plan`,`fecha_desde`,`fecha_hasta`,`importe_plan`,`ind_renov`,`cod_plan_renov`,`cant_cuotas`) values 
(1,'2019-02-01',NULL,180000.00,'N',2,18),
(2,'2019-02-01',NULL,80000.00,'S',NULL,20),
(3,'2019-02-01',NULL,160000.00,'N',4,18),
(4,'2019-02-01',NULL,80000.00,'S',NULL,20);

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `proveedor` */

insert  into `proveedor`(`cod_proveedor`,`cod_persona`,`cod_tipo_prov`,`razon_social`,`estado`) values 
(1,2062,'GRAL',NULL,'A'),
(2,2065,'GRAL',NULL,'A'),
(3,2074,'GRAL',NULL,'A'),
(4,2075,'GRAL',NULL,'A'),
(5,2076,'GRAL',NULL,'A'),
(6,2077,'GRAL',NULL,'A'),
(7,2078,'GRAL',NULL,'A'),
(8,2079,'GRAL',NULL,'A'),
(9,2080,'GRAL',NULL,'A'),
(10,2081,'GRAL',NULL,'A'),
(11,2082,'GRAL',NULL,'A'),
(12,2083,'GRAL',NULL,'A');

/*Table structure for table `prueba` */

DROP TABLE IF EXISTS `prueba`;

CREATE TABLE `prueba` (
  `id_prueba` int(11) NOT NULL,
  `objeto_prueba` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_prueba`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `prueba` */

insert  into `prueba`(`id_prueba`,`objeto_prueba`) values 
(1,'JONATHAN DAVID TORRES VILLAGRA'),
(2,'RICARDO JAVIER TORRES VILLAGRA'),
(3,'FRANCISCO JAVIER AMARILLA TORRES'),
(4,'WILLIAM DAVID CESPEDES CORONEL'),
(5,'VENTAS CASA CENTRAL'),
(6,'COBRADOR CASA CENTRAL'),
(7,'VENTAS CLIENTE MOSTRADOR'),
(8,'NGO'),
(9,'LASER IMPORT'),
(10,'AM REGUERA'),
(11,'PROVEEDOR DE PRUEBA'),
(12,'BANCO FAMILIAR'),
(13,'BANCO VISION'),
(14,'BANCO ITAU'),
(16,'ADMINISTRADOR DEL SISTEMA'),
(17,'OCASIONAL'),
(20,'PERSONA DE PRUEBA'),
(21,'MARIA VILLAGRA'),
(22,'WALTER LOPEZ KIESSE');

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
  `monto_cuota` decimal(10,2) DEFAULT NULL,
  `importe_total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`tipo_recibo`,`ser_recibo`,`nro_recibo`,`tipo_transaccion`,`sub_tipo_transac`,`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`,`fecha_vencimiento`),
  KEY `FK_DET_REC_VEN_TRANS` (`tipo_transaccion`),
  KEY `FK_DET_REC_VEN_SUB_TIP_TRANS` (`sub_tipo_transac`),
  KEY `FK_DET_REC_VEN_SAL_CLIEN` (`tipo_comprobante_ref`,`ser_comprobante_ref`,`nro_comprobante_ref`,`nro_cuota`),
  CONSTRAINT `FK_DET_REC_VEN_SAL_CLIEN` FOREIGN KEY (`tipo_comprobante_ref`, `ser_comprobante_ref`, `nro_comprobante_ref`, `nro_cuota`) REFERENCES `saldo_cliente` (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`, `nro_cuota`),
  CONSTRAINT `FK_DET_REC_VEN_SUB_TIP_TRANS` FOREIGN KEY (`sub_tipo_transac`) REFERENCES `sub_tipo_transaccion` (`cod_sub_tipo_trans`),
  CONSTRAINT `FK_DET_REC_VEN_TRANS` FOREIGN KEY (`tipo_transaccion`) REFERENCES `tipo_transaccion` (`cod_tipo_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recibo_detalle_venta` */

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
  `total_recibo` decimal(10,2) DEFAULT NULL,
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
  `monto_cuota` decimal(10,2) DEFAULT NULL,
  `cod_moneda` varchar(5) DEFAULT NULL,
  `saldo_cuota` decimal(10,2) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  `cod_referencia` varchar(100) DEFAULT NULL,
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
  `saldo_cuota` decimal(10,2) DEFAULT NULL,
  `cod_usuario` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante`,`ser_comprobante`,`nro_comprobante`,`nro_cuota`),
  CONSTRAINT `FK_SALDO_PROV_TIP_SER_NRO` FOREIGN KEY (`tipo_comprobante`, `ser_comprobante`, `nro_comprobante`) REFERENCES `comprobante_cabecera_compra` (`cod_tipo_comp`, `ser_timb_comp`, `nro_comprob_comp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `saldo_proveedor` */

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
('AJU','A','01',1,1000,'001-001','123366','2020-10-31'),
('FCO','A','01',1,99999999,'001-001','123456','2019-04-16'),
('FCO','B','01',1,99999999,'001-002','123456','2019-04-16'),
('FCO','C','01',1,99999999,'001-001','123456','2019-06-20'),
('FCR','A','01',1,99999999,'001-001','123456','2019-04-16'),
('FCR','B','01',1,999999999,'001-002','1234567','2019-04-16'),
('FCR','C','01',1,99999999,'001-001','123456','2019-06-20'),
('REC','A','01',1,10000000,'001-001','0',NULL);

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
('01','YPACARAI'),
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
('AJU','A','01',1,1,1000,'A'),
('FCO','A','01',1,1,999999999,'A'),
('FCO','B','01',1,1,999999999,'A'),
('FCR','A','01',1,1,999999999,'A'),
('FCR','B','01',1,1,999999999,'A'),
('REC','A','01',1,1,10000000,'A');

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
('AJU','A','01',1,'GALVARENGA'),
('REC','A','01',1,'GALVARENGA'),
('FCO','A','01',1,'RTORRES'),
('REC','A','01',1,'TGONZALEZ'),
('FCO','A','01',1,'VENTAS'),
('AJU','A','01',1,'WLOPEZ'),
('FCR','A','01',1,'WLOPEZ'),
('REC','A','01',1,'WLOPEZ'),
('AJU','A','01',1,'YLOPEZ'),
('REC','A','01',1,'YLOPEZ');

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
('AJU','ST','NOTA DE AJUSTE STOCK',10),
('FCO','VT','FACTURA CONTADO',10),
('FCR','VT','FACTURA CREDITO',10),
('NCR','VT','NOTAS DE CREDITO',10),
('REC','CC','RECIBO VENTA',10),
('REM','ST','NOTA DE REMISION',NULL);

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
('PR','PRUEBA'),
('UN','UNIDAD');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `cod_usuario` varchar(10) NOT NULL,
  `clave_usuario` varchar(50) DEFAULT NULL,
  `cod_persona` int(15) DEFAULT NULL,
  `cod_grupo` varchar(15) DEFAULT NULL,
  `cod_sucursal` varchar(15) DEFAULT NULL,
  `cod_deposito` varchar(15) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  KEY `FK_USUARIO_COD_PERS` (`cod_persona`),
  KEY `FK_USUARIO_COD_GRUP` (`cod_grupo`),
  KEY `FK_USUARIO_COD_SUC` (`cod_sucursal`),
  KEY `FK_USUARIO_COD_DEP` (`cod_deposito`),
  CONSTRAINT `FK_USUARIO_COD_DEP` FOREIGN KEY (`cod_deposito`) REFERENCES `deposito_articulo` (`cod_sucursal`),
  CONSTRAINT `FK_USUARIO_COD_GRUP` FOREIGN KEY (`cod_grupo`) REFERENCES `grupo_usuario` (`cod_grupo`),
  CONSTRAINT `FK_USUARIO_COD_PERS` FOREIGN KEY (`cod_persona`) REFERENCES `persona` (`cod_persona`),
  CONSTRAINT `FK_USUARIO_COD_SUC` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursal` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`cod_usuario`,`clave_usuario`,`cod_persona`,`cod_grupo`,`cod_sucursal`,`cod_deposito`,`estado`) values 
('ADMIN','ADMIN2020',1,'ADMIN','01','01','A'),
('GALVARENGA','GALVARENGA',2197,'VENTAS','01','01','A'),
('root','manager',1,'ADMIN','01','01','A'),
('RTORRES','RTORRES',2491,'VENTAS','01','01','A'),
('TGONZALEZ','TGONZALEZ',2196,'VENTAS','01','01','A'),
('VENTAS','VENTAS2020',2489,'VENTAS','01','01','A'),
('WLOPEZ','WLOPEZ',2061,'VENTAS','01','01','A'),
('YLOPEZ','YLOPEZ',2195,'VENTAS','01','01','A');

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
('01',2478,NULL,NULL,NULL,'A'),
('02',2016,NULL,NULL,NULL,'A');

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
CALL generar_saldo_cliente(new.tipo_comprobante,new.ser_comprobante,new.nro_comprobante,new.cod_condicion_venta,new.cod_sucursal,new.cod_cliente,new.fecha_comprobante,new.monto_cuota,new.cod_moneda,new.monto_cuota,new.cod_usuario,new.comentario);
END */$$


DELIMITER ;

/* Trigger structure for table `comprobante_cabecera_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_borra_sald_anul_comp_venta` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_borra_sald_anul_comp_venta` AFTER UPDATE ON `comprobante_cabecera_venta` FOR EACH ROW 
 BEGIN
/*IF (old.estado <> new.estado) THEN*/
IF new.estado = 'A'   THEN
   CALL act_exist_anul_comp_venta(old.tipo_comprobante,old.ser_comprobante,old.nro_comprobante,old.cod_sucursal,old.cod_deposito);
   if new.tipo_comprobante='FCR' then  
      DELETE  FROM saldo_cliente 
      WHERE tipo_comprobante=old.tipo_comprobante
	AND ser_comprobante=old.ser_comprobante
	AND nro_comprobante=old.nro_comprobante;
   end if;
END IF;
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
DECLARE tip VARCHAR(5);
DECLARE tra INT(5);
DECLARE sub INT(5);
SELECT 	cod_sucursal,cod_deposito,tipo_comprobante,cod_mot_ent_sal_art,cod_sub_mot_ent_sal_art
INTO 	suc,dep,tip,tra,sub
FROM 	comprobante_cabecera_venta
WHERE	tipo_comprobante=new.tipo_comprobante
	AND ser_comprobante=new.ser_comprobante
	AND nro_comprobante=new.nro_comprobante;
	
SELECT maneja_stock INTO s
     FROM articulo 
     WHERE cod_articulo=new.cod_articulo
           AND cod_un_med=new.cod_un_med
	   AND nro_lote=new.nro_lote;
	   
IF tip IN('FCR','FCO') THEN
	SELECT 'S' INTO ea
	FROM existencia_articulo 
	WHERE cod_articulo = new.cod_articulo
		AND cod_un_medida = new.cod_un_med
		AND nro_lote = new.nro_lote 
		AND cod_sucursal = suc
		AND cod_deposito = dep
		AND tipo_transacc = 4
		AND sub_tipo_transacc = 10;
ELSEIF tip = 'AJU' THEN
	IF tra = 3 THEN
		SELECT 'S' INTO ea
		FROM existencia_articulo 
		WHERE cod_articulo = new.cod_articulo
			AND cod_un_medida = new.cod_un_med
			AND nro_lote = new.nro_lote 
			AND cod_sucursal = suc
			AND cod_deposito = dep
			AND tipo_transacc = 3
			AND sub_tipo_transacc = 8;
	ELSEIF tra = 4 THEN
		SELECT 'S' INTO ea
		FROM existencia_articulo 
		WHERE cod_articulo = new.cod_articulo
			AND cod_un_medida = new.cod_un_med
			AND nro_lote = new.nro_lote 
			AND cod_sucursal = suc
			AND cod_deposito = dep
			AND tipo_transacc = 4
			AND sub_tipo_transacc = 11;
	END IF;
END IF;
	   
IF s='S'  THEN
	IF tip IN('FCR','FCO') THEN
		IF ea = 'S' THEN
			UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad WHERE cod_articulo=new.cod_articulo AND cod_un_medida=new.cod_un_med AND nro_lote=new.nro_lote AND cod_sucursal=suc AND cod_deposito=dep AND tipo_transacc=4 AND sub_tipo_transacc=10;
		ELSE
			CALL insertar_exist_articulo(suc,dep,new.cod_articulo,new.cod_un_med,new.nro_lote,4,10,new.cantidad);
		END IF;
	ELSEIF tip = 'AJU' THEN
		IF tra = 3 THEN
			IF ea = 'S' THEN
				UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad WHERE cod_articulo=new.cod_articulo AND cod_un_medida=new.cod_un_med AND nro_lote=new.nro_lote AND cod_sucursal=suc AND cod_deposito=dep AND tipo_transacc=3 AND sub_tipo_transacc=8;
			ELSE
				CALL insertar_exist_articulo(suc,dep,new.cod_articulo,new.cod_un_med,new.nro_lote,3,8,new.cantidad);
			END IF;
		ELSEIF tra = 4 THEN
			IF ea = 'S' THEN
				UPDATE  existencia_articulo SET cantidad=cantidad+new.cantidad WHERE cod_articulo=new.cod_articulo AND cod_un_medida=new.cod_un_med AND nro_lote=new.nro_lote AND cod_sucursal=suc AND cod_deposito=dep AND tipo_transacc=4 AND sub_tipo_transacc=11;
			ELSE
				CALL insertar_exist_articulo(suc,dep,new.cod_articulo,new.cod_un_med,new.nro_lote,4,11,new.cantidad);
			END IF;
		END IF;
	END IF;
END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `comprobante_detalle_venta` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trigger_act_stock_venta_delete` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trigger_act_stock_venta_delete` BEFORE DELETE ON `comprobante_detalle_venta` FOR EACH ROW BEGIN
DECLARE ea  VARCHAR(1);
DECLARE suc VARCHAR(5);
DECLARE dep VARCHAR(5);
	
	SELECT 	cod_sucursal,cod_deposito
	INTO 	suc,dep
	FROM 	comprobante_cabecera_venta
	WHERE	tipo_comprobante = old.tipo_comprobante
		AND ser_comprobante = old.ser_comprobante
		AND nro_comprobante = old.nro_comprobante;
	
	SELECT 'S' INTO ea
	FROM 	existencia_articulo 
	WHERE 	cod_articulo = old.cod_articulo
		AND cod_un_medida = old.cod_un_med
		AND nro_lote = old.nro_lote
		AND cod_sucursal = suc
		AND cod_deposito = dep
		AND tipo_transacc = 4
		AND sub_tipo_transacc = 10;
	   	
	IF ea = 'S' THEN
		UPDATE  existencia_articulo SET cantidad = cantidad-old.cantidad WHERE cod_articulo = old.cod_articulo AND cod_un_medida = old.cod_un_med AND nro_lote = old.nro_lote AND cod_sucursal = suc AND cod_deposito = dep AND tipo_transacc = 4 AND sub_tipo_transacc = 10;
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

/* Function  structure for function  `fn_ult_fec_recibo` */

/*!50003 DROP FUNCTION IF EXISTS `fn_ult_fec_recibo` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `fn_ult_fec_recibo`(p_cliente INT(10),p_tip_com VARCHAR(5),p_ser_comp VARCHAR(2),p_nro_comp INT(10)) RETURNS date
BEGIN
DECLARE fec DATE;
  SELECT MAX(c.fecha_rec) 
INTO fec
FROM view_recibo_venta c 
WHERE c.cod_cliente = p_cliente 
AND c.tipo_comprobante_ref = p_tip_com
AND c.ser_comprobante_ref = p_ser_comp 
AND c.nro_comprobante_ref = p_nro_comp
LIMIT 1;
RETURN fec;
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

/* Function  structure for function  `retorna_permiso_grupo` */

/*!50003 DROP FUNCTION IF EXISTS `retorna_permiso_grupo` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `retorna_permiso_grupo`(grupo varchar(15),modulo VARCHAR(5),form VARCHAR(10)) RETURNS varchar(5) CHARSET latin1
BEGIN
DECLARE perm varchar(5);
	select CONCAT(ag.puede_insert,ag.puede_modif,ag.puede_borrar,ag.puede_consul) permiso
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

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `verif_existencia_nro_comprobante`(sucur VARCHAR(5),seri varchar(5),numer int(10),tipo varchar(5)) RETURNS varchar(5) CHARSET latin1
    DETERMINISTIC
BEGIN
DECLARE mens VARCHAR(5);
DECLARE s VARCHAR(15);
SELECT c.nro_comprobante INTO s
FROM comprobante_cabecera_venta c
WHERE c.cod_sucursal=sucur and c.ser_comprobante=seri and c.nro_comprobante=numer and c.tipo_comprobante = tipo;
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

/* Procedure structure for procedure `actualizar_planes_vigencia` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualizar_planes_vigencia` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_planes_vigencia`(IN plan int(5),IN fec_desd date,IN fec_hast date,in impor decimal(10,2),in ind_renv varchar(1),IN plan_ren INT(5),IN can_cuo INT(5))
BEGIN
UPDATE planes_vigencia SET fecha_hasta = fec_hast,importe_plan = impor,ind_renov = ind_renv,cod_plan_renov = plan_ren,cant_cuotas = can_cuo WHERE cod_plan = plan and fecha_desde = fec_desd;
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_usuario`(IN cod varchar(10),IN cod_pers INT(15),IN cod_grup VARCHAR(15),IN cod_suc VARCHAR(15),IN cod_dep VARCHAR(5),in estad varchar(1))
BEGIN
UPDATE usuario SET cod_persona=cod_pers,cod_grupo=cod_grup,cod_sucursal=cod_suc,cod_deposito=cod_dep,estado=estad WHERE cod_usuario=cod;
END */$$
DELIMITER ;

/* Procedure structure for procedure `actualiza_exist_art_borr_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `actualiza_exist_art_borr_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_compra`(IN art VARCHAR(100),IN un VARCHAR(100),IN lot VARCHAR(100),IN cant decimal(10,2),IN suc VARCHAR(5),IN dep VARCHAR(5))
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_venta`(IN art VARCHAR(100),IN un VARCHAR(100),IN lot VARCHAR(100),IN cant DECIMAL(10,2),IN suc VARCHAR(5),IN dep VARCHAR(5),IN tipcom VARCHAR(5),IN trans INT(5))
BEGIN
IF tipcom IN('FCR','FCO') THEN
	UPDATE  existencia_articulo
	SET cantidad = (cantidad-cant)
	WHERE cod_sucursal = suc
	AND cod_deposito = dep
	AND cod_articulo = art
	AND cod_un_medida = un
	AND nro_lote = lot 
	AND tipo_transacc = 4
	AND sub_tipo_transacc = 10;
ELSEIF 	tipcom = 'AJU' THEN
	IF trans = 3 THEN
		UPDATE  existencia_articulo
		SET cantidad = (cantidad-cant)
		WHERE cod_sucursal = suc
		AND cod_deposito = dep
		AND cod_articulo = art
		AND cod_un_medida = un
		AND nro_lote = lot
		AND tipo_transacc = 3
		AND sub_tipo_transacc = 8;
	ELSEIF trans = 4 THEN
		UPDATE  existencia_articulo
		SET cantidad = (cantidad-cant)
		WHERE cod_sucursal = suc
		AND cod_deposito = dep
		AND cod_articulo = art
		AND cod_un_medida = un
		AND nro_lote = lot
		AND tipo_transacc = 4
		AND sub_tipo_transacc = 11;
	END IF;
END IF;
END */$$
DELIMITER ;

/* Procedure structure for procedure `act_exist_anul_comp_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `act_exist_anul_comp_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `act_exist_anul_comp_venta`(IN p_tipo_comp VARCHAR(3),IN p_ser_comp VARCHAR(2),IN p_nro_comp INTEGER(10),IN p_suc VARCHAR(5),IN p_dep VARCHAR(5))
BEGIN
 
 DECLARE v_finished INTEGER DEFAULT 0;
 DECLARE v_art VARCHAR(100) DEFAULT NULL;
 DECLARE v_un VARCHAR(100) DEFAULT NULL;
 DECLARE v_lot VARCHAR(100) DEFAULT NULL;
 DECLARE v_cant DECIMAL(10,2) DEFAULT 0.0;
 
 -- declare cursor for employee email
 DECLARE email_cursor CURSOR FOR 
 SELECT cod_articulo,cod_un_med,nro_lote,cantidad 
 FROM comprobante_detalle_venta
 WHERE tipo_comprobante = p_tipo_comp
	AND ser_comprobante = p_ser_comp
	AND nro_comprobante = p_nro_comp;
 
 -- declare NOT FOUND handler
 DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET v_finished = 1;
 
 OPEN email_cursor;
 
 get_email: LOOP
 
 FETCH email_cursor INTO v_art,v_un,v_lot,v_cant;
 
 IF v_finished = 1 THEN 
 LEAVE get_email;
 END IF;
 
 -- build email list
 CALL actualiza_exist_art_borr_venta(v_art,v_un,v_lot,v_cant,p_suc,p_dep,p_tipo_comp,4);
 
 END LOOP get_email;
 
 CLOSE email_cursor;
 
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

/* Procedure structure for procedure `cancelacion_auto_saldo_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `cancelacion_auto_saldo_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `cancelacion_auto_saldo_cliente`(
)
BEGIN
  DECLARE v_tipo_comp VARCHAR(5);
  DECLARE v_ser_comp VARCHAR(2);
  DECLARE v_nro_comp int(10);
  declare v_nro_cuota INT(5);
  DECLARE fin INTEGER DEFAULT 0;
  DECLARE saldo_cliente CURSOR FOR 
    SELECT s.tipo_comprobante,s.ser_comprobante,s.nro_comprobante,s.nro_cuota
    FROM saldo_cliente s
    WHERE s.cod_tipo_estado = 7
      AND s.cod_estado = 15
      AND s.fecha_vencimiento <= CURDATE();
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin=1;
  OPEN saldo_cliente;
  get_sald_client: LOOP
    FETCH saldo_cliente INTO v_tipo_comp,v_ser_comp,v_nro_comp,v_nro_cuota;
    IF fin = 1 THEN
       LEAVE get_sald_client;
    END IF;
	update saldo_cliente s
	set s.cod_estado = 16,saldo_cuota = 0
	where s.tipo_comprobante = v_tipo_comp
		and s.ser_comprobante = v_ser_comp
		and s.nro_comprobante = v_nro_comp
		and s.nro_cuota = v_nro_cuota;
  END LOOP get_sald_client;
  CLOSE saldo_cliente;
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

/* Procedure structure for procedure `cursorTest` */

/*!50003 DROP PROCEDURE IF EXISTS  `cursorTest` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `cursorTest`(
)
BEGIN
  DECLARE v_nombre VARCHAR(120);
  DECLARE v_codigo BIGINT;
  DECLARE v_penalty1 BIGINT;
  DECLARE v_penalty2 BIGINT;
  DECLARE fin INTEGER DEFAULT 0;
  DECLARE runners_cursor CURSOR FOR 
    SELECT cod_persona,nombre FROM persona;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin=1;
  OPEN runners_cursor;
  get_runners: LOOP
    FETCH runners_cursor INTO v_codigo,v_nombre;
    IF fin = 1 THEN
       LEAVE get_runners;
    END IF;
	INSERT INTO prueba(id_prueba,objeto_prueba) values(v_codigo,v_nombre);
  /*SELECT v_name, v_time, v_penalty1, v_penalty2;*/
  END LOOP get_runners;
  CLOSE runners_cursor;
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_saldo_cliente`(IN tipo VARCHAR(3),IN ser VARCHAR(2),IN numero INT,in cant_cuo int, in suc varchar(2),IN cliente INT,IN fecha DATE,IN monto decimal(10,2),IN mon VARCHAR(5),IN saldo decimal(10,2),in us varchar(10),in ref varchar(100))
BEGIN
DECLARE i INT;
DECLARE f DATE;
SET i=1;
WHILE i <= cant_cuo DO
INSERT INTO saldo_cliente(tipo_comprobante,ser_comprobante,nro_comprobante,nro_cuota,cod_sucursal,cod_cliente,fecha_vencimiento,monto_cuota,cod_moneda,saldo_cuota,cod_usuario,cod_referencia) VALUES(tipo,ser,numero,i,suc,cliente,ADDDATE(fecha,INTERVAL I MONTH),monto,mon,saldo,us,ref);
SET i = i + 1;
END WHILE;
END */$$
DELIMITER ;

/* Procedure structure for procedure `generar_saldo_proveedor` */

/*!50003 DROP PROCEDURE IF EXISTS  `generar_saldo_proveedor` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_saldo_proveedor`(IN tipo VARCHAR(3),IN ser VARCHAR(15),IN numero INT,IN cant_cuo INT, IN suc VARCHAR(5),IN cliente INT,IN fecha DATE,IN monto DECIMAL(10,2),IN mon VARCHAR(5),IN saldo INT,us VARCHAR(10))
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

/* Procedure structure for procedure `insertar_ajuste_stock_cab` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_ajuste_stock_cab` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ajuste_stock_cab`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante INT(15),IN cod_sucursal VARCHAR(5),IN cod_depos VARCHAR(5),IN fecha_comprobante DATE,IN estado VARCHAR(1),IN cod_usuario VARCHAR(10),in mot_ent_sal_art int(5),in sub_mot_ent_sal_art int(5))
BEGIN
INSERT INTO comprobante_cabecera_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_deposito,fecha_comprobante,estado,cod_usuario,cod_mot_ent_sal_art,cod_sub_mot_ent_sal_art) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_depos,fecha_comprobante,estado,cod_usuario,mot_ent_sal_art,sub_mot_ent_sal_art);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_ajuste_stock_det` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_ajuste_stock_det` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ajuste_stock_det`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante INT(15),IN cod_articulo VARCHAR(50),IN cod_un_med VARCHAR(5),IN nro_lo VARCHAR(100),IN cantidad INT(2),IN descripcion VARCHAR(80))
BEGIN
INSERT INTO comprobante_detalle_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lote,cantidad,descripcion) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lo,cantidad,descripcion);
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_compra_cabecera`(IN tipo_comp VARCHAR(3),IN ser_timb VARCHAR(15),IN nro_comprob INT(15),in nro_timb varchar(30),IN fecha_comprobante DATE,IN cod_us VARCHAR(10),IN cod_suc VARCHAR(5),IN cod_dep VARCHAR(5),IN cod_proveedor INT(10),IN cod_cond INT(5),in cant_cuo int(5),in fec_inic_comp date,in mont_cuo decimal(10,2),IN total_comprobante DECIMAL(10,2),IN total_iva DECIMAL(10,2),IN total_gravada DECIMAL(10,2),IN cod_moneda VARCHAR(5),in ti_camb DECIMAL(10,2),IN est VARCHAR(1))
BEGIN
INSERT INTO comprobante_cabecera_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,nro_timbrado,fecha_comprob_comp,cod_usuario,cod_sucursal,cod_deposito,cod_proveedor,cod_cond_comp,cant_cuota,fecha_inic_comp,monto_cuota,total_comprob_comp,iva_comp,gravada,cod_moneda,tipo_cambio,estado) VALUES(tipo_comp,ser_timb,nro_comprob,nro_timb,fecha_comprobante,cod_us,cod_suc,cod_dep,cod_proveedor,cod_cond,cant_cuo,fec_inic_comp,mont_cuo,total_comprobante,total_iva,total_gravada,cod_moneda,ti_camb,est);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_compra_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_compra_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_compra_detalle`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(15),IN nro_comprobante INT(15),IN cod_articulo VARCHAR(100),cod_un varchar(5),lo varchar(100),in desc_articulo varchar(100),IN cantidad DECIMAL(10,2),IN precio_unitario DECIMAL(10,2),IN descuento DECIMAL(10,2),IN importe DECIMAL(10,2),IN total_iva5 DECIMAL(10,2),IN total_iva10 DECIMAL(10,2),IN gravada_5 DECIMAL(10,2),IN gravada_10 DECIMAL(10,2))
BEGIN
INSERT INTO comprobante_detalle_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,cod_producto,cod_un_med,nro_lote,descripcion_prod,cantidad_prod,precio_unitario,descuento,importe,total_iva_5,total_iva_10,gravada_5,gravada_10) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un,lo,desc_articulo,cantidad,precio_unitario,descuento,importe,total_iva5,total_iva10,gravada_5,gravada_10);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_comprobante_cabecera` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_comprobante_cabecera` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comprobante_cabecera`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante int(15),IN cod_sucursal VARCHAR(5),IN cod_depos VARCHAR(5),IN fecha_comprobante date,IN cod_cliente int(10),IN cod_cobrador varchar(10),IN cod_vendedor varchar(10),IN cod_condicion_venta INT(5),IN cod_moneda VARCHAR(5),IN total_comprobante decimal(10,2),IN total_gravada decimal(10,2),IN total_iva decimal(10,2),IN estado varchar(1),IN cod_usuario varchar(10),IN comentario varchar(50),in monto_cuo decimal(10,2))
BEGIN
INSERT INTO comprobante_cabecera_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_deposito,fecha_comprobante,cod_cliente,cod_cobrador,cod_vendedor,cod_condicion_venta,cod_moneda,total_comprobante,total_gravada,total_iva,estado,cod_usuario,comentario,monto_cuota) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_depos,fecha_comprobante,cod_cliente,cod_cobrador,cod_vendedor,cod_condicion_venta,cod_moneda,total_comprobante,total_gravada,total_iva,estado,cod_usuario,comentario,monto_cuo);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_comprobante_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_comprobante_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comprobante_detalle`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante int(15),IN cod_articulo VARCHAR(50),in cod_un_med varchar(5),in nro_lo varchar(100),IN cantidad INT(2),IN precio_unitario decimal(10,2),IN descuento decimal(10,2),IN gravada_10 decimal(10,2),IN gravada_5 decimal(10,2),IN importe_total decimal(10,2),IN total_iva10 decimal(10,2),IN total_iva5 decimal(10,2),IN porcentaje_iva INT(2),IN cod_iva int(2),IN porcentaje_descuento int(2),IN nro_cuota int(2),in descripcion varchar(80))
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_forma_cobro_venta`(IN tipo_mov_cja VARCHAR(3),IN ser_mov_cja VARCHAR(3),IN nro_mov_cja INT(15),IN tipo_tran int(5),IN su_tip_tra int(5),IN cod_pers_juridic INT(10),IN nro_val VARCHAR(30),IN nro_cuen VARCHAR(30),IN mot decimal(10,2))
BEGIN
INSERT INTO forma_cobro_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,tipo_transaccion,sub_tipo_transaccion,cod_persona_juridica,nro_valor,nro_cuenta,monto)VALUES(tipo_mov_cja,ser_mov_cja,nro_mov_cja,tipo_tran,su_tip_tra,cod_pers_juridic,nro_val,nro_cuen,mot);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_forma_pago` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_forma_pago` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_forma_pago`(IN tipo_mov_cja VARCHAR(3),IN ser_mov_cja VARCHAR(3),IN nro_mov_cja INT(15),IN tipo_tran INT(5),IN su_tip_tra INT(5),IN cod_pers_juridic INT(10),IN nro_val VARCHAR(30),IN nro_cuen VARCHAR(30),IN mot decimal(10,2))
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_caja_compra`(IN tipo_mov VARCHAR(3),IN ser_mov VARCHAR(3),IN nro_mov INT(10),IN fecha_mov DATE,IN cod_suc VARCHAR(5),IN cod_prov INT(10),IN cod_usu VARCHAR(10),IN total_mov decimal(10,2))
BEGIN
INSERT INTO movimiento_caja_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,fecha_mov_caja_com,cod_sucursal,cod_proveedor,cod_usuario,total_mov_caja_com)VALUES(tipo_mov,ser_mov,nro_mov,fecha_mov,cod_suc,cod_prov,cod_usu,total_mov);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_caja_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_caja_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_caja_venta`(IN tipo_mov_caja VARCHAR(3),IN ser_mov_caja VARCHAR(3),in nro_mov_caja INT(10),IN fecha_mov_caja_venta DATE,IN cod_sucursal VARCHAR(5),IN cod_cliente INT(10),IN cod_usuario VARCHAR(10),IN cod_caja VARCHAR(10),IN numero_hab INT(10),IN total_mov_caja decimal(10,2))
BEGIN
INSERT INTO movimiento_caja_venta(tipo_mov_caja,ser_mov_caja,nro_mov_caja,fecha_mov_caja_venta,cod_sucursal,cod_cliente,cod_usuario,cod_caja,numero_hab,total_mov_caja)VALUES(tipo_mov_caja,ser_mov_caja,nro_mov_caja,fecha_mov_caja_venta,cod_sucursal,cod_cliente,cod_usuario,cod_caja,numero_hab,total_mov_caja);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_comprobante_compra` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_comprobante_compra` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_comprobante_compra`(IN tipo_mov VARCHAR(3),IN ser_mov VARCHAR(3),IN nro_mov INT(15),IN cod_suc VARCHAR(5),in tipo_trans int(5),in sub_tipo_trans int(5),IN tipo_comprob VARCHAR(3),IN ser_comprob VARCHAR(15),IN nro_comprob INT(10),IN total_comprob decimal(10,2))
BEGIN
INSERT INTO movimiento_comprobante_compra(tipo_mov_caja_com,ser_mov_caja_com,nro_mov_caja_com,cod_sucursal,tipo_transacc,sub_tipo_transacc,tipo_comprobante_com,ser_comprobante_com,nro_comprobante_com,total_comprobante_com)VALUES(tipo_mov,ser_mov,nro_mov,cod_suc,tipo_trans,sub_tipo_trans,tipo_comprob,ser_comprob,nro_comprob,total_comprob);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_movimiento_comprobante_venta` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_movimiento_comprobante_venta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_movimiento_comprobante_venta`(IN tipo_mov_caja VARCHAR(3),IN ser_mov_caja VARCHAR(3),IN nro_mov_caja INT(15),IN cod_sucursal VARCHAR(5),IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(3),IN nro_comprobante INT(10),IN total_comprobante decimal(10,2))
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

/* Procedure structure for procedure `insertar_planes_vigencia` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_planes_vigencia` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_planes_vigencia`(IN plan INT(5),IN fec_desde date,IN fec_hasta date,IN importe decimal(10,2),IN ind VARCHAR(1),IN plan_ren INT(5),IN cant_cuo INT(5))
BEGIN
INSERT INTO planes_vigencia(cod_plan,fecha_desde,fecha_hasta,importe_plan,ind_renov,cod_plan_renov,cant_cuotas) VALUES(plan,fec_desde,fec_hasta,importe,ind,plan_ren,cant_cuo);
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_venta_cabecera`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(2),IN nro_recibo INT(15),IN cod_sucursal VARCHAR(5),IN fecha_recibo DATE,IN cod_cliente INT(10),IN cod_cobrador VARCHAR(10),IN cod_moneda VARCHAR(5),IN cod_usuario VARCHAR(10),IN estado VARCHAR(1),IN total_recibo decimal(10,2),IN comentario VARCHAR(50))
BEGIN
INSERT INTO recibo_venta_cabecera(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_cliente,cod_cobrador,cod_moneda,cod_usuario,estado,total_recibo,comentario) VALUES(tipo_recibo,ser_recibo,nro_recibo,cod_sucursal,fecha_recibo,cod_cliente,cod_cobrador,cod_moneda,cod_usuario,estado,total_recibo,comentario);
END */$$
DELIMITER ;

/* Procedure structure for procedure `insertar_recibo_venta_detalle` */

/*!50003 DROP PROCEDURE IF EXISTS  `insertar_recibo_venta_detalle` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_venta_detalle`(IN tipo_recibo VARCHAR(3),IN ser_recibo VARCHAR(2),IN nro_recibo INT(15),IN tipo_transaccion INT(5),IN sub_tipo_transac INT(5),IN tipo_comprobante_ref VARCHAR(3),IN ser_comprobante_ref VARCHAR(2),IN nro_comprobante_ref INT(15),IN nro_cuota INT(5),IN fecha_vencimiento date,IN monto_cuota decimal(10,2),IN importe_total decimal(10,2))
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

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_usuario`(IN cod_usuario VARCHAR(10),IN clave_usuario VARCHAR(20),IN cod_persona INT(15),IN cod_grupo VARCHAR(15),IN cod_sucursal VARCHAR(5),IN cod_depos VARCHAR(5),IN estado VARCHAR(1))
BEGIN
INSERT INTO usuario(cod_usuario,clave_usuario,cod_persona,cod_grupo,cod_sucursal,cod_deposito,estado) VALUES(cod_usuario,clave_usuario,cod_persona,cod_grupo,cod_sucursal,cod_depos,estado);
END */$$
DELIMITER ;

/* Procedure structure for procedure `prueba_cursor1` */

/*!50003 DROP PROCEDURE IF EXISTS  `prueba_cursor1` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `prueba_cursor1`(INOUT email_list varchar(4000))
BEGIN
 
 DECLARE v_finished INTEGER DEFAULT 0;
 DECLARE v_email VARCHAR(100) DEFAULT "";
 
 -- declare cursor for employee email
 DECLARE email_cursor CURSOR FOR 
 SELECT cod_categoria FROM categoria;
 
 -- declare NOT FOUND handler
 DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET v_finished = 1;
 
 OPEN email_cursor;
 
 get_email: LOOP
 
 FETCH email_cursor INTO v_email;
 
 IF v_finished = 1 THEN 
 LEAVE get_email;
 END IF;
 
 -- build email list
 SET email_list = CONCAT(v_email,";",email_list);
 
 END LOOP get_email;
 
 CLOSE email_cursor;
 
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
 `monto_cuota` decimal(10,2) ,
 `total_comp` decimal(10,2) ,
 `total_iva_comp` decimal(10,2) ,
 `total_grav_comp` decimal(10,2) ,
 `cod_moneda` varchar(5) ,
 `desc_moneda` varchar(50) ,
 `tipo_cambio` decimal(10,2) ,
 `estado` varchar(1) ,
 `cod_articulo` varchar(100) ,
 `unidad_med` varchar(100) ,
 `nro_lote` varchar(100) ,
 `desc_articulo` varchar(100) ,
 `cant_articulo` decimal(10,2) ,
 `precio_unitario` decimal(10,2) ,
 `descuento` decimal(10,2) ,
 `importe` decimal(10,2) ,
 `iva5` decimal(10,2) ,
 `iva10` decimal(10,2) ,
 `gravada5` decimal(10,2) ,
 `gravada10` decimal(10,2) 
)*/;

/*Table structure for table `view_comprob_venta_cab_det` */

DROP TABLE IF EXISTS `view_comprob_venta_cab_det`;

/*!50001 DROP VIEW IF EXISTS `view_comprob_venta_cab_det` */;
/*!50001 DROP TABLE IF EXISTS `view_comprob_venta_cab_det` */;

/*!50001 CREATE TABLE  `view_comprob_venta_cab_det`(
 `cod_sucursal` varchar(5) ,
 `desc_sucursal` varchar(50) ,
 `tipo_comprobante` varchar(20) ,
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
 `cantidad` decimal(10,2) ,
 `desc_articulo` varchar(100) ,
 `precio_unitario` decimal(10,2) ,
 `importe_total` decimal(10,2) ,
 `total_iva5` decimal(10,2) ,
 `total_iva10` decimal(10,2) ,
 `gravada_5` decimal(10,2) ,
 `gravada_10` decimal(10,2) ,
 `total_gravada` decimal(10,2) ,
 `total_iva` decimal(10,2) ,
 `total_comprobante` decimal(10,2) ,
 `cod_deposito` varchar(5) ,
 `desc_deposito` varchar(80) ,
 `estado` varchar(1) ,
 `tip_comp` varchar(5) ,
 `fec_comp` date ,
 `trans_ent_sal_art` int(5) ,
 `desc_trans_ent_sal_art` varchar(80) ,
 `sub_trans_ent_sal_art` int(5) ,
 `desc_sub_trans_ent_sal_art` varchar(50) 
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
 `existencia` decimal(41,2) 
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
 `total_mov_comp` decimal(10,2) 
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
 `total_mov_caja` decimal(10,2) ,
 `fecha_movimiento` date 
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
 `total_recibo` decimal(10,2) ,
 `comentario` varchar(80) ,
 `tipo_transaccion` int(5) ,
 `sub_tipo_transac` int(5) ,
 `tipo_comprobante_ref` varchar(3) ,
 `ser_comprobante_ref` varchar(3) ,
 `nro_comprobante_ref` int(10) ,
 `nro_cuota` int(5) ,
 `fecha_vencimiento` date ,
 `monto_cuota` decimal(10,2) ,
 `importe_total` decimal(10,2) ,
 `fecha_rec` date 
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
 `saldo_cuota` decimal(10,2) ,
 `ref_comprob` varchar(100) ,
 `fec_ult_recibo` date 
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
 `saldo_cuota` decimal(10,2) ,
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
 `COD_DEPOSITO` varchar(15) ,
 `DESC_DEPOSITO` varchar(80) ,
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

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_comprob_venta_cab_det` AS (select `com`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,(case when (`com`.`tipo_comprobante` = 'FCO') then 'FACTURA CONTADO' when (`com`.`tipo_comprobante` = 'FCR') then 'FACTURA CREDITO' when (`com`.`tipo_comprobante` = 'AJU') then 'NOTA DE AJUSTE STOCK' else 'COMP NO ENCONTRADO' end) AS `tipo_comprobante`,`com`.`ser_comprobante` AS `ser_comprobante`,`com`.`nro_comprobante` AS `nro_comprobante`,date_format(`com`.`fecha_comprobante`,'%d/%m/%Y') AS `fecha_comprobante`,`com`.`cod_cliente` AS `cod_cliente`,`per`.`nombre` AS `nombre_cliente`,`com`.`cod_cobrador` AS `cod_cobrador`,`pco`.`nombre` AS `nombre_cobrador`,`com`.`cod_vendedor` AS `cod_vendedor`,`pve`.`nombre` AS `nombre_vendedor`,`com`.`cod_condicion_venta` AS `cod_condicion_venta`,`con`.`descripcion` AS `descripcion`,`com`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`dco`.`cod_articulo` AS `cod_articulo`,`dco`.`cod_un_med` AS `cod_un_med`,`dco`.`nro_lote` AS `nro_lote`,`dco`.`cantidad` AS `cantidad`,`art`.`desc_articulo` AS `desc_articulo`,`dco`.`precio_unitario` AS `precio_unitario`,`dco`.`importe_total` AS `importe_total`,`dco`.`total_iva5` AS `total_iva5`,`dco`.`total_iva10` AS `total_iva10`,`dco`.`gravada_5` AS `gravada_5`,`dco`.`gravada_10` AS `gravada_10`,`com`.`total_gravada` AS `total_gravada`,`com`.`total_iva` AS `total_iva`,`com`.`total_comprobante` AS `total_comprobante`,`com`.`cod_deposito` AS `cod_deposito`,`dep`.`desc_deposito` AS `desc_deposito`,`com`.`estado` AS `estado`,`com`.`tipo_comprobante` AS `tip_comp`,`com`.`fecha_comprobante` AS `fec_comp`,`com`.`cod_mot_ent_sal_art` AS `trans_ent_sal_art`,`tra`.`descripcion` AS `desc_trans_ent_sal_art`,`com`.`cod_sub_mot_ent_sal_art` AS `sub_trans_ent_sal_art`,`sub`.`descripcion` AS `desc_sub_trans_ent_sal_art` from ((((((((((((((`comprobante_cabecera_venta` `com` left join `comprobante_detalle_venta` `dco` on(((`com`.`tipo_comprobante` = `dco`.`tipo_comprobante`) and (`com`.`ser_comprobante` = `dco`.`ser_comprobante`) and (`com`.`nro_comprobante` = `dco`.`nro_comprobante`)))) left join `articulo` `art` on(((`dco`.`cod_articulo` = `art`.`cod_articulo`) and (`dco`.`cod_un_med` = `art`.`cod_un_med`) and (`dco`.`nro_lote` = `art`.`nro_lote`)))) left join `cliente` `cli` on((`com`.`cod_cliente` = `cli`.`cod_cliente`))) left join `persona` `per` on((`cli`.`cod_persona` = `per`.`cod_persona`))) left join `sucursal` `suc` on((`com`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `deposito_articulo` `dep` on((`com`.`cod_deposito` = `dep`.`cod_deposito`))) left join `cobrador` `cob` on((`com`.`cod_cobrador` = `cob`.`cod_cobrador`))) left join `persona` `pco` on((`cob`.`cod_persona` = `pco`.`cod_persona`))) left join `vendedor` `ven` on((`com`.`cod_vendedor` = `ven`.`cod_vendedor`))) left join `persona` `pve` on((`ven`.`cod_persona` = `pve`.`cod_persona`))) left join `condicion_venta` `con` on((`com`.`cod_condicion_venta` = `con`.`cod_condicion`))) left join `moneda` `mon` on((`cli`.`cod_moneda` = `mon`.`cod_moneda`))) left join `tipo_transaccion` `tra` on((`com`.`cod_mot_ent_sal_art` = `tra`.`cod_tipo_trans`))) left join `sub_tipo_transaccion` `sub` on(((`com`.`cod_mot_ent_sal_art` = `sub`.`cod_tipo_trans`) and (`com`.`cod_sub_mot_ent_sal_art` = `sub`.`cod_sub_tipo_trans`))))) */;

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

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_mov_caja_venta` AS (select `mcaj`.`tipo_mov_caja` AS `tipo_mov_caja`,`mcaj`.`ser_mov_caja` AS `ser_mov_caja`,`mcaj`.`nro_mov_caja` AS `nro_mov_caja`,date_format(`mcaj`.`fecha_mov_caja_venta`,'%d/%m/%Y') AS `fecha_mov_caja_venta`,`mcaj`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`mcaj`.`cod_cliente` AS `cod_cliente`,`p`.`nombre` AS `nomb_cliente`,`mcaj`.`cod_usuario` AS `cod_usuario`,`pu`.`nombre` AS `nomb_usuario`,`mcaj`.`cod_caja` AS `cod_caja`,`cj`.`desc_caja` AS `desc_caja`,`mcaj`.`numero_hab` AS `numero_hab`,`mcaj`.`total_mov_caja` AS `total_mov_caja`,`mcaj`.`fecha_mov_caja_venta` AS `fecha_movimiento` from ((((((`movimiento_caja_venta` `mcaj` left join `cliente` `c` on((`mcaj`.`cod_cliente` = `c`.`cod_cliente`))) left join `caja` `cj` on(((`mcaj`.`cod_caja` = `cj`.`cod_caja`) and (`mcaj`.`cod_sucursal` = `cj`.`cod_sucursal`)))) left join `persona` `p` on((`p`.`cod_persona` = `c`.`cod_persona`))) left join `usuario` `us` on((`mcaj`.`cod_usuario` = `us`.`cod_usuario`))) left join `persona` `pu` on((`us`.`cod_persona` = `pu`.`cod_persona`))) left join `sucursal` `suc` on((`mcaj`.`cod_sucursal` = `suc`.`cod_sucursal`)))) */;

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

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_recibo_venta` AS (select `rec`.`cod_usuario` AS `cod_usuario`,`pus`.`nombre` AS `nomb_usuario`,`rec`.`cod_sucursal` AS `cod_sucursal`,`suc`.`desc_sucursal` AS `desc_sucursal`,`rec`.`tipo_recibo` AS `tipo_recibo`,`rec`.`ser_recibo` AS `ser_recibo`,`rec`.`nro_recibo` AS `nro_recibo`,date_format(`rec`.`fecha_recibo`,'%d/%m/%Y') AS `fecha_recibo`,`rec`.`cod_cliente` AS `cod_cliente`,`pcl`.`nombre` AS `nomb_cliente`,`rec`.`cod_cobrador` AS `cod_cobrador`,`pco`.`nombre` AS `nomb_cobrador`,`rec`.`cod_moneda` AS `cod_moneda`,`mon`.`desc_moneda` AS `desc_moneda`,`rec`.`total_recibo` AS `total_recibo`,`rec`.`comentario` AS `comentario`,`dre`.`tipo_transaccion` AS `tipo_transaccion`,`dre`.`sub_tipo_transac` AS `sub_tipo_transac`,`dre`.`tipo_comprobante_ref` AS `tipo_comprobante_ref`,`dre`.`ser_comprobante_ref` AS `ser_comprobante_ref`,`dre`.`nro_comprobante_ref` AS `nro_comprobante_ref`,`dre`.`nro_cuota` AS `nro_cuota`,`dre`.`fecha_vencimiento` AS `fecha_vencimiento`,`dre`.`monto_cuota` AS `monto_cuota`,`dre`.`importe_total` AS `importe_total`,`rec`.`fecha_recibo` AS `fecha_rec` from (((((((((`recibo_venta_cabecera` `rec` left join `recibo_detalle_venta` `dre` on(((`rec`.`tipo_recibo` = `dre`.`tipo_recibo`) and (`rec`.`ser_recibo` = `dre`.`ser_recibo`) and (`rec`.`nro_recibo` = `dre`.`nro_recibo`)))) left join `cliente` `cli` on((`rec`.`cod_cliente` = `cli`.`cod_cliente`))) left join `cobrador` `cob` on((`rec`.`cod_cobrador` = `cob`.`cod_cobrador`))) left join `moneda` `mon` on((`rec`.`cod_moneda` = `mon`.`cod_moneda`))) left join `sucursal` `suc` on((`rec`.`cod_sucursal` = `suc`.`cod_sucursal`))) left join `usuario` `usu` on((`rec`.`cod_usuario` = `usu`.`cod_usuario`))) left join `persona` `pcl` on((`cli`.`cod_persona` = `pcl`.`cod_persona`))) left join `persona` `pco` on((`cob`.`cod_persona` = `pco`.`cod_persona`))) left join `persona` `pus` on((`usu`.`cod_persona` = `pus`.`cod_persona`)))) */;

/*View structure for view view_saldo_cliente */

/*!50001 DROP TABLE IF EXISTS `view_saldo_cliente` */;
/*!50001 DROP VIEW IF EXISTS `view_saldo_cliente` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_saldo_cliente` AS (select `s`.`tipo_comprobante` AS `tipo_comprobante`,`s`.`ser_comprobante` AS `ser_comprobante`,`s`.`nro_comprobante` AS `nro_comprobante`,`s`.`cod_cliente` AS `cod_cliente`,`p`.`nombre` AS `nombre`,`s`.`nro_cuota` AS `nro_cuota`,`s`.`fecha_vencimiento` AS `fec_venc`,date_format(`s`.`fecha_vencimiento`,'%d/%m/%Y') AS `fecha_vencimiento`,`s`.`saldo_cuota` AS `saldo_cuota`,`s`.`cod_referencia` AS `ref_comprob`,`fn_ult_fec_recibo`(`s`.`cod_cliente`,`s`.`tipo_comprobante`,`s`.`ser_comprobante`,`s`.`nro_comprobante`) AS `fec_ult_recibo` from ((`saldo_cliente` `s` left join `cliente` `c` on((`s`.`cod_cliente` = `c`.`cod_cliente`))) left join `persona` `p` on((`c`.`cod_persona` = `p`.`cod_persona`))) order by `s`.`ser_comprobante`,`s`.`nro_comprobante`,`s`.`nro_cuota`) */;

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

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_usuarios` AS (select `u`.`cod_usuario` AS `COD_USUARIO`,`p`.`cod_persona` AS `COD_PERSONA`,`p`.`nombre` AS `NOMBRE_USUARIO`,`u`.`cod_grupo` AS `COD_GRUPO`,`g`.`desc_grupo` AS `DESC_GRUPO`,`u`.`cod_sucursal` AS `COD_SUCURSAL`,`s`.`desc_sucursal` AS `DESC_SUCURSAL`,`u`.`cod_deposito` AS `COD_DEPOSITO`,`d`.`desc_deposito` AS `DESC_DEPOSITO`,`u`.`estado` AS `ESTADO`,(case when (`u`.`estado` = 'A') then 'ACTIVO' else 'INACTIVO' end) AS `desc_estado` from ((((`usuario` `u` left join `persona` `p` on((`u`.`cod_persona` = `p`.`cod_persona`))) left join `grupo_usuario` `g` on((`u`.`cod_grupo` = `g`.`cod_grupo`))) left join `sucursal` `s` on((`u`.`cod_sucursal` = `s`.`cod_sucursal`))) left join `deposito_articulo` `d` on((`u`.`cod_deposito` = `d`.`cod_deposito`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
