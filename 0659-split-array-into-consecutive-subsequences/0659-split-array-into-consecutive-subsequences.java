class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        for(int x :nums) numsFreq.put(x, numsFreq.getOrDefault(x, 0) +1);

        Map<Integer, Integer> needNum = new HashMap<>();

        for(int x :nums) {
            if(numsFreq.get(x) == 0) continue;
            if(needNum.getOrDefault(x, 0) > 0) {
                needNum.put(x, needNum.get(x) -1);
                needNum.put(x +1, needNum.getOrDefault(x +1, 0) +1);
                numsFreq.put(x, numsFreq.get(x) -1);
            } else if(numsFreq.getOrDefault(x, 0) > 0
                        && numsFreq.getOrDefault(x +1, 0) > 0
                        && numsFreq.getOrDefault(x +2, 0) > 0) {
                numsFreq.put(x, numsFreq.get(x) -1);
                numsFreq.put(x +1, numsFreq.get(x +1) -1);
                numsFreq.put(x +2, numsFreq.get(x +2) -1);

                needNum.put(x +3, needNum.getOrDefault(x +3, 0) +1);
            } else {
                return false;
            }
        }

        return true;
    }
}