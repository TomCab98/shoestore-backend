package com.project.shoestore.employee.infrastructure.controllers.interfaces;

import com.project.shoestore.employee.infrastructure.dtos.AuthRequestDto;
import com.project.shoestore.employee.infrastructure.dtos.AuthResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Endpoints for login and authentication")
public interface IAuthController {

  @Operation(summary = "Login user")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Stock updated correctly",
      content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = AuthResponseDto.class),
        examples = @ExampleObject(
          name = "Return validation token for validated user.",
          summary = "Token for validated user",
          value = """
        {
          "email": "user@email.com",
          "message": "User validated",
          "jwt": "TOKEN",
          "status": true
        }
        """
        )
      )
    ),
    @ApiResponse(responseCode = "404", description = "Bad credentials",
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(
          name = "Bad credentials are introduced",
          summary = "Not found employee account",
          value = """
        {
          "exception": "BadCredentialsException",
          "message": "email or password is wrong",
          "status": 404,
          "path": "/auth",
          "error": "Error description"
        }
        """
        )
      )
    )
  })
  ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthRequestDto request);
}
