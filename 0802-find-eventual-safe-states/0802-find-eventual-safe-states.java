class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        final int N = graph.length;
        int[] degree = new int[N];
        List<List<Integer>> adjMatrix = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            adjMatrix.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N; i++) {
            for(int node :graph[i]) {
                degree[i]++;
                adjMatrix.get(node).add(i);
            }
        }
        
        Queue<Integer> helperQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                helperQueue.add(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        while(!helperQueue.isEmpty()) {
            int node = helperQueue.poll();
            safeNodes.add(node);
            
            for(int neighbor :adjMatrix.get(node)) {
                degree[neighbor]--;
                if(degree[neighbor] == 0) {
                    helperQueue.add(neighbor);
                }
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}