package com.tienda.api_bazar_tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalles")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @NotNull(message = "Asignar una venta, no puede estar vacia")
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @NotNull(message = "Asignar un producto, no puede estar vacia")
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(nullable = false)
    @Min(value = 0, message = "El valor minimo es 0")
    private Integer cantidad;

    @Column(name = "sub_total", nullable = false)
    @Min(value = 0, message = "El valor minimo es 0")
    private Double subTotal;
}