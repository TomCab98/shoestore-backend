package com.project.shoestore.sales.infrastructure.controllers.interfaces;

import com.project.shoestore.product.infrastructure.dtos.ProductDto;
import com.project.shoestore.sales.infrastructure.dtos.RefundDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Sales", description = "Endpoints for sales management")
public interface ISaleController {

  @Operation(summary = "Refund a product in the list of sale details")
  @ApiResponses({
    @ApiResponse(responseCode = "204", description = "Success refund",
      content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = ProductDto.class),
        examples = @ExampleObject(
          name = "Return response code 204"
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
          "path": "/sales/refund",
          "error": "Error description"
        }
        """
        )
      )
    ),
    @ApiResponse(responseCode = "404", description = "Sale not found",
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(
          name = "The sale was not found",
          summary = "Sale not found response",
          value = """
        {
          "exception": "NotFoundException",
          "message": "Sale with ID 123 not found",
          "status": 404,
          "path": "/sales/refund",
          "error": "Error description"
        }
        """
        )
      )
    )
  })
  ResponseEntity<Void> refundSale(@RequestBody RefundDto dto);
}
