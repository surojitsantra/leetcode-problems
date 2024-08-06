class Solution {
    public int minimumPushes(String word) {
        int[] charFreq = new int[26];
        
        for(char ch :word.toCharArray()) {
            charFreq[ch -'a']++;
        }
        
        Arrays.sort(charFreq);
        
        int keyUsed = 0;
        int keyPressed = 0;
        for(int i = 25; i >= 0; i--) {
            int freq = charFreq[i];
            if(freq == 0) {
                break;
            }
            keyPressed = keyPressed +(freq *((keyUsed /8) +1));
            keyUsed++;
        }
        
        return keyPressed;
    }
}