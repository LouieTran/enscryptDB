package com.example.encryptdb.controller;

import com.example.encryptdb.dto.UserDto;
import com.example.encryptdb.entity.User;
import com.example.encryptdb.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public ResponseEntity<?> users(){

    List<UserDto> userList = userService.getUsers();
    if (userList.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(userList);
    }
  }

  @PostMapping("user")
  public ResponseEntity<?> createUsers(@RequestBody UserDto userDto) throws Exception {
    User createdUser = userService.createUser(userDto);
      return ResponseEntity.ok(createdUser);
  }
}
