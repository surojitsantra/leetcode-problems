class Solution {
    int answer = 0;
    
    public int maximumRequests(int n, int[][] requests) {
        
        int employees[] = new int[n];
        
        maxReqPossible(requests, 0, employees, 0);
        
        return answer;
    }
    
    private void maxReqPossible(int[][] requests, int i, int[] employees, int count) {
        if(i == requests.length) {
            for(int num :employees) if(num != 0) return;;
            answer = Math.max(answer, count);
            return;
        }
        
        //pick
        employees[requests[i][0]]--;
        employees[requests[i][1]]++;
        maxReqPossible(requests, i +1, employees, count +1);
        employees[requests[i][0]]++;
        employees[requests[i][1]]--;
           
        //not pick
        maxReqPossible(requests, i +1, employees, count);
        
    }
}