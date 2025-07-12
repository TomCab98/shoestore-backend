package com.project.shoestore.provider.infrastructure.controllers;

import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.provider.adapters.controllers.ProviderControllerAdapter;
import com.project.shoestore.provider.infrastructure.dtos.ProviderDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController extends CoreController<ProviderDto, String> {
  public ProviderController(ProviderControllerAdapter adapter) {
    super(adapter);
  }
}
