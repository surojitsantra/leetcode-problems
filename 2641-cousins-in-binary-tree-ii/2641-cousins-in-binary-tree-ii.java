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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> helperQueue = new LinkedList<>();
        List<Integer> levelSums = new ArrayList<>();
        
        helperQueue.add(root);
        while(!helperQueue.isEmpty()) {
            int size = helperQueue.size();
            int levelSum = 0;
            while(size-- > 0) {
                TreeNode node = helperQueue.remove();
                levelSum += node.val;
                
                if(node.left != null) helperQueue.add(node.left);
                if(node.right != null) helperQueue.add(node.right);
                
            }
            levelSums.add(levelSum);
        }
        
        helperQueue.add(root);
        root.val = 0;
        int level = 0;
        while(!helperQueue.isEmpty()) {
            int size = helperQueue.size();
            while(size-- > 0) {
                TreeNode node = helperQueue.remove();
                
                int leftNodeVal = 0;
                int rightNodeVal = 0;
                if(node.left != null) {
                    leftNodeVal = levelSums.get(level +1) -node.left.val;
                    if(node.right != null) leftNodeVal -= node.right.val;
                }
                
                if(node.right != null) {
                    rightNodeVal = levelSums.get(level +1) -node.right.val;
                    if(node.left != null) rightNodeVal -= node.left.val;
                }
                
                if(node.left != null) {
                    node.left.val = leftNodeVal;
                    helperQueue.add(node.left);
                }
                if(node.right != null) {
                    node.right.val = rightNodeVal;
                    helperQueue.add(node.right);
                }
                
            }
            level++;
        }
        
        return root;
    }
}