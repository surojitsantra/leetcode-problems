class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];
        
        for(int num :nums1) {
            count1[num]++;
        }
        
        for(int num :nums2) {
            count2[num]++;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < 1001; i++) {
            int count = Math.min(count1[i], count2[i]);
            
            while(count-- > 0) {
                ans.add(i);
            }
            
        }
        
        int[] intArray = ans.stream().mapToInt(Integer::intValue).toArray();
        
        return intArray;
        
    }
}