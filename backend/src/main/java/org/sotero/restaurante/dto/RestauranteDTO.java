package org.sotero.restaurante.dto;

import org.sotero.restaurante.model.entity.Restaurante;

public record RestauranteDTO(
        Long codRes,
        String correo,
        String pais,
        Integer cp,
        String ciudad,
        String direccion
) {
    public RestauranteDTO(Restaurante r) {
        this(r.getCodRes(), r.getCorreo(), r.getPais(), r.getCodigoPostal(), r.getCiudad(), r.getDireccion());
    }
}