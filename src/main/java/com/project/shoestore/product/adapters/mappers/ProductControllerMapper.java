package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.product.domain.models.Brand;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.models.Size;
import com.project.shoestore.product.infrastructure.dtos.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductControllerMapper extends ControllerMapper<Product, ProductDto> {

  default Category mapCategory(String category) {
    return new Category(category, null);
  }

  default Brand mapBrand(String brand) {
    return new Brand(brand, null);
  }

  default Size mapSize(int size) {
    return new Size(size);
  }

  default String mapCategory(Category category) {
    return category.getName();
  }

  default String mapBrand(Brand brand) {
    return brand.getName();
  }

  default int mapSize(Size size) {
    return size.getSize();
  }
}
