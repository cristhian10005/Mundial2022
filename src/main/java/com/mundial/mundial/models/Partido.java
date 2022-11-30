package com.mundial.mundial.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "partido")
@NoArgsConstructor
public class Partido {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="fecha")
    @JsonFormat(pattern = "yyyyMMdd")
    private Date fecha;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "idequi1")
    private Desempeno equipo1;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "idequ2")
    private Desempeno equipo2;

    @Column(name = "estado")
    private String estado;


    @Getter @Setter
    @OneToMany(mappedBy ="partido")
    List<Resultado> resultados;

    public Partido(Date fecha, Desempeno equipo1, Desempeno equipo2, String estado) {
        this.fecha = fecha;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.estado = estado;
    }
}
