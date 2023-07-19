package com.example.encryptdb;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EncryptdbApplicationTests {

  public static void main(String[] args) throws Exception {

    // Tạo mới khóa AES
    KeyGenerator keygen = KeyGenerator.getInstance("AES");
    keygen.init(256); // Độ dài khóa (128 bit cho AES-128, 256 bit cho AES-256)
    SecretKey skey = keygen.generateKey();

    // Chuyển đổi khóa sang chuỗi Base64
    byte[] encodedKey = skey.getEncoded();
    String encKeyString = Base64.getEncoder().encodeToString(encodedKey);

    System.out.println("Generated Encoded Key: " + encKeyString);


    String messageToEncrypt = "test";
    System.out.println("Message to encrypt: " + messageToEncrypt);

//        KeyGenerator keygen = KeyGenerator.getInstance("AES");
//        keygen.init(128);
//        SecretKey skey = keygen.generateKey();
//        byte[] encKey = skey.getEncoded();

//    String encKey = "4Eo9HIN2hFUl6VhuILTJSg==";
    String encKey = "4Eo9HIN2hFUl1VhuILTJ12==";

    String encrypted1 = encrypt(messageToEncrypt, encKey);
    String encrypted2 = encrypt(messageToEncrypt, encKey);
    System.out.println("Encrypted string: 1 " + encrypted1);
    System.out.println("Encrypted string: 2 " + encrypted2);

    String originalString = decrypt(encrypted1, encKey);
    System.out.println("Original string: " + originalString);
  }

  /**
   * Encrypt given string <code>plainText</code> in AES encryption using the given key
   * <code>rawkey</code>.
   *
   * @param plainText string to be decrypted
   * @param encodedKey    encryption key
   * @return encrypted string
   * @throws Exception
   */
  public static String encrypt(String plainText, String encodedKey) throws Exception {

    try {
      SecretKeySpec skeySpec = new SecretKeySpec(Base64.getDecoder().decode(encodedKey), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
      byte[] encrypted = cipher.doFinal(plainText.getBytes());
      System.out.println("encryptedencryptedencrypted: encrypted" + encrypted);
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      throw e;
    }
  }

  /**
   * Decrypt given AES encrypted string <code>encryptedText</code> using given key
   * <code>rawkey</code>
   *
   * @param encryptedText string to be decrypted
   * @param decodeKey        decryption key (same encryption key used to encrypt this text)
   * @return decrypted string
   * @throws Exception
   */
  public static String decrypt(String encryptedText, String decodeKey) throws Exception {
    try {
      SecretKeySpec skeySpec = new SecretKeySpec(Base64.getDecoder().decode(decodeKey), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.DECRYPT_MODE, skeySpec);
      byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
      return new String(decryptedBytes);

    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      throw e;
    }
  }
}
