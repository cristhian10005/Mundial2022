package com.mundial.mundial.controllers;

import com.mundial.mundial.dao.UsuarioDao;
import com.mundial.mundial.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class UsuariosController {
    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping(value = "api/tabalResultados")
    public List<Usuarios> prueba(){
        List<Usuarios>lista = new ArrayList<>();
        for (Usuarios u:usuarioDao.getUsuarios()) {
            if (u.getRol().equals("admin"))continue;
            lista.add(u);
        }
        Collections.sort(lista);
        return lista;
    }
}
