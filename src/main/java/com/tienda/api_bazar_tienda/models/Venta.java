package com.tienda.api_bazar_tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(nullable = false, name = "fecha_venta")
    private LocalDate fechaVenta;

    @Column(nullable = false)
    @NotEmpty(message = "El total no puede estar vacio")
    @Min(value = 0, message = "El valor minimo es 0")
    private Double total;

    @NotNull(message = "Asignar un usuario, no puede estar vacio")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}