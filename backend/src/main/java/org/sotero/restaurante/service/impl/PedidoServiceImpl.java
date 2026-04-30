package org.sotero.restaurante.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sotero.restaurante.model.entity.Pedido;
import org.sotero.restaurante.model.entity.PedidoProducto;
import org.sotero.restaurante.model.entity.Producto;
import org.sotero.restaurante.model.entity.Restaurante;
import org.sotero.restaurante.repository.PedidoProductoRepository;
import org.sotero.restaurante.repository.PedidoRepository;
import org.sotero.restaurante.repository.ProductoRepository;
import org.sotero.restaurante.service.IPedidoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoProductoRepository pedidoProductoRepository;
    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public Pedido confirmarPedido(Restaurante restaurante, Map<Long, Integer> carrito) {

        Pedido pedido = new Pedido();

        pedido.setFecha(LocalDate.now());
        pedido.setEnviado(0);
        pedido.setRestaurante(restaurante);

        Pedido pedidoCreado = pedidoRepository.save(pedido);

        for (Map.Entry<Long, Integer> entry : carrito.entrySet()) {
            Long codProd = entry.getKey();
            Integer unidades = entry.getValue();

            Producto producto = productoRepository.findProductoById(codProd)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + codProd));

            if (producto.getStock() < unidades) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - unidades);
            productoRepository.save(producto);

            PedidoProducto pedidoProducto = new PedidoProducto();
            pedidoProducto.setProducto(producto);
            pedidoProducto.setPedido(pedidoCreado);
            pedidoProducto.setUnidades(unidades);

            pedidoProductoRepository.save(pedidoProducto);
        }

        return pedidoCreado;
    }

    @Override
    public List<Pedido> findPedidosByRestaurante(Long codRes) {

        return pedidoRepository.findPedidosByRestaurante(codRes);
    }

    @Override
    public List<PedidoProducto> findLineasByPedido(Long codPed) {

        return pedidoProductoRepository.findLineasByPedido(codPed);
    }
}
