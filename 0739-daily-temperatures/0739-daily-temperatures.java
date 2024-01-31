class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int N = temperatures.length;
        Stack<Integer> helperStack = new Stack<>();
        int[] ans = new int[N];
        
        for(int i = N -1; i >= 0; i--) {
            int curTemp = temperatures[i];
            while(!helperStack.isEmpty() && curTemp >= temperatures[helperStack.peek()]) {
                helperStack.pop();
            }
            
            ans[i] = (helperStack.isEmpty())? 0 : helperStack.peek() -i;
            
            helperStack.push(i);
        }
        
        return ans;
    }
}