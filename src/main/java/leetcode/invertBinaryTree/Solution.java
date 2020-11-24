package leetcode.invertBinaryTree;

import java.util.Objects;

public class Solution {
    class TreeNode {
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

    public TreeNode invertTree(TreeNode root) {
        if (Objects.equals(root,null)) {return null;}
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if ( !(Objects.equals(leftNode,null) && Objects.equals(rightNode, null)) ) {
            return new TreeNode(root.val, invertTree(rightNode), invertTree(leftNode) );
        } else {
            return new TreeNode(root.val);
        }
    }

}