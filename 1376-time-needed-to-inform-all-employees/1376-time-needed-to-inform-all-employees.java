

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managerToEmployeeMap = new HashMap<>();
        managerToEmployeeMap.put(headID, new ArrayList<>());
        
        for(int i = 0; i < n; i++) {
            int man = manager[i];
            if(man == -1) continue;
            
            managerToEmployeeMap.putIfAbsent(man, new ArrayList<>());
            managerToEmployeeMap.get(man).add(i);
        }
        
        return dfs(headID, managerToEmployeeMap, informTime);
        
    }
    
    
    private int dfs(int currManager, Map<Integer, List<Integer>> managerToEmployeeMap, 
                    int[] informTime) {
        if(!managerToEmployeeMap.containsKey(currManager)) {
            return 0;
        }
        
        List<Integer> employees = managerToEmployeeMap.get(currManager);
        int currTime = 0;
        for(int employee :employees) {
            int time = dfs(employee, managerToEmployeeMap, informTime);
            currTime = Math.max(time, currTime);
        }
        
        return currTime +informTime[currManager];
    }
}