package com.project.shoestore.provider.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.domain.ports.IProviderRepositoryPort;

public class CreateProviderService extends CreateService<Provider, String> {
  public CreateProviderService(IProviderRepositoryPort repository) {
    super(repository);
  }
}
