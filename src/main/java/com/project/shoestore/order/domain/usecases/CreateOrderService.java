package com.project.shoestore.order.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.ports.IOrderRepositoryPort;

public class CreateOrderService extends CreateService<Order, String> {
  public CreateOrderService(IOrderRepositoryPort repository) {
    super(repository);
  }
}
