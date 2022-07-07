package org.jackey.datastructure;

import org.jackey.datastructure.tree.BST;
import org.jackey.datastructure.tree.BT;
import org.jackey.datastructure.tree.BTNode;
import org.jackey.support.Printer;

public class TestBT {

    public static void main(String[] args) {
//        BT<Integer> bt = new BT<Integer>();
//        BTNode<Integer> node1 = new BTNode(1);
//        BTNode<Integer> node2 = new BTNode(2);
//        BTNode<Integer> node3 = new BTNode(3);
//        BTNode<Integer> node4 = new BTNode(4);
//        BTNode<Integer> node5 = new BTNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node4.left = node5;
//        bt.setRoot(node1);
//        Printer.println(bt);

        BST<Integer> bst = new BST();
        bst.add(4);
        bst.add(2);
        bst.add(3);
        bst.add(1);
        bst.add(5);
        bst.add(6);
        Printer.println(bst);
        bst.delete(2);
        Printer.println(bst);
    }

}
