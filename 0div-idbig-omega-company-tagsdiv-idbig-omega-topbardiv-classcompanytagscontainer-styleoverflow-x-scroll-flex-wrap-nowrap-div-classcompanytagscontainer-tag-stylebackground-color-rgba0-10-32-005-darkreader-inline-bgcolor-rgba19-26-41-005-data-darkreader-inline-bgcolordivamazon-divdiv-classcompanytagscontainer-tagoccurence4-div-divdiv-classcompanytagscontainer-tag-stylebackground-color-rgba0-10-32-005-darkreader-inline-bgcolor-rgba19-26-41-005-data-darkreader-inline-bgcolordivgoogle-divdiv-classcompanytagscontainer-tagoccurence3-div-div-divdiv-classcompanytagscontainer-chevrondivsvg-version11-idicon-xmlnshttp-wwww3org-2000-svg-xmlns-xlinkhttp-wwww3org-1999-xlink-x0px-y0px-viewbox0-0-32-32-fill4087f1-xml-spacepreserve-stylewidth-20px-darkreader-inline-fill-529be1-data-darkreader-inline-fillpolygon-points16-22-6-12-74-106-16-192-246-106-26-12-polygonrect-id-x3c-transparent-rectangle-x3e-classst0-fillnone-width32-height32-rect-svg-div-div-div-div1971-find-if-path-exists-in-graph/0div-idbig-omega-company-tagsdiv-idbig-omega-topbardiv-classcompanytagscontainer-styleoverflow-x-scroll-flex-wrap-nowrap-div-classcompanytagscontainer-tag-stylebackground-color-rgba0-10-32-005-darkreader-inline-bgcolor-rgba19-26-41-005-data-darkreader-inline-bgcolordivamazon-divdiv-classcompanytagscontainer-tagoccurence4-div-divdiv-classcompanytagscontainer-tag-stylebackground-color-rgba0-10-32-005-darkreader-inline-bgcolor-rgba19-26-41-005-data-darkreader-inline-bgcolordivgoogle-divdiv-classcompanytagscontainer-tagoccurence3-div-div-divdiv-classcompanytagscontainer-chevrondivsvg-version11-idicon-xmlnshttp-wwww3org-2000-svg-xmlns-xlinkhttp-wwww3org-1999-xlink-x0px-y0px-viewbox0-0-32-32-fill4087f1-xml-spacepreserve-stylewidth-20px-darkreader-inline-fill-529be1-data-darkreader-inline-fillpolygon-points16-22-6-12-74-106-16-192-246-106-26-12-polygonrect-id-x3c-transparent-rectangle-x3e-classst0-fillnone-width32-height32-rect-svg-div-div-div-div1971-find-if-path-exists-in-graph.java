class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adjMatrix = new List[n];
        
        for(int[] edge :edges) {
            int u = edge[0];
            int v = edge[1];
            if(adjMatrix[u] == null) {
                adjMatrix[u] = new ArrayList<>();
            }
            if(adjMatrix[v] == null) {
                adjMatrix[v] = new ArrayList<>();
            }
            
            adjMatrix[u].add(v);
            adjMatrix[v].add(u);
        }
        
        return (dfs(adjMatrix, source, destination, visited));
        
    }
    
    private boolean dfs(List<Integer>[] adjMatrix, int pos, int des, boolean[] visited) {
        if(visited[pos]) {
            return false;
        }
        if(pos == des) {
            return true;
        }
        
        visited[pos] = true;
        
        for(int v :adjMatrix[pos]) {
            if(dfs(adjMatrix, v, des, visited)) {
                return true;
            }
        }
        
        return false;
        
    }
    
}