class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        
        for(int num :nums) {
            numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        }
        
        int[] sortedArray = Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> {
            if(numsFreq.get(a) == numsFreq.get(b)) {
                return b -a;
            }
            return numsFreq.get(a) -numsFreq.get(b);
        })
            .mapToInt(Integer::intValue)
            .toArray();
        
        return sortedArray;
    }
}