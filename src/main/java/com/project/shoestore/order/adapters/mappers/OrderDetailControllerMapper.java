package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.infrastructure.dtos.OrderDetailDto;
import com.project.shoestore.product.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDetailControllerMapper extends ControllerMapper<OrderDetail, OrderDetailDto> {

  @Mapping(target = "product", source = "product")
  OrderDetail toDomain(OrderDetailDto dto, Product product);

  @Override
  @Mapping(target = "product", ignore = true)
  OrderDetail toDomain(OrderDetailDto orderDetailDto);

  @Override
  @Mapping(target = "product", source = "order.product.name")
  OrderDetailDto toDto(OrderDetail order);
}
