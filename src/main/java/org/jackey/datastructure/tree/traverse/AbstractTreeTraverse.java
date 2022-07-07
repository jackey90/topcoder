package org.jackey.datastructure.tree.traverse;

import org.jackey.datastructure.tree.BT;
import org.jackey.datastructure.tree.BTNode;

public abstract class AbstractTreeTraverse<T> implements TreeTraverse<T>{

    StringBuilder sb = new StringBuilder();
    protected String SPACE = "  ";

    @Override
    public void traverse(BT<T> tree) {
        traverse(tree.getRoot());
        System.out.println(sb.toString());
    }

    protected abstract void traverse(BTNode<T> node);
}
