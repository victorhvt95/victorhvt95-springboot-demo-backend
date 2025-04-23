package com.demo_victor.demo.app.application.companies;

import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.shared.mediator.simple_mediator.Handler;

import jakarta.persistence.EntityNotFoundException;

public class EnableCompanyHandler implements Handler<EnableCompany, Company> {

    private final CompanyContract repository;

    public EnableCompanyHandler(CompanyContract repository) {
        this.repository = repository;
    }

    @Override
    public Company handle(EnableCompany request) {
        Company company = this.repository.getById(request.companyId());
        if (company == null) {
            throw new EntityNotFoundException("Entity with ID " + request.companyId() + " Not found");
        }
        company.enable();
        return this.repository.save(company);
    }

}
