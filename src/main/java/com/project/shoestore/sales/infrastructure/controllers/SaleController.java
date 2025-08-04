package com.project.shoestore.sales.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.sales.adapters.controllers.SaleControllerAdapter;
import com.project.shoestore.sales.infrastructure.dtos.SaleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController extends CoreController<SaleDto, String> {
  public SaleController(SaleControllerAdapter adapter) {
    super(adapter);
  }
}
