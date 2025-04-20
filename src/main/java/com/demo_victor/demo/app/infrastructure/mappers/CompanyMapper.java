package com.demo_victor.demo.app.infrastructure.mappers;

import com.demo_victor.demo.app.domain.entities.Company;
import com.demo_victor.demo.app.infrastructure.models.CompanyModel;

public final class CompanyMapper {

    private CompanyMapper() {
        // Constructor privado para evitar instancias
    }

    public static Company toDomain(CompanyModel model) {
        if (model == null) {
            return null;
        }

        Company entity = new Company();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setAddress(model.getAddress());
        entity.setPhone(model.getPhone());
        entity.setEmail(model.getEmail());
        entity.setIsEnabled(model.getIsEnabled());
        entity.setCreatedAt(model.getCreatedAt());
        entity.setUpdatedAt(model.getUpdatedAt());
        return entity;
    }

    public static CompanyModel toModel(Company entity) {
        if (entity == null) {
            return null;
        }

        CompanyModel model = new CompanyModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setAddress(entity.getAddress());
        model.setPhone(entity.getPhone());
        model.setEmail(entity.getEmail());
        model.setIsEnabled(entity.getIsEnabled());
        return model;
    }
}
