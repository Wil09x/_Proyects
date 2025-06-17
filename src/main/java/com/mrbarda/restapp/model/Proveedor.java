package com.mrbarda.restapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import com.mrbarda.restapp.model.TipoDocumento;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @NotBlank
    @Size(min = 8, max = 11)
    @Column(nullable = false, unique = true)
    private String numeroDocumento;

    @Size(max = 100)
    private String razonSocial;

    @Pattern(regexp = "^9\\d{8}$")
    private String telefono;

    @Email
    private String email;

    @Size(max = 200)
    private String direccion;

    @Column(nullable = false)
    private Boolean activo = true;
}

