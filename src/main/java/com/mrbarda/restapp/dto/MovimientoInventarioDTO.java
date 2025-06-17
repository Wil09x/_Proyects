package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoInventarioDTO {

    private Integer id;

    @NotNull(message = "El insumo es obligatorio")
    private Integer inventarioId;

    @NotNull(message = "El proveedor es obligatorio")
    private Integer proveedorId;

    private LocalDateTime fecha;

    @NotBlank(message = "El tipo de movimiento es obligatorio")
    private String tipoMovimiento;

    @NotNull(message = "La cantidad es obligatoria")
    @DecimalMin(value = "0.01", message = "La cantidad debe ser mayor a cero")
    private BigDecimal cantidad;

    private String observacion;
}

