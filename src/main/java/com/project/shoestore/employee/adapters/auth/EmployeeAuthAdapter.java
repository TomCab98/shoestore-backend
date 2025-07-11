package com.project.shoestore.employee.adapters.auth;

import com.project.shoestore.employee.infrastructure.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAuthAdapter {

  @Autowired
  private UserDetailServiceImpl userDetailService;

  public String encodePassword(String password) {
    return userDetailService.encodePassword(password);
  }
}
