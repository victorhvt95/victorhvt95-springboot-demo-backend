package com.demo_victor.demo.app.infrastructure.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo_victor.demo.app.domain.contracts.CompanyContract;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.app.infrastructure.jpa_repositories.CompanyJpaRepository;
import com.demo_victor.demo.app.infrastructure.mappers.CompanyMapper;
import com.demo_victor.demo.app.infrastructure.models.CompanyModel;

@Service
public class CompanyRepository implements CompanyContract {
    private final CompanyJpaRepository repository;

    public CompanyRepository(CompanyJpaRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAll() {
        List<CompanyModel> listCompanyModel = repository.findAll();
        List<Company> listCompany = listCompanyModel
                .stream()
                .map(CompanyMapper::toDomain)
                .collect(Collectors.toList());
        return listCompany;
    }

    public Company save(Company company) {
        CompanyModel companyModel = CompanyMapper.toModel(company);
        companyModel = this.repository.save(companyModel);
        return CompanyMapper.toDomain(companyModel);
    }

    @Override
    public Company getById(Long companyId) {
        Company company = this.repository
                .findById(companyId)
                .map(CompanyMapper::toDomain)
                .orElseThrow();
        return company;
    }
}
