package com.demo_victor.demo.app.infrastructure.jpa_repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo_victor.demo.app.infrastructure.models.CompanyModel;

public interface CompanyJpaRepository extends JpaRepository<CompanyModel, Long> {

}
