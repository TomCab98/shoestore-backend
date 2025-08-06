package com.project.shoestore.sales.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.sales.adapters.controllers.SaleControllerAdapter;
import com.project.shoestore.sales.infrastructure.dtos.RefundDto;
import com.project.shoestore.sales.infrastructure.dtos.SaleDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "Endpoints for sales management")
public class SaleController extends CoreController<SaleDto, String> {
  private final SaleControllerAdapter adapter;

  public SaleController(SaleControllerAdapter adapter) {
    super(adapter);
    this.adapter = adapter;
  }

  @PostMapping("/refund")
  public ResponseEntity<Void> refundSale(@RequestBody RefundDto dto) {
    adapter.refund(dto);
    return ResponseEntity.noContent().build();
  }
}
