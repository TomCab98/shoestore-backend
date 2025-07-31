package com.project.shoestore.order.infrastructure.config;

import com.project.shoestore.order.adapters.repositories.OrderRepositoryAdapter;
import com.project.shoestore.order.domain.usecases.CreateOrderService;
import com.project.shoestore.order.domain.usecases.DeleteOrderService;
import com.project.shoestore.order.domain.usecases.FindOrderService;
import com.project.shoestore.order.domain.usecases.UpdateOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeansConfig {
  @Bean
  public CreateOrderService createOrderService(OrderRepositoryAdapter repository) {
    return new CreateOrderService(repository);
  }

  @Bean
  public UpdateOrderService updateOrderService(OrderRepositoryAdapter repository) {
    return new UpdateOrderService(repository);
  }

  @Bean
  public DeleteOrderService deleteOrderService(OrderRepositoryAdapter repository, FindOrderService findOrderService) {
    return new DeleteOrderService(repository, findOrderService);
  }

  @Bean
  public FindOrderService findOrderService(OrderRepositoryAdapter repository) {
    return new FindOrderService(repository);
  }
}
