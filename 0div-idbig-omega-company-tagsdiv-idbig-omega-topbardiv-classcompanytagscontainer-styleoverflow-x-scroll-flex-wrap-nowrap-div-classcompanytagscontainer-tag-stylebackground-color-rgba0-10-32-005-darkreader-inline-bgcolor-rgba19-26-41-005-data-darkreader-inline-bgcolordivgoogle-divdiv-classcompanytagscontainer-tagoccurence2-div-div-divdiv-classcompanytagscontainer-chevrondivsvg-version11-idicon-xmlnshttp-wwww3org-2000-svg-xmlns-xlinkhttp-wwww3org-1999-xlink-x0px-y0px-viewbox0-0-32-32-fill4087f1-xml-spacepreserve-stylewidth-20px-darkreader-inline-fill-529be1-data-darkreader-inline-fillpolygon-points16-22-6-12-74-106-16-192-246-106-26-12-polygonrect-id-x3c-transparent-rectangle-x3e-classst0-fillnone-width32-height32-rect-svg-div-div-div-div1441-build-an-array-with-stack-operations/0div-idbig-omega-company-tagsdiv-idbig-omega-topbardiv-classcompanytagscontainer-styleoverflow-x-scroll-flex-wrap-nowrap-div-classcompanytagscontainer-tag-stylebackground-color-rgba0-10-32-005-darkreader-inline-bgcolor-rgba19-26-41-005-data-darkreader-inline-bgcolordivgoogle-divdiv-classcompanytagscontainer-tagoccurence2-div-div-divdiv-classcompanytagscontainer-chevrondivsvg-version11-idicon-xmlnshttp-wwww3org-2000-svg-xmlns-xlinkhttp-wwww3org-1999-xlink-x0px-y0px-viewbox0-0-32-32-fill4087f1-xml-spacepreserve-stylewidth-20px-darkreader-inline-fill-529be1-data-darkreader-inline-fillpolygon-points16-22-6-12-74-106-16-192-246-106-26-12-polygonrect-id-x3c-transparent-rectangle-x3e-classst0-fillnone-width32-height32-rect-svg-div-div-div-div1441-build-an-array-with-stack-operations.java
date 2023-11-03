class Solution {
    public List<String> buildArray(int[] target, int n) {
        final int N = target.length;
        List<String> ops = new ArrayList<>();
        
        int point = 1;
        int i = 0;
        
        while(i < N) {
            if(target[i] == point) {
                ops.add("Push");
                point++;
                i++;
            } else {
                ops.add("Push");
                ops.add("Pop");
                point++;
            }
        }
        
        
        return ops;
    }
}