package com.mundial.mundial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Comparable<Usuarios>{
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

    @Column(name = "rol")
    @Getter @Setter
    private String rol;

    @Override
    public int compareTo(Usuarios u) {

        if (this.getPuntos()<u.getPuntos()) {

            return 1;
        }else if (this.getPuntos()>u.getPuntos()) {
            return -1;
        }else {
            return 0;
        }
    }

}
