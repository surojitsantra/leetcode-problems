class Nums {
    int val, idx;
    Nums(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        final int N = costs.length;
        
        List<Nums> costList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            costList.add(new Nums(costs[i], i));
        }
        
        PriorityQueue<Nums> minHeap = new PriorityQueue<>(
            (num1, num2) -> {
                if(num1.val -num2.val != 0) return num1.val -num2.val;
                return num1.idx -num2.idx;
            });
        
        //initial store
        for(int i = 0; i < candidates; i++)
            minHeap.add(costList.get(i));
        for(int i = Math.max(candidates, N- candidates); i < N; i++)
            minHeap.add(costList.get(i));
        
        int point1 = candidates;
        int point2 = N -candidates -1;
        long totalCost = 0;
        
        while(k-- > 0) {
            Nums num = minHeap.poll();
            int idx = num.idx;            
            totalCost += num.val;
            
            // Only refill pq if there are workers outside.
            if (point1 <= point2) {
                if (idx < point1) {
                    minHeap.add(costList.get(point1));
                    point1++;
                } else {
                    minHeap.add(costList.get(point2));
                    point2--;
                }
            }
        }
        
        return totalCost;
    }
    
}