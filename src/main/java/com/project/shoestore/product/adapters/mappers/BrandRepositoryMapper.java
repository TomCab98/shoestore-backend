package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.product.domain.models.Brand;
import com.project.shoestore.product.infrastructure.repositories.entities.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandRepositoryMapper extends RepositoryMapper<Brand, BrandEntity> {}
