package com.kiet.springbootexample.config;

import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
  private final CustomerDao customerDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Customer customer = customerDao.findByEmail(username).orElse(null);
    if (customer == null || customer.getIsActive() == 0) {
      throw new UsernameNotFoundException("No user found with email: " + username);
    }
    return customer;
  }
}
