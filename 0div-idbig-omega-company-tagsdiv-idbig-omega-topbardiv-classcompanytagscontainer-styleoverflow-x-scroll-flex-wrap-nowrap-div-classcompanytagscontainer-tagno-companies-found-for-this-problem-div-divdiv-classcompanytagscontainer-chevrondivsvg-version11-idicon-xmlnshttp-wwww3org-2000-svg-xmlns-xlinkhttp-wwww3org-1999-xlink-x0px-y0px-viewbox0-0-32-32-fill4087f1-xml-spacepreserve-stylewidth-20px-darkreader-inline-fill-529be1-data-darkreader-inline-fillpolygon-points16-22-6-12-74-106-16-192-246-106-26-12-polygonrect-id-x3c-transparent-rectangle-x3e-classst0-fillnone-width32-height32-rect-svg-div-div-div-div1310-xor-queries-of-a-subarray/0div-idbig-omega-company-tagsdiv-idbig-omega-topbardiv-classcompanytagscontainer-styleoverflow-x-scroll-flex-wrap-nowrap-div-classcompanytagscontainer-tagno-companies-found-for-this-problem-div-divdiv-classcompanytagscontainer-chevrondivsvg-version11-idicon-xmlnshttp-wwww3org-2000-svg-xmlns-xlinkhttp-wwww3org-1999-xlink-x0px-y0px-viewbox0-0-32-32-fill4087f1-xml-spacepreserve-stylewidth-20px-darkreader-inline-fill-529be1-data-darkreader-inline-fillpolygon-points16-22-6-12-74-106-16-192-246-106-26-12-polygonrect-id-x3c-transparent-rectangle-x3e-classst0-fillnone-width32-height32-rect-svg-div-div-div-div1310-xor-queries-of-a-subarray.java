class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        final int N = arr.length;
        int[] prefixXor = new int[N];
        
        prefixXor[0] = arr[0];
        for(int i = 1; i < N; i++) {
            prefixXor[i] = prefixXor[i -1] ^arr[i];
        }
        
        int result[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            
            int tillLeftPartXor = 0;
            int tillRightPartXor = prefixXor[right];
            if(left > 0) {
                tillLeftPartXor = prefixXor[left -1];
            }
            
            result[i] = tillRightPartXor ^tillLeftPartXor;
        }
        
        return result;
    }
}