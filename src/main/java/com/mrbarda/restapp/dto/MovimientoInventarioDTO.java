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

    @NotNull(message = "El inventario es obligatorio")
    private Integer inventarioId;

    @NotNull(message = "El proveedor es obligatorio")
    private Integer proveedorId;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fecha;

    @NotBlank(message = "El tipo de movimiento es obligatorio")
    @Pattern(regexp = "ENTRADA|SALIDA", message = "Debe ser ENTRADA o SALIDA")
    private String tipoMovimiento;

    @NotNull(message = "La cantidad es obligatoria")
    @DecimalMin(value = "0.01", message = "Debe ser mayor a 0")
    private BigDecimal cantidad;

    @Size(max = 300)
    private String observacion;
}
