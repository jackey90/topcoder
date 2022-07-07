package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrderIteration<T> extends AbstractTreeTraverse<T>{


    @Override
    protected void traverse(BTNode<T> node) {
        Deque<BTNode> stack = new ArrayDeque<>();
        BTNode cur = node;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }
            System.out.println(stack);
            BTNode popNode = stack.pollFirst();
            sb.append(popNode.element).append(SPACE);
            cur = popNode.right;
        }
    }
}
