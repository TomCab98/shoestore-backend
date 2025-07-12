package com.project.shoestore.provider.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.domain.ports.IProviderRepositoryPort;

public class FindProviderService extends FindService<Provider, String> {
  public FindProviderService(IProviderRepositoryPort repository) {
    super(repository);
  }
}
