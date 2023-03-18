class Node {
    public String url;
    public Node prev, next;
    public Node(String url) {
        this.url = url;
        this.prev = this.next = null;
    }
}

class BrowserHistory {
    
    private Node head = null;
    private int curPos;
    private Node curPoint = null;
    
    public BrowserHistory(String homepage) {
        this.head = this.curPoint = new Node(homepage);
        this.curPos = 1;
    }
    
    public void visit(String url) {
        this.curPoint.next = new Node(url);
        this.curPoint.next.prev = this.curPoint;
        this.curPoint = this.curPoint.next;
        this.curPos++;
    }
    
    public String back(int steps) {
        if(steps >= this.curPos -1) {
            this.curPoint = head;
            this.curPos = 1;
            return this.curPoint.url;
        }
        
        for(int i = 1; i <= steps; i++) {
            this.curPoint = this.curPoint.prev;
            curPos--;
        }
        return this.curPoint.url; 
    }
    
    public String forward(int steps) {
        int i = 1;
        while(i <= steps && this.curPoint.next != null) {
            this.curPoint = this.curPoint.next;
            curPos++;
            i++;
        }
        return this.curPoint.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */