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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        buildLargestValueInRow(root, 0, ans);
        
        return ans;
    }
    
    private void buildLargestValueInRow(TreeNode node, int level, List<Integer> ans) {
        if(node == null) {
            return;
        }
        
        if(ans.size() == level) {
            ans.add(node.val);
        }
        
        ans.set(level, (Math.max(node.val, ans.get(level))));
        
        buildLargestValueInRow(node.left, level +1, ans);
        buildLargestValueInRow(node.right, level +1, ans);
    }
    
}