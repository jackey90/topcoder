package org.jackey.datastructure.list;

public class RerverseLinkList {


    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new RerverseLinkList().reverseList(node1);
    }

    public LinkedListNode reverseList(LinkedListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
