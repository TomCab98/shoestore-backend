package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.domain.usecases.AbstractCrudService;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.product.domain.ports.ICategoryRepositoryPort;

public class CrudCategoryService extends AbstractCrudService<Category, String> {
  private final ICategoryRepositoryPort repository;

  public CrudCategoryService(ICategoryRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public IRepositoryPort<Category, String> getRepository() {
    return repository;
  }
}
