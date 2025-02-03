package com.jgdev.timework.TimeWork.repository;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.domain.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {

    @Transactional
    @Query("SELECT p FROM Enterprise p WHERE p.cnpj = :cnpj")
    Enterprise findEnterpriseByCnpj(@Param("cnpj") String cnpj);

    @Transactional
    @Query("SELECT p FROM Enterprise p WHERE p.email = :email")
    Enterprise findEnterpriseByEmail(@Param("email") String email);
}
