package com.Super;

import com.Super.entity.Password;
import org.omg.CORBA.RepositoryIdHelper;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        String p1 = args[0];
//        String p2 = args[1];
//        String p3 = args[2];
//        p1 = p1.toUpperCase();
//        if(p1.equals(Action.SET.name())) {
//
//        }else if (p1.equals(Action.GET.name())) {
//
//        }
        Repository repository = new Repository();
        repository.save("sda", new Password("asd"));
    }
}
