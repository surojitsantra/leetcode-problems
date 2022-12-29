class Solution {
    public int[] getOrder(int[][] tasks) {
        final int N = tasks.length;
        
        // Store task enqueue time, processing time, index.
        int[][] sortedTasks = new int[N][3];
        
        for(int i = 0; i < N; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        
        Arrays.sort(sortedTasks, (task1, task2) -> task1[0] -task2[0]);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
            (task1, task2) -> ((task1[1] == task2[1])? task1[2] -task2[2] : task1[1] -task2[1]));
        
        int[] ans = new int[N];
        long currTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;
        
        while(taskIndex < N || !minHeap.isEmpty()) {
            if(minHeap.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                currTime = sortedTasks[taskIndex][0];
            }
            
            while(taskIndex < N && currTime >= sortedTasks[taskIndex][0]) {
                minHeap.add(sortedTasks[taskIndex]);
                taskIndex++;
            }
            
            int processTime = minHeap.peek()[1];
            int index = minHeap.peek()[2];
            minHeap.remove();
            
            currTime += processTime; 
            ans[ansIndex++] = index;
        }        
        
        return ans;
    }
}