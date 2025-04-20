package com.demo_victor.demo.app.presentation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo_victor.demo.app.application.companies.CreateCompany;
import com.demo_victor.demo.app.application.companies.GetListCompany;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.app.infrastructure.models.CompanyModel;
import com.demo_victor.demo.app.infrastructure.repositories.CompanyRepository;
import com.demo_victor.demo.shared.mediator.simple_mediator.Mediator;
import com.demo_victor.demo.shared.mediator.simple_mediator.SimpleMediator;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Companies")
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final Mediator mediator;

    public CompanyController(SimpleMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("")
    public List<Company> getList() {
        return this.mediator.send(new GetListCompany());
        // return this.companyService.getAll();
    }

    @PostMapping("")
    public Company createCompany(@RequestBody CreateCompany company) {
        return this.mediator.send(company);
    }

}
