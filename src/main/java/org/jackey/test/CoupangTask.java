package org.jackey.test;

public class CoupangTask implements Task{

    private String name;

    public CoupangTask(String name){
        this.name = name;
    }

    @Override
    public void doTask() {
        System.out.println(name);
    }
}
