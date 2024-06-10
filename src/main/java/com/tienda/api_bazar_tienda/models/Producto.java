package com.tienda.api_bazar_tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El nombre del producto no puede estar vacio")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "El costo no puede estar vacio")
    private Double costo;

    @Column(nullable = false)
    @NotNull(message = "El stock no puede estar vacio")
    private Double stock;

    @NotNull(message = "Asignar una categoria, no puede estar vacio")
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}