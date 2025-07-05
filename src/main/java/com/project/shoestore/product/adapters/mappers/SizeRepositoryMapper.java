package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.product.domain.models.Size;
import com.project.shoestore.product.infrastructure.repositories.entities.SizeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SizeRepositoryMapper extends RepositoryMapper<Size, SizeEntity> {}
