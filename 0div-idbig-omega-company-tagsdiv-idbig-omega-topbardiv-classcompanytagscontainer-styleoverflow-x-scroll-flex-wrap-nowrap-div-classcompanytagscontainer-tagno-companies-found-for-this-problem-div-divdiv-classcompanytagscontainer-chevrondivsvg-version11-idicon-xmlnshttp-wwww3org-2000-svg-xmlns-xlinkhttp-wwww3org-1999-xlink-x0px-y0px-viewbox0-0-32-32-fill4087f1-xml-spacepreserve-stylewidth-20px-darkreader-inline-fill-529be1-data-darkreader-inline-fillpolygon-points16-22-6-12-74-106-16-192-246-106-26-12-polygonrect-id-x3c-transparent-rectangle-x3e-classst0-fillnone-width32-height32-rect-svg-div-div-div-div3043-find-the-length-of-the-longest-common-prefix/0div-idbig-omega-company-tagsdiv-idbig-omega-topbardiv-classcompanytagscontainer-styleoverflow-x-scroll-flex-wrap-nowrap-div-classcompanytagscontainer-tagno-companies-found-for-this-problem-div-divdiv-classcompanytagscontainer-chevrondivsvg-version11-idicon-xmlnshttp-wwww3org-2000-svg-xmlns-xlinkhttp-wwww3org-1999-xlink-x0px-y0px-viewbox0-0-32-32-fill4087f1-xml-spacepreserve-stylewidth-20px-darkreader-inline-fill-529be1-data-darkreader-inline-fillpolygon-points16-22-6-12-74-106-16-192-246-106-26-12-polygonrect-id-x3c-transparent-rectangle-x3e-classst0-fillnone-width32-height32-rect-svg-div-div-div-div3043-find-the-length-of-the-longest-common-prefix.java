class Solution {
    
    class Trie {
        public boolean isEnd = false;
        public Trie[] childs = new Trie[10];
    }
    
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = buildTrie(arr1);
        
        int maxPrefixLen = 0;
        for(int num :arr2) {
            
            int currLen = 0;
            Trie node = root;
            for(char ch :String.valueOf(num).toCharArray()) {
                int digit = (int)(ch -'0');
                if(node.childs[digit] == null) {
                    break;
                }
                currLen++;
                node = node.childs[digit];
            }
            
            maxPrefixLen = Math.max(maxPrefixLen, currLen);
        }
        
        return maxPrefixLen;
    }
    
    private Trie buildTrie(int[] arr) {
        Trie root = new Trie();
        
        for(int num :arr) {
            Trie node = root;
            for(char ch :String.valueOf(num).toCharArray()) {
                int digit = (int)(ch -'0');
                if(node.childs[digit] == null) {
                    node.childs[digit] = new Trie();
                }
                node = node.childs[digit];
            }
            node.isEnd = true;
        }
        
        return root;
    }
    
}