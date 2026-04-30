package org.sotero.restaurante.dto;

import org.sotero.restaurante.model.entity.Categoria;

public record CategoriaDTO(
        Long codCat,
        String nombre,
        String descripcion
) {
    public CategoriaDTO(Categoria c) {
        this(c.getCodCat(), c.getNombre(), c.getDescripcion());
    }
}