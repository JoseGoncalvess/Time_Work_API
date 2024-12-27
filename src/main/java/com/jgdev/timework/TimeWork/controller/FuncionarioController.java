package com.jgdev.timework.TimeWork.controller;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario savedFuncionario(@RequestBody Funcionario  newfuncionario){
      return   funcionarioService.saveFuncionario(newfuncionario);
    }
}
