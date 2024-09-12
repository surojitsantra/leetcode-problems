class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        
        for(char ch :allowed.toCharArray()) {
            int setBitMask = (1 <<(int)(ch -'a'));
            mask = (mask | setBitMask);
        }
        
        int count = 0;
        for(String word :words) {
            boolean isConsistent = true;
            
            for(char ch :word.toCharArray()) {
                int setBitMask = (1 <<(int)(ch -'a'));
                if((mask & setBitMask) == 0) {
                    isConsistent = false;
                    break;
                }
            }
            
            if(isConsistent) {
                count++;
            }
            
        }
        
        return count;
    }
}