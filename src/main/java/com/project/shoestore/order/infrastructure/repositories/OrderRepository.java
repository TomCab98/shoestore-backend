package com.project.shoestore.order.infrastructure.repositories;

import com.project.shoestore.core.infrastructure.repositories.IRepository;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderEntity;

public interface OrderRepository extends IRepository<OrderEntity, String> {}
