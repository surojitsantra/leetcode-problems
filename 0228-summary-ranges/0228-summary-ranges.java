class Solution {
    public List<String> summaryRanges(int[] nums) { 
        
        final int N = nums.length;
        
        List<String> ans  = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            int start = nums[i];
            
            while(i +1 < N && nums[i] +1 == nums[i +1]) i++;
            
            if(start == nums[i]) ans.add("" + start);
            else ans.add("" + start + "->" + nums[i]);
        }
        
        return ans;
    }
}