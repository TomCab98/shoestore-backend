package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.product.infrastructure.dtos.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryControllerMapper extends ControllerMapper<Category, CategoryDto> {}
