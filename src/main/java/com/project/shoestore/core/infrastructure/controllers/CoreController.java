package com.project.shoestore.core.infrastructure.controllers;

import com.project.shoestore.core.adapters.controllers.ports.ControllerAdapterPort;
import com.project.shoestore.core.domain.exceptions.IllegalArgumentException;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Generic REST controller that provides basic CRUD operations for any resource.
 * This class should be extended by specific controllers (e.g., UserController, ProductController).
 * It relies on a controller port (IControllerPort) that abstracts the application logic.
 *
 * @param <D>  The Data Transfer Object (DTO) used for external communication (API).
 * @param <ID> The type of the identifier (e.g., String, Long, UUID).
 */
@RequiredArgsConstructor
public class CoreController<D, ID> {
  protected final ControllerAdapterPort<D, ID> adapter;

  /**
   * Handles the creation of a new resource.
   *
   * @param dto The input DTO from the HTTP request body.
   * @return The created resource in DTO format.
   */
  @Operation(summary = "Create a new entity")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Entity created"),
    @ApiResponse(responseCode = "404", description = "Entity already exists",
      content = @Content(mediaType = "application/json", schema = @Schema(implementation = IllegalArgumentException.class),
        examples = @ExampleObject(
          value = """
            {
              "exception": "IllegalArgumentException",
              "message": "Entity already exists",
              "status": 404,
              "path": "/{{path}}",
              "error": "Error description"
            }
          """
        )
      )
    )
  })
  @PostMapping
  public ResponseEntity<D> create(@Valid @RequestBody D dto) {
    return ResponseEntity.ok(adapter.create(dto));
  }

  /**
   * Retrieves all resources.
   *
   * @return A list of all resources in DTO format.
   */
  @Operation(summary = "Get all entities")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Entity created"),
    @ApiResponse(responseCode = "404", description = "Entity not found",
      content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundException.class),
        examples = @ExampleObject(
          value = """
            {
              "exception": "NotFoundException",
              "message": "Entity with ID 123 not found",
              "status": 404,
              "path": "/{{path}}",
              "error": "Error description"
            }
          """
        )
      )
    )
  })
  @GetMapping
  public List<D> getAll() {
    return adapter.getAll();
  }

  /**
   * Retrieves a specific resource by its identifier.
   *
   * @param id The unique identifier of the resource.
   * @return The corresponding resource in DTO format.
   */
  @Operation(summary = "Get a entity by id")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Entity found"),
    @ApiResponse(responseCode = "404", description = "Entity not found",
      content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundException.class),
        examples = @ExampleObject(
          value = """
            {
              "exception": "NotFoundException",
              "message": "Entity with ID 123 not found",
              "status": 404,
              "path": "/{{path}}",
              "error": "Error description"
            }
          """
        )
      )
    )
  })
  @GetMapping("/{id}")
  public D findById(@PathVariable ID id) {
    return adapter.findById(id);
  }

  /**
   * Updates a specific resource identified by ID.
   *
   * @param id   The ID of the resource to update.
   * @param dto  The DTO containing updated fields.
   * @return The updated resource in DTO format.
   */
  @Operation(summary = "Update an existing entity")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Entity updated"),
    @ApiResponse(responseCode = "404", description = "Entity not found",
      content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundException.class),
        examples = @ExampleObject(
          value = """
            {
              "exception": "NotFoundException",
              "message": "Entity with ID 123 not found",
              "status": 404,
              "path": "/{{path}}",
              "error": "Error description"
            }
          """
        )
      )
    )
  })
  @PutMapping("/{id}")
  public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) {
    return ResponseEntity.ok(adapter.update(id, dto));
  }

  /**
   * Deletes a specific resource by its identifier.
   *
   * @param id The ID of the resource to delete.
   * @return HTTP 204 No Content if successful.
   */
  @Operation(summary = "Delete an entity")
  @ApiResponses({
    @ApiResponse(responseCode = "204", description = "Entity deleted"),
    @ApiResponse(responseCode = "404", description = "Entity not found",
      content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundException.class),
        examples = @ExampleObject(
          value = """
            {
              "exception": "NotFoundException",
              "message": "Entity with ID 123 not found",
              "status": 404,
              "path": "/{{path}}",
              "error": "Error description"
            }
          """
        )
      )
    )
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable ID id) {
    adapter.delete(id);
    return ResponseEntity.noContent().build();
  }
}
