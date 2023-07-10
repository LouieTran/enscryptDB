package com.example.encryptdb.encrypt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Configuration
public class RSAConfiguration {

  @Bean
  public KeyPair rsaKeyPair() throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    SecureRandom secureRandom = new SecureRandom();
    keyPairGenerator.initialize(2048, secureRandom);
    return keyPairGenerator.generateKeyPair();
  }

  @Bean
  public StringKeyGenerator stringKeyGenerator() {
    return KeyGenerators.string();
  }
}