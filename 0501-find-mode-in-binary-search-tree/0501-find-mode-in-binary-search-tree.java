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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        
        traversal(root, numFreq);
        
        int maxFreq = 0;
        for(int freq :numFreq.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        
        List<Integer> ans = new ArrayList();
        for (int key : numFreq.keySet()) {
            if (numFreq.get(key) == maxFreq) {
                ans.add(key);
            }
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
        
    }
    
    private void traversal(TreeNode node, Map<Integer, Integer> numFreq) {
        if(node == null) return;
        numFreq.put(node.val, numFreq.getOrDefault(node.val, 0) +1);
        
        traversal(node.left, numFreq);
        traversal(node.right, numFreq);
    }
}