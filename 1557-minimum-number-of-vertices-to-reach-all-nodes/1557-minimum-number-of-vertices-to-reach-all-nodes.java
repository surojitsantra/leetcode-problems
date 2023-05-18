class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        // mark the node which can be visited by e 
        for (List<Integer> edge :edges)
            visited[edge.get(1)] = true;

        List<Integer> ans = new ArrayList<>();
        // push the node which are not visited because we will need those nodes to traverse the whole graph
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) ans.add(i);
        }
        
        return ans;
    }
}