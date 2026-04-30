package org.sotero.restaurante.service;

import org.sotero.restaurante.model.entity.Restaurante;

import java.util.Optional;

public interface IRestauranteService {

    Optional<Restaurante> findRestauranteByCorreo(String correo);

}
