class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        final int N = chalk.length;
        
        long chalkReq = 0;
        for(int c :chalk) chalkReq += c;
        
        long rem = k %chalkReq;
        
        for(int i = 0; i < N; i++) {
            if(rem -chalk[i] < 0) {
                return i;
            }
            rem -= chalk[i];
        }
        
        return N -1;
    }
}