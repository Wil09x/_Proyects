package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private Integer id;

    @NotNull(message = "La fecha de emisión es obligatoria")
    private LocalDateTime fechaEmision;

    @NotNull(message = "El cliente es obligatorio")
    private Integer clienteId;

    @NotNull(message = "El pedido es obligatorio")
    private Integer pedidoId;

    @NotBlank(message = "El tipo de comprobante es obligatorio")
    @Pattern(regexp = "BOLETA|FACTURA", message = "Tipo debe ser BOLETA o FACTURA")
    private String tipoComprobante;

    @NotBlank(message = "La serie es obligatoria")
    @Size(max = 10)
    private String numeroSerie;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(max = 20)
    private String numeroDocumento;

    @NotBlank(message = "La forma de pago es obligatoria")
    private String formaPago; // EFECTIVO, TARJETA, TRANSFERENCIA

    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0.01", message = "El total debe ser mayor a 0")
    private BigDecimal total;

    @NotNull
    private Boolean anulado;
}
