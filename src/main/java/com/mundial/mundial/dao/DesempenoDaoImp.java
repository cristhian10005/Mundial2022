package com.mundial.mundial.dao;

import com.mundial.mundial.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class DesempenoDaoImp implements DesempenoDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Desempeno> getDesempeno() {
        String query ="FROM Desempeno";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void asignarEquipos(Desempeno d,Desempeno d2) {
        entityManager.merge(d);
        entityManager.merge(d2);
    }

    @Override
    public List<Partido> getPartidos() {
        String query = "FROM Partido";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Equipos> getEquipos() {
        String query = "FROM Equipos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void crearPartido(Desempeno d, Desempeno d2) {
        Partido partido = new Partido(new Date(2022,11,27),d,d2,"pendiente",0);
        entityManager.merge(partido);
    }

    @Override
    public void registrarResultado(int m1, int m2, int idp, int idu) {
        Usuarios u =entityManager.find(Usuarios.class, idu);
        Partido p = entityManager.find(Partido.class, idp);
        Resultado resultado = new Resultado(p, m1, m2, u, "pendiente");
        entityManager.merge(resultado);
    }

    @Override
    public List<Resultado> resultados() {
        String query = "FROM Resultado";
        return entityManager.createQuery(query).getResultList();
    }

}
