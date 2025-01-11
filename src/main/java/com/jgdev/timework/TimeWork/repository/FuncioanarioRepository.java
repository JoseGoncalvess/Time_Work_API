package com.jgdev.timework.TimeWork.repository;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface FuncioanarioRepository extends JpaRepository<Funcionario, Integer> {


    @Transactional
    @Query("SELECT p FROM Funcionario p WHERE p.matricula = :matricula")
    Funcionario findFuncionarioByMAtricula(@Param("matricula") String matricula);

    @Modifying
    @Transactional
    @Query("UPDATE Funcionario p SET p.password = :password WHERE p.id = :id")
    void updatePassword(@Param("id") Integer id, @Param("password") String newPassword);

    @Modifying
    @Transactional
    @Query("UPDATE Funcionario p SET p.password = :password, p.name = :name, p.status = :status  WHERE p.id = :id")
    Funcionario updateFunconario(@Param("status") int status,@Param("name") String name, @Param("id") Integer id, @Param("password") String Password);

}

