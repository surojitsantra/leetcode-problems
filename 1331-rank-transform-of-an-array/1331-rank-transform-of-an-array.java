class Solution {
    public int[] arrayRankTransform(int[] arr) {
        final int N = arr.length;
        
        Map<Integer, Integer> numToRank = new HashMap<>();
        int[] rankResult = Arrays.copyOf(arr, N);
        Arrays.sort(rankResult);
        
        for(int num :rankResult) {
            numToRank.putIfAbsent(num, numToRank.size() +1);
        }
        
        for(int i = 0; i < N; i++) {
            rankResult[i] = numToRank.get(arr[i]);
        }
        
        return rankResult;
    }
}