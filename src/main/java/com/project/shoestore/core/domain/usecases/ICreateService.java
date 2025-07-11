package com.project.shoestore.core.domain.usecases;

public interface ICreateService<M> {
  M create(M model);
}
