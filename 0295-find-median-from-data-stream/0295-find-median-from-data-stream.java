class MedianFinder {
    
    private PriorityQueue<Integer> bigNumbers, smallNumbers;

    public MedianFinder() {
        bigNumbers = new PriorityQueue<>();
        smallNumbers = new PriorityQueue<>((a, b) -> b -a);
    }
    
    public void addNum(int num) {
        smallNumbers.add(num);
        if(smallNumbers.size() -bigNumbers.size() > 1) {
            bigNumbers.add(smallNumbers.poll());
        }
        if(!bigNumbers.isEmpty() && smallNumbers.peek() > bigNumbers.peek()) {
            bigNumbers.add(smallNumbers.poll());
            smallNumbers.add(bigNumbers.poll());
        }
    }
    
    public double findMedian() {
        int size = smallNumbers.size() +bigNumbers.size();
        
        if((size &1) == 0) {
            return ((smallNumbers.peek() +bigNumbers.peek()) /2.0);
        } else {
            return smallNumbers.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */