package org.estebanfern.rabbitmqcommons.utils;

import org.estebanfern.rabbitmqcommons.bean.TipoTransaccion;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.VentaReq;
import org.estebanfern.rabbitmqcommons.dto.req.CompraReq;

public class TransaccionUtils {

    public static Transaccion transaccionFromVenta(VentaReq ventaReq) {
        Transaccion transaccion = new Transaccion();
        transaccion.setTipo(TipoTransaccion.VENTA);
        transaccion.setClienteId(ventaReq.getClienteId());
        transaccion.setProductoId(ventaReq.getProductoId());
        transaccion.setCantidad(ventaReq.getCantidad());
        transaccion.setPrecioTotal(ventaReq.getPrecioTotal());
        return transaccion;
    }

    public static Transaccion transaccionFromCompra(CompraReq compraReq) {
        Transaccion transaccion = new Transaccion();
        transaccion.setTipo(TipoTransaccion.COMPRA);
        transaccion.setProductoId(compraReq.getProductoId());
        transaccion.setCantidad(compraReq.getCantidad());
        return transaccion;
    }

}
