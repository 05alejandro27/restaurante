package org.sotero.restaurante.repository;

import org.sotero.restaurante.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.codProd = :codProd")
    Optional<Producto> findProductoById(@Param("codProd") Long codProd);

    @Query("SELECT p FROM Producto p WHERE p.categoria.codCat = :codCat")
    List<Producto> findProductoByCategoria(@Param("codCat") Long codCat);
}