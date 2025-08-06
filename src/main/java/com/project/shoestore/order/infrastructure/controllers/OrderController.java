package com.project.shoestore.order.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.order.adapters.controllers.OrderControllerAdapter;
import com.project.shoestore.order.infrastructure.dtos.OrderDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Tag(name = "Order", description = "Endpoints for order management")
public class OrderController extends CoreController<OrderDto, String> {
  public OrderController(OrderControllerAdapter adapter) {
    super(adapter);
  }
}
