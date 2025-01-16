package com.jgdev.timework.TimeWork.service;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.domain.Ponto;
import jakarta.transaction.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IPontoInterface {

    public Ponto registrarEntrada(Integer funcionarioId, LocalTime entrada) ;

    public void registrarSaidaIntervalo(Integer registroId, LocalTime saidaIntervalo) ;

    public void registrarRetornoIntervalo(Integer registroId, LocalTime retornoIntervalo);

    public void registrarSaida(Integer id, LocalTime saida) ;

    public void calcularTotalPrimeiroIntervalo(Ponto ponto);

    public void calcularTotalSegundoIntervalo(Ponto ponto) ;

    public void calcularHorasExtras(Ponto ponto) ;

    public List<Ponto> getAllPontosFuncinarioById(Integer idFuncionario);

    public Ponto getPontoDayFuncinario(Integer idFuncionario, LocalDate dateDay);
}
