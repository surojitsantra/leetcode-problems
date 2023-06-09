class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        
        int low = 0, high = letters.length -1;
        
        while(low <= high) {
            int mid = (low +high) /2;
            
            if(letters[mid] > target) {
                ans = letters[mid];
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
}