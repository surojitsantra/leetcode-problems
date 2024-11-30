class Solution {
    public long subArrayRanges(int[] nums) {
        final int N = nums.length;
        
        int[] pse = previousSmallElementIdx(nums);
        int[] nse = nextSmallElementIdx(nums);
        int[] pbe = previousBigElementIdx(nums);
        int[] nbe = nextBigElementIdx(nums);
        
        long sum = 0;
        
        for(int i = 0; i < N; i++) {
            long sub = ((long)(i -pse[i]) *(nse[i] -i));
            long add = ((long)(i -pbe[i]) *(nbe[i] -i));
            
            sum += (add *nums[i]) -(sub *nums[i]);
            
        }
        
        return sum;
    }
    
    private int[] previousSmallElementIdx(int[] nums) {
        final int N = nums.length;
        int[] pse = new int[N];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!st.isEmpty() && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            pse[i] = (st.isEmpty())? -1 : st.peek();
            st.push(i);
        }
        
        return pse;
    }
    
    private int[] nextSmallElementIdx(int[] nums) {
        final int N = nums.length;
        int[] nse = new int[N];
        
        Stack<Integer> st = new Stack<>();
        for(int i = N -1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            nse[i] = (st.isEmpty())? N : st.peek();
            st.push(i);
        }
        
        return nse;
    }
    
    private int[] previousBigElementIdx(int[] nums) {
        final int N = nums.length;
        int[] pbe = new int[N];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!st.isEmpty() && nums[i] > nums[st.peek()]) {
                st.pop();
            }
            pbe[i] = (st.isEmpty())? -1 : st.peek();
            st.push(i);
        }
        
        return pbe;
    }
    
    private int[] nextBigElementIdx(int[] nums) {
        final int N = nums.length;
        int[] nbe = new int[N];
        
        Stack<Integer> st = new Stack<>();
        for(int i = N -1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            nbe[i] = (st.isEmpty())? N : st.peek();
            st.push(i);
        }
        
        return nbe;
    }
    
}