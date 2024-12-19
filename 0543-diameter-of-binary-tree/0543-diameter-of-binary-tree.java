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
    
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        
        findMaxDiameter(root);
        return maxDiameter;
    }
    
    private int findMaxDiameter(TreeNode node) {
        if(node == null) return 0;
        
        int leftSubtreeHeight = findMaxDiameter(node.left);
        int rightSubtreeHeight = findMaxDiameter(node.right);
        
        maxDiameter = Math.max(maxDiameter, leftSubtreeHeight +rightSubtreeHeight);
        
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) +1;
    }
    
}