package com.example.encryptdb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyPairRSADto {
  String privateKey;
  String publicKey;


}
