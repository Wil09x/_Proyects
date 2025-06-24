package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredientes_productos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class IngredienteProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "inventario_id", nullable = false)
    private Inventario insumo;

    @Column(nullable = false)
    private BigDecimal cantidadRequerida;
}
