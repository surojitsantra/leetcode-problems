class Solution {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder();
        
        int stars = 0;
        for(int i = s.length() -1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '*') stars++;
            else if(stars > 0) stars--;
            else ans.append(ch);
        }
        
        return ans.reverse().toString();
    }
}