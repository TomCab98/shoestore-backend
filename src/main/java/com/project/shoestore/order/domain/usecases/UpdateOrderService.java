package com.project.shoestore.order.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.ports.IOrderRepositoryPort;

public class UpdateOrderService extends UpdateService<Order, String> {
  public UpdateOrderService(IOrderRepositoryPort repository) {
    super(repository);
  }
}
