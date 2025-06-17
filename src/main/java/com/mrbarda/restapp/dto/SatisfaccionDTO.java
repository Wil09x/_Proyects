package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SatisfaccionDTO {

    private Integer id;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Integer pedidoId;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer clienteId;

    @NotNull(message = "La puntuación es obligatoria")
    @Min(1)
    @Max(5)
    private Integer puntuacion;

    @Size(max = 255, message = "Comentario máximo 255 caracteres")
    private String comentario;
}

