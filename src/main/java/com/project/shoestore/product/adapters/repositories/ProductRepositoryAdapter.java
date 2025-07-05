package com.project.shoestore.product.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.product.adapters.mappers.ProductRepositoryMapper;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;
import com.project.shoestore.product.infrastructure.repositories.ProductRepository;
import com.project.shoestore.product.infrastructure.repositories.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryAdapter extends RepositoryAdapter<Product, ProductEntity, String> implements IProductRepositoryPort {
  public ProductRepositoryAdapter(ProductRepository repository, ProductRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
