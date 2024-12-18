class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() -1;
        
        while(left < right) {
            char ch1 = Character.toLowerCase(s.charAt(left));
            char ch2 = Character.toLowerCase(s.charAt(right));
            
            if(!isDigit(ch1) && !isAlphabet(ch1)) {
                left++;
            } else if(!isDigit(ch2) && !isAlphabet(ch2)) {
                right--;
            } else {
                if(ch1 != ch2) return false;
                left++;
                right--;
            }
            
        }
        
        return true;
    }
    
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    
    private boolean isAlphabet(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
    
}