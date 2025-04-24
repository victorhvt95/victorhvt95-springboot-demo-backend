package com.demo_victor.demo.app.presentation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo_victor.demo.app.application.companies.CreateCompany;
import com.demo_victor.demo.app.application.companies.DisableCompany;
import com.demo_victor.demo.app.application.companies.EnableCompany;
import com.demo_victor.demo.app.application.companies.GetCompany;
import com.demo_victor.demo.app.application.companies.GetListCompany;
import com.demo_victor.demo.app.application.companies.UpdateCompany;
import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.shared.mediator.simple_mediator.Mediator;
import com.demo_victor.demo.shared.mediator.simple_mediator.SimpleMediator;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    }

    @PostMapping("")
    public Company createCompany(@RequestBody CreateCompany company) {
        return this.mediator.send(company);
    }

    @PutMapping("/{companyId}")
    public Company updateCompany(@PathVariable String companyId,
            @RequestBody UpdateCompany updateCompany) {
        return this.mediator.send(updateCompany);
    }

    @PutMapping("/{companyId}/enable")
    public Company enableCompany(@PathVariable Long companyId) {
        return this.mediator.send(new EnableCompany(companyId));
    }

    @PutMapping("/{companyId}/disable")
    public Company disableCompany(@PathVariable Long companyId) {
        return this.mediator.send(new DisableCompany(companyId));
    }

    @GetMapping("/{companyId}")
    public Company getById(@PathVariable Long companyId) {
        return this.mediator.send(new GetCompany(companyId));
    }

}
