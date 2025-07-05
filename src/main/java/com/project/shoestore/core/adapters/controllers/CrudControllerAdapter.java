package com.project.shoestore.core.adapters.controllers;

import com.project.shoestore.core.adapters.controllers.ports.ControllerAdapterPort;
import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.core.domain.usecases.AbstractCrudService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CrudControllerAdapter<M, D, ID> implements ControllerAdapterPort<D, ID> {
   private final AbstractCrudService<M, ID> service;
   private final ControllerMapper<M, D> mapper;

  @Override
  public D create(D dto) {
    M model = mapper.toDomain(dto);
    M created = service.create(model);
    return mapper.toDto(created);
  }

  @Override
  public List<D> getAll() {
    return mapper.toDtoList(service.findAll());
  }

  @Override
  public D update(ID id, D dto) {
    M model = mapper.toDomain(dto);
    M updated = service.update(id, model);
    return mapper.toDto(updated);
  }

  @Override
  public void delete(ID id) {
    service.delete(id);
  }

  @Override
  public D findById(ID id) {
    M model = service.findById(id);
    return mapper.toDto(model);
  }
}
