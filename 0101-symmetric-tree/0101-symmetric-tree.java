/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null && rightTree == null) return true;
        if(leftTree == null || rightTree == null) return false;
        if(leftTree.val != rightTree.val) return false;
        
        return isSymmetric(leftTree.left, rightTree.right)
            && isSymmetric(leftTree.right, rightTree.left);
    }
}