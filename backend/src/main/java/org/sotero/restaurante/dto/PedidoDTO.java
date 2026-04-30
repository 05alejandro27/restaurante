package org.sotero.restaurante.dto;

import org.sotero.restaurante.model.entity.Pedido;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(
        Long codPed,
        LocalDate fecha,
        Integer enviado,
        String restauranteCorreo,
        List<PedidoLineaDTO> lineas
) {

    public PedidoDTO(Pedido p, List<PedidoLineaDTO> lineas) {
        this(p.getCodPed(), p.getFecha(), p.getEnviado(), p.getRestaurante().getCorreo(), lineas);
    }
}