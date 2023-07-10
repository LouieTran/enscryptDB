package com.example.encryptdb.dto;

import lombok.Data;

@Data
public class UserDto {

  public UserDto(String name, String email) {
    this.name = name;
    this.email = email;
  }

  private String name;
  private String email;

}
