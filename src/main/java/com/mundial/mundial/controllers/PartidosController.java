package com.mundial.mundial.controllers;

import com.mundial.mundial.dao.DesempenoDao;
import com.mundial.mundial.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartidosController {
    @Autowired
    DesempenoDao desempenoDao;

    @RequestMapping(value = "api/prepartido/{id}")
    public List<Partido> formPartidos(@PathVariable int id){
        return desempenoDao.getPartidos(id);
    }

    @RequestMapping(value = "api/equipos")
    public List<Equipos> equipos(){
        return desempenoDao.getEquipos();
    }

    @RequestMapping(value = "api/resultados")
    public List<Partido> resultados(){
        return  desempenoDao.resultados();
    }


    @RequestMapping(value = "api/asigEquipos", method = RequestMethod.POST)
    public void asignarEquipos(@RequestBody List<Equipos> lista){
        Desempeno d1 = new Desempeno(0,lista.get(0));
        Desempeno d2 = new Desempeno(0,lista.get(1));
        desempenoDao.asignarEquipos(d1, d2);
    }
    @RequestMapping(value = "api/regPartido")
    public void registrarPartido(){
       if (desempenoDao.getDesempeno().size()>1){
           Desempeno d = desempenoDao.getDesempeno().get(desempenoDao.getDesempeno().size()-2);
           Desempeno d2 = desempenoDao.getDesempeno().get(desempenoDao.getDesempeno().size()-1);
           desempenoDao.crearPartido(d, d2);
       }
    }

    @RequestMapping(value = "api/regResultado", method = RequestMethod.POST)
    public void reguistrarResultado(@RequestBody TempResultado resultado){
                desempenoDao.registrarResultado(resultado.getMarcador1(),resultado.getMarcador2(),
                resultado.getIdpartido(),resultado.getIdPersona());
    }

    @RequestMapping(value = "api/regResultado/{id}")
    public void reguistrarResultadoAdmin(@PathVariable int id){
        desempenoDao.asignarPuntos(id);

    }

    @RequestMapping(value = "api/inhabilitar/{id}")
    public void inhabilitar(@PathVariable int id){
        desempenoDao.inhabilitar(id);
    }
}
