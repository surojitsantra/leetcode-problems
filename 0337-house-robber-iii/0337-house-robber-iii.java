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
    public int rob(TreeNode root) {
        Map<Integer, Integer> dp = new HashMap<>();
        return maxAmount(root, 0, dp);
    }
    
    private int maxAmount(TreeNode node, int pos, Map<Integer, Integer> dp) {
        if(node == null) {
            return 0;
        }
        if(dp.containsKey(pos)) {
            return dp.get(pos);
        }
        
        int ans = 0;
        if(node.left != null) {
            ans += maxAmount(node.left.left, (pos *2 +1) *2 +1, dp) 
                +maxAmount(node.left.right, (pos *2 +1) *2 +2, dp);
        }
        
        if(node.right != null) {
            ans += maxAmount(node.right.left, (pos *2 +2) *2 +1, dp) 
                +maxAmount(node.right.right, (pos *2 +2) *2 +2, dp);
        }
        
        int skipSelf = maxAmount(node.left, pos *2 +1, dp) 
                        +maxAmount(node.right, pos *2 +2, dp);
        int takeSelf = node.val +ans;
        
        dp.put(pos, Math.max(skipSelf, takeSelf));
        
        return Math.max(skipSelf, takeSelf);
        
    }
    
}