class Spell {
    public int val, idx;
    public Spell(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        final int N = spells.length;
        final int M = potions.length;
        
        List<Spell> spellsWithIdx = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            spellsWithIdx.add(new Spell(spells[i], i));
        }
        
        Collections.sort(spellsWithIdx, (a, b) -> b.val -a.val);
        Arrays.sort(potions);
        
        int[] ans = new int[N];
        
        int j = 0;
        for(int i = 0; i < N; i++) {
            while(j < M && (long)potions[j] *spellsWithIdx.get(i).val < success) j++;
            ans[spellsWithIdx.get(i).idx] = M -j;
        }
        
        return ans;
    }
}