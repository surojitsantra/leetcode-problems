class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) return b[1] -a[1];
            return a[0] -b[0];
        });

        final int N = envelopes.length;
        int[] lis = new int[N];

        int ans = 1;

        int size = 0;
        for(int[] env :envelopes) {
            int h = env[1];
            int left = 0, right = size;
            int idx = -1;

            while(left <= right) {
                int mid = (left +right) /2;
                if(lis[mid] >= h) {
                    idx = mid;
                    right = mid -1;
                } else {
                    left = mid +1;
                }
            }

            if(idx == -1) {
                lis[size] = h;
                size++;
            } else {
                lis[idx] = h;
            }

        }

        return size;

    }
}