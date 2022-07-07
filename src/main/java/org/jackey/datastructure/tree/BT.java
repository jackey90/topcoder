package org.jackey.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class BT<T> {

    private BTNode<T> root;

    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> root) {
        this.root = root;
    }


    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return toString(sb,getRoot());
    }


    private String toString(StringBuilder sb, BTNode<T> node){
        List<List<BTNode<T>>> all = new ArrayList<List<BTNode<T>>>();
        List<BTNode<T>> list = new ArrayList<BTNode<T>>();
        list.add(node);
        while(!list.isEmpty()){
            all.add(list);
            list = collectChild(list);
        }
        int range = 3;
        for(int i = all.size() - 1; i >= 0; i--){
            List<BTNode<T>> oneList = all.get(i);
            StringBuilder s = new StringBuilder();
            for(int j = 0 ; j < oneList.size(); j++){
                for(int r = 0; r < range; r++){
                    s.append(" ");
                }
                s.append(oneList.get(j).toString());
                for(int r = 0; r < range; r++){
                    s.append(" ");
                }
                s.append(" ");// for upper
            }
            s.append("\n");
            sb.insert(0, s.toString());
            range = 2 * range  + 1;
        }
        return sb.toString();
    }

    private List<BTNode<T>> collectChild(List<BTNode<T>> parents){
        List<BTNode<T>> result = new ArrayList();
        boolean allNil = true;
        for(BTNode parentNode: parents){
            if(parentNode == BTNode.NIL_NODE){
                result.add(BTNode.NIL_NODE);
                result.add(BTNode.NIL_NODE);
            }else{
                BTNode left = parentNode.left == null ? BTNode.NIL_NODE : parentNode.left;
                BTNode right = parentNode.right == null ? BTNode.NIL_NODE : parentNode.right;
                if(left != BTNode.NIL_NODE){
                    allNil = false;
                }
                if(right != BTNode.NIL_NODE){
                    allNil = false;
                }
                result.add(left);
                result.add(right);
            }
        }
        if(allNil){
            return new ArrayList();
        }
        return result;
    }
}
