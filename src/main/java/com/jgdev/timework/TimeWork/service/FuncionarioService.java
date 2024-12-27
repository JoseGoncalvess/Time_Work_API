package com.jgdev.timework.TimeWork.service;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.repository.FuncioanarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService  {
    @Autowired
    FuncioanarioRepository funcioanarioRepository;

    public Funcionario saveFuncionario(Funcionario funcionario){
               return   funcioanarioRepository.save(funcionario);
    }
}
