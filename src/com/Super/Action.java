package com.Super;

import com.Super.entity.Password;
import com.Super.util.ClipboardUtils;

public enum Action {
    SET{
        @Override
        public void execute(String[] args, Repository repository) {
            String name = args[1].toUpperCase();
            String password = args[2];
            repository.save(name, new Password(password, true));
        }
    },
    GET{
        @Override
        public void execute(String[] args, Repository repository) {
            String name = args[1].toUpperCase();
            Password password = repository.search(name);
            if (password != null) {
                ClipboardUtils.copyToClipboard(password.getDecrypted());
                System.out.println("Copiada al portapapeles! :)");
            } else {
                System.out.println("No se encontró la contraseña :_(");
            }
        }
    };

    public static Action toAction (String value) {
        try {
            return Action.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public abstract void execute(String[] args, Repository repository);
}
