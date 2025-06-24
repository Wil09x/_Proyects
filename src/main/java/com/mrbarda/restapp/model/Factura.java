package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime fechaEmision;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(nullable = false, length = 10)
    private String tipoComprobante; // BOLETA o FACTURA

    @Column(nullable = false, length = 10)
    private String numeroSerie;

    @Column(nullable = false, length = 20)
    private String numeroDocumento;

    @Column(length = 20)
    private String formaPago; // EFECTIVO, TARJETA, TRANSFERENCIA

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private Boolean anulado;
}
