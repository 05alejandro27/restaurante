package org.sotero.restaurante.controller;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.dto.ProductoDTO;
import org.sotero.restaurante.service.IProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurante")
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping("/productos/{id}")
    public ProductoDTO findProductoById(@PathVariable Long id) {
        return new ProductoDTO(productoService.findProductoById(id));
    }

    @GetMapping("/productos/categoria/{id}")
    public List<ProductoDTO> findProductoByCategoria(@PathVariable Long id) {
        return productoService.findProductoByCategoria(id)
                .stream()
                .map(producto -> new ProductoDTO(producto))
                .toList();
    }
}
