package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.domain.usecases.AbstractCrudService;
import com.project.shoestore.product.domain.models.Size;
import com.project.shoestore.product.domain.ports.ISizeRepositoryPort;

public class CrudSizeService extends AbstractCrudService<Size, Integer> {
  private final ISizeRepositoryPort repository;

  public CrudSizeService(ISizeRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public IRepositoryPort<Size, Integer> getRepository() {
    return repository;
  }
}
