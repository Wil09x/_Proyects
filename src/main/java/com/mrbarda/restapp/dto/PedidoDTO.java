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

    @NotNull(message = "El empleado que atiende es obligatorio")
    private Integer empleadoId;

    @NotNull(message = "La fecha y hora es obligatoria")
    private LocalDateTime fechaHora;

    @NotBlank(message = "El estado del pedido es obligatorio")
    private String estado; // PENDIENTE, PREPARANDO, ENTREGADO, PAGADO

    @NotNull(message = "El total es obligatorio")
    private BigDecimal total;

    @NotEmpty(message = "Debe contener al menos un detalle")
    private List<DetallePedidoDTO> detalles;
}
