package com.project.shoestore.core.adapters.repositories;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.infrastructure.repositories.IRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * Generic repository adapter implementing the domain's repository port.
 * This class acts as a bridge between the domain layer and the persistence infrastructure,
 * delegating persistence operations to a Spring Data JPA repository and mapping
 * between domain models and persistence entities.
 *
 * @param <M>  The domain model type.
 * @param <E>  The persistence entity type.
 * @param <ID> The type of the identifier used for the entities.
 */
@RequiredArgsConstructor
public class RepositoryAdapter<M, E, ID> implements IRepositoryPort<M, ID> {

  protected final IRepository<E, ID> repository;
  protected final RepositoryMapper<M, E> mapper;

  /**
   * Persists a new domain model by mapping it to a persistence entity and saving it.
   *
   * @param domain The domain model to persist.
   * @return The persisted domain model mapped back from the saved entity.
   */
  @Override
  public M create(M domain) {
    E entity = mapper.toEntity(domain);
    E created = repository.save(entity);
    return mapper.toDomain(created);
  }

  /**
   * Retrieves all persisted entities and maps them to domain models.
   *
   * @return A list of all domain models.
   */
  @Override
  public List<M> getAll() {
    List<E> entities = repository.findAll();
    return mapper.toDomainList(entities);
  }

  /**
   * Deletes an entity by its identifier.
   *
   * @param id The identifier of the entity to delete.
   */
  @Override
  public void delete(ID id) {
    repository.deleteById(id);
  }

  /**
   * Finds an entity by its identifier and maps it to a domain model if present.
   *
   * @param id The identifier of the entity to find.
   * @return An Optional containing the domain model if found, or empty otherwise.
   */
  @Override
  public Optional<M> findById(ID id) {
    Optional<E> entity = repository.findById(id);
    return mapper.toDomain(entity);
  }
}
