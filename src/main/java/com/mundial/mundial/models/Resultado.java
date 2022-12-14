package com.mundial.mundial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "resultados")
@NoArgsConstructor
public class Resultado {
    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @Getter @Setter
    @JsonIgnore
    @JoinColumn(name = "idpartido")
    private Partido partido;

    @Getter @Setter
    @Column(name = "marcador1")
    private int marcador1;

    @Getter @Setter
    @Column(name = "marcador2")
    private int marcador2;

    @ManyToOne @Getter @Setter
    @JoinColumn(name = "idpersona")
    private Usuarios usuarios;

    @Getter @Setter
    @Column(name = "estado")
    private String estado;

    @Getter @Setter
    @Column(name = "puntos")
    private int puntos;

    public Resultado(Partido partido, int marcador1, int marcador2, Usuarios usuarios, String estado, int puntos) {
        this.partido = partido;
        this.marcador1 = marcador1;
        this.marcador2 = marcador2;
        this.usuarios = usuarios;
        this.estado = estado;
        this.puntos = puntos;
    }
}
