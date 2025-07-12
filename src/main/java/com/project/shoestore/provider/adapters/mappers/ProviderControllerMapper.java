package com.project.shoestore.provider.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.provider.domain.models.Provider;
import com.project.shoestore.provider.infrastructure.dtos.ProviderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderControllerMapper extends ControllerMapper<Provider, ProviderDto> {

}
