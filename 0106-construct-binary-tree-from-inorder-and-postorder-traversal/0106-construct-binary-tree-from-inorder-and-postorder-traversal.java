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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final int N = inorder.length;
        Map<Integer, Integer> numToIdxMap = new HashMap<>();
        for(int i = 0; i < N; i++) {
            numToIdxMap.put(inorder[i], i);
        }
        
        return createBinaryTree(inorder, 0, N -1, postorder, 0, N -1, numToIdxMap);
    }
    
    private TreeNode createBinaryTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd, Map<Integer, Integer> numToIdxMap) {
        
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) return null;
        
        int rootVal = postorder[postorderEnd];
        int rootIdx = numToIdxMap.get(rootVal);
        
        TreeNode parentNode = new TreeNode(rootVal);
        
        int leftSize = rootIdx - inorderStart;
        int rightSize = inorderEnd - rootIdx;
        
        parentNode.right = createBinaryTree(inorder, rootIdx +1, inorderEnd, postorder, postorderEnd - rightSize, postorderEnd -1, numToIdxMap);
        parentNode.left = createBinaryTree(inorder, inorderStart, rootIdx -1, postorder, postorderStart, postorderStart + leftSize - 1, numToIdxMap);
        
        return parentNode;
    }
}