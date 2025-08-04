package com.project.shoestore.sales.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.sales.adapters.mappers.SaleControllerMapper;
import com.project.shoestore.sales.adapters.mappers.SaleDetailControllerMapper;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.models.SaleDetail;
import com.project.shoestore.sales.domain.usecases.CreateSaleService;
import com.project.shoestore.sales.domain.usecases.DeleteSaleService;
import com.project.shoestore.sales.domain.usecases.FindSaleService;
import com.project.shoestore.sales.domain.usecases.UpdateSaleService;
import com.project.shoestore.sales.infrastructure.dtos.SaleDetailDto;
import com.project.shoestore.sales.infrastructure.dtos.SaleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleControllerAdapter extends ControllerAdapter<Sale, SaleDto, String> {
  private final SaleDetailControllerMapper saleDetailMapper;

  public SaleControllerAdapter(
    CreateSaleService createService,
    UpdateSaleService updateService,
    FindSaleService findService,
    DeleteSaleService deleteService,
    SaleControllerMapper mapper,
    SaleDetailControllerMapper saleDetailMapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
    this.saleDetailMapper = saleDetailMapper;
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
}
