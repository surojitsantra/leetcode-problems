class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> route = new HashMap<>();
        
        for(List<String> path :paths) {
            String src = path.get(0);
            String des = path.get(1);
            route.put(src, des);
        }
        
        String des = paths.get(0).get(0);
        
        while(route.containsKey(des)) {
            des = route.get(des);
        }
        
        return des;
    }
}