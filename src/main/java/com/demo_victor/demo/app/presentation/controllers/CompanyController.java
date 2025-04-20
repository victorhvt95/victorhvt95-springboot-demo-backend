package com.demo_victor.demo.app.presentation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo_victor.demo.app.infrastructure.models.CompanyModel;
import com.demo_victor.demo.app.infrastructure.services.CompanyService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Companies")
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("")
    public List<CompanyModel> getList() {
        return this.companyService.getAll();
    }

    @PostMapping("")
    public CompanyModel createCompany(@RequestBody CompanyModel company) {
        return this.companyService.save(company);
    }

}
