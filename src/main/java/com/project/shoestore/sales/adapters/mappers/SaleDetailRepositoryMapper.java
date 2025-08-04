package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.sales.domain.models.SaleDetail;
import com.project.shoestore.sales.infrastructure.repositories.entities.SaleDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleDetailRepositoryMapper extends RepositoryMapper<SaleDetail, SaleDetailEntity> {

  @Override
  @Mapping(target = "sale", ignore = true)
  @Mapping(target = "product", ignore = true)
  @Mapping(target = "id", ignore = true)
  SaleDetailEntity toEntity(SaleDetail order);
}
