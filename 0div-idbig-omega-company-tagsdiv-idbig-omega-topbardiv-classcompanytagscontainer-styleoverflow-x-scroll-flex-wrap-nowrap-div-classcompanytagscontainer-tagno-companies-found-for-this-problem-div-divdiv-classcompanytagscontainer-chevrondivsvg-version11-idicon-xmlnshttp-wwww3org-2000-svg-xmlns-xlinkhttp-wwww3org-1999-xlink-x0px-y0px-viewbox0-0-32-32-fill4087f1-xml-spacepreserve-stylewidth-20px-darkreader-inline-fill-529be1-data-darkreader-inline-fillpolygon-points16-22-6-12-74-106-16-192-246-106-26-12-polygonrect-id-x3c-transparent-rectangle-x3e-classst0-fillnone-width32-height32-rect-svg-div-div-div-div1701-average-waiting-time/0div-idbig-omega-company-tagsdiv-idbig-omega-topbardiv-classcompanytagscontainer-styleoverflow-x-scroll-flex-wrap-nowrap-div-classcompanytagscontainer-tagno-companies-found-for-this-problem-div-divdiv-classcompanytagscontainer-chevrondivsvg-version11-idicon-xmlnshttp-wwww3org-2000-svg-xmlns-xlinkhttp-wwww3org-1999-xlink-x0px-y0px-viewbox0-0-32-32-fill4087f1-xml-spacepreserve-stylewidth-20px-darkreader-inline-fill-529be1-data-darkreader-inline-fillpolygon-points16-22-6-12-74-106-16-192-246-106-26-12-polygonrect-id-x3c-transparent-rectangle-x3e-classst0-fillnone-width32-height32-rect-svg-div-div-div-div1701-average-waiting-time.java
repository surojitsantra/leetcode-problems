class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currentTime = customers[0][0];
        
        for(int[] customer : customers) {
            
            currentTime = Math.max(currentTime, customer[0]);
            currentTime += customer[1];
            totalWaitingTime += currentTime - customer[0];
    
        }
        
        return totalWaitingTime/customers.length;
        
    }
}