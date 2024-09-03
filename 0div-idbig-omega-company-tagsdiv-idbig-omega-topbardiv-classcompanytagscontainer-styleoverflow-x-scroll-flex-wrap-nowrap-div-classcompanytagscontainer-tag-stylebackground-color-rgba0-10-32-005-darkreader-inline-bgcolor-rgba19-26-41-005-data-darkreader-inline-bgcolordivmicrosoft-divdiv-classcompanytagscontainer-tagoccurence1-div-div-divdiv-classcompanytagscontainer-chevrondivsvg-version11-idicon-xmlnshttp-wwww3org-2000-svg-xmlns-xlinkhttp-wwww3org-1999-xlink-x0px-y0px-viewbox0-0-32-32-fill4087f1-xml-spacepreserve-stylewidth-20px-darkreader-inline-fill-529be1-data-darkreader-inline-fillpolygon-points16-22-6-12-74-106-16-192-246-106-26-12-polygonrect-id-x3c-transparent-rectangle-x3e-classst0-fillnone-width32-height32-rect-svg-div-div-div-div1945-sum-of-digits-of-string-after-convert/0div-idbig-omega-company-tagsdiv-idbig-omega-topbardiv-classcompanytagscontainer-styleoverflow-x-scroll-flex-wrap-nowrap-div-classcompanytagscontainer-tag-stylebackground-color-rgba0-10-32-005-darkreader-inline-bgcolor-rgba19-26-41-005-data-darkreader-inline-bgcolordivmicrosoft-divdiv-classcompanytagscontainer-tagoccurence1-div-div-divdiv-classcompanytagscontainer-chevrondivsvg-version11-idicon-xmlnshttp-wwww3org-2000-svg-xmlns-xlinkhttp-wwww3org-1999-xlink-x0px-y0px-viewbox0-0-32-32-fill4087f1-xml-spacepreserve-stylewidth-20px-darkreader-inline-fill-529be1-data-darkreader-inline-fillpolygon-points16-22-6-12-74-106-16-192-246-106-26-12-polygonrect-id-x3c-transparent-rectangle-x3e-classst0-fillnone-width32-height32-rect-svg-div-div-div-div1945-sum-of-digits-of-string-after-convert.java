class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) -'a' +1;
            if(n > 9) {
                num = num + (n %10);
                n = n /10;
            }
            num = num +n;
        }
        
        while(--k > 0 && num > 9) {
            int sum = 0;
            while(num > 0) {
                sum = sum +(num %10);
                num = num /10;
            }
            num = sum;
        }
        return num;
    }
}