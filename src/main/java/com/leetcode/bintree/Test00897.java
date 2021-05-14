package com.leetcode.bintree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Description: 递增顺序搜索树
 * <p>
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * @author 10014994
 * @since 2021/4/25
 */
public class Test00897 {

    public static void main(String[] args) {
        TreeNode treeNode_5 = new TreeNode(5);
        TreeNode treeNode_3 = new TreeNode(3);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_4 = new TreeNode(4);
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_6 = new TreeNode(6);
        TreeNode treeNode_8 = new TreeNode(8);
        TreeNode treeNode_7 = new TreeNode(7);
        TreeNode treeNode_9 = new TreeNode(9);
        treeNode_5.left = treeNode_3;
        treeNode_3.left = treeNode_2;
        treeNode_3.right = treeNode_4;
        treeNode_2.left = treeNode_1;
        treeNode_5.right = treeNode_6;
        treeNode_6.right = treeNode_8;
        treeNode_8.left = treeNode_7;
        treeNode_8.right = treeNode_9;
        System.out.println(new Test00897().increasingBST(treeNode_5));
    }

    public TreeNode increasingBST(TreeNode root) {

        List<TreeNode> result = new ArrayList<>();
        middle(root, result);
        TreeNode resultTreeNode = result.get(0);
        TreeNode ref = resultTreeNode;
        for (int i = 1; i < result.size(); i++) {
            ref.right = result.get(i);
            ref = result.get(i);
        }
        return resultTreeNode;
    }

    private void middle(TreeNode root, List<TreeNode> rootList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            middle(root.left, rootList);
        }
        // 当前节点
        rootList.add(new TreeNode(root.val));
        if (root.right != null) {
            middle(root.right, rootList);
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
