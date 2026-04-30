package org.sotero.restaurante.service;

import org.sotero.restaurante.model.entity.Producto;

import java.util.List;

public interface IProductoService {

    Producto findProductoById(Long codProd);
    List<Producto> findProductoByCategoria(Long codCat);
}
