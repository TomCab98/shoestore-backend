package com.project.shoestore.product.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.product.adapters.mappers.BrandRepositoryMapper;
import com.project.shoestore.product.domain.models.Brand;
import com.project.shoestore.product.domain.ports.IBrandRepositoryPort;
import com.project.shoestore.product.infrastructure.repositories.BrandRepository;
import com.project.shoestore.product.infrastructure.repositories.entities.BrandEntity;
import org.springframework.stereotype.Component;

@Component
public class BrandRepositoryAdapter extends RepositoryAdapter<Brand, BrandEntity, String> implements IBrandRepositoryPort {
  public BrandRepositoryAdapter(BrandRepository repository, BrandRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
