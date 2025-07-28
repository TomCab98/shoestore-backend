package com.project.shoestore.order.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.order.adapters.mappers.OrderDetailRepositoryMapper;
import com.project.shoestore.order.adapters.mappers.OrderRepositoryMapper;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.domain.ports.IOrderRepositoryPort;
import com.project.shoestore.order.infrastructure.repositories.OrderRepository;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderDetailEntity;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderDetailId;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryAdapter extends RepositoryAdapter<Order, OrderEntity, String> implements IOrderRepositoryPort {
  private final OrderRepositoryMapper mapper;
  private final OrderRepository repository;
  private final OrderDetailRepositoryMapper detailsMapper;

  public OrderRepositoryAdapter(
    OrderRepository repository,
    OrderRepositoryMapper mapper,
    OrderDetailRepositoryMapper detailsMapper
  ) {
    super(repository, mapper);
    this.mapper = mapper;
    this.repository = repository;
    this.detailsMapper = detailsMapper;
  }

  @Override
  public Order create(Order order) {
    OrderEntity entity = mapper.toEntity(order);

    List<OrderDetailEntity> detailsEntity = new ArrayList<>();

    for (OrderDetail detail: order.getDetails()) {
      OrderDetailEntity detailEntity = detailsMapper.toEntity(detail);

      OrderDetailId id = new OrderDetailId(detailEntity.getProduct().getId());
      detailEntity.setId(id);

      entity.addDetails(detailEntity);
    }

    OrderEntity created = repository.save(entity);
    return mapper.toDomain(created);
  }
}
