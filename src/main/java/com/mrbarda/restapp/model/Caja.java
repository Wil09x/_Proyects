package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cajas")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;

    @NotNull
    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal saldoInicial;

    @DecimalMin("0.00")
    private BigDecimal saldoFinal;

    @Column(nullable = false)
    private Boolean cerrada = false;

    @ManyToOne
    @JoinColumn(name = "encargado_id", nullable = false)
    private Empleado encargado;
}

