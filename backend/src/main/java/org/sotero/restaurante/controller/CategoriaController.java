package org.sotero.restaurante.controller;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.dto.CategoriaDTO;
import org.sotero.restaurante.service.ICategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurante")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<CategoriaDTO> findCategoria() {
        return categoriaService.findCategoria()
                .stream()
                .map(categoria -> new CategoriaDTO(categoria))
                .toList();
    }

    @GetMapping("/categorias/{id}")
    public CategoriaDTO findCategoriaById(@PathVariable Long id) {
        return new CategoriaDTO(categoriaService.findCategoriaById(id));
    }
}
