class Solution {
    public int minOperations(String[] logs) {
        int steps = 0;
        
        for(String ops :logs) {
            if(ops.equals("../")) {
                if(steps > 0) steps--;
            } else if(ops.equals("./")) {
                continue;
            } else {
                steps++;
            }
        }
        
        return steps;
    }
}