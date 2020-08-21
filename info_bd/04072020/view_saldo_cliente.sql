DELIMITER $$

ALTER ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_saldo_cliente` AS (
SELECT
  `s`.`tipo_comprobante`  AS `tipo_comprobante`,
  `s`.`ser_comprobante`   AS `ser_comprobante`,
  `s`.`nro_comprobante`   AS `nro_comprobante`,
  `s`.`cod_cliente`       AS `cod_cliente`,
  `p`.`nombre`            AS `nombre`,
  `s`.`nro_cuota`         AS `nro_cuota`,
  `s`.`fecha_vencimiento` AS `fec_venc`,
  DATE_FORMAT(`s`.`fecha_vencimiento`,'%d/%m/%Y') AS `fecha_vencimiento`,
  `s`.`saldo_cuota`       AS `saldo_cuota`,
  `s`.`cod_referencia`    AS `ref_comprob`,
  TIMESTAMPDIFF(DAY,s.fecha_vencimiento, CURDATE()) AS dias
FROM ((`saldo_cliente` `s`
    LEFT JOIN `cliente` `c`
      ON ((`s`.`cod_cliente` = `c`.`cod_cliente`)))
   LEFT JOIN `persona` `p`
     ON ((`c`.`cod_persona` = `p`.`cod_persona`)))
ORDER BY `s`.`ser_comprobante`,`s`.`nro_comprobante`,`s`.`nro_cuota`)$$

DELIMITER ;