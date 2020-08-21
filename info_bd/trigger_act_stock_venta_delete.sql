DELIMITER $$

USE `compra_venta`$$

DROP TRIGGER /*!50032 IF EXISTS */ `trigger_act_stock_venta_delete`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `trigger_act_stock_venta_delete` BEFORE DELETE ON `comprobante_detalle_venta` 
    FOR EACH ROW BEGIN
DECLARE s VARCHAR(1);
DECLARE ea  VARCHAR(1);
DECLARE suc VARCHAR(5);
DECLARE dep VARCHAR(5);
DECLARE tip VARCHAR(5);
DECLARE tra INT(5);
DECLARE sub INT(5);
	
	SELECT 	cod_sucursal,cod_deposito,tipo_comprobante,cod_mot_ent_sal_art,cod_sub_mot_ent_sal_art
	INTO 	suc,dep,tip,tra,sub
	FROM 	comprobante_cabecera_venta
	WHERE	tipo_comprobante = old.tipo_comprobante
		AND ser_comprobante = old.ser_comprobante
		AND nro_comprobante = old.nro_comprobante;
		
	SELECT maneja_stock INTO s
	FROM articulo 
	WHERE cod_articulo = old.cod_articulo
		AND cod_un_med = old.cod_un_med
		AND nro_lote = old.nro_lote;
	
	IF tip IN('FCR','FCO') THEN
		SELECT 'S' INTO ea
		FROM 	existencia_articulo 
		WHERE 	cod_articulo = old.cod_articulo
			AND cod_un_medida = old.cod_un_med
			AND nro_lote = old.nro_lote
			AND cod_sucursal = suc
			AND cod_deposito = dep
			AND tipo_transacc = 4
			AND sub_tipo_transacc = 10;
	ELSEIF tip = 'AJU' THEN
		IF tra = 4 THEN
			SELECT 'S' INTO ea
			FROM existencia_articulo 
			WHERE cod_articulo = old.cod_articulo
				AND cod_un_medida = old.cod_un_med
				AND nro_lote = old.nro_lote 
				AND cod_sucursal = suc
				AND cod_deposito = dep
				AND tipo_transacc = 4
				AND sub_tipo_transacc = 11;
		END IF;
	END IF;
	
	IF s='S'  THEN
		IF tip IN('FCR','FCO') THEN   	
			IF ea = 'S' THEN
				UPDATE  existencia_articulo SET cantidad = cantidad-old.cantidad WHERE cod_articulo = old.cod_articulo AND cod_un_medida = old.cod_un_med AND nro_lote = old.nro_lote AND cod_sucursal = suc AND cod_deposito = dep AND tipo_transacc = 4 AND sub_tipo_transacc = 10;
			END IF;
		ELSEIF tip = 'AJU' THEN
			IF tra = 4 THEN
				IF ea = 'S' THEN
					UPDATE  existencia_articulo SET cantidad = cantidad-old.cantidad WHERE cod_articulo = old.cod_articulo AND cod_un_medida = old.cod_un_med AND nro_lote = old.nro_lote AND cod_sucursal = suc AND cod_deposito = dep AND tipo_transacc = 4 AND sub_tipo_transacc = 11;
				END IF;
			END IF;
		END IF;
	END IF;
END;
$$

DELIMITER ;