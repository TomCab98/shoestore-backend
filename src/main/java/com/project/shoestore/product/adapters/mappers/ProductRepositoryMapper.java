package com.project.shoestore.product.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.infrastructure.repositories.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRepositoryMapper extends RepositoryMapper<Product, ProductEntity> {}
