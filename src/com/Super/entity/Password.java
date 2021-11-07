package com.Super.entity;

import com.Super.util.PasswordUtils;

public class Password {

  private String password;

  public Password(String password, boolean encrypt) {
    this.password = password;
    if (encrypt) {
      this.password = PasswordUtils.encrypt(password);
    }
  }

  public String getEncrypted() {
    return password;
  }

  public String getDecrypted() {
    return PasswordUtils.decrypt(password);
  }
}
