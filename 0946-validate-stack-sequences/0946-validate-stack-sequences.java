class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        final int N = pushed.length;

        int i = 0;
        int j = 0;
        while(i < N && j < N) {
            if(!st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            } else {
                while(i < N && pushed[i] != popped[j]) {
                    st.push(pushed[i]);
                    i++;
                }
                if(i >= N && j < N) return false;
                i++;
                j++;
            }
        }

        while(j < N) {
            if(st.pop() != popped[j]) return false;
            j++;
        }

        return true;

    }
}