class Solution {
    public int minimumLength(String s) {
        final int N = s.length();
        int i = 0, j = N -1;
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) break;
            while(i +1 < N && s.charAt(i) == s.charAt(i +1)) i++;
            while(j -1 >= 0 && s.charAt(j) == s.charAt(j -1)) j--;
            if(i >= j) return 0;
            i++;
            j--;
        }
        
        return (j -i +1);
    }
}