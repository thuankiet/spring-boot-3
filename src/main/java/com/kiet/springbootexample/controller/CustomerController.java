package com.kiet.springbootexample.controller;

import com.kiet.springbootexample.dto.request.CustomerRequestDTO;
import com.kiet.springbootexample.dto.response.CustomerResponse;
import com.kiet.springbootexample.dto.response.DataTableResponse;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@BaseController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.getCustomer(id));
  }

  @GetMapping
  public ResponseEntity<DataTableResponse> getCustomers(
    @RequestParam(defaultValue = "0") Integer pageNo,
    @RequestParam(defaultValue = "10") Integer pageSize) {
    return ResponseEntity.ok(customerService.getCustomerPage(pageNo, pageSize));
  }

  @PostMapping
  public ResponseEntity save(@RequestBody CustomerRequestDTO dto) {
    customerService.save(dto);
    return ResponseEntity.created(URI.create("")).build();
  }

  @PutMapping
  public ResponseEntity update(@RequestBody CustomerRequestDTO dto) {
    customerService.update(dto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    customerService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
