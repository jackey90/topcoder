package org.jackey.datastructure;

import org.jackey.datastructure.queue.JArrayQueue;
import org.jackey.datastructure.queue.JQueue;

public class JQueueTest {

    public static void main(String[] args) {
        JQueue<Integer> jQueue = new JArrayQueue<>();
        System.out.println(jQueue.isEmpty());
        for(int i = 0; i < 3; i++){
            jQueue.enQueue(i);
        }
        for(int i = 0; i < 2; i++){
            System.out.println(jQueue.deQueue());
        }
        for(int i = 0; i < 3; i++){
            jQueue.enQueue(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(jQueue.deQueue());
        }
    }

}
