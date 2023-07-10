package com.example.encryptdb.service.impl;

import com.example.encryptdb.dto.UserDto;
import com.example.encryptdb.entity.User;
import com.example.encryptdb.repository.UserRepository;
import com.example.encryptdb.service.UserService;
import com.example.encryptdb.utils.EncryptUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Value("${encrypt.public-key}")
  private String publicKeyRSA;
  @Value("${encrypt.private-key}")
  private String privateKey;

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<UserDto> getUsers() {
    List<User> users = userRepository.findAll();

    return users.stream()
        .map(user -> {
          try {
            return user.toUserDto(privateKey);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        })
        .collect(Collectors.toList());
  }

  @Override
  public User createUser(UserDto userDto) throws Exception {
    User user = new User();
    user.setName(userDto.getName());
    user.setEmail(EncryptUtils.cipherEncrypt(publicKeyRSA, userDto.getEmail()));
    userRepository.save(user);
    return user;
  }
}
