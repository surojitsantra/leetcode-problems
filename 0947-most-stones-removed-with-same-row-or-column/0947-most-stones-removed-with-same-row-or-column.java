class UnionSet {
    private final int V;
    private int[] parent;
    private int[] size;
    
    public UnionSet(int V) {
        this.V = V;
        
        parent = new int[V];
        size = new int[V];
        
        for(int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
    }
    
    public void union(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        
        if(parentX == parentY) {
            return;
        }
        
        if(size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        
    }
    
    public boolean isSameComponent(int x, int y) {
        int parentX = getParent(x);
        int parentY = getParent(y);
        return parentX == parentY;
    }
    
    public int getParent(int x) {
        if(x == parent[x]) return x;
        
        return parent[x] = getParent(parent[x]);
    }
    
}

class Solution {
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;
        
        // take the row and col no as nodes
        
        //figure out the max row and column size;
        int maxRow = 0;
        int maxCol = 0;
        
        for(int[] stone :stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        
        UnionSet unionSet = new UnionSet(maxRow +maxCol +2);
        
        // all row will be treated as [0...maxRow] node
        // all columns will be traeted as [maxRow +1 ... maxRow +maxCol +1];
        
        for(int[] stone :stones) {
            int node1 = stone[0];
            int node2 = stone[1] +maxRow +1;
            
            unionSet.union(node1, node2);
            
        }
        
        Set<Integer> parents = new HashSet<>();
        for(int[] stone :stones) {
            int node1 = stone[0];
            int node2 = stone[1] +maxRow +1;
            
            parents.add(unionSet.getParent(node1));
            parents.add(unionSet.getParent(node2));
        }
        
        return totalStones -parents.size();
        
    }
}