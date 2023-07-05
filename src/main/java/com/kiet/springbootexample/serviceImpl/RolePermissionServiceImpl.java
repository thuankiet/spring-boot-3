package com.kiet.springbootexample.serviceImpl;

import com.kiet.springbootexample.constant.MessageConstant;
import com.kiet.springbootexample.dao.PermissionDao;
import com.kiet.springbootexample.dao.RoleDao;
import com.kiet.springbootexample.dao.RolePermissionDao;
import com.kiet.springbootexample.dto.request.RolePermissionRequestDTO;
import com.kiet.springbootexample.entity.Permission;
import com.kiet.springbootexample.entity.Role;
import com.kiet.springbootexample.entity.RolePermission;
import com.kiet.springbootexample.exception.NotFoundException;
import com.kiet.springbootexample.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

  private final RoleDao roleDao;
  private final PermissionDao permissionDao;
  private final RolePermissionDao rolePermissionDao;

  @Override
  public void createRolePermission(RolePermissionRequestDTO dto) {
    Role role = roleDao.findById(dto.getRoleId()).orElse(null);
    if (role == null) {
      throw new NotFoundException(MessageConstant.ROLE_NOT_FOUND, dto.getRoleId());
    }
    Permission permission = permissionDao.findById(dto.getPermissionId()).orElse(null);
    if (permission == null) {
      throw new NotFoundException(MessageConstant.PERMISSION_NOT_FOUND, dto.getPermissionId());
    }

    RolePermission rolePermission = RolePermission.builder()
      .role(role)
      .permission(permission)
      .build();

    rolePermissionDao.save(rolePermission);
  }
}
