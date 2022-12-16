class MyQueue {
    
    stack<int> helperStack1, helperStack2;
    
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        helperStack1.push(x);
    }
    
    int pop() {
        if(helperStack2.empty()) reArrangeToStack2();
        int x = helperStack2.top();
        helperStack2.pop();
        return x;
    }
    
    int peek() {
        if(helperStack2.empty()) reArrangeToStack2();
        return helperStack2.top();
    }
    
    bool empty() {
        return (helperStack1.empty() && helperStack2.empty());
    }
    
private:
    void reArrangeToStack2() {
        while(!helperStack1.empty()) {
            helperStack2.push(helperStack1.top());
            helperStack1.pop();
        }
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */