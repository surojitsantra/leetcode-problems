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
    
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        
        findPathSum(root, 0);
        
        return sum;
    }
    
    private void findPathSum(TreeNode node, int number) {
        if(node == null) {
            return;
        }
        
        number = (number *10) +node.val;
        
        if(node.left == null && node.right == null) {
            sum += number;
        }
        
        findPathSum(node.left, number);
        findPathSum(node.right, number);
        
        number = number /10;
        
    }
    
}