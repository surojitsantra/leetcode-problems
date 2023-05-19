class Solution {
    public boolean isBipartite(int[][] graph) {
        final int N = graph.length;
        int[] color = new int[N];
        
        for(int i = 0; i < N; i++) {
            if(color[i] == 0 && !dfs(graph, color, i, 1)) return false;
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph, int[] color, int node, int curColor) {
        if(color[node] != 0) return (color[node] == curColor);
        
        color[node] = curColor;
        for(int v :graph[node]) {
            if(!dfs(graph, color, v, -curColor)) return false;
        }
        
        return true;
    }
}