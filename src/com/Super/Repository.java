package com.Super;

import com.Super.entity.Password;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repository {

  private final Path path;

  public Repository() {
    Map<String, String> env = System.getenv();
    File file = new File(env.get("COMMANDS") + "/passwords.txt");
    try {
      file.createNewFile();
    }catch (IOException e) {
      e.printStackTrace();
    }
    path = Paths.get(file.getPath());
  }

  public void save(String name, Password password) {
    String line = name + "," + password.getEncrypted() + "\n";
    try {
      Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.out.println("No se pudo guardar la contraseña de" + name);
    }
  }

  private List<String> read() {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }

  public Password search(String name) {
    List<String> lines = read();
    for (String line : lines) {
      if(line.startsWith(name)){
        int pos = line.indexOf(",") + 1;
        return new Password(line.substring(pos), false);
      }
    }
    return null;
  }
}
