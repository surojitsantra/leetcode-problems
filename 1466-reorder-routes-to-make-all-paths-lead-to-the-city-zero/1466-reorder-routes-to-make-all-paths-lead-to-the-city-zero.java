class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer> adjMatrix[] = new List[n +1];
        for(int i = 1; i <= n; i++) adjMatrix[i] = new ArrayList<>();
        
        for(int[] conn :connections) {
            int u = conn[0] +1;
            int v = conn[1] +1;
            adjMatrix[u].add(v);
            adjMatrix[v].add(-u);
        }
        
        boolean[] visited = new boolean[n +1];
        Arrays.fill(visited, false);
        visited[0] = true;
        
        int ans = 0;
        Queue<Integer> helperQueue = new LinkedList<>();
        helperQueue.add(1);
        
        while(!helperQueue.isEmpty()) {
            int currNode = helperQueue.poll();
            visited[currNode] = true;
            for(int desNode :adjMatrix[currNode]) {
                if(visited[Math.abs(desNode)]) continue;
                if(desNode > 0) ans++;
                helperQueue.add(Math.abs(desNode));
            }
        }
        
        return ans;
    }
}