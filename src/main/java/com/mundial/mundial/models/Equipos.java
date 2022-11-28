package com.mundial.mundial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipos {
    @Id @Getter @Setter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

}
