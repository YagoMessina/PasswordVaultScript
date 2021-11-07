package com.Super.entity;

import com.Super.util.PasswordUtils;

class Password {

  private final String password;

  private final String key;

  Password(String password) {
    this.key = PasswordUtils.generateKey();
    this.password = PasswordUtils.encrypt(password, key);
  }

  Password(String password, String key) {
    this.key = key;
    this.password = password;
  }

  String getKey() {
    return key;
  }

  String encrypted() {
    return password;
  }

  String decrypted() {
    return PasswordUtils.decrypt(password, key);
  }
}
