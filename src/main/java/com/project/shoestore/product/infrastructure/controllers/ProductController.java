package com.project.shoestore.product.infrastructure.controllers;

import com.project.shoestore.product.adapters.controllers.ProductControllerAdapter;
import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.product.infrastructure.dtos.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends CoreController<ProductDto, String> {
  public ProductController(ProductControllerAdapter adapter) {
    super(adapter);
  }
}
