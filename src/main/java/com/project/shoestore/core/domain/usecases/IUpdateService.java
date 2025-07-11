package com.project.shoestore.core.domain.usecases;

public interface IUpdateService<M, ID> {
  M update(ID id, M criteria);
}
