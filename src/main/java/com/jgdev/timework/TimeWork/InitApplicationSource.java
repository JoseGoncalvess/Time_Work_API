package com.jgdev.timework.TimeWork;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.domain.Funcionario;
import com.jgdev.timework.TimeWork.repository.EnterpriseRepository;
import com.jgdev.timework.TimeWork.repository.FuncioanarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class InitApplicationSource implements ApplicationRunner {
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    private FuncioanarioRepository funcioanarioRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Enterprise redeCaza = new Enterprise("Rede Caza","11.111.111/0001-11","email@gmail.com","78799199999","0000");
        enterpriseRepository.save(redeCaza);
        Funcionario testeFuncionario = new Funcionario("Gonçalves", "1234","11","87991767676","emial@gmail.com","Aux. Contabíl",redeCaza,0);
    funcioanarioRepository.save(testeFuncionario);
    }
}
