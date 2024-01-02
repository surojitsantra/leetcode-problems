class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        final int N = nums.length;
        int freq[] = new int[N +1];
        
        List<List<Integer>> matrix = new ArrayList<>();
        
        for(int num :nums) {
            if(freq[num] >= matrix.size()) matrix.add(new ArrayList<>());
            matrix.get(freq[num]).add(num);
            freq[num]++;
        }
        
        return matrix;
    }
}