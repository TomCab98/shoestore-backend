package com.project.shoestore.client.adapters.mappers;

import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.client.infrastructure.repositories.entities.ClientEntity;
import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientRepositoryMapper extends RepositoryMapper<Client, ClientEntity> {}
