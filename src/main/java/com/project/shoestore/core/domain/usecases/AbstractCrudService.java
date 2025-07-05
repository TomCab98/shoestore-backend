package com.project.shoestore.core.domain.usecases;

import com.project.shoestore.core.domain.exceptions.DatabaseAccessException;
import com.project.shoestore.core.domain.exceptions.IllegalArgumentException;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.core.domain.ports.IRepositoryPort;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractCrudService<M, ID> {
  public abstract IRepositoryPort<M, ID> getRepository();

  public M create(M model) {
    try {
      return getRepository().create(model);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail saving in database " + model.toString() + e.getMessage());
    }
  }

  public List<M> findAll() {
    try {
      return this.getRepository().getAll();
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining domain from database" + e.getMessage());
    }
  }

  public M findById(ID id) {
    Optional<M> domain;
    try {
      domain = this.getRepository().findById(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining domain with id from database" + e.getMessage());
    }

    if (domain.isEmpty()) {
      throw new NotFoundException("Not found domain with id " + id);
    }

    return domain.get();
  }

  public boolean existById(ID id) {
    Optional<M> task = this.getRepository().findById(id);
    return task.isPresent();
  }

  @Transactional
  public void delete(ID id) {
    if (!existById(id)) {
      throw new NotFoundException("Not found task with id " + id);
    }

    try {
      this.getRepository().delete(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail deleting the domain from database " + id + e.getMessage());
    }
  }

  public M update(ID id, M criteria) {
    Optional<M> existModel = getRepository().findById(id);
    if (existModel.isEmpty()) {
      throw new NotFoundException("Not found domain with id " + id);
    }

    M model = existModel.get();
    for (Field field : criteria.getClass().getDeclaredFields()) {
      field.setAccessible(true);

      try {
        Object newValue = field.get(criteria);
        Object oldValue = field.get(model);

        if (newValue != null && !Objects.equals(newValue, oldValue)) {
          field.set(model, newValue);
        }
      } catch (Exception e) {
        throw new IllegalArgumentException("Error updating model field: " + field.getName() + e.getMessage());
      }
    }

    return this.getRepository().create(model);
  }
}
