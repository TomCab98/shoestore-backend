package com.project.shoestore.order.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.order.adapters.mappers.OrderControllerMapper;
import com.project.shoestore.order.adapters.mappers.OrderDetailControllerMapper;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.domain.usecases.CreateOrderService;
import com.project.shoestore.order.domain.usecases.DeleteOrderService;
import com.project.shoestore.order.domain.usecases.FindOrderService;
import com.project.shoestore.order.domain.usecases.UpdateOrderService;
import com.project.shoestore.order.infrastructure.dtos.OrderDetailDto;
import com.project.shoestore.order.infrastructure.dtos.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderControllerAdapter extends ControllerAdapter<Order, OrderDto, String> {
  private final OrderDetailControllerMapper orderDetailMapper;

  public OrderControllerAdapter(
    CreateOrderService createService,
    UpdateOrderService updateService,
    FindOrderService findService,
    DeleteOrderService deleteService,
    OrderControllerMapper mapper,
    OrderDetailControllerMapper orderDetailMapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
    this.orderDetailMapper = orderDetailMapper;
  }

  @Override
  public OrderDto create(OrderDto dto) {
    List<OrderDetail> details = new ArrayList<>();

    for (OrderDetailDto detailDto: dto.details()) {
      OrderDetail detail = orderDetailMapper.toDomain(detailDto);
      details.add(detail);
    }

    Order order = mapper.toDomain(dto);
    order.setDetails(details);
    Order created = createService.create(order);
    return mapper.toDto(created);
  }
}
