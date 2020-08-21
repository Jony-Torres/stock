DELIMITER $$

USE `compra_venta`$$

DROP PROCEDURE IF EXISTS `insertar_ajuste_stock_cab`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ajuste_stock_cab`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante INT(15),IN cod_sucursal VARCHAR(5),IN cod_depos VARCHAR(5),IN fecha_comprobante DATE,IN estado VARCHAR(1),IN cod_usuario VARCHAR(10),IN mot_ent_sal_art INT(5),IN sub_mot_ent_sal_art INT(5),IN transac INT(5))
BEGIN
IF transac = 3 THEN
	INSERT INTO comprobante_cabecera_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,cod_sucursal,cod_deposito,fecha_comprob_comp,estado,cod_usuario,cod_mot_ent_sal_art,cod_sub_mot_ent_sal_art) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_depos,fecha_comprobante,estado,cod_usuario,mot_ent_sal_art,sub_mot_ent_sal_art);
ELSEIF transac = 4 THEN
	INSERT INTO comprobante_cabecera_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_deposito,fecha_comprobante,estado,cod_usuario,cod_mot_ent_sal_art,cod_sub_mot_ent_sal_art) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_sucursal,cod_depos,fecha_comprobante,estado,cod_usuario,mot_ent_sal_art,sub_mot_ent_sal_art);
END IF;
END$$

DELIMITER ;