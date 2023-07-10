package com.example.encryptdb.controller;

import com.example.encryptdb.dto.KeyPairRSADto;
import com.example.encryptdb.service.EncryptionService;
import java.security.NoSuchAlgorithmException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptController {

  private final EncryptionService encryptionService;

  public EncryptController(EncryptionService encryptionService) {
    this.encryptionService = encryptionService;
  }

  @GetMapping("get-key-for-rsa-algorithm")
  public ResponseEntity<?> getKey() throws NoSuchAlgorithmException {
    KeyPairRSADto keyPairRSADto = encryptionService.genKeyPair();
    return ResponseEntity.ok(keyPairRSADto);
  }

}
