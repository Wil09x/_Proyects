package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 20)
    private String tipoCliente; // NATURAL o JURIDICA

    @Column(length = 20)
    private String tipoDocumento; // DNI o RUC

    @Column(nullable = false, length = 20)
    private String numeroDocumento;

    @Column(length = 100)
    private String razonSocial;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(nullable = false)
    private Boolean esUsuario;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
