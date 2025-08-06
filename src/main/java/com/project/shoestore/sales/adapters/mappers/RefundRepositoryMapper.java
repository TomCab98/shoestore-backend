package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.domain.models.Status;
import com.project.shoestore.sales.infrastructure.repositories.entities.RefundEntity;
import com.project.shoestore.sales.infrastructure.repositories.entities.StatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RefundRepositoryMapper extends RepositoryMapper<Refund, RefundEntity> {

  @Override
  @Mapping(target = "detail", ignore = true)
  @Mapping(target = "status", ignore = true)
  RefundEntity toEntity(Refund model);

  @Override
  @Mapping(target = "product", source = "entity.detail.product.id")
  @Mapping(target = "sale", source = "entity.detail.sale.id")
  Refund toDomain(RefundEntity entity);

  default Status mapStatus(StatusEntity entity) {
    return Status.valueOf(entity.getName());
  }
}
