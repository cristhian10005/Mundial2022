package com.mundial.mundial.dao;

import com.mundial.mundial.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
    public List<Partido> getPartidos(int id) {
        String query = "FROM Partido WHERE estado = :estado";
        boolean comp = true;
        List<Partido>lista = new ArrayList<>();
        List<Partido>partidos =entityManager.createQuery(query)
                .setParameter("estado","pendiente")
                .getResultList();
        for (Partido p: partidos) {
            comp =true;
            for (Resultado r: p.getResultados()) {
                if (r.getUsuarios().getId()==id){
                    comp = false;
                    break;
                }
            }
            if (comp) lista.add(p);
        }

        return lista;
    }

    @Override
    public List<Equipos> getEquipos() {
        String query = "FROM Equipos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void crearPartido(Desempeno d, Desempeno d2) {
        Partido partido = new Partido(new Date(2022,11,27),d,d2,"pendiente");
        entityManager.merge(partido);
    }

    @Override
    public void registrarResultado(int m1, int m2, int idp, int idu) {
        Usuarios u =entityManager.find(Usuarios.class, idu);
        Partido p = entityManager.find(Partido.class, idp);
            Resultado resultado = new Resultado(p, m1, m2, u, "pendiente",0);
            entityManager.merge(resultado);
             if(u.getRol().equals("admin")) {
            p.getEquipo1().setGoles(m1);
            p.getEquipo2().setGoles(m2);
            entityManager.merge(p);
        }
    }



    @Override
    public List<Resultado> resultados() {
        String query = "FROM Resultado";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void asignarPuntos(int id) {
        Partido p = entityManager.find(Partido.class, id);
        int m1=0, m2=0;
        for (Resultado r: p.getResultados()) {
            if (r.getUsuarios().getRol().equals("admin")){
                m1 = r.getMarcador1();
                m2 = r.getMarcador2();
            }
        }
        for (Resultado r: p.getResultados()) {
            int addPuntos = 0;
            if (r.getMarcador1() ==m1 || r.getMarcador2() == m2){
                Usuarios user = entityManager.find(Usuarios.class, r.getUsuarios().getId());
                if (r.getMarcador1() ==m1 && r.getMarcador2() == m2){
                        r.setPuntos(3);
                        addPuntos = user.getPuntos() + 3;
                        user.setPuntos(addPuntos);
                }else {
                    r.setPuntos(1);
                    addPuntos = user.getPuntos() +1;
                }
                entityManager.merge(r);
                entityManager.merge(user);
            }
        }
    }

}
