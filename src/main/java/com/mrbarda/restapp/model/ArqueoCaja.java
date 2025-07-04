package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "arqueo_cajas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArqueoCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "caja_id", nullable = false)
    private Caja caja;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "monto_declarado", nullable = false)
    private BigDecimal montoDeclarado;

    @Column(name = "monto_calculado", nullable = false)
    private BigDecimal montoCalculado;

    @Column(nullable = false)
    private BigDecimal diferencia;

    @Column(length = 255)
    private String observacion;
}
