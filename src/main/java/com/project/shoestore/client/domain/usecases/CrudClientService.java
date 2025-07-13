package com.project.shoestore.client.domain.usecases;

import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.client.domain.ports.IClientRepositoryPort;
import com.project.shoestore.core.domain.usecases.AbstractCrudService;

public class CrudClientService extends AbstractCrudService<Client, String> {
  private final IClientRepositoryPort repository;

  public CrudClientService(IClientRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public IClientRepositoryPort getRepository() {
    return repository;
  }
}
