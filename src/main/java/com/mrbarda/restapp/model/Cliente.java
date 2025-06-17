package com.mrbarda.restapp.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import com.mrbarda.restapp.model.TipoCliente;
import com.mrbarda.restapp.model.TipoDocumento;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipoCliente;

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

    @Column(nullable = false)
    private Boolean esUsuario = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;
}