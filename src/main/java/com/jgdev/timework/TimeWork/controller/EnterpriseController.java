package com.jgdev.timework.TimeWork.controller;


import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.repository.EnterpriseRepository;
import com.jgdev.timework.TimeWork.service.Impl.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/enterprise")
public class EnterpriseController {

    @Autowired
   private EnterpriseService enterpriseService;

    @PostMapping
    public Enterprise savedFuncionario(@RequestBody Enterprise enterprise) {
        return enterpriseService.saveEnterprise(enterprise);
    }

    @GetMapping
    public List<Enterprise> getAllEnterprise() {
        return enterpriseService.getAllEnterprise();
    }

    @GetMapping("/{id}")
    public Enterprise getEnterpriseById(
            @PathVariable("id") Integer idEnterprise) {
        return enterpriseService.getEnterpriseById(idEnterprise);
    }
}
