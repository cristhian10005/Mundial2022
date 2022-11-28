package com.mundial.mundial.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "desempeno")
@NoArgsConstructor
public class Desempeno {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Column(name = "goles")
    private int goles;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "idequipo")
    private Equipos equipo;

    public Desempeno(int goles, Equipos equipo) {
        this.goles = goles;
        this.equipo = equipo;
    }


}
