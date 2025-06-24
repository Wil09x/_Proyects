package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mesas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false, length = 20)
    private String estado; // DISPONIBLE, RESERVADA, OCUPADA
}
