/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return null;
        
        if(node == p || node == q) {
            return node;
        }
        
        if(Math.max(p.val, q.val) < node.val) {
            return lowestCommonAncestor(node.left, p, q);
        }
        if(Math.min(p.val, q.val) > node.val) {
            return lowestCommonAncestor(node.right, p, q);
        }
        
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        
        if(left != null && right != null) {
            return node;
        }
        if(left != null) return left;
        else return right;
    }
    
}