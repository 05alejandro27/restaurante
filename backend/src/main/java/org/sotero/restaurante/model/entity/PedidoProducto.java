package org.sotero.restaurante.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pedidosproductos")
public class PedidoProducto {

    @Id
    @Column(name = "codPedProd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPedProd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto")
    private Producto producto;

    @Column(name = "unidades")
    private Integer unidades;
}
