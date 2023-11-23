class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        
        final int M = l.length;
        for(int i = 0; i < M; i++) {
            int lb = l[i];
            int rb = r[i];
            
            res.add(isArithmetic(nums, lb, rb));
            
        }
        
        return res;
    }
    
    private boolean isArithmetic(int[] nums, int lb, int rb) {
        Set<Integer> numSet = new HashSet<>();
        int minNo = Integer.MAX_VALUE, maxNo = Integer.MIN_VALUE;
        
        for(int i = lb; i <= rb; i++) {
            minNo = Math.min(minNo, nums[i]);
            maxNo = Math.max(maxNo, nums[i]);
            numSet.add(nums[i]);
        }
        
        if(minNo == maxNo) return (numSet.size() == 1);
        
        int n = rb -lb +1;
        if(numSet.size() != n) return false;
        if((maxNo -minNo) %(n -1) != 0) return false;
        
        int diff = (maxNo -minNo) /(n -1);
        
        for(int ele = minNo; ele <= maxNo; ele += diff) {
            if(!numSet.contains(ele)) return false;
        }
        
        return true;
        
    }
}