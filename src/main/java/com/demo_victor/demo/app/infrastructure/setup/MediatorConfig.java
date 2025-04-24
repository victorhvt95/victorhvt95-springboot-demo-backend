package com.demo_victor.demo.app.infrastructure.setup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.shared.mediator.simple_mediator.SimpleMediator;

@Configuration
public class MediatorConfig {

    @Bean
    public SimpleMediator mediator(CompanyContract companyContract) {
        SimpleMediator mediator = new SimpleMediator();
        MediatorCompanyRegistry.register(mediator, companyContract);
        return mediator;
    }
}
