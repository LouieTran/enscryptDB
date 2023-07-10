package com.example.encryptdb.utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class EncryptUtils {


  public static String decodedPrivateKey(String privateKeyString,String encryptedString)
      throws Exception {
    // Giải mã với khóa bí mật
    PrivateKey decodedPrivateKey = base64StringToPrivateKey(privateKeyString);
    Cipher cipherDecrypt = Cipher.getInstance("RSA");
    cipherDecrypt.init(Cipher.DECRYPT_MODE, decodedPrivateKey);
    byte[] decryptedBytes = cipherDecrypt.doFinal(Base64.getDecoder().decode(encryptedString));
    return new String(decryptedBytes);
  }
  public static String cipherEncrypt(String publicKeyString,String encryptData)
      throws Exception {
    // Mã hóa với khóa công khai
    PublicKey decodedPublicKey = base64StringToPublicKey(publicKeyString );
    Cipher cipherEncrypt = Cipher.getInstance("RSA");
    cipherEncrypt.init(Cipher.ENCRYPT_MODE, decodedPublicKey);
    byte[] encryptedBytes = cipherEncrypt.doFinal(encryptData.getBytes());
    return Base64.getEncoder().encodeToString(encryptedBytes);
  }
  public static String publicKeyToBase64String(PublicKey publicKey) {
    return Base64.getEncoder().encodeToString(publicKey.getEncoded());
  }

  public static PublicKey base64StringToPublicKey(String publicKeyString) throws Exception {
    byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
    return keyFactory.generatePublic(keySpec);
  }

  public static String privateKeyToBase64String(PrivateKey privateKey) {
    return Base64.getEncoder().encodeToString(privateKey.getEncoded());
  }

  private static PrivateKey base64StringToPrivateKey(String privateKeyString) throws Exception {
    byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
    return keyFactory.generatePrivate(keySpec);
  }
}
