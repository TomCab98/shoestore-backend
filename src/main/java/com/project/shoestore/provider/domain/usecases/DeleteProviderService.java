package com.project.shoestore.provider.domain.usecases;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.domain.ports.IProviderRepositoryPort;

public class DeleteProviderService extends DeleteService<Provider, String> {
  public DeleteProviderService(IProviderRepositoryPort repository, FindProviderService findService) {
    super(repository, findService);
  }
}
