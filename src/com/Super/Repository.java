package com.Super;

import com.Super.entity.Registry;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class Repository {

  private final Path path;

  public Repository() {
    Map<String, String> env = System.getenv();
    File file = new File(env.get("COMMANDS") + "/passwords.dat");
    try {
      file.createNewFile();
    }catch (IOException e) {
      e.printStackTrace();
    }
    path = Paths.get(file.getPath());
  }

  public void save(Registry registry) {
    try {
      OutputStream out = Files.newOutputStream(path, StandardOpenOption.APPEND);
      DataOutputStream outputStream = new DataOutputStream(out);
      outputStream.writeUTF(String.valueOf(registry));
      outputStream.close();
    } catch (IOException e) {
      System.out.println(
        "No se pudo guardar la contraseña de" + registry.getName());
    }
  }

  public Registry search(String name) {
    try (DataInputStream inputStream
           = new DataInputStream(Files.newInputStream(path))) {
      while (inputStream.available() > 0) {
        Registry registry = Registry.fromString(inputStream.readUTF());

        if(registry.getName().equals(name)){
          return registry;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
