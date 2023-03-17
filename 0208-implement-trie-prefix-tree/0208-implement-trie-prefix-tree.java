class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode = root;
        for(char ch :word.toCharArray()) {
            int idx = ch -'a';
            if(currNode.children[idx] == null) {
                currNode.children[idx] = new TrieNode();
            }
            currNode = currNode.children[idx];
        }
        currNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        for(char ch :word.toCharArray()) {
            int idx = ch -'a';
            if(currNode.children[idx] == null) {
                return false;
            }
            currNode = currNode.children[idx];
        }
        return currNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for(char ch :prefix.toCharArray()) {
            int idx = ch -'a';
            if(currNode.children[idx] == null) {
                return false;
            }
            currNode = currNode.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */