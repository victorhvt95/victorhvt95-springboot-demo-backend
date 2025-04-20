package com.demo_victor.demo.app.infrastructure.setup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo_victor.demo.app.application.companies.CreateCompany;
import com.demo_victor.demo.app.application.companies.CreateCompanyHandler;
import com.demo_victor.demo.app.application.companies.GetListCompanyHandler;
import com.demo_victor.demo.app.application.companies.GetListCompany;
import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.shared.mediator.simple_mediator.SimpleMediator;

@Configuration
public class MediatorConfig {

    @Bean
    public SimpleMediator mediator(CompanyContract companyContract) {
        SimpleMediator mediator = new SimpleMediator();

        mediator.registerHandler(GetListCompany.class, new GetListCompanyHandler(companyContract));

        mediator.registerHandler(CreateCompany.class, new CreateCompanyHandler(companyContract));
        return mediator;
    }
}
