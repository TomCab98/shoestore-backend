package com.project.shoestore.core.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Generic base interface for all JPA repositories in the infrastructure layer.
 * This abstraction prevents direct exposure of Spring Data interfaces at the domain level
 * and facilitates consistency across all repository definitions.
 *
 * <p>It is marked with {@link NoRepositoryBean} to avoid being instantiated directly by Spring.</p>
 *
 * @param <A>  The JPA entity type managed by the repository (typically annotated with {@code @Entity}).
 * @param <ID> The type of the entity's identifier (e.g., {@code Long}, {@code UUID}, {@code String}).
 */
@NoRepositoryBean
public interface IRepository<A, ID> extends JpaRepository<A, ID> {}
