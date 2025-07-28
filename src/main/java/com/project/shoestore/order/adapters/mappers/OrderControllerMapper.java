package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.infrastructure.dtos.OrderDto;
import com.project.shoestore.provider.domain.models.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderControllerMapper extends ControllerMapper<Order, OrderDto> {

  @Override
  @Mapping(target = "provider", ignore = true)
  Order toDomain(OrderDto dto);

  @Mapping(target = "id", source = "dto.id")
  @Mapping(target = "date", source = "dto.date")
  @Mapping(target = "total", source = "dto.total")
  @Mapping(target = "provider", source = "provider")
  @Mapping(target = "details", ignore = true)
  Order toDomain(OrderDto dto, Provider provider);

  @Override
  @Mapping(target = "provider", source = "order.provider.name")
  OrderDto toDto(Order order);
}
