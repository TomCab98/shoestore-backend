package com.project.shoestore.product.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.CrudControllerAdapter;
import com.project.shoestore.product.adapters.mappers.CategoryControllerMapper;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.product.domain.usecases.CrudCategoryService;
import com.project.shoestore.product.infrastructure.dtos.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryControllerAdapter extends CrudControllerAdapter<Category, CategoryDto, String> {
  public CategoryControllerAdapter(CrudCategoryService service, CategoryControllerMapper mapper) {
    super(service, mapper);
  }
}
