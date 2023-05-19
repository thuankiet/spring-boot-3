package com.kiet.springbootexample.dao;

import com.kiet.springbootexample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Long> {
  Optional<Customer> findByEmail(String email);
}
