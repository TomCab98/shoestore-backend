package com.project.shoestore.core.adapters.mappers;

import java.util.List;

/**
 * Generic interface for mapping between domain models and Data Transfer Objects (DTOs).
 * This interface is typically implemented by adapters responsible for translating between
 * the internal business logic and the external representation exposed through the API.
 *
 * <p>It ensures that the domain remains isolated from transport-specific structures like DTOs,
 * promoting clean separation between layers.</p>
 *
 * @param <M>   The domain model (business object).
 * @param <DTO> The Data Transfer Object used in API communication.
 */
public interface ControllerMapper<M, DTO> {

  /**
   * Converts a domain model to its corresponding DTO representation.
   *
   * @param model The domain object to be mapped.
   * @return The DTO representation of the domain object.
   */
  DTO toDto(M model);

  /**
   * Converts a DTO to its corresponding domain model.
   *
   * @param dto The DTO to be mapped.
   * @return The domain model representation of the DTO.
   */
  M toDomain(DTO dto);

  /**
   * Converts a list of domain models into a list of DTOs.
   *
   * @param models The list of domain models.
   * @return A list of DTOs representing the domain models.
   */
  List<DTO> toDtoList(List<M> models);
}
