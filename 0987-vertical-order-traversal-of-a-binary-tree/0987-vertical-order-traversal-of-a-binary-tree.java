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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> orders = new TreeMap<>();
        
        generateVerticalTraversal(root, 0, 0, orders);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, List<Integer>> rowValues :orders.values()) {
            
            List<Integer> cols = new ArrayList<>();
            for(List<Integer> values :rowValues.values()) {
                Collections.sort(values);
                cols.addAll(values);
            }
            
            ans.add(cols);
        }
        
        return ans;
    }
    
    private void generateVerticalTraversal(TreeNode node, int row, int col,
                                          TreeMap<Integer, TreeMap<Integer, List<Integer>>> orders) {
        
        if(node == null) return;
        orders.putIfAbsent(col, new TreeMap<>());
        orders.get(col).putIfAbsent(row, new ArrayList<>());
        
        orders.get(col).get(row).add(node.val);
        
        generateVerticalTraversal(node.left, row +1, col -1, orders);
        generateVerticalTraversal(node.right, row +1, col +1, orders);
    }
    
}