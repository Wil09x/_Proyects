package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String nombres;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String apellidos;

    @NotBlank
    @Size(min = 8, max = 8)
    @Column(nullable = false, unique = true)
    private String dni;

    @Pattern(regexp = "^9\\d{8}$")
    @Column(length = 9)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;
}

