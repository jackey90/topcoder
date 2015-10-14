package main.java.org.jackey.leetcode.easy;


/**
 * Created by jackey90 on 15/10/14.
 * Given two binary trees, write a function to check if they are equal or not.
 * <p/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */


public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null ) {
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
