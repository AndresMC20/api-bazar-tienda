package com.tienda.api_bazar_tienda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El username no puede estar vacio")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "El password no puede estar vacio")
    private String password;

    @Transient
    @NotBlank(message = "La confirmación del password no puede estar vacio")
    private String confirmationPassword;

}