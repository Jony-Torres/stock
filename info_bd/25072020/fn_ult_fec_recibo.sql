DELIMITER $$

USE `compra_venta`$$

DROP FUNCTION IF EXISTS `fn_ult_fec_recibo`$$

CREATE DEFINER=`root`@`localhost` FUNCTION `fn_ult_fec_recibo`(p_cliente INT(10),p_tip_com VARCHAR(5),p_ser_comp VARCHAR(2),p_nro_comp INT(10)) RETURNS DATE
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
END$$

DELIMITER ;