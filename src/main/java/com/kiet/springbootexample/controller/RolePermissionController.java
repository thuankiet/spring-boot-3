package com.kiet.springbootexample.controller;

import com.kiet.springbootexample.dto.request.RolePermissionRequestDTO;
import com.kiet.springbootexample.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@BaseController
@RequestMapping("/api/v1/role-permission")
@RequiredArgsConstructor
public class RolePermissionController {
  private final RolePermissionService rolePermissionService;

  @PostMapping
  public ResponseEntity<Void> createRolePermission(
    @Validated @RequestBody RolePermissionRequestDTO dto
  ) {
    rolePermissionService.createRolePermission(dto);
    return ResponseEntity.ok().build();
  }
}
