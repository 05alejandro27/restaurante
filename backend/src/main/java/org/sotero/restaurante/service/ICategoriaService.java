package org.sotero.restaurante.service;

import org.sotero.restaurante.model.entity.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> findCategoria();
    Categoria findCategoriaById(Long id);

}