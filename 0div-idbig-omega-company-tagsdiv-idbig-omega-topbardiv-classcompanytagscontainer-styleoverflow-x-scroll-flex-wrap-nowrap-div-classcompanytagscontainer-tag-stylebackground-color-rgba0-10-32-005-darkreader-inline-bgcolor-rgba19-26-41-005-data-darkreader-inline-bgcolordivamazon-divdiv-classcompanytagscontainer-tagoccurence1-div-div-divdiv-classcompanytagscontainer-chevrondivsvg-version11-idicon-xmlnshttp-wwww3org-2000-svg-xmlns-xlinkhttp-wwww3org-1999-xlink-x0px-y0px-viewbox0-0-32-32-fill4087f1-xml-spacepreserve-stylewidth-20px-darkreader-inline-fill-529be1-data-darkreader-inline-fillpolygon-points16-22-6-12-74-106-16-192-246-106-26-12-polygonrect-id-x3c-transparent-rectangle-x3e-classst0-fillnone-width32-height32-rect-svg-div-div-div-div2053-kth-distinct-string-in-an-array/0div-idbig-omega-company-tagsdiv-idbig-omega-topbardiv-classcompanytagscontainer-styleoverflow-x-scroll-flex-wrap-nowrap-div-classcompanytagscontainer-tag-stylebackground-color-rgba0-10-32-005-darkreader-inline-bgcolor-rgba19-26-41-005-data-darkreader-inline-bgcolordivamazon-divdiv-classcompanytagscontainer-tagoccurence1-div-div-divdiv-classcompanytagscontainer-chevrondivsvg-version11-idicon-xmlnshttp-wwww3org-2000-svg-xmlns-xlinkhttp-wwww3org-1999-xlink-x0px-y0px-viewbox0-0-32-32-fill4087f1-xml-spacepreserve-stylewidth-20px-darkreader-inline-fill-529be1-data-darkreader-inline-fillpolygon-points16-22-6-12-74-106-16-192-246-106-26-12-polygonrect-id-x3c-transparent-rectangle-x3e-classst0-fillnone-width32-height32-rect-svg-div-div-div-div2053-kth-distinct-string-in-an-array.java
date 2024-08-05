class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> stringCount = new HashMap<>();
        
        for(String s :arr) {
            stringCount.put(s, stringCount.getOrDefault(s, 0) +1);
        }
        
        int distinctCount = 0;
        for(String s :arr) {
            if(stringCount.get(s) == 1) distinctCount++;
            if(distinctCount == k) return s;
        }
        
        return "";
    }
}