package com.mundial.mundial.controllers;

import com.mundial.mundial.dao.UsuarioDao;
import com.mundial.mundial.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuariosController {
    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping(value = "api/index")
    public List<Usuarios> prueba(){
        return usuarioDao.getUsuarios();
    }
}
