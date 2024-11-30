class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int N = nums2.length;
        int[] nextGreaterEleIdx = new int[N];
        
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> numsIdx = new HashMap<>();
        for(int i = N -1; i >= 0; i--) {
            numsIdx.put(nums2[i], i);
            
            while(!st.isEmpty() && nums2[i] >= nums2[st.peek()]) st.pop();
            if(st.empty()) {
                nextGreaterEleIdx[i] = -1;
            } else {
                nextGreaterEleIdx[i] = st.peek();
            }
            st.push(i);
        }
        
        
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            int idx = numsIdx.get(nums1[i]);
            result[i] = (nextGreaterEleIdx[idx] == -1)? -1 : nums2[nextGreaterEleIdx[idx]];
        }
        
        return result;
    }
}