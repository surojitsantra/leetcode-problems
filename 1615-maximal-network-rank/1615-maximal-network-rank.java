class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] adjMatrix = new Set[n];
        
        for(int i = 0; i < n; i++) adjMatrix[i] = new HashSet<>();
        
        for(int[] road :roads) {
            int u = road[0], v = road[1];
            adjMatrix[u].add(v);
            adjMatrix[v].add(u);
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i +1; j < n; j++) {
                int count = adjMatrix[i].size() +adjMatrix[j].size();
                if(adjMatrix[i].contains(j)) count--;
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
}