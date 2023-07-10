package com.example.encryptdb.service.impl;

import com.example.encryptdb.dto.KeyPairRSADto;
import com.example.encryptdb.service.EncryptionService;
import com.example.encryptdb.utils.EncryptUtils;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {

  @Override
  public KeyPairRSADto genKeyPair() throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    SecureRandom secureRandom = new SecureRandom();
    keyPairGenerator.initialize(2048, secureRandom);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();

    return new KeyPairRSADto(EncryptUtils.publicKeyToBase64String(publicKey),EncryptUtils.privateKeyToBase64String(privateKey));
  }
}
