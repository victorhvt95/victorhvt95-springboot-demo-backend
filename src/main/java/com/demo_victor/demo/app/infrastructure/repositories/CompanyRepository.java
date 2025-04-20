package com.demo_victor.demo.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo_victor.demo.app.infrastructure.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

}
