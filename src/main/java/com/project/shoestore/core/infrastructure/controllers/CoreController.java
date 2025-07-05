package com.project.shoestore.core.infrastructure.controllers;

import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.core.adapters.controllers.ports.ControllerAdapterPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
  private final ControllerAdapterPort<D, ID> adapter;

  /**
   * Handles the creation of a new resource.
   *
   * @param dto The input DTO from the HTTP request body.
   * @return The created resource in DTO format.
   */
  @PostMapping
  public ResponseEntity<D> create(@Valid @RequestBody D dto) {
    return ResponseEntity.ok(adapter.create(dto));
  }

  /**
   * Retrieves all resources.
   *
   * @return A list of all resources in DTO format.
   */
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
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable ID id) {
    adapter.delete(id);
    return ResponseEntity.noContent().build();
  }
}
