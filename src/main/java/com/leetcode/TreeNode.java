package com.leetcode;

public class TreeNode {
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

/**
 * 前序遍历 根-左-右
 * 中序遍历 左-根-右
 * 后续遍历 左-右-根
 */
class Solution {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }



    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}