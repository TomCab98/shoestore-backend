package com.project.shoestore.order.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.ports.IOrderRepositoryPort;

public class DeleteOrderService extends DeleteService<Order, String> {
  public DeleteOrderService(IOrderRepositoryPort repository, FindOrderService findService) {
    super(repository, findService);
  }
}
