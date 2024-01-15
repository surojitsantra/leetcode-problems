class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossFreq = new HashMap<>();
        
        for(int[] match :matches) {
            int win = match[0], loss = match[1];
            
            lossFreq.putIfAbsent(win, 0);
            lossFreq.putIfAbsent(loss, 0);
            lossFreq.put(loss, lossFreq.get(loss) +1);
            
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        
        for(Map.Entry<Integer, Integer> entry :lossFreq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == 0) {
                ans.get(0).add(key);
            } else if(val == 1) {
                ans.get(1).add(key);
            }
            
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        
        return ans;
    }
}