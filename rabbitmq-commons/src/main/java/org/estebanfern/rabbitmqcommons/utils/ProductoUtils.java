package org.estebanfern.rabbitmqcommons.utils;

import org.estebanfern.rabbitmqcommons.bean.Producto;
import org.estebanfern.rabbitmqcommons.dto.req.ProductoReq;

public class ProductoUtils {

    public static Producto productoFromRequest(ProductoReq productoReq) {
        Producto producto = new Producto();
        producto.setNombre(productoReq.getNombre());
        producto.setDescripcion(productoReq.getDescripcion());
        producto.setPrecio(productoReq.getPrecio());
        return producto;
    }

}
