class Project {
    public int profit, capital;
    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int N = profits.length;
        
        Project[] projects = new Project[N];
        for(int i = 0; i < N; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        
        Arrays.sort(projects, (p1, p2) -> p1.capital -p2.capital);
        
        PriorityQueue<Integer> profitsMaxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int i = 0;
        int totalProfit = w;
        while(k-- > 0) {
            while(i < N && projects[i].capital <= totalProfit) profitsMaxheap.add(projects[i++].profit);
            
            if(profitsMaxheap.isEmpty()) break;            
            totalProfit += profitsMaxheap.poll();
        }
        
        return totalProfit;
    }
}