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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final int N = inorder.length;
        
        Map<Integer, Integer> inorderIdx = new HashMap<>();
        for(int i = 0; i < N; i++) {
            inorderIdx.put(inorder[i], i);
        }
        
        return makeTree(preorder, 0, N -1, inorder, 0, N -1, inorderIdx);
        
    }
    
    private TreeNode makeTree(int[] preorder, int preStart, int preEnd, 
                        int[] inorder, int inStart, int inEnd,
                        Map<Integer, Integer> inorderIdx) {
            
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        
        int inRoot = inorderIdx.get(val);
        int numsLeft = inRoot -inStart;
            
        root.left = makeTree(preorder, preStart +1, preStart +numsLeft,
                             inorder, inStart, inRoot -1,
                             inorderIdx);
            
        root.right = makeTree(preorder, preStart +numsLeft +1, preEnd,
                              inorder, inRoot +1, inEnd, 
                              inorderIdx);
            
        return root;         
    }
    
}