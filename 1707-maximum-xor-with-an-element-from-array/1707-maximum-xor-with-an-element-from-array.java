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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        final int Q = queries.length;
        final int N = nums.length;
        
        int[][] queriesWithIdx = new int[Q][3];
        for(int i = 0; i < Q; i++) {
            queriesWithIdx[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        
        Arrays.sort(queriesWithIdx, (a, b) -> a[1] -b[1]);
        Arrays.sort(nums);
        
        int[] res = new int[Q];
        
        Trie root = new Trie();
        for(int i = 0, j = 0; i < Q; i++) {
            int xi = queriesWithIdx[i][0];
            int mi = queriesWithIdx[i][1];
            int idx = queriesWithIdx[i][2];
            
            while(j < N && nums[j] <= mi) {
                root.insert(nums[j]);
                j++;
            }
            res[idx] = -1;
            if(j > 0) {
                res[idx] = getMaxXor(root, xi);
            }
        }
        
        return res;
    }
    
    private int getMaxXor(Trie node, int num) {
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
            
        return currXor;
    }
    
}