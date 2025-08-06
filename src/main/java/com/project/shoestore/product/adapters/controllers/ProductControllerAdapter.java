package com.project.shoestore.product.adapters.controllers;

import com.project.shoestore.product.adapters.mappers.ProductControllerMapper;
import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.usecases.CreateProductService;
import com.project.shoestore.product.domain.usecases.DeleteProductService;
import com.project.shoestore.product.domain.usecases.FindProductService;
import com.project.shoestore.product.domain.usecases.UpdateProductService;
import com.project.shoestore.product.infrastructure.dtos.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductControllerAdapter extends ControllerAdapter<Product, ProductDto, String> {
  private final UpdateProductService updateService;

  public ProductControllerAdapter(
    CreateProductService createService,
    UpdateProductService updateService,
    FindProductService findService,
    DeleteProductService deleteService,
    ProductControllerMapper mapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
    this.updateService = updateService;
  }

  public ProductDto addStock(String productId, Integer quantity) {
    Product product = updateService.addStock(productId, quantity);
    return mapper.toDto(product);
  }
}
