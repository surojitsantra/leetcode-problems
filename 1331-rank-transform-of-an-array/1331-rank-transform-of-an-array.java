class Solution {
    public int[] arrayRankTransform(int[] arr) {
        final int N = arr.length;
        Map<Integer, List<Integer>> numbersIdx = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            int num = arr[i];
            numbersIdx.putIfAbsent(num, new ArrayList<>());
            numbersIdx.get(num).add(i);
        }
        
        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);
        
        int[] rankArr = new int[N];
        int rank = 1;
        for(int num :sortedArr) {
            if(numbersIdx.containsKey(num)) {
                for(int idx :numbersIdx.get(num)) {
                    rankArr[idx] = rank;
                }
                numbersIdx.remove(num);
                rank++;
            }
        }
        
        return rankArr;
        
    }
}