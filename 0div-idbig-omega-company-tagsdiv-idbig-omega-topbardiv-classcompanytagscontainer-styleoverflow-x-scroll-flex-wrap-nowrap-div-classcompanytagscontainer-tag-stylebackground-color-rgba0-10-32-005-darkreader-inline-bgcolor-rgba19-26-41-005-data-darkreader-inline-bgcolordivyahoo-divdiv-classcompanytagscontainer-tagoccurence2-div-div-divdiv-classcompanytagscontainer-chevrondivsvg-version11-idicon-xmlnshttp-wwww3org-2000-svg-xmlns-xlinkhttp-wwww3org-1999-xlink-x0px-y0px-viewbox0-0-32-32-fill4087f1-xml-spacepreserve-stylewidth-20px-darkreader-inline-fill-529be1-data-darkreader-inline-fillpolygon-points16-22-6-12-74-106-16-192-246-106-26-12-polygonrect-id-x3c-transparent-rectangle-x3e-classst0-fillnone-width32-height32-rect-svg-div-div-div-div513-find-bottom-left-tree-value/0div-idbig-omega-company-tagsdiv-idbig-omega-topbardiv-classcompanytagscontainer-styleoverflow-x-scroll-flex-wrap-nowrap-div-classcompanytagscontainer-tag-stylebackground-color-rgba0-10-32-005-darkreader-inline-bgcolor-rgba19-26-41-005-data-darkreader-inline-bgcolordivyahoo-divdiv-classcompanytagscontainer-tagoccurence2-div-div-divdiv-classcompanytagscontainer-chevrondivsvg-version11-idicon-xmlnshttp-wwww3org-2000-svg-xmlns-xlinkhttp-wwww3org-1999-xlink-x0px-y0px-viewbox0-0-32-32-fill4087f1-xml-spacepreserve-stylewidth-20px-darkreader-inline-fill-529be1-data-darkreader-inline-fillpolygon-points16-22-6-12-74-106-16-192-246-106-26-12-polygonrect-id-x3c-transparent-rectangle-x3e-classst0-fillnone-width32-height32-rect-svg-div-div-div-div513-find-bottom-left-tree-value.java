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
    int tillMaxHeight = -1;
    int ans = -1;
    
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftMostValue(root, 0);
        return ans;
    }
    
    private void findBottomLeftMostValue(TreeNode node, int height) {
        if(node == null) return;
        if(height > tillMaxHeight) {
            ans = node.val;
            tillMaxHeight = height;
        }
        
        findBottomLeftMostValue(node.left, height +1);
        findBottomLeftMostValue(node.right, height +1);
        
    }
}