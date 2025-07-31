package com.project.shoestore.order.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.ports.IOrderRepositoryPort;

public class FindOrderService extends FindService<Order, String> {
  public FindOrderService(IOrderRepositoryPort repository) {
    super(repository);
  }
}
