package com.kiet.springbootexample.mapper;

import java.util.Date;

public interface CustomerInterfaceProjectionMapper {
  Long getId();
  String getFirstname();
  String getLastname();
  String getEmail();
  Integer getIsActive();
  Date getCreatedDate();
}
