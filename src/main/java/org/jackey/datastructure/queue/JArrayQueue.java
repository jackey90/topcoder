package org.jackey.datastructure.queue;


import org.jackey.support.Assert;

import java.util.Arrays;

public class JArrayQueue<T> implements JQueue<T> {


    private T[] array;
    private int head;
    private int tail;

    public JArrayQueue(int capacity){
        this.array = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public JArrayQueue(){
        this(4);
    }

    @Override
    public void enQueue(T t) {
        if(checkCapacity()){
            grow();
        }
        array[tail] = t;
        if(tail == array.length - 1){
            tail = 0;
        }else{
            tail = tail + 1;
        }
    }

    @Override
    public T deQueue() {
        Assert.check(head != tail,"no element!");
        T t = array[head];
        array[head] = null;
        if(head == array.length - 1){
            head = 0;
        }else{
            head = head + 1;
        }
        return t;
    }

    @Override
    public T head() {
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }


    /**
     *  {0,1,2,3,4,5,6}
     *   h           t
     *  {0,1,2,3,4,5,6}
     *   t h
     *
     * @return
     */
    private boolean checkCapacity(){
        return tail == head - 1 || tail == array.length + head - 1;
    }

    private void grow(){
        int oldLength = this.array.length;
        this.array = Arrays.copyOf(array,array.length << 1);
        if(tail < head){
            // {0,1,2,3}
            //  t   h
            // {0,1,2,3,-,-,-,-}
            //  t
            System.arraycopy(array,head,array,head + array.length - oldLength,oldLength - head);
            int i = head;
            head = head + array.length - oldLength ;
            for(; i < head;i++){
                array[i] = null;
            }
        }
    }

}
