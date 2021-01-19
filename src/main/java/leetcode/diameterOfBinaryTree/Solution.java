package leetcode.diameterOfBinaryTree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfTree = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                longestPathOnCurrentNode(root);
            }
        }
        return diameterOfTree;

    }

    public int longestPathOnCurrentNode(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                if (diameterOfTree == 0) diameterOfTree = 1;
                return 1;
            } else {
                int rightPath = longestPathOnCurrentNode(node.right);
                int leftPath = longestPathOnCurrentNode(node.left);
                if (diameterOfTree < rightPath + leftPath) diameterOfTree = rightPath + leftPath;
                return Math.max(rightPath, leftPath) + 1;
            }
        } else {
            return 0;
        }
    }
}
