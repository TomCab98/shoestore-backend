package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.infrastructure.dtos.OrderDetailDto;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.provider.domain.models.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDetailControllerMapper extends ControllerMapper<OrderDetail, OrderDetailDto> {

  @Override
  @Mapping(target = "product", source = "order.product.name")
  OrderDetailDto toDto(OrderDetail order);

  default Product mapProduct(String id) {
    return new Product(id);
  }
}
