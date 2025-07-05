package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.product.domain.models.Category;
import com.project.shoestore.product.infrastructure.repositories.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryRepositoryMapper extends RepositoryMapper<Category, CategoryEntity> {}
