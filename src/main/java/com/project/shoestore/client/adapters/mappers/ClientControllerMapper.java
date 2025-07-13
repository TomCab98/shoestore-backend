package com.project.shoestore.client.adapters.mappers;

import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.client.infrastructure.dtos.ClientDto;
import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientControllerMapper extends ControllerMapper<Client, ClientDto> {}
