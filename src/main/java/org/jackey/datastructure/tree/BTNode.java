package org.jackey.datastructure.tree;

public class BTNode<T> {

     public T element;
     public BTNode<T> left;
     public BTNode<T> right;

    public BTNode(T element){
        this.element = element;
    }

    public BTNode(T element, BTNode<T> left, BTNode<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        if(element == null){
            return "*";
        }
        return element.toString();
    }

    public static final BTNode NIL_NODE = new BTNode(null);
}
