package com.project.shoestore.employee.infrastructure.controllers;

import com.project.shoestore.employee.infrastructure.controllers.interfaces.IAuthController;
import com.project.shoestore.employee.infrastructure.dtos.AuthRequestDto;
import com.project.shoestore.employee.infrastructure.dtos.AuthResponseDto;
import com.project.shoestore.employee.infrastructure.security.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements IAuthController {

  @Autowired
  private UserDetailServiceImpl userDetailService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthRequestDto request) {
    return new ResponseEntity<>(userDetailService.login(request), HttpStatus.OK);
  }
}
