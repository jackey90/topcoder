package org.jackey.test;

public interface Job {

    void add(Task task, Task dependency);


    boolean hasNext();

    void doNext();

}
