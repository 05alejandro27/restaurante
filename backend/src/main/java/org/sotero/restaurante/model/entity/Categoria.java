package org.sotero.restaurante.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categorias")
public class Categoria {

    @Id
    @Column(name = "codCat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCat;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
