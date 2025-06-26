package com.project.shoestore.domain.ports;

import com.project.shoestore.core.domain.ports.IControllerPort;
import com.project.shoestore.infrastructure.dtos.EmployeeDto;

public interface IEmployeeControllerPort extends IControllerPort<EmployeeDto, String> {}
