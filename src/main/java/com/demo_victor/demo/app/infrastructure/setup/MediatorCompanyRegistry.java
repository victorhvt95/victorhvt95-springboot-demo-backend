package com.demo_victor.demo.app.infrastructure.setup;

import com.demo_victor.demo.app.application.companies.CreateCompany;
import com.demo_victor.demo.app.application.companies.CreateCompanyHandler;
import com.demo_victor.demo.app.application.companies.DisableCompany;
import com.demo_victor.demo.app.application.companies.DisableCompanyHandler;
import com.demo_victor.demo.app.application.companies.EnableCompany;
import com.demo_victor.demo.app.application.companies.EnableCompanyHandler;
import com.demo_victor.demo.app.application.companies.GetCompany;
import com.demo_victor.demo.app.application.companies.GetCompanyHandler;
import com.demo_victor.demo.app.application.companies.GetListCompany;
import com.demo_victor.demo.app.application.companies.GetListCompanyHandler;
import com.demo_victor.demo.app.application.companies.UpdateCompany;
import com.demo_victor.demo.app.application.companies.UpdateCompanyHandler;
import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.shared.mediator.simple_mediator.SimpleMediator;

public class MediatorCompanyRegistry {

    public static void register(SimpleMediator mediator, CompanyContract companyContract) {
        mediator.registerHandler(GetListCompany.class, new GetListCompanyHandler(companyContract));
        mediator.registerHandler(CreateCompany.class, new CreateCompanyHandler(companyContract));
        mediator.registerHandler(EnableCompany.class, new EnableCompanyHandler(companyContract));
        mediator.registerHandler(DisableCompany.class, new DisableCompanyHandler(companyContract));
        mediator.registerHandler(UpdateCompany.class, new UpdateCompanyHandler(companyContract));
        mediator.registerHandler(GetCompany.class, new GetCompanyHandler(companyContract));
    }
}
