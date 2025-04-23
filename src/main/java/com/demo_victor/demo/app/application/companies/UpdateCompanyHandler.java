package com.demo_victor.demo.app.application.companies;

import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.shared.mediator.simple_mediator.Handler;

import jakarta.persistence.EntityNotFoundException;

public class UpdateCompanyHandler implements Handler<UpdateCompany, Company> {

    private CompanyContract repository;

    public UpdateCompanyHandler(CompanyContract repository) {
        this.repository = repository;
    }

    @Override
    public Company handle(UpdateCompany request) {
        Company company = this.repository.getById(request.id());
        if (company == null) {
            throw new EntityNotFoundException("Company with ID " + request.id() + " Not found");
        }
        company.setName(request.name());
        company.setAddress(request.address());
        company.setPhone(request.phone());
        company.setEmail(request.email());
        return this.repository.save(company);
    }

}
