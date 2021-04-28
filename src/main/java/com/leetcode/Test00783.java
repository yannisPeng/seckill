package com.leetcode;

/**
 * Description: 二叉搜索树节点最小距离
 * <p>
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 10^5
 *
 * 涉及知识点，二叉树遍历
 *
 * @author 10014994
 * @since 2021/4/13
 */
public class Test00783 {

    static class Solution {
        private TreeNode pre = null;   //pre记录前一节点
        private int res = Integer.MAX_VALUE;

        public int minDiffInBST(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (pre != null) {
                res = Math.min(root.val - pre.val, res);   //记录最小
            }
            pre = root;
            dfs(root.right);
        }
    }

    /**
     * 前序遍历 根->左->右
     */
    static class Before{
        public void before(TreeNode treeNode){
            print(treeNode);
        }

        private void print(TreeNode treeNode) {
            if(treeNode == null){
                return;
            }
            System.out.println(treeNode.val);
            if(treeNode.left != null){
                before(treeNode.left);
            }
            if(treeNode.right != null){
                before(treeNode.right);
            }
        }
    }

    /**
     * 中序遍历 左->根->右
     */
    static class Middle{
        public void print(TreeNode treeNode){
            printMiddle(treeNode);
        }

        private void printMiddle(TreeNode treeNode) {
            if(treeNode == null){
                return;
            }
            if(treeNode.left != null){
                printMiddle(treeNode.left);
            }
            System.out.println(treeNode.val);
            if(treeNode.right != null){
                printMiddle(treeNode.right);
            }
        }
    }

    /**
     * 后续遍历 左->右->根
     */
    static class After{
        public void printAfter(TreeNode treeNode){
            if(treeNode == null){
                return;
            }
            if(treeNode.left != null){
                printAfter(treeNode.left);
            }
            if(treeNode.right != null){
                printAfter(treeNode.right);
            }
            System.out.println(treeNode.val);
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        TreeNode root = new TreeNode(4, left, right);

        TreeNode left_1 = new TreeNode(7);
        TreeNode right_1 = new TreeNode(6);
        left.left = left_1;
        left.right = right_1;

        TreeNode left_2 = new TreeNode(3);
        TreeNode right_2 = new TreeNode(2);
        right.left = left_2;
        right.right = right_2;

        new After().printAfter(root);
    }

}


