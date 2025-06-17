package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "descuentos_promocion")
public class DescuentoPromocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank
    private String nombre;

    private String descripcion;

    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal porcentaje;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    private Boolean activo = true;

    @ManyToMany
    private List<Producto> productos;
}

