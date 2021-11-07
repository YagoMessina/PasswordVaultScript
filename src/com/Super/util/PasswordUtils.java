package com.Super.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordUtils {

  public static String encrypt(String password, String key) {
    if (password == null || password.isEmpty()) { return ""; }

    try {
      DESKeySpec keySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey secretKey = keyFactory.generateSecret(keySpec);
      BASE64Encoder base64encoder = new BASE64Encoder();

      byte[] cleartext = password.getBytes(StandardCharsets.UTF_8);
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return base64encoder.encode(cipher.doFinal(cleartext));

    } catch (Exception e) {
      e.printStackTrace();
    }

    return "";
  }

  public static String decrypt(String password, String key) {
    if (password == null || password.isEmpty()) { return ""; }

    try {
      BASE64Decoder base64decoder = new BASE64Decoder();
      byte[] encryptedPwdBytes = base64decoder.decodeBuffer(password);
      DESKeySpec keySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey secretKey = keyFactory.generateSecret(keySpec);

      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      byte[] plainTextPwdBytes = (cipher.doFinal(encryptedPwdBytes));
      return new String(plainTextPwdBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "";
  }

  public static String randomPassword() {
    Random random = new Random();
    int passwordLength = 20;
    List<String> charsets = new ArrayList<>();
    charsets.add("ZXCVBNMASDFGHJKLQWERTYUIOP");
    charsets.add("zxcvbnmasdfghjklqwertyuiop");
    charsets.add("1234567890");
    charsets.add("!@#$%^&*_+?");

    StringBuilder password = new StringBuilder();
    for (int i = 0; i < passwordLength; ++i) {
      String charset = charsets.get(random.nextInt(charsets.size()));
      char character = charset.charAt(random.nextInt(charset.length()));
      password.append(character);
    }

    return password.toString();
  }

  public static String generateKey()  {
    Random random = new Random();
    int keyLength = 16;
    List<String> charsets = new ArrayList<>();
    charsets.add("ZXCVBNMASDFGHJKLQWERTYUIOP");
    charsets.add("1234567890");

    StringBuilder password = new StringBuilder();
    for (int i = 0; i < keyLength; ++i) {
      String charset = charsets.get(random.nextInt(charsets.size()));
      char character = charset.charAt(random.nextInt(charset.length()));
      password.append(character);
    }

    return password.toString();
  }
}
