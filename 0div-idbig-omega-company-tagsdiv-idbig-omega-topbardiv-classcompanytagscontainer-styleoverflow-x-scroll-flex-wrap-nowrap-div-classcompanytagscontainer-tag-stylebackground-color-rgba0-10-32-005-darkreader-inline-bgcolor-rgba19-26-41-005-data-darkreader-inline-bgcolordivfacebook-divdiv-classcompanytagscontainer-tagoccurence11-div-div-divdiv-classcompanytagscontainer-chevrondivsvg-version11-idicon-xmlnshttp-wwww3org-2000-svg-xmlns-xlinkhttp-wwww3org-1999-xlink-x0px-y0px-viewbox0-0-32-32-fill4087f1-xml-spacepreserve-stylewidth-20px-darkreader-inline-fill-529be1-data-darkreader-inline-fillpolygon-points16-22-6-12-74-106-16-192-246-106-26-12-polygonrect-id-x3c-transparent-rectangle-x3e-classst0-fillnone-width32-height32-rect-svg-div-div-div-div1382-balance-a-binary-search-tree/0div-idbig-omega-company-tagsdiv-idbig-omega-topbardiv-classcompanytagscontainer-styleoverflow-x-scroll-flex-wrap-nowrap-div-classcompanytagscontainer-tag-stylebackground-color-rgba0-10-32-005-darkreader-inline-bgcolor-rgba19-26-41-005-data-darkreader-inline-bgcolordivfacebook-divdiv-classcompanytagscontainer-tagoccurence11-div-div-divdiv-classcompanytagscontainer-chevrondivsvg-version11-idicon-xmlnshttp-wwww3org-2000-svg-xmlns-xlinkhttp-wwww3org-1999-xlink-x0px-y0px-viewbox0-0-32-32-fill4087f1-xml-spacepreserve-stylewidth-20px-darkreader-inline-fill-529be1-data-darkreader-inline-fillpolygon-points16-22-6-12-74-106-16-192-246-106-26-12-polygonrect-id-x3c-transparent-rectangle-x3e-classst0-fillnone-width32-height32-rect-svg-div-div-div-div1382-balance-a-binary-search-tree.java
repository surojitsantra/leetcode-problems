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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        getAllNums(root, nums);
        
        return bbst(nums, 0, nums.size() -1);
        
    }
    
    private void getAllNums(TreeNode node, List<Integer> nums) {
        if(node == null) {
            return;
        }
        
        getAllNums(node.left, nums);
        nums.add(node.val);
        getAllNums(node.right, nums);
        
    }
    
    private TreeNode bbst(List<Integer> nums, int i, int j) {
        if(i > j) {
            return null;
        }
        int mid = (i +j) /2;
        
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = bbst(nums, i, mid -1);
        node.right = bbst(nums, mid +1, j);
        
        return node;
        
    }
}