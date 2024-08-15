class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBuckCount = 0, tenBuckCount = 0;
        
        for(int bill :bills) {
            if(bill == 5) {
                fiveBuckCount++;
            } else if(bill == 10) {
                if(fiveBuckCount < 1) return false;
                fiveBuckCount--;
                tenBuckCount++;
            } else {
                if(tenBuckCount > 0 && fiveBuckCount > 0) {
                    fiveBuckCount--;
                    tenBuckCount--;
                } else if(fiveBuckCount >= 3) {
                    fiveBuckCount -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}