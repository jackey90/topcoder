package org.jackey.datastructure.stack;

public interface JStack<T> {

    void push(T element);

    T pop();

    boolean isEmpty();

    T top();
}
