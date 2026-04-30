package org.sotero.restaurante.service.impl;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.model.entity.Producto;
import org.sotero.restaurante.repository.ProductoRepository;
import org.sotero.restaurante.service.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto findProductoById(Long codProd) {

        return productoRepository.findProductoById(codProd)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + codProd));
    }

    @Override
    public List<Producto> findProductoByCategoria(Long codCat) {

        return productoRepository.findProductoByCategoria(codCat);
    }
}
