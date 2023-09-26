class Solution {
    public String removeDuplicateLetters(String s) {
        //Monotonic stack
        int[] charFreq = new int[26];
        boolean[] visited = new boolean[26];
        
        for(char ch :s.toCharArray()) charFreq[ch -'a']++;
        
        Stack<Character> helperStak = new Stack<>();
        
        for(char ch :s.toCharArray()) {
            if(visited[ch -'a']) {
                charFreq[ch -'a']--;
                continue;
            }
            
            while(!helperStak.isEmpty() && charFreq[helperStak.peek() -'a'] > 0 && helperStak.peek() > ch) {
                visited[helperStak.peek() -'a'] = false;
                helperStak.pop();
            }
            
            helperStak.push(ch);
            visited[ch -'a'] = true;
            charFreq[ch -'a']--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!helperStak.isEmpty()) {
            sb.append(helperStak.pop());
        }
        
        return sb.reverse().toString();
    }
}