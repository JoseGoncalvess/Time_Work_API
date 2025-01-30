package com.jgdev.timework.TimeWork.repository;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
}
