package com.project.shoestore.product.domain.ports;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.product.domain.models.Product;

public interface IProductRepositoryPort extends IRepositoryPort<Product, String> {}
