class SmallestInfiniteSet {

    private int counter;
    private Queue<Integer> helperQueue;
    private HashSet<Integer> isPresent;
    
    public SmallestInfiniteSet() {
        this.counter = 1;
        this.helperQueue = new PriorityQueue<>();
        this.isPresent = new HashSet<>();
    }
    
    public int popSmallest() {
        if(this.helperQueue.isEmpty()) return this.counter++;
        int num = this.helperQueue.poll();
        this.isPresent.remove(num);
        return num;
    }
    
    public void addBack(int num) {
        if(num >= this.counter || this.isPresent.contains(num)) return;
        this.helperQueue.add(num);
        this.isPresent.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */