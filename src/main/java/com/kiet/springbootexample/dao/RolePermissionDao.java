package com.kiet.springbootexample.dao;

import com.kiet.springbootexample.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionDao extends JpaRepository<RolePermission, Long> {

}
