class Solution {
    public List<Integer> majorityElement(int[] nums) {
        final int N = nums.length;
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE, ctr1 = 0, ctr2 = 0;
        
        for(int num :nums) {
            if(num == num1) {
                ctr1++;
            } else if(num == num2) {
                ctr2++;
            } else if(ctr1 == 0) {
                num1 = num;
                ctr1 = 1;
            } else if(ctr2 == 0) {
                num2 = num;
                ctr2 = 1;
            } else {
                ctr1--;
                ctr2--;
            }
        }
        
        ctr1 = ctr2 = 0;
        
        for(int num :nums) {
            if(num == num1) ctr1++;
            else if(num == num2) ctr2++;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        if(ctr1 > N /3) ans.add(num1);
        if(ctr2 > N /3) ans.add(num2);
        
        return ans;
    }
}