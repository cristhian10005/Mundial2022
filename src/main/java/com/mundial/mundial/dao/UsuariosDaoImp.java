package com.mundial.mundial.dao;

import com.mundial.mundial.models.Usuarios;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

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

    @Override
    public void registrarUsuario(Usuarios u) {
        entityManager.merge(u);
    }

    @Override
    public Usuarios Autenticar(String nombreusuario) {
        String query ="FROM Usuarios WHERE nombreusuario = :nombreusuario";

        Object user= entityManager.createQuery(query)
                .setParameter("nombreusuario", nombreusuario)
                .getResultStream().findFirst().orElse(null);
        Usuarios u = user==null?null:(Usuarios) user;
        return u;
    }
}
