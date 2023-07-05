package com.kiet.springbootexample.controller;

import com.kiet.springbootexample.dto.request.PermissionRequestDTO;
import com.kiet.springbootexample.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@BaseController
@RequiredArgsConstructor
@RequestMapping("/api/v1/permissions")
public class PermissionController {

  private final PermissionService permissionService;

  @PostMapping
  public ResponseEntity createPermission(@Validated @RequestBody PermissionRequestDTO dto) {
    permissionService.createPermission(dto);
    return ResponseEntity.ok().build();
  }
}
