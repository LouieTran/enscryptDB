package com.example.encryptdb.service;

import com.example.encryptdb.dto.UserDto;
import com.example.encryptdb.entity.User;
import java.util.List;

public interface UserService {

  List<UserDto> getUsers();

  User createUser(UserDto userDto) throws Exception;
}
