package org.sotero.restaurante.dto;

public record CarritoDTO(
        Long codProd,
        String nombre,
        String descripcion,
        Double peso,
        Integer unidades
) {}