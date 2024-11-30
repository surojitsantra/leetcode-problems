class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int N = nums.length;
        int[] nextGreaterEle = new int[N];
        
        Stack<Integer> st = new Stack<>();
        for(int i = N -1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            st.push(nums[i]);
        }
        
        for(int i = N -1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            
            nextGreaterEle[i] = (st.isEmpty())? -1 : st.peek();
            
            st.push(nums[i]);
        }
        
        return nextGreaterEle;
    }
}