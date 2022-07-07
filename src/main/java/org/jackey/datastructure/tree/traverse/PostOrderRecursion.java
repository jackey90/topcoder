package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

public class PostOrderRecursion<T> extends AbstractTreeTraverse<T>{

    @Override
    public void traverse(BTNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        traverse(node.right);
        sb.append(node.element + SPACE);
    }

}
