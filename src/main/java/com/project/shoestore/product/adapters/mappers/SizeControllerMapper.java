package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.product.domain.models.Size;
import com.project.shoestore.product.infrastructure.dtos.SizeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SizeControllerMapper extends ControllerMapper<Size, SizeDto> {}
