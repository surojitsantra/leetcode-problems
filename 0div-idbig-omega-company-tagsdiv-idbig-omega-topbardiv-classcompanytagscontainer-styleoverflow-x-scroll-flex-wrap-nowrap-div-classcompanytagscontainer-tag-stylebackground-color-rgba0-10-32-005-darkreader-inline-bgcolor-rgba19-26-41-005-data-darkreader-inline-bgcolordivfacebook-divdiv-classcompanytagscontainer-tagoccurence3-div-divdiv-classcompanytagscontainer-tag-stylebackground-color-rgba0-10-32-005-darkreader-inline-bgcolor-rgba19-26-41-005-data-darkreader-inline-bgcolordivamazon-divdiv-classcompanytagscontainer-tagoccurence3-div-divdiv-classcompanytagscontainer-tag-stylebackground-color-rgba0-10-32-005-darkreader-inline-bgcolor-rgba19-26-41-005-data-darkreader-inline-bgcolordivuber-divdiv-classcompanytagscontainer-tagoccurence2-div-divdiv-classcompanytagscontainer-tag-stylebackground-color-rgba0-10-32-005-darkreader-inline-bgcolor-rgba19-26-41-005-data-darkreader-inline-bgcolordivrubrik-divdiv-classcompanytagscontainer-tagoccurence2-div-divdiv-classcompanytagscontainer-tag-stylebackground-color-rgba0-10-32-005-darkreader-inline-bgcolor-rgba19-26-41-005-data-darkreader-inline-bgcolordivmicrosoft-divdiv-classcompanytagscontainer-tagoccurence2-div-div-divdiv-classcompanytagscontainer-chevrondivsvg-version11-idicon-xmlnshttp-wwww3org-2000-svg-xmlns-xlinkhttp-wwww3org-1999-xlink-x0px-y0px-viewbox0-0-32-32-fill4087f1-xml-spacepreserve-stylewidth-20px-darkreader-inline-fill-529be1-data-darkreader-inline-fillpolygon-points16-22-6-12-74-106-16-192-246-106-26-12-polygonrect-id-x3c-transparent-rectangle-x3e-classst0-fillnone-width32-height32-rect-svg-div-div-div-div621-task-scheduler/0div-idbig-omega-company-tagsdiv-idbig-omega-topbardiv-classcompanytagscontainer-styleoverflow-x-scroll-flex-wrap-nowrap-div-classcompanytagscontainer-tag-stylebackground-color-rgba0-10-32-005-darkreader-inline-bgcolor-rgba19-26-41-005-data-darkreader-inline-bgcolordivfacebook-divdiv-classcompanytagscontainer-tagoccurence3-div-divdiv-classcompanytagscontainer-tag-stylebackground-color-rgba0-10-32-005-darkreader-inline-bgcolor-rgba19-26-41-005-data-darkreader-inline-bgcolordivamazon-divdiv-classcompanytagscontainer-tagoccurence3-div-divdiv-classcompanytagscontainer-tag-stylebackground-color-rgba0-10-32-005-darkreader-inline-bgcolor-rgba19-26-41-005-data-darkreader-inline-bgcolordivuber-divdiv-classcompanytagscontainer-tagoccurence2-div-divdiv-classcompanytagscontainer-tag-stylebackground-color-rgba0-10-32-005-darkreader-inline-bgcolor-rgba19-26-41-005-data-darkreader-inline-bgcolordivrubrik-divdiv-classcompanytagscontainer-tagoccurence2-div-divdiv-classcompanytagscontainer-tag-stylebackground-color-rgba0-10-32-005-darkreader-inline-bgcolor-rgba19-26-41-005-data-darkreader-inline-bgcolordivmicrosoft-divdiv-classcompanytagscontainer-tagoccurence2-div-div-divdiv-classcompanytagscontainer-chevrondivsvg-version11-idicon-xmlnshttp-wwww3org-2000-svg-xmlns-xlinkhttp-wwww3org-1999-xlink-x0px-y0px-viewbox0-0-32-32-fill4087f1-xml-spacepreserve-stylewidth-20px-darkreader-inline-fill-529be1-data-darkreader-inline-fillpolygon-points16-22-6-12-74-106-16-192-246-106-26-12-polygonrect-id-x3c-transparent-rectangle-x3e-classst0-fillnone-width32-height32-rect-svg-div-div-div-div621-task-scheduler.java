class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskFreq = new HashMap<>();
        for(char task :tasks) {
            taskFreq.put(task, taskFreq.getOrDefault(task, 0) +1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> (a.getValue() != b.getValue())? 
                Integer.compare(b.getValue(), a.getValue()) : Integer.compare(b.getKey(), a.getKey())
        );
        
        maxHeap.addAll(taskFreq.entrySet());
        int count = 0;
        
        while(!maxHeap.isEmpty()) {
            int k = n +1;
            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
            
            while(k > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                entry.setValue(entry.getValue() -1);
                if(entry.getValue() > 0) {
                    tempList.add(entry);
                }
                k--;
                count++;
            }
            
            for(int i = 0; i < tempList.size(); i++) {
                maxHeap.add(tempList.get(i));
            }
            
            if (maxHeap.isEmpty()) break;
            count += k;
        }
        
        return count;
    }
}