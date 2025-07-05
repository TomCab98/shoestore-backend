package com.project.shoestore.product.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.CrudControllerAdapter;
import com.project.shoestore.product.adapters.mappers.BrandControllerMapper;
import com.project.shoestore.product.domain.models.Brand;
import com.project.shoestore.product.domain.usecases.CrudBrandService;
import com.project.shoestore.product.infrastructure.dtos.BrandDto;
import org.springframework.stereotype.Component;

@Component
public class BrandControllerAdapter extends CrudControllerAdapter<Brand, BrandDto, String> {
  public BrandControllerAdapter(CrudBrandService service, BrandControllerMapper mapper) {
    super(service, mapper);
  }
}
