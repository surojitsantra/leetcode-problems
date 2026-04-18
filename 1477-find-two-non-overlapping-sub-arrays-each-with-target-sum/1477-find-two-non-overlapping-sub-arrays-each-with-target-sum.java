class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        final int N = arr.length;

        int[] bestPos = new int[N];
        Arrays.fill(bestPos, Integer.MAX_VALUE);

        int start = 0;
        int currSum = 0;
        for(int end = 0; end < N; end++) {
            currSum += arr[end];
            while(start <= end && currSum > target) {
                currSum -= arr[start++];
            }
            int prev = (end -1 < 0)? Integer.MAX_VALUE : bestPos[end -1];
            int curr = end -start +1;

            if(currSum == target) {
                bestPos[end] = Math.min(prev, curr);
            } else {
                bestPos[end] = prev;
            }

        }

        int minSize = Integer.MAX_VALUE;

        int end = N -1;
        currSum = 0;
        for(start = N -1; start >= 0; start--) {
            currSum += arr[start];
            while(end >= start && currSum > target) {
                currSum -= arr[end--];
            }

            if(currSum == target) {
                int prv = (start -1 < 0)? Integer.MAX_VALUE : bestPos[start -1];
                if(prv != Integer.MAX_VALUE) {
                    minSize = Math.min(minSize, prv + (end -start +1));
                }
            }

        }

        if(minSize == Integer.MAX_VALUE) return -1;
        return minSize;

    }
}