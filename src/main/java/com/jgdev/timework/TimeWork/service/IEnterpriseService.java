package com.jgdev.timework.TimeWork.service;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.domain.Funcionario;

import java.util.List;

public interface IEnterpriseService {

    public Enterprise saveEnterprise(Enterprise enterprise);
    public List<Enterprise> getAllEnterprise();
    public Enterprise getEnterpriseById(Integer enterpriseId);
    public Enterprise updateEnterprise(Enterprise enterprise) ;
}
