class Trie {
    public boolean isEnd = false;
    public int count = 0;
    public Trie[] childs = new Trie[26];
    
    public void insert(char[] word) {
        Trie node = this;
        for(char ch :word) {
            int idx = ch -'a';
            if(node.childs[idx] == null) {
                node.childs[idx] = new Trie();
            }
            node = node.childs[idx];
            node.count++;
        }
        node.isEnd = true;
    }
    
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        final int N = words.length;
        
        Trie root = new Trie();
        for(String word :words) {
            root.insert(word.toCharArray());
        }
        
        int[] result = new int[N];
        
        for(int i = 0; i < N; i++) {
            Trie node = root;
            int sum = 0;
            for(char ch :words[i].toCharArray()) {
                int idx = ch -'a';
                if(node.childs[idx] == null) {
                    break;
                }
                node = node.childs[idx];
                sum += node.count;
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}