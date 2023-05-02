class Solution {
    public int arraySign(int[] nums) {
        int negetiveNo = 0;
        for(int num :nums) {
            if(num == 0) return 0;
            if(num < 0) negetiveNo++;
        }
        
        return ((negetiveNo &1) == 0)? 1 : -1;
    }
}