package com.project.shoestore.product.infrastructure.controllers;

import com.project.shoestore.product.adapters.controllers.ProductControllerAdapter;
import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.product.infrastructure.dtos.AddStockRequest;
import com.project.shoestore.product.infrastructure.dtos.ProductDto;
import com.project.shoestore.sales.infrastructure.dtos.RefundDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController extends CoreController<ProductDto, String> {
  private final ProductControllerAdapter adapter;

  public ProductController(ProductControllerAdapter adapter) {
    super(adapter);
    this.adapter = adapter;
  }

  @PutMapping("/add-stock/{id}")
  public ResponseEntity<?> addProductStock(
    @PathVariable String id,
    @RequestBody AddStockRequest request
  ) {

    ProductDto updated = adapter.addStock(id, request.quantity());

    Map<String, Object> response = new LinkedHashMap<>();
    response.put("message", "Stock updated correctly");
    response.put("product", updated);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
