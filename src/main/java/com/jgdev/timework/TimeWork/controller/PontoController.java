package com.jgdev.timework.TimeWork.controller;

import com.jgdev.timework.TimeWork.domain.Ponto;
import com.jgdev.timework.TimeWork.service.Impl.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/ponto")
public class PontoController {
    @Autowired
    PontoService pontoService;

    @GetMapping("/{id}")
    public List<Ponto> getAllPotosByFuncionarioId(@PathVariable("id") Integer funcionarioId ){
        return  pontoService.getAllPontosFuncinarioById(funcionarioId);
    }
    @GetMapping("/registerday/{id}/{day}")
    public Ponto getPotosDayFuncionarioByIdandDate(@PathVariable("id") Integer funcionarioId, @PathVariable("day") LocalDate dateDay ){
        return  pontoService.getPontoDayFuncinario(funcionarioId,dateDay);
    }




    @PostMapping("/entarda/{id}")
    public void setEntrada(@PathVariable("id") Integer funcionarioId) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarEntrada(funcionarioId, entrada);
    }

    @PostMapping("/saidainterval/{id}")
    public void setSaidaIntervalo(@PathVariable("id") Integer registroId) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarSaidaIntervalo(registroId, entrada);
    }

    @PostMapping("/retornointerval/{id}")
    public void setRetornoIntervalo(@PathVariable("id") Integer registroId) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarRetornoIntervalo(registroId, entrada);
    }


    @PostMapping("/saida/{id}")
    public void setSaida(@PathVariable("id") Integer registroId) {
        LocalTime entrada =  LocalTime.now();
        pontoService.registrarSaida(registroId, entrada);
    }
}
