package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderIteration1<T> extends AbstractTreeTraverse<T>{


    @Override
    protected void traverse(BTNode<T> node) {
        if (node == null) {
            return;
        }
        BTNode cur = node;
        Deque<BTNode> stack = new ArrayDeque<>();
        stack.offerFirst(node);
        while (!stack.isEmpty()) {
            BTNode peek = stack.peekFirst();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.offerFirst(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.offerFirst(peek.right);
            } else {
                sb.append(stack.pollFirst().element).append(SPACE);
                cur = peek;
            }
            System.out.println(stack);
        }
    }
}
