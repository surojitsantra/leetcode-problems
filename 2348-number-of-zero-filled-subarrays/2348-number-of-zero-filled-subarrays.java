class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarrayOnlyHaveZero = 0;
        long continiousZero = 0;
        
        for(int num :nums) {
            if(num == 0) continiousZero++;
            else {
                subarrayOnlyHaveZero += ((continiousZero *(continiousZero +1)) /2);
                continiousZero = 0;
            }
        }
        
        subarrayOnlyHaveZero += ((continiousZero *(continiousZero +1)) /2);
        
        return subarrayOnlyHaveZero;
    }
}