DELIMITER $$

USE `compra_venta`$$

DROP PROCEDURE IF EXISTS `act_exist_anul_comp_venta`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `act_exist_anul_comp_venta`(IN p_tipo_comp VARCHAR(3),IN p_ser_comp VARCHAR(2),IN p_nro_comp INTEGER(10),IN p_suc VARCHAR(5),IN p_dep VARCHAR(5))
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
 
END$$

DELIMITER ;