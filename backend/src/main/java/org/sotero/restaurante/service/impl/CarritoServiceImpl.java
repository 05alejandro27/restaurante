package org.sotero.restaurante.service.impl;

import org.sotero.restaurante.service.ICarritoService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CarritoServiceImpl implements ICarritoService {

    Map<Long, Integer> carrito = new HashMap<>();

    @Override
    public void aniadirProducto(Long codProd, Integer unidades) {

        carrito.merge(codProd, unidades, Integer::sum);
    }

    @Override
    public void eliminarProducto(Long codProd) {

        carrito.remove(codProd);
    }

    @Override
    public Map<Long, Integer> getCarrito() {

        return carrito;
    }

    @Override
    public void vaciarCarrito() {

        carrito.clear();
    }
}