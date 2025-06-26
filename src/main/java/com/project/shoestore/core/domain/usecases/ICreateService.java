package com.project.shoestore.core.domain.usecases;

public interface ICreateService<M> {
  public M create(M model);
}
