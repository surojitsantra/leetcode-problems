class Solution {
    public int lengthOfLIS(int[] nums) {
        final int N = nums.length;
        List<Integer> subSeq = new ArrayList<>();
        subSeq.add(nums[0]);
        
        for(int i = 1; i < N; i++) {
            int num = nums[i];
            int j = subSeq.size();
            if(subSeq.get(j -1) < num) {
                subSeq.add(num);
            } else if(subSeq.get(j -1) > num) {
                int idx = graterSmallestNumIdx(subSeq, num);
                subSeq.set(idx, num);
            }
        }
        
        return subSeq.size();
    }
    
    private int graterSmallestNumIdx(List<Integer> subSeq, int num) {
        final int N = subSeq.size();
        
        int i = 0, j = N -1;
        int idx = -1;
        while(i <= j) {
            int mid = (i +j) /2;
            int midNum = subSeq.get(mid);
            if(num == midNum) return mid;
            if(num < midNum) {
                idx = mid;
                j = mid -1;
            } else {
                i = mid +1;
            }
        }
        return idx;
    }
    
}