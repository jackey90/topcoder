package org.jackey.datastructure.common;

import java.util.HashMap;
import java.util.Map;

class LRUCache {


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(1,0);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }

    private Map<Integer,Node> map = new HashMap();
    private int capacity;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        //capacity should >= 1
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public int get(int key) {
        Node node = getNode(key);
        if(node == null){
            return -1;
        }
        return node.val;
    }

    private Node getNode(int key){
        Node node = map.get(key);
        if(node == null){
            return null;
        }
        removeNode(node);
        addToHead(node);
        return node;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null){
            if(node.val != value){
                node.val = value;
            }
            return;
        }
        node = new Node(key,value);
        map.put(key,node);
        addToHead(node);
        size++;
        if(size > capacity){
            removeTail();
        }
    }

    private void removeTail(){
        Node last = tail.pre;
        map.remove(last.key);
        removeNode(last);
        --size;
    }

    /**
     *   head  ->  1   -> tail
     *   head  <-  1   <- tail
     * @param node
     */
    private void addToHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(){

        }

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

