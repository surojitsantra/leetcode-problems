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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        
        Set<Integer> toDelete = Arrays.stream(to_delete)
                                       .boxed()
                                       .collect(Collectors.toSet());
        
        if(!toDelete.contains(root.val)) {
            forest.add(root);
        }
        makeForest(root, toDelete, forest);
        
        return forest;
    }
    
    private void makeForest(TreeNode node, Set<Integer> toDelete, List<TreeNode> forest) {
        
        if(node == null) {
            return;
        }
        
        makeForest(node.left, toDelete, forest);
        makeForest(node.right, toDelete, forest);
        
        if(node.left != null && toDelete.contains(node.left.val)) {
            node.left = null;
        }
        if(node.right != null && toDelete.contains(node.right.val)) {
            node.right = null;
        }
        
        if(toDelete.contains(node.val)) {
            if(node.left != null) {
                forest.add(node.left);
            }
            if(node.right != null) {
                forest.add(node.right);
            }
        }
        
    }
}