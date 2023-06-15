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
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        
        long maxSum = Long.MIN_VALUE;
        int level = 0;
        int curLevel = 0;
        
        while(!levelOrderQueue.isEmpty()) {
            int sz  = levelOrderQueue.size();
            long curSum = 0;
            curLevel++;
            while(sz-- > 0) {
                TreeNode node = levelOrderQueue.poll();
                curSum += node.val;
                if(node.left != null) levelOrderQueue.add(node.left);
                if(node.right != null) levelOrderQueue.add(node.right);
            }
            if(curSum > maxSum) {
                maxSum = curSum;
                level = curLevel;
            }
        }
        
        return level;
    }
}