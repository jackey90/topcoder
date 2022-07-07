package org.jackey.support;

public class Printer {

    public static <T> void println(T[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(T t : array){
            sb.append(t).append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        System.out.println(sb.toString());
    }

    public static <T> void println(T t){
        System.out.println(t.toString());
    }



}
