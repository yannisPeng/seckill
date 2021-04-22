package com.newcoder.entity;

import lombok.Data;

/**
 * Description: 二叉树节点
 *
 * @author 10014994
 * @since 2021/1/8
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
