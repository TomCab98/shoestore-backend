package com.project.shoestore.product.infrastructure.controllers.interfaces;

import com.project.shoestore.product.infrastructure.dtos.AddStockRequest;
import com.project.shoestore.product.infrastructure.dtos.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Product", description = "Endpoints for product management")
public interface IProductController {

  @Operation(summary = "Add stock for existing product")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Stock updated correctly",
      content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = ProductDto.class),
        examples = @ExampleObject(
          name = "Returns a message indicating that the operation was completed successfully and also the updated product.",
          summary = "Product with updated stock",
          value = """
        {
          "message": "Stock updated correctly",
          "product": {
          "id": "{{UUID}}",
          "name": "Zapato deportivo",
          "price": 2500,
          "stock": 15,
          "category": "Deportivo",
          "brand": "Nike",
          "size": 42
          }

        }
        """
        )
      )
    ),
    @ApiResponse(responseCode = "404", description = "Product not found",
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(
          name = "The product was not found",
          summary = "Product not found response",
          value = """
        {
          "exception": "NotFoundException",
          "message": "Product with ID 123 not found",
          "status": 404,
          "path": "/product",
          "error": "Error description"
        }
        """
        )
      )
    )
  })
  ResponseEntity<?> addProductStock(
    @PathVariable String id,
    @RequestBody AddStockRequest request
  );
}
