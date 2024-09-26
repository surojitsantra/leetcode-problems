class MyCalendar {
    
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        this.calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = this.calendar.floorKey(start);
        Integer prevEnd = 0;
        if(prevStart != null) {
            prevEnd = this.calendar.get(prevStart);
        }
        
        if(prevEnd > start) {
            return false;
        }
        
        Integer nextStart = this.calendar.ceilingKey(start);
        if(nextStart != null && end > nextStart) {
            return false;
        }
        
        this.calendar.put(start, end);
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */