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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftSubtreeHeight = 0;
        TreeNode node = root;
        while(node != null) {
            leftSubtreeHeight++;
            node = node.left;
        }
        
        int rightSubtreeHeight = 0;
        node = root;
        while(node != null) {
            rightSubtreeHeight++;
            node = node.right;
        }
        
        if(leftSubtreeHeight == rightSubtreeHeight) {
            return (1 <<leftSubtreeHeight) -1;
        }
        
        return 1 +countNodes(root.left) +countNodes(root.right);
    }
    
}