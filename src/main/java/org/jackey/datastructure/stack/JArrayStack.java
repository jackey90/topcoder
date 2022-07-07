package org.jackey.datastructure.stack;


import org.jackey.support.Assert;

import java.util.Arrays;

public class JArrayStack<T> implements JStack<T>{

    private T[] array;
    private int top;

    public JArrayStack(int capacity){
        array = (T[]) new Object[capacity];
        top = -1;
    }

    public JArrayStack(){
        this(4);
    }

    @Override
    public void push(T element) {
        if(!checkCapacity()){
            enlarge();
        }
        array[++top] = element;
    }

    @Override
    public T pop() {
        Assert.check(top >= 0, "no element!");
        T t = array[top];
        array[top] = null;
        top--;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    private boolean checkCapacity(){
        if(top > array.length / 2){
            return false;
        }
        return true;
    }

    private void enlarge(){
        array = Arrays.copyOf(array, array.length << 1);
    }

    @Override
    public T top() {
        Assert.check(top >= 0, "no element!");
        return array[top];
    }
}
