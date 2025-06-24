package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraDTO {

    private Integer id;

    @NotNull(message = "El usuario es obligatorio")
    private Integer usuarioId;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fecha;

    @NotBlank(message = "La acción es obligatoria")
    @Size(max = 100)
    private String accion;

    @Size(max = 300)
    private String descripcion;
}

