class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String queryDividend = query.get(0);
            String queryDivisor = query.get(1);
            
            Set<String> visited = new HashSet<>();
            
            results[i] = -1.0;
            if(graph.containsKey(queryDividend) && graph.containsKey(queryDivisor)) 
                results[i] = dfs(queryDivisor, queryDividend, 1.0, graph, visited);
        }
        
        return results;
    }
    
    private double dfs(String queryDivisor, String curDivisor, double value, Map<String, Map<String, Double>> graph, Set<String> visited) {
        
        if(curDivisor.equals(queryDivisor)) return value;
        visited.add(curDivisor);
        
        for (Map.Entry<String, Double> neighbor : graph.get(curDivisor).entrySet()) {
            String neighborNode = neighbor.getKey();
            double neighborValue = neighbor.getValue();
            
            if(visited.contains(neighborNode)) continue;
            
            double tempValue = dfs(queryDivisor, neighborNode, value *neighborValue, graph, visited);
            if(tempValue != -1) {
                // System.out.println("LOL"+);
                return tempValue;
            }
        }
        
        return -1;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double value = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }
        
        return graph;
    }
}