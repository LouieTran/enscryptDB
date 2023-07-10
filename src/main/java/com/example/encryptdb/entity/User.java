package com.example.encryptdb.entity;

import com.example.encryptdb.dto.UserDto;
import com.example.encryptdb.utils.EncryptUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name="users")
@Entity
public class User {

  public User() {
  }

  public UserDto toUserDto(String privateKey) throws Exception {
    String decodedEmail = EncryptUtils.decodedPrivateKey(privateKey,this.email);
    return new UserDto(this.name, decodedEmail);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

}
