class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        if(tickets[k] == 1) return k +1;
        int timeReq = 0;
        
        for(int i = 0; i < tickets.length; i++) {
            if(i <= k) {
                timeReq += Math.min(tickets[k], tickets[i]);
            } else {
                timeReq += Math.min(tickets[k] -1, tickets[i]);
            }
        }
        
        return timeReq;
    }
}