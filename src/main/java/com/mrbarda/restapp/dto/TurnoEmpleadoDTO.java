package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoEmpleadoDTO {

    private Integer id;

    @NotNull(message = "El empleado es obligatorio")
    private Integer empleadoId;

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalDateTime horaInicio;

    private LocalDateTime horaFin;
}
