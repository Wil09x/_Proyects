package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, length = 20)
    private String dni;

    @Column(length = 20)
    private String telefono;

    @Column(length = 50)
    private String cargo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
