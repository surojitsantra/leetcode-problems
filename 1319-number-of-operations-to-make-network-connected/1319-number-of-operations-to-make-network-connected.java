class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        
        List<Integer> adjMatrix[] = new ArrayList[n];
        
        for(int i = 0; i < n; i++) adjMatrix[i] = new ArrayList<>();
        for(int[] connection :connections) {
            adjMatrix[connection[0]].add(connection[1]);
            adjMatrix[connection[1]].add(connection[0]);
        }
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(adjMatrix, i, visited);
            }
        }
        
        return components -1;
    }
    
    private void dfs(List<Integer> adjMatrix[], int node, boolean[] visited) {
        if(visited[node]) return;
        visited[node] = true;
        for(int des :adjMatrix[node]) dfs(adjMatrix, des, visited);
    }
}