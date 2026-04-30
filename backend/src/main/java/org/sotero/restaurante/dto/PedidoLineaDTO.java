package org.sotero.restaurante.dto;

import org.sotero.restaurante.model.entity.PedidoProducto;

public record PedidoLineaDTO(
        String productoNombre,
        Integer unidades
) {
    public PedidoLineaDTO(PedidoProducto pp) {
        this(pp.getProducto().getNombre(), pp.getUnidades());
    }
}