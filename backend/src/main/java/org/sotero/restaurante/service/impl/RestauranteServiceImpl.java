package org.sotero.restaurante.service.impl;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.model.entity.Restaurante;
import org.sotero.restaurante.repository.RestauranteRepository;
import org.sotero.restaurante.service.IRestauranteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RestauranteServiceImpl implements IRestauranteService {

    private final RestauranteRepository restauranteRepository;

    @Override
    public Optional<Restaurante> findRestauranteByCorreo(String correo) {

        return restauranteRepository.findRestauranteByCorreo(correo);
    }
}
