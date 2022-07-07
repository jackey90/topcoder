package org.jackey.leetcode.hard;

import org.jackey.datastructure.tree.BT;
import org.jackey.datastructure.tree.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CodecBST {


    private final BTNode<Integer> EMPTY = new BTNode<Integer>(Integer.MAX_VALUE);
    public static void main(String[] args) {
        BTNode<Integer> node1 = new BTNode<Integer>(1);
        BTNode<Integer> node2 = new BTNode<Integer>(2);
        BTNode<Integer> node3 = new BTNode<Integer>(3);
        BTNode<Integer> node4 = new BTNode<Integer>(4);
        BTNode<Integer> node5 = new BTNode<Integer>(5);
        BTNode<Integer> node6 = new BTNode<Integer>(6);
        BTNode<Integer> node7 = new BTNode<Integer>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node4.left = node6;
        node4.right = node7;
        BT bt1 = new BT();
        bt1.setRoot(node1);
        System.out.println(bt1);
        CodecBST codecBST = new CodecBST();
        String str = codecBST.serialize(node1);
        System.out.println(str);
        BTNode<Integer> btNode = codecBST.deserialize(str);
        BT bt2 = new BT();
        bt2.setRoot(btNode);
        System.out.println(bt2);
        AtomicInteger ai = new AtomicInteger();
        ai.addAndGet(1);
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        ReentrantReadWriteLock readWriteLock;
    }


    public String serialize(BTNode<Integer> root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return sb.toString();
        }
        Deque<BTNode<Integer>> queue = new ArrayDeque<BTNode<Integer>>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            BTNode<Integer> node = queue.pollFirst();
            if(node == EMPTY){
                sb.append("N").append(",");
                continue;
            }else{
                sb.append(node.element).append(",");
            }
            BTNode<Integer> l = node.left == null ? EMPTY : node.left;
            BTNode<Integer> r = node.right == null ? EMPTY : node.right;
            queue.offerLast(l);
            queue.offerLast(r);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public BTNode<Integer> deserialize(String str){
        String[] array = str.split(",");
        int i = 0;
        int n = array.length;
        BTNode<Integer> root = getNode(array,i);
        Deque<BTNode<Integer>> queue = new ArrayDeque<BTNode<Integer>>();
        queue.offerLast(root);
        for(i = 1; i < n - 1; i += 2){
            BTNode<Integer> node = queue.pollFirst();
            node.left = getNode(array,i);
            node.right = getNode(array,i + 1);
            if(node.left != EMPTY){
                queue.offerLast(node.left);
            }
            if(node.right != EMPTY){
                queue.offerLast(node.right);
            }
        }
        return root;
    }

    private BTNode<Integer> getNode(String[] array, int i){
        String s = array[i];
        if(s.equals("N")){
            return EMPTY;
        }else{
            return new BTNode<Integer>(Integer.valueOf(s));
        }
    }


}
