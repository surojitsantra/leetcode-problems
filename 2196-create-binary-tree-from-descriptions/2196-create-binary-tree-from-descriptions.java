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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer, TreeNode> nodesPointer = new HashMap<>();
        Set<Integer> childs = new HashSet<>();
        
        for(int[] description :descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = (description[2] == 1);
            
            TreeNode parentNode = nodesPointer.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = nodesPointer.getOrDefault(child, new TreeNode(child));
            
            if(isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            nodesPointer.putIfAbsent(parent, parentNode);
            nodesPointer.putIfAbsent(child, childNode);
            
            childs.add(child);
        }
        
        for(TreeNode node :nodesPointer.values()) {
            if(!childs.contains(node.val)) {
                return node;
            }
        }
        
        return null;
    }
}