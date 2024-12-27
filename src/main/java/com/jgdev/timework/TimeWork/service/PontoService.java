package com.jgdev.timework.TimeWork.service;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.domain.Ponto;
import com.jgdev.timework.TimeWork.repository.FuncioanarioRepository;
import com.jgdev.timework.TimeWork.repository.PontoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;
    @Autowired
    private FuncioanarioRepository funcioanarioRepository;


    @Transactional
    public Ponto registrarEntrada(Integer funcionarioId, LocalTime entrada) {
        Ponto ponto = new Ponto();
        Funcionario funcionario = funcioanarioRepository.findById(funcionarioId).get();
        ponto.setFuncionario(funcionario);
        ponto.setDataEntrada(LocalDate.now());
        ponto.setEntrada(entrada);
        return pontoRepository.save(ponto);
    }

    @Transactional
    public void registrarSaidaIntervalo(Integer id, LocalTime saidaIntervalo) {
        Optional<Ponto> pontoOpt = pontoRepository.findById(id);
        if (pontoOpt.isPresent()) {
            pontoRepository.registrarSaidaIntervalo(id, saidaIntervalo);
            pontoOpt.get().setSaidaIntervalo(saidaIntervalo);
            calcularTotalPrimeiroIntervalo(pontoOpt.get());

        }
    }

    @Transactional
    public void registrarRetornoIntervalo(Integer id, LocalTime retornoIntervalo) {
        Optional<Ponto> pontoOpt = pontoRepository.findById(id);
        if (pontoOpt.isPresent()) {
            pontoRepository.registrarRetornoIntervalo(id, retornoIntervalo);
        }
    }

    @Transactional
    public void registrarSaida(Integer id, LocalTime saida) {
        Optional<Ponto> pontoOpt = pontoRepository.findById(id);
        if (pontoOpt.isPresent()) {
            pontoRepository.registrarSaida(id, saida);
            pontoOpt.get().setSaida(saida);
            calcularTotalSegundoIntervalo(pontoOpt.get());
            calcularHorasExtras( pontoOpt.get());
        }
    }

    private void calcularTotalPrimeiroIntervalo(Ponto ponto) {
        if (ponto.getEntrada() != null && ponto.getSaidaIntervalo() != null) {
            Duration duration = Duration.between(ponto.getEntrada(), ponto.getSaidaIntervalo());
            ponto.setTotalPrimerioIntervalo(LocalTime.of((int) duration.toHours(), duration.toMinutesPart()));
            pontoRepository.registrartotalPrimerioIntervalo(ponto.getId(), ponto.getTotalPrimerioIntervalo());
        }
    }

    private void calcularTotalSegundoIntervalo(Ponto ponto) {
        if (ponto.getRetornoIntervalo() != null && ponto.getSaida() != null) {
            Duration duration = Duration.between(ponto.getRetornoIntervalo(), ponto.getSaida());
            ponto.setTotalSegundoIntervalo(LocalTime.of((int) duration.toHours(), duration.toMinutesPart()));
            pontoRepository.registrartotalPrimerioIntervalo(ponto.getId(), ponto.getTotalSegundoIntervalo());
        }


    }
    private void calcularHorasExtras(Ponto ponto) {
        if (ponto.getTotalPrimerioIntervalo() != null && ponto.getTotalSegundoIntervalo() != null) {
           LocalTime durationBussines = LocalTime.of(8,0);
            Duration durationWorking = Duration.between(ponto.getTotalPrimerioIntervalo(), ponto.getTotalSegundoIntervalo());
            LocalTime woking = LocalTime.of((int) durationWorking.toHours(), (int) durationWorking.toMinutes());
            Duration extra = Duration.between(woking, durationBussines);
            ponto.setTotalHorarioExtra(LocalTime.of((int) extra.toHours(), extra.toMinutesPart()));
            pontoRepository.CalculartotalHorarioExtra(ponto.getId(), ponto.getTotalHorarioExtra());
        }
    }


}
