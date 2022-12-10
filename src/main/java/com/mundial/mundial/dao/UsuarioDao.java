package com.mundial.mundial.dao;

import com.mundial.mundial.models.Usuarios;

import java.util.List;

public interface UsuarioDao {
    List<Usuarios> getUsuarios();

    void registrarUsuario(Usuarios u);
    Usuarios Autenticar(String nombreusuario);
}
