class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        int xdiff = Math.abs(sx - fx);
        int ydiff = Math.abs(sy - fy);
        if(xdiff == 0 && ydiff == 0 && t == 1) return false;
        
        int minTimeReq = Math.max(xdiff, ydiff);
        return t >= minTimeReq;
    }
}