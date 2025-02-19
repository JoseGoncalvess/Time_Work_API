package com.jgdev.timework.TimeWork.service.Impl;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.exception.BusinessException;
import com.jgdev.timework.TimeWork.repository.FuncioanarioRepository;
import com.jgdev.timework.TimeWork.service.IFuncionarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements IFuncionarioInterface {
    @Autowired
    FuncioanarioRepository funcioanarioRepository;

    public Funcionario saveFuncionario(Funcionario funcionario)  {
        if (funcionario.getMatricula().isEmpty()  || funcionario.getEnterprise() == null) {
            throw  new BusinessException("Verifique as Infomações importantes do Funcionario");
        }
        
        return funcioanarioRepository.save(funcionario);
    }

    public List<Funcionario> getAllFuncionarios() {

        return funcioanarioRepository.findAll();
    }

    public Funcionario getFuncionarioById(Integer funcionarioId) {
        if (funcionarioId <= 0){
            throw  new BusinessException("Id Invalido para Consulta");
        }
        return funcioanarioRepository.findById(funcionarioId).get();
    }
    public Funcionario getFuncionarioByMatricula(String matricula) {
        if (matricula.isEmpty()){
            throw  new RuntimeException("Matricula Invalido para Consulta");
        }
        return funcioanarioRepository.findFuncionarioByMAtricula(matricula);
    }


    public String patchPasswordFuncionario(Integer funcionarioId, String newPassword) {

        if (funcionarioId == null || newPassword.isEmpty()){
            throw  new RuntimeException("Novas infomações do funcionario é  Invalido");
        }
        funcioanarioRepository.updatePassword(funcionarioId, newPassword);
        return "Password Atualiado com sucesso para " + newPassword;
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcioanarioRepository.updateFunconario(funcionario.getStatus(),
                funcionario.getName(), funcionario.getId(), funcionario.getPassword());
    }
}
