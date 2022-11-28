package com.mundial.mundial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id @Getter @Setter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres")
    @Getter @Setter
    private String nombres;

    @Column(name = "apellidos")
    @Getter @Setter
    private String apellidos;

    @Column(name = "nombreusuario")
    @Getter @Setter
    private String usuario;

    @Column(name = "password")
    @Getter @Setter
    private String password;
    
    @Column(name = "puntos")
    @Getter @Setter
    private int puntos;
    

}
