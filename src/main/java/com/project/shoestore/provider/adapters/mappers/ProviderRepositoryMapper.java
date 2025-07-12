package com.project.shoestore.provider.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.infrastructure.repositories.entities.ProviderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderRepositoryMapper extends RepositoryMapper<Provider, ProviderEntity> {

}
