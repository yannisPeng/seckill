package com.leetcode.bintree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Test00938 {

    public static void main(String[] args) {
        final TreeNode treeNode_10 = new TreeNode(10);
        final TreeNode treeNode_5 = new TreeNode(5);
        final TreeNode treeNode_3 = new TreeNode(3);
        final TreeNode treeNode_7 = new TreeNode(7);
        final TreeNode treeNode_15 = new TreeNode(15);
        final TreeNode treeNode_18 = new TreeNode(18);
        treeNode_10.left = treeNode_5;
        treeNode_10.right = treeNode_15;
        treeNode_5.left = treeNode_3;
        treeNode_5.right = treeNode_7;
        treeNode_15.right = treeNode_18;

        System.out.println(new Test00938().rangeSumBST(treeNode_10, 7, 15));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> numList = new ArrayList<>();
        doTraverse(root, low, high, numList);
        int sum = 0;
        for (Integer num : numList){
            sum += num;
        }
        return sum;
    }

    public void doTraverse(TreeNode root, int low, int high, List<Integer> numList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            doTraverse(root.left, low, high, numList);
        }
        if (root.val >= low && root.val <= high) {
            numList.add(root.val);
        }
        if (root.right != null) {
            doTraverse(root.right, low, high, numList);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
