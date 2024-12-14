class Solution {
    public long continuousSubarrays(int[] nums) {
        final int N = nums.length;
        long count = 0;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        
        int start = 0;
        for(int end = 0; end < N; end++) {
            tMap.put(nums[end], tMap.getOrDefault(nums[end], 0) +1);
            
            while(start <= end 
                 && tMap.lastEntry().getKey() -tMap.firstEntry().getKey() > 2) {
                
                tMap.put(nums[start], tMap.getOrDefault(nums[start], 0) -1);
                if(tMap.get(nums[start]) == 0) {
                    tMap.remove(nums[start]);
                }
                start++;
            }
            
            count += (end -start +1);
        }
        
        return count;
    }
    
}