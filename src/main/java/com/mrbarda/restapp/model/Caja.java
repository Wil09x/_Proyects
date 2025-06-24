package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cajas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime fechaHoraApertura;

    @Column
    private LocalDateTime fechaHoraCierre;

    @Column(nullable = false)
    private BigDecimal montoInicial;

    @Column
    private BigDecimal montoFinal;

    @Column(nullable = false)
    private Boolean abierta;
}
