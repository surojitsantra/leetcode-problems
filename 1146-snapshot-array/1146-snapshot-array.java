class SnapshotArray {
    private int curSnap;

    private TreeMap<Integer, Integer>[] reference;

    public SnapshotArray(int length) {
        curSnap = 0;
        reference = new TreeMap[length];
        for(int i = 0; i < length; i++) {
            reference[i] = new TreeMap<>();
            reference[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> currPoint = reference[index];
        currPoint.put(curSnap, val);
    }
    
    public int snap() {
        return curSnap++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> currPoint = reference[index];
        return currPoint.floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */