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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> helperQueue = new LinkedList<>();
        helperQueue.add(root);
        
        while(!helperQueue.isEmpty() && helperQueue.peek() != null) {
            TreeNode node = helperQueue.poll();
            helperQueue.add(node.left);
            helperQueue.add(node.right);
        }
        
        while(!helperQueue.isEmpty()) {
            TreeNode node = helperQueue.poll();
            if(node != null) return false;
        }
        return true;
    }
}