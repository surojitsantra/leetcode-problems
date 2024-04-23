class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> mhtRoots = new ArrayList<>();
        
        if(n == 0) {
            return mhtRoots;
        }
        if(n == 1) {
            return Arrays.asList(0);
        }
        
        int[] degree = new int[n];
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
            
            degree[u]++;
            degree[v]++;
        }
        
        Queue<Integer> helperQueue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                helperQueue.add(i);
            }
        }
        
        while(!helperQueue.isEmpty()) {
            mhtRoots = new ArrayList<>();
            int sz = helperQueue.size();
            while(sz-- > 0) {
                int node = helperQueue.remove();
                mhtRoots.add(node);
                
                degree[node]--;
                
                for(int neighbor :adjMatrix[node]) {
                    degree[neighbor]--;
                    if(degree[neighbor] == 1) {
                        helperQueue.add(neighbor);
                    }
                }
                
            }
        }
        
        return mhtRoots;
    }
}