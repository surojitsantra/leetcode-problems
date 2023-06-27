class Pair {
    int num1, num2, idx;
    Pair(int num1, int num2, int idx) {
        this.num1 = num1;
        this.num2 = num2;
        this.idx = idx;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (pair1, pair2) -> (pair1.num1 +pair1.num2) -(pair2.num1 +pair2.num2));
        
        for(int num :nums1) {
            minHeap.add(new Pair(num, nums2[0], 0));
        }
        
        while(k-- > 0 && !minHeap.isEmpty()) {
            Pair pair = minHeap.poll();        
            pairs.add(Arrays.asList(pair.num1, pair.num2));
            
            int pos = pair.idx;
            if(pos +1 < nums2.length) {
                minHeap.add(new Pair(pair.num1, nums2[pos +1], pos +1));
            }
        }
        
        return pairs;
    }
}