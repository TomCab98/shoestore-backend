package com.project.shoestore.client.infrastructure.controllers;

import com.project.shoestore.client.adapters.controllers.ClientControllerAdapter;
import com.project.shoestore.client.infrastructure.dtos.ClientDto;
import com.project.shoestore.core.infrastructure.controllers.CoreController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Tag(name = "Client", description = "Endpoints for client management")
public class ClientController extends CoreController<ClientDto, String> {
  public ClientController(ClientControllerAdapter adapter) {
    super(adapter);
  }
}
