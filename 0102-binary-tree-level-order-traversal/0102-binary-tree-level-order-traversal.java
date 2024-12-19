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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> hq = new LinkedList<>();
        hq.add(root);
        
        while(!hq.isEmpty()) {
            int sz = hq.size();
            List<Integer> levelNodes = new ArrayList<>();
            
            while(sz-- > 0) {
                TreeNode node = hq.poll();
                levelNodes.add(node.val);
                
                if(node.left != null) {
                    hq.add(node.left);
                }
                if(node.right != null) {
                    hq.add(node.right);
                }
                
            }
            
            ans.add(levelNodes);
        }
        
        
        return ans;
    }
}