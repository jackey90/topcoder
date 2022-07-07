package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderIteration<T> extends AbstractTreeTraverse<T>{


    @Override
    public void traverse(BTNode<T> node){
        Deque<BTNode> stack = new ArrayDeque<BTNode>();
        BTNode<T> cur = node;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                sb.append(cur.element + SPACE);
                stack.offerFirst(cur);
                cur = cur.left;
            }
            System.out.println(stack);
            cur = stack.pollFirst().right;
        }
    }
}
