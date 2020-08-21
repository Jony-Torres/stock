DELIMITER $$

USE `compra_venta`$$

DROP TRIGGER /*!50032 IF EXISTS */ `trigger_act_stock_compra_delete`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `trigger_act_stock_compra_delete` BEFORE DELETE ON `comprobante_detalle_compra` 
    FOR EACH ROW BEGIN
DECLARE s VARCHAR(1);
DECLARE ea  VARCHAR(1);
DECLARE suc VARCHAR(5);
DECLARE dep VARCHAR(5);
DECLARE tip VARCHAR(5);
DECLARE tra INT(5);
DECLARE sub INT(5);
	
	SELECT 	cod_sucursal,cod_deposito,cod_tipo_comp,cod_mot_ent_sal_art,cod_sub_mot_ent_sal_art
	INTO 	suc,dep,tip,tra,sub
	FROM 	comprobante_cabecera_compra
	WHERE	cod_tipo_comp=old.cod_tipo_comp
		AND ser_timb_comp=old.ser_timb_comp
		AND nro_comprob_comp=old.nro_comprob_comp;
	
	SELECT maneja_stock INTO s
	FROM 	articulo 
	WHERE cod_articulo = old.cod_producto
		AND cod_un_med = old.cod_un_med
		AND nro_lote = old.nro_lote;
	
	
	IF tip IN('FCR','FCO') THEN
		SELECT 'S' INTO ea
		FROM 	existencia_articulo 
		WHERE 	cod_articulo = old.cod_producto
			AND cod_un_medida = old.cod_un_med
			AND nro_lote = old.nro_lote
			AND cod_sucursal = suc
			AND cod_deposito = dep
			AND tipo_transacc = 3
			AND sub_tipo_transacc = 7;
	ELSEIF tip = 'AJU' THEN
		IF tra = 3 THEN
			SELECT 'S' INTO ea
			FROM existencia_articulo 
			WHERE cod_articulo = old.cod_producto
				AND cod_un_medida = old.cod_un_med
				AND nro_lote = old.nro_lote 
				AND cod_sucursal = suc
				AND cod_deposito = dep
				AND tipo_transacc = 3
				AND sub_tipo_transacc = 8;
		END IF;
	END IF;
	   	
	
	IF s='S'  THEN
		IF tip IN('FCR','FCO') THEN
			IF ea = 'S' THEN
				UPDATE  existencia_articulo SET cantidad = cantidad-old.cantidad_prod WHERE cod_articulo = old.cod_producto AND cod_un_medida = old.cod_un_med AND nro_lote = old.nro_lote AND cod_sucursal = suc AND cod_deposito = dep AND tipo_transacc = 3 AND sub_tipo_transacc = 7;
			END IF;
		ELSEIF tip = 'AJU' THEN
			IF tra = 3 THEN
				IF ea = 'S' THEN
					UPDATE  existencia_articulo SET cantidad = cantidad+old.cantidad_prod WHERE cod_articulo = old.cod_producto AND cod_un_medida = old.cod_un_med AND nro_lote = old.nro_lote AND cod_sucursal = suc AND cod_deposito = dep AND tipo_transacc = 3 AND sub_tipo_transacc = 8;
				END IF;
			END IF;
		END IF;
	END IF;
END;
$$

DELIMITER ;