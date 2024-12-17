class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charCount = new int[26];
        
        for(char ch :s.toCharArray()) {
            charCount[ch -'a']++;
        }
        
        PriorityQueue<int[]> maxHeap 
            = new PriorityQueue<>((a, b) -> b[0] -a[0]);
        
        for(int i = 0; i < 26; i++) {
            if(charCount[i] > 0) {
                maxHeap.add(new int[]{i, charCount[i]});
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty()) {
            int[] topEle = maxHeap.poll();
            char ch = (char)(topEle[0] +'a');
            
            for(int i = 1; i <= repeatLimit && topEle[1] > 0; i++, topEle[1]--) {
                sb.append(ch);
            }
            
            if(topEle[1] == 0) {
                continue;
            }
            if(maxHeap.isEmpty()) break;
            
            int[] nextTop = maxHeap.poll();
            sb.append((char)(nextTop[0] +'a'));
            nextTop[1]--;
            
            if(nextTop[1] > 0) {
                maxHeap.add(nextTop);
            }
            
            maxHeap.add(topEle);
        }
        
        return sb.toString();
    }
}