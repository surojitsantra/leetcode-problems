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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        
        while(node != null || !st.isEmpty()) {
            if(node != null) {
                postorder.add(node.val);
                st.push(node);
                
                node = node.right;
            } else {
                node = st.pop().left;
            }
        }
        
        Collections.reverse(postorder);
        
        return postorder;
    }
}