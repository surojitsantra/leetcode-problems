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
    
    private static class NodeInfo {
        public int height;
        public boolean balance;

        public NodeInfo(int height, boolean balance) {
            this.height = height;
            this.balance = balance;
        }

    }
    
    public boolean isBalanced(TreeNode root) {
        NodeInfo node = getBalanceInfo(root);
        return node.balance;
    }
    
    private NodeInfo getBalanceInfo(TreeNode node) {
        if(node == null) {
            return new NodeInfo(0, true);
        }
        
        NodeInfo leftTree = getBalanceInfo(node.left);
        if(!leftTree.balance) return leftTree;
        
        NodeInfo rightTree = getBalanceInfo(node.right);
        if(!rightTree.balance) return rightTree;
        
        int currHeight = Math.max(leftTree.height, rightTree.height) +1;
        boolean balance = (Math.abs(leftTree.height -rightTree.height) <= 1);
        
        return new NodeInfo(currHeight, balance);
        
    }
    
}