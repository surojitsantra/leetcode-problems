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
        public TreeNode node;
        public int row, col;
        public NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> order = new TreeMap<>();
        generateVerticalTraversal(new NodeInfo(root, 0, 0), order);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(TreeMap<Integer, List<Integer>> mp :order.values()) {
            List<Integer> list = new ArrayList<>();
            for(List<Integer> nums :mp.values()) {
                Collections.sort(nums);
                list.addAll(nums);
            }
            ans.add(list);
        }
        
        return ans;
        
    }
    
    private void generateVerticalTraversal(NodeInfo nodeInfo, 
                                           TreeMap<Integer, TreeMap<Integer, List<Integer>>> order) {
        if(nodeInfo.node == null) {
            return;
        }
        
        TreeNode node = nodeInfo.node;
        int row = nodeInfo.row;
        int col = nodeInfo.col;
        
        order.putIfAbsent(col, new TreeMap<>());
        order.get(col).putIfAbsent(row, new ArrayList<>());
        order.get(col).get(row).add(node.val);
        
        generateVerticalTraversal(new NodeInfo(node.left, row +1,col -1), order);
        generateVerticalTraversal(new NodeInfo(node.right, row +1, col +1), order);
        
    }
    
}