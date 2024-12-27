package com.jgdev.timework.TimeWork.repository;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncioanarioRepository extends JpaRepository<Funcionario, Integer> {
}
