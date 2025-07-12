package com.project.shoestore.provider.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.provider.adapters.mappers.ProviderControllerMapper;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.domain.usecases.CreateProviderService;
import com.project.shoestore.provider.domain.usecases.DeleteProviderService;
import com.project.shoestore.provider.domain.usecases.FindProviderService;
import com.project.shoestore.provider.domain.usecases.UpdateProviderService;
import com.project.shoestore.provider.infrastructure.dtos.ProviderDto;
import org.springframework.stereotype.Component;

@Component
public class ProviderControllerAdapter extends ControllerAdapter<Provider, ProviderDto, String> {
  public ProviderControllerAdapter(
    CreateProviderService createService,
    UpdateProviderService updateService,
    FindProviderService findService,
    DeleteProviderService deleteService,
    ProviderControllerMapper mapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
  }
}
