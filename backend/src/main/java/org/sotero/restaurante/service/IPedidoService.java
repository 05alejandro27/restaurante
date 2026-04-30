package org.sotero.restaurante.service;

import org.sotero.restaurante.model.entity.*;

import java.util.List;
import java.util.Map;

public interface IPedidoService {

    Pedido confirmarPedido(Restaurante restaurante, Map<Long, Integer> carrito);
    List<Pedido> findPedidosByRestaurante(Long codRes);
    List<PedidoProducto> findLineasByPedido(Long codPed);

}
