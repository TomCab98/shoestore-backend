package com.project.shoestore.product.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.product.adapters.controllers.BrandControllerAdapter;
import com.project.shoestore.product.infrastructure.dtos.BrandDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@Tag(name = "Brand", description = "Endpoints for brand management")
public class BrandController extends CoreController<BrandDto, String> {
  public BrandController(BrandControllerAdapter adapter) { super(adapter); }

}
