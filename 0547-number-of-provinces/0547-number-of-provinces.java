class Solution {
    public int findCircleNum(int[][] isConnected) {
        final int N = isConnected.length;       
        
        boolean[] visited = new boolean[N];
        int components = 0;
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            dfs(i, isConnected, visited, N);
            components++;
        }
        
        return components;
    }
    
    private void dfs(int node, int[][] isConnected, boolean[] visited, final int N) {
        visited[node] = true;
        
        for(int i = 0; i < N; i++) {
            if(isConnected[node][i] == 0 || i == node || visited[i]) continue;
            dfs(i, isConnected, visited, N);
        }
    }
}