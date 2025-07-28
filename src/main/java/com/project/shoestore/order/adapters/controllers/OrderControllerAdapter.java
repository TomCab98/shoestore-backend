package com.project.shoestore.order.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
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
import com.project.shoestore.product.adapters.repositories.ProductRepositoryAdapter;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.provider.adapters.repositories.ProviderRepositoryAdapter;
import com.project.shoestore.provider.domain.models.Provider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderControllerAdapter extends ControllerAdapter<Order, OrderDto, String> {
  private final OrderControllerMapper mapper;
  private final CreateOrderService createService;
  private final ProviderRepositoryAdapter providerRepository;
  private final ProductRepositoryAdapter productRepository;
  private final OrderDetailControllerMapper orderDetailMapper;

  public OrderControllerAdapter(
    CreateOrderService createService,
    UpdateOrderService updateService,
    FindOrderService findService,
    DeleteOrderService deleteService,
    OrderControllerMapper mapper,
    ProviderRepositoryAdapter providerRepository,
    ProductRepositoryAdapter productRepository,
    OrderDetailControllerMapper orderDetailMapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
    this.createService = createService;
    this.mapper = mapper;
    this.providerRepository = providerRepository;
    this.productRepository = productRepository;
    this.orderDetailMapper = orderDetailMapper;
  }

  @Override
  public OrderDto create(OrderDto dto) {
    Optional<Provider> provider = providerRepository.findById(dto.provider());
    if (provider.isEmpty()) {
      throw new NotFoundException("not found provider");
    }

    List<OrderDetail> details = new ArrayList<>();

    for (OrderDetailDto detailDto: dto.details()) {
      Optional<Product> product = productRepository.findById(detailDto.product());
      if (product.isEmpty()) {
        throw new NotFoundException("not found product " + detailDto.product());
      }

      OrderDetail detail = orderDetailMapper.toDomain(detailDto, product.get());
      details.add(detail);
    }

    Order order = mapper.toDomain(dto, provider.get());
    order.setDetails(details);
    Order created = createService.create(order);
    return mapper.toDto(created);
  }
}
