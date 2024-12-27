package com.jgdev.timework.TimeWork.controller;

import com.jgdev.timework.TimeWork.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("api/v1/ponto")
public class PontoController {
    @Autowired
    PontoService pontoService;

    @PostMapping("entarda/{id}")
    public void setEntrada(@PathVariable("id") Integer id) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarEntrada(id, entrada);
    }

    @PostMapping("saidainterval/{id}")
    public void setSaidaIntervalo(@PathVariable("id") Integer id) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarSaidaIntervalo(id, entrada);
    }

    @PostMapping("retornointerval/{id}")
    public void setRetornoIntervalo(@PathVariable("id") Integer id) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarRetornoIntervalo(id, entrada);
    }


    @PostMapping("saida/{id}")
    public void setSaida(@PathVariable("id") Integer id) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarSaida(id, entrada);
    }
}
