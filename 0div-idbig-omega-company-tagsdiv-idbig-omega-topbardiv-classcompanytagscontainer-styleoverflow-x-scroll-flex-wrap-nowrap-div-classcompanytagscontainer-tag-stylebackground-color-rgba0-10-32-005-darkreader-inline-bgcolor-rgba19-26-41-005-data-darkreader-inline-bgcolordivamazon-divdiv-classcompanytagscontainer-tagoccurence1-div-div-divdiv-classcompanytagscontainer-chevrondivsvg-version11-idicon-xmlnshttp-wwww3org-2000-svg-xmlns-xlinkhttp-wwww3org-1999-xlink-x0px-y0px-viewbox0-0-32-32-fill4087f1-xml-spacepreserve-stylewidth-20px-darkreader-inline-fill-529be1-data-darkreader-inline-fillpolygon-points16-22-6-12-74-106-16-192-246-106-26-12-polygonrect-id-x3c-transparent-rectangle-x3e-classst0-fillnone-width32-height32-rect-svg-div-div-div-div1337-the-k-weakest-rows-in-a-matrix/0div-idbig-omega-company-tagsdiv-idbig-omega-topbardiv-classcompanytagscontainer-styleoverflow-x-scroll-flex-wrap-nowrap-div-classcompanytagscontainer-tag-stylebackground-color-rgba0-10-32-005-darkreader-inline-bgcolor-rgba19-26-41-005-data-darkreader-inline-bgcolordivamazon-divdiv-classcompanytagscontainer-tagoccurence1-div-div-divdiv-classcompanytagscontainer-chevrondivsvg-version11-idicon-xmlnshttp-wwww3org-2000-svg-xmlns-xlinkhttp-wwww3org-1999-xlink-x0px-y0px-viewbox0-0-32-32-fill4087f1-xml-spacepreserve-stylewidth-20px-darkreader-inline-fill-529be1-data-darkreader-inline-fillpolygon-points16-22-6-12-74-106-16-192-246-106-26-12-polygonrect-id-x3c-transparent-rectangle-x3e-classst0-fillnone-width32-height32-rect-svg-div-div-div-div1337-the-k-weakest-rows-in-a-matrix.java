class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((Integer[] a, Integer[] b) -> {
            if(a[1] == b[1]) return a[0] -b[0];
            return a[1] -b[1];
        });
        
        for(int i = 0; i < mat.length; i++) {
            int[] humans = mat[i];
            int soldiers = getNoOfSoldiers(humans);
            
            pq.offer(new Integer[] {i, soldiers});
        }
        
        int[] ans = new int[k];
        
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        
        return ans;
    }
    
    private int getNoOfSoldiers(int[] humans) {
        int soldiers = 0;
        
        int low = 0, high = humans.length -1;
        
        while(low <= high) {
            int mid = low +(high -low)/2;
            if(humans[mid] == 1) {
                soldiers = mid +1;
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return soldiers;
    }
}