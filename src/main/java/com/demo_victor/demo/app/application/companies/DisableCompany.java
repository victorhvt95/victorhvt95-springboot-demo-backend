package com.demo_victor.demo.app.application.companies;

import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.shared.mediator.simple_mediator.Request;

public record DisableCompany(
        Long companyId) implements Request<Company> {
}