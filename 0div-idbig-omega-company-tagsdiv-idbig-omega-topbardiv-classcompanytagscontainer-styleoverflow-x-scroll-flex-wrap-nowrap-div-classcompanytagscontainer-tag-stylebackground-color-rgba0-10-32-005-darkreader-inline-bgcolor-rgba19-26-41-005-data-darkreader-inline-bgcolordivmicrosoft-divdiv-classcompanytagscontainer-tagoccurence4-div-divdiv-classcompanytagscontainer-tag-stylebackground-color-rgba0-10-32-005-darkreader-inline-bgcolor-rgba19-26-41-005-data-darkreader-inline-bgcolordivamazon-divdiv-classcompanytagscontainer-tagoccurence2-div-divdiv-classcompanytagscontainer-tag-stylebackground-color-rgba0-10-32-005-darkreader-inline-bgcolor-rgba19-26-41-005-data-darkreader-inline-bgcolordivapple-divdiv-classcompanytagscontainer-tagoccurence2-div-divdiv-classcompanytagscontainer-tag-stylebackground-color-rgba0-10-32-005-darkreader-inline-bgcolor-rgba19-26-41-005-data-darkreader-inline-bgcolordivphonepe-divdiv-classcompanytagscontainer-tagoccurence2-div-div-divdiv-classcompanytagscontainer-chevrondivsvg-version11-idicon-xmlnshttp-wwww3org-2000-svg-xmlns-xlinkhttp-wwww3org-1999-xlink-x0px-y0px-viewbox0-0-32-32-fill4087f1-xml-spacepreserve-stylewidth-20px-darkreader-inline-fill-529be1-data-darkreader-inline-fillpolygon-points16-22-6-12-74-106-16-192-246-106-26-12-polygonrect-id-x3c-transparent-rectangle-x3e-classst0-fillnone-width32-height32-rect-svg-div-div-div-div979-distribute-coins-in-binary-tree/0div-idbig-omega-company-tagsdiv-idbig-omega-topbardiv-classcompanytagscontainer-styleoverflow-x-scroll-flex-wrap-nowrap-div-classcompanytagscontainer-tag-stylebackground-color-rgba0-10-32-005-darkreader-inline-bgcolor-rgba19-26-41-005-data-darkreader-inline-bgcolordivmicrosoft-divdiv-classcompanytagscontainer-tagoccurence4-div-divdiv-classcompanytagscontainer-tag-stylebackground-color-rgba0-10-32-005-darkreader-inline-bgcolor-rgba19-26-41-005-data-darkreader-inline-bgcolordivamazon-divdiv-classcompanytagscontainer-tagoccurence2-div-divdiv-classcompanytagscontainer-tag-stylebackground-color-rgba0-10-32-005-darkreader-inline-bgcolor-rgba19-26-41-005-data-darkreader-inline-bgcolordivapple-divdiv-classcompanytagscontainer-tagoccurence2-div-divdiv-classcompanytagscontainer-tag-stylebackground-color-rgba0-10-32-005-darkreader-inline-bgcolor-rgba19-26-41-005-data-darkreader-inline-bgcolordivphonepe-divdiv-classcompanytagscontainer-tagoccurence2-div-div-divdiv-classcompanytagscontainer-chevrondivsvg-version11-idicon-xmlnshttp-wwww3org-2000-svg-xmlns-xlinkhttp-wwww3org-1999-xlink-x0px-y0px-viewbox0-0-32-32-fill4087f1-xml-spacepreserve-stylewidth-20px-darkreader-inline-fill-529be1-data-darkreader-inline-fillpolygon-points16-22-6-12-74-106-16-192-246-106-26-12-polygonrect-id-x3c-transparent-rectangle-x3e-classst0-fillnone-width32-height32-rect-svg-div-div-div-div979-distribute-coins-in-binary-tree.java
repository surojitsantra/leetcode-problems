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
    
    private int totalMoves = 0;
    
    public int distributeCoins(TreeNode root) {
        totalMoves(root);
        return totalMoves;
    }
    
    private int totalMoves(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int leftExtraCoins = totalMoves(node.left);
        int rightExtraCoins = totalMoves(node.right);
        
        totalMoves += Math.abs(leftExtraCoins) +Math.abs(rightExtraCoins);
        
        return (node.val -1) +leftExtraCoins +rightExtraCoins;
    }
}