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
    String minString = "";
    public String smallestFromLeaf(TreeNode root) {
        smallestString(root, "");
        return minString;
    }
    
    private void smallestString(TreeNode node, String currString) {
        if(node == null) {
            return;
        }
        
        currString = (char) (node.val + 'a') +currString;
        
        if (node.left == null && node. right == null && (minString.isEmpty() || minString.compareTo(currString) > 0)) {
            minString = currString;
        }
        
        smallestString(node.left, currString);
        smallestString(node.right, currString);
    }
}