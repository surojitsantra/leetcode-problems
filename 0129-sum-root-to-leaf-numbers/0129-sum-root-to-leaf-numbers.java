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
    private int currSum = 0;
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        //DFS
        
        this.dfs(root);
        
        return (this.ans);
    }
    
    private void dfs(TreeNode node) {
        currSum = (currSum *10) +node.val;
        if(node.left != null) dfs(node.left);
        if(node.right != null) dfs(node.right);
        
        if(node.left == null && node.right == null) {
            this.ans += this.currSum;
        }
        currSum = currSum /10;
    }
}