package org.jackey.datastructure.tree;

import org.jackey.datastructure.tree.traverse.*;

public class TestTraverse {

    public static void main(String[] args) {
        BT<Integer> bt = new BT<Integer>();
        BTNode<Integer> node1 = new BTNode<Integer>(1);
        bt.setRoot(node1);
        BTNode<Integer> node2 = new BTNode<Integer>(2);
        BTNode<Integer> node3 = new BTNode<Integer>(3);
        node1.left = node2;
        node1.right = node3;
        BTNode<Integer> node4 = new BTNode<Integer>(4);
        BTNode<Integer> node5 = new BTNode<Integer>(5);
        BTNode<Integer> node6 = new BTNode<Integer>(6);
        BTNode<Integer> node7 = new BTNode<Integer>(7);
        BTNode<Integer> node8 = new BTNode<Integer>(8);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.right = node8;
        TreeTraverse<Integer> preTraverse = new PreOrderRecursion<>();
        TreeTraverse<Integer> preTraverseIte = new PreOrderIteration1<>();
        TreeTraverse<Integer> inTraverse = new InOrderRecursion<>();
        TreeTraverse<Integer> inTraverseIte = new InOrderIteration<>();
        TreeTraverse<Integer> postTraverse = new PostOrderRecursion<>();
        TreeTraverse<Integer> postTraverseIte = new PostOrderIteration1<>();
        System.out.println("preTraverse");
        preTraverse.traverse(bt);
        preTraverseIte.traverse(bt);
        System.out.println("inTraverse");
        inTraverse.traverse(bt);
        inTraverseIte.traverse(bt);
        System.out.println("postTraverse");
        postTraverse.traverse(bt);
        postTraverseIte.traverse(bt);
        System.out.println(bt);

    }

}
