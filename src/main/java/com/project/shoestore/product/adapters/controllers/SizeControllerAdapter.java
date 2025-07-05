package com.project.shoestore.product.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.CrudControllerAdapter;
import com.project.shoestore.product.adapters.mappers.SizeControllerMapper;
import com.project.shoestore.product.domain.models.Size;
import com.project.shoestore.product.domain.usecases.CrudSizeService;
import com.project.shoestore.product.infrastructure.dtos.SizeDto;
import org.springframework.stereotype.Component;

@Component
public class SizeControllerAdapter extends CrudControllerAdapter<Size, SizeDto, Integer> {
  public SizeControllerAdapter(CrudSizeService service, SizeControllerMapper mapper) {
    super(service, mapper);
  }
}
