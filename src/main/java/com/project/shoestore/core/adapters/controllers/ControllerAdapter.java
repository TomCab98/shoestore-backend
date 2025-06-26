package com.project.shoestore.core.adapters.controllers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.core.domain.ports.IControllerPort;
import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Generic controller adapter that acts as an intermediary between the external DTOs
 * and the internal domain models. It maps between DTOs and domain entities, and delegates
 * logic execution to the corresponding use case services.
 *
 * @param <M>  The internal domain model (business logic entity).
 * @param <D>  The external Data Transfer Object (DTO) used for API communication.
 * @param <ID> The type of the unique identifier (e.g., Long, UUID, String).
 */
@RequiredArgsConstructor
public class ControllerAdapter<M, D, ID> implements IControllerPort<D, ID> {
  private final CreateService<M, ID> createService;
  private final UpdateService<M, ID> updateService;
  private final FindService<M, ID> findService;
  private final DeleteService<M, ID> deleteService;
  private final ControllerMapper<M, D> mapper;

  /**
   * Creates a new resource by mapping the DTO to a domain model and delegating to the create use case.
   *
   * @param dto The input DTO.
   * @return The created resource in DTO format.
   */
  @Override
  public D create(D dto) {
    M domain = mapper.toDomain(dto);
    M created = createService.create(domain);
    return mapper.toDto(created);
  }

  /**
   * Retrieves all resources using the find use case and maps them to DTOs.
   *
   * @return A list of DTOs representing all resources.
   */
  @Override
  public List<D> getAll() {
    List<M> domains = findService.findAll();
    return mapper.toDtoList(domains);
  }

  /**
   * Updates an existing resource by ID using the update use case.
   *
   * @param id      The resource identifier.
   * @param criteria The DTO containing fields to update.
   * @return The updated resource in DTO format.
   */
  @Override
  public D update(ID id, D criteria) {
    M partial = mapper.toDomain(criteria);
    M updated = updateService.update(id, partial);
    return mapper.toDto(updated);
  }

  /**
   * Deletes a resource by its identifier.
   *
   * @param id The ID of the resource to delete.
   */
  @Override
  public void delete(ID id) {
    deleteService.delete(id);
  }

  /**
   * Retrieves a single resource by its identifier.
   *
   * @param id The resource ID.
   * @return The resource mapped to a DTO.
   */
  @Override
  public D findById(ID id) {
    M domain = findService.findById(id);
    return mapper.toDto(domain);
  }
}
