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

class NodeInfo {
    public int childs, sum;
    public NodeInfo(int childs, int sum) {
        this.childs = childs;
        this.sum = sum;
    }
}

class Solution {
    private int ans = 0;
    
    public int averageOfSubtree(TreeNode root) {
        findAverageOfSubtree(root);
        return ans;
    }
    
    private NodeInfo findAverageOfSubtree(TreeNode node) {
        if(node == null) return new NodeInfo(0, 0);
        
        NodeInfo leftSubtreeInfo = findAverageOfSubtree(node.left);
        NodeInfo rightSubtreeInfo = findAverageOfSubtree(node.right);
        
        int sum = node.val +leftSubtreeInfo.sum +rightSubtreeInfo.sum;
        int count = 1 +leftSubtreeInfo.childs +rightSubtreeInfo.childs;
        
        int avg = (int)(Math.round((double)sum) /count);
        if(avg == node.val) ans++;
        
        return new NodeInfo(count, sum);
        
    }
}