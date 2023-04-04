class Solution {
    public int partitionString(String s) {
        int[] charFrq = new int[26];
        Arrays.fill(charFrq, 0);
        
        int noOfSubStr = 1;
        
        for(char ch :s.toCharArray()) {
            if(charFrq[ch -'a'] > 0) {
                Arrays.fill(charFrq, 0);
                noOfSubStr++;
            }
            charFrq[ch -'a']++;
        }
        
        return noOfSubStr;
    }
}