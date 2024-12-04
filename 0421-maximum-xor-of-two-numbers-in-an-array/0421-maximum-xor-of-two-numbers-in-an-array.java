class Trie {
    
    public Trie[] childs;
    public Trie() {
        childs = new Trie[2];
    }
    
    public void insert(int num) {
        Trie node = this;
        for(int i = 31; i >= 0; i--) {
            int bit = ((num &(1 <<i)) == 0)? 0 : 1;
            
            if(node.childs[bit] == null) {
                node.childs[bit] = new Trie();
            }
            node = node.childs[bit];
        }
    }
    
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        root.insert(nums[0]);
        
        int maxXor = 0;
        for(int num :nums) {
            
            Trie node = root;
            int currXor = 0;
            for(int i = 31; i >= 0; i--) {
                int bit = ((num &(1 <<i)) == 0)? 0 : 1;
                int toggleBit = (bit == 0)? 1 : 0;
                
                currXor = currXor <<1;
                if(node.childs[toggleBit] == null) {
                    node = node.childs[bit];
                } else {
                    node = node.childs[toggleBit];
                    currXor = (currXor | 1);
                }
                
            }
            
            maxXor = Math.max(maxXor, currXor);
            root.insert(num);
        }
        
        return maxXor;
    }
}