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
@Table(name = "Ingredientes_productos")
public class IngredienteProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "platillo_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "inventario_id", nullable = false)
    private Inventario insumo;

    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal cantidadRequerida;
}

