package com.demo_victor.demo.app.application.companies;

import java.util.List;

import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.shared.mediator.simple_mediator.Handler;

public class GetListCompanyHandler implements Handler<GetListCompany, List<Company>> {

    private CompanyContract repository;

    public GetListCompanyHandler(CompanyContract repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> handle(GetListCompany request) {

        List<Company> listCompanies = this.repository.getAll();
        return listCompanies;
    }

}