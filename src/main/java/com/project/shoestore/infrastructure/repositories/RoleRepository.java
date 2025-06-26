package com.project.shoestore.infrastructure.repositories;

import com.project.shoestore.core.infrastructure.repositories.IRepository;
import com.project.shoestore.infrastructure.repositories.entities.RoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends IRepository<RoleEntity, String> {
  Set<RoleEntity> findByRoleIn(List<String> roles);
}
