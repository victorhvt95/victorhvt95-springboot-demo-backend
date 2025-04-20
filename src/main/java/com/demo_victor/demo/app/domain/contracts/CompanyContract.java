package com.demo_victor.demo.app.domain.contracts;

import java.util.List;

import com.demo_victor.demo.app.domain.entities.Company;

public interface CompanyContract {

    public List<Company> getAll();

    public Company getById(Long companyId);

    public Company save(Company company);
}
