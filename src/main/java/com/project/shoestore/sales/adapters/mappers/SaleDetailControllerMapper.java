package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.sales.domain.models.SaleDetail;
import com.project.shoestore.sales.infrastructure.dtos.SaleDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleDetailControllerMapper extends ControllerMapper<SaleDetail, SaleDetailDto> {

  @Override
  @Mapping(target = "product", source = "order.product.name")
  SaleDetailDto toDto(SaleDetail order);

  default Product mapProduct(String id) {
    return new Product(id);
  }
}
