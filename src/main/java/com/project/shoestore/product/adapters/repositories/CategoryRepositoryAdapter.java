package com.project.shoestore.product.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.product.adapters.mappers.CategoryRepositoryMapper;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.product.domain.ports.ICategoryRepositoryPort;
import com.project.shoestore.product.infrastructure.repositories.CategoryRepository;
import com.project.shoestore.product.infrastructure.repositories.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryAdapter extends RepositoryAdapter<Category, CategoryEntity, String> implements ICategoryRepositoryPort {
  public CategoryRepositoryAdapter(CategoryRepository repository, CategoryRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
