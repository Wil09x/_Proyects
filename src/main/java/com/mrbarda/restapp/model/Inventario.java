package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank
    @Size(max = 80)
    @Column(nullable = false)
    private String nombreInsumo;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false)
    private String unidadMedida;

    @NotNull
    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal cantidadDisponible;

    @DecimalMin("0.00")
    private BigDecimal stockMinimo;

    @Column(nullable = false)
    private Boolean activo = true;
}

