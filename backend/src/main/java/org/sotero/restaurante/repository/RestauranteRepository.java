package org.sotero.restaurante.repository;

import org.sotero.restaurante.model.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("SELECT r FROM Restaurante r WHERE r.correo = :correo")
    Optional<Restaurante> findRestauranteByCorreo(@Param("correo") String correo);
}
