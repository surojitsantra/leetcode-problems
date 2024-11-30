class MinStack {
    
    private Stack<Integer> st, minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || minSt.peek() >= val) {
            minSt.push(val);
        }
    }
    
    public void pop() {
        int pop = st.pop();
        if(!minSt.isEmpty() && minSt.peek() == pop) {
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */