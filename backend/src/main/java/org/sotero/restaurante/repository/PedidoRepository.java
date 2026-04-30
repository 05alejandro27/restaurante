package org.sotero.restaurante.repository;

import org.sotero.restaurante.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.restaurante.codRes = :codRes")
    List<Pedido> findPedidosByRestaurante(@Param("codRes") Long codRes);
}
