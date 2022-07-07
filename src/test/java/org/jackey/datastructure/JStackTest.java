package org.jackey.datastructure;

import org.jackey.datastructure.stack.JArrayStack;
import org.jackey.datastructure.stack.JStack;

public class JStackTest {

    public static void main(String[] args) {
        JStack<Integer> jStack = new JArrayStack<>();
        jStack.push(1);
        jStack.push(2);
        jStack.push(3);
        System.out.println(jStack.top());
        System.out.println(jStack.pop());
        jStack.push(4);
        jStack.push(4);
        jStack.push(4);
        jStack.push(4);
        jStack.push(4);
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());
        System.out.println(jStack.pop());

    }

}
