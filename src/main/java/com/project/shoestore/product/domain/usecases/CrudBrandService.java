package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.domain.usecases.AbstractCrudService;
import com.project.shoestore.product.domain.models.Brand;
import com.project.shoestore.product.domain.ports.IBrandRepositoryPort;

public class CrudBrandService extends AbstractCrudService<Brand, String> {
  private final IBrandRepositoryPort repository;

  public CrudBrandService(IBrandRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public IRepositoryPort<Brand, String> getRepository() {
    return repository;
  }
}
