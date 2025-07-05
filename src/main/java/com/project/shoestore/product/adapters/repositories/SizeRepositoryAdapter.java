package com.project.shoestore.product.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.product.adapters.mappers.SizeRepositoryMapper;
import com.project.shoestore.product.domain.models.Size;
import com.project.shoestore.product.domain.ports.ISizeRepositoryPort;
import com.project.shoestore.product.infrastructure.repositories.SizeRepository;
import com.project.shoestore.product.infrastructure.repositories.entities.SizeEntity;
import org.springframework.stereotype.Component;

@Component
public class SizeRepositoryAdapter extends RepositoryAdapter<Size, SizeEntity, Integer> implements ISizeRepositoryPort {
  public SizeRepositoryAdapter(SizeRepository repository, SizeRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
