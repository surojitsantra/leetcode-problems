class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((Integer[] a, Integer[] b) -> {
            if(a[1] == b[1]) return a[0] -b[0];
            return a[1] -b[1];
        });
        
        for(int i = 0; i < mat.length; i++) {
            int[] humans = mat[i];
            int soldiers = 0;
            for(int human :humans) {
                soldiers += human;
            }
            
            pq.offer(new Integer[] {i, soldiers});
        }
        
        int[] ans = new int[k];
        
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        
        return ans;
    }
}