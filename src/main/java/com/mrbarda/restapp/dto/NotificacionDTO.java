package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDTO {

    private Integer id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    private Boolean leido;

    private Integer remitenteId;

    @NotNull(message = "El destinatario es obligatorio")
    private Integer destinatarioId;

    private LocalDateTime fechaEnvio;
}

