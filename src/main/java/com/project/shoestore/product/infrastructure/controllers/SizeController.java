package com.project.shoestore.product.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.product.adapters.controllers.SizeControllerAdapter;
import com.project.shoestore.product.infrastructure.dtos.SizeDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/size")
public class SizeController extends CoreController<SizeDto, Integer> {
  public SizeController(SizeControllerAdapter adapter) { super(adapter); }
}
