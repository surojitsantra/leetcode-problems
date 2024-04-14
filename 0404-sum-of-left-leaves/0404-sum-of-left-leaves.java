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
    public int sumOfLeftLeaves(TreeNode root) {
        return lefLeavesSum(root, false);
    }
    
    private int lefLeavesSum(TreeNode node, boolean isLeftLeaves) {
        if(node == null) return 0;
        
        if(isLeftLeaves && node.left == null && node.right == null) {
            return node.val;
        }
        
        int leftSubtreeSum = lefLeavesSum(node.left, true);
        int rightSubtreeSum = lefLeavesSum(node.right, false);
        
        return leftSubtreeSum +rightSubtreeSum;
        
    }
}