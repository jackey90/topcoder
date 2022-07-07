package org.jackey.datastructure.tree;

import org.jackey.support.Assert;

public class BST<T extends Comparable<T>> extends BT<T> {

    public BST(){
        this.setRoot(null);
    }

    public boolean isEmpty(){
        return this.getRoot() == null;
    }

    public void add(T value){
        BTNode newNode = add(value,this.getRoot());
        if(this.getRoot() == null){
            setRoot(newNode);
        }
    }

    public void delete(T value){
        delete(value,getRoot());
    }

    /**
     *
     * @param value
     * @param node
     * @return node after deleted value
     */
    private BTNode<T>  delete(T value, BTNode<T> node){
        Assert.check(value != null, "value can not be null");
        if(node == null){
            return null;
        }
        BTNode<T> root = node;
        int compare = value.compareTo(root.element);
        if(compare < 0){
            root.left  = delete(value,root.left);
        }else if(compare > 0){
            root.right = delete(value,root.right);
        }else if(root.left == null && root.right == null){
            root =  null;
        }else if(root.left != null && root.right != null){
            root.element = findMin(root.right).element;
            root.right = delete(root.element,root.right);
        }else{
            root = root.left != null ? root.left : root.right;
        }
        return root;
    }

    /**
     *
     * @param value
     * @param node
     * @return
     */
    private BTNode<T> add(T value, BTNode<T> node){
        Assert.check(value != null , "value can not be null");
        BTNode<T> root = node;
        if(root == null){
            return new BTNode(value);
        }
        int compare = value.compareTo(node.element);
        if(compare == 0){
            // nothing;
        }else if(compare < 0){
            node.left = add(value,node.left);
        }else{
            node.right = add(value,node.right);
        }
        return node;
    }

    public boolean contains(T value, BTNode<T> node){
        BTNode<T> root = node;
        if(value == null || root == null || root.element == null){
            return false;
        }
        int compare = value.compareTo(node.element);
        if(compare == 0){
            return true;
        }else if(compare > 0){
            return contains(value,node.right);
        }else{
            return contains(value,node.left);
        }
    }

    public BTNode<T> findMax(BTNode<T> node){
        if(node == null){
            return null;
        }
        BTNode<T> ret = node;
        while(ret.right != null){
            ret = ret.right;
        }
        return ret;
    }

    public BTNode<T> findMin(BTNode<T> node){
        if(node == null){
            return null;
        }
        BTNode<T> ret = node;
        while(ret.left != null){
            ret = ret.left;
        }
        return ret;
    }

    

}


