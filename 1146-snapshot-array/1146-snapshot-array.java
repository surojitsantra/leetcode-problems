class SnapshotArray {
    
    private List<TreeMap<Integer, Integer>> numbers;
    
    private int snap;

    public SnapshotArray(int length) {
        snap = 0;
        numbers = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            mp.put(0, 0);
            numbers.add(mp);
        }
    }
    
    public void set(int index, int val) {
        Map<Integer, Integer> allNos = numbers.get(index);
        allNos.put(snap, val);
    }
    
    public int snap() {
        return snap++;
        
    }
    
    public int get(int index, int snap_id) {
        return numbers.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */