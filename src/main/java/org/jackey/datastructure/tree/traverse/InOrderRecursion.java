package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

public class InOrderRecursion<T> extends AbstractTreeTraverse<T>{

    @Override
    public void traverse(BTNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        sb.append(node.element + SPACE);
        traverse(node.right);
    }
}
