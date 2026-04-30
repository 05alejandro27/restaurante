package org.sotero.restaurante.controller;

import lombok.AllArgsConstructor;
import org.sotero.restaurante.dto.CarritoDTO;
import org.sotero.restaurante.model.entity.Producto;
import org.sotero.restaurante.service.ICarritoService;
import org.sotero.restaurante.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurante")
public class CarritoController {

    private final ICarritoService carritoService;
    private final IProductoService productoService;

    @GetMapping("/carrito")
    public List<CarritoDTO> getCarrito() {

        Map<Long, Integer> carrito = carritoService.getCarrito();
        List<CarritoDTO> carritoDTO = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : carrito.entrySet()) {
            Long codProd = entry.getKey();
            Integer unidades = entry.getValue();

            Producto producto = productoService.findProductoById(codProd);

            carritoDTO.add(new CarritoDTO(codProd, producto.getNombre(), producto.getDescripcion(), producto.getPeso(), unidades));
        }

        return carritoDTO;
    }

    @PostMapping("/carrito")
    public void aniadirProducto(@RequestParam Long codProd, @RequestParam Integer unidades) {

        if (unidades == null || unidades <= 0) {
            throw new RuntimeException("Las cantidad debe ser positiva");
        }

        //Comprobar que el producto existe
        productoService.findProductoById(codProd);

        carritoService.aniadirProducto(codProd, unidades);
    }

    @DeleteMapping("/carrito/{codProd}")
    public void eliminarProducto(@PathVariable Long codProd) {
        carritoService.eliminarProducto(codProd);
    }

    @DeleteMapping("/carrito")
    public void vaciarCarrito() {
        carritoService.vaciarCarrito();
    }

}
