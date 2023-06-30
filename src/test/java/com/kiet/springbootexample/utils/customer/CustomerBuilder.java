package com.kiet.springbootexample.utils.customer;

import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerBuilder {
  private final CustomerDao customerDao;

  public Customer createCustomer() {
    Customer customer = Customer.builder()
      .email("email@example.com")
      .firstname("firstname")
      .lastname("lastname")
      .build();
    return customerDao.save(customer);
  }
}
