package org.sotero.restaurante.service.impl;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.model.entity.Restaurante;
import org.sotero.restaurante.service.IRestauranteService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final IRestauranteService restauranteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Restaurante restaurante = restauranteService.findRestauranteByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));


        return User.withUsername(restaurante.getCorreo())
                .password(restaurante.getClave())
                .authorities(restaurante.getRol())
                .build();
    }
}
