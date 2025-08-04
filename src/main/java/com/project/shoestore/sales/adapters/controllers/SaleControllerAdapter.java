package com.project.shoestore.sales.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.sales.adapters.mappers.RefundControllerMapper;
import com.project.shoestore.sales.adapters.mappers.SaleControllerMapper;
import com.project.shoestore.sales.adapters.mappers.SaleDetailControllerMapper;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.models.SaleDetail;
import com.project.shoestore.sales.domain.usecases.*;
import com.project.shoestore.sales.infrastructure.dtos.RefundDto;
import com.project.shoestore.sales.infrastructure.dtos.SaleDetailDto;
import com.project.shoestore.sales.infrastructure.dtos.SaleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleControllerAdapter extends ControllerAdapter<Sale, SaleDto, String> {
  private final SaleDetailControllerMapper saleDetailMapper;
  private final RefundControllerMapper refundMapper;
  private final RefundProductService refundProductService;

  public SaleControllerAdapter(
    CreateSaleService createService,
    UpdateSaleService updateService,
    FindSaleService findService,
    DeleteSaleService deleteService,
    SaleControllerMapper mapper,
    SaleDetailControllerMapper saleDetailMapper,
    RefundControllerMapper refundMapper,
    RefundProductService refundProductService
  ) {
    super(createService, updateService, findService, deleteService, mapper);
    this.saleDetailMapper = saleDetailMapper;
    this.refundMapper = refundMapper;
    this.refundProductService = refundProductService;
  }

  @Override
  public SaleDto create(SaleDto dto) {
    List<SaleDetail> details = new ArrayList<>();

    for (SaleDetailDto detailDto: dto.details()) {
      SaleDetail detail = saleDetailMapper.toDomain(detailDto);
      details.add(detail);
    }

    Sale sale = mapper.toDomain(dto);
    sale.setDetails(details);
    Sale created = createService.create(sale);
    return mapper.toDto(created);
  }

  public void refund(RefundDto dto) {
    Refund refund = refundMapper.toDomain(dto);
    refundProductService.refund(refund);
  }
}
