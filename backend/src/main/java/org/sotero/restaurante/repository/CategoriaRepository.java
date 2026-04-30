package org.sotero.restaurante.repository;

import org.sotero.restaurante.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c")
    List<Categoria> findCategoria();

    @Query("SELECT c FROM Categoria c WHERE c.codCat = :codCat")
    Optional<Categoria> findCategoriaById(@Param("codCat") Long codCat);
}