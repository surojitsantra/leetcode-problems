class Solution {
    public String compressedString(String word) {
        final int N = word.length();
        StringBuilder comp = new StringBuilder();
        
        int i = 0, j = 0;
        while(i < N && j < N) {
            while(j < N && word.charAt(i) == word.charAt(j) && j -i < 9) {
                j++;
            }
            int count = j -i;
            comp.append("" +count +word.charAt(i));
            i = j;
        }
        
        return comp.toString();
    }
}