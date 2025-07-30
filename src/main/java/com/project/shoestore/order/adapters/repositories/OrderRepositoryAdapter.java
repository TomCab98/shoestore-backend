package com.project.shoestore.order.adapters.repositories;

import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.order.adapters.mappers.OrderDetailRepositoryMapper;
import com.project.shoestore.order.adapters.mappers.OrderRepositoryMapper;
import com.project.shoestore.order.domain.models.Order;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.domain.ports.IOrderRepositoryPort;
import com.project.shoestore.order.infrastructure.repositories.OrderRepository;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderDetailEntity;
import com.project.shoestore.order.infrastructure.repositories.ids.OrderDetailId;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderEntity;
import com.project.shoestore.product.infrastructure.repositories.ProductRepository;
import com.project.shoestore.product.infrastructure.repositories.entities.ProductEntity;
import com.project.shoestore.provider.infrastructure.repositories.ProviderRepository;
import com.project.shoestore.provider.infrastructure.repositories.entities.ProviderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderRepositoryAdapter extends RepositoryAdapter<Order, OrderEntity, String> implements IOrderRepositoryPort {
  private final OrderRepositoryMapper mapper;
  private final OrderRepository repository;
  private final OrderDetailRepositoryMapper detailsMapper;
  private final ProductRepository productRepository;
  private final ProviderRepository providerRepository;

  public OrderRepositoryAdapter(
    OrderRepository repository,
    OrderRepositoryMapper mapper,
    OrderDetailRepositoryMapper detailsMapper,
    ProductRepository productRepository,
    ProviderRepository providerRepository
  ) {
    super(repository, mapper);
    this.mapper = mapper;
    this.repository = repository;
    this.detailsMapper = detailsMapper;
    this.productRepository = productRepository;
    this.providerRepository = providerRepository;
  }

  @Override
  public Order create(Order order) {
    OrderEntity entity = mapper.toEntity(order);

    ProviderEntity provider = providerRepository.findById(order.getProvider().getId())
      .orElseThrow(() -> new NotFoundException("not found provider"));

    entity.setProvider(provider);

    for (OrderDetail detail: order.getDetails()) {
      OrderDetailEntity detailEntity = detailsMapper.toEntity(detail);

      ProductEntity product = productRepository.findById(detail.getProduct().getId())
        .orElseThrow(() -> new NotFoundException("not found product"));

      OrderDetailId id = new OrderDetailId(product.getId());

      detailEntity.setId(id);
      detailEntity.setProduct(product);

      entity.addDetails(detailEntity);
    }

    OrderEntity created = repository.save(entity);
    return mapper.toDomain(created);
  }
}
