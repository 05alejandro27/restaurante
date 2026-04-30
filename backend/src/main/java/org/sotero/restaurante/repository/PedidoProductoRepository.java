package org.sotero.restaurante.repository;

import org.sotero.restaurante.model.entity.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Long> {

    @Query("SELECT pp FROM PedidoProducto pp WHERE pp.pedido.codPed = :codPed")
    List<PedidoProducto> findLineasByPedido(@Param("codPed") Long codPed);
}