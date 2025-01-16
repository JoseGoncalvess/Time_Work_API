package com.jgdev.timework.TimeWork.service;

import com.jgdev.timework.TimeWork.domain.Funcionario;

import java.util.List;

public interface IFuncionarioInterface {
    public Funcionario saveFuncionario(Funcionario funcionario);
    public List<Funcionario> getAllFuncionarios();
    public Funcionario getFuncionarioById(Integer funcionarioId);
    public Funcionario getFuncionarioByMatricula(String matricula) ;
     String patchPasswordFuncionario(Integer funcionarioId, String newPassword);
    public Funcionario updateFuncionario(Funcionario funcionario) ;
}
