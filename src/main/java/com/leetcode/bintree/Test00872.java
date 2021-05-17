package com.leetcode.bintree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 叶子相似的树
 *
 * @author 10014994
 * @since 2021/5/10
 */
public class Test00872 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode1l = new TreeNode(2);
        treeNode1.left = treeNode1l;
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode2l = new TreeNode(2);
        treeNode2.left = treeNode2l;
        System.out.println(new Test00872().leafSimilar(treeNode1, treeNode2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root_1 = new ArrayList<>();
        List<Integer> root_2 = new ArrayList<>();
        findLeaf(root1, root_1);
        findLeaf(root2, root_2);
        if (root_1.size() != root_2.size()) {
            return false;
        }
        for (int i = 0; i < root_1.size(); i++) {
            if (!root_1.get(i).equals(root_2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void findLeaf(TreeNode node, List<Integer> leafList) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            findLeaf(node.left, leafList);
        }
        if(node.left == null &&node.right == null){
            leafList.add(node.val);
        }
        if (node.right != null) {
            findLeaf(node.right, leafList);
        }
    }
}
