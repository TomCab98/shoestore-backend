package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.infrastructure.dtos.RefundDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefundControllerMapper extends ControllerMapper<Refund, RefundDto> {}
