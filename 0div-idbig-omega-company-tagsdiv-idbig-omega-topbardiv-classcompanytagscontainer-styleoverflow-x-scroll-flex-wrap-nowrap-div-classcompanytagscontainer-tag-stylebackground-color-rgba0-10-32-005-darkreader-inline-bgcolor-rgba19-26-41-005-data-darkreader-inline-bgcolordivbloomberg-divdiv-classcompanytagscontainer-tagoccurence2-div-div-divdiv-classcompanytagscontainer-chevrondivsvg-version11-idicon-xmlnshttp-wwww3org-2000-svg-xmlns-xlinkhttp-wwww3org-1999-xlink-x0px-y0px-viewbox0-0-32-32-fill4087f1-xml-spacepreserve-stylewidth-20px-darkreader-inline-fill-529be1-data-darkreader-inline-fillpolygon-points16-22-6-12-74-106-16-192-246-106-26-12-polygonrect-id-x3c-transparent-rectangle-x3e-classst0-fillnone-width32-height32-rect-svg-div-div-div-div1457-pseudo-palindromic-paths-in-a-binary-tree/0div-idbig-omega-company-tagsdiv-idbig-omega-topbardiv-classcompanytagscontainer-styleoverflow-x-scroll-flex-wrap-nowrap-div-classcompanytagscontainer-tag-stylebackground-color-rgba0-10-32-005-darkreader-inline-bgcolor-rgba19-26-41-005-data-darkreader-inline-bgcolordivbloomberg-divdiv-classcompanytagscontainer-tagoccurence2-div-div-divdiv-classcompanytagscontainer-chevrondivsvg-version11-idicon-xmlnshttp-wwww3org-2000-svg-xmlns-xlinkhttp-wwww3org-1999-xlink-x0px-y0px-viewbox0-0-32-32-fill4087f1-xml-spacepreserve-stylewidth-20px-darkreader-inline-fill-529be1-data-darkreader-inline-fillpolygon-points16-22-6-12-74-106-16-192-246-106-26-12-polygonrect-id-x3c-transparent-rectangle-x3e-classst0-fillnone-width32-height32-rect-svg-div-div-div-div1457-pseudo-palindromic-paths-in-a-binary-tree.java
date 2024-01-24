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
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        
        return countPseudoPalindromicPaths(root, numsFreq);
    }
    
    private int countPseudoPalindromicPaths(TreeNode node, Map<Integer, Integer> numsFreq) {
        if(node == null) return 0;
        
        int count = 0;
        int val = node.val;
        numsFreq.put(val, numsFreq.getOrDefault(val, 0) +1);
        
        if(node.left == null && node.right == null) {
            if(canPalimdrome(numsFreq)) {
                count = 1;
            }
        } else {
            count += countPseudoPalindromicPaths(node.left, numsFreq);
            count += countPseudoPalindromicPaths(node.right, numsFreq);
        }
        
        numsFreq.put(val, numsFreq.getOrDefault(val, 0) -1);
        
        return count;
    }
    
    private boolean canPalimdrome(Map<Integer, Integer> numsFreq) {
        int oddFreqCount = 0;
        
        for(int freq :numsFreq.values()) {
            if((freq &1) == 1) oddFreqCount++;
            if(oddFreqCount > 1) return false;
        }
        
        return true;
    }
    
}