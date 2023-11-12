class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> numsIdxMap = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for(int stop :route) {
                numsIdxMap.putIfAbsent(stop, new ArrayList<>());
                numsIdxMap.get(stop).add(i);
            }
        }
        
        
        Queue<Integer> helperQueue = new LinkedList<>();
        Set<Integer> busVisited = new HashSet<>();
        Set<Integer> busStopVisited = new HashSet<>();
        
        int cost = 0;
        helperQueue.add(source);
        busStopVisited.add(source);
        
        while(!helperQueue.isEmpty()) {
            int sz = helperQueue.size();
            
            while(sz -- > 0) {
                int currPos  = helperQueue.poll();
                if(currPos == target) return cost;
                
                List<Integer> allBusses = numsIdxMap.get(currPos);
                
                for(int bus :allBusses) {
                    if(busVisited.contains(bus)) continue;
                    
                    for(int busStop :routes[bus]) {
                        if(busStopVisited.contains(busStop)) continue;
                        
                        helperQueue.add(busStop);
                        busStopVisited.add(busStop);
                    }
                    busVisited.add(bus);
                }
            }
            cost++;
        }
        return -1;
    }
}