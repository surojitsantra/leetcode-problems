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

    private Stack<TreeNode> st;
    private TreeNode root;
    private boolean isReversed;
        
    public BSTIterator(TreeNode root, boolean isReversed) {
        this.root = root;
        this.st = new Stack<>();
        this.isReversed = isReversed;
        
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        int val = node.val;
        
        if(isReversed) {
            node = node.left;
        } else {
            node = node.right;
        }
        pushAll(node);
        
        return val;
    }
    
    private void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            if(isReversed) {
                node = node.right;
            } else {
                node = node.left;
            }
            
        }
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator itrAsc = new BSTIterator(root, false);
        BSTIterator itrDesc = new BSTIterator(root, true);
        
        int val1 = itrAsc.next();
        int val2 = itrDesc.next();
        while(val1 < val2) {
            
            if(val1 +val2 == k) {
                return true;
            } else if(val1 +val2 < k) {
                val1 = itrAsc.next();
            } else {
                val2 = itrDesc.next();
            }
            
        }
        
        return false;
    }
}