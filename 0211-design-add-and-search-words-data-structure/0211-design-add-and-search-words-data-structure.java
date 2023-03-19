class TrieNode {
    public TrieNode[] childrens;
    public boolean isEnd;
    public TrieNode() {
        this.childrens = new TrieNode[26];
        this.isEnd = false;
    }
}

class WordDictionary {

    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curNode = this.root;
        for(char ch :word.toCharArray()) {
            int idx = ch -'a';
            if(curNode.childrens[idx] == null) {
                curNode.childrens[idx] = new TrieNode();
            }
            curNode = curNode.childrens[idx];
        }
        curNode.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchWord(this.root, word, 0);
    }
    
    private boolean searchWord(TrieNode curNode, String word, int idx) {
        if(curNode == null) return false;
        if(idx == word.length()) {
            return curNode.isEnd;
        }
        
        char ch = word.charAt(idx);
        if(ch == '.') {
            for(int i = 0; i < 26; i++) {
                if(searchWord(curNode.childrens[i], word, idx +1)) return true;
            }
            return false;
        } else {
            return searchWord(curNode.childrens[ch -'a'], word, idx +1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */