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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> helperQueue = new LinkedList<>();
        helperQueue.add(root);
        int level = 0;
        
        while(!helperQueue.isEmpty()) {
            int sz = helperQueue.size();
            boolean evenSeries = ((level &1) == 1);
            int prevVal = (evenSeries)? Integer.MAX_VALUE : 0;
            while(sz-- > 0) {
                TreeNode node = helperQueue.poll();
                int val = node.val;
                if(evenSeries && ((val &1) == 1 || prevVal <= val)) return false;
                if(!evenSeries && ((val &1) == 0 || prevVal >= val)) return false;
                
                prevVal = val;
                
                if(node.left != null) helperQueue.add(node.left);
                if(node.right != null) helperQueue.add(node.right);
                
            }
            level++;
        }
        
        return true;
    }
    
}