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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrderValues = new LinkedList<>();
        
        zigzagLevelOrderDfs(root, 0, zigzagLevelOrderValues);
        
        return zigzagLevelOrderValues;
    }
    
    private void zigzagLevelOrderDfs(TreeNode node, int level, 
                                     List<List<Integer>> zigzagLevelOrderValues) {
        
        if(node == null) {
            return;
        }
        if(zigzagLevelOrderValues.size() == level) {
            zigzagLevelOrderValues.add(new LinkedList<>());
        }
        
        if((level &1) == 0) {
            zigzagLevelOrderValues.get(level).addLast(node.val);
        } else {
            zigzagLevelOrderValues.get(level).addFirst(node.val);
        }
        
        zigzagLevelOrderDfs(node.left, level +1, zigzagLevelOrderValues);
        zigzagLevelOrderDfs(node.right, level +1, zigzagLevelOrderValues);
        
    }
    
}