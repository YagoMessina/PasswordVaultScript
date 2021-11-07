package com.Super.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PasswordUtilsTest {

  private String key;

  @BeforeAll
  public void setUp() {
    key = "AAAABBBBCCCCDDDD";
  }

  @Test
  public void encrypt_OK() {
    String text = "text";

    String encodedText = PasswordUtils.encrypt(text, key);

    assertEquals(encodedText, "xrNYHo+l5yI=");
  }

  @Test
  public void encrypt_nullString() {
    String encodedText = PasswordUtils.encrypt(null, key);

    assertEquals(encodedText, "");
  }

  @Test
  public void encrypt_emptyString() {
    String encodedText = PasswordUtils.encrypt("", key);

    assertEquals(encodedText, "");
  }

  @Test
  public void encrypt_symbolsOnly() {
    String encodedText = PasswordUtils.encrypt("!@#$%^&", key);

    assertEquals(encodedText, "06jYnwt1erw=");
  }

  @Test
  public void decrypt_OK() {
    String encodedText = "xrNYHo+l5yI=";

    String text = PasswordUtils.decrypt(encodedText, key);

    assertEquals(text, "text");
  }

  @Test
  public void decrypt_nullString() {
    String text = PasswordUtils.decrypt(null, key);

    assertEquals(text, "");
  }

  @Test
  public void decrypt_emptyString() {
    String text = PasswordUtils.decrypt("", key);

    assertEquals(text, "");
  }

  @Test
  public void decrypt_symbolsOnly() {
    String encodedText = PasswordUtils.decrypt("06jYnwt1erw=", key);

    assertEquals(encodedText, "!@#$%^&");
  }

  @Test
  public void generatePassword_withSymbols() {
    String password = PasswordUtils.randomPassword();

    assertNotNull(password);
    assertEquals(password.length(), 20);
  }
}