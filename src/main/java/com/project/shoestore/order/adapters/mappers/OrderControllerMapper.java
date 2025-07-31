package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.infrastructure.dtos.OrderDto;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.provider.domain.models.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
  componentModel = "spring",
  uses = { OrderDetailControllerMapper.class }
)
public interface OrderControllerMapper extends ControllerMapper<Order, OrderDto> {

  @Override
  @Mapping(target = "details", ignore = true)
  Order toDomain(OrderDto dto);

  @Override
  @Mapping(target = "provider", source = "order.provider.name")
  OrderDto toDto(Order order);

  default Provider mapProvider(String id) {
    return new Provider(id);
  }
}
