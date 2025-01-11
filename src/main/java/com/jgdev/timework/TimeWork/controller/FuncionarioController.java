package com.jgdev.timework.TimeWork.controller;

import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario savedFuncionario(@RequestBody Funcionario newfuncionario) {
        return funcionarioService.saveFuncionario(newfuncionario);
    }

    @GetMapping
    public List<Funcionario> getAllFuncionario() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("matricula/{matricula}")
    public Funcionario getFuncionarioByMatricula(
            @PathVariable("matricula") String matricula) {
        return funcionarioService.getFuncionarioByMatricula(matricula);
    }
    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable("id") Integer idFuncionario) {
        return funcionarioService.getFuncionarioById(idFuncionario);
    }

    @PatchMapping()
    public String updatePassword(
            @RequestParam(value = "idFuncionario") Integer idFuncionario,
            @RequestParam(value = "newPassword") String newPassWord) {
        return funcionarioService.patchPasswordFuncionario(idFuncionario, newPassWord);
    }

    @PutMapping()
    public Funcionario updateFuncionario(@RequestBody Funcionario updateFuncionario) {
        return funcionarioService.updateFuncionario(updateFuncionario);
    }

}
