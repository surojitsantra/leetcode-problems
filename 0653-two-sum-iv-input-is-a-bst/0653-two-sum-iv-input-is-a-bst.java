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

class BSTIterator {

    private TreeNode currNode = null;
    private Stack<TreeNode> st = new Stack<>();
    private TreeNode root;
        
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.currNode = root;
    }
    
    public int next() {
        while(currNode != null) {
            st.push(currNode);
            currNode = currNode.left;
        }
        if(st.isEmpty()) return -1;
        
        TreeNode node = st.pop();
        currNode = node.right;
        
        return node.val;
    }
    
    public boolean hasNext() {
        return (currNode != null || !st.isEmpty());
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator itr = new BSTIterator(root);
        Set<Integer> nums = new HashSet<>();
        
        while(itr.hasNext()) {
            int num = itr.next();
            if(nums.contains(k -num)) {
                return true;
            }
            nums.add(num);
        }
        
        return false;
    }
}