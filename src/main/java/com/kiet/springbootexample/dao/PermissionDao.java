package com.kiet.springbootexample.dao;

import com.kiet.springbootexample.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
}
