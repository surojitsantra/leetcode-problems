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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        getHeight(root, maxDiameter);
        
        return maxDiameter[0];
    }
    
    private int getHeight(TreeNode node, int[] maxDiameter) {
        if(node == null) return 0;
        int leftTreeHeight = getHeight(node.left, maxDiameter);
        int rightTreeHeight = getHeight(node.right, maxDiameter);
        
        maxDiameter[0] = Math.max(maxDiameter[0], leftTreeHeight +rightTreeHeight);
        
        return Math.max(leftTreeHeight, rightTreeHeight) +1;
        
    }
    
}