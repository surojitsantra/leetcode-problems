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
        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrderDfs(root, 0, levelOrder);
        
        return levelOrder;
    }
    
    private void levelOrderDfs(TreeNode node, int level, 
                               List<List<Integer>> levelOrder) {
        if(node == null) {
            return;
        }
        if(level == levelOrder.size()) {
            levelOrder.add(new ArrayList<>());
        }
        levelOrder.get(level).add(node.val);
        
        levelOrderDfs(node.left, level +1, levelOrder);
        levelOrderDfs(node.right, level +1, levelOrder);
    }
    
}