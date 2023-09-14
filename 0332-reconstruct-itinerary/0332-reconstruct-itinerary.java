class Solution {
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs("JFK", flights, path);
        
        return path;
    }
    
    private void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> path) {
        PriorityQueue<String> arrivals = flights.get(departure);
        
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, path);
        }
        
        path.addFirst(departure);
    }
    
}