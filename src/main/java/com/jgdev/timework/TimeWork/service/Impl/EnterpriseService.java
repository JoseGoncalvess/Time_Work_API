package com.jgdev.timework.TimeWork.service.Impl;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.repository.EnterpriseRepository;
import com.jgdev.timework.TimeWork.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Enterprise getEnterpriseById(Integer enterpriseId) {
        return enterpriseRepository.findById(enterpriseId).get();
    }

    @Override
    public Enterprise getEnterpriseByCnpj(String enterpriseCnpj) {
        return enterpriseRepository.findEnterpriseByCnpj(enterpriseCnpj);
    }
    @Override
    public Enterprise getEnterpriseByEmail(String enterpriseEmail) {
        return enterpriseRepository.findEnterpriseByEmail(enterpriseEmail);
    }

    @Override
    public Enterprise updateEnterprise(Enterprise UpdateEnterprise) {
        return enterpriseRepository.save(UpdateEnterprise);
    }


}
