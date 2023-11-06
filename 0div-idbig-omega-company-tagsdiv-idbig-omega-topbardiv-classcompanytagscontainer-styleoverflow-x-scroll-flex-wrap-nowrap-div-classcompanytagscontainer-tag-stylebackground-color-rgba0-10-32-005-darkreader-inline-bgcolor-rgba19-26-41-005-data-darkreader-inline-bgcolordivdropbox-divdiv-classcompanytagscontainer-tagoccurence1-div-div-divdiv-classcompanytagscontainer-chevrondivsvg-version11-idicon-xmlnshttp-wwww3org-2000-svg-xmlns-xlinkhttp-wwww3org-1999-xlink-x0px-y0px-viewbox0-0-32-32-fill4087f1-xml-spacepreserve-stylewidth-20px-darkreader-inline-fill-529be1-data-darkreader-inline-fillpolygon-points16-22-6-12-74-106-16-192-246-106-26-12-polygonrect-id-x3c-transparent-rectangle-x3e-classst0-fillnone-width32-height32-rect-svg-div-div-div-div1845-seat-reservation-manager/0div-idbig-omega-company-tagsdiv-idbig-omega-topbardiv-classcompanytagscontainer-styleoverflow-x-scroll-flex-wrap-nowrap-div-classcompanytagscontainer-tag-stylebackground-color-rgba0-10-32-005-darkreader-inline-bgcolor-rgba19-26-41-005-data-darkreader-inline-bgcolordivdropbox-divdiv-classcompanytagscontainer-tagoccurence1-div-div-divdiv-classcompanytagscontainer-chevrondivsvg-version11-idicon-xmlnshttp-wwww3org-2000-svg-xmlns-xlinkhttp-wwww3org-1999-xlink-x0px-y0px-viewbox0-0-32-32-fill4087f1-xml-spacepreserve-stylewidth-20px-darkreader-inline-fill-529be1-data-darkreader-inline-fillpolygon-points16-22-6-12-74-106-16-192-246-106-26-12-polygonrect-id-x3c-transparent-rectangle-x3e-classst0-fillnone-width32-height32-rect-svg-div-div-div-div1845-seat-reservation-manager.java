class SeatManager {
    
    private PriorityQueue<Integer> minHeap;

    public SeatManager(int n) {
        this.minHeap = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            this.minHeap.add(i);
        }
    }
    
    public int reserve() {
        int seatNumber = this.minHeap.poll();
        return seatNumber;
    }
    
    public void unreserve(int seatNumber) {
        this.minHeap.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */