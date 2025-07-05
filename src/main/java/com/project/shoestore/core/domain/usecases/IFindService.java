package com.project.shoestore.core.domain.usecases;

import java.util.List;

public interface IFindService<M, ID> {
  List<M> findAll();
  M findById(ID id);
  boolean existById(ID id);
}
