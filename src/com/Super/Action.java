package com.Super;

import com.Super.entity.Registry;
import com.Super.util.ClipboardUtils;
import com.Super.util.PasswordUtils;

public enum Action {
  SET{
    @Override
    public void execute(String[] args) {
      String name = args[1].toUpperCase();
      String password = args[2];

      if (password.equals("--random") || password.equals("--r")) {
        password = PasswordUtils.randomPassword();
      }

      Registry registry = new Registry(name, password);
      repository.save(registry);
    }
  },
  GET{
    @Override
    public void execute(String[] args) {
      String name = args[1].toUpperCase();
      Registry registry = repository.search(name);
      if (registry != null) {
        ClipboardUtils.copyToClipboard(registry.getPasswordDecrypted());
        System.out.println("Copiada al portapapeles! :)");
      } else {
        System.out.println("No se encontró la contraseña :_(");
      }
    }
  };

  private static final Repository repository = new Repository();

  public static Action toAction (String value) {
    try {
      return Action.valueOf(value);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }

  public abstract void execute(String[] args);
}
