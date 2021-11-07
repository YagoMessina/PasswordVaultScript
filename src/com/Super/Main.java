package com.Super;

import com.Super.entity.Password;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println();
            System.out.println("Comandos disponibles:");
            System.out.println("set <alias> <contraseña>");
            System.out.println("get <alias>");
            System.exit(0);
        }
        Action action = Action.toAction(args[0].toUpperCase());
        if (action == null) {
            System.out.println("La acción no es válida");
            System.exit(-1);
        }
        action.execute(args, new Repository());
    }
}
