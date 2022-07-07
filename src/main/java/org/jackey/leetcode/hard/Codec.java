package org.jackey.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Codec {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = new ArrayList();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        node1.children = list1;
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list2 = new ArrayList();
        list2.add(node5);
        list2.add(node6);
        node3.children = list2;
        Codec codec = new Codec();
        String str = codec.serialize(node1);
        Node node = codec.deserialize(str);
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if(root != null){
            sb.append("{");
            sb.append(root.val);
            if(root.children != null && !root.children.isEmpty()){
                sb.append(",");
                sb.append("[");
                for(int i = 0; i < root.children.size(); i++){
                    Node child = root.children.get(i);
                    sb.append(serialize(child));
                    if(i != root.children.size() - 1){
                        sb.append(",");
                    }
                }
                sb.append("]");
            }
            sb.append("}");
        }
        return sb.toString();
    }



    /**

     {1,[{3,[{55,[{1}]},{6,[{8}]}]},{2},{4}]}

     {1,[{1},{2,[{3}]}]}


     */
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null){
            return null;
        }
        Deque<Node> stack = new ArrayDeque();
        Deque<List<Node>> listStack = new ArrayDeque();
        Node cur = null;
        Node last = null;
        List<Node> list = null;
        int i = 0;
        while(i < data.length()){
            char c = data.charAt(i);
            if(c == '{'){
                cur = new Node();
                i++;
            }else if(c == '['){
                i++;
                list = new ArrayList();
                listStack.addFirst(list);
            }else if(isNum(c)){
                String s = c + "";
                while(i < data.length()){
                    i++;
                    c = data.charAt(i);
                    if(isNum(c)){
                        s = s + c;
                    }else{
                        break;
                    }
                }
                cur.val = Integer.valueOf(s);
                stack.addFirst(cur);
            }else if(c == '}'){
                last = stack.removeFirst();
                if(listStack.peekFirst() != null){
                    listStack.peekFirst().add(last);
                }
                cur = stack.peekFirst();
                i++;
            }else if(c == ']'){
                cur.children = listStack.removeFirst();
                i++;
            }else if(c == ','){
                i++;
            }else{
                // throw error
            }
        }
        return last;
    }

    private boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    private int convertInt(char c){
        return (int)(c - '0');
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

