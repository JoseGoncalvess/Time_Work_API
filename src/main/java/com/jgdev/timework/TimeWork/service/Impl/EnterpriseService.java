package com.jgdev.timework.TimeWork.service.Impl;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.exception.BusinessException;
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

        if (enterprise.getCnpj().isEmpty() || enterprise.getEmail().isEmpty()){
            throw  new BusinessException("Verifique os Dados da Empresa");
        }

        return enterpriseRepository.save(enterprise);
    }

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Enterprise getEnterpriseById(Integer enterpriseId) {
        if (enterpriseId <= 0){
            throw  new BusinessException("Id Invalido para Consulta");
        }
        return enterpriseRepository.findById(enterpriseId).get();
    }

    @Override
    public Enterprise getEnterpriseByCnpj(String enterpriseCnpj) {
        if (enterpriseCnpj.isEmpty()){
            throw  new BusinessException("Id CNPJ esta vazio ou incorreto");
        }
        return enterpriseRepository.findEnterpriseByCnpj(enterpriseCnpj);
    }
    @Override
    public Enterprise getEnterpriseByEmail(String enterpriseEmail) {
        if (enterpriseEmail.isEmpty()){
            throw  new BusinessException("E-MAIL está vazio ou incorreto");
        }
        return enterpriseRepository.findEnterpriseByEmail(enterpriseEmail);
    }

    @Override
    public Enterprise updateEnterprise(Enterprise UpdateEnterprise) {

        if (UpdateEnterprise == null) {
            throw  new BusinessException("Verifique as finomações da empresa");
        } else if (UpdateEnterprise.getPassword().isEmpty()) {
            throw  new BusinessException("Password Incorreto, Verifique o NovoPassword");
        }

        return enterpriseRepository.save(UpdateEnterprise);
    }


}
