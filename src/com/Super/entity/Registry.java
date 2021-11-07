package com.Super.entity;

public class Registry {

  private static final String SEPARATOR = ";:;";

  private final String name;

  private final Password password;

  public Registry(String name, String password) {
    this.name = name;
    this.password = new Password(password);
  }

  public Registry(String name, String password, String key) {
    this.name = name;
    this.password = new Password(password, key);
  }

  public static Registry fromString(String str) {
    String[] values = str.split(SEPARATOR);
    return new Registry(values[0], values[1], values[2]);
  }

  public String getName() {
    return name;
  }

  public String getPasswordEncrypted() {
    return password.encrypted();
  }

  public String getPasswordDecrypted() {
    return password.decrypted();
  }

  @Override
  public String toString() {
    return name + SEPARATOR + getPasswordEncrypted() +
      SEPARATOR + password.getKey();
  }
}
