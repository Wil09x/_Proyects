package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log_errores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LogError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 300)
    private String mensaje;

    @Column(length = 1000)
    private String traza;
}
