/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        int val = root.val;
        int pVal = p.val;
        int qVal = q.val;
        
        if(val == pVal) {
            return p;
        }
        if(val == qVal) {
            return q;
        }
        if(Math.min(pVal, qVal) <= val && val <= Math.max(pVal, qVal)) {
            return root;
        } else if(Math.min(pVal, qVal) > val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
        
    }
}