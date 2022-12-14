package com.mundial.mundial.dao;

import com.mundial.mundial.models.Desempeno;
import com.mundial.mundial.models.Equipos;
import com.mundial.mundial.models.Partido;
import com.mundial.mundial.models.Resultado;

import java.util.List;

public interface DesempenoDao {
    List<Desempeno> getDesempeno();
    void asignarEquipos(Desempeno d, Desempeno d2);
    List<Partido> getPartidos(int id);

    List<Equipos> getEquipos();

    void crearPartido(Desempeno d, Desempeno d2);

    void registrarResultado(int m1, int m2, int idp, int idu);

    List<Partido>resultados();
    void  asignarPuntos(int id);

    void inhabilitar(int id);
}
