package com.kiet.springbootexample.controller;

import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.utils.IntegrationTestingBase;
import com.kiet.springbootexample.utils.customer.CustomerBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerControllerTest extends IntegrationTestingBase {

  @Autowired
  private CustomerBuilder customerBuilder;

  @Test
  public void getCustomerById() throws IOException {
    customerBuilder.createCustomer();
    HttpUriRequest request = RequestBuilder.get()
      .setUri(API_ROOT_PATH + "/customers/1")
      .build();

    HttpResponse response = HttpClientBuilder.create().build().execute(request);
    assertThat(response.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
  }

  @Test
  public void getCustomers() throws IOException {
    customerBuilder.createCustomer();
    HttpUriRequest request = RequestBuilder.get()
      .setUri(API_ROOT_PATH + "/customers")
      .build();

    HttpResponse response = HttpClientBuilder.create().build().execute(request);
    assertThat(response.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
  }
}
