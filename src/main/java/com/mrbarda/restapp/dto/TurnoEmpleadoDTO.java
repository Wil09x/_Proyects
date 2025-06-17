package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoEmpleadoDTO {

    private Integer id;

    @NotNull(message = "El empleado es obligatorio")
    private Integer empleadoId;

    @NotNull(message = "La fecha del turno es obligatoria")
    private LocalDate fecha;

    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    private Boolean presente;
}

