package com.jgdev.timework.TimeWork.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ponto {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    LocalDate dataEntrada;

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    @Column(nullable = false)
    LocalTime entrada;

    LocalTime saidaIntervalo;


    LocalTime retornoIntervalo;

    LocalTime saida;
    @ManyToOne
    Funcionario funcionario;

    public LocalTime getTotalPrimerioIntervalo() {
        return totalPrimerioIntervalo;
    }

    public void setTotalPrimerioIntervalo(LocalTime totalPrimerioIntervalo) {
        this.totalPrimerioIntervalo = totalPrimerioIntervalo;
    }

    LocalTime totalPrimerioIntervalo;

    LocalTime totalSegundoIntervalo;
    LocalTime totalHorarioExtra;
    int motivo = 0;

    public Ponto() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public LocalTime getTotalSegundoIntervalo() {
        return totalSegundoIntervalo;
    }

    public void setTotalSegundoIntervalo(LocalTime totalSegundoIntervalo) {
        this.totalSegundoIntervalo = totalSegundoIntervalo;
    }

    public LocalTime getTotalHorarioExtra() {
        return totalHorarioExtra;
    }

    public void setTotalHorarioExtra(LocalTime totalHorarioExtra) {
        this.totalHorarioExtra = totalHorarioExtra;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    public LocalTime getSaidaIntervalo() {
        return saidaIntervalo;
    }

    public void setSaidaIntervalo(LocalTime saidaIntervalo) {
        this.saidaIntervalo = saidaIntervalo;
    }

    public LocalTime getRetornoIntervalo() {
        return retornoIntervalo;
    }

    public void setRetornoIntervalo(LocalTime retornoIntervalo) {
        this.retornoIntervalo = retornoIntervalo;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }


}
