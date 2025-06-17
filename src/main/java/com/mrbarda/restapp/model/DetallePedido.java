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
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "platillo_id", nullable = false)
    private Producto producto;

    @NotNull
    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer cantidad;

    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal subtotal;
}

