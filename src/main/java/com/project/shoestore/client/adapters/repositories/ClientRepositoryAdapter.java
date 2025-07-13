package com.project.shoestore.client.adapters.repositories;

import com.project.shoestore.client.adapters.mappers.ClientRepositoryMapper;
import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.client.domain.ports.IClientRepositoryPort;
import com.project.shoestore.client.infrastructure.repositories.ClientRepository;
import com.project.shoestore.client.infrastructure.repositories.entities.ClientEntity;
import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryAdapter extends RepositoryAdapter<Client, ClientEntity, String> implements IClientRepositoryPort {
  public ClientRepositoryAdapter(ClientRepository repository, ClientRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
