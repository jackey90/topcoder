package org.jackey.leetcode.medium;

import org.jackey.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackey90 on 16/9/26.
 */
public class PathSum2 {
    public  List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root==null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        pathSum(root, new ArrayList<Integer>(), sum, result);

        return result;
    }

    private  void pathSum(TreeNode node, List<Integer> list, int sum,  List<List<Integer>> result){
        if(node == null){
            return;
        }
        boolean isLeaf = (node.left == null && node.right == null);
        int val = node.val;
        list.add(val);
        if(val == sum && isLeaf){
            List<Integer> oneResult  = new ArrayList<Integer>();
            oneResult.addAll(list);
            result.add(oneResult);
        } else {
            pathSum(node.left, list, sum - val, result);
            pathSum(node.right, list, sum - val, result);
        }

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(11);
        TreeNode node2  = new TreeNode(2);
        TreeNode node3  = new TreeNode(5);
        TreeNode node4  = new TreeNode(3);
        TreeNode node5  = new TreeNode(8);
        TreeNode node6  = new TreeNode(7);
        TreeNode node7  = new TreeNode(6);
        TreeNode node8  = new TreeNode(11);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node5.setRight(node8);

        System.out.println(new PathSum2().pathSum(node1, 16));

        System.out.println(new PathSum2().pathSum(node8, 11));

        System.out.println(new PathSum2().pathSum(node5, 8));
    }
}
