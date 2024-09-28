class Node {
    public int val;
    public Node prev, next;
    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class MyCircularDeque {
    
    private Node front, rear;
    private int size, capacity;

    public MyCircularDeque(int k) {
        front = rear = null;
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        
        if(front == null) {
            front = rear = new Node(value, null, null);
        } else {
            front = new Node(value, null, front);
            front.next.prev = front;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        
        if(rear == null) {
            front = rear = new Node(value, null, null);
        } else {
            rear.next = new Node(value, rear, null);
            rear = rear.next;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        
        if(size == 1) {
            front = rear = null;
        } else {
            front = front.next;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        
        if(size == 1) {
            front = rear = null;
        } else {
            rear = rear.prev;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        
        return front.val;
    }
    
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        
        return rear.val;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */