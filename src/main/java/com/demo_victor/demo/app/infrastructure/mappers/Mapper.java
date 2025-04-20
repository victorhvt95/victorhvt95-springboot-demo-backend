package com.demo_victor.demo.app.infrastructure.mappers;

public interface Mapper<TDomain, TModel> {

    TDomain toDomain(TModel entity);

    TModel toModel(TDomain domain);
}
