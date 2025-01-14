package com.jgdev.timework.TimeWork.repository;

import com.jgdev.timework.TimeWork.domain.Ponto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface PontoRepository extends JpaRepository<Ponto, Integer> {

    @Query("UPDATE Ponto p SET p.entrada = :entrada WHERE p.id = :id")
    void registrarEntrada(@Param("id") Integer id, @Param("entrada") LocalTime entrada);

    @Modifying
    @Transactional
    @Query("UPDATE Ponto p SET p.saida = :saida WHERE p.id = :id")
    void registrarSaida(@Param("id") Integer id, @Param("saida") LocalTime saida);

    @Modifying
    @Transactional
    @Query("UPDATE Ponto p SET p.saidaIntervalo = :saidaIntervalo WHERE p.id = :id")
    void registrarSaidaIntervalo(@Param("id") Integer id,  @Param("saidaIntervalo")LocalTime saidaIntervalo);

    @Modifying
    @Transactional
    @Query("UPDATE Ponto p SET p.retornoIntervalo = :retornoIntervalo WHERE p.id = :id")
    void registrarRetornoIntervalo(@Param("id") Integer id, @Param("retornoIntervalo")LocalTime retornoIntervalo);

    @Modifying
    @Transactional
    @Query("UPDATE Ponto p SET p.totalPrimerioIntervalo = :totalPrimerioIntervalo WHERE p.id = :id")
    void registrartotalPrimerioIntervalo(@Param("id") Integer id, @Param("totalPrimerioIntervalo")LocalTime totalPrimerioIntervalo);

    @Modifying
    @Transactional
    @Query("UPDATE Ponto p SET p.totalSegundoIntervalo = :totalSegundoIntervalo WHERE p.id = :id")
    void registrartotalSegundoIntervalo(@Param("id") Integer id,@Param("totalSegundoIntervalo") LocalTime totalSegundoIntervalo);

    @Modifying
    @Transactional
    @Query("UPDATE Ponto p SET p.totalHorarioExtra = :totalHorarioExtra WHERE p.id = :id")
    void CalculartotalHorarioExtra(@Param("id") Integer id, @Param("totalHorarioExtra") LocalTime totalHorarioExtra);

    @Transactional
    @Query("SELECT p FROM Ponto p WHERE p.funcionario.id = :funcionarioId")
    List<Ponto> findAllPontoByIdFuncionario(@Param("funcionarioId") Integer idFuncionario);

    @Transactional
    @Query("SELECT p FROM Ponto p WHERE p.funcionario.id = :funcionarioId AND p.dataEntrada = :dataEntrada")
    Ponto findPontoDayByIdandDate(@Param("funcionarioId") Integer idFuncionario,@Param("dataEntrada") LocalDate dateDay);


}
