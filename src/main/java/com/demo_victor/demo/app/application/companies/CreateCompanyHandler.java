package com.demo_victor.demo.app.application.companies;

import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.shared.mediator.simple_mediator.Handler;

public class CreateCompanyHandler implements Handler<CreateCompany, Company> {

    private CompanyContract repository;

    public CreateCompanyHandler(CompanyContract repository) {
        this.repository = repository;
    }

    @Override
    public Company handle(CreateCompany request) {
        Company company = new Company();
        company.setName(request.name());
        company.setAddress(request.address());
        company.setPhone(request.phone());
        company.setEmail(request.email());
        return this.repository.save(company);
    }

}
