class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final int N = numCourses;
        int[] indegree = new int[N];
        List<Integer>[] adjList = new List[N];
        
        for(int[] edge :prerequisites) {
            int u = edge[0], v = edge[1];
            indegree[u]++;
            
            if(adjList[v] == null) {
                adjList[v] = new ArrayList<>();
            }
            adjList[v].add(u);
        }
        
        Queue<Integer> hq = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(indegree[i] == 0) {
                hq.add(i);
            }
        }
        
        if(hq.isEmpty()) {
            return new int[0];
        }
        
        int[] path = new int[N];
        int k = 0;
        while(!hq.isEmpty()) {
            int sz = hq.size();
            while(sz-- > 0) {
                int node = hq.poll();
                path[k++] = node;
                
                if(adjList[node] == null) continue;
                
                for(int friend :adjList[node]) {
                    indegree[friend]--;
                    if(indegree[friend] == 0) {
                        hq.add(friend);
                    }
                }
                
            }
        }
        
        if(k < N) return new int[0];
        
        return path;
    }
}