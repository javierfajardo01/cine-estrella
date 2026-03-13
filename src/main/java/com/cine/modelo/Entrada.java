package com.cine.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entradas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private int asiento;

    @NotBlank
    @Column(nullable = false)
    private String nombreCliente;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "sesion_id")
    private Sesion sesion;

}
