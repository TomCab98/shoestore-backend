package com.project.shoestore.core.domain.usecases;

public interface IDeleteService<ID> {
  void delete(ID id);
}
