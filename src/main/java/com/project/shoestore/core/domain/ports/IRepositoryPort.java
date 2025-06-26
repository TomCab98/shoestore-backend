package com.project.shoestore.core.domain.ports;

import java.util.List;
import java.util.Optional;

/**
 * Generic output port interface that defines the persistence operations expected by
 * the domain or application layer. This abstraction allows the domain to remain
 * independent of any specific persistence technology (e.g., JPA, MongoDB, file systems).
 *
 * <p>This interface should be implemented by infrastructure-layer adapters
 * that interact with concrete databases or external storage systems.</p>
 *
 * @param <M>  The domain model (business object) handled by the repository.
 * @param <ID> The type of the identifier used to uniquely reference a domain entity.
 */
public interface IRepositoryPort<M, ID> {

  /**
   * Persists a new domain object.
   *
   * @param model The domain object to be created.
   * @return The persisted domain object.
   */
  M create(M model);

  /**
   * Retrieves all stored domain objects.
   *
   * @return A list of all domain objects.
   */
  List<M> getAll();

  /**
   * Deletes a domain object by its unique identifier.
   *
   * @param id The ID of the domain object to delete.
   */
  void delete(ID id);

  /**
   * Finds a domain object by its unique identifier.
   *
   * @param id The ID of the domain object to find.
   * @return An {@link Optional} containing the domain object if found, or empty otherwise.
   */
  Optional<M> findById(ID id);
}
