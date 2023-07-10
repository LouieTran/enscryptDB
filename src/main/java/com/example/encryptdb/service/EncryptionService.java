package com.example.encryptdb.service;

import com.example.encryptdb.dto.KeyPairRSADto;
import java.security.NoSuchAlgorithmException;

public interface EncryptionService {
  KeyPairRSADto genKeyPair() throws NoSuchAlgorithmException;


}