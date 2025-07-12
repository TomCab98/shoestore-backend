package com.project.shoestore.provider.domain.usecases;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.domain.ports.IProviderRepositoryPort;

public class UpdateProviderService extends UpdateService<Provider, String> {
  public UpdateProviderService(IProviderRepositoryPort repository) {
    super(repository);
  }
}
