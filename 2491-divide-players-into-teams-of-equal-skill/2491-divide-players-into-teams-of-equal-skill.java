class Solution {
    public long dividePlayers(int[] skill) {
        final int N = skill.length;
        Arrays.sort(skill);
        
        int targetedSkill = skill[0] +skill[N -1];
        
        long ans = 0;
        for(int i = 0; i < N /2; i++) {
            if(skill[i] +skill[N -i -1] != targetedSkill) {
                return -1;
            }
            
            ans += ((long)skill[i] *skill[N -i -1]);
        }
        
        return ans;
    }
}