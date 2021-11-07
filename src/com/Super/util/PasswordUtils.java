package com.Super.util;

import com.Super.entity.Password;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class PasswordUtils {

  public static String encrypt(String password) {
    if (password == null) { return ""; }

    Base64.Encoder encoder = Base64.getEncoder();
    byte[] bytes = password.getBytes(StandardCharsets.UTF_8);

    return new String(encoder.encode(bytes));
  }

  public static String decrypt(String password) {
    if (password == null) { return ""; }

    Base64.Decoder decoder = Base64.getDecoder();
    return new String(decoder.decode(password));
  }

  public static Password randomPassword() {
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

    return new Password(password.toString(), true);
  }
}
