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
    
    private int maxSum = 0;
    private int maxValue = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum = 0;
        maxValue = Integer.MIN_VALUE;
        genaratetMaxPathSum(root);
        
        if(maxValue < 0) return maxValue;
        return maxSum;
    }
    
    private int genaratetMaxPathSum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int currNodeVal = node.val;
        maxValue = Math.max(maxValue, currNodeVal);
        int leftSubtree = genaratetMaxPathSum(node.left);
        int rightSubtree = genaratetMaxPathSum(node.right);
        
        int bigger = Math.max(leftSubtree, rightSubtree);
        
        int currSum = 0;
        if(bigger > 0) {
            currSum += bigger;
        }
        currSum += currNodeVal;
        
        maxSum = Math.max(maxSum, currSum);
        maxSum = Math.max(maxSum, currNodeVal +leftSubtree +rightSubtree);
        
        return Math.max(currSum, 0);
    }
    
}