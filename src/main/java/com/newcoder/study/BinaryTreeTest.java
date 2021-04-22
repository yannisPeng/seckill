package com.newcoder.study;

import com.newcoder.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/2/1
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node9 = new TreeNode(9, null, node10);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, node8, node9);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        // 前序遍历
//        frontIterator(node1);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 1));
        System.out.println(linkedHashSet);

    }

    public static void frontIterator(TreeNode root) {
        if (root != null) {
            System.out.println(root.getVal() + "\t");
            frontIterator(root.getLeft());
            frontIterator(root.getRight());
        }
    }

}
