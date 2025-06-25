package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "configuraciones_empresa")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConfiguracionEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 200)
    private String direccion;

    @Column(length = 100)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String logoUrl;
}
