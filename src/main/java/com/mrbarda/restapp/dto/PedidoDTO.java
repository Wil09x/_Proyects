package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer id;

    @NotNull(message = "El cliente es obligatorio")
    private Integer clienteId;

    @NotNull(message = "El empleado es obligatorio")
    private Integer empleadoId;

    private Integer mesaId;

    private LocalDateTime fechaHora;

    @NotBlank(message = "El estado del pedido es obligatorio")
    private String estado;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;

    private BigDecimal total;

    private List<DetallePedidoDTO> detalles;
}

