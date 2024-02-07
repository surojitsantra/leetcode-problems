class Solution {
    public String frequencySort(String s) {
        final int N = s.length();
        
        int[] charFreq = new int[62];
        
        for(char ch :s.toCharArray()) charFreq[getIdx(ch)]++;
        
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (p1, p2) -> p2.getValue() -p1.getValue());
        
        for(int i = 0; i < 62; i++) {
            if(charFreq[i] > 0){
                maxHeap.add(new Pair<>(i, charFreq[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        while(!maxHeap.isEmpty()) {
            Pair<Integer, Integer> pair = maxHeap.poll();
            char ch = getChar(pair.getKey());
            int freq = pair.getValue();
            
            for(int i = 1; i <= freq; i++) sb.append(ch);
            
        }
        
        return sb.toString();
        
    }
    
    private int getIdx(char ch) {
        if(ch >= 'A' && ch <= 'Z') return ch -'A';
        if(ch >= 'a' && ch <= 'z') return (ch -'a') +26;
        return ch -'0' +26 +26;
    }
    
    private char getChar(int idx) {
        if(idx < 26) return (char) ('A' +idx);
        if(idx < 52) return (char) ('a' +idx -26);
        return (char) ('0' +idx -26 -26);
    }
    
}