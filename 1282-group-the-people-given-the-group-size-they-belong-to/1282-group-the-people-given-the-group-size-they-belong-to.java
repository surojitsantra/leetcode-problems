class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        
        List<List<Integer>> groups = new ArrayList<>();
        
        for(int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            groupMap.putIfAbsent(groupSize, new ArrayList<>());
            groupMap.get(groupSize).add(i);
            
            if(groupMap.get(groupSize).size() == groupSize) {
                groups.add(groupMap.get(groupSize));
                groupMap.remove(groupSize);
            }
        }
        
        return groups;
    }
}