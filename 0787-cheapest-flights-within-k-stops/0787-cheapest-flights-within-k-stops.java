class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        
        List<Pair<Integer, Integer>>[] adjList = new List[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge :flights) {
            int u = edge[0], v = edge[1], cost = edge[2];
            adjList[u].add(new Pair<>(v, cost));
        }
        
        Queue<Pair<Integer, Integer>> hq = new LinkedList<>();
        hq.add(new Pair<>(src, 0));
        costs[src] = 0;
        
        int level = 0;
        while(!hq.isEmpty() && level <= k) {
            int sz = hq.size();
            while(sz-- > 0) {
                Pair<Integer, Integer> point = hq.poll();
                int node = point.getKey();
                int cost = point.getValue();
                
                for(Pair<Integer, Integer> child :adjList[node]) {
                    int v = child.getKey();
                    int currCost = child.getValue();
                    
                    if(cost +currCost < costs[v]) {
                        costs[v] = cost +currCost;
                        hq.add(new Pair<>(v, costs[v]));
                    }
                    
                }
                
            }
            level++;
        }
        
        if(costs[dst] == Integer.MAX_VALUE) return  -1;
        return costs[dst];
        
    }
}