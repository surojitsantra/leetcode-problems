class Solution {
    public int maxLength(List<String> arr) {
        final int N = arr.size();
        boolean[] charFlag = new boolean[26];
        Arrays.fill(charFlag, false);
        
        return maxLenString(arr, 0, charFlag, N);
        
    }
    
    private int maxLenString(List<String> arr, int i, boolean[] charFlag, final int N) {
        if(i >= N) return 0;
        
        String str = arr.get(i);
        
        int notInclude = maxLenString(arr, i +1, charFlag, N);
        int include = 0;
        if(canInclude(str, charFlag)) {
            addString(str, charFlag);
            include = str.length() +maxLenString(arr, i +1, charFlag, N);
            removeString(str, charFlag);
        }
        
        return Math.max(include, notInclude);
    }
    
    private boolean canInclude(String str, boolean[] charFlag) {
        boolean[] tempCharFlag = new boolean[26];
        
        for(char ch :str.toCharArray()) {
            int idx = ch -'a';
            if(charFlag[idx] || tempCharFlag[idx]) return false;
            tempCharFlag[idx] = true;
        }
        return true;
    }
    
    private void addString(String str, boolean[] charFlag) {
        for(char ch :str.toCharArray()) {
            int idx = ch -'a';
            charFlag[idx] = true;
        }
    }
    
    private void removeString(String str, boolean[] charFlag) {
        for(char ch :str.toCharArray()) {
            int idx = ch -'a';
            charFlag[idx] = false;
        }
    }
    
}