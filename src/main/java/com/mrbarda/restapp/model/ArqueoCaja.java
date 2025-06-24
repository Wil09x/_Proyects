package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "arqueo_caja")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArqueoCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false)
    private BigDecimal montoDeclarado;

    @Column(nullable = false)
    private BigDecimal montoCalculado;

    @Column(length = 255)
    private String observacion;
}
