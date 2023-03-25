class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer> adjMatrix[] = new List[n];
        for(int i = 0; i < n; i++) adjMatrix[i] = new ArrayList<>();
        
        for(int[] edge :edges) {
            int u = edge[0], v = edge[1];
            adjMatrix[u].add(v);
            adjMatrix[v].add(u);
        }
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        List<Integer> nodesInComponents = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            nodesInComponents.add(dfs(adjMatrix, i, visited));
        }
        if(nodesInComponents.size() <= 1) return 0;
        
        long ans = 0;
        int currSum = n;
        for(int nodes :nodesInComponents) {
            currSum -= nodes;
            ans += (long)nodes *currSum;
        }
        
        return ans;
    }
    
    private int dfs(List<Integer> adjMatrix[], int node, boolean[] visited) {
        visited[node] = true;
        int currNodes = 1;
        for(int des :adjMatrix[node]) {
            if(visited[des]) continue;
            currNodes += dfs(adjMatrix, des, visited);
        }
        
        return currNodes;
    }
}