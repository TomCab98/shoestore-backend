package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderEntity;
import com.project.shoestore.product.adapters.mappers.ProductRepositoryMapper;
import com.project.shoestore.provider.adapters.mappers.ProviderRepositoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
  componentModel = "spring",
  uses = {
    ProviderRepositoryMapper.class,
    OrderDetailRepositoryMapper.class,
    ProductRepositoryMapper.class
  }
)
public interface OrderRepositoryMapper extends RepositoryMapper<Order, OrderEntity> {

  @Override
  @Mapping(target = "details", ignore = true)
  OrderEntity toEntity(Order order);
}
