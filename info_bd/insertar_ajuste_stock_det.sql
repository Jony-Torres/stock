DELIMITER $$

USE `compra_venta`$$

DROP PROCEDURE IF EXISTS `insertar_ajuste_stock_det`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ajuste_stock_det`(IN tipo_comprobante VARCHAR(3),IN ser_comprobante VARCHAR(2),IN nro_comprobante INT(15),IN cod_articulo VARCHAR(50),IN cod_un_med VARCHAR(5),IN nro_lo VARCHAR(100),IN cantidad INT(2),IN descripcion VARCHAR(80),IN transac INT(5))
BEGIN
IF transac = 3 THEN
	INSERT INTO comprobante_detalle_compra(cod_tipo_comp,ser_timb_comp,nro_comprob_comp,cod_producto,cod_un_med,nro_lote,cantidad_prod,descripcion_prod) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lo,cantidad,descripcion);
ELSEIF transac = 4 THEN
	INSERT INTO comprobante_detalle_venta(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lote,cantidad,descripcion) VALUES(tipo_comprobante,ser_comprobante,nro_comprobante,cod_articulo,cod_un_med,nro_lo,cantidad,descripcion);
END IF;
END$$

DELIMITER ;