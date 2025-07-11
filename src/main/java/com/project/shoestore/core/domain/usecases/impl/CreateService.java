package com.project.shoestore.core.domain.usecases.impl;

import com.project.shoestore.core.domain.exceptions.DatabaseAccessException;
import com.project.shoestore.core.domain.exceptions.IllegalArgumentException;
import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.core.domain.usecases.ICreateService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

public class CreateService<M, ID> implements ICreateService<M> {
  private final IRepositoryPort<M, ID> repository;

  public CreateService(IRepositoryPort<M, ID> repository) {
    this.repository = repository;
  }

  @Override
  public M create(M model) {
    try {
      return repository.create(model);
    } catch (DataIntegrityViolationException | ConstraintViolationException e) {
      throw new IllegalArgumentException("Foreign key constraint fails");
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail saving in database " + model.toString() + e.getMessage());
    }
  }
}
