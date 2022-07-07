package org.jackey.datastructure.tree;

public class PrefixTree {

    private Node root;
    private Node startRoot;
    public PrefixTree(){
        this.root = new Node(null);
        this.startRoot = new Node(null);
    }


    public void add(String s){
        Node node = root;
        Node startNode = startRoot;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index= (int)(c - 'a');
            Node next = node.array[index];
            if(next == null){
                next = new Node(c);
                node.array[index] = next;
            }
            Node startNext = startNode.array[index];
            if(startNext == null){
                startNext = new Node(c);
                startNode.array[index] = startNext;
            }
            Node start = startNode.array[26];
            if(start == null){
                start = new Node('.');
                startNode.array[26] = start;
                node.array[26] = start;
            }
            node = next;
            startNode = start;

        }
    }





    class Node{
        boolean isEnd;
        Node[] array;
        Character c;

        public Node(Character c){
            this.c = c;
            array = new Node[27];
            isEnd = false;
        }

    }

}
