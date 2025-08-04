package com.project.shoestore.sales.adapters.mappers;

import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.employee.domain.models.Employee;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.infrastructure.dtos.SaleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
  componentModel = "spring",
  uses = { SaleDetailControllerMapper.class }
)
public interface SaleControllerMapper extends ControllerMapper<Sale, SaleDto> {

  @Override
  @Mapping(target = "employee", source = "employee.name")
  @Mapping(target = "client", source = "client.name")
  SaleDto toDto(Sale sale);

  default Employee mapEmployee(String id) {
    return new Employee(id);
  }

  default Client mapClient(String id) {
    return new Client(id);
  }
}
