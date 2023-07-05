package com.kiet.springbootexample.controller;

import com.kiet.springbootexample.dto.request.RoleRequestDTO;
import com.kiet.springbootexample.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@BaseController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

  private final RoleService roleService;

  @PostMapping
  public ResponseEntity<Void> createRole(@Validated @RequestBody RoleRequestDTO dto) {
    roleService.createRole(dto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteRole(@PathVariable Long id) {
    roleService.deleteRole(id);
    return ResponseEntity.ok().build();
  }
}
