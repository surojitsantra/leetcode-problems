class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final int N = graph.length;
        
        List<List<Integer>> paths = new ArrayList<>();
        
        int src = 0, des = N -1;
        List<Integer> path = new ArrayList<>();
        
        dfs(src, des, graph, path, paths);        
        
        return paths;
    }
    
    private void dfs(int v, int des, int[][] graph, List<Integer> path, List<List<Integer>> paths) {
        path.add(v);
        
        if(v == des) {
            List<Integer> curPath = new ArrayList<>();
            for(int u :path) curPath.add(u);
            paths.add(curPath);
            path.remove(path.size() -1);
            return;
        }
        
        for(int u :graph[v]) {
            dfs(u, des, graph, path, paths);
        }
        path.remove(path.size() -1);
    }
}