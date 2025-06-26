package com.project.shoestore.adapters.auth;

import com.project.shoestore.infrastructure.security.UserDetailServiceImpl;
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
