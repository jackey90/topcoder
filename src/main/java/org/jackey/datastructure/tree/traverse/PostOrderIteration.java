package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderIteration<T> extends AbstractTreeTraverse<T>{

    @Override
    protected void traverse(BTNode<T> node) {
        Deque<BTNode> stack1 = new ArrayDeque<>();
        Deque<BTNode> stack2 = new ArrayDeque<>();
        stack1.offerFirst(node);
        while(!stack1.isEmpty()){
            BTNode popNode = stack1.pollFirst();
            stack2.offerFirst(popNode);
            if(popNode.left != null){
                stack1.offerFirst(popNode.left);
            }
            if(popNode.right != null){
                stack1.offerFirst(popNode.right);
            }
        }

        while(!stack2.isEmpty()){
            sb.append(stack2.pollFirst().element).append(SPACE);
        }
    }
}
