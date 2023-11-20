class Solution {
    public int garbageCollection(String[] garbages, int[] travel) {
        final int N = garbages.length;
        
        int metalCost = 0;
        int paperCost = 0;
        int glassCost = 0;
        
        for(int i = N -1; i >= 0; i--) {
            String garbage = garbages[i];
            int metal = 0;
            int paper = 0;
            int glass = 0;
            
            for(char ch :garbage.toCharArray()) {
                metal += (ch == 'M')? 1 : 0;
                paper += (ch == 'P')? 1 : 0;
                glass += (ch == 'G')? 1 : 0;
            }
            
            metalCost += metal;
            paperCost += paper;
            glassCost += glass;
            
            if(i - 1 >= 0 && metalCost > 0) metalCost += travel[i -1];
            if(i - 1 >= 0 && paperCost > 0) paperCost += travel[i -1];
            if(i - 1 >= 0 && glassCost > 0) glassCost += travel[i -1];
            
        }
        
        return metalCost +paperCost + glassCost;
        
    }
}