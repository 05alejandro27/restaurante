package org.sotero.restaurante.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    @Column(name = "codRes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codRes;

    @Column(name = "correo")
    private String correo;

    @Column(name = "clave")
    private String clave;

    @Column(name = "pais")
    private String pais;

    @Column(name = "cp")
    private Integer codigoPostal;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "rol")
    private String rol;
}
