class Solution {
    public int findCircleNum(int[][] isConnected) {
        final int N = isConnected.length;
        
        List<Integer>[] adjMatrix = new ArrayList[N];
        for(int i = 0; i < N; i++) adjMatrix[i] = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j || isConnected[i][j] == 0) continue;
                adjMatrix[i].add(j);
            }
        }
        
        boolean[] visited = new boolean[N];
        
        int components = 0;
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            dfs(i, adjMatrix, visited, N);
            components++;
        }
        
        return components;
    }
    
    private void dfs(int node, List<Integer>[] adjMatrix, boolean[] visited, final int N) {
        visited[node] = true;
        
        for(int v :adjMatrix[node]) {
            if(visited[v]) continue;
            dfs(v, adjMatrix, visited, N);
        }
    }
}