package com.kiet.springbootexample.dao;

import com.kiet.springbootexample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
