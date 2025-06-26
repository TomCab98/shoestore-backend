package com.project.shoestore.core.domain.usecases;

public interface IDeleteService<ID> {
  public void delete(ID id);
}
