class Solution {
    public int numberOfBeams(String[] bank) {
        int totalLaserBeams = 0;
        int prevDevice = 0;
        
        for(String row :bank) {
            int currDevice = 0;
            for(char bit :row.toCharArray()) {
                currDevice += (bit -'0');
            }
            if(currDevice == 0) continue;
            totalLaserBeams += (prevDevice *currDevice);
            
            prevDevice = currDevice;
        }
        
        return totalLaserBeams;
    }
}