package org.jackey.datastructure.queue;

public interface JQueue<T> {

    void enQueue(T t);

    T deQueue();

    T head();

    boolean isEmpty();

}
