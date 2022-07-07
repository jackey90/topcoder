package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BTNode;

public class PreOrderRecursion<T> extends AbstractTreeTraverse<T>{

    @Override
    public void traverse(BTNode node){
        if(node == null){
            return;
        }
        sb.append(node.element + SPACE);
        traverse(node.left);
        traverse(node.right);
    }

}
