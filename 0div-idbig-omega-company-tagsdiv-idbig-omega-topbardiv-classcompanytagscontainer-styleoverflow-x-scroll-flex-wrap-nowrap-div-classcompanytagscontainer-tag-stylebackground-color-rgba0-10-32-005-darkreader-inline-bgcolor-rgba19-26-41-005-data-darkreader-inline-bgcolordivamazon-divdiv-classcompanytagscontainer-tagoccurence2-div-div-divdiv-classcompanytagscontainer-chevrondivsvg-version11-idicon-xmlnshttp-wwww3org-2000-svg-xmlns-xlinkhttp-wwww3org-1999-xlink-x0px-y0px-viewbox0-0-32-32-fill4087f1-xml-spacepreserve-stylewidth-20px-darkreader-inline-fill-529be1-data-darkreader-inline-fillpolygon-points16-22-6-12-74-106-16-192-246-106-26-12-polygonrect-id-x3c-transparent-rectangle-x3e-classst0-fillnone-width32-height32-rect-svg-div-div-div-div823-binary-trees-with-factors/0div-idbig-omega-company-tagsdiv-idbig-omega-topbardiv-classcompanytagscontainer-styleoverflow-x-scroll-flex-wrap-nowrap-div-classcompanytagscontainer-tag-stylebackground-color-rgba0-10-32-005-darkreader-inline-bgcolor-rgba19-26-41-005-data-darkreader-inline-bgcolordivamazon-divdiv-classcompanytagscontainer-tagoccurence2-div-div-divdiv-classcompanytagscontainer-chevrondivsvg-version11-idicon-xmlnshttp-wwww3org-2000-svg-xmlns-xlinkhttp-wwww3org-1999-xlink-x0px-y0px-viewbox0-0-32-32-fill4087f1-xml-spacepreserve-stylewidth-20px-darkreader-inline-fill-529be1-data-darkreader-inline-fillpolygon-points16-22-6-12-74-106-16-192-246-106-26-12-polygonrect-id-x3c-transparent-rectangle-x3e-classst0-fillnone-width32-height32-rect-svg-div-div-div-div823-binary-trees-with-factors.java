class Solution {
    
    private final int MOD = 1000000000 +7;
    
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> treeCount = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 1;
            
            for(int j = 0; j < i; j++) {
                int child = arr[j];
                if(num %child == 0 && treeCount.containsKey(num /child)) {
                    int otherChild = num /child;
                    count += ((long)treeCount.get(child) *treeCount.get(otherChild)) %MOD;
                    count %= MOD;
                }
            }
            
            treeCount.put(num, count);
        }        
        
        int totalCount = 0;
        for(int count :treeCount.values()) {
            totalCount += count;
            totalCount %= MOD;
        }
        
        return totalCount;
    }
}