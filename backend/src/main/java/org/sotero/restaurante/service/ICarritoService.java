package org.sotero.restaurante.service;

import java.util.Map;

public interface ICarritoService {

    void aniadirProducto(Long codProd, Integer unidades);

    void eliminarProducto(Long codProd);

    Map<Long, Integer> getCarrito();

    void vaciarCarrito();

}
