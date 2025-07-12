package com.project.shoestore.provider.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.provider.adapters.mappers.ProviderRepositoryMapper;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.domain.ports.IProviderRepositoryPort;
import com.project.shoestore.provider.infrastructure.repositories.ProviderRepository;
import com.project.shoestore.provider.infrastructure.repositories.entities.ProviderEntity;
import org.springframework.stereotype.Component;

@Component
public class ProviderRepositoryAdapter extends RepositoryAdapter<Provider, ProviderEntity, String> implements IProviderRepositoryPort {
  public ProviderRepositoryAdapter(ProviderRepository repository, ProviderRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
