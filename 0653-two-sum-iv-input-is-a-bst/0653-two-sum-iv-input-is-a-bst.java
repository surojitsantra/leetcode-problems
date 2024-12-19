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
    public boolean findTarget(TreeNode root, int k) {
        return isPresent(root, k, new HashSet<>());
    }
    
    private boolean isPresent(TreeNode node, int k, Set<Integer> nums) {
        if(node == null) return false;
        
        if(nums.contains(k -node.val)) {
            return true;
        }
        
        nums.add(node.val);
        
        return isPresent(node.left, k, nums) || isPresent(node.right, k, nums);
        
    }
    
}