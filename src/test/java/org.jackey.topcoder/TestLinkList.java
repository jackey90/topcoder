package org.jackey.topcoder;

import java.util.ArrayList;
import java.util.List;

public class TestLinkList {


    /**
     *
     * 123 456 789
     * 321 456 789
     * 321 654 789
     *
     * @param node
     * @param k
     */
    public void reverseKList(Node node, int k){
        List<Node> list = new ArrayList<Node>();
        int i = 0;
        Node EMPTY = new Node();
        Node head = EMPTY;
        while(node != null){
            Node thisNode = node;
            node = node.next;
            thisNode.pre = null;
            thisNode.next = null;
            list.add(thisNode);
            i++;
            if(i == k || node == null){
                Node[] reverse =  reverseList(list);
                head.next = reverse[0];
                reverse[0].pre = head;
                if(node != null){
                    reverse[1].next = node;
                    node.pre = reverse[1];
                }
                i = 0;
                list.clear();
                head = reverse[1];
            }
        }
    }

    /**
     * 返回拼接后的头尾结点
     * @param list
     * @return
     */
    private Node[] reverseList(List<Node> list){
        return null;
    }


    class Node{
        int val;
        Node pre;
        Node next;

        public Node(){

        }

        public Node(int val){
            this.val = val;
        }
    }

}
