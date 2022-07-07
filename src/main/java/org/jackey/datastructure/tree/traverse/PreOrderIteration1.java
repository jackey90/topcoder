package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderIteration1<T> extends AbstractTreeTraverse<T>{


    @Override
    protected void traverse(BTNode<T> node) {
        Deque<BTNode> stack = new ArrayDeque<BTNode>();
        stack.offerFirst(node);
        while(!stack.isEmpty()){
            //middle
            node = stack.pollFirst();
            sb.append(node.element).append(SPACE);
            //right
            if(node.right != null){
                stack.offerFirst(node.right);
            }
            //left
            if(node.left != null){
                stack.offerFirst(node.left);
            }
            System.out.println(stack);
        }
    }
}
