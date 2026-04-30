package org.sotero.restaurante.service.impl;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.model.entity.Categoria;
import org.sotero.restaurante.repository.CategoriaRepository;
import org.sotero.restaurante.service.ICategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findCategoria() {

        return categoriaRepository.findCategoria();
    }

    @Override
    public Categoria findCategoriaById(Long id) {

        return categoriaRepository.findCategoriaById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + id));

    }
}
