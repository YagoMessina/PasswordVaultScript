package com.Super.util;

import com.Super.entity.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {

  @Test
  public void encrypt_OK() {
    String text = "text";

    String encodedText = PasswordUtils.encrypt(text);

    assertEquals(encodedText, "dGV4dA==");
  }

  @Test
  public void encrypt_nullString() {
    String encodedText = PasswordUtils.encrypt(null);

    assertEquals(encodedText, "");
  }

  @Test
  public void encrypt_emptyString() {
    String encodedText = PasswordUtils.encrypt("");

    assertEquals(encodedText, "");
  }

  @Test
  public void decrypt_OK() {
    String encodedText = "dGV4dA==";

    String text = PasswordUtils.decrypt(encodedText);

    assertEquals(text, "text");
  }

  @Test
  public void decrypt_nullString() {
    String text = PasswordUtils.decrypt(null);

    assertEquals(text, "");
  }

  @Test
  public void decrypt_emptyString() {
    String text = PasswordUtils.decrypt("");

    assertEquals(text, "");
  }

  @Test
  public void generatePassword_withSymbols() {
    Password password = PasswordUtils.randomPassword();

    assertNotNull(password);
    assertEquals(password.getDecrypted().length(), 20);
  }
}