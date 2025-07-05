package com.project.shoestore.core.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ports.ControllerAdapterPort;
import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Generic adapter that maps DTOs to domain models and delegates to use case services.
 *
 * @param <M>  Domain model
 * @param <D>  DTO
 * @param <ID> Identifier type
 */
@RequiredArgsConstructor
public class ControllerAdapter<M, D, ID> implements ControllerAdapterPort<D, ID> {
  private final CreateService<M, ID> createService;
  private final UpdateService<M, ID> updateService;
  private final FindService<M, ID> findService;
  private final DeleteService<M, ID> deleteService;
  private final ControllerMapper<M, D> mapper;

  @Override
  public D create(D dto) {
    M model = mapper.toDomain(dto);
    M created = createService.create(model);
    return mapper.toDto(created);
  }

  @Override
  public List<D> getAll() {
    return mapper.toDtoList(findService.findAll());
  }

  @Override
  public D update(ID id, D dto) {
    M model = mapper.toDomain(dto);
    M updated = updateService.update(id, model);
    return mapper.toDto(updated);
  }

  @Override
  public void delete(ID id) {
    deleteService.delete(id);
  }

  @Override
  public D findById(ID id) {
    M model = findService.findById(id);
    return mapper.toDto(model);
  }
}
