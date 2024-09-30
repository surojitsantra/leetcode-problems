class CustomStack {
    
    private int[][] stack;
    private int top = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize][2];
    }
    
    public void push(int x) {
        if(!isFull()) {
            stack[++top] = new int[]{x, 0};
        }
    }
    
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int pair[] = stack[top--];
        int val = pair[0];
        int count = pair[1];
        
        if(!isEmpty()) {
            stack[top][1] += count;
        }
        
        return val +count;
    }
    
    public void increment(int k, int val) {
        if(isEmpty()) {
            return;
        }
        if(k -1 > top) {
            stack[top][1] += val;
        } else {
            stack[k -1][1] += val;
        }
    }
    
    public boolean isFull() {
        return top == stack.length -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */