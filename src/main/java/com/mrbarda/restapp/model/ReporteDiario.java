package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reportes_diarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReporteDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private BigDecimal totalVentas;

    @Column(nullable = false)
    private BigDecimal totalEfectivo;

    @Column(nullable = false)
    private BigDecimal totalTarjeta;
}
