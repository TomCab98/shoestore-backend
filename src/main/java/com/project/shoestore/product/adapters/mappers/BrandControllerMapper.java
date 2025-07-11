package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.product.domain.models.Brand;
import com.project.shoestore.product.infrastructure.dtos.BrandDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandControllerMapper extends ControllerMapper<Brand, BrandDto> {}
