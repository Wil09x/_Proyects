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
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private LocalDateTime fechaEmision;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @NotBlank
    @Column(nullable = false)
    private String tipoComprobante;

    @NotBlank
    @Column(nullable = false)
    private String numeroSerie;

    @NotBlank
    @Column(nullable = false)
    private String numeroDocumento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPago formaPago;

    @NotNull
    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private Boolean anulado = false;
}

