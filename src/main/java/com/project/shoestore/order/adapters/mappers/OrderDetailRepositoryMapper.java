package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderDetailEntity;
import com.project.shoestore.product.adapters.mappers.ProductRepositoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDetailRepositoryMapper extends RepositoryMapper<OrderDetail, OrderDetailEntity> {

  @Override
  @Mapping(target = "order", ignore = true)
  @Mapping(target = "product", ignore = true)
  @Mapping(target = "id", ignore = true)
  OrderDetailEntity toEntity(OrderDetail order);
}
