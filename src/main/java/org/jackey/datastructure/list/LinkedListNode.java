package org.jackey.datastructure.list;

public class LinkedListNode {

    int val;
    LinkedListNode next;

    public LinkedListNode(){

    }

    public LinkedListNode(int val){
        this.val = val;
    }

    public LinkedListNode(int val, LinkedListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
