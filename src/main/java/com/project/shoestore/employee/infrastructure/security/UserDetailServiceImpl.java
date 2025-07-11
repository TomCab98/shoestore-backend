package com.project.shoestore.employee.infrastructure.security;

import com.project.shoestore.core.domain.exceptions.BadCredentialsException;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.employee.infrastructure.dtos.AuthRequestDto;
import com.project.shoestore.employee.infrastructure.dtos.AuthResponseDto;
import com.project.shoestore.employee.infrastructure.repositories.EmployeeRepository;
import com.project.shoestore.employee.infrastructure.repositories.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private EmployeeRepository repository;

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String email) {
    EmployeeEntity employeeEntity = repository.findEmployeeEntityByEmail(email)
      .orElseThrow(() -> new NotFoundException("employee not found"));

    List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();

    employeeEntity.getRoles()
      .forEach(role -> grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

    employeeEntity.getRoles()
      .stream()
      .flatMap(role -> role.getPermissionList().stream())
      .forEach(permission -> grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getPermission().name())));

    return new User(
      employeeEntity.getName(),
      employeeEntity.getPassword(),
      employeeEntity.isEnabled(),
      employeeEntity.isAccountNoExpired(),
      employeeEntity.isCredentialsNoExpired(),
      employeeEntity.isAccountNoLocked(),
      grantedAuthorityList
    );  }

  public AuthResponseDto login(AuthRequestDto request) {
    String email = request.email();
    String password = request.password();

    Authentication authentication = this.authenticate(email, password);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String accessToken = jwtUtils.createToken(authentication);

    return new AuthResponseDto(
      email,
      "User login successfully",
      accessToken,
      true
    );
  }

  public Authentication authenticate(String email, String password) {
    UserDetails userDetails = this.loadUserByUsername(email);

    if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new BadCredentialsException("invalid email or password");
    }

    return new UsernamePasswordAuthenticationToken(email, userDetails.getPassword(), userDetails.getAuthorities());
  }

  public String encodePassword(String password) {
    return passwordEncoder.encode(password);
  }
}
