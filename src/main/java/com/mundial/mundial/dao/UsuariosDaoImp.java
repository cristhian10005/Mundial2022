package com.mundial.mundial.dao;

import com.mundial.mundial.models.Usuarios;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuariosDaoImp implements UsuarioDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuarios> getUsuarios() {
        String query ="FROM Usuarios";
        return entityManager.createQuery(query).getResultList();
    }
}
