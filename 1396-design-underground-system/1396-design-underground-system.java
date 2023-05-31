class MoveinInfo {
    public int id, t;
    public String stationName;
    
    public MoveinInfo(int id, String stationName, int t) {
        this.id = id;
        this.stationName = stationName;
        this.t = t;
    }
}

class StationDisInfo {
    public String start, end;
    public int totalDis, passengerVisited;
    
    public StationDisInfo(String start, String end) {
        this.start = start;
        this.end = end;
        totalDis = passengerVisited = 0;
    }
}

class UndergroundSystem {
    
    Map<Integer, MoveinInfo> checkinMap;
    Map<String, StationDisInfo> stationDisMap;

    public UndergroundSystem() {
        checkinMap = new HashMap<>();
        stationDisMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new MoveinInfo(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        MoveinInfo info = checkinMap.get(id);
        
        String start = info.stationName;
        String end = stationName;
        int timeTook = t -info.t;
        
        storeInMap(start, end, timeTook);
    }
    
    private void storeInMap(String start, String end, int t) {
        if(start.compareTo(end) == 0) return;
        
        String key = start + "-To-" + end;
        
        stationDisMap.putIfAbsent(key, new StationDisInfo(start, end));
        
        StationDisInfo stationDisInfo = stationDisMap.get(key);
        
        stationDisInfo.totalDis += t;
        stationDisInfo.passengerVisited++;
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        if(startStation.compareTo(endStation) == 0) return 0;
        
        String key = startStation + "-To-" + endStation;
        StationDisInfo stationDisInfo = stationDisMap.getOrDefault(key, null);
        if(stationDisInfo == null) return 0;
        
        return (double)stationDisInfo.totalDis /stationDisInfo.passengerVisited;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */