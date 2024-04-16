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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1) {
            root = new TreeNode(val, root, null);
            return root;
        }
        
        addValueNode(root, val, 1, depth);
        
        return root;
    }
    
    private void addValueNode(TreeNode node, int val, int level, int depth) {
        if(node == null) {
            return;
        }
        
        if(level == depth -1) {
            TreeNode leftSubtree = node.left;
            TreeNode rightSubtree = node.right;
            node.left = new TreeNode(val, leftSubtree, null);
            node.right = new TreeNode(val, null, rightSubtree);
            return;
        }
        
        addOneRow(node.left, val, depth -1);
        addOneRow(node.right, val, depth -1);
    }
}