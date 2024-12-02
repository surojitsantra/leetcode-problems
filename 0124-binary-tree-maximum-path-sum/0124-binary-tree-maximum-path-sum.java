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
    
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        genaratetMaxPathSum(root);
        
        return maxSum;
    }
    
    private int genaratetMaxPathSum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int currNodeVal = node.val;
        int leftSubtree = Math.max(genaratetMaxPathSum(node.left), 0);
        int rightSubtree = Math.max(genaratetMaxPathSum(node.right), 0);
        
        maxSum = Math.max(maxSum, currNodeVal +leftSubtree +rightSubtree);
        
        return Math.max(leftSubtree, rightSubtree) +currNodeVal;
    }
    
}