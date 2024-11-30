class Stock {
    public int price;
    public int day;
    public Stock(int price, int day) {
        this.price = price;
        this.day = day;
    }
}

class StockSpanner {
    
    private Stack<Stock> helperStack;
    private int day;

    public StockSpanner() {
        helperStack = new Stack<>();
        day = 0;
    }
    
    public int next(int price) {
        ++day;
        while(!helperStack.isEmpty() && price >= helperStack.peek().price) {
            helperStack.pop();
        }
        int span = day;
        if(!helperStack.isEmpty()) {
            span -= helperStack.peek().day;
        }
        helperStack.push(new Stock(price, day));
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */