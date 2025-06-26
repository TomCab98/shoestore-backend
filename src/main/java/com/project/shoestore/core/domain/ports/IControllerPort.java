package com.project.shoestore.core.domain.ports;

import java.util.List;

/**
 * Generic input port interface that defines the application-level contract for
 * basic CRUD operations. This interface is intended to be used by infrastructure
 * controllers through a controller adapter that bridges between DTOs and the domain.
 *
 * <p>It ensures that the controller layer interacts only with DTOs and identifiers,
 * remaining completely decoupled from domain models or entities.</p>
 *
 * @param <D>  The Data Transfer Object (DTO) used for communication with external layers.
 * @param <ID> The type of the unique identifier (e.g., {@code String}, {@code Long}, {@code UUID}).
 */
public interface IControllerPort<D, ID> {

  /**
   * Creates a new resource using the given DTO.
   *
   * @param dto The DTO representing the new resource.
   * @return The created resource in DTO format.
   */
  D create(D dto);

  /**
   * Retrieves all resources.
   *
   * @return A list of all resources in DTO format.
   */
  List<D> getAll();

  /**
   * Updates an existing resource identified by its ID.
   *
   * @param id     The unique identifier of the resource.
   * @param partial A DTO containing the fields to be updated.
   * @return The updated resource in DTO format.
   */
  D update(ID id, D partial);

  /**
   * Deletes a resource identified by its ID.
   *
   * @param id The unique identifier of the resource to delete.
   */
  void delete(ID id);

  /**
   * Finds a specific resource by its ID.
   *
   * @param id The unique identifier of the resource.
   * @return The found resource in DTO format.
   */
  D findById(ID id);
}
