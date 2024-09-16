class Solution {
    public int findMinDifference(List<String> timePoints) {
        //convert everything in minute
        //do bucket sort
        
        boolean[] minutes = new boolean[24 *60];
        for(String time :timePoints) {
            int HH = Integer.parseInt(time.substring(0, 2));
            int MM = Integer.parseInt(time.substring(3));
            
            int minute = (HH *60) +MM;
            
            if (minutes[minute]) return 0;
            
            minutes[minute] = true;
        }
        
        int prevIndex = Integer.MAX_VALUE;
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < minutes.length; i++) {
            if(!minutes[i]) {
                continue;
            }
            if (prevIndex != Integer.MAX_VALUE) {
                ans = Math.min(ans, i - prevIndex);
            }
            prevIndex = i;
            if (firstIndex == Integer.MAX_VALUE) {
                firstIndex = i;
            }
            lastIndex = i;
        }
        
        return Math.min(ans, 24 * 60 - lastIndex + firstIndex);
    }
}