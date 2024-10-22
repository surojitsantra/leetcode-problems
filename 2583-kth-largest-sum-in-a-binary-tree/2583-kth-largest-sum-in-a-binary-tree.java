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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        Queue<TreeNode> helperQueue = new LinkedList<>();
        helperQueue.add(root);
        
        while(!helperQueue.isEmpty()) {
            int queueSize = helperQueue.size();
            long curSum = 0;
            
            for(int i = 0; i < queueSize; i++) {
                TreeNode node = helperQueue.remove();
                curSum += node.val;
                if(node.left != null) helperQueue.add(node.left);
                if(node.right != null) helperQueue.add(node.right);
            }
            
            minHeap.add(curSum);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        if(minHeap.size() < k) return -1;
        
        return minHeap.peek();
        
    }
}