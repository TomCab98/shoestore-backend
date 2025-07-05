package com.project.shoestore.product.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.product.adapters.controllers.CategoryControllerAdapter;
import com.project.shoestore.product.infrastructure.dtos.CategoryDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends CoreController<CategoryDto, String> {
  public CategoryController(CategoryControllerAdapter adapter) {
    super(adapter);
  }

}
