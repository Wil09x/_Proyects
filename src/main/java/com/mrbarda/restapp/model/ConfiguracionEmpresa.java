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
@Table(name = "configuracion_empresa")
public class ConfiguracionEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    private String nombreEmpresa;

    @NotBlank
    private String ruc;

    private String direccion;
    private String telefono;
    private String email;
    private String logoUrl;

    @DecimalMin("0.00")
    private BigDecimal igv;

    @DecimalMin("0.00")
    private BigDecimal porcentajeServicio;
}

