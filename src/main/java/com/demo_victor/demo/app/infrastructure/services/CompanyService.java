package com.demo_victor.demo.app.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo_victor.demo.app.infrastructure.models.CompanyModel;
import com.demo_victor.demo.app.infrastructure.repositories.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<CompanyModel> getAll() {
        return repository.findAll();
    }

    public CompanyModel save(CompanyModel companyModel) {
        return this.repository.save(companyModel);
    }

    public void delete(CompanyModel companyModel) {
        this.repository.deleteById(companyModel.getId());
    }
}
