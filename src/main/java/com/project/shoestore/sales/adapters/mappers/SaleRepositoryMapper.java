package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.infrastructure.repositories.entities.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleRepositoryMapper extends RepositoryMapper<Sale, SaleEntity> {

  @Override
  @Mapping(target = "client", ignore = true)
  @Mapping(target = "employee", ignore = true)
  @Mapping(target = "details", ignore = true)
  SaleEntity toEntity(Sale order);

  @Override
  @Mapping(target = "employee.roles", ignore = true)
  Sale toDomain(SaleEntity entity);
}
