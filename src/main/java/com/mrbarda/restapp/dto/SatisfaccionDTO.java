package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SatisfaccionDTO {

    private Integer id;

    @NotNull(message = "El pedido es obligatorio")
    private Integer pedidoId;

    @NotNull(message = "La puntuación es obligatoria")
    @Min(1)
    @Max(5)
    private Integer puntuacion;

    @Size(max = 300)
    private String comentario;
}
