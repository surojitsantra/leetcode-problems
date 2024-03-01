class Solution {
    public String maximumOddBinaryNumber(String s) {
        int once = 0;
        int zeros = 0;
        
        for(char ch :s.toCharArray()) {
            if(ch == '1') once++;
            else zeros++;
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(once-- > 1) {
            ans.append("1");
        }
        while(zeros-- > 0) {
            ans.append("0");
        }
        ans.append("1");
        
        return ans.toString();
        
    }
}