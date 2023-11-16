class Solution {
    public String findDifferentBinaryString(String[] nums) {
        final int N = nums.length;
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            String num = nums[i];
            char bit = num.charAt(i);
            ans.append(bit == '0'? '1' : '0');
        }
        
        return ans.toString();
    }
}