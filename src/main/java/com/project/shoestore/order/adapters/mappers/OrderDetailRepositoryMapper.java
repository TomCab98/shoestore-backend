package com.project.shoestore.order.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.order.domain.models.OrderDetail;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
  componentModel = "spring",
  uses = { OrderRepositoryMapper.class }
)
public interface OrderDetailRepositoryMapper extends RepositoryMapper<OrderDetail, OrderDetailEntity> {}
