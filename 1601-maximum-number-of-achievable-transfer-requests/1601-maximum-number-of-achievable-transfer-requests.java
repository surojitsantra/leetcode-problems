class Solution {
    int maxAns = 0;
    
    public int maximumRequests(int n, int[][] requests) {
        
        int employees[] = new int[n];
        
        return Math.max(0, maxReqPossible(requests, 0, employees));
    }
    
    private int maxReqPossible(int[][] requests, int i, int[] employees) {
        if(i == requests.length) {
            for(int num :employees) if(num != 0) return Integer.MIN_VALUE;;
            return 0;
        }
        
        employees[requests[i][0]]--;
        employees[requests[i][1]]++;
        int pick = 1 +maxReqPossible(requests, i +1, employees);
        employees[requests[i][0]]++;
        employees[requests[i][1]]--;
            
        int notPick = maxReqPossible(requests, i +1, employees);
        
        return Math.max(pick, notPick);
        
    }
}