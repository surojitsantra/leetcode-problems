class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        final int N = nums.length;

        if(N %k != 0) return false;

        TreeMap<Integer, Integer> numsFreq = new TreeMap<>();
        for(int x :nums) {
            numsFreq.put(x, numsFreq.getOrDefault(x, 0) +1);
        }

        for(int i = 1; i <= N /k; i++) {
            int curr = numsFreq.firstKey() -1;
            for(int j = 1; j <= k; j++) {
                int next = curr +1;
                if(!numsFreq.containsKey(next)) return false;
                numsFreq.put(next, numsFreq.get(next) -1);
                if(numsFreq.get(next) == 0) numsFreq.remove(next);

                curr = next;
            }
        }

        return true;

    }
}