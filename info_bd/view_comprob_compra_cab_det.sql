DELIMITER $$

ALTER ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_comprob_compra_cab_det` AS (
SELECT
  `c`.`cod_tipo_comp`           AS `tipo_comp`,
  (CASE WHEN (`c`.`cod_tipo_comp` = 'FCO') THEN 'FACTURA CONTADO' WHEN (`c`.`cod_tipo_comp` = 'FCR') THEN 'FACTURA CREDITO' WHEN (`c`.`cod_tipo_comp` = 'AJU') THEN 'NOTA DE AJUSTE STOCK' ELSE 'COMP NO ENCONTRADO' END) AS `tipo_comprobante`,
  `c`.`ser_timb_comp`           AS `serie_comp`,
  `c`.`nro_comprob_comp`        AS `nro_comp`,
  `c`.`nro_timbrado`            AS `nro_timbrado_comp`,
  DATE_FORMAT(`c`.`fecha_comprob_comp`,'%d/%m/%Y') AS `fecha_comprob`,
  `c`.`cod_usuario`             AS `cod_usuario`,
  `pu`.`nombre`                 AS `nomb_usuario`,
  `c`.`cod_sucursal`            AS `cod_sucursal`,
  `s`.`desc_sucursal`           AS `desc_sucursal`,
  `c`.`cod_deposito`            AS `cod_deposito`,
  `da`.`desc_deposito`          AS `desc_deposito`,
  `c`.`cod_proveedor`           AS `cod_proveedor`,
  `pp`.`nombre`                 AS `nomb_proveedor`,
  `c`.`cod_cond_comp`           AS `cond_comp`,
  `cv`.`descripcion`            AS `descripcion`,
  `c`.`cant_cuota`              AS `cant_cuota`,
  DATE_FORMAT(`c`.`fecha_inic_comp`,'%d/%m/%Y') AS `fecha_inic_comp`,
  `c`.`monto_cuota`             AS `monto_cuota`,
  `c`.`total_comprob_comp`      AS `total_comp`,
  `c`.`iva_comp`                AS `total_iva_comp`,
  `c`.`gravada`                 AS `total_grav_comp`,
  `c`.`cod_moneda`              AS `cod_moneda`,
  `mo`.`desc_moneda`            AS `desc_moneda`,
  `c`.`tipo_cambio`             AS `tipo_cambio`,
  `c`.`estado`                  AS `estado`,
  `d`.`cod_producto`            AS `cod_articulo`,
  `d`.`cod_un_med`              AS `unidad_med`,
  `d`.`nro_lote`                AS `nro_lote`,
  `d`.`descripcion_prod`        AS `desc_articulo`,
  `d`.`cantidad_prod`           AS `cant_articulo`,
  `d`.`precio_unitario`         AS `precio_unitario`,
  `d`.`descuento`               AS `descuento`,
  `d`.`importe`                 AS `importe`,
  `d`.`total_iva_5`             AS `iva5`,
  `d`.`total_iva_10`            AS `iva10`,
  `d`.`gravada_5`               AS `gravada5`,
  `d`.`gravada_10`              AS `gravada10`,
  `c`.`cod_mot_ent_sal_art`     AS `trans_ent_sal_art`,
  `tra`.`descripcion`           AS `desc_trans_ent_sal_art`,
  `c`.`cod_sub_mot_ent_sal_art` AS `sub_trans_ent_sal_art`,
  `sub`.`descripcion`           AS `desc_sub_trans_ent_sal_art`
FROM (((((((((((`comprobante_cabecera_compra` `c`
             LEFT JOIN `comprobante_detalle_compra` `d`
               ON (((`c`.`cod_tipo_comp` = `d`.`cod_tipo_comp`)
                    AND (`c`.`ser_timb_comp` = `d`.`ser_timb_comp`)
                    AND (`c`.`nro_comprob_comp` = `d`.`nro_comprob_comp`))))
            LEFT JOIN `usuario` `u`
              ON ((`c`.`cod_usuario` = `u`.`cod_usuario`)))
           LEFT JOIN `persona` `pu`
             ON ((`u`.`cod_persona` = `pu`.`cod_persona`)))
          LEFT JOIN `sucursal` `s`
            ON ((`c`.`cod_sucursal` = `s`.`cod_sucursal`)))
         LEFT JOIN `deposito_articulo` `da`
           ON ((`c`.`cod_deposito` = `da`.`cod_deposito`)))
        LEFT JOIN `proveedor` `pr`
          ON ((`c`.`cod_proveedor` = `pr`.`cod_proveedor`)))
       LEFT JOIN `persona` `pp`
         ON ((`pr`.`cod_persona` = `pp`.`cod_persona`)))
      LEFT JOIN `condicion_venta` `cv`
        ON ((`c`.`cod_cond_comp` = `cv`.`cod_condicion`)))
     LEFT JOIN `moneda` `mo`
       ON ((`c`.`cod_moneda` = `mo`.`cod_moneda`)))
    LEFT JOIN `tipo_transaccion` `tra`
      ON ((`c`.`cod_mot_ent_sal_art` = `tra`.`cod_tipo_trans`)))
   LEFT JOIN `sub_tipo_transaccion` `sub`
     ON (((`c`.`cod_mot_ent_sal_art` = `sub`.`cod_tipo_trans`)
          AND (`c`.`cod_sub_mot_ent_sal_art` = `sub`.`cod_sub_tipo_trans`)))))$$

DELIMITER ;