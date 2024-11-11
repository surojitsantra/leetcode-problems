class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        
        for(int i = 2; i < 1001; i++) {
            if(prime[i] == true) {
                for(int j = i *i; j < 1001; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        TreeSet<Integer> primeSet = new TreeSet<>();
        for (int p = 2; p < 1001; p++) {
            if (prime[p]) {
                primeSet.add(p);
            }
        }
        
        final int N = nums.length;
        int lastPoint = N -1;
        while(lastPoint >= 1) {
            if(nums[lastPoint] <= nums[lastPoint -1]) {
                break;
            }
            lastPoint--;
        }
        if(lastPoint == 0) {
            return true;
        }
        
        while(lastPoint >= 1) {
            if(nums[lastPoint] <= nums[lastPoint -1]) {
                int needToDis = nums[lastPoint -1] -nums[lastPoint] +1;
                Integer primeNo = primeSet.ceiling(needToDis);
                if(primeNo == null) {
                    return false;
                }
                if(primeNo >= nums[lastPoint -1]) {
                    return false;
                }
                nums[lastPoint -1] -= primeNo;
            }
            lastPoint--;
        }
        
        return true;
    }
}