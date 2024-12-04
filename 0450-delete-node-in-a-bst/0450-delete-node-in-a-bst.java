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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    
    private TreeNode delete(TreeNode node, int key) {
        if(node == null) {
            return node;
        }
        if(node.val == key) {
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            } else {
                TreeNode left = node.left;
                TreeNode right = node.right;
                TreeNode extreameLeft = getExtreamLeft(right);
                extreameLeft.left = left;
                
                return right;
            }
        } else {
            if(key <= node.val) {
                node.left = delete(node.left, key);
            } else {
                node.right = delete(node.right, key);
            }
        }
        
        return node;
    }
    
    private TreeNode getExtreamLeft(TreeNode node) {
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }
    
}