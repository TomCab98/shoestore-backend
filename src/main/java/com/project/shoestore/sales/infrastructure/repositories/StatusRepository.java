package com.project.shoestore.sales.infrastructure.repositories;

import com.project.shoestore.core.infrastructure.repositories.IRepository;
import com.project.shoestore.sales.infrastructure.repositories.entities.StatusEntity;

public interface StatusRepository extends IRepository<StatusEntity, Integer> {
  StatusEntity findByName(String name);
}
