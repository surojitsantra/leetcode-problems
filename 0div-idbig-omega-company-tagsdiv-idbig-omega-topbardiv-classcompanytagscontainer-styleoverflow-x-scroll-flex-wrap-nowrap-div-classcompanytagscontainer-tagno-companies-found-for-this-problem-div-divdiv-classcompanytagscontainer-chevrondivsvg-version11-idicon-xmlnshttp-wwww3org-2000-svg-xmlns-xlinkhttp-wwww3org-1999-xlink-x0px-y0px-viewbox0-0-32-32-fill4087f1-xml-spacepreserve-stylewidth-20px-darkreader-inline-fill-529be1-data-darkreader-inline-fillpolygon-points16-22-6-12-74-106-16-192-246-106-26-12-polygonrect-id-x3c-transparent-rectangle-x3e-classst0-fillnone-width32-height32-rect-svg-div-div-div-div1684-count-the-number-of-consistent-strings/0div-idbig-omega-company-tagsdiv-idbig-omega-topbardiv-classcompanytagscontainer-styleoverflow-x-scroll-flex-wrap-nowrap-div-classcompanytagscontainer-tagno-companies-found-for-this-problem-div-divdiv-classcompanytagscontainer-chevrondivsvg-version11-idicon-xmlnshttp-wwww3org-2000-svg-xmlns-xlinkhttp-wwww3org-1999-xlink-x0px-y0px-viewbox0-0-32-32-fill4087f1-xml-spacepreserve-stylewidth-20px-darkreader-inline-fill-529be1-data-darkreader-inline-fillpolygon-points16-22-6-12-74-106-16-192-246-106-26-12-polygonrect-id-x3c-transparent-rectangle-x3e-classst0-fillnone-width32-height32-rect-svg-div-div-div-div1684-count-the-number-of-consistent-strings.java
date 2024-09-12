class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars = new HashSet<>();
        for(char ch :allowed.toCharArray()) {
            allowedChars.add(ch);
        }
        
        int count = 0;
        for(String word :words) {
            boolean validString = true;
            for(char ch :word.toCharArray()) {
                if(!allowedChars.contains(ch)) {
                    validString = false;
                    break;
                }
            }
            
            if(validString) {
                count++;
            }
        }
        
        return count;
    }
}