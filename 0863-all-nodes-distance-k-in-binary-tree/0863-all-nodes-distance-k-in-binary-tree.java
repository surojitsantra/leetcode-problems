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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        
        List<Integer> ans = new ArrayList<>();
        
        Queue<Integer> helperQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        
        helperQueue.add(target.val);
        visited.add(target.val);
        
        while(!helperQueue.isEmpty()) {
            int sz = helperQueue.size();
            while(sz-- > 0) {
                int val = helperQueue.poll();
                
                if(level == k) {
                    ans.add(val);
                    continue;
                }
                
                for(int neighbor :graph.getOrDefault(val, new ArrayList<>())) {
                    if(visited.contains(neighbor)) continue;
                    visited.add(neighbor);
                    helperQueue.add(neighbor);
                }
            }
            level++;
        }
        
        return ans;        
    }
    
    private void buildGraph(TreeNode root, TreeNode parent, Map<Integer, List<Integer>> graph) {
             
        if(root != null && parent != null) {
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(root.val).add(parent.val);
            graph.get(parent.val).add(root.val);
        }
        if(root.left != null) {
            buildGraph(root.left, root, graph);
        }
        if(root.right != null) {
            buildGraph(root.right, root, graph);
        }
    }
}