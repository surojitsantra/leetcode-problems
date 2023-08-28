class MyStack {
    
    private Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        this.queue.add(x);
        
        for(int i = 1; i < this.queue.size(); i++) {
            this.queue.add(this.queue.remove());
        }
        
    }
    
    public int pop() {
        return this.queue.remove();
    }
    
    public int top() {
        return this.queue.peek();
    }
    
    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */