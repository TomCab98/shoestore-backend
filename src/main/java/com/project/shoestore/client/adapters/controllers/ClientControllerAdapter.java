package com.project.shoestore.client.adapters.controllers;

import com.project.shoestore.client.adapters.mappers.ClientControllerMapper;
import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.client.domain.usecases.CrudClientService;
import com.project.shoestore.client.infrastructure.dtos.ClientDto;
import com.project.shoestore.core.adapters.controllers.CrudControllerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ClientControllerAdapter extends CrudControllerAdapter<Client, ClientDto, String> {
  public ClientControllerAdapter(CrudClientService service, ClientControllerMapper mapper) {
    super(service, mapper);
  }
}
