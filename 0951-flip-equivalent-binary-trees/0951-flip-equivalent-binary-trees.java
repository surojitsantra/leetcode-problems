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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val) return false;

        TreeNode root1Left = root1.left;
        TreeNode root1Right = root1.right;

        TreeNode root2Left = root2.left;
        TreeNode root2Right = root2.right;

        int root1LeftVal = (root1Left == null)? -1 : root1Left.val;
        int root1RightVal = (root1Right == null)? -1 : root1Right.val;

        int root2LeftVal = (root2Left == null)? -1 : root2Left.val;
        int root2RightVal = (root2Right == null)? -1 : root2Right.val;

        if(root1LeftVal == root2LeftVal && root1RightVal == root2RightVal) {
            return flipEquiv(root1Left, root2Left) && flipEquiv(root1Right, root2Right);
        } else if(root1LeftVal == root2RightVal && root1RightVal == root2LeftVal) {
            return flipEquiv(root1Left, root2Right) && flipEquiv(root1Right, root2Left);
        } else {
            return false;
        }

    }
}