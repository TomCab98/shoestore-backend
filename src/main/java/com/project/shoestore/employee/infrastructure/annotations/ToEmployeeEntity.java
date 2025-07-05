package com.project.shoestore.employee.infrastructure.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "enabled", constant = "true")
@Mapping(target = "accountNoExpired", constant = "true")
@Mapping(target = "accountNoLocked", constant = "true")
@Mapping(target = "credentialsNoExpired", constant = "true")
public @interface ToEmployeeEntity {}
