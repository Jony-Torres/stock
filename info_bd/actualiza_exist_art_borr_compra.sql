DELIMITER $$

USE `compra_venta`$$

DROP PROCEDURE IF EXISTS `actualiza_exist_art_borr_compra`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_exist_art_borr_compra`(IN art VARCHAR(100),IN un VARCHAR(100),IN lot VARCHAR(100),IN cant DECIMAL(10,2),IN suc VARCHAR(5),IN dep VARCHAR(5),IN tipcom VARCHAR(5),IN trans INT(5))
BEGIN
IF tipcom IN('FCR','FCO') THEN
	UPDATE  existencia_articulo
	SET cantidad = (cantidad-cant)
	WHERE cod_sucursal = suc
	AND cod_deposito = dep
	AND cod_articulo = art
	AND cod_un_medida = un
	AND nro_lote = lot
	AND tipo_transacc = 3
	AND sub_tipo_transacc = 7;
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
	END IF;
END IF;
END$$

DELIMITER ;