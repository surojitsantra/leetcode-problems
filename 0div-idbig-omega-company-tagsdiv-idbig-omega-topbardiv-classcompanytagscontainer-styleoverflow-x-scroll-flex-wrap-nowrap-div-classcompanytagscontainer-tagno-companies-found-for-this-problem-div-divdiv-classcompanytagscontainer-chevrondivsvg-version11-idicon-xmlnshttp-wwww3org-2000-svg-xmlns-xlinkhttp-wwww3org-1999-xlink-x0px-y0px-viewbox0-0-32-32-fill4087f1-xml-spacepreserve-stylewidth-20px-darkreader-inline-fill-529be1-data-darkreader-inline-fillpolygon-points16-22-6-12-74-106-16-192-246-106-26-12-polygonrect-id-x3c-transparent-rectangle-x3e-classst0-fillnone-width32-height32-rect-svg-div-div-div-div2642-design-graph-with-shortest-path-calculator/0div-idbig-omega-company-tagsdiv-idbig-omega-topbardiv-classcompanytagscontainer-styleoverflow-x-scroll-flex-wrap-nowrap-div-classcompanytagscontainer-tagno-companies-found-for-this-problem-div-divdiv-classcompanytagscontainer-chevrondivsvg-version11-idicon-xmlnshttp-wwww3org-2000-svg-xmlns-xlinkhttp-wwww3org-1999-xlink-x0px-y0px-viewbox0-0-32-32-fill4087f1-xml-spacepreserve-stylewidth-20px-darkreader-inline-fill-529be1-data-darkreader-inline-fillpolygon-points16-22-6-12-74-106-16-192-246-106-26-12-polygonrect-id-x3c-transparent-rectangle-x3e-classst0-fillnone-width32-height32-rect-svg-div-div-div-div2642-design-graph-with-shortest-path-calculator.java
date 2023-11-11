class Pair {
    public  int des;
    public int cost;
    
    public Pair(int des, int cost){
        this.des = des;
        this.cost = cost;
    }
}

class Graph {
    
    private List<List<Pair>> adjMatrix;
    private int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        this.adjMatrix = new ArrayList<>();
        
        for(int i = 0; i < n; i++) this.adjMatrix.add(new ArrayList<>());
        
        for(int[] edge :edges) {
            int src = edge[0];
            int des = edge[1];
            int cost = edge[2];
            
            this.adjMatrix.get(src).add(new Pair(des, cost));
        }
    }
    
    public void addEdge(int[] edge) {
        int src = edge[0];
        int des = edge[1];
        int cost = edge[2];
        
        this.adjMatrix.get(src).add(new Pair(des, cost));
    }
    
    public int shortestPath(int src, int des) {
        
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Pair> helperQueue = new LinkedList<>();
        helperQueue.add(new Pair(src, 0));
        
        while(!helperQueue.isEmpty()) {
            Pair pair = helperQueue.poll();
            
            int node = pair.des;
            int cost = pair.cost;
            
            for(Pair neighour :this.adjMatrix.get(node)) {
                int neighourCost = neighour.cost;
                
                if(cost +neighourCost < dist[neighour.des]) {
                    dist[neighour.des] = cost +neighourCost;
                    helperQueue.add(new Pair(neighour.des, dist[neighour.des]));
                }
            }
        }
        
        return (dist[des] == Integer.MAX_VALUE)? -1 : dist[des];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */