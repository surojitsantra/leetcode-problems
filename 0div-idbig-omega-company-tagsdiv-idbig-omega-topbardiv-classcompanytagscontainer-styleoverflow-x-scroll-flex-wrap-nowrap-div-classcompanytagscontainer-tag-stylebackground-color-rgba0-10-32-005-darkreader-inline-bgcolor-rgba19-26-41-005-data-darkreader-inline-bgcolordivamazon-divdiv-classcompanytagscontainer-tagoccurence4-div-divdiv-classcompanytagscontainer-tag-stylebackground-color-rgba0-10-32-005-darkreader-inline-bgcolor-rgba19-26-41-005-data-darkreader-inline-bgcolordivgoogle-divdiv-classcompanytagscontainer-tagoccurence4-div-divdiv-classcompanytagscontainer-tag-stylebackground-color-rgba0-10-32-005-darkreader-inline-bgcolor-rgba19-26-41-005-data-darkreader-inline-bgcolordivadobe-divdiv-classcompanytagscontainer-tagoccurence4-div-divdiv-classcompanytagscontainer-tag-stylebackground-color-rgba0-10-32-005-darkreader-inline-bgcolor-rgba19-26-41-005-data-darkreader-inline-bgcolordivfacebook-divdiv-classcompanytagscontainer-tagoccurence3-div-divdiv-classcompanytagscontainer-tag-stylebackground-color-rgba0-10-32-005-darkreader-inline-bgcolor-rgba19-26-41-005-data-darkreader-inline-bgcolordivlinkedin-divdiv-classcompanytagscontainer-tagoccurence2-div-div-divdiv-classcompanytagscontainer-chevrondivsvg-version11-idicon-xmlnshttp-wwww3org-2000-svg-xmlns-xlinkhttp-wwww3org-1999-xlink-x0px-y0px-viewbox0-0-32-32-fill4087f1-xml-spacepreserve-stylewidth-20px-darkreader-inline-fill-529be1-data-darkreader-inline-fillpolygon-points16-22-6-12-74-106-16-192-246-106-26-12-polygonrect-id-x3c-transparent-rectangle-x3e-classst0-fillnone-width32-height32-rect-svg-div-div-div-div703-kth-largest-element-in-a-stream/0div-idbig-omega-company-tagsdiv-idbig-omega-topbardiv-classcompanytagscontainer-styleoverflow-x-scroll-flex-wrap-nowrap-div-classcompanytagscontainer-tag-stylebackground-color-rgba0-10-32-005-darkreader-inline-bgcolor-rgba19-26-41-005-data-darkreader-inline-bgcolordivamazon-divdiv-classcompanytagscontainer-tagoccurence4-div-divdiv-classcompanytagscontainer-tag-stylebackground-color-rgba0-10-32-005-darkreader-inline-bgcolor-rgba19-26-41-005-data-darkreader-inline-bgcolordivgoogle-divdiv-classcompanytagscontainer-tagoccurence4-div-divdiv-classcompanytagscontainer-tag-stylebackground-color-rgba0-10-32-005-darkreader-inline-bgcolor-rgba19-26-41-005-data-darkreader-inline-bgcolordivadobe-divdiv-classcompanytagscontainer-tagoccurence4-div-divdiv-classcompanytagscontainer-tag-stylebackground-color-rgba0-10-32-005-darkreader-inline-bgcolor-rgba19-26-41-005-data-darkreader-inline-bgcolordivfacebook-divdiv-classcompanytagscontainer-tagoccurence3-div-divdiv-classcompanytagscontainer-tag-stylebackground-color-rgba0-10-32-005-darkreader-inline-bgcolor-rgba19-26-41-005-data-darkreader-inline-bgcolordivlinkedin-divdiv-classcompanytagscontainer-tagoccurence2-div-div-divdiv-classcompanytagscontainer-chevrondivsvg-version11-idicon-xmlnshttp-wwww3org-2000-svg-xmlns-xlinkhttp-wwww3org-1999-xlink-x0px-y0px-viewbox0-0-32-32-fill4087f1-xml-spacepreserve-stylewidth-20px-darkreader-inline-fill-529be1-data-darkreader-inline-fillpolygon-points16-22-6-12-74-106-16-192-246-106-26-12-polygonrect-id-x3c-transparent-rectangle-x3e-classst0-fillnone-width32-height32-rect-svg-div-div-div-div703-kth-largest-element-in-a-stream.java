class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num :nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (this.minHeap.size() < this.k || this.minHeap.peek() < val) {
            this.minHeap.add(val);
            if (this.minHeap.size() > this.k) {
                this.minHeap.remove();
            }
        }
        return this.minHeap.peek();
    }
}