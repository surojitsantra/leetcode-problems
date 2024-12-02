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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        
        while(!st.isEmpty() || node != null) {
            if(node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                inorder.add(node.val);
                
                node = node.right;
            }
        }
        
        return inorder;
    }
}