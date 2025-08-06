package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.domain.models.Status;
import com.project.shoestore.sales.infrastructure.dtos.RefundDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RefundControllerMapper extends ControllerMapper<Refund, RefundDto> {

  @Override
  @Mapping(target = "status", expression = "java(refund.getStatus().name())")
  RefundDto toDto(Refund refund);

  default Status mapStatus(String ignoredStatus) {
    return Status.PENDING;
  }
}
