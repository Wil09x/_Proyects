package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDTO {

    private Integer id;

    @NotBlank(message = "El mensaje es obligatorio")
    @Size(max = 200)
    private String mensaje;

    @NotNull(message = "La fecha y hora es obligatoria")
    private LocalDateTime fechaHora;

    @NotNull(message = "El estado de lectura es obligatorio")
    private Boolean leida;
}
