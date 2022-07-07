package org.jackey.support;

public class Assert {

    public static void check(boolean condition, String message){
        if(!condition){
            throw new RuntimeException(message);
        }
    }

}
