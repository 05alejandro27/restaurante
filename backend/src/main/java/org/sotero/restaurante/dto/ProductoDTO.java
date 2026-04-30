package org.sotero.restaurante.dto;

import org.sotero.restaurante.model.entity.Producto;

public record ProductoDTO(
        Long codProd,
        String nombre,
        String descripcion,
        Double peso,
        Integer stock,
        String categoriaNombre
) {
    public ProductoDTO(Producto p) {
        this(p.getCodProd(), p.getNombre(), p.getDescripcion(), p.getPeso(), p.getStock(), p.getCategoria().getNombre());
    }
}