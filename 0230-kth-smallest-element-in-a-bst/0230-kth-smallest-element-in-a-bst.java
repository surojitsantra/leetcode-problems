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
    private int kthSmallestNo = -1;
    private int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return kthSmallestNo;
    }
    
    private void findKthSmallest(TreeNode node, int k) {
        if(node == null) return;
        findKthSmallest(node.left, k);
        cnt++;
        if(cnt == k) {
            kthSmallestNo = node.val;
            return;
        }
        findKthSmallest(node.right, k);
    }
}