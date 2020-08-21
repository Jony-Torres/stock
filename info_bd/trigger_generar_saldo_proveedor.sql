DELIMITER $$

USE `compra_venta`$$

DROP TRIGGER /*!50032 IF EXISTS */ `trigger_generar_saldo_proveedor`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `trigger_generar_saldo_proveedor` AFTER INSERT ON `comprobante_cabecera_compra` 
    FOR EACH ROW BEGIN
IF new.cod_tipo_comp = 'FCR' AND IFNULL(new.cod_cond_comp,0) > 0 THEN
	CALL generar_saldo_proveedor(new.cod_tipo_comp,new.ser_timb_comp,new.nro_comprob_comp,new.cod_cond_comp,new.cod_sucursal,new.cod_proveedor,new.fecha_comprob_comp,new.total_comprob_comp,new.cod_moneda,new.total_comprob_comp,new.cod_usuario);
END IF;
END;
$$

DELIMITER ;