class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        
        for(int[] pair :adjacentPairs) {
            int first = pair[0];
            int second = pair[1];
                              
            numsMap.putIfAbsent(first, new ArrayList<>());
            numsMap.putIfAbsent(second, new ArrayList<>());
            
            numsMap.get(first).add(second);
            numsMap.get(second).add(first);
        }
        
        //find root
        int root = Integer.MIN_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry :numsMap.entrySet()) {
            if(entry.getValue().size() == 1) {
                root = entry.getKey();
                break;
            }
        }
        
        int[] nums = new int[numsMap.size()];
        nums[0] = root;
        
        int i = 1;
        int prev = Integer.MAX_VALUE;
        int curr = root;
        
        while(i < numsMap.size()) {
            for(int neighbor :numsMap.get(curr)) {
                if(neighbor != prev) {
                    nums[i] = neighbor;
                    i++;
                    prev = curr;
                    curr = neighbor;
                    break;
                }
            }
        }
        
        return nums;
    }
}