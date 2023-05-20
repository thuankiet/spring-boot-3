package com.kiet.springbootexample.auth;

import com.kiet.springbootexample.config.JwtService;
import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final CustomerDao customerDao;
  private final BCryptPasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    Customer customer = Customer.builder()
      .email(request.getEmail())
      .firstname(request.getFirstname())
      .lastname(request.getLastname())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.USER)
      .createdDate(new Date())
      .lastModifiedDate(new Date())
      .isActive(1)
      .build();
    customerDao.save(customer);

    String token = jwtService.generateToken(customer);
    return AuthenticationResponse.builder()
      .token(token)
      .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    );

    Customer customer = customerDao.findByEmail(request.getEmail()).orElseThrow();

    String token = jwtService.generateToken(customer);
    return AuthenticationResponse.builder()
      .token(token)
      .build();
  }
}
