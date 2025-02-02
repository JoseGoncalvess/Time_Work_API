package com.jgdev.timework.TimeWork;

import com.jgdev.timework.TimeWork.domain.Enterprise;
import com.jgdev.timework.TimeWork.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class InitApplicationSource implements ApplicationRunner {
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Enterprise redeCaza = new Enterprise("Rede Caza","11.111.111/0001-11","email@gmail.com","78799199999");
        enterpriseRepository.save(redeCaza);

    }
}
