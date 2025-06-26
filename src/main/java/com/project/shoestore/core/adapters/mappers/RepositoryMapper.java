package com.project.shoestore.core.adapters.mappers;

import java.util.List;
import java.util.Optional;

/**
 * Generic interface for mapping between domain models and persistence entities.
 * This interface is typically implemented by adapters that translate between the
 * domain layer and the persistence layer (e.g., JPA entities).
 *
 * <p>It ensures separation between the domain model and database representations,
 * enabling the domain to remain persistence-agnostic.</p>
 *
 * @param <M> The domain model (business object).
 * @param <E> The persistence entity (e.g., JPA entity).
 */
public interface RepositoryMapper<M, E> {

  /**
   * Converts a domain model into its corresponding persistence entity.
   *
   * @param model The domain model to be converted.
   * @return The persistence entity representation of the domain model.
   */
  E toEntity(M model);

  /**
   * Converts a persistence entity into its corresponding domain model.
   *
   * @param entity The persistence entity to be converted.
   * @return The domain model representation of the entity.
   */
  M toDomain(E entity);

  /**
   * Converts a list of persistence entities into a list of domain models.
   *
   * @param entities The list of persistence entities.
   * @return A list of domain models representing the entities.
   */
  List<M> toDomainList(List<E> entities);

  /**
   * Converts an Optional persistence entity into an Optional domain model.
   *
   * @param entity The Optional containing a persistence entity.
   * @return An Optional containing the corresponding domain model, or empty if not present.
   */
  default Optional<M> toDomain(Optional<E> entity) {
    return entity.map(this::toDomain);
  }
}
