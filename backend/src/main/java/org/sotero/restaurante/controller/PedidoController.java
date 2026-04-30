package org.sotero.restaurante.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.sotero.restaurante.dto.PedidoDTO;
import org.sotero.restaurante.dto.PedidoLineaDTO;
import org.sotero.restaurante.model.entity.Pedido;
import org.sotero.restaurante.model.entity.Restaurante;
import org.sotero.restaurante.service.ICarritoService;
import org.sotero.restaurante.service.IPedidoService;
import org.sotero.restaurante.service.IRestauranteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurante")
public class PedidoController {

    private final IPedidoService pedidoService;
    private final ICarritoService carritoService;
    private final IRestauranteService restauranteService;

    @GetMapping("/pedidos")
    public List<PedidoDTO> findPedidosByRestaurante(Authentication authentication) {

        String correo = authentication.getName();

        Restaurante restaurante = restauranteService.findRestauranteByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado: " + correo));

        return pedidoService.findPedidosByRestaurante(restaurante.getCodRes())
                .stream()
                .map(pedido -> {
                    List<PedidoLineaDTO> lineas = pedidoService.findLineasByPedido(pedido.getCodPed())
                            .stream()
                            .map(PedidoLineaDTO::new)
                            .toList();
                    return new PedidoDTO(pedido, lineas);
                })
                .toList();
    }

    @PostMapping("/pedidos")
    public PedidoDTO confirmarPedido(Authentication authentication) {

        String correo = authentication.getName();

        Restaurante restaurante = restauranteService.findRestauranteByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado: " + correo));

        Map<Long, Integer> carrito = carritoService.getCarrito();

        if (carrito.isEmpty()) {
            throw new RuntimeException("El carrito esta vacio");
        }

        Pedido pedido = pedidoService.confirmarPedido(restaurante, carrito);

        carritoService.vaciarCarrito();

        List<PedidoLineaDTO> lineas = pedidoService.findLineasByPedido(pedido.getCodPed())
                .stream()
                .map(pedidoProducto -> new PedidoLineaDTO(pedidoProducto))
                .toList();

        return new PedidoDTO(pedido, lineas);
    }
}