package com.project.shoestore.order.domain.ports;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.order.domain.models.Order;

public interface IOrderRepositoryPort extends IRepositoryPort<Order, String> {}
