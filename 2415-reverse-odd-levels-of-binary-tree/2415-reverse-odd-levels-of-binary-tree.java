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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> hq = new LinkedList<>();
        hq.add(root);
        
        Stack<Integer> nodeStack = new Stack<>();
        
        int level = 0;
        while(!hq.isEmpty()) {
            int sz = hq.size();
            
            while(sz-- > 0) {
                TreeNode node = hq.poll();
                
                if(level %2 == 0) {
                    if(node.left != null) {
                        nodeStack.push(node.left.val);
                    }
                    if(node.right != null) {
                        nodeStack.push(node.right.val);
                    }
                } else {
                    node.val = nodeStack.pop();
                }
                
                if(node.left != null) {
                    hq.add(node.left);
                }
                if(node.right != null) {
                    hq.add(node.right);
                }
                
            }
            
            level++;
        }
        
        return root;
    }
}