class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> edgesCount = new HashMap<>();
        
        for(int[] edge :edges) {
            int u = edge[0];
            int v = edge[1];
            
            edgesCount.put(u, edgesCount.getOrDefault(u, 0) +1);
            edgesCount.put(v, edgesCount.getOrDefault(v, 0) +1);
            
        }
        
        for(Map.Entry<Integer, Integer> entry :edgesCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == edgesCount.size() -1) {
                return key;
            }
        }
        
        return -1;
    }
}