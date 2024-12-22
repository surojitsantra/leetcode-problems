class DisjointSet {
    private final int V;
    private int[] parent;
    private int[] size;
    
    public DisjointSet(int V) {
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
    
    public int getSize(int x) {
        return size[getParent(x)];
    }
    
    
}

class Solution {
    public int largestIsland(int[][] grid) {
        final int N = grid.length, M = grid[0].length;
        
        DisjointSet disjointSet = new DisjointSet(N *M);
        
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(grid[r][c] == 1) {
                    for(int[] dir :directions) {
                        int nr = r +dir[0];
                        int nc = c +dir[1];
                        
                        if(0 <= nr && nr < N && 0 <= nc && nc < M 
                           && grid[nr][nc] == 1) {
                            
                            disjointSet.union(r *M +c, nr *M +nc);
                        }
                        
                    }
                }
            }
        }
        
        int maxIsland = 1;
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(grid[r][c] == 0) {
                    
                    int nodes = 1;
                    Set<Integer> parents = new HashSet<>();
                    for(int[] dir :directions) {
                        int nr = r +dir[0];
                        int nc = c +dir[1];
                        
                        if(0 <= nr && nr < N && 0 <= nc && nc < M 
                           && grid[nr][nc] == 1) {
                            
                            int parent = disjointSet.getParent(nr *M +nc);
                            if(!parents.contains(parent)) {
                                nodes += disjointSet.getSize(parent);
                            }
                            parents.add(parent);
                            
                        }
                        
                    }
                    
                    maxIsland = Math.max(maxIsland, nodes);
                } else {
                    maxIsland = Math.max(maxIsland, disjointSet.getSize(r *M +c));
                }
            }
        }
        
        return maxIsland;
    }
}