package org.sotero.restaurante.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {

    @Id
    @Column(name = "codPed")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPed;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "enviado")
    private Integer enviado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante")
    private Restaurante restaurante;
}
