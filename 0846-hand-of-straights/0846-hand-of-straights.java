class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int N = hand.length;
        if(N %groupSize != 0) return false;

        TreeMap<Integer, Integer> numsFreq = new TreeMap<>();

        for (int x :hand) {
            numsFreq.put(x, numsFreq.getOrDefault(x, 0) +1);
        }

        while(!numsFreq.isEmpty()) {
            int key = numsFreq.firstKey();
            for(int i = 0; i < groupSize; i++) {
                int next = key +i;
                if(!numsFreq.containsKey(next)) return false;
                numsFreq.put(next, numsFreq.get(next) -1);
                if(numsFreq.get(next) == 0) numsFreq.remove(next);
            }
        }

        return true;

    }
}