class Task {
    public int difficulty, profit;
    public Task(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final int N = difficulty.length;
        final int M = worker.length;
        
        List<Task> tasks = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            tasks.add(new Task(difficulty[i], profit[i]));
        }
        
        Collections.sort(tasks, (t1, t2) -> t1.profit -t2.profit);
        Arrays.sort(worker);
        
        int maxProfit = 0;
        
        int t = N -1;
        int w = M -1;
        while(t >= 0 && w >= 0) {
            Task task = tasks.get(t);
            if(worker[w] < task.difficulty) {
                t--;
            } else {
                w--;
                maxProfit += task.profit;
            }
        }
        
        return maxProfit;
    }
}